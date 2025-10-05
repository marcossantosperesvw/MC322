package com.rpglab.game.cenario;
import java.util.*;
import com.rpglab.game.combate.*;
import com.rpglab.game.itens.*;
import com.rpglab.game.personagens.monstros.*;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        
        Arma cetroGelido = new Machadinho("Cetro Gélido", 0, 0);
        Arma varinhaSombras = new Machadinho("Varinha das Sombras", 0, 0);
        Arma garrasFogo = new Machadinho("Garras de Fogo", 0, 0);
        Arma machadinhaKoopa = new Machadinho("Machadinha Koopa", 0, 0);
        
        Arma[][] lootsPorQualidade = criarLootsPorQualidade();
        
        // Fase 1 - Corredor Assombrado
        fases.add(new FaseDeCombate(
            TipoCenario.CORREDOR_ASSOMBRADO,
            new Koopalings("Koopaling Ordenado", 90, 20, 150, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]),
            new Koopalings("Koopaling Ponteiro", 90, 20, 150, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]),
            new King_Boo("King Boo", 120, 30, 300, cetroGelido, lootsPorQualidade[dificuldade.getQualidadeLoot()])
        ));
        
        // Fase 2 - Câmara das Ilusões
        fases.add(new FaseDeCombate(
            TipoCenario.CAMARA_ILUSOES,
            new Koopalings("Koopaling Logarítmico", 110, 25, 180, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]),
            new Koopalings("Koopaling Quadrático", 110, 25, 180, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]),
            new Kamek("Kamek", 300, 50, 420, varinhaSombras, lootsPorQualidade[dificuldade.getQualidadeLoot()])
        ));
        
        // Fase 3 - Castelo do Bowser
        fases.add(new FaseDeCombate(
            TipoCenario.CASTELO_BOWSER,
            new Koopalings("Koopaling Exponencial", 130, 30, 220, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]),
            new Koopalings("Koopaling Linear", 130, 30, 220, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]),
            new Bowser("Bowser", 450, 55, 1500, garrasFogo, lootsPorQualidade[dificuldade.getQualidadeLoot()])
        ));
        
        // Aplicar multiplicadores de dificuldade
        aplicarDificuldade(fases, dificuldade);
        return fases;
    }
    
    private Arma[][] criarLootsPorQualidade() {
        // [0] = Básico, [1] = Médio, [2] = Épico
        return new Arma[][]{
            // Loot básico (FÁCIL)
            {
                new Martelo("Martelo de Ferro", 15, 1),
                new Varinha("Cajado Simples", 12, 1),
                new Garras("Garras Afiadas", 14, 1)
            },
            // Loot médio (NORMAL)
            {
                new Martelo("Esmagador de Crânios", 25, 3),
                new Varinha("Cajado da Noite Eterna", 22, 3),
                new Garras("Dilacerador de Almas", 24, 3)
            },
            // Loot épico (DIFÍCIL)
            {
                new Martelo("Aniquilador Divino", 40, 5),
                new Varinha("Cetro do Apocalipse", 45, 5),
                new Garras("Exterminador de Universos", 42, 5)
            }
        };
    }
    
    private void aplicarDificuldade(List<Fase> fases, Dificuldade dificuldade) {
        for (Fase fase : fases) {
            for (Monstro monstro : fase.getMonstros()) {
                int novaVida = dificuldade.aplicarMultiplicador(monstro.getPontosDeVida());
                int novaForca = dificuldade.aplicarMultiplicador(monstro.getForca());
                monstro.setPontosDeVida(novaVida);
                monstro.setForca(novaForca);
            }
        }
    }
}
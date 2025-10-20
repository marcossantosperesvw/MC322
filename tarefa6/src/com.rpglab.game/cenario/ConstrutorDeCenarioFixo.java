package com.rpglab.game.cenario;

import java.util.*;
import com.rpglab.game.combate.*;
import com.rpglab.game.itens.*;
import com.rpglab.game.personagens.monstros.*;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    
    // Ações de combate compartilhadas (AGREGAÇÃO)
    private static final AtaqueFisico ATAQUE_FISICO_COMPARTILHADO = new AtaqueFisico();
    
    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        
        // Armas dos monstros (podem ser compartilhadas)
        Arma cetroGelido = new Machadinho("Cetro Gélido", 10, 0);
        Arma varinhaSombras = new Machadinho("Varinha das Sombras", 15, 0);
        Arma garrasFogo = new Machadinho("Garras de Fogo", 20, 0);
        Arma machadinhaKoopa = new Machadinho("Machadinha Koopa", 8, 0);
        
        // Criar arrays de loot por qualidade (AGREGAÇÃO - não são instâncias, são classes)
        Arma[][] lootsPorQualidade = criarLootsPorQualidade();
        
        // Fase 1 - Corredor Assombrado
        Koopalings koop1_1 = new Koopalings("Koopaling Ordenado", 90, 20, 150, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        Koopalings koop1_2 = new Koopalings("Koopaling Ponteiro", 90, 20, 150, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        King_Boo kingBoo = new King_Boo("King Boo", 120, 30, 300, cetroGelido, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        
        // Configurar ações compartilhadas
        koop1_1.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        koop1_2.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        kingBoo.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        
        fases.add(new FaseDeCombate(
            TipoCenario.CORREDOR_ASSOMBRADO,
            koop1_1, koop1_2, kingBoo
        ));
        
        // Fase 2 - Câmara das Ilusões
        Koopalings koop2_1 = new Koopalings("Koopaling Logarítmico", 110, 25, 180, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        Koopalings koop2_2 = new Koopalings("Koopaling Quadrático", 110, 25, 180, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        Kamek kamek = new Kamek("Kamek", 300, 50, 420, varinhaSombras, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        
        // Configurar ações compartilhadas
        koop2_1.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        koop2_2.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        kamek.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        
        fases.add(new FaseDeCombate(
            TipoCenario.CAMARA_ILUSOES,
            koop2_1, koop2_2, kamek
        ));
        
        // Fase 3 - Castelo do Bowser
        Koopalings koop3_1 = new Koopalings("Koopaling Exponencial", 130, 30, 220, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        Koopalings koop3_2 = new Koopalings("Koopaling Linear", 130, 30, 220, machadinhaKoopa, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        Bowser bowser = new Bowser("Bowser", 450, 55, 1500, garrasFogo, lootsPorQualidade[dificuldade.getQualidadeLoot()]);
        
        // Configurar ações compartilhadas
        koop3_1.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        koop3_2.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        bowser.setAcaoAtaque(ATAQUE_FISICO_COMPARTILHADO);
        
        fases.add(new FaseDeCombate(
            TipoCenario.CASTELO_BOWSER,
            koop3_1, koop3_2, bowser
        ));
        
        // Aplicar multiplicadores de dificuldade
        aplicarDificuldade(fases, dificuldade);
        
        return fases;
    }
    
    private ArmaTemplate[][] criarLootsPorQualidade() {
        // [0] = Básico, [1] = Médio, [2] = Épico
        return new ArmaTemplate[][]{
            // Loot básico (FÁCIL)
            { // Básico
                new ArmaTemplate("com.rpglab.game.itens.Martelo", "Martelo de Ferro", 10, 1),
                new ArmaTemplate("com.rpglab.game.itens.Varinha", "Cajado Simples", 10, 1),
                new ArmaTemplate("com.rpglab.game.itens.Garras", "Garras Afiadas", 12, 1)
            },
            { // Médio
                new ArmaTemplate("com.rpglab.game.itens.Martelo", "Esmagador de Crânios", 25, 3),
                new ArmaTemplate("com.rpglab.game.itens.Varinha", "Cajado da Noite Eterna", 22, 3),
                new ArmaTemplate("com.rpglab.game.itens.Garras", "Dilacerador de Almas", 24, 3)
            },
            { // Épico
                new ArmaTemplate("com.rpglab.game.itens.Martelo", "Aniquilador Divino", 40, 5),
                new ArmaTemplate("com.rpglab.game.itens.Varinha", "Cetro do Apocalipse", 45, 5),
                new ArmaTemplate("com.rpglab.game.itens.Garras", "Exterminador de Universos", 42, 5)
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
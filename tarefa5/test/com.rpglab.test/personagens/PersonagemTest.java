package com.rpglab.test.personagens;

import com.rpglab.combate.Combatente;
import com.rpglab.exceptions.NivelInsuficiente;
import com.rpglab.itens.*;
import com.rpglab.personagens.herois.*;
import com.rpglab.personagens.monstros.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    private Heroi heroi;
    private Monstro monstro;
    private Arma armaHeroi;
    private Arma armaMonstro;

    @BeforeEach
    void setUp() {
        armaHeroi = new Martelo("Martelo Básico", 10, 0);
        armaMonstro = new Machadinho("Machadinha Koopa", 5, 0);
        heroi = new Mario("Mario", 100, 20, armaHeroi);
        monstro = new Koopalings("Koopa", 80, 15, 50, armaMonstro, new Arma[]{new Garras("Garras", 12, 1)});
    }

    @Test
    void testPersonagensImplementamCombatente() {
        assertTrue(heroi instanceof Combatente, "Herói deve implementar Combatente");
        assertTrue(monstro instanceof Combatente, "Monstro deve implementar Combatente");
    }

    @Test
    void testMonstroImplementaLootavel() {
        assertTrue(monstro instanceof Lootavel, "Monstro deve ser Lootavel");
    }

    @Test
    void testHeroiRecebeDanoCorretamente() {
        int vidaInicial = heroi.getPontosDeVida();
        int dano = 20;
        heroi.receberDano(dano);
        assertEquals(vidaInicial - dano, heroi.getPontosDeVida(), "A vida do herói deve diminuir corretamente.");
    }

    @Test
    void testMonstroRecebeDanoCorretamente() {
        int vidaInicial = monstro.getPontosDeVida();
        int dano = 30;
        monstro.receberDano(dano);
        assertEquals(vidaInicial - dano, monstro.getPontosDeVida(), "A vida do monstro deve diminuir corretamente.");
    }

    @Test
    void testHeroiAtacaMonstro() {
        int vidaInicialMonstro = monstro.getPontosDeVida();
        int danoEsperado = heroi.getForca() + heroi.getArma().getDano();
        
        // Simula um ataque
        heroi.escolherAcao(monstro).executar(heroi, monstro);
        
        assertEquals(vidaInicialMonstro - danoEsperado, monstro.getPontosDeVida(), "Monstro deve receber dano do herói.");
    }

    @Test
    void testMonstroAtacaHeroi() {
        int vidaInicialHeroi = heroi.getPontosDeVida();
        int danoEsperado = monstro.getForca() + monstro.getArma().getDano();

        // Simula um ataque
        monstro.escolherAcao(heroi).executar(monstro, heroi);
        
        assertEquals(vidaInicialHeroi - danoEsperado, heroi.getPontosDeVida(), "Herói deve receber dano do monstro.");
    }

    @Test
    void testDroparLoot() {
        Item loot = monstro.droparLoot();
        assertNotNull(loot, "Monstro deveria dropar um loot.");
        assertEquals("Garras", loot.getNome());
    }
    
    // Teste de Exceção: NivelInsuficiente
    @Test
    void testEquiparArmaComNivelInsuficienteLancaExcecao() {
        Arma armaAvancada = new Martelo("Aniquilador Divino", 40, 5);
        // O herói está no nível 0 por padrão
        assertThrows(NivelInsuficiente.class, () -> {
            heroi.equiparArma(armaAvancada);
        });
    }

    // Teste de Exceção: IllegalArgumentException
    @Test
    void testReceberDanoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> {
            heroi.receberDano(-50);
        });
    }
}
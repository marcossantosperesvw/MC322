package com.rpglab.cenario;
import com.rpglab.itens.*;
import com.rpglab.personagens.monstros.Monstro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DificuldadeTest {

    private GeradorDeFases gerador;

    @BeforeEach
    void setUp() {
        gerador = new ConstrutorDeCenarioFixo();
    }

    @Test
    void testMonstrosSaoMaisFortesEmDificuldadeMaior() {
        // Gerar fases para FACIL e DIFICIL
        List<Fase> fasesFaceis = gerador.gerar(3, Dificuldade.FACIL);
        List<Fase> fasesDificeis = gerador.gerar(3, Dificuldade.DIFICIL);

        // Pegar o primeiro monstro da primeira fase para comparação
        Monstro monstroFacil = fasesFaceis.get(0).getMonstros().get(0);
        Monstro monstroDificil = fasesDificeis.get(0).getMonstros().get(0);

        // Verificar se os atributos são maiores na dificuldade DIFICIL
        assertTrue(monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida(),
                "Primeiro Monstro no DIFÍCIL deve ter mais vida que no FÁCIL.");

        assertTrue(monstroDificil.getForca() > monstroFacil.getForca(),
                "Primeiro Monstro no DIFÍCIL deve ter mais força que no FÁCIL.");
        
        // Fazer o mesmo para os proximos monstros
        monstroFacil = fasesFaceis.get(1).getMonstros().get(1);
        monstroDificil = fasesDificeis.get(1).getMonstros().get(1);

        // Verificar se os atributos são maiores na dificuldade DIFICIL
        assertTrue(monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida(),
                "Segundo Monstro no DIFÍCIL deve ter mais vida que no FÁCIL.");

        assertTrue(monstroDificil.getForca() > monstroFacil.getForca(),
                "Segundo Monstro no DIFÍCIL deve ter mais força que no FÁCIL.");
        
        
        monstroFacil = fasesFaceis.get(2).getMonstros().get(2);
        monstroDificil = fasesDificeis.get(2).getMonstros().get(2);

        // Verificar se os atributos são maiores na dificuldade DIFICIL
        assertTrue(monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida(),
                "Terceiro Monstro no DIFÍCIL deve ter mais vida que no FÁCIL.");

        assertTrue(monstroDificil.getForca() > monstroFacil.getForca(),
                "Terceiro Monstro no DIFÍCIL deve ter mais força que no FÁCIL.");
    }

    @Test
    void testQualidadeDoLootMudaComDificuldade() {
        // Gerar fases para FACIL e DIFICIL
        List<Fase> fasesFaceis = gerador.gerar(3, Dificuldade.FACIL);
        List<Fase> fasesDificeis = gerador.gerar(3, Dificuldade.DIFICIL);

        // O loot é definido no ConstrutorDeCenarioFixo, vamos pegar um monstro que dropa
        Monstro monstroFacil = fasesFaceis.get(0).getMonstros().get(0);
        Monstro monstroDificil = fasesDificeis.get(0).getMonstros().get(0);
        
        // Dropar um item de cada
        Item lootFacil = monstroFacil.droparLoot();
        Item lootDificil = monstroDificil.droparLoot();

        // Verificar se os itens são armas para poder comparar o dano
        assertTrue(lootFacil instanceof com.rpglab.itens.Arma);
        assertTrue(lootDificil instanceof com.rpglab.itens.Arma);
        
        com.rpglab.itens.Arma armaFacil = (com.rpglab.itens.Arma) lootFacil;
        com.rpglab.itens.Arma armaDificil = (com.rpglab.itens.Arma) lootDificil;
        
        // Com base no ConstrutorDeCenarioFixo, o loot da dificuldade maior deve ter mais dano
        assertTrue(armaDificil.getDano() > armaFacil.getDano(),
                "O loot do modo DIFÍCIL deve ser mais forte que o do FÁCIL para o primeiro monstro.");
        
        monstroFacil = fasesFaceis.get(1).getMonstros().get(1);
        monstroDificil = fasesDificeis.get(1).getMonstros().get(1);
        
        lootFacil = monstroFacil.droparLoot();
        lootDificil = monstroDificil.droparLoot();

        // Verificar se os itens são armas para poder comparar o dano
        assertTrue(lootFacil instanceof com.rpglab.itens.Arma);
        assertTrue(lootDificil instanceof com.rpglab.itens.Arma);
        
        armaFacil = (com.rpglab.itens.Arma) lootFacil;
        armaDificil = (com.rpglab.itens.Arma) lootDificil;
        
        // Com base no ConstrutorDeCenarioFixo, o loot da dificuldade maior deve ter mais dano
        assertTrue(armaDificil.getDano() > armaFacil.getDano(),
                "O loot do modo DIFÍCIL deve ser mais forte que o do FÁCIL para o segundo monstro");
        
        monstroFacil = fasesFaceis.get(2).getMonstros().get(2);
        monstroDificil = fasesDificeis.get(2).getMonstros().get(2);
        
        lootFacil = monstroFacil.droparLoot();
        lootDificil = monstroDificil.droparLoot();

        // Verificar se os itens são armas para poder comparar o dano
        assertTrue(lootFacil instanceof com.rpglab.itens.Arma);
        assertTrue(lootDificil instanceof com.rpglab.itens.Arma);
        
        armaFacil = (com.rpglab.itens.Arma) lootFacil;
        armaDificil = (com.rpglab.itens.Arma) lootDificil;
        
        // Com base no ConstrutorDeCenarioFixo, o loot da dificuldade maior deve ter mais dano
        assertTrue(armaDificil.getDano() > armaFacil.getDano(),
                "O loot do modo DIFÍCIL deve ser mais forte que o do FÁCIL para o terceiro monstro");
    }
}
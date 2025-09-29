package com.rpglab.cenario;
import com.rpglab.personagens.herois.*;
import com.rpglab.personagens.monstros.*;

public class Emboscada implements Evento {
    private boolean jaExecutado = false;
    
    @Override
    public boolean verificarGatilho(Heroi heroi, Monstro monstro) {
        // Gatilho: herói com vida baixa e evento ainda não executado
        return !jaExecutado && heroi.getPontosDeVida() < 100;
    }
    
    @Override
    public void executar(Heroi heroi, Monstro monstro) {
        System.out.println("\n*** EVENTO: EMBOSCADA! ***");
        System.out.println("Inimigos adicionais aparecem das sombras!");
        
        // Aplica efeitos negativos
        heroi.receberDano(10);
        System.out.println("O herói recebe 10 de dano da emboscada!");
        
        jaExecutado = true;
    }
}
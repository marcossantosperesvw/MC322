package com.rpglab.game.combate;


public interface Combatente {
    String getNome();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    boolean isAtordoado(); 
    AcaoDeCombate escolherAcao(Combatente alvo);
    int getPontosDeVida();
    void resetarHabilidade();
}
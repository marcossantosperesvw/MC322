package com.rpglab.cenario;
import com.rpglab.personagens.herois.*;
import com.rpglab.personagens.monstros.*;

public interface Evento {
    boolean verificarGatilho(Heroi heroi, Monstro monstro);
    void executar(Heroi heroi, Monstro monstro);
}
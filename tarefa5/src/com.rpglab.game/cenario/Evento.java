package com.rpglab.game.cenario;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;

public interface Evento {
    boolean verificarGatilho(Heroi heroi, Monstro monstro);
    void executar(Heroi heroi, Monstro monstro);
}
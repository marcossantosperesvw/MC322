package com.rpglab.game.cenario;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;
import java.util.List;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
    List<Monstro> getMonstros();
}
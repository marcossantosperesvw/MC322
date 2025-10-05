package com.rpglab.cenario;
import com.rpglab.personagens.herois.*;
import com.rpglab.personagens.monstros.*;
import java.util.List;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
    List<Monstro> getMonstros();
}
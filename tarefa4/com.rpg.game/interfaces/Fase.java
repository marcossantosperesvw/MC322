package interfaces;
import personagens.herois.*;
import personagens.monstros.Monstro;

import java.util.List;

import mundo.*;
// Falta importar tipo cenario conforme especificacao do enunciado
public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
    List<Monstro> getMonstros();
}
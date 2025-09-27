package interfaces;
import personagens.herois.*;
import mundo.*;
// Falta importar tipo cenario conforme especificacao do enunciado
public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
}
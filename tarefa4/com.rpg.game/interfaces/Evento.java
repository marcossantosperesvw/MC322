package interfaces;
import personagens.herois.*;
import personagens.monstros.*;
public interface Evento {
    boolean verificarGatilho(Heroi heroi, Monstro monstro);
    void executar(Heroi heroi, Monstro monstro);
}
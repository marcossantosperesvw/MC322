package interfaces;
import jogo.Heroi;
import jogo.Monstro;

public interface Evento {
    boolean verificarGatilho(Heroi heroi, Monstro monstro);
    void executar(Heroi heroi, Monstro monstro);
}
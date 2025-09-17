package interfaces;
import jogo.Heroi;
import jogo.TipoCenario;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
}
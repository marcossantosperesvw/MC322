package interfaces;
import java.util.List;
import mundo.*;
public interface GeradorDeFases {
    List<Fase> gerar(int quantidadeDeFases, Dificuldade d);
}
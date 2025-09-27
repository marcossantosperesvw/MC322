package mundo;
import java.util.*;
import interfaces.*;
import itens.*;
import personagens.monstros.*;


public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade d) {
        List<Fase> fases = new ArrayList<>();

        // Armas
        Arma calafafrios = new Machadinho("Cetro Gélido", 25, 0);
        Arma farra = new Machadinho("Varinha das Sombras", 25, 0);
        Arma fogo = new Machadinho("Garras de Fogo", 25, 0);
        Arma machadinha = new Machadinho("Machadinha Koopa", 15, 0);

        // Loots
        Arma[] listaNivel1 = {
            new Martelo("Esmagador de Crânios", 22, 1),
            new Varinha("Cajado da Noite Eterna", 15, 1),
            new Garras("Dilacerador de Almas", 20, 1)
        };
        Arma[] listaNivel2 = {
            new Martelo("Quebra-Mundos", 32, 2),
            new Varinha("Orbe da Destruição", 30, 2),
            new Garras("Desmembrador Cósmico", 37, 2)
        };
        Arma[] listaNivel3 = {
            new Martelo("Aniquilador Divino", 50, 3),
            new Varinha("Cetro do Apocalipse", 55, 3),
            new Garras("Exterminador de Universos", 42, 3)
        };

        // Fase 1
        fases.add(new FaseDeCombate(
            TipoCenario.CORREDOR_ASSOMBRADO,
            new Koopalings("Koopaling Ordenado", 90, 20, 150, machadinha, listaNivel1),
            new Koopalings("Koopaling Ponteiro", 90, 20, 150, machadinha, listaNivel1),
            new King_Boo("King Boo", 120, 30, 300, calafafrios, listaNivel1)
        ));

        // Fase 2
        fases.add(new FaseDeCombate(
            TipoCenario.CAMARA_ILUSOES,
            new Koopalings("Koopaling Logarítmico", 110, 25, 180, machadinha, listaNivel2),
            new Koopalings("Koopaling Quadrático", 110, 25, 180, machadinha, listaNivel2),
            new Kamek("Kamek", 300, 50, 420, farra, listaNivel2)
        ));

        // Fase 3
        fases.add(new FaseDeCombate(
            TipoCenario.CASTELO_BOWSER,
            new Koopalings("Koopaling Exponencial", 130, 30, 220, machadinha, listaNivel3),
            new Koopalings("Koopaling Linear", 130, 30, 220, machadinha, listaNivel3),
            new Bowser("Bowser", 450, 55, 1500, fogo, listaNivel3)
        ));

        return fases;
    }
}
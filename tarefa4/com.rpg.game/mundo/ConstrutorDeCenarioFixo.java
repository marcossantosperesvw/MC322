package mundo;
import java.util.*;
import interfaces.*;
import itens.*;
import personagens.monstros.*;


public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();

        // Armas sem dano - DAno apenas relacionado a forca do monstro
        Arma calafafrios = new Machadinho("Cetro Gélido", 0, 0);
        Arma farra = new Machadinho("Varinha das Sombras", 0, 0);
        Arma fogo = new Machadinho("Garras de Fogo", 0, 0);
        Arma machadinha = new Machadinho("Machadinha Koopa", 0, 0);

        // Loots
        Arma[] listaNivel1 = {
            new Martelo("Esmagador de Crânios", 22, 1000),
            new Varinha("Cajado da Noite Eterna", 15, 1000),
            new Garras("Dilacerador de Almas", 20, 1000)
        };
        Arma[] listaNivel2 = {
            new Martelo("Quebra-Mundos", 32, 10000),
            new Varinha("Orbe da Destruição", 30, 10000),
            new Garras("Desmembrador Cósmico", 37, 10000)
        };
        Arma[] listaNivel3 = {
            new Martelo("Aniquilador Divino", 50, 15),
            new Varinha("Cetro do Apocalipse", 55, 7),
            new Garras("Exterminador de Universos", 42, 20)
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
        // MULTIPLICADOR sobre os pontos de vida de cada monstro para todas as fases
        Adicao_Dificuldade(fases, dificuldade);
        return fases;
    }
    public static void Adicao_Dificuldade(List<Fase> fases, Dificuldade dificuldade){
        for (Fase f: fases){
            for (Monstro monstro : f.getMonstros()){
                double vida_monstro = monstro.getPontosDeVida() * dificuldade.getMult_dificuldade();
                double forca_monstro = monstro.getForca() * dificuldade.getMult_dificuldade();
                int forca_truncada = (int) forca_monstro;
                int vida_truncada = (int) vida_monstro;
                monstro.setPontosDeVida(vida_truncada);
                monstro.setForca(forca_truncada);

            }
        }
    }
}
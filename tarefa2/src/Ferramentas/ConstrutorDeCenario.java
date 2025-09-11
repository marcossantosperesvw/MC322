package Ferramentas;
public class ConstrutorDeCenario {
    public static Fase[] gerarFases(int nFases){
        Fase[] f = new Fase[nFases];

        for (int nvl = 0; nvl < nFases; nvl++){
            f[nvl] = new Fase(nvl, null, null);
        }

        return f;

    }
}

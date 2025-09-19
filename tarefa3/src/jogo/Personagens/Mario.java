package jogo.Personagens;

import Armas.Arma;
import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import java.util.Arrays;
import jogo.AcaoDeCombate.AtaqueFisico;
import jogo.AcaoDeCombate.HabilidadeCogumelo;
import jogo.Heroi;

public class Mario extends Heroi {
    private int cogumelo;

    public Mario(String nome, int pontosDeVida, int forca, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.cogumelo = 1;
        this.acoes = Arrays.asList(new AtaqueFisico(), new HabilidadeCogumelo());
    }

    public int getCogumelo() {
        return this.cogumelo;
    }

    public void setCogumelo(int cogumelo) {
        this.cogumelo = cogumelo;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // IA simples do Mario: se estiver com pouca vida e tiver cogumelo, usa. Senão, ataca.
        if (getPontosDeVida() < 50 && this.cogumelo > 0 && this.sorte > 0.5) {
            System.out.printf("%s esta com sorte e conseguiu utilizar sua habilidade especial\n", getNome());
            return acoes.get(1); // HabilidadeCogumelo
        }
        return acoes.get(0); // AtaqueFisico
    }
}
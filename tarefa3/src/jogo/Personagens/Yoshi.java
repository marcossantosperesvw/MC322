package jogo.Personagens;

import Armas.Arma;
import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import java.util.Arrays;
import jogo.AcaoDeCombate.AtaqueFisico;
import jogo.AcaoDeCombate.HabilidadeAtordoar;
import jogo.Heroi;
import jogo.Monstro;

public class Yoshi extends Heroi {
    private boolean atordoarDisponivel;

    public Yoshi(String nome, int pontosDeVida, int forca, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.atordoarDisponivel = true;
        this.acoes = Arrays.asList(new AtaqueFisico(), new HabilidadeAtordoar());
    }

    public void setAtordoarDisponivel(boolean atordoarDisponivel) {
        this.atordoarDisponivel = atordoarDisponivel;
    }
    
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (alvo instanceof Monstro) {
            Monstro monstro = (Monstro) alvo;
            // IA do Yoshi: se a habilidade estiver disponível, houver chance e o alvo não estiver atordoado, usa.
            if (this.atordoarDisponivel && !monstro.isAtordoado() && this.sorte > 0.8) {

                System.out.printf("%s esta com sorte e conseguiu utilizar sua habilidade especial\n", getNome());
                return acoes.get(1); // HabilidadeAtordoar
            }
        }
        return acoes.get(0); // AtaqueFisico
    }
}
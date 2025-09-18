package jogo.Personagens;

import Armas.Arma;
import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import jogo.Monstro;
import jogo.AcaoDeCombate.AtaqueFisico;

public class Bowser extends Monstro {
    public Bowser(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] lista) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, lista);
    }
    
    @Override
    protected void inicializarAcoes() {
        acoes.add(new AtaqueFisico());
    }
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // IA do Bowser: sempre ataca ferozmente
        System.out.println(getNome() + " ruge e prepara suas " + getArma().getNome() + "!");
        return acoes.get(0);
    }
}
package jogo.Personagens;

import jogo.Monstro;
import Armas.Arma;
import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import jogo.AcaoDeCombate.AtaqueFisico;

public class King_Boo extends Monstro {
    public King_Boo(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] lista) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, lista);
    }
    
    @Override
    protected void inicializarAcoes() {
        acoes.add(new AtaqueFisico());
    }
    
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        System.out.println(getNome() + " prepara uma Mordida Fantasma!");
        return acoes.get(0);
    }
}
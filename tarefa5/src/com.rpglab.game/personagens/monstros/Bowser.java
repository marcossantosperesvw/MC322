package com.rpglab.game.personagens.monstros;
import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;

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
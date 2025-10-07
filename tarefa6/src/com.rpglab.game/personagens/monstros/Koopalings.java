package com.rpglab.game.personagens.monstros;

import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;

public class Koopalings extends Monstro {
    public Koopalings(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] lista) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, lista);
    }
    
    @Override
    protected void inicializarAcoes() {
        acoes.add(new AtaqueFisico());
    }
    
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // IA simples: sempre ataca
        return acoes.get(0);
    }
}
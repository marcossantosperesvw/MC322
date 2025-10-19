package com.rpglab.game.personagens.monstros;

import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class King_Boo extends Monstro {
    
    public King_Boo() { super(); }
    
    public King_Boo(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] lista) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, lista);
    }

    @Override
    protected void inicializarAcoes() {
        acoes.add(new AtaqueFisico());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes == null || acoes.isEmpty()) {
            inicializarAcoes();
        }
        System.out.println(getNome() + " prepara uma Mordida Fantasma!");
        return acoes.get(0);
    }

    @Override
    public void resetarHabilidade() {
        setAtordoado(false);
    }
}

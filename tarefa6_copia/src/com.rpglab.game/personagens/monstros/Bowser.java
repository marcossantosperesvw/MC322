package com.rpglab.game.personagens.monstros;

import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Bowser extends Monstro {
    
    public Bowser() { super(); }
    
    public Bowser(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
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
        // IA do Bowser: sempre ataca ferozmente
        System.out.println(getNome() + " ruge e prepara suas " + getArma().getNome() + "!");
        return acoes.get(0);
    }

    @Override
    public void resetarHabilidade() {
        setAtordoado(false);
    }
}
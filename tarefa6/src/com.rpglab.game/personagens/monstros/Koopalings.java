package com.rpglab.game.personagens.monstros;

import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Koopalings extends Monstro {
    
    public Koopalings() { super(); }
    
    public Koopalings(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
    }

    @Override
    protected void inicializarAcoes() {
        acoes.add(new AtaqueFisico());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Inicializar se necessário
        if (acoes == null || acoes.isEmpty()) {
            inicializarAcoes();
        }
        // IA simples: sempre ataca
        return acoes.get(0);
    }
    @Override
    public void resetarHabilidade() {
        setAtordoado(false);
    }
}
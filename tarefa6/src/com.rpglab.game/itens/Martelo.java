package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Martelo extends Arma {
    public Martelo() { super(); }
    
    public Martelo(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }
}
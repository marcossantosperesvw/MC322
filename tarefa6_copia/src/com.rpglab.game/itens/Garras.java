package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Garras extends Arma {
    public Garras() { super(); }
    
    public Garras(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }
}
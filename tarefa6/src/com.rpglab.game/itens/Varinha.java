package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Varinha extends Arma {
    public Varinha() { super(); }
    
    public Varinha(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }
}

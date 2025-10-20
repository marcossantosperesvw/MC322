package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Cetro extends Arma {
    public Cetro() { super(); }
    
    public Cetro(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }
}
package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Machadinho extends Arma {
    public Machadinho() { super(); }
    
    public Machadinho(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }
}
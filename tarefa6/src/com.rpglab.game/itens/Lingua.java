package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Lingua extends Arma {
    
    // Construtor padrão para JAXB
    public Lingua() {
        super();
    }
    
    public Lingua(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }
}
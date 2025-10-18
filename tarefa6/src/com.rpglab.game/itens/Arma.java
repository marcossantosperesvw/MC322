package com.rpglab.game.itens;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Martelo.class, Lingua.class, Machadinho.class, Garras.class, Varinha.class, Cetro.class})
public abstract class Arma implements Item {
    
    @XmlElement
    private String nome;
    
    @XmlElement
    private int dano;
    
    @XmlElement
    private int minNivel;

    // Construtor padrão para JAXB
    protected Arma() {}

    public Arma(String nome, int dano, int minNivel) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getMinNivel() {
        return minNivel;
    }
}
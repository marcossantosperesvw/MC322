package com.rpglab.game.itens;

public abstract class Arma implements Item {
    private String nome;
    private int dano;
    private int minNivel;

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

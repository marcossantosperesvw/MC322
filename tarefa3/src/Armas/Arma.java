package Armas;

import interfaces.Item;

public abstract class Arma implements Item {
    // ... o resto do seu código da classe Arma permanece o mesmo ...
    private String nome;
    private int dano;
    private int MinNivel;

    public Arma(String nome, int dano, int MinNivel) {
        this.nome = nome;
        this.dano = dano;
        this.MinNivel = MinNivel;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getMinNivel() {
        return MinNivel;
    }
}
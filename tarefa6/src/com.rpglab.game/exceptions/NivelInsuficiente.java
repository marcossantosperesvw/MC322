package com.rpglab.game.exceptions;

public class NivelInsuficiente extends Exception {
    private int nivelAtual;
    private int nivelNecessario;
    private String nomeItem;
    
    public NivelInsuficiente() {
        super("Herói não possui nível suficiente para equipar nova arma");
    }
    
    public NivelInsuficiente(int nivelAtual, int nivelNecessario, String nomeItem) {
        super(String.format("Nível insuficiente! Atual: %d, Necessário: %d para %s", 
                          nivelAtual, nivelNecessario, nomeItem));
        this.nivelAtual = nivelAtual;
        this.nivelNecessario = nivelNecessario;
        this.nomeItem = nomeItem;
    }
    
    public int getNivelAtual() {
        return nivelAtual;
    }
    
    public int getNivelNecessario() {
        return nivelNecessario;
    }
    
    public String getNomeItem() {
        return nomeItem;
    }
}
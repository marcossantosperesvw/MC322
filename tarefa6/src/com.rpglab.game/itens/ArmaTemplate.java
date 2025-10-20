package com.rpglab.game.itens;
public class ArmaTemplate {
    private String classe_arma;
    private String nome;
    private int dano;
    private int nivel;

    public String getNome() {
        return nome;
    }
    public int getNivel() {
        return nivel;
    }
    public int getDano() {
        return dano;
    }
    
    public String getClasse_arma() {
        return classe_arma;
    }
    public ArmaTemplate(String classe_arma, String nome, int dano, int nivel){
        this.classe_arma = classe_arma;
        this.nome = nome;
        this.dano = dano;
        this.nivel = nivel; 
    }
}

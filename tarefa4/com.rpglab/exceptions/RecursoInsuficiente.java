package com.rpglab.exceptions;

public class RecursoInsuficiente extends Exception {
    private String tipoRecurso;
    private int quantidadeAtual;
    private int quantidadeNecessaria;
    
    public RecursoInsuficiente(String tipoRecurso) {
        super("Recurso insuficiente: " + tipoRecurso);
        this.tipoRecurso = tipoRecurso;
    }
    
    public RecursoInsuficiente(String tipoRecurso, int atual, int necessario) {
        super(String.format("Recurso insuficiente! %s - Atual: %d, Necessário: %d", 
                          tipoRecurso, atual, necessario));
        this.tipoRecurso = tipoRecurso;
        this.quantidadeAtual = atual;
        this.quantidadeNecessaria = necessario;
    }
    
    public String getTipoRecurso() {
        return tipoRecurso;
    }
    
    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
    
    public int getQuantidadeNecessaria() {
        return quantidadeNecessaria;
    }
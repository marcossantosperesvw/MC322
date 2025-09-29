package com.rpglab.cenario;

public enum Dificuldade {
    FACIL(0.8, "Inimigos mais fracos, melhores recompensas"),
    NORMAL(1.0, "Experiência balanceada"),
    DIFICIL(1.5, "Inimigos poderosos, grandes desafios");

    private final double multiplicadorDificuldade;
    private final String descricao;
    
    Dificuldade(double multiplicador, String descricao) {
        this.multiplicadorDificuldade = multiplicador;
        this.descricao = descricao;
    }
    
    public double getMultiplicadorDificuldade() {
        return multiplicadorDificuldade;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Aplica o multiplicador de dificuldade a um valor
     * @param valorBase O valor base a ser modificado
     * @return O valor modificado pela dificuldade
     */
    public int aplicarMultiplicador(int valorBase) {
        return (int) Math.round(valorBase * multiplicadorDificuldade);
    }
    
    /**
     * Determina a qualidade do loot baseado na dificuldade
     * @return índice que representa a qualidade do loot (0=básico, 1=médio, 2=épico)
     */
    public int getQualidadeLoot() {
        switch (this) {
            case FACIL:
                return 0; 
            case NORMAL:
                return 1; 
            case DIFICIL:
                return 2; 
            default:
                return 1;
        }
    }
}
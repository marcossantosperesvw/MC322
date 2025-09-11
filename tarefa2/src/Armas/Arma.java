package Armas;

public class Arma {
    private String nome;
    private int dano;
    private int MinNivel;

    public Arma(String nome, int dano, int MinNivel) {
        this.nome = nome;
        this.dano = dano;
        this.MinNivel = MinNivel;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getMinNivel() {
        return MinNivel;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setMinNivel(int minNivel) {
        this.MinNivel = minNivel;
    }
}

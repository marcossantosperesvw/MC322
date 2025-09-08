package Armas;
public abstract class Arma {
    private int dano;
    private int MinNivel;
    Arma(int dano, int MinNivel){
        this.dano = dano;
        this.MinNivel = MinNivel;
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

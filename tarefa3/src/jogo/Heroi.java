package jogo;
import Armas.Arma;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    protected float sorte;
    private int expParaProxNivel;

    public Heroi(String nome, int pontosDeVida, int forca, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = 0;
        this.experiencia = 0;
        this.sorte = (float) Math.random();
        this.expParaProxNivel = 100;
    }

    public int getNivel() {
        return this.nivel;
    }

    public float getSorte() {
        return this.sorte;
    }

    public void ganharExperiencia(int xp) {
        int nivelAnterior = this.nivel;
        this.experiencia += xp;
        this.nivel = this.experiencia / 100;
        this.expParaProxNivel = 100 - (experiencia % 100);

        if (this.nivel > nivelAnterior) {
            setForca(getForca() + 10 * (this.nivel - nivelAnterior));
            System.out.printf(">> %s subiu para o nível %d e sua força aumentou para %d! <<\n", getNome(), this.nivel, getForca());
        }
    }
    
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf("   Nível: %d | Experiência: %d (%d para o próximo nível)\n", this.nivel, this.experiencia, this.expParaProxNivel);
    }
}
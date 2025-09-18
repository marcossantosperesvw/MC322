package jogo;
import Armas.Arma;
import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import java.util.List;

public abstract class Personagem implements Combatente {
    private String nome;
    private int pontosDeVida;
    private int forca;
    protected Arma arma;
    protected List<AcaoDeCombate> acoes;

    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
        // NOTA: acoes será inicializada nas subclasses
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean estaVivo() {
        return this.pontosDeVida > 0;
    }

    @Override
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) {
            this.pontosDeVida = 0;
        }
    }

    @Override
    public void receberCura(int cura) {
        this.pontosDeVida += cura;
    }
    
    @Override
    public int getPontosDeVida() {
        return pontosDeVida;
    }
    
    public int getForca() {
        return this.forca;
    }

    public Arma getArma() {
        return arma;
    }
    
    public void equiparArma(Arma arma) {
        this.arma = arma;
    }

    protected void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    protected void setForca(int forca) {
        this.forca = forca;
    }

    public void exibirStatus() {
        System.out.printf("Nome: %s | Vida: %d | Força: %d\n", getNome(), getPontosDeVida(), getForca());
    }
}

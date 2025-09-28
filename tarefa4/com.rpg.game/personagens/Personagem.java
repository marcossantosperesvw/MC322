package personagens;
import interfaces.*;
import itens.*;
import java.util.*;
import exceptions.*;
import personagens.herois.*;

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
    
    public void equiparArma(Arma arma) throws NivelInsuficiente{
        if (getArma().getDano() < arma.getDano()){
            if (this instanceof Heroi){
                Heroi h = (Heroi) this;
                if (h.getNivel() < arma.getMinNivel()){
                    throw new NivelInsuficiente();
                } else {
                    System.out.printf("Heroi %s trocou %s por %s\n", h.getNome(), getArma().getNome(), arma.getNome());
                    this.arma = arma;
                }
            }

        }
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void exibirStatus() {
        System.out.printf("Nome: %s | Vida: %d | Força: %d\n", getNome(), getPontosDeVida(), getForca());
    }
}

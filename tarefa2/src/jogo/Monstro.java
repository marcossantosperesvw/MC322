package jogo;
import Armas.*;
// Criacao da classe abstrata para monstros
public abstract class Monstro extends Personagem{
    private int xp_concedido;
    private boolean atordoado = false;
    public Monstro(String nome, int pontos_de_vida, int forca, int xp_concedido, Arma arma){
        super(nome, pontos_de_vida, forca, arma);
        this.xp_concedido = xp_concedido;
    }
    public int getXpConcedido(){
        return this.xp_concedido;
    }
    public boolean getAtordoado(){
        return this.atordoado;
    }
    public void setAtordoado(boolean atordoado){
        this.atordoado = atordoado;
    }
    @Override
    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\nXP Concedido: %d\n", getNome(), getPontos_de_vida(), getForca(), getXpConcedido());
    }
}

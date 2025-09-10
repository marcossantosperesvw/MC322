package jogo;
import Armas.*;
import java.util.Random;
// Criacao da classe abstrata para monstros
public abstract class Monstro extends Personagem{
    private int xp_concedido;
    private boolean atordoado = false;
    public Arma[] listaArmasParaLargar = new Arma[3]; // Cada monstro  tera apenas tres opcoes de armas para largar
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
    public Arma[] getListaArmasParaLargar() {
        return listaArmasParaLargar;
    }
    public void setListaArmasParaLargar(Arma arma1, Arma arma2, Arma arma3) {
        this.listaArmasParaLargar[0] = arma1;
        this.listaArmasParaLargar[1] = arma2;
        this.listaArmasParaLargar[2] = arma3;

    }

    public void setAtordoado(boolean atordoado){
        this.atordoado = atordoado;
    }

    public Arma largaArma(){
        // Geracao de arma aleatoria para largar
        Random r = new Random();
        int numero = r.nextInt(3);

        return this.listaArmasParaLargar[numero];
    }
    @Override
    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\nXP Concedido: %d\n", getNome(), getPontos_de_vida(), getForca(), getXpConcedido());
    }
}

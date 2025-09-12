package jogo;
import Armas.Arma;
// Criacao da classe abstrata para monstros
public abstract class Monstro extends Personagem{
    private int xp_concedido;
    private boolean atordoado = false;
    private Arma[] listaArmasParaLargar;
    public Monstro(String nome, int pontos_de_vida, int forca, int xp_concedido, Arma arma, Arma[] listaArmasParaLargar){
        super(nome, pontos_de_vida, forca, arma);
        this.xp_concedido = xp_concedido;
        this.listaArmasParaLargar = listaArmasParaLargar;
 
    }
    public Arma[] getListaArmasParaLargar() {
        return listaArmasParaLargar;
    }
    public void setListaArmasParaLargar(Arma arma1, Arma arma2, Arma arma3) {
        this.listaArmasParaLargar[0] = arma1;
        this.listaArmasParaLargar[1] = arma2;
        this.listaArmasParaLargar[2] = arma3;
    }
    public Arma largarArma(){
        int numero = (int)(Math.random() * 3);
        Arma arma_largar = this.listaArmasParaLargar[numero];
        return arma_largar;
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

package jogo;
import Armas.Arma;
import interfaces.Item;
import interfaces.Lootavel;

public abstract class Monstro extends Personagem implements Lootavel {
    private final int xpConcedido;
    private boolean atordoado = false;
    private final Arma[] listaArmasParaLargar;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] listaArmasParaLargar) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaArmasParaLargar = listaArmasParaLargar;
    }

    public int getXpConcedido() {
        return this.xpConcedido;
    }

    public boolean isAtordoado() {
        return this.atordoado;
    }

    public void setAtordoado(boolean atordoado) {
        this.atordoado = atordoado;
    }

    @Override
    public Item droparLoot() {
        int numero = (int) (Math.random() * listaArmasParaLargar.length);
        return this.listaArmasParaLargar[numero];
    }
    
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf("   XP Concedido: %d\n", getXpConcedido());
    }
}
package jogo;
import Armas.Arma;
// Criacao da classe abstrata para personagens
public abstract class Personagem {
    private String nome;
    private int pontos_de_vida;
    private int forca;
    // Implementar Arma para os personagens
    protected Arma arma;

    public Personagem(String nome, int pontos_de_vida, int forca, Arma arma){
        this.nome = nome;
        this.pontos_de_vida = pontos_de_vida;
        this.forca = forca;
        this.arma = arma;
    }

    public void takeDamage(int damage){
        this.pontos_de_vida -= damage;

        if(this.pontos_de_vida < 0){
            setPontos_de_vida(0);
            
        }
    }

    // Getters e setters
    public String getNome(){
        return this.nome;
    }
    public int getPontos_de_vida(){ 
        return this.pontos_de_vida;
    }
    public int getForca(){
        return this.forca;
    }
    public Arma getArma() {
        return arma;
    }
    public void EquiparArma(Arma arma) {

        this.arma = arma;
    }
    public void setPontos_de_vida(int pontos_de_vida){
        this.pontos_de_vida = pontos_de_vida;
    }
    public void setForca(int forca){
        this.forca = forca;
    }
     public boolean isAlive(){
        if(getPontos_de_vida() > 0){
            return true;
        } else {
            return false;
        }
    }
    public void Exibir_Status(){
        System.out.printf("============================================\n");
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\n", this.nome, this.pontos_de_vida, this.forca);
        System.out.printf("============================================\n");
    }


    public abstract void atacar(Personagem p, int critico);



}

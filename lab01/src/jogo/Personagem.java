package jogo;
// Criacao da classe abstrata para personagens
public abstract class Personagem {
    private String nome;
    private int pontos_de_vida;
    private int forca;

    public Personagem(String nome, int pontos_de_vida, int forca){
        this.nome = nome;
        this.pontos_de_vida = pontos_de_vida;
        this.forca = forca;
    }

    public void Damage(int damage){
        this.pontos_de_vida -= damage;


    }
    public String getNome(){
        return this.nome;
    }
    public int getPontos_de_vida(){ 
        return this.pontos_de_vida;
    }
    public int getForca(){
        return this.forca;
    }

    public int setPontos_de_vida(int pontos_de_vida){
        this.pontos_de_vida = pontos_de_vida;
        return this.pontos_de_vida;
    }
    public int setForca(int forca){
        return this.forca;
    }

    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\n", this.nome, this.pontos_de_vida, this.forca);
    }


    public abstract void atacar(Personagem p);



}

package jogo;
public abstract class Personagem {
    String nome;
    int pontos_de_vida;
    int forca;

    Personagem(String nome, int pontos_de_vida, int forca){
        this.nome = nome;
        this.pontos_de_vida = pontos_de_vida;
        this.forca = forca;
    }

    public void Damage(int damage){
        this.pontos_de_vida -= damage;


    }

    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\n", this.nome, this.pontos_de_vida, this.forca);
    }


    public abstract void atacar(Personagem p);



}

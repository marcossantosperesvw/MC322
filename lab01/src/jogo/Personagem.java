package jogo;
// Criacao da classe abstrata para personagens
public abstract class Personagem {
    public String nome;
    public int pontos_de_vida;
    public int forca;

    public Personagem(String nome, int pontos_de_vida, int forca){
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
    public abstract void usarHabilidadeEspecial();



}

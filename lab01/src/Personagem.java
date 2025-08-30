public abstract class Personagem {
    String nome;
    int pontos_de_vida;
    int forca;

    Personagem(String nome, int pontos_de_vida, int forca){
        this.nome = nome;
        this.pontos_de_vida = pontos_de_vida;
        this.forca = forca;
    }

    public void Damage(int damage, Personagem p){
        p.pontos_de_vida -= damage;


    }

    public void Exibir_Status(Personagem p){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\n", p.nome, p.pontos_de_vida, p.forca);
    }


    abstract void atacar(Personagem p);



}

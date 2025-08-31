package jogo;

// Criacao da classe abstrata para monstros
public abstract class Monstro extends Personagem{
    private int xp_concedido;
    public Monstro(String nome, int pontos_de_vida, int forca, int xp_concedido){
        super(nome, pontos_de_vida, forca);
        this.xp_concedido = pontos_de_vida * forca;
    }
    
    @Override
    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\nXP Concedido: %d\n", this.nome, this.pontos_de_vida, this.forca, this.xp_concedido);
    }


    // @Override
    // public void atacar(Personagem p){
    //     p.Damage(this.forca);

    //     System.out.printf("%s atacou %s e causou %d de dano!\n", this.nome, p.nome, this.forca);
    // }

}

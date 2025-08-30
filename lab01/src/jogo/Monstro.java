package jogo;


public class Monstro extends Personagem{
    Monstro(String nome, int pontos_de_vida, int forca){
        super(nome, pontos_de_vida, forca);
    }
    @Override
    public void atacar(Personagem p){
        p.Damage(this.forca);

        System.out.printf("%s atacou %s e causou %d de dano!\n", this.nome, p.nome, this.forca);
    }

}

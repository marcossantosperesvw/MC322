package jogo.Personagens;

public class King_Boo extends jogo.Monstro {
    public King_Boo(String nome, int pontos_de_vida, int forca, int xp_concedido){
        super(nome, pontos_de_vida, forca, xp_concedido);
    }
    @Override
    public void atacar(jogo.Personagem p){

        System.out.printf("%s atacou %s e causou %d de dano!\n", getNome(), p.getNome(), getForca());
    }

}

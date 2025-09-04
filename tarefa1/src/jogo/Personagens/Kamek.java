package jogo.Personagens;

public class Kamek extends jogo.Monstro{

    public Kamek(String nome, int pontos_de_vida, int forca, int xp_concedido){
        super(nome, pontos_de_vida, forca, xp_concedido);



    }

    @Override
    public void atacar(jogo.Personagem alvo){
        System.out.printf("%s lançou Feitiço Abstrato em %s e causou %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
    }
    
}

package jogo.Personagens;
import jogo.*;
import Armas.*;
public class Kamek extends Monstro{

    public Kamek(String nome, int pontos_de_vida, int forca, int xp_concedido, Arma arma){
        super(nome, pontos_de_vida, forca, xp_concedido, arma);



    }

    @Override
    public void atacar(Personagem alvo){

        System.out.printf("%s lançou Feitiço Abstrato em %s e causou %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());

        if(alvo.isAlive() == false){
            System.out.printf("\n%s foi eliminado por %s com Frieza Mágica!\n", alvo.getNome(), getNome());
        }
    }
    
}

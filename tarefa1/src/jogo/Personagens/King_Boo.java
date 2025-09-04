package jogo.Personagens;
import jogo.*;

public class King_Boo extends Monstro {
    public King_Boo(String nome, int pontos_de_vida, int forca, int xp_concedido){
        super(nome, pontos_de_vida, forca, xp_concedido);
    }
    @Override
    public void atacar(Personagem alvo){

        System.out.printf("%s atacou %s com a Mordida Fantasma e causou %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
        
        if(alvo.isAlive() == false){
            System.out.printf("%s foi eliminado por %s, sendo tomado pela escuridão!\n", alvo.getNome(), getNome());
        }
    }

}

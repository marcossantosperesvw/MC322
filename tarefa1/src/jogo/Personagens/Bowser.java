package jogo.Personagens;

import jogo.*;


public class Bowser extends Monstro {
    public Bowser(String nome, int pontos_de_vida, int forca, int xp_concedido){
        super(nome, pontos_de_vida, forca, xp_concedido);
    }

    @Override
    public void atacar(Personagem alvo){

        System.out.printf("%s atacou %s com suas Bolas de Fogo, causando %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());

    }
}

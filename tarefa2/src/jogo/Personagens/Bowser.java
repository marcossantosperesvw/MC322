package jogo.Personagens;

import jogo.*;
import Armas.Arma;


public class Bowser extends Monstro {
    public Bowser(String nome, int pontos_de_vida, int forca, int xp_concedido, Arma arma, Arma[] lista){
        super(nome, pontos_de_vida, forca, xp_concedido, arma, lista);
    }

    @Override
    public void atacar(Personagem alvo, int critico){
        // Monstros nao terao ataque critico
        System.out.printf("%s atacou %s com suas Bolas de Fogo, causando %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
        if(alvo.isAlive() == false){
            System.out.println("Yoshi: Mario, meu amigo... Este é meu último presente para você!");
            System.out.println("Em um clarão de luz verde, Yoshi se lança contra Bowser em um cometa de pura coragem!");
            System.out.println("Yoshi se sacrifica em um último ataque heroico!");
            System.out.printf("%s foi eliminado por %s de maneira brutal!\n", alvo.getNome(), getNome());
        }

    }
}

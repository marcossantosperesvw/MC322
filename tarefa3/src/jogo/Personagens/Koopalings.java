package jogo.Personagens;

import jogo.*;
import Armas.Arma;
public class Koopalings extends Monstro {
    public Koopalings(String nome, int pontos_de_vida, int forca, int xp_concedido, Arma arma, Arma[] lista){
        super(nome, pontos_de_vida, forca, xp_concedido, arma, lista);
    }
    @Override
    public void atacar(Personagem alvo, int critico){
        // O monstro  nao tera ataque critico.
    System.out.printf("%s atacou %s com Magia Quadratica e causou %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
        
        if(alvo.isAlive() == false){
            System.out.printf("%s foi eliminado por %s, sendo tomado pela Ineficiência Quadrática!\n", alvo.getNome(), getNome());
        }
    }

}

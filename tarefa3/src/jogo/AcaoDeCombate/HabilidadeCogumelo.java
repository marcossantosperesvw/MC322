package jogo.AcaoDeCombate;

import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import jogo.Personagens.Mario;

public class HabilidadeCogumelo implements AcaoDeCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Mario) {
            Mario mario = (Mario) usuario;
            mario.setCogumelo(mario.getCogumelo() - 1);
            mario.receberCura(50);
            System.out.printf(">> %s usou um Cogumelo Mágico e recuperou 50 de vida! <<\n", mario.getNome());
        }
    }
}
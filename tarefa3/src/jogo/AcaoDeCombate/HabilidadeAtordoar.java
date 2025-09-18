package jogo.AcaoDeCombate;

import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import jogo.Monstro;
import jogo.Personagens.Yoshi;

public class HabilidadeAtordoar implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Yoshi && alvo instanceof Monstro) {
            Yoshi yoshi = (Yoshi) usuario;
            Monstro monstro = (Monstro) alvo;

            yoshi.setAtordoarDisponivel(false); // Usa a habilidade
            monstro.setAtordoado(true);
            System.out.printf(">> %s usa um ataque rápido e atordoa %s! <<\n", yoshi.getNome(), monstro.getNome());
            
            // Yoshi ainda ataca no mesmo turno
            System.out.println("Yoshi aproveita a chance para um ataque extra!");
            new AtaqueFisico().executar(yoshi, monstro);
        }
    }
}
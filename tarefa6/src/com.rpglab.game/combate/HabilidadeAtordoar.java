package com.rpglab.game.combate;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;
import com.rpglab.game.exceptions.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class HabilidadeAtordoar implements AcaoDeCombate {
    
    // Construtor padrão para JAXB
    public HabilidadeAtordoar() {}
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Yoshi && alvo instanceof Monstro) {
            Yoshi yoshi = (Yoshi) usuario;
            Monstro monstro = (Monstro) alvo;

            try {
                // Verificar se a habilidade está disponível
                if (!yoshi.isAtordoarDisponivel()) {
                    throw new RecursoInsuficiente("Habilidade Atordoar", 0, 1);
                }

                yoshi.setAtordoarDisponivel(false);
                monstro.setAtordoado(true);
                System.out.printf(">> %s usa um ataque rápido e atordoa %s! <<\n", 
                                yoshi.getNome(), monstro.getNome());
                
                // Yoshi ainda ataca no mesmo turno
                System.out.println("Yoshi aproveita a chance para um ataque extra!");
                new AtaqueFisico().executar(yoshi, monstro);
                
            } catch (RecursoInsuficiente e) {
                System.out.println("Habilidade não disponível! Realizando ataque normal.");
                new AtaqueFisico().executar(yoshi, monstro);
            }
        }
        // Lancar uma excecao neste caso -> mario nao pode atordoar

    }
}
package com.rpglab.combate;
import com.rpglab.personagens.herois.*;
import com.rpglab.exceptions.*;

public class HabilidadeCogumelo implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Mario) {
            Mario mario = (Mario) usuario;
            try {
                // Verificar se tem cogumelos disponíveis
                if (mario.getCogumelo() <= 0) {
                    throw new RecursoInsuficiente("Cogumelos Mágicos", mario.getCogumelo(), 1);
                }
                
                mario.setCogumelo(mario.getCogumelo() - 1);
                mario.receberCura(50);
                System.out.printf(">> %s usou um Cogumelo Mágico e recuperou 50 de vida! <<\n", 
                                mario.getNome());
                System.out.printf("Cogumelos restantes: %d\n", mario.getCogumelo());
                
            } catch (RecursoInsuficiente e) {
                System.out.println("Sem cogumelos disponíveis! Realizando ataque normal.");
                new AtaqueFisico().executar(mario, alvo);
            }
        }
    }
}
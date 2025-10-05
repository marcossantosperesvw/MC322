package com.rpglab.game.combate;

import com.rpglab.game.personagens.*;

public class AtaqueFisico implements AcaoDeCombate {
    /**
     * Executa um ataque físico de um combatente (usuário) em outro (alvo).
     * O dano total é calculado com base nos atributos do atacante e aplicado ao alvo.
     * @param usuario O combatente que está realizando o ataque.
     * @param alvo O combatente que está recebendo o ataque.
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Personagem atacante = (Personagem) usuario;
        int dano = atacante.calcularDanoTotal();
        alvo.receberDano(dano);
        System.out.printf("%s ataca %s com %s causando %d de dano!\n", 
                         usuario.getNome(), alvo.getNome(), 
                         atacante.getArma().getNome(), dano);
    }
}
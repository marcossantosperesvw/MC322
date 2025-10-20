package com.rpglab.game.combate;

@XmlSeeAlso({AtaqueFisico.class, HabilidadeAtordoar.class, HabilidadeCogumelo.class})
public interface AcaoDeCombate {
    void executar(Combatente usuario, Combatente alvo);
}
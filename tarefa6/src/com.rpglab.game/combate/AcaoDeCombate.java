package com.rpglab.game.combate;

import javax.xml.bind.annotation.*;

@XmlSeeAlso({AtaqueFisico.class, HabilidadeAtordoar.class, HabilidadeCogumelo.class})
public interface AcaoDeCombate {
    void executar(Combatente usuario, Combatente alvo);
}
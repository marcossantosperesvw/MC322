package com.rpglab.game.personagens.herois;

import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import com.rpglab.game.personagens.monstros.*;
import java.util.*;

public class Yoshi extends Heroi {
    private boolean atordoarDisponivel;

    public Yoshi(String nome, int pontosDeVida, int forca, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.atordoarDisponivel = true;
        this.acoes = Arrays.asList(new AtaqueFisico(), new HabilidadeAtordoar());
    }

    public boolean isAtordoarDisponivel() {
        return atordoarDisponivel;
    }

    public void setAtordoarDisponivel(boolean atordoarDisponivel) {
        this.atordoarDisponivel = atordoarDisponivel;
    }
    
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (alvo instanceof Monstro) {
            Monstro monstro = (Monstro) alvo;
            // IA do Yoshi: se a habilidade estiver disponível, houver chance e o alvo não estiver atordoado, usa.
            if (this.atordoarDisponivel && !monstro.isAtordoado() && this.sorte > 0.5) {
                System.out.printf("%s está com sorte e conseguiu utilizar sua habilidade especial\n", getNome());
                return acoes.get(1); // HabilidadeAtordoar
            }
        }
        return acoes.get(0); // AtaqueFisico
    }
    
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf("   Atordoar Disponível: %s\n", this.atordoarDisponivel ? "Sim" : "Não");
    }
}
package jogo.Personagens;

import Armas.Arma;
import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import java.util.Collections;
import jogo.AcaoDeCombate.AtaqueFisico;
import jogo.Monstro;

public class Bowser extends Monstro {

    public Bowser(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] lista) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, lista);
        // Monstros, por enquanto, só terão o ataque físico básico.
        this.acoes = Collections.singletonList(new AtaqueFisico());
    }
    
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // IA do Monstro: sempre ataca.
        return acoes.get(0);
    }
}
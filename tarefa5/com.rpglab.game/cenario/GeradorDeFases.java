package com.rpglab.cenario;
import java.util.*;

public interface GeradorDeFases {
    /**
     * Gera uma lista de fases para o jogo com base na dificuldade escolhida.
     * @param quantidadeDeFases A quantidade de fases a serem geradas.
     * @param dificuldade O nível de dificuldade que influenciará os monstros e recompensas.
     * @return Uma lista de objetos Fase prontos para serem jogados.
     */
    List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}
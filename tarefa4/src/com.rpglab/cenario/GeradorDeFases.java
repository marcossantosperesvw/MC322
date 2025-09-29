package com.rpglab.cenario;
import java.util.*;

public interface GeradorDeFases {
    List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}
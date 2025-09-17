package jogo.AcaoDeCombate;

import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import jogo.Personagens.Mario;

public class HabilidadeCogumelo implements AcaoDeCombate {
    private final String nomeAcao;
    
    public HabilidadeCogumelo(){
        this.nomeAcao = "Usar Cogumelo Mágico";
    }
    
    @Override
    public String getNomeAcao(){
        return this.nomeAcao;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Mario) {
            Mario mario = (Mario) usuario;
            mario.setCogumelo(mario.getCogumelo() - 1);
            int cura = mario.getPontosDeVida(); // Dobra a vida atual
            mario.receberCura(cura);
            System.out.printf(">> %s usou um Cogumelo Mágico e recuperou %d de vida! <<\n", mario.getNome(), cura);
        }
    }
}
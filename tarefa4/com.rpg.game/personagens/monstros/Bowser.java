package personagens.monstros;
import itens.*;
import interfaces.*;
import combate.*;

public class Bowser extends Monstro {
    public Bowser(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] lista) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, lista);
    }
    
    @Override
    public void inicializarAcoes() {
        acoes.add(new AtaqueFisico());
    }
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // IA do Bowser: sempre ataca ferozmente
        System.out.println(getNome() + " ruge e prepara suas " + getArma().getNome() + "!");
        return acoes.get(0);
    }
}
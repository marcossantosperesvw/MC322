package mundo;
import interfaces.*;
import java.util.*;

import personagens.monstros.*;
import personagens.herois.*;
import itens.*;
import  utils.*;

public class FaseDeCombate implements Fase {
    private TipoCenario tipoCenario;
    private List<Monstro> monstros;
    private boolean concluida;

    public FaseDeCombate(TipoCenario tipoCenario, Monstro... monstros) {
        this.tipoCenario = tipoCenario;
        this.monstros = Arrays.asList(monstros);
        this.concluida = false;
    }
    public List<Monstro> getMonstros() {
        return monstros;
    }
    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("\n======================================================================");
        System.out.println("                INICIANDO NOVA FASE: " + tipoCenario.getDescricao());
        System.out.println("======================================================================\n");
        tipoCenario.aplicarEfeitos(heroi);
        
        GerenciadorDeInteracao manager = new GerenciadorDeInteracao();
        for (Monstro monstro : monstros) {
            if (!heroi.estaVivo()) break;
            
            System.out.printf("\n--- Um %s selvagem aparece! ---\n", monstro.getNome());
            
            // Laço de combate
            Emboscada emboscada = new Emboscada();
            while (heroi.estaVivo() && monstro.estaVivo()) {
                if (emboscada.verificarGatilho(heroi, monstro)){
                    emboscada.executar(heroi, monstro);
                }

                System.out.println("\n--- Vez do Herói ---");
                heroi.escolherAcao(monstro).executar(heroi, monstro);

                if (monstro.estaVivo()) {
                    System.out.println("\n--- Vez do Monstro ---");
                    if (monstro.isAtordoado()) {
                        System.out.printf("%s está atordoado e perde o turno!\n", monstro.getNome());
                        monstro.setAtordoado(false);
                    } else {
                        monstro.escolherAcao(heroi).executar(monstro, heroi);
                    }
                }
                
                if (heroi.estaVivo()) {
                    System.out.printf("\n>> %s foi derrotado! <<\n", monstro.getNome());
                    Arma arma_dropada = (Arma) monstro.droparLoot();
                    System.out.printf("%s deixou cair: %s.\n", monstro.getNome(), arma_dropada.getNome());
                    heroi.ganharExperiencia(monstro.getXpConcedido());

                    System.out.println("\n-- Status Pós-Turno --");
                    heroi.exibirStatus();
                    
                    // Lógica de Loot
                    manager.StatusPosTurno(heroi, arma_dropada);


                }
                System.out.println("----------------------");
            }

        }

        if (heroi.estaVivo()) {
            this.concluida = true;
            if (heroi instanceof Mario){
                Mario m = (Mario) heroi;
                m.setCogumelo(1);
            }
            else {
                Yoshi y = (Yoshi) heroi;
                y.setAtordoarDisponivel(true);
            }
            // Reseta habilidades a cada fase
        }
    }

    @Override
    public boolean isConcluida() {
        return this.concluida;
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return this.tipoCenario;
    }
}
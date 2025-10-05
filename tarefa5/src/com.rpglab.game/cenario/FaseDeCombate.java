package com.rpglab.game.cenario;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;
import java.util.*;

import com.rpglab.game.itens.*;
import com.rpglab.game.util.*;

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
                // Verificar evento de emboscada
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
                
                // Exibir status após cada turno
                System.out.println("\n-- Status Pós-Turno --");
                heroi.exibirStatus();
                if (monstro.estaVivo()) {
                    monstro.exibirStatus();
                }
                System.out.println("----------------------");
            }
            
            // Monstro foi derrotado
            if (!monstro.estaVivo() && heroi.estaVivo()) {
                System.out.printf("\n>> %s foi derrotado! <<\n", monstro.getNome());
                Item itemDropado = monstro.droparLoot();
                if (itemDropado != null) {
                    System.out.printf("%s deixou cair: %s.\n", monstro.getNome(), itemDropado.getNome());
                    heroi.ganharExperiencia(monstro.getXpConcedido());
                    
                    // Lógica de Loot apenas se for uma arma
                    if (itemDropado instanceof Arma) {
                        manager.statusPosTurno(heroi, (Arma) itemDropado);
                    }
                }
            }
        }

        // Se herói sobreviveu a todos os monstros
        if (heroi.estaVivo()) {
            this.concluida = true;
            // Resetar habilidades específicas do herói
            if (heroi instanceof Mario){
                Mario m = (Mario) heroi;
                m.setCogumelo(1);
            }
            else if (heroi instanceof Yoshi) {
                Yoshi y = (Yoshi) heroi;
                y.setAtordoarDisponivel(true);
            }
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
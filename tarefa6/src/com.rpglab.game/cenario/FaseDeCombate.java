package com.rpglab.game.cenario;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;
import java.util.*;
import com.rpglab.game.itens.*;
import com.rpglab.game.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FaseDeCombate implements Fase {
    
    @XmlElement
    private TipoCenario tipoCenario;
    
    @XmlElementWrapper(name = "monstros")
    @XmlElements({
        @XmlElement(name = "bowser", type = Bowser.class),
        @XmlElement(name = "kingBoo", type = King_Boo.class),
        @XmlElement(name = "kamek", type = Kamek.class),
        @XmlElement(name = "koopalings", type = Koopalings.class)
    })
    private List<Monstro> monstros;
    
    @XmlElement
    private boolean concluida;

    // Construtor padrão para JAXB
    public FaseDeCombate() {
        this.monstros = new ArrayList<>();
    }

    public FaseDeCombate(TipoCenario tipoCenario, Monstro... monstros) {
        this.tipoCenario = tipoCenario;
        this.monstros = Arrays.asList(monstros);
        this.concluida = false;
    }
    
    @Override
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
            heroi.resetarHabilidade();
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
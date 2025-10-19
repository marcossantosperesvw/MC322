package com.rpglab.game.personagens.herois;

import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Mario extends Heroi {
    
    @XmlElement
    private int cogumelo;

    // Construtor padrão para JAXB
    public Mario() {
        super();
    }

    public Mario(String nome, int pontosDeVida, int forca, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.cogumelo = 1;
        this.acoes = Arrays.asList(new AtaqueFisico(), new HabilidadeCogumelo());
    }

    public int getCogumelo() {
        return this.cogumelo;
    }

    public void setCogumelo(int cogumelo) {
        this.cogumelo = cogumelo;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Inicializar ações se necessário (após desserialização)
        if (acoes == null || acoes.isEmpty()) {
            acoes = Arrays.asList(new AtaqueFisico(), new HabilidadeCogumelo());
        }
        
        // IA simples do Mario: se estiver com pouca vida e tiver cogumelo, usa. Senão, ataca.
        if (getPontosDeVida() < 100 && this.cogumelo > 0 && this.sorte > 0.5) {
            System.out.printf("%s está com sorte e conseguiu utilizar sua habilidade especial\n", getNome());
            return acoes.get(1); // HabilidadeCogumelo
        }
        return acoes.get(0); // AtaqueFisico
    }
    @Override
    public void resetarHabilidade(){
        setCogumelo(1);
    }
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf(" Cogumelos Mágicos: %d\n", this.cogumelo);
    }
}
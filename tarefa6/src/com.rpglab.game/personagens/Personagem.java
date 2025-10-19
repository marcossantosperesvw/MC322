package com.rpglab.game.personagens;

import com.rpglab.game.cenario.*;
import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import java.util.*;
import com.rpglab.game.exceptions.*;
import com.rpglab.game.personagens.herois.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Heroi.class})
public abstract class Personagem implements Combatente {
    
    @XmlElement
    private String nome;
    
    @XmlElement
    private int pontosDeVida;
    
    @XmlElement
    private int forca;
    
    @XmlElement
    protected Arma arma;
    
    @XmlTransient
    protected List<AcaoDeCombate> acoes;

    // Construtor padrão para JAXB
    protected Personagem() {
        this.acoes = new ArrayList<>();
    }

    /**
     * Construtor da classe Personagem.
     * @param nome Nome do personagem.
     * @param pontosDeVida Pontos de vida iniciais.
     * @param forca Força base do personagem.
     * @param arma Arma inicial equipada.
     */
    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
        this.acoes = new ArrayList<>();
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean estaVivo() {
        return this.pontosDeVida > 0;
    }

    /**
     * Aplica uma quantidade de dano ao personagem, reduzindo seus pontos de vida.
     * @param dano A quantidade de dano a ser recebida. Não pode ser negativa.
     * @throws IllegalArgumentException se o dano for negativo.
     */
    @Override
    public void receberDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("Dano não pode ser negativo");
        }
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) {
            this.pontosDeVida = 0;
        }
        System.out.printf("%s recebeu %d de dano! Vida restante: %d\n", 
                         this.nome, dano, this.pontosDeVida);
    }

    /**
     * Aplica uma quantidade de cura ao personagem, aumentando seus pontos de vida.
     * @param cura A quantidade de cura a ser recebida. Não pode ser negativa.
     * @throws IllegalArgumentException se a cura for negativa.
     */
    @Override
    public void receberCura(int cura) {
        if (cura < 0) {
            throw new IllegalArgumentException("Cura não pode ser negativa");
        }
        int vidaAnterior = this.pontosDeVida;
        this.pontosDeVida += cura;
        System.out.printf("%s foi curado em %d pontos! Vida: %d -> %d\n", 
                         this.nome, cura, vidaAnterior, this.pontosDeVida);
    }
    
    @Override
    public int getPontosDeVida() {
        return pontosDeVida;
    }
    
    public int getForca() {
        return this.forca;
    }

    public Arma getArma() {
        return arma;
    }
    
    /**
     * Equipa uma nova arma no personagem, substituindo a atual se a nova for melhor.
     * Apenas heróis têm a restrição de nível mínimo para equipar a arma.
     * @param novaArma A nova arma a ser equipada.
     * @throws NivelInsuficiente se um herói tentar equipar uma arma sem o nível necessário.
     * @throws IllegalArgumentException se a novaArma for nula.
     */
    public void equiparArma(Arma novaArma) throws NivelInsuficiente {
        if (novaArma == null) {
            throw new IllegalArgumentException("Nova arma não pode ser null");
        }
        
        // Verifica se o personagem é um herói para validar nível
        if (this instanceof Heroi) {
            Heroi h = (Heroi) this;
            if (h.getNivel() < novaArma.getMinNivel()) {
                throw new NivelInsuficiente();
            }
        }
        
        // Só troca se a nova arma for melhor
        if (this.arma == null || this.arma.getDano() < novaArma.getDano()) {
            Arma armaAnterior = this.arma;
            this.arma = novaArma;
            if (armaAnterior != null) {
                System.out.printf("%s trocou %s por %s\n", 
                                this.nome, armaAnterior.getNome(), novaArma.getNome());
            } else {
                System.out.printf("%s equipou %s\n", this.nome, novaArma.getNome());
            }
        } else {
            System.out.printf("%s já possui uma arma melhor ou igual!\n", this.nome);
        }
    }

    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida < 0) {
            this.pontosDeVida = 0;
        } else {
            this.pontosDeVida = pontosDeVida;
        }
    }

    public void setForca(int forca) {
        if (forca < 0) {
            throw new IllegalArgumentException("Força não pode ser negativa");
        }
        this.forca = forca;
    }

    /**
     * Calcula o dano total que o personagem pode causar em um ataque.
     * O cálculo é a soma da força do personagem com o dano da arma equipada.
     * @return O valor total do dano.
     */
    public int calcularDanoTotal() {
        int danoArma = (this.arma != null) ? this.arma.getDano() : 0;
        return this.forca + danoArma;
    }

    public void exibirStatus() {
        String statusArma = (this.arma != null) ? this.arma.getNome() : "Sem arma";
        System.out.printf("Nome: %s | Vida: %d | Força: %d | Arma: %s\n", 
                         getNome(), getPontosDeVida(), getForca(), statusArma);
    }
    
    // Método abstrato que deve ser implementado pelas subclasses
    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    @Override 
    public abstract resetarHabilidade();
}
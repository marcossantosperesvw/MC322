package com.rpglab.game.personagens.herois;

import com.rpglab.game.personagens.*;
import com.rpglab.game.itens.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Mario.class, Yoshi.class})
public abstract class Heroi extends Personagem {
    
    @XmlElement
    private int nivel;
    
    @XmlElement
    private int experiencia;
    
    @XmlElement
    protected float sorte;
    
    @XmlElement
    private int expParaProxNivel;

    // Construtor padrão para JAXB
    protected Heroi() {
        super();
    }

    public Heroi(String nome, int pontosDeVida, int forca, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = 0;
        this.experiencia = 0;
        this.sorte = (float) Math.random();
        this.expParaProxNivel = 100;
    }

    public int getNivel() {
        return this.nivel;
    }

    public float getSorte() {
        return this.sorte;
    }

    /**
     * Adiciona pontos de experiência ao herói e verifica se ele subiu de nível.
     * Ao subir de nível, a força do herói aumenta.
     * @param xp A quantidade de experiência a ser adicionada.
     */
    public void ganharExperiencia(int xp) {
        int nivelAnterior = this.nivel;
        this.experiencia += xp;
        this.nivel = this.experiencia / 100;
        this.expParaProxNivel = 100 - (experiencia % 100);

        if (this.nivel > nivelAnterior) {
            setForca(getForca() + 10 * (this.nivel - nivelAnterior));
            System.out.printf(">> %s subiu para o nível %d e sua força aumentou para %d! <<\n",
                    getNome(), this.nivel, getForca());
        }
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf(" Nível: %d | Experiência: %d (%d para o próximo nível)\n",
                this.nivel, this.experiencia, this.expParaProxNivel);
    }
}
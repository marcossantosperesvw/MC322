package com.rpglab.game.personagens.monstros;

import com.rpglab.game.personagens.*;
import com.rpglab.game.itens.*;
import com.rpglab.game.combate.*;
import java.util.*;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Bowser.class, King_Boo.class, Kamek.class, Koopalings.class})
public abstract class Monstro extends Personagem implements Lootavel {
    
    @XmlElement
    private final int xpConcedido;
    
    @XmlElement
    private boolean atordoado = false;
    
    
    // Ação de ataque compartilhada (AGREGAÇÃO)
    @XmlTransient
    private AcaoDeCombate acaoAtaqueCompartilhada;
    
    // Construtor padrão para JAXB
    protected Monstro() {
        super();
        this.xpConcedido = 0;
    }
    
    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.acoes = new ArrayList<>();
        inicializarAcoes();
    }
    
    protected abstract void inicializarAcoes();
    
    /**
     * Define a ação de ataque compartilhada (AGREGAÇÃO).
     * Permite que múltiplos monstros usem a mesma instância de ação.
     * @param acao A ação de combate a ser compartilhada
     */
    public void setAcaoAtaque(AcaoDeCombate acao) {
        this.acaoAtaqueCompartilhada = acao;
        // Limpa as ações antigas e adiciona a compartilhada
        this.acoes.clear();
        this.acoes.add(acao);
    }
    
    
    public int getXpConcedido() {
        return this.xpConcedido;
    }
    
    public boolean isAtordoado() {
        return this.atordoado;
    }
    
    public void setAtordoado(boolean atordoado) {
        this.atordoado = atordoado;
    }
    
    private Arma instanciarArma(ArmaTemplate template) {
        Class<?> possibilidades = Class.forName(template.getClasse_arma());
        return (Arma) possibilidades
                .getDeclaredConstructor(String.class, int.class, int.class)
                .newInstance(template.getNome(), template.getDano(), template.getNivel());
    }
    @Override
    public Arma droparLoot(int qualidade, ArmaTemplate[][] lootsPorQualidade) {
        ArmaTemplate[] arma_template = lootsPorQualidade[qualidade];
        int indice = (int) (Math.random() * 3);
        return instanciarArma(arma_template[indice]);
    }

    
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf(" XP Concedido: %d | Atordoado: %s\n",
                getXpConcedido(), isAtordoado() ? "Sim" : "Não");
    }
}
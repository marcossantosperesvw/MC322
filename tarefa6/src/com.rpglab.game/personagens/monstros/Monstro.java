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
    
    @XmlElement
    private final Arma[] listaArmasParaLargar;
    
    // Ação de ataque compartilhada (AGREGAÇÃO)
    @XmlTransient
    private AcaoDeCombate acaoAtaqueCompartilhada;
    
    // Construtor padrão para JAXB
    protected Monstro() {
        super();
        this.xpConcedido = 0;
        this.listaArmasParaLargar = new Arma[0];
    }
    
    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, Arma[] listaArmasParaLargar) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaArmasParaLargar = listaArmasParaLargar;
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
    
    @Override
    public Item droparLoot() {
        if (listaArmasParaLargar.length == 0) return null;
        int indice = (int) (Math.random() * listaArmasParaLargar.length);
        return this.listaArmasParaLargar[indice];
    }
    @Override
    public Item droparLoot(int qualidade, ArmaTemplate[][] lootsPorQualidade) {
        Arma[] arma_template = lootsPorQualidade[qualidade];
        int indice = (int) (Math.random() * 3);
        return instanciarArma(arma_template[indice]);
    }

    private Arma instanciarArma(ArmaTemplate template) {
        try {
            Class<?> possibilidades = Class.forName(template.getTipoClasse());
            // Supondo que o construtor aceite (String nome, int dano, int nivel)
            return (Arma) possibilidades
                    .getDeclaredConstructor(String.class, int.class, int.class)
                    .newInstance(template.getNome(), template.getDano(), template.getNivel());
        } catch (Exception e) {
            // Erro ao instanciar arma
            return null;
        }
    }
    
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf(" XP Concedido: %d | Atordoado: %s\n",
                getXpConcedido(), isAtordoado() ? "Sim" : "Não");
    }
}
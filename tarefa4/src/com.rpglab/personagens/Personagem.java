package personagens;
import interfaces.*;
import itens.*;
import java.util.*;
import exceptions.*;
import personagens.herois.*;

public abstract class Personagem implements Combatente {
    private String nome;
    private int pontosDeVida;
    private int forca;
    protected Arma arma;
    protected List<AcaoDeCombate> acoes;

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

    // Método para calcular dano total (força + dano da arma)
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
}
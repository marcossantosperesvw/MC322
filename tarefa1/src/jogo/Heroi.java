package jogo;
import Armas.*;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    public Heroi(String nome, int pontos_de_vida, int forca, Arma arma) {
        super(nome, pontos_de_vida, forca, arma);

        this.nivel = 0;
        this.experiencia = 0;
    }
    

    // Getters e Setters
    public int getNivel() {
        return this.nivel;
    }
    public int getExperiencia() {
        return this.experiencia;
    }

    public void ganharExperiencia(int xp) {
        int nivel_anterior = this.nivel;
        this.experiencia += xp;
        if (this.experiencia >= 100) {
            this.nivel = this.experiencia /100;

            if(this.nivel > nivel_anterior){
                System.out.printf("%s subiu para o nível %d!\n", getNome(), this.nivel);
            }

            this.experiencia %= 100;
        }
    }

    public abstract void usarHabilidadeEspecial();

    @Override
    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\nNível: %d\nExperiência: %d\n", getNome(), getPontos_de_vida(), getForca(), this.nivel, this.experiencia);
    }

}
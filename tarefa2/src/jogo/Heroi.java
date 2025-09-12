package jogo;
import Armas.Arma;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    private float sorte;
    int expParaProxNivel;
    public Heroi(String nome, int pontos_de_vida, int forca, Arma arma) {
        super(nome, pontos_de_vida, forca, arma);

        this.nivel = 0;
        this.experiencia = 0;

        this.sorte = (float) Math.random();
    }
    

    // Getters e Setters
    public int getNivel() {
        return this.nivel;
    }
    public int getExperiencia() {
        return this.experiencia;
    }
    public float getSorte() {
        return this.sorte;
    }
    public int getExpParaProxNivel() {
        return expParaProxNivel;
    }
    public void ganharExperiencia(int xp) {
        int nivel_anterior = this.nivel;
        this.experiencia += xp;
        this.nivel = this.experiencia /100;
        this.expParaProxNivel = 100 -(experiencia %100);
        if(this.nivel > nivel_anterior){
            System.out.printf("%s subiu para o nível %d e sua forca foi atualizada para %d!\n", getNome(), this.nivel, getForca()+ 10);
            setForca(getForca() + 10);
        }

    }

    public abstract void usarHabilidadeEspecial();

    @Override
    public void Exibir_Status(){
        if (this.expParaProxNivel!=0){

            System.out.printf("Nome: %s\nVida: %d\nForça: %d\nNível: %d\nExperiência: %d\nFaltam %d de experiencia para o proximo nivel\n", getNome(), getPontos_de_vida(), getForca(), this.nivel, this.experiencia, this.expParaProxNivel);
        } else {
            System.out.printf("Nome: %s\nVida: %d\nForça: %d\nNível: %d\nExperiência: %d\n", getNome(), getPontos_de_vida(), getForca(), this.nivel, this.experiencia);

        }
    }

}
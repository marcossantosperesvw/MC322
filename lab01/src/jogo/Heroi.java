package jogo;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    public Heroi(String nome, int pontos_de_vida, int forca) {
        super(nome, pontos_de_vida, forca);

        this.nivel = 0;
        this.experiencia = 0;
        
    }
    


    public int getNivel() {
        return this.nivel;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public void ganharExperiencia(int xp) {
        this.experiencia += xp;
        if (this.experiencia >= 100) {
            this.nivel++;
            this.experiencia -= 100;
            System.out.printf("%s subiu para o nível %d!\n", getNome(), this.nivel);
        }
    }

    public abstract void usarHabilidadeEspecial();

    @Override
    public void Exibir_Status(){
        System.out.printf("Nome: %s\nVida: %d\nForça: %d\nNível: %d\nExperiência: %d/10\n", getNome(), getPontos_de_vida(), getForca(), this.nivel, this.experiencia);
    }

}
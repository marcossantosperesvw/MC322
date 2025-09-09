package jogo.Personagens;
import jogo.*;
import Armas.*;
public class Yoshi extends Heroi {
    private int atordoar;
    public Yoshi(String nome, int pontos_de_vida, int forca, Arma arma){
        super(nome, pontos_de_vida, forca,arma);

        this.atordoar = 1;
    }

    // Getters e Setters
    public int getAtordoar(){
        return this.atordoar;
    }
    public void setAtordoar(int atordoar){
        this.atordoar = atordoar;
    }

    public void TurnoYoshi(Monstro alvo){
        if (getAtordoar() == 1 && !alvo.getAtordoado()){
            // Usando habilidade de atordoamento
            usarHabilidadeEspecial();
            alvo.setAtordoado(true);
            
            // Ainda pode fazer um ataque apos usar atordoamento
            System.out.println("Yoshi aproveita a chance e ataca!");
            atacar(alvo);


        } else {


            atacar(alvo);
        }
        // Se monstro foi derrotado, ele recebe experiencia
        if(alvo.getPontos_de_vida() <= 0){
            System.out.printf("%s derrotou %s e ganhou %d de experiencia!\n", getNome(), alvo.getNome(), alvo.getXpConcedido());
            ganharExperiencia(alvo.getXpConcedido());
        }     
    }
    @Override
    public void atacar(Personagem alvo){
        
        System.out.printf("%s pisou em cima de %s, causando %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
    }
    @Override
    public void usarHabilidadeEspecial(){
        // Volta apenas ao derrotar o monstro
        setAtordoar(0);

        System.out.printf("%s atordoou o oponente com sua habilidade especial\n", getNome());



    }
    
}

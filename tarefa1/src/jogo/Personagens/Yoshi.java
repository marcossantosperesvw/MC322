package jogo.Personagens;
import jogo.*;
public class Yoshi extends Heroi {
    private int atordoar;
    public Yoshi(String nome, int pontos_de_vida, int forca){
        super(nome, pontos_de_vida, forca);

        this.atordoar = 1;
    }

    public int getAtordoar(){
        return this.atordoar;
    }
    public void setAtordoar(int atordoar){
        this.atordoar = atordoar;
    }

    public void TurnoYoshi(Monstro alvo){
        if (getAtordoar()== 1){
            // Usa habilidade de atordoar
            usarHabilidadeEspecial();

        } else {

            // Ataca normalmente
            atacar(alvo);

        }

        if(alvo.getPontos_de_vida() <= 0){
            ganharExperiencia(alvo.getXpConcedido());

            System.out.printf("%s derrotou %s e ganhou %d de experiencia!\n", getNome(), alvo.getNome(), alvo.getXpConcedido());

            // Reseta a habilidade e vida pra enfrentar proximo monstro
            setPontos_de_vida(75);
            setAtordoar(1);
        }

            
    }
    @Override
    public void atacar(Personagem alvo){
        
        System.out.printf("%s pisou em cima de %s, causando %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
    }
    @Override
    public void usarHabilidadeEspecial(){
        // Habilidade de atordoar o oponente
        // Apos o uso, volta apenas ao derrotar o monstro
        setAtordoar(0);

        System.out.printf("%s atordoou o oponente com sua habilidade especial\n", getNome());



    }
    
}

package jogo.Personagens;
import jogo.*;

public class Mario extends Heroi {
    private int estrela;
    private int cogumelo;
    private boolean invencivel;
 
    public Mario(String nome, int pontos_de_vida, int forca){
        super(nome, pontos_de_vida, forca);
        this.cogumelo = 1; // Mario comeca com apenas 1 cogumelo
        this.invencivel = false;

    }
    public int getCogumelo(){
        return this.cogumelo;
    }
    public int getEstrela(){
        return this.estrela;
    }
    public boolean getInvencivel(){
        return this.invencivel;
    }

    public void setCogumelo(int cogumelo){
        this.cogumelo = cogumelo;
    }
    public void setEstrela(int estrela){
        this.estrela = estrela;
    }
    public void usarEstrela(){
        // Usa estrela e o personagem fica temporariamente intangivel
        this.estrela--;
        this.invencivel = true;

        System.out.printf("%s usou a estrela e está temporariamente invencivel",getNome());
        


    }

    public void TurnoMario(Monstro alvo){
        if(getInvencivel() == true){
            this.invencivel = false; // Desativa o invencivel apos um turno
            System.out.printf("%s perdeu o poder da estrela e não esta mais invencível\n", getNome());

        }
        if(getPontos_de_vida() < 0.5 * 150){
            usarHabilidadeEspecial(); // Usa o cogumelo se a vida estiver abaixo de 50% da vida maxima (150)
            usarEstrela(); // Usa a estrela para ficar invencivel
        }

        atacar(alvo);


        if (alvo.getPontos_de_vida() <= 0){
            ganharExperiencia(alvo.getXpConcedido());

            // Ao derrotar um monstro, suas habilidades e sua vida resetam, assim como acontece para o Yoshi
            setCogumelo(1);
            setEstrela(1);
            setPontos_de_vida(150);
            this.invencivel = false;



            

            setPontos_de_vida(150);
            System.out.printf("%s derrotou %s e ganhou %d de experiencia!\n", getNome(), alvo.getNome(), alvo.getXpConcedido());


        }





    }
 
    @Override
    public void atacar(jogo.Personagem alvo){
        
        System.out.printf("%s pulou em cima de %s, causando %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
    }
    @Override
    public void usarHabilidadeEspecial(){

        // Usa o Cogumelo
        this.cogumelo--;
        System.out.printf("%s usou cogumelo mágico e sua vida foi dobrada!\n", getNome());

        // Dobra a vida
        setPontos_de_vida(getPontos_de_vida() * 2);

    }
    
}

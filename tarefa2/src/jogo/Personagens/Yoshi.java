package jogo.Personagens;
import jogo.*;
import Armas.Arma;
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
        // Gerar atributo sorte antes de lancar a habilidade especial
        float dado = (float) Math.random();

        if (getAtordoar() == 1 && !alvo.getAtordoado() && getSorte() > dado){
            // Usando habilidade de atordoamento
            usarHabilidadeEspecial();
            alvo.setAtordoado(true);
            
            // Ainda pode fazer um ataque apos usar atordoamento
            System.out.println("Yoshi aproveita a chance e ataca!");
            int critico = 0;
            if (dado >= 0.8){
                critico = 1;
            }
            atacar(alvo, critico);


        } else {
            int critico = 0;
            if (dado >= 0.8){
                critico = 1;
            }

            atacar(alvo, critico);
        }
        // Se monstro foi derrotado, ele recebe experiencia
        if(alvo.getPontos_de_vida() <= 0){
            System.out.printf("%s derrotou %s e ganhou %d de experiencia!\n", getNome(), alvo.getNome(), alvo.getXpConcedido());
            ganharExperiencia(alvo.getXpConcedido());

            // Verificar loot do monstro
            Arma nova_arma = alvo.largarArma();
            if (nova_arma != null && nova_arma.getDano() > this.getArma().getDano() && nova_arma.getMinNivel() <= getNivel()){
                EquiparArma(nova_arma);
                System.out.printf("%s trocou sua %s por %s", getNome(), getArma(), nova_arma.getNome());
            }
        }     
    }
    @Override
    public void atacar(Personagem alvo, int critico){
        int ataque = getForca() + this.arma.getDano();
        if (critico == 1){
            double dano = (1.2 * ataque); // Acerto critico
            int dano_truncado = (int)Math.floor(dano);
            System.out.printf("%s conseguiu acertar dano critico com %s em cima de %s, causando %d de dano", getNome(), this.arma.getNome(), alvo.getNome(), dano_truncado);
            
            alvo.takeDamage(dano_truncado);
        } else {

            System.out.printf("%s pisou em cima de %s, causando %d de dano!\n", getNome(), alvo.getNome(), ataque);
            alvo.takeDamage(ataque);
        }
    }
    @Override
    public void usarHabilidadeEspecial(){
        // Volta apenas ao derrotar o monstro
        setAtordoar(0);

        System.out.printf("%s atordoou o oponente com sua habilidade especial\n", getNome());



    }
    
}

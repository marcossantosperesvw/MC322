package jogo.Personagens;
import jogo.*;
import Armas.Arma;
public class Mario extends Heroi {
    private int cogumelo;
 
    public Mario(String nome, int pontos_de_vida, int forca, Arma arma){
        super(nome, pontos_de_vida, forca, arma);
        this.cogumelo = 1; // Mario comeca com apenas 1 cogumelo

    }

    // Getters e Setters
    public int getCogumelo(){
        return this.cogumelo;
    }
    public void setCogumelo(int cogumelo){
        this.cogumelo = cogumelo;
    }

    public void TurnoMario(Monstro alvo){

        float dado = (float) Math.random();
        if(getPontos_de_vida() < 50 && getCogumelo() > 0 && getSorte() > dado){
            // Utiliza cogumelo apenas quando esta com 50% da vida
            System.out.printf("%s está com pouca vida! ", getNome());
            usarHabilidadeEspecial();
        }
        else {
            // Mario nao consegue usar a sua habilidade especial e atacar no mesmo turno
            int critico = 0;
            if (dado >= 0.8){
                critico = 1;
            }

            atacar(alvo, critico);
        }
        
        // Se derrotou monstro, recebe experiencia
        if (alvo.getPontos_de_vida() <= 0){
            System.out.printf("%s derrotou %s e ganhou %d de experiencia!\n", getNome(), alvo.getNome(), alvo.getXpConcedido());
            ganharExperiencia(alvo.getXpConcedido());

            Arma nova_arma = alvo.largarArma();
            if (nova_arma.getDano() > this.getArma().getDano() && nova_arma.getMinNivel() <= getNivel()){
                EquiparArma(nova_arma);
            }
        }

    }
 
    @Override
    public void atacar(jogo.Personagem alvo, int critico){
        int ataque = getForca() + this.arma.getDano();
        if (critico == 1){
            
            double dano = (1.2 *  ataque); // Acerto critico
            int dano_truncado = (int)Math.floor(dano);
            System.out.printf("%s conseguiu acertar dano critico com %s em cima de %s, causando %d de dano", getNome(), this.arma.getNome(), alvo.getNome(), dano_truncado);

            alvo.takeDamage(dano_truncado);
        } else {

            System.out.printf("%s pulou em cima de %s, causando %d de dano!\n", getNome(), alvo.getNome(), ataque);
            alvo.takeDamage(ataque);
        }
    }
    @Override
    public void usarHabilidadeEspecial(){

        // Usa o Cogumelo
        setCogumelo(this.cogumelo - 1);
        System.out.printf("%s usou cogumelo mágico e sua vida foi dobrada!\n", getNome());

        // Dobra a vida
        setPontos_de_vida(getPontos_de_vida() * 2);

    }
    
}

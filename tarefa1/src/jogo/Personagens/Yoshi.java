package jogo.Personagens;

public class Yoshi extends jogo.Heroi {
    private int atordoar;
    public Yoshi(String nome, int pontos_de_vida, int forca){
        super(nome, pontos_de_vida, forca);

        this.atordoar = 1;
    }

    public int getAtordoar(){
        return this.atordoar;
    }
    @Override
    public void atacar(jogo.Personagem alvo){
        
        System.out.printf("%s pisou em cima de %s, causando %d de dano!\n", getNome(), alvo.getNome(), getForca());
        alvo.takeDamage(getForca());
    }
    @Override
    public void usarHabilidadeEspecial(){

        this.atordoar -= 1;

        
        System.out.printf("%s atordoou o oponente com sua habilidade especial\n", getNome());



    }
    
}

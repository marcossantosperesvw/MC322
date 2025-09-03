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
    public void atacar(jogo.Personagem p){
        p.Damage(getForca());

        System.out.printf("%s atacou %s e causou %d de dano!\n", getNome(), p.getNome(), getForca());
    }
    @Override
    public void usarHabilidadeEspecial(){

        this.atordoar -= 1;

        
        System.out.printf("%s atordoou o oponente com sua habilidade especial\n", getNome());


        setPontos_de_vida(getPontos_de_vida() * 2);

    }
    
}

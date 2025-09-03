package jogo.Personagens;

public class Mario extends jogo.Heroi {
    private int estrela;
    private int cogumelo;
    public Mario(String nome, int pontos_de_vida, int forca){
        super(nome, pontos_de_vida, forca);
        this.cogumelo = 1; // Mario comeca com apenas 1 cogumelo
    }
    public int getCogumelo(){
        return this.cogumelo;
    }
    public int getEstrela(){
        return this.estrela;
    }

 
    @Override
    public void atacar(jogo.Personagem p){
        p.Damage(getForca());

        System.out.printf("%s atacou %s e causou %d de dano!\n", getNome(), p.getNome(), getForca());
    }
    @Override
    public void usarHabilidadeEspecial(){
        this.cogumelo--;
        System.out.printf("%s usou cogumelo mágico e sua vida foi dobrada!\n", getNome());


        setPontos_de_vida(getPontos_de_vida() * 2);

    }
    
}

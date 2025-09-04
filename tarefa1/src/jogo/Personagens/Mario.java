package jogo.Personagens;

public class Mario extends jogo.Heroi {
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
    public void usarEstrela(){
        // Usa estrela e o personagem fica temporariamente intangivel
        this.estrela--;
        this.invencivel = true;

        System.out.printf("%s usou a estrela e está temporariamente invencivel",getNome());
        


    }
 
    @Override
    public void atacar(jogo.Personagem alvo){
        
        System.out.printf("%s atacou %s e causou %d de dano!\n", getNome(), alvo.getNome(), getForca());
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

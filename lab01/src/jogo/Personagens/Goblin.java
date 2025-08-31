package jogo.Personagens;

public class Goblin extends jogo.Monstro {
    private int velocidade;
    public Goblin(String nome, int pontos_de_vida, int forca, int xp_concedido, int velocidade){
        super(nome, pontos_de_vida, forca, xp_concedido);
        this.velocidade = velocidade; // Ao ativar o modo de velocidade o Goblin dobra este atributo conseguindo atacar duas vezes em apenas uma
    }
    public int getVelocidade(){
        return this.velocidade;
    }

    @Override
    public void atacar(jogo.Personagem p){
        p.Damage(getForca());

        System.out.printf("%s atacou %s e causou %d de dano!\n", getNome(), p.getNome(), getForca());
    }
    @Override   
    public void usarHabilidadeEspecial(){
        System.out.printf("%s usou habilidade especial!\n", getNome());
    }
    
}

package jogo.Personagens;

public class Mago extends jogo.Personagem {

    private int magia;
    public Mago(String nome, int pontos_de_vida, int forca, int magia){
        super(nome, pontos_de_vida, forca);
        this.magia = magia;
    }
    public int getMagia(){
        return this.magia;
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

package jogo.Personagens;

public class Zumbi extends jogo.Monstro {
    private int resistencia;
    public Zumbi(String nome, int pontos_de_vida, int forca, int xp_concedido){
        super(nome, pontos_de_vida, forca, xp_concedido);
        this.resistencia = 0; // Se a vida do zumbi estiver abaixo de 10%, ele dobra sua vida para 20% ao ativar o modo de resistencia
    }
    public int getResistencia(){
        return this.resistencia;
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

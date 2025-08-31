package jogo.Personagens;

public class Guerreiro extends jogo.Personagem {
    private int furia;
    public Guerreiro(String nome, int pontos_de_vida, int forca){
        super(nome, pontos_de_vida, forca);
        this.furia = 0; // Se a vida do guerreiro estiver abaixo de 10%, ele ativa o modo de Furia - permite dar mais dano nesta rodada
    }
    
    @Override
    public void atacar(jogo.Personagem p){
        p.Damage(this.forca);

        System.out.printf("%s atacou %s e causou %d de dano!\n", this.nome, p.nome, this.forca);
    }
    @Override
    public void usarHabilidadeEspecial(){   
        System.out.printf("%s usou habilidade especial!\n", this.nome);
    }   
}

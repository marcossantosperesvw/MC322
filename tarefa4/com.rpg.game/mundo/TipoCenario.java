package mundo;
import personagens.herois.*;

public enum TipoCenario {
    CASTELO_BOWSER("Fortaleza de Bowser", "O ar é pesado com o cheiro de enxofre e malícia.", Dificuldade.DIFICIL),
    CORREDOR_ASSOMBRADO("Corredor Sombrio", "A temperatura cai drasticamente e sussurros ecoam pelas paredes.", Dificuldade.MEDIO),
    CAMARA_ILUSOES("Câmara das Ilusões", "As paredes parecem se contorcer e a realidade se distorce a cada passo.", Dificuldade.FACIL);

    private String descricao;
    private String efeito;
    private Dificuldade dificuldade;

    TipoCenario(String descricao, String efeito, Dificuldade d) {
        this.descricao = descricao;
        this.efeito = efeito;
        this.dificuldade = d;
    }
    public Dificuldade getDificuldade() {
        return dificuldade;
    }
    public String getDescricao() {
        return descricao;
    }

    public void aplicarEfeitos(Heroi heroi) {
        System.out.println(efeito);
        // IMPLEMENTAR diferentes efeitos
        heroi.receberDano(5);

    }
}
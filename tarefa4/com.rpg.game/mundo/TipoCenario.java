package mundo;
import personagens.herois.*;

public enum TipoCenario {
    CASTELO_BOWSER("Fortaleza de Bowser", "O ar é pesado com o cheiro de enxofre e malícia."),
    CORREDOR_ASSOMBRADO("Corredor Sombrio", "A temperatura cai drasticamente e sussurros ecoam pelas paredes."),
    CAMARA_ILUSOES("Câmara das Ilusões", "As paredes parecem se contorcer e a realidade se distorce a cada passo.");

    private final String descricao;
    private final String efeito;

    TipoCenario(String descricao, String efeito) {
        this.descricao = descricao;
        this.efeito = efeito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void aplicarEfeitos(Heroi heroi) {
        System.out.println(efeito);
        // IMplementar diferntes efeitos
        heroi.receberDano(5);

    }
}
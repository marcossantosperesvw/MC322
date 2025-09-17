package interfaces;

public interface Combatente {
    String getNome();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    AcaoDeCombate escolherAcao(Combatente alvo);
    int getPontosDeVida(); // Adicionado para facilitar a exibição de status
}
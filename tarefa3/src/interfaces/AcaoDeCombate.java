package interfaces;

public interface AcaoDeCombate {
    void executar(Combatente usuario, Combatente alvo);
    String getNomeAcao();
}
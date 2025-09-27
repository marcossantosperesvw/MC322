package combate;
import personagens.*;
import interfaces.*;
public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Personagem atacante = (Personagem) usuario;
        int dano = atacante.getForca() + atacante.getArma().getDano();
        alvo.receberDano(dano);
        System.out.printf("%s ataca %s com %s causando %d de dano!\n", 
                         usuario.getNome(), alvo.getNome(), 
                         atacante.getArma().getNome(), dano);
    }
    
}

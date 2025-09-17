package jogo.AcaoDeCombate;

import interfaces.AcaoDeCombate;
import interfaces.Combatente;
import jogo.Personagem;

public class AtaqueFisico implements AcaoDeCombate {
    private final String nomeAcao;

    public AtaqueFisico() {
        this.nomeAcao = "Ataque Físico";
    }
    
    @Override
    public String getNomeAcao(){
        return this.nomeAcao;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Personagem) {
            Personagem pUsuario = (Personagem) usuario;
            int danoTotal = pUsuario.getForca() + pUsuario.getArma().getDano();
            
            // Lógica de crítico (mantida do seu código original)
            if (Math.random() > 0.8) {
                danoTotal *= 1.2;
                System.out.printf(">> %s faz um ATAQUE CRÍTICO com %s em %s, causando %d de dano! <<\n",
                    usuario.getNome(), pUsuario.getArma().getNome(), alvo.getNome(), danoTotal);
            } else {
                System.out.printf("%s ataca %s com %s, causando %d de dano.\n",
                    usuario.getNome(), alvo.getNome(), pUsuario.getArma().getNome(), danoTotal);
            }
            
            alvo.receberDano(danoTotal);
            if (!alvo.estaVivo()) {
                 System.out.printf("%s foi derrotado!\n", alvo.getNome());
            }
        }
    }
}
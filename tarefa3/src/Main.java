
import Armas.*;
import interfaces.Fase;
import interfaces.GeradorDeFases;
import jogo.Personagens.*;
import java.util.List;
import jogo.*;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("                    Aventuras de Mario e Yoshi");
        System.out.println("======================================================================\n");
        
        // USAR INTERFACES conforme especificação
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3);
        
        // Criar herói usando interface
        Arma Martelo_Poderoso = new Martelo("Matrtelo do Iniciante", 15, 0);
        Heroi heroi = new Yoshi("Yoshi", 300, 40, Martelo_Poderoso);
        
        System.out.println("Herói criado: " + heroi.getNome());
        heroi.exibirStatus();
        
        // LOOP PRINCIPAL conforme especificação
        for (Fase fase : fases) {
            
            // Iniciar a fase
            fase.iniciar(heroi);
            
            // Verificar se foi concluída
            if (!fase.isConcluida()) {
                System.out.println("\nO herói não conseguiu completar a fase!");
                System.out.println("GAME OVER!");
                return;
            }
            
            System.out.println("Fase concluída com sucesso!");
            
            // Mostrar status após a fase
            System.out.println("\n=== Status após a fase ===");
            heroi.exibirStatus();
        }
        
        // Vitória final
        if (heroi.estaVivo()) {
            System.out.println("\t==========================\t");
            System.out.println("                    VITÓRIA!");
            System.out.println("\t==========================\t");
            System.out.println("Parabéns! Você completou todas as fases!");
            System.out.println("O reino está salvo!");
            heroi.exibirStatus();
        }
    }
}
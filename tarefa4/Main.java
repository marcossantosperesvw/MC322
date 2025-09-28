import mundo.*;
import java.util.*;
import interfaces.*;
import itens.*;
import personagens.herois.*;
import utils.*;
public class Main {
    
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("                    Aventuras de Mario e Yoshi");
        System.out.println("=====================================================================");
        
        // USAR INTERFACES conforme especificação
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        GerenciadorDeInteracao manager = new GerenciadorDeInteracao();
        manager.MenuInicial();
        Dificuldade d = manager.SelecionarDificuldade();
        List<Fase> fases = gerador.gerar(3, d);
        
        // Criar herói usando interface
        Arma Martelo_Poderoso = new Martelo("Matrtelo do Iniciante", 15, 0);
        Arma Lingua = new Lingua("Lingua do Iniciante", 130, 0);
        Heroi[] Array_herois = {new Yoshi("Yoshi", 200000, 40, Lingua), new Mario("Mario", 20000, 50, Martelo_Poderoso)};
        Heroi heroi = manager.selecaoHeroi(Array_herois);
        System.out.println("Herói criado: " + heroi.getNome());
        heroi.exibirStatus();
            
            // LOOP PRINCIPAL conforme especificação
        for (int i = 0; i < 3; i++) {
                
            // Iniciar a fase
            fases.get(i).iniciar(heroi);
            
            // Verificar se foi concluída
            if (!fases.get(i).isConcluida()) {
                System.out.println("\nO herói não conseguiu completar a fase!");
                System.out.println("GAME OVER!");
                return;
            }
            
            System.out.println("Fase concluída com sucesso!");
            // PERMITE ao usuario controle apos a conclusao de uma fase
            if (i <= 1){
                manager.MostrarOpcoes(heroi, fases.get(i+1).getMonstros());

            }
        }   
        
        // Vitória final
        if (heroi.estaVivo()) {
            System.out.println("\t========================== " + "VITÓRIA!" + " ==========================\t");
            System.out.println("Parabéns! Você completou todas as fases!");
            System.out.println("O reino está salvo!");
            heroi.exibirStatus();
        }

    }
}
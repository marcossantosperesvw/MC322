package com.rpglab.game;

import com.rpglab.src.cenario.*;
import com.rpglab.src.personagens.herois.*;
import com.rpglab.src.personagens.monstros.*;
import com.rpglab.src.itens.*;
import com.rpglab.src.util.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("                    TERRAS SOMBRIAS - RPG");
        System.out.println("======================================================================");
        
        try {
            // Usar interfaces conforme especificação
            GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
            GerenciadorDeInteracao manager = new GerenciadorDeInteracao();
            
            // Menu principal
            manager.exibirMenuPrincipal();
            
            // Seleção de dificuldade
            Dificuldade dificuldade = manager.selecionarDificuldade();
            List<Fase> fases = gerador.gerar(3, dificuldade);
            
            // Criar heróis
            Arma marteloPoderoso = new Martelo("Martelo do Iniciante", 15, 0);
            Arma lingua = new Lingua("Língua do Iniciante", 13, 0);
            Heroi[] arrayHerois = {
                new Yoshi("Yoshi", 200, 40, lingua), 
                new Mario("Mario", 200, 50, marteloPoderoso)
            };
            
            Heroi heroi = manager.selecaoHeroi(arrayHerois);
            System.out.println("Herói criado: " + heroi.getNome());
            heroi.exibirStatus();
            InputManager.esperarEnter("Pressione ENTER para começar a aventura...");
            
            // Loop principal do jogo
            for (int i = 0; i < fases.size(); i++) {
                System.out.println("\n" + "=".repeat(60));
                System.out.printf("                    FASE %d DE %d\n", i + 1, fases.size());
                System.out.println("=".repeat(60));
                
                // Iniciar a fase
                fases.get(i).iniciar(heroi);
                
                // Verificar se foi concluída
                if (!fases.get(i).isConcluida()) {
                    System.out.println("\n" + "=".repeat(50));
                    System.out.println("           GAME OVER!");
                    System.out.println("  O herói não conseguiu completar a fase!");
                    System.out.println("=".repeat(50));
                    heroi.exibirStatus();
                    break;
                }
                
                System.out.println("\n" + "=".repeat(50));
                System.out.println("        FASE CONCLUÍDA COM SUCESSO!");
                System.out.println("=".repeat(50));
                
                // Menu pós-turno (exceto na última fase)
                if (i < fases.size() - 1) {
                    manager.menuPosFase(heroi, fases.get(i + 1).getMonstros());
                }
            }
            
            // Verificar vitória final
            if (heroi.estaVivo() && todasFasesConcluidas(fases)) {
                exibirVitoriaFinal(heroi);
            }
            
        } catch (Exception e) {
            System.err.println("Erro inesperado no jogo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            InputManager.fecharScanner();
        }
    }
    
    private static boolean todasFasesConcluidas(List<Fase> fases) {
        return fases.stream().allMatch(Fase::isConcluida);
    }
    
    private static void exibirVitoriaFinal(Heroi heroi) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                     VITÓRIA!");
        System.out.println("=".repeat(60));
        System.out.println("    Parabéns! Você completou todas as fases!");
        System.out.println("           O reino está salvo!");
        System.out.println("=".repeat(60));
        System.out.println("\n--- STATUS FINAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("\n" + "=".repeat(60));
        System.out.println("         Obrigado por jogar!");
        System.out.println("=".repeat(60));
    }
}
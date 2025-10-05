package com.rpglab.game;

import com.rpglab.cenario.*;
import com.rpglab.personagens.herois.*;
import com.rpglab.itens.*;
import com.rpglab.util.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        exibirIntroducao();
        
        try {
            // Usar interfaces conforme especificação
            GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
            GerenciadorDeInteracao manager = new GerenciadorDeInteracao();
            
            // Menu principal com seleção
            manager.menuInicial();
            
            // Narrativa de início
            exibirNarrativaInicio();
            
            // Seleção de dificuldade
            Dificuldade dificuldade = manager.selecionarDificuldade();
            List<Fase> fases = gerador.gerar(3, dificuldade);
            
            // Criação dos heróis
            Arma marteloIniciante = new Martelo("Martelo do Iniciante", 15, 0);
            Arma linguaIniciante = new Lingua("Língua do Iniciante", 13, 0);
            
            Heroi[] arrayHerois = {
                new Yoshi("Yoshi", 200, 40, linguaIniciante), 
                new Mario("Mario", 200, 50, marteloIniciante)
            };
            
            // Seleção do herói
            Heroi heroi = manager.selecaoHeroi(arrayHerois);
            
            // Narrativa pós-seleção
            exibirNarrativaPosSelecao(heroi);
            heroi.exibirStatus();
            
            InputManager.esperarEnter("\nPressione ENTER para começar a aventura...");
            
            // Loop principal das fases
            for (int i = 0; i < fases.size(); i++) {
                exibirInicioFase(i + 1, fases.size());
                
                // Iniciar a fase
                fases.get(i).iniciar(heroi);
                
                // Verificar se foi concluída
                if (!fases.get(i).isConcluida()) {
                    exibirGameOver(heroi);
                    return;
                }
                
                // Narrativa pós-fase
                exibirSucessoFase(i + 1);
                
                // Mostrar status após a fase
                System.out.println("\n=== STATUS APÓS A FASE ===");
                heroi.exibirStatus();
                
                // Menu pós-fase (exceto na última)
                if (i < fases.size() - 1) {
                    InputManager.esperarEnter("Pressione ENTER para continuar...");
                    manager.statusPosTurno(heroi, fases.get(i + 1).getMonstros().get(0).getArma());
                }
            }
            
            // Verificar vitória final
            if (heroi.estaVivo() && todasFasesConcluidas(fases)) {
                exibirVitoriaFinal(heroi);
            }
            
        } catch (Exception e) {
            System.err.println("\n💀 ERRO CRÍTICO: O tecido da realidade se rompeu!");
            System.err.println("Detalhes do erro: " + e.getMessage());
            System.err.println("A aventura foi interrompida por forças misteriosas...");
        } finally {
            InputManager.fecharScanner();
        }
    }
    
    private static void exibirIntroducao() {
        System.out.println("======================================================================");
        System.out.println("                    🏰 TERRAS SOMBRIAS - RPG 🏰");
        System.out.println("                  Aventuras de Mario e Yoshi");
        System.out.println("======================================================================");
        System.out.println();
    }
    
    private static void exibirNarrativaInicio() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                        📖 A LENDA COMEÇA 📖");
        System.out.println("=".repeat(70));
        System.out.println();
        System.out.println("Há muito tempo, nas terras distantes do Reino Cogumelo, uma sombra");
        System.out.println("maligna começou a se espalhar. O terrível Bowser, Rei dos Koopas,");
        System.out.println("reuniu seus servos mais leais e tomou o controle de três fortalezas");
        System.out.println("místicas que protegem o equilíbrio do mundo.");
        System.out.println();
        System.out.println("A Princesa Peach enviou um chamado desesperado aos maiores heróis");
        System.out.println("do reino. Apenas Mario, o lendário encanador, e Yoshi, o corajoso");
        System.out.println("dinossauro, responderam ao chamado.");
        System.out.println();
        System.out.println("A jornada será perigosa... Apenas um herói poderá enfrentar esta");
        System.out.println("ameaça e restaurar a paz ao Reino Cogumelo!");
        System.out.println();
        System.out.println("=".repeat(70));
    }
    
    private static void exibirNarrativaPosSelecao(Heroi heroi) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                      ⚔️ O HERÓI ESCOLHIDO ⚔️");
        System.out.println("=".repeat(70));
        System.out.println();
        
        if (heroi.getNome().equals("Mario")) {
            System.out.println("Mario ajusta seu chapéu vermelho e empunha seu fiel martelo.");
            System.out.println("'Mama mia! É hora de salvar o reino mais uma vez!'");
            System.out.println();
            System.out.println("Com seus anos de experiência salvando a Princesa Peach,");
            System.out.println("Mario está pronto para enfrentar qualquer desafio!");
        } else {
            System.out.println("Yoshi bate suas asas e prepara sua língua extensível.");
            System.out.println("'Yoshi! Vamos mostrar a esses vilões do que somos capazes!'");
            System.out.println();
            System.out.println("Ágil e corajoso, Yoshi está determinado a proteger");
            System.out.println("seus amigos e restaurar a paz ao reino!");
        }
        
        System.out.println();
        System.out.println("=== STATUS INICIAL DO HERÓI ===");
    }
    
    private static void exibirInicioFase(int faseAtual, int totalFases) {
        System.out.println("\n" + "=".repeat(70));
        System.out.printf("                    ⚡ FASE %d DE %d ⚡\n", faseAtual, totalFases);
        System.out.println("=".repeat(70));
        
        switch (faseAtual) {
            case 1:
                System.out.println();
                System.out.println("🌙 Nosso herói se aproxima do primeiro desafio...");
                System.out.println("Os corredores sombrios ecoam com sussurros fantasmagóricos.");
                System.out.println("É hora de provar sua coragem contra os servos de Bowser!");
                break;
            case 2:
                System.out.println();
                System.out.println("🔮 A jornada continua pela Câmara das Ilusões...");
                System.out.println("A realidade se distorce ao redor do herói.");
                System.out.println("Inimigos mais poderosos aguardam nas sombras!");
                break;
            case 3:
                System.out.println();
                System.out.println("🔥 Finalmente, o Castelo de Bowser se ergue à frente!");
                System.out.println("Esta é a batalha final que decidirá o destino do reino.");
                System.out.println("O Rei dos Koopas aguarda... Que a batalha épica comece!");
                break;
        }
        System.out.println();
    }
    
    private static void exibirSucessoFase(int fase) {
        System.out.println("\n" + "🎉".repeat(20));
        System.out.printf("          FASE %d CONCLUÍDA COM SUCESSO!\n", fase);
        System.out.println("🎉".repeat(20));
        System.out.println();
        
        switch (fase) {
            case 1:
                System.out.println("Os fantasmas recuam para as sombras!");
                System.out.println("O primeiro dos três selos foi quebrado.");
                break;
            case 2:
                System.out.println("As ilusões se desfazem diante da determinação do herói!");
                System.out.println("O segundo selo foi destruído.");
                break;
            case 3:
                System.out.println("Bowser foi derrotado e seu poder sombrio se dissipa!");
                System.out.println("O último selo foi quebrado!");
                break;
        }
    }
    
    private static void exibirGameOver(Heroi heroi) {
        System.out.println("\n" + "💀".repeat(25));
        System.out.println("                    GAME OVER");
        System.out.println("💀".repeat(25));
        System.out.println();
        System.out.println("As forças das trevas prevaleceram...");
        System.out.println("O herói lutou bravamente, mas não foi suficiente.");
        System.out.println("O Reino Cogumelo permanecerá nas sombras...");
        System.out.println();
        System.out.println("=== STATUS FINAL ===");
        heroi.exibirStatus();
        System.out.println("\n🔄 Tente novamente para mudar o destino do reino!");
    }
    
    private static boolean todasFasesConcluidas(List<Fase> fases) {
        return fases.stream().allMatch(Fase::isConcluida);
    }
    
    private static void exibirVitoriaFinal(Heroi heroi) {
        System.out.println("\n" + "🏆".repeat(25));
        System.out.println("                     VITÓRIA ÉPICA!");
        System.out.println("🏆".repeat(25));
        System.out.println();
        System.out.println("🎊 PARABÉNS! Você completou todas as fases! 🎊");
        System.out.println();
        System.out.println("Com coragem e determinação, nosso herói conseguiu derrotar");
        System.out.println("todos os servos de Bowser e quebrar os três selos sombrios!");
        System.out.println();
        System.out.println("A luz voltou a brilhar sobre o Reino Cogumelo!");
        System.out.println("A Princesa Peach e todos os habitantes estão salvos!");
        System.out.println();
        System.out.println("🌟 O reino está salvo graças à sua bravura! 🌟");
        System.out.println();
        System.out.println("=== STATUS FINAL DO HERÓI VITORIOSO ===");
        heroi.exibirStatus();
        System.out.println();
        System.out.println("🎮 Obrigado por jogar Terras Sombrias - RPG! 🎮");
        System.out.println("✨ Que esta vitória seja lembrada para sempre! ✨");
        System.out.println();
        System.out.println("=".repeat(70));
    }
}
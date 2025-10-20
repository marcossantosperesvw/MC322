package com.rpglab.game;

import com.rpglab.game.cenario.*;
import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.itens.*;
import com.rpglab.game.util.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        exibirIntroducao();
        
        try {
            GerenciadorDeInteracao manager = new GerenciadorDeInteracao();
            Batalha batalha = null;
            
            // Verificar se existe save disponível
            boolean existeSave = GerenciadorDePersistencia.existeSaveDisponivel();
            
            // Menu principal
            int opcaoMenu = manager.menuInicial(existeSave);
            
            if (opcaoMenu == 1) {
                // Iniciar novo jogo
                batalha = iniciarNovaAventura(manager);
            } else if (opcaoMenu == 2) {
                // Tentar carregar jogo salvo (se disponível)
                if (existeSave) {
                    String nomeSave = GerenciadorDePersistencia.getNomeSavePadrao();
                    batalha = Batalha.carregarJogo(nomeSave);

                    if (batalha == null) {
                        System.out.println("Erro ao carregar o save. Iniciando novo jogo...");
                        batalha = iniciarNovaAventura(manager);
                    } else {
                        System.out.println("\n=== JOGO CARREGADO ===");
                        System.out.printf("Fase atual: %d/%d\n", 
                                        batalha.getFaseAtual() + 1, 
                                        batalha.getFases().size());
                        batalha.getHeroi().exibirStatus();
                        InputManager.esperarEnter("\nPressione ENTER para continuar a aventura...");

                        // Verificar se todas as fases foram concluídas
                        if (batalha.getFaseAtual() >= batalha.getFases().size()) {
                            System.out.println("Este save já completou todas as fases!");
                            System.exit(0);
                        }
                    }
                } else {
                    // Caso não exista save, essa opção nunca deveria ser retornada como 2
                    // Mas por segurança, iniciar novo jogo
                    batalha = iniciarNovaAventura(manager);
                }
            } else if (opcaoMenu == 3) {
                // Sair do jogo
                System.out.println("Obrigado por jogar!");
                System.exit(0);
            }
            
            // Executar o loop de fases
            if (batalha != null) {
                while (batalha.getFaseAtual() < batalha.getFases().size() && 
                       batalha.getHeroi().estaVivo()) {
                    batalha.executarProxFase();
                    // Dar uma pequena pausa entre as fases para melhor leitura
                    if (batalha.getHeroi().estaVivo() && batalha.getFaseAtual() < batalha.getFases().size()) {
                        InputManager.esperarEnter("\nPressione ENTER para continuar para a próxima fase...");
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("\n💀 ERRO CRÍTICO: O tecido da realidade se rompeu!");
            System.err.println("Detalhes do erro: " + e.getMessage());
            System.err.println("A aventura foi interrompida por forças misteriosas...");
            e.printStackTrace();
        } finally {
            InputManager.fecharScanner();
        }
    }
    
    /**
     * Inicia uma nova aventura do zero.
     * @param manager Gerenciador de interação com o jogador
     * @return Nova instância de Batalha configurada
     */
    private static Batalha iniciarNovaAventura(GerenciadorDeInteracao manager) {
        // Narrativa de início
        exibirNarrativaInicio();
        
        // Seleção de dificuldade
        Dificuldade dificuldade = manager.selecionarDificuldade();
        
        // Gerar fases
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3, dificuldade);
        
        // Seleção do herói
        Heroi heroi = manager.selecaoHeroi();
        
        // Narrativa pós-seleção
        exibirNarrativaPosSelecao(heroi);
        heroi.exibirStatus();
        
        InputManager.esperarEnter("\nPressione ENTER para começar a aventura...");
        
        // Criar e retornar a batalha
        return new Batalha(heroi, fases, dificuldade);
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
}
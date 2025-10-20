package com.rpglab.game.util;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;
import java.util.*;
import com.rpglab.game.exceptions.NivelInsuficiente;
import com.rpglab.game.itens.*;
import com.rpglab.game.cenario.*;

public class GerenciadorDeInteracao {
    // Lista centralizada de classes de monstros para exibição de informações
    private static final Class<? extends com.rpglab.game.personagens.monstros.Monstro>[] MONSTRO_CLASSES = new Class[] {
        com.rpglab.game.personagens.monstros.Bowser.class,
        com.rpglab.game.personagens.monstros.Kamek.class,
        com.rpglab.game.personagens.monstros.King_Boo.class,
        com.rpglab.game.personagens.monstros.Koopalings.class
    };
                    
    public int mostrarOpcoes(Heroi heroi, List<Monstro> monstros) {
        int opcao = 0;
        while (opcao != 1) {
            System.out.println("==============================================");
            System.out.println("             Aventuras de Mario e Yoshi");
            System.out.println("==============================================");
            String opcoesMenu = "\n[1] Continuar\n"
                    + "[2] Ver informações das classes de Heróis\n"
                    + "[3] Ver informações das classes de Monstros\n"
                    + "[4] Sair do Jogo\n";
            
            opcao = InputManager.lerInteiro(opcoesMenu + "Escolha uma opção", 1, 4);
            
            switch (opcao) {
                case 1:
                    // Continuar - sai do loop
                    break;
                case 2:
                    // Mostrar informações sobre os heróis
                    System.out.println("\n--- Informações do Herói ---");
                    heroi.exibirStatus();
                    InputManager.esperarEnter("Pressione ENTER para continuar");
                    break;
                case 3:
                    // Mostrar informações sobre os vilões
                    System.out.println("\n--- Informações dos Monstros ---");
                    for (Monstro monstro : monstros) {
                        monstro.exibirStatus();
                        InputManager.esperarEnter("Pressione ENTER para verificar informações do próximo monstro");
                    }
                    InputManager.esperarEnter("Pressione ENTER para continuar");
                    break;
                case 4:
                    // Sair
                    System.out.println("Fim de jogo!");
                    System.exit(0);
                    break;
            }
        }
        return 0;
    }
    
    /**
     * Menu inicial com opção de carregar jogo se existir save.
     * @param existeSave Indica se há um save disponível
     * @return 1 para novo jogo, 2 para carregar, 3 para sair
     */
    public int menuInicial(boolean existeSave) {
        System.out.println("=== BEM-VINDO AO JOGO ===");
        // Menu interativo que permite visualizar informações antes de iniciar/carregar
        while (true) {
            String opcoes;
            if (existeSave) {
                opcoes = "[1] Iniciar Novo Jogo\n"
                        + "[2] Ver Informações das Classes de Heróis\n"
                        + "[3] Ver Informações das Classes de Monstros\n"
                        + "[4] Carregar Jogo\n"
                        + "[5] Sair do Jogo\n";
            } else {
                opcoes = "[1] Iniciar Novo Jogo\n"
                        + "[2] Ver Informações das Classes de Heróis\n"
                        + "[3] Ver Informações das Classes de Monstros\n"
                        + "[4] Sair do Jogo\n";
            }

            int max = existeSave ? 5 : 4;
            int escolha = InputManager.lerInteiro(opcoes + "Escolha uma opção", 1, max);

            // Tratar as opções de informação localmente
            if (escolha == 2) {
                // Mostrar informações dos heróis (exemplo resumido)
                System.out.println("\n=== INFORMAÇÕES: HERÓIS ===");
                Heroi exemploYoshi = new Yoshi("Yoshi (exemplo)", 200, 40, new Lingua("Língua", 20, 0));
                Heroi exemploMario = new Mario("Mario (exemplo)", 200, 50, new Martelo("Martelo", 30, 0));
                System.out.println("\n-- Yoshi --");
                exemploYoshi.exibirStatus();
                System.out.println("Habilidade: Atordoar (Yoshi)\nDescrição: Atordoa por um turno.");
                System.out.println("\n-- Mario --");
                exemploMario.exibirStatus();
                System.out.println("Habilidade: Cogumelo (Mario)\nDescrição: Recupera vida instantaneamente.");
                InputManager.esperarEnter("Pressione ENTER para voltar ao menu...");
                continue;
            }

            if (escolha == 3) {
                // Mostrar informações dos monstros (todas as classes conhecidas)
                System.out.println("\n=== INFORMAÇÕES: MONSTROS ===");
                for (Class<? extends com.rpglab.game.personagens.monstros.Monstro> cls : MONSTRO_CLASSES) {
                    try {
                        com.rpglab.game.personagens.monstros.Monstro exemplo = cls.getDeclaredConstructor().newInstance();
                        System.out.println("\n-- " + cls.getSimpleName() + " --");
                        exemplo.exibirStatus();
                    } catch (Exception e) {
                        System.out.printf("Erro ao instanciar %s: %s\n", cls.getSimpleName(), e.getMessage());
                    }
                    InputManager.esperarEnter("Pressione ENTER para continuar...");
                }
                InputManager.esperarEnter("Pressione ENTER para voltar ao menu...");
                continue;
            }

            // Se chegou aqui, a escolha não é uma opção informativa: mapear para ação
            if (existeSave) {
                if (escolha == 1) return 1;           // Novo jogo
                if (escolha == 4) return 2;           // Carregar jogo
                if (escolha == 5) return 3;           // Sair
            } else {
                if (escolha == 1) return 1;           // Novo jogo
                if (escolha == 4) return 3;           // Sair
            }
        }
    }
    public Heroi selecaoHeroi() {
        System.out.println("\n=== SELEÇÃO DE HERÓI ===");
        String opcoes = "\n[1] Yoshi\n[2] Mario\n";
        Heroi heroiSelecionado;
        int posicao = InputManager.lerInteiro(opcoes + "Escolha seu herói", 1, 2);
        if (posicao ==1){
            Arma linguaIniciante = new Lingua("Lingua do iniciante", 20, 0);
            heroiSelecionado = new Yoshi("Yoshi", 200, 40, linguaIniciante);
        } else {
            Arma marteloIniciante = new Martelo("Martelo do iniciante", 30, 0);
            heroiSelecionado = new Mario("Mario", 200, 50, marteloIniciante);
        }
        return heroiSelecionado;
    }
    
    /**
     * Exibe um menu para o jogador selecionar a dificuldade do jogo.
     * @return A enumeração Dificuldade escolhida pelo jogador.
     */
    public Dificuldade selecionarDificuldade() {
        System.out.println("\n=== SELEÇÃO DE DIFICULDADE ===");
        String opcoes = "[1] FÁCIL\n[2] MÉDIO\n[3] DIFÍCIL\n";

        int input = InputManager.lerInteiro(opcoes + "Escolha a dificuldade", 1, 3);
        
        Dificuldade dificuldadeSelecionada;
        switch (input) {
            case 1:
                dificuldadeSelecionada = Dificuldade.FACIL;
                break;
            case 2:
                dificuldadeSelecionada = Dificuldade.MEDIO;
                break;
            case 3:
                dificuldadeSelecionada = Dificuldade.DIFICIL;
                break;
            default:
                // Fallback para fácil
                dificuldadeSelecionada = Dificuldade.FACIL;
                break;
        }
        
        System.out.printf("Dificuldade selecionada: %s\n", dificuldadeSelecionada.name());
        return dificuldadeSelecionada;
    }
    
    public void statusPosTurno(Heroi heroi, Arma armaDropada) {
        if (armaDropada == null) {
            System.out.println("Nenhum item foi dropado.");
            return;
        }
        
        int input = 0;
        while (input != 4) {
            System.out.println("\n=== GERENCIAMENTO DE ITENS ===");
            String opcoes = "[1] Ver Arma do Herói\n[2] Ver Arma Dropada\n[3] Trocar de Arma\n[4] Continuar\n[5] Desistir\n";
            input = InputManager.lerInteiro(opcoes + "Escolha uma opção", 1, 5);
            
            switch (input) {
                case 1:
                    mostrarArmaHeroi(heroi);
                    break;
                case 2:
                    mostrarArmaDropada(armaDropada);
                    break;
                case 3:
                    tentarTrocarArma(heroi, armaDropada);
                    break;
                case 4:
                    // Continuar - sai do loop
                    break;
                case 5:
                    confirmarDesistencia();
                    break;
            }
        }
    }
    
    private void mostrarArmaHeroi(Heroi heroi) {
        Arma arma = heroi.getArma();
        if (arma != null) {
            System.out.printf("\n--- Arma do Herói ---\nNome: %s\nDano: %d\nNível Mínimo: %d\n", 
                            arma.getNome(), arma.getDano(), arma.getMinNivel());
        } else {
            System.out.println("O herói não possui arma equipada.");
        }
    }
    
    private void mostrarArmaDropada(Arma armaDropada) {
        System.out.printf("\n--- Arma Encontrada ---\nNome: %s\nDano: %d\nNível Mínimo: %d\n", 
        armaDropada.getNome(), armaDropada.getDano(), armaDropada.getMinNivel());
    }
    
    private void tentarTrocarArma(Heroi heroi, Arma armaDropada) {
        try {
            Arma armaAtual = heroi.getArma();
            heroi.equiparArma(armaDropada);
            
            // Se chegou aqui, a troca foi bem-sucedida
            if (armaAtual != null && armaAtual.getDano() >= armaDropada.getDano()) {
                System.out.println("Você manteve sua arma atual (era melhor ou igual).");
            }
        } catch (NivelInsuficiente e) {
            System.out.printf("ERRO: %s [nível %d] não possui nível suficiente para equipar %s [nível mínimo: %d]\n", 
                            heroi.getNome(), heroi.getNivel(), armaDropada.getNome(), armaDropada.getMinNivel());
        } catch (Exception e) {
            System.out.printf("Erro ao equipar arma: %s\n", e.getMessage());
        }
    }
    
    private void confirmarDesistencia() {
        boolean confirmacao = InputManager.lerSimNao("Tem certeza de que deseja desistir do jogo? (s/n)");
        if (confirmacao) {
            System.out.println("Você desistiu do jogo. Fim de jogo!");
            System.exit(0);
        }
    }
}
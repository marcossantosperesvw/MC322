package utils;
import personagens.herois.*;
import personagens.monstros.*;
import java.util.*;

import exceptions.NivelInsuficiente;
import mundo.*;
import itens.*;
public class GerenciadorDeInteracao {
    String opcoes = "\n[1] Continuar\n"
    + "[2] Ver informacoes das classes de Herois\n"
    + "[3] Ver informacoes das classes de Monstros\n"
    + "[4] Sair do Jogo\n";
                    
    public int MostrarOpcoes(Heroi h, List<Monstro> Array_monstros){
        int num = 0;
        while (num != 1){
            System.out.printf("==============================================\n             Aventuras de Mario e Yoshi\n==============================================");
            System.out.print(opcoes);
            num = InputManager.LerInteiro("Escolha uma opção", 1, 4);
            if (num == 2){
                // MOSTRAR informacoes sobre os HEROIS
                h.exibirStatus();
                InputManager.esperarEnter("Pressione ENTER para continuar");
            }
            else if (num == 3){
                // MOSTRAR informacoes sobre os VILOES
                for (Monstro m : Array_monstros){
                    m.exibirStatus();
                    InputManager.esperarEnter("Pressione ENTER para verificar informacoes do proximo monstro");
                }
                InputManager.esperarEnter("Pressione ENTER para continuar");
            }
            else if (num == 4){
                // SAIR
                System.out.println("Fim de jogo\n");
            }

        }
        return 0;
    
    }
    public void MenuInicial(){
        String opcoes = "[1] Iniciar Novo Jogo\n"
                    + "[2] Sair do Jogo\n";

        int num = InputManager.LerInteiro(opcoes, 1, 2);
             
        if (num == 2){
            System.exit(1);
        }
    }
    public Heroi selecaoHeroi(Heroi[] array_herois){
        String opcoes = "\n[1] Yoshi\n"
                    + "[2] Mario\n";

        int pos = InputManager.LerInteiro(opcoes, 1, 2);
        return array_herois[pos-1];

    }
    public Dificuldade SelecionarDificuldade(){
        System.out.println("Selecao de dificuldade");
        String opcoes = "[1] FACIL\n"
                        + "[2] MEDIO\n"
                        + "[3] DIFICIL\n";

        int input = InputManager.LerInteiro(opcoes, 1, 3);
        if (input == 1){
            return Dificuldade.FACIL;
        }
        else if (input == 2){
            return Dificuldade.MEDIO;
        }
        else if (input == 3){
            return Dificuldade.DIFICIL;
        } else {
            // Caso o usuario nao selecione a dificuldade adequadaemnte, ela vai automaticamente para facil
            return Dificuldade.FACIL;
        }
    }
    public void StatusPosTurno(Heroi h, Arma arma_dropada){
        int input = 0;
        while (input != 4){
            String opcoes = "[1] Arma do Heroi\n[2] Arma Dropada\n[3] Trocar de Arma\n[4] Continuar\n[5] Desistir\n";
            input = InputManager.LerInteiro(opcoes, 1, 5);
            if (input == 1){
                System.out.printf("Arma do heroi: %s\nDano: %d\n", h.getArma().getNome(), h.getArma().getDano());
                
                
            }
            else if (input == 2){
                System.out.printf("Arma do Chao: %s\nDano: %d\nNivel Minimo: %d\n", arma_dropada.getNome(), arma_dropada.getDano(), arma_dropada.getMinNivel());

            }
            else if (input == 3){
                try{
                    h.equiparArma(arma_dropada);
                } catch (NivelInsuficiente e){

                    System.out.printf("%s[lvl = %d] nao possui nivel suficiente para equipar %s[lvl = %d]", h.getNome(), h.getNivel(), arma_dropada.getNome(), arma_dropada.getMinNivel());
                }

            }
            else if (input == 5){
                String mensagem = "Tem certeza de que deseja desistir do jogo? (s/n)\n";
                boolean in = InputManager.lerSimNao(mensagem);
                if (in == true){
                    System.out.printf("Derrota por desistencia\n");
                    System.exit(1);

                } 

                
            }
        }


        

        
    }

}   

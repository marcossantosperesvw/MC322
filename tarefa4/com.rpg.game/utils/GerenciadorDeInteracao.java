package utils;
public class GerenciadorDeInteracao {
    String opcoes = "[1] Iniciar Novo Jogo\n"
                    + "[2] Ver informacoes das classes de Herois\n"
                    + "[3] Ver informacoes das classes de Monstros\n"
                    + "[4] Sair do Jogo\n";

    public int MostrarOpcoes(){
        while(true){
            System.out.print(opcoes);
            int num = InputManager.LerInteiro("Escolha uma opção", 1, 4);
            if (num == 1){
                // INICIAR novo jogo
            }
            else if (num == 2){
                // MOSTRAR informacoes sobre os HEROIS
            }
            else if (num == 3){
                // MOSTRAR informacoes sobre os VILOES
            }
            else if (num == 4){
                // SAIR
            }
        }
    }

}   

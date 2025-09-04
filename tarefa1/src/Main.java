import jogo.*;
import jogo.Personagens.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Mario mario = new Mario("Mario", 100, 60);
        Yoshi yoshi = new Yoshi("Yoshi", 40, 30);
        // indica qual personagem esta vivo
        Monstro array_monstros[] = {
            new King_Boo("King Boo", 120, 40, 100),
            new Kamek("Kamek", 80, 40, 100),
            new Bowser("Bowser", 180, 50, 100)
        };

        System.out.println("Em uma terra mágica chamada Reino dos Cogumelos...");
        System.out.println("Mario é convodado pelo seu Rei, o Rei Toadstool\n");
        System.out.println("Rei Toadstool: Mario, a Princesa Peach foi sequestrada por Bowser novamente!");
        System.out.println("Mario e Yoshi partem em uma jornada para resgatar a Princesa Peach!");
        System.out.println("Eles precisam atravessar o castelo assombrado de Bowser...\n");


        // Primeira batalha - King Boo
        System.out.println("=== PRIMEIRO DESAFIO: King Boo aparece! ===");
        turno(yoshi, mario, array_monstros[0]);
        
        
        System.out.println("\n King Boo foi derrotado...\n");
        // Segunda batalha - Kamek
        System.out.println("=== SEGUNDO DESAFIO: Kamek bloqueia o caminho! ===");
        turno(yoshi, mario, array_monstros[1]);
        System.out.println("\nKamek foi derrotado! Chegou a hora da batalha final...\n");
        
        // Batalha Final - Bowser
        System.out.println("=== BATALHA FINAL: Bowser, o Rei dos Koopas! ===");
        turno(yoshi,mario, array_monstros[2]);
        System.out.println("Bowser: Vocês nunca levarão a Princesa Peach!");


        System.out.println("\n=== O FIM DA JORNADA ===");
        System.out.println("Com o sacrifício de Yoshi, Bowser foi finalmente derrotado!");
        System.out.println("Mario corre para salvar a Princesa Peach...");
        System.out.println("Princesa Peach: Meu herói! Você me salvou novamente!");
        System.out.println("\nE assim, mais uma vez, o Reino dos Cogumelos foi salvo graças à bravura de Mario e ao sacrifício do leal Yoshi.");
    }

    public static void turno(Yoshi yoshi, Mario mario, Monstro alvo){
        System.out.printf("\nIniciando batalha contra %s!\n", alvo.getNome());

        while(alvo.isAlive() && (yoshi.isAlive() || mario.isAlive())){
            // O jogo so continua se o monstro estiver vivo juntamente com um heroi
            if(!yoshi.isAlive() && !mario.isAlive()){
                System.out.println("Todos os heróis foram derrotados! Game Over!");
                break;
            }

            System.out.println("\n===Vez dos heróis!===");
            // Mario ataca primeiro por ser mais forte
            if(mario.isAlive()){
                mario.TurnoMario(alvo);

                if(!alvo.isAlive()){
                    break;
                }
            }
            
            if(yoshi.isAlive()){
                yoshi.TurnoYoshi(alvo);

                if(!alvo.isAlive()){
                    break;
                }
            }
            // Implementacao da fase de ataque do monstro
            if(!alvo.getAtordoado()){
                System.out.printf("\n===Vez de %s atacar!===\n", alvo.getNome());
                if(yoshi.isAlive()){
                    // Monstro ataca sempre ataca Yoshi primeiro
                    alvo.atacar(yoshi);
                } else if(mario.isAlive()){
                    alvo.atacar(mario);
                }
            } else {
                System.out.printf("\n%s está atordoado e perde seu turno!\n", alvo.getNome());
                // Monstro perde efeito de atordoamento
                alvo.setAtordoado(false); 
            }
            
        }
    }
}
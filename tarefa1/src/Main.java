import jogo.*;
import jogo.Personagens.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Mario mario = new Mario("Mario", 150, 50);
        Yoshi yoshi = new Yoshi("Yoshi", 75, 40);
        Monstro array_monstros[] = {
            new King_Boo("King Boo", 100, 20, 100),
            new Kamek("Kamek", 80, 15, 100),
            new Bowser("Bowser", 120, 25, 100)
        };

        System.out.println("Numa terra encantada conhecida como Reino dos Cogumelos...");
        System.out.println("Uma terrível notícia ecoa por todas as terras: a Princesa Peach foi sequestrada novamente!");
        System.out.println("Mario, o destemido encanador de bigode majestoso, não hesita em aceitar o desafio.");
        System.out.println("Seu fiel companheiro Yoshi, o dinossauro de coração valente, se junta à missão.");
        System.out.println("Juntos, eles devem enfrentar o temido castelo de Bowser, que contém três desafios escondidos...");

        // Primeira batalha - King Boo
        System.out.println("=== PRIMEIRO DESAFIO: King Boo aparece! ===");
        while (array_monstros[0].getPontos_de_vida() > 0){
            yoshi.TurnoYoshi(array_monstros[0]);
            if (array_monstros[0].getPontos_de_vida() > 0){
                array_monstros[0].atacar(yoshi);
            }

            if (yoshi.getPontos_de_vida() <= 0){
                System.out.println("Yoshi foi derrotado! Mario deve continuar sozinho...");
                break;
            }
        }
        // Segunda batalha - Kamek
        System.out.println("=== SEGUNDO DESAFIO: Kamek aparece! ===");
        while (array_monstros[1].getPontos_de_vida() > 0){
            yoshi.TurnoYoshi(array_monstros[1]);
            if (array_monstros[1].getPontos_de_vida() > 0){
                array_monstros[1].atacar(yoshi);
            }
            if (yoshi.getPontos_de_vida() <= 0){
                System.out.println("Yoshi foi derrotado! Mario deve continuar sozinho...");
                break;
            }
        }
        // Terceira batalha - Bowser
        System.out.println("=== TERCEIRO DESAFIO: Bowser aparece! ===");
        while (array_monstros[2].getPontos_de_vida() > 0){
            yoshi.TurnoYoshi(array_monstros[2]);
            if (array_monstros[2].getPontos_de_vida() > 0){
                array_monstros[2].atacar(yoshi);
            }
            if (yoshi.getPontos_de_vida() <= 0){
                System.out.println("Yoshi foi derrotado! Mario deve continuar sozinho...");
                break;
            }
        }

        System.out.println("\n=== O FIM DA JORNADA ===");
        System.out.println("Com o sacrifício de Yoshi, Bowser foi finalmente derrotado!");
        System.out.println("Mario corre para salvar a Princesa Peach...");
        System.out.println("Princesa Peach: Meu herói! Você me salvou novamente!");
        System.out.println("\nE assim, mais uma vez, o Reino dos Cogumelos foi salvo graças à bravura de Mario e ao sacrifício do leal Yoshi.");
    }
}

import jogo.*;
import jogo.Personagens.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Heroi array_herois[] = {
            new Mario("Mario", 150, 50),
            new Yoshi("Yoshi", 75, 40)
        };
        Monstro array_monstros[] = {
            new King_Boo("King Boo", 100, 20, 50),
            new Kamek("Kamek", 80, 15, 30),
            new Bowser("Bowser", 120, 30, 70)
        };

        System.out.println("Em uma terra mágica chamada Reino dos Cogumelos...");
        System.out.println("Mario é convodado pelo seu Rei, o Rei Toadstool\n");
        System.out.println("Rei Toadstool: Mario, a Princesa Peach foi sequestrada por Bowser novamente!");
        System.out.println("Mario e Yoshi partem em uma jornada para resgatar a Princesa Peach!");
        System.out.println("Eles precisam atravessar o castelo assombrado de Bowser...\n");


        // Primeira batalha - King Boo
        System.out.println("=== PRIMEIRO DESAFIO: King Boo aparece! ===");
        while (array_monstros[0].getPontos_de_vida() > 0 && array_herois[0].getPontos_de_vida() > 0) {
            array_herois[0].atacar(array_monstros[0]);
            array_herois[1].atacar(array_monstros[0]);
            
            if (array_monstros[0].getPontos_de_vida() > 0) {
                array_monstros[0].atacar(array_herois[0]);
            }
        }
        array_herois[0].ganharExperiencia(array_monstros[0].getXpConcedido());
        System.out.println("\nKing Boo foi derrotado! A jornada continua...\n");

        // Segunda batalha - Kamek
        System.out.println("=== SEGUNDO DESAFIO: Kamek bloqueia o caminho! ===");
        if (((Mario)array_herois[0]).getCogumelo() > 0) {
            System.out.println("Mario usa seu cogumelo mágico para fortalecer-se!");
            array_herois[0].usarHabilidadeEspecial();
        }
        
        while (array_monstros[1].getPontos_de_vida() > 0 && array_herois[0].getPontos_de_vida() > 0) {
            array_herois[0].atacar(array_monstros[1]);
            array_herois[1].atacar(array_monstros[1]);
            
            if (array_monstros[1].getPontos_de_vida() > 0) {
                array_monstros[1].atacar(array_herois[1]);
            }
        }
        array_herois[0].ganharExperiencia(array_monstros[1].getXpConcedido());
        System.out.println("\nKamek foi derrotado! Chegou a hora da batalha final...\n");

        // Batalha Final - Bowser
        System.out.println("=== BATALHA FINAL: Bowser, o Rei dos Koopas! ===");
        System.out.println("Bowser: Vocês nunca levarão a Princesa Peach!");
        
        while (array_monstros[2].getPontos_de_vida() > 0 && (array_herois[0].getPontos_de_vida() > 0 || array_herois[1].getPontos_de_vida() > 0)) {
            array_herois[0].atacar(array_monstros[2]);
            
            if (((Yoshi)array_herois[1]).getAtordoar() > 0) {
                System.out.println("\nYoshi: Mario, meu amigo... Este é meu último presente para você!");
                array_herois[1].usarHabilidadeEspecial();
                array_herois[1].atacar(array_monstros[2]);
                System.out.println("Yoshi se sacrifica em um último ataque heroico!");
                break;
            }
            
            if (array_monstros[2].getPontos_de_vida() > 0) {
                array_monstros[2].atacar(array_herois[0]);
            }
        }

        System.out.println("\n=== O FIM DA JORNADA ===");
        System.out.println("Com o sacrifício de Yoshi, Bowser foi finalmente derrotado!");
        System.out.println("Mario corre para salvar a Princesa Peach...");
        System.out.println("Princesa Peach: Meu herói! Você me salvou novamente!");
        System.out.println("\nE assim, mais uma vez, o Reino dos Cogumelos foi salvo graças à bravura de Mario e ao sacrifício do leal Yoshi.");
    }
}

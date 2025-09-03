import jogo.*;
import jogo.Personagens.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Heroi array_herois[] = {
            new Mario ("Mario", 150, 50),
            new Yoshi ("Yoshi", 75, 40)
        };
        Monstro array_monstros[] = {
            new King_Boo("King Boo", 100, 20, 50),
            new Kamek("Kamek", 80, 15, 30),
            new Bowser("Bowser", 120, 30, 70)
        };

        System.out.printf("O NOSSO HERÓI ENTROU NO CASTELO DO BOWSER E DEVERÁ ENRENTRAR TRÊS DESAFIOS");
    }

    
}

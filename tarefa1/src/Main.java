import jogo.*;
import jogo.Personagens.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Mario mario = new Mario("Mario", 100, 60);
        Yoshi yoshi = new Yoshi("Yoshi", 40, 30);
        // indica qual personagem esta vivo
        Monstro array_monstros[] = {
            new King_Boo("King Boo", 120, 40, 125),
            new Kamek("Kamek", 80, 40, 175),
            new Bowser("Bowser", 180, 50, 200)
        };

        // --- INÍCIO DA HISTÓRIA ---
        System.out.println("======================================================================");
        System.out.println("A Lenda de Dois Heróis: A Bravura de Mario e o Sacrifício de Yoshi");
        System.out.println("======================================================================\n");
        
        System.out.println("Em uma terra mágica, banhada por um sol dourado e risadas cristalinas, jazia o pacífico Reino dos Cogumelos.");
        System.out.println("A paz, no entanto, era uma tapeçaria frágil, e mais uma vez, suas cores vibrantes foram rasgadas pela sombra escura e ameaçadora do Rei dos Koopas.");
        System.out.println("No coração do castelo, o Rei Toadstool, com o rosto marcado pela angústia, convocou seu mais leal e corajoso campeão.\n");
        
        System.out.println("Rei Toadstool: Mario! A escuridão caiu sobre nós novamente. A Princesa Peach... ela foi levada por Bowser!");
        System.out.println("Rei Toadstool: Você deve resgatá-la! Mas não vá sozinho. Leve Yoshi com você. Ele é seu melhor amigo e um guerreiro formidável.");
        System.out.println("Rei Toadstool: Mario, este é um pedido como pai, não como Rei. Eu vi a forma como você a protege, a forma como vocês se olham.");
        System.out.println("Rei Toadstool: Se você conseguir trazê-la de volta, sã e salva, saberei que não há ninguém mais digno de protegê-la para sempre. Então, e somente então, abençoarei o casamento de vocês.\n");
        
        System.out.println("Mario: Não se preocupe, Majestade. Eu e Yoshi a traremos de volta. Custe o que custar!\n");
        
        System.out.println("Com um aceno de cabeça e um olhar cúmplice, Mario e Yoshi partiram.");
        System.out.println("A jornada os levou para além dos campos verdes, em direção às terras sombrias e desoladas de Bowser.\n");

        System.out.println("O destino final: sua fortaleza assombrada, um castelo de pedra negra que parecia arranhar os céus tempestuosos.");
        System.out.println("Ao chegarem aos portões colossais, um rangido ensurdecedor ecoou quando eles se abriram sozinhos.");
        System.out.println("Lá dentro, a escuridão era quase total, e um frio sobrenatural arrepiou a espinha dos heróis.\n");


        // === Primeira batalha - King Boo ===
        System.out.println("=== PRIMEIRO DESAFIO: O RISO GELADO DO REI FANTASMA ===");
        System.out.println("As sombras dançam nas paredes enquanto King Boo materializa-se, sua coroa brilhando com uma luz espectral.");
        System.out.println("King Boo: Suas almas serão minhas! Ninguém jamais escapou do meu labirinto de pesadelos!\n");
        turno(yoshi, mario, array_monstros[0]);
        System.out.println("\nCom um golpe final, King Boo se dissipou em uma névoa fria, deixando para trás apenas o eco de sua risada.");
        System.out.println("King Boo foi derrotado! Esgotos, mas vitoriosos, a jornada continua...");
        System.out.println("O corredor antes sombrio agora está iluminado, como se a própria luz celebrasse a derrota de King Boo.\n");

        // === Segunda batalha - Kamek ===
        System.out.println("=== SEGUNDO DESAFIO: A MAGIA ILUSÓRIA DE KAMEK ===");
        System.out.println("Avançando por um corredor, o caminho é bloqueado por um brilho de luz hexagonal.");
        System.out.println("Kamek: Impressionante, venceram o fantasma medroso. Mas vocês não são páreo para a minha magia!\n");
        turno(yoshi, mario, array_monstros[1]);

        System.out.println("\nCom um ataque preciso, Mario acerta o verdadeiro Kamek, que desaparece em uma nuvem de fumaça e arrependimento.");
        System.out.println("Kamek foi derrotado! Chegou a hora da batalha final...\n");

        System.out.println("Mario olha para Yoshi, seu companheiro de tantas aventuras.");
        System.out.println("Mario: Estamos quase lá, amigo. Só mais um desafio...");
        System.out.println("Yoshi acena, determinado. Ambos sabem que o verdadeiro teste ainda está por vir.\n");


        // === Batalha Final - Bowser ===
        System.out.println("=== BATALHA FINAL: O REI DOS KOOPAS E O SACRIFÍCIO SUPREMO ===");
        System.out.println("A porta da sala do trono se abre. Lá dentro, em meio a rios de lava, está Bowser. Em uma jaula suspensa, a Princesa Peach.");
        System.out.println("Bowser: MARIO! Então você veio. Veio para testemunhar meu triunfo final! Vocês nunca levarão a Princesa Peach!\n");
        turno(yoshi,mario, array_monstros[2]);

        // --- CONCLUSÃO DA HISTÓRIA ---
        System.out.println("\n=== O FIM DA JORNADA ===");
        System.out.println("Com a força do sacrifício de seu amigo, Mario desfere o golpe final!");
        System.out.println("Bowser foi finalmente derrotado! O silêncio toma conta da sala do trono.");
        System.out.println("Mario corre para a jaula, libertando a Princesa Peach.\n");
        
        System.out.println("Princesa Peach: Meu herói! Você me salvou novamente!");
        System.out.println("Mario a abraça, o alívio da vitória misturado com a amarga dor da perda.\n");
        
        System.out.println("E assim, mais uma vez, o Reino dos Cogumelos foi salvo.");
        System.out.println("A vitória teve um custo imenso, mas o reino para sempre se lembraria e honraria a lenda do mais leal dos amigos,cujo sacrifício supremo garantiu que a luz triunfasse sobre as trevas.\n");

        System.out.println("Mario ajoelha-se ao lado do corpo de seu amigo caído.");
        System.out.println("Mario: Você sempre foi mais que um companheiro, Yoshi. Era meu irmão.");
        System.out.println("Peach coloca gentilmente a mão no ombro de Mario.");
        System.out.println("Peach: Seu sacrifício não será esquecido. O Reino dos Cogumelos sempre lembrará de Yoshi como seu maior herói.\n");
        
        System.out.println("No dia seguinte, um memorial foi erguido nos jardins do castelo.");
        System.out.println("Uma estátua de Yoshi, eternamente vigilante, guardando o reino que ele amou até seu último suspiro.");
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
            // Mario ataca primeiro 
            if(mario.isAlive()){
                mario.TurnoMario(alvo);

                if(!alvo.isAlive()){
                    break;
                }
            }
            // Yoshi ataca logo na sequencia
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
            exibeStatus(yoshi, mario, alvo);
            
        }

        // Exibe status apos o final da batalha
        exibeStatus(yoshi, mario, alvo);
    }

    public static void exibeStatus(Yoshi yoshi, Mario mario, Monstro alvo){
        System.out.println("\n===Status dos Personagens===\n");

        yoshi.Exibir_Status();
        System.out.printf("============================================\n");
        mario.Exibir_Status();
        System.out.printf("============================================\n");
        alvo.Exibir_Status();
        System.out.printf("============================================\n");
    }
}
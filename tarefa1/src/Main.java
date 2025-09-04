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

        // --- INÍCIO DA HISTÓRIA ---
        System.out.println("======================================================================");
        System.out.println("A Lenda de Dois Heróis: A Bravura de Mario e o Sacrifício de Yoshi");
        System.out.println("======================================================================\n");
        
        System.out.println("Em uma terra mágica, banhada por um sol dourado e risadas cristalinas, jazia o pacífico Reino dos Cogumelos.");
        System.out.println("A paz, no entanto, era uma tapeçaria frágil, e mais uma vez, suas cores vibrantes foram rasgadas pela sombra escura e ameaçadora do Rei dos Koopas.\n");
        System.out.println("No coração do castelo, o Rei Toadstool, com o rosto marcado pela angústia, convocou seu mais leal e corajoso campeão.\n");
        
        System.out.println("Rei Toadstool: Mario! A escuridão caiu sobre nós novamente. A Princesa Peach... ela foi levada por Bowser!");
        System.out.println("Rei Toadstool: Você deve resgatá-la! Mas não vá sozinho. Leve Yoshi com você. Ele é seu melhor amigo e um guerreiro formidável.\n");
        System.out.println("Rei Toadstool: Mario, este é um pedido como pai, não como Rei. Eu vi a forma como você a protege, a forma como vocês se olham.");
        System.out.println("Rei Toadstool: Se você conseguir trazê-la de volta, sã e salva, saberei que não há ninguém mais digno de protegê-la para sempre. Então, e somente então, abençoarei o casamento de vocês.\n");
        
        System.out.println("Mario: Não se preocupe, Majestade. Eu e Yoshi a traremos de volta. Custe o que custar!\n");
        
        System.out.println("Com um aceno de cabeça e um olhar cúmplice, Mario e Yoshi partiram.");
        System.out.println("A jornada os levou para além dos campos verdes, em direção às terras sombrias e desoladas de Bowser.");
        System.out.println("O destino final: sua fortaleza assombrada, um castelo de pedra negra que parecia arranhar os céus tempestuosos.\n");
        System.out.println("Ao chegarem aos portões colossais, um rangido ensurdecedor ecoou quando eles se abriram sozinhos.");
        System.out.println("Lá dentro, a escuridão era quase total, e um frio sobrenatural arrepiou a espinha dos heróis.\n");


        // === Primeira batalha - King Boo ===
        System.out.println("=== PRIMEIRO DESAFIO: O RISO GELADO DO REI FANTASMA ===\n");
        System.out.println("De repente, uma risada gélida ecoou pelas paredes, vinda de todos os lugares e de lugar nenhum.");
        System.out.println("King Boo: Toloooos... Ninguém entra no castelo de Lorde Bowser sem pagar o pedágio do medo!\n");
        
        while (array_monstros[0].getPontos_de_vida() > 0 && array_herois[0].getPontos_de_vida() > 0) {
            array_herois[0].atacar(array_monstros[0]);
            if (array_monstros[0].getPontos_de_vida() <= 0) break; // Verifica se o monstro foi derrotado
            
            array_herois[1].atacar(array_monstros[0]);
            if (array_monstros[0].getPontos_de_vida() <= 0) break; // Verifica se o monstro foi derrotado
            
            array_monstros[0].atacar(array_herois[0]);
        }
        
        array_herois[0].ganharExperiencia(array_monstros[0].getXpConcedido());
        System.out.println("\nCom um golpe final, King Boo se dissipou em uma névoa fria, deixando para trás apenas o eco de sua risada.");
        System.out.println("King Boo foi derrotado! Esgotos, mas vitoriosos, a jornada continua...\n");


        // === Segunda batalha - Kamek ===
        System.out.println("=== SEGUNDO DESAFIO: A MAGIA ILUSÓRIA DE KAMEK ===\n");
        System.out.println("Avançando por um corredor, o caminho é bloqueado por um brilho de luz hexagonal.");
        System.out.println("Kamek: Impressionante, venceram o fantasma medroso. Mas vocês não são páreo para a minha magia!\n");
        
        if (((Mario)array_herois[0]).getCogumelo() > 0) {
            System.out.println("Mario avista um Super Cogumelo pulsando com uma luz suave em um canto e o consome!");
            array_herois[0].usarHabilidadeEspecial();
        }
        
        while (array_monstros[1].getPontos_de_vida() > 0 && array_herois[0].getPontos_de_vida() > 0) {
            array_herois[0].atacar(array_monstros[1]);
            if (array_monstros[1].getPontos_de_vida() <= 0) break;

            array_herois[1].atacar(array_monstros[1]);
            if (array_monstros[1].getPontos_de_vida() <= 0) break;

            // Kamek ataca o herói com menos vida para ser mais estratégico
            if (array_herois[1].getPontos_de_vida() > 0) {
                 array_monstros[1].atacar(array_herois[1]);
            } else {
                 array_monstros[1].atacar(array_herois[0]);
            }
        }
        
        array_herois[0].ganharExperiencia(array_monstros[1].getXpConcedido());
        System.out.println("\nCom um ataque preciso, Mario acerta o verdadeiro Kamek, que desaparece em uma nuvem de fumaça e arrependimento.");
        System.out.println("Kamek foi derrotado! Chegou a hora da batalha final...\n");


        // === Batalha Final - Bowser ===
        System.out.println("=== BATALHA FINAL: O REI DOS KOOPAS E O SACRIFÍCIO SUPREMO ===\n");
        System.out.println("A porta da sala do trono se abre. Lá dentro, em meio a rios de lava, está Bowser. Em uma jaula suspensa, a Princesa Peach.\n");
        System.out.println("Bowser: MARIO! Então você veio. Veio para testemunhar meu triunfo final! Vocês nunca levarão a Princesa Peach!\n");
        
        while (array_monstros[2].getPontos_de_vida() > 0 && (array_herois[0].getPontos_de_vida() > 0 || array_herois[1].getPontos_de_vida() > 0)) {
            // Mario ataca
            if(array_herois[0].getPontos_de_vida() > 0) {
                array_herois[0].atacar(array_monstros[2]);
            }
            if (array_monstros[2].getPontos_de_vida() <= 0) break;

            // Checagem do sacrifício de Yoshi
            if (array_herois[0].getPontos_de_vida() < 50 && ((Yoshi)array_herois[1]).getAtordoar() > 0 && array_herois[1].getPontos_de_vida() > 0) {
                System.out.println("\nMario está enfraquecido! Bowser prepara o golpe final...");
                System.out.println("Yoshi olha para seu amigo caído e toma uma decisão heroica.");
                System.out.println("\nYoshi: Mario, meu amigo... Este é meu último presente para você!");
                
                array_herois[1].usarHabilidadeEspecial(); // Assume que a habilidade especial de Yoshi é este ataque sacrificial
                array_herois[1].atacar(array_monstros[2]);
                
                System.out.println("Em um clarão de luz verde, Yoshi se lança contra Bowser em um cometa de pura coragem, desferindo um dano massivo!");
                System.out.println("Yoshi se sacrifica em um último ataque heroico!\n");
                array_herois[1].setPontos_de_vida(0); // Garante que Yoshi seja removido da batalha
                break; // A batalha termina com o sacrifício, Bowser é derrotado
            }
            
            // Bowser ataca
            if (array_monstros[2].getPontos_de_vida() > 0) {
                // Bowser foca em quem estiver vivo
                if (array_herois[0].getPontos_de_vida() > 0) {
                    array_monstros[2].atacar(array_herois[0]);
                } else if (array_herois[1].getPontos_de_vida() > 0) {
                    array_monstros[2].atacar(array_herois[1]);
                }
            }
        }

        // --- CONCLUSÃO DA HISTÓRIA ---
        System.out.println("\n=== O FIM DA JORNADA ===\n");
        System.out.println("Com a força do sacrifício de seu amigo, Mario desfere o golpe final!");
        System.out.println("Bowser foi finalmente derrotado! O silêncio toma conta da sala do trono.");
        System.out.println("Mario corre para a jaula, libertando a Princesa Peach.\n");
        
        System.out.println("Princesa Peach: Meu herói! Você me salvou novamente!");
        System.out.println("Mario a abraça, o alívio da vitória misturado com a amarga dor da perda.\n");
        
        System.out.println("E assim, mais uma vez, o Reino dos Cogumelos foi salvo.");
        System.out.println("A vitória teve um custo imenso, mas o reino para sempre se lembraria e honraria a lenda do mais leal dos amigos,");
        System.out.println("cujo sacrifício supremo garantiu que a luz triunfasse sobre as trevas.");
    }
}
import Armas.*;
import jogo.Personagens.*;
import jogo.Monstro;
import jogo.Fase;
import jogo.ConstrutorDeCenario;

public class Main {
    public static void main(String[] args) throws Exception {
        Fase[] f = ConstrutorDeCenario.gerarFases(3); 
        // Mint das armas iniciais
        Arma martelo = new Martelo("Martelo Lendário", 10, 0);
        Arma lingua = new Lingua("Língua Ancestral", 12, 0);

        // Arma dos alemão
        Arma calafafrios = new Machadinho("NULL", 25, 0);
        Arma Farra = new Machadinho("Cajadão", 25, 0);
        Arma Fogo = new Machadinho("Labaredas de Fogo", 25, 0);
        Arma Machadinha = new Machadinho("Machadinha", 25, 0);
        
        // Heróis com suas armas
        Mario mario = new Mario("Mario", 100, 40, martelo);
        Yoshi yoshi = new Yoshi("Yoshi", 40, 15, lingua);
        
        // Monstros com armas para largar
        Arma[] lista_nivel1 = new Arma[3];
        lista_nivel1[0] = new Martelo("Esmagador de Crânios", 22, 1);
        lista_nivel1[1] = new Varinha("Cajado da Noite Eterna", 15, 1);
        lista_nivel1[2] = new Garras("Dilacerador de Almas", 20, 1);

        Arma[] lista_nivel2 = new Arma[3];
        lista_nivel2[0] = new Martelo("Quebra-Mundos", 32, 2);
        lista_nivel2[1] = new Varinha("Orbe da Destruição", 30, 2);
        lista_nivel2[2] = new Garras("Desmembrador Cósmico", 37, 2);

        Arma[] lista_nivel3 = new Arma[3];
        lista_nivel3[0] = new Martelo("Aniquilador Divino", 50, 3);
        lista_nivel3[1] = new Varinha("Cetro do Apocalipse", 55, 3);
        lista_nivel3[2] = new Garras("Exterminador de Universos", 42, 3);
        
        Monstro[][] array_monstros = {
            {
                new King_Boo("King Boo", 120, 30, 300, calafafrios, lista_nivel1),
                new Koopalings("Koopalings", 90, 20, 150, Machadinha ,lista_nivel1),
                new Koopalings("Koopalings", 90, 20, 150, Machadinha ,lista_nivel1),

            },
            {
                new Kamek("Kamek", 300, 50, 420, Farra ,lista_nivel2),
                new Koopalings("Koopalings", 90, 20, 150, Machadinha ,lista_nivel2),
                new Koopalings("Koopalings", 90, 20, 150, Machadinha ,lista_nivel2)
            },
            {
                new Bowser("Bowser", 500, 70, 1500, Fogo, lista_nivel3),
                new Koopalings("Koopalings", 90, 20, 150, Machadinha ,lista_nivel3),
                new Koopalings("Koopalings", 90, 20, 150, Machadinha ,lista_nivel3),
            }
        };

        // Criação correta das fases
        
        // --- INÍCIO DA HISTÓRIA ---
        System.out.println("======================================================================");
        System.out.println("     A Lenda de Dois Heróis: Uma Jornada pelo Coração do Reino");
        System.out.println("======================================================================\n");

        String[] cenario0 = {"Salão do Trono do Castelo do Cogumelo"};
        System.out.println("[CENÁRIO ATUAL: " + cenario0[0] + "]\n");
        
        System.out.println("Nas profundezas do Castelo do Cogumelo, em uma câmara iluminada apenas por cristais brilhantes, o Rei Toadstool aguardava.");
        System.out.println("Sobre almofadas de veludo, duas armas antigas repousavam, pulsando com uma energia contida.");
        System.out.println("'Este Martelo Lendário', disse o Rei com a voz embargada, entregando-o a Mario, 'foi forjado no coração de uma estrela cadente. Que ele seja a extensão de sua coragem.'");
        System.out.println("'E esta Língua Ancestral', continuou ele, voltando-se para Yoshi, 'carrega a sabedoria e a força de todas as gerações de seu povo.'\n");
        
        // --- O Pedido do Rei ---
        System.out.println("Rei Toadstool: Mario... A sombra de Bowser caiu sobre nós mais uma vez. A Princesa Peach... foi levada para a fortaleza dele.");
        System.out.println("Rei Toadstool: Você deve resgatá-la! E você, Yoshi, seu amigo mais leal, deve ir com ele. A amizade de vocês é uma arma tão poderosa quanto as que carregam.");
        System.out.println("O Rei se aproxima de Mario, seu olhar suaviza. 'Meu rapaz, este é um pedido de um pai, não de um rei. Eu vejo como você a protege, como seus olhares se encontram quando pensam que ninguém está vendo.'");
        System.out.println("Rei Toadstool: 'Traga minha filha de volta, sã e salva. Prove que seu coração é o escudo mais forte que ela poderia ter. E então, com toda a alegria do meu ser, eu abençoarei a união de vocês.'\n");
        
        System.out.println("Mario, com o peso do martelo em uma mão e o peso do reino em seu coração, aperta o punho.");
        System.out.println("Mario: Não se preocupe, Majestade. Nós a traremos de volta. É uma promessa!\n");
        
        // --- A Jornada ---
        System.out.println("Com um aceno de cabeça e um olhar cúmplice, Mario e Yoshi partiram. A jornada os levou através dos Campos Verdes, agora silenciosos e sombrios, em direção às terras corrompidas de Bowser.");
        System.out.println("A grama verde deu lugar a cinzas, as árvores se tornaram garras esqueléticas apontando para um céu perpetuamente nublado. O ar cheirava a enxofre e medo.\n");

        System.out.println("Finalmente, a fortaleza de Bowser surgiu no horizonte, uma montanha de obsidiana e malícia que perfurava as nuvens de tempestade.");
        System.out.println("Ao se aproximarem, os portões colossais, adornados com a face raivosa do próprio Bowser, rangeram abertos como as mandíbulas de uma fera.");
        System.out.println("Lá dentro, a escuridão era uma entidade viva, e um frio que não era natural arrepiou a espinha dos heróis. Cada passo ecoava como uma batida de tambor fúnebre.\n");


        // === Primeira batal(yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1)ha - King Boo ===
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   PRIMEIRO DESAFIO: O GUARDIÃO ESPECTRAL E SEU CETRO GÉLIDO");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        String[] cenario1 = {"Corredor Sombrio", "Sala do Trono Fantasma"};
        f[0] = new Fase(1, cenario1[0], array_monstros[0]); 

        System.out.println(">>> OS HERÓIS ADENTRAM O CASTELO... <<<");
        System.out.println("[CENÁRIO ATUAL: " + f[0].getAmbiente() + "]\n");
        
        System.out.println("A temperatura cai drasticamente. Uma gargalhada gélida ecoa pelas paredes, e do próprio ar, a forma translúcida de KING BOO se materializa!");
        System.out.println("King Boo: 'Heh heh heh... Tolos mortais. Suas armas de carne e osso não podem tocar um rei feito de pesadelos!'\n");
        
        if (yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1) {
            System.out.println("O destino conspirou contra nossos heróis, e suas almas foram congeladas pelo toque do Rei Fantasma...");
            return;
        }
        
        turno(yoshi, mario, array_monstros[0][2]);
        turno(yoshi, mario, array_monstros[0][1]);
        turno(yoshi, mario, array_monstros[0][0]);

        System.out.println("\nCom um golpe final imbuído de pura bravura, o Martelo Lendário atravessou a forma espectral.");
        System.out.println("King Boo se dissipou em uma névoa fria, deixando para trás apenas o eco de sua risada e o silêncio.");
        System.out.println("King Boo foi derrotado! A luz de tochas mágicas se acende ao longo do corredor, revelando o caminho a seguir. A própria fortaleza parece respirar aliviada.\n");
        f[0] = new Fase(1, cenario1[1], array_monstros[0]); 
        System.out.println("[Os heróis avançam para a " + f[0].getAmbiente() + "]\n");
        
        // === Segunda batalha - Kamek ===
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   SEGUNDO DESAFIO: O FEITICEIRO DAS ILUSÕES E A VARINHA DAS SOMBRAS");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        String[] cenario2 = {"Câmara das Ilusões", "Laboratório de Kamek"};
        // Sua linha de código para definir a nova fase
        f[0] = new Fase(2, cenario2[0], array_monstros[1]);

        System.out.println(">>> ELES SEGUEM ADIANTE... <<<");
        System.out.println("[CENÁRIO ATUAL: " + f[0].getAmbiente() + "]\n");

        System.out.printf("Yoshi: 'A magia vem daquela %s, Mario! É ela que está criando tudo isso!'\n\n", array_monstros[1][0].getArma().getNome());
        System.out.println("Kamek: 'Impressionante, mas sua jornada termina aqui!'\n");
        System.out.println("Ele ergue sua Varinha das Sombras, e o salão se multiplica em dezenas de cópias, cada uma com um Kamek zombeteiro.\n");
        
        if (yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1) {
            System.out.println("Perdidos no labirinto de ilusões, a magia negra de Kamek provou ser forte demais...");
            return;
        }
        
        turno(yoshi, mario, array_monstros[1][2]);
        turno(yoshi, mario, array_monstros[1][1]);
        turno(yoshi, mario, array_monstros[1][0]);


        System.out.println("\nCom um ataque preciso guiado pela intuição, a Língua Ancestral de Yoshi chicoteia através das ilusões e acerta o verdadeiro Kamek!");
        System.out.println("O feiticeiro desaparece em uma nuvem de fumaça e arrependimento, e as ilusões se estilhaçam como vidro.");

        f[0] = new Fase(2, cenario2[1], array_monstros[1]);

        System.out.println("Kamek foi derrotado! Apenas uma porta imponente agora os separa do confronto final.\n");
        
        // --- A Calma Antes da Tempestade ---
        System.out.println("Mario coloca uma mão no ombro de Yoshi, seu companheiro de tantas aventuras.");
        System.out.println("Mario: Estamos quase lá, amigo. Atrás daquela porta... está o Bowser. E a Peach.");
        System.out.println("Yoshi solta um grunhido determinado, batendo o pé no chão. Eles não vieram tão longe para falhar agora. Juntos, eles empurram a porta.\n");
        

        // === Batalha Final - Bowser ===
        System.out.println("======================================================================");
        System.out.println("                 BATALHA FINAL: O REI KOOPA E SUAS GARRAS DE FOGO");
        System.out.println("======================================================================\n");
        
        String[] cenario3 = {"Fortaleza de Bowser", "Sala do Trono", "Câmara da Lava"};
        // Sua linha de código para definir a fase final
        f[0] = new Fase(3, cenario3[1], array_monstros[2]);

        System.out.println(">>> A CÂMARA FINAL. <<<");
        System.out.println("[CENÁRIO ATUAL: " + f[0].getAmbiente() + "]\n");
        
        System.out.println("O chão treme. Um rugido gutural que abala as próprias fundações do castelo anuncia a chegada do Rei Koopa.");
        System.out.printf("Yoshi: 'Cuidado, Mario! São as lendárias %s! O calor é insuportável!'\n\n", array_monstros[2][0].getArma().getNome());
        System.out.println("Bowser: 'MARIO! Seu inseto persistente! A Princesa é MINHA! E este reino será reduzido a cinzas sob as MINHAS GARRAS!'\n");
        
        if (yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1) {
            System.out.println("O poder avassalador das Garras de Fogo consumiu nossos heróis...");
            return;
        }
        
        turno(yoshi, mario, array_monstros[2][2]);
        turno(yoshi, mario, array_monstros[2][1]);
        turno(yoshi, mario, array_monstros[2][0]);

        // --- CONCLUSÃO ---
        System.out.println("\nCom um último esforço hercúleo, Mario e Yoshi atacam juntos!");
        System.out.println("O Martelo Lendário colide com as Garras de Fogo, criando uma explosão de luz e som. Bowser, o tirano, finalmente tomba, derrotado.");
        System.out.println("As Garras de Fogo se apagam, tornando-se metal frio e sem vida. O silêncio que se segue é mais pesado que qualquer rugido.\n");
        
        System.out.println("======================================================================");
        System.out.println("                 O LEGADO DAS ARMAS, O TRIUNFO DO AMOR");
        System.out.println("======================================================================\n");

        System.out.println("Com Bowser vencido, o castelo começa a tremer e a desmoronar. 'Peach!' grita Mario.");
        
        f[0] = new Fase(3, "Torre da Fortaleza em Ruínas", array_monstros[2]); // Cenário customizado para a fuga
        //--> NOVO: Anúncio do cenário final.
        System.out.println("[Eles correm para a " + f[0].getAmbiente() + "]\n");
        
        System.out.println("Eles correm para a torre mais alta, onde encontram a Princesa, sã e salva. 'Mario! Yoshi! Eu sabia que vocês viriam!'");
        System.out.println("Não há tempo para palavras. Mario a pega nos braços e, com Yoshi liderando o caminho, eles escapam da fortaleza em ruínas.\n");

        System.out.println("O retorno ao Reino do Cogumelo foi triunfal. O povo comemorou nas ruas, e o sol, antes escondido, agora brilhava intensamente.");
        System.out.println("No salão do trono, o Rei Toadstool, com lágrimas de alegria nos olhos, abraça sua filha.");
        System.out.println("Ele então se vira para Mario. 'Você não é apenas um herói do reino, Mario. Você é o herói do coração dela. E do meu.'");
        System.out.println("Rei Toadstool: 'Eu não poderia sonhar com um guardião mais nobre, um marido mais digno para minha filha. Vocês têm a minha bênção.'\n");

        System.out.println("O Martelo Lendário e a Língua Ancestral provaram seu valor, mas a verdadeira força veio da coragem, da amizade e do amor.");
        System.out.println("E assim, com a promessa de um casamento real no horizonte, a paz e a felicidade reinaram mais uma vez no Reino do Cogumelo.");
        System.out.println("\nFIM.");
    }

    public static void turno(Yoshi yoshi, Mario mario, Monstro alvo) {
        System.out.printf("\nIniciando batalha contra %s empunhando %s!\n", alvo.getNome(), alvo.getArma().getNome());

        while(alvo.isAlive() && (yoshi.isAlive() || mario.isAlive())) {
            
            System.out.println("\n=== Vez dos heróis! ===");
            // Mario ataca primeiro 
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
            if(!alvo.getAtordoado()){
                System.out.printf("\n=== Vez de %s atacar! ===\n", alvo.getNome());
                if(yoshi.isAlive()){
                    alvo.atacar(yoshi, 0);
                } else if(mario.isAlive()){
                    alvo.atacar(mario, 0);
                }
            } else {
                System.out.printf("\n%s está atordoado e perde seu turno!\n", alvo.getNome());
                alvo.setAtordoado(false); 
            }
            exibeStatus(yoshi, mario, alvo);
            
        }
        
        if (!alvo.isAlive()) {
            System.out.printf("\n%s foi derrotado!\n", alvo.getNome());
        }

        exibeStatus(yoshi, mario, alvo);
    }

    public static void exibeStatus(Yoshi yoshi, Mario mario, Monstro alvo) {
        System.out.println("\n--- Status dos Combatentes ---");
        System.out.printf("HERÓI: %s\n", yoshi.getNome());
        yoshi.Exibir_Status();
        System.out.printf("Arma: %s (Dano: %d)\n", 
            yoshi.getArma().getNome(), yoshi.getArma().getDano());
        System.out.println("------------------------------");
        
        System.out.printf("HERÓI: %s\n", mario.getNome());
        mario.Exibir_Status();
        System.out.printf("Arma: %s (Dano: %d)\n", 
            mario.getArma().getNome(), mario.getArma().getDano());
        System.out.println("------------------------------");
        
        System.out.printf("INIMIGO: %s\n", alvo.getNome());
        alvo.Exibir_Status();
        System.out.printf("Arma: %s (Dano: %d)\n", 
            alvo.getArma().getNome(), alvo.getArma().getDano());
        System.out.println("------------------------------\n");
    }

}
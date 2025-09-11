import jogo.*;
import jogo.Personagens.*;
import Armas.*;
import Ferramentas.ConstrutorDeCenario;
import Ferramentas.Fase;

public class Main {
    public static void main(String[] args) throws Exception {
        int nFases = 3;
        Fase[] f = ConstrutorDeCenario.gerarFases(nFases); 
        // Mint das armas iniciais
        Arma martelo = new Martelo("Martelo Lendário", 1, 0);
        Arma lingua = new Lingua("Língua Ancestral", 15, 0);
        Arma cetroFantasma = new Cetro("Cetro Espectral", 1, 0);
        Arma varinhaMagica = new Varinha("Varinha das Sombras", 1, 0);
        Arma garrasIgneas = new Garras("Garras de Fogo", 0, 0);
        
        // Heróis com suas armas
        Mario mario = new Mario("Mario", 100, 40, martelo);
        Yoshi yoshi = new Yoshi("Yoshi", 40, 15, lingua);
        
        // Monstros armados
        Monstro array_monstros[] = {
            new King_Boo("King Boo", 120, 30, 125, cetroFantasma),
            new Kamek("Kamek", 80, 25, 175, varinhaMagica),
            new Bowser("Bowser", 180, 25, 200, garrasIgneas)
        };

        // Criação correta das fases
        
        // --- INÍCIO DA HISTÓRIA ---
        System.out.println("======================================================================");
        System.out.println("     A Lenda de Dois Heróis: Uma Jornada pelo Coração do Reino");
        System.out.println("======================================================================\n");

        String[] cenario0 = {"Salão do Trono do Castelo do Cogumelo"};
        
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


        // === Primeira batalha - King Boo ===
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   PRIMEIRO DESAFIO: O GUARDIÃO ESPECTRAL E SEU CETRO GÉLIDO");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        String[] cenario1 = {"Castelo Mal Assombrado", "Corredor Sombrio", "Sala do Trono Fantasma"};
        f[0] = new Fase(1, cenario1, array_monstros[0]); // King Boo

        System.out.println("A temperatura cai drasticamente. Uma gargalhada gélida ecoa pelas paredes, e do próprio ar, a forma translúcida de KING BOO se materializa!");
        System.out.println("Seu Cetro Espectral brilha com uma luz fantasmagórica, drenando o calor e a coragem do ambiente.");
        System.out.println("King Boo: 'Heh heh heh... Tolos mortais. Suas armas de carne e osso não podem tocar um rei feito de pesadelos!'\n");
        
        if (yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1) {
            System.out.println("O destino conspirou contra nossos heróis, e suas almas foram congeladas pelo toque do Rei Fantasma...");
            return;
        }
        
        turno(yoshi, mario, array_monstros[0]);
        System.out.println("\nCom um golpe final imbuído de pura bravura, o Martelo Lendário atravessou a forma espectral.");
        System.out.println("King Boo se dissipou em uma névoa fria, deixando para trás apenas o eco de sua risada e o silêncio.");
        System.out.println("King Boo foi derrotado! A luz de tochas mágicas se acende ao longo do corredor, revelando o caminho a seguir. A própria fortaleza parece respirar aliviada.\n");
        
        // === Segunda batalha - Kamek ===
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   SEGUNDO DESAFIO: O FEITICEIRO DAS ILUSÕES E A VARINHA DAS SOMBRAS");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        String[] cenario2 = {"Torre do Feiticeiro", "Câmara das Ilusões", "Laboratório de Kamek"};
        f[1] = new Fase(2, cenario2, array_monstros[1]); // Kamek

        System.out.println("O corredor seguinte se abre para um salão vasto, cujas paredes parecem ondular. No centro, KAMEK flutua em seu cajado, rindo com desdém.");
        System.out.println("Kamek: 'Impressionante, mas sua jornada termina aqui! Vocês conseguirão distinguir o real do imaginário quando a sua própria mente for o campo de batalha?'");
        System.out.println("Ele ergue sua Varinha das Sombras, e o salão se multiplica em dezenas de cópias, cada uma com um Kamek zombeteiro.\n");
        
        if (yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1) {
            System.out.println("Perdidos no labirinto de ilusões, a magia negra de Kamek provou ser forte demais...");
            return;
        }
        
        turno(yoshi, mario, array_monstros[1]);

        System.out.println("\nCom um ataque preciso guiado pela intuição, a Língua Ancestral de Yoshi chicoteia através das ilusões e acerta o verdadeiro Kamek!");
        System.out.println("O feiticeiro desaparece em uma nuvem de fumaça e arrependimento, e as ilusões se estilhaçam como vidro.");
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
        f[2] = new Fase(3, cenario3, array_monstros[2]); // Bowser
        
        System.out.println("O chão treme. Um rugido gutural que abala as próprias fundações do castelo anuncia a chegada do Rei Koopa.");
        System.out.println("BOWSER aterrissa diante deles, quebrando as lajes de pedra. Em suas mãos, as Garras de Fogo ardem com o calor de um vulcão.");
        System.out.println("Bowser: 'MARIO! Seu inseto persistente! A Princesa é MINHA! E este reino será reduzido a cinzas sob as MINHAS GARRAS!'\n");
        
        if (yoshi.getSorte() < 0.1 && mario.getSorte() < 0.1) {
            System.out.println("O poder avassalador das Garras de Fogo consumiu nossos heróis...");
            return;
        }
        
        turno(yoshi, mario, array_monstros[2]);

        // --- CONCLUSÃO (Aprimorada e Completa) ---
        System.out.println("\nCom um último esforço hercúleo, Mario e Yoshi atacam juntos!");
        System.out.println("O Martelo Lendário colide com as Garras de Fogo, criando uma explosão de luz e som. Bowser, o tirano, finalmente tomba, derrotado.");
        System.out.println("As Garras de Fogo se apagam, tornando-se metal frio e sem vida. O silêncio que se segue é mais pesado que qualquer rugido.\n");
        
        System.out.println("======================================================================");
        System.out.println("                 O LEGADO DAS ARMAS, O TRIUNFO DO AMOR");
        System.out.println("======================================================================\n");

        System.out.println("Com Bowser vencido, o castelo começa a tremer e a desmoronar. 'Peach!' grita Mario.");
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
        System.out.printf("\nIniciando batalha contra %s empunhando %s!\n", 
            alvo.getNome(), alvo.getArma().getNome());

        while(alvo.isAlive() && (yoshi.isAlive() || mario.isAlive())) {
            if(!yoshi.isAlive() && !mario.isAlive()){
                System.out.println("Todos os heróis foram derrotados! Game Over!");
                break;
            }

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
                    alvo.atacar(yoshi);
                } else if(mario.isAlive()){
                    alvo.atacar(mario);
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
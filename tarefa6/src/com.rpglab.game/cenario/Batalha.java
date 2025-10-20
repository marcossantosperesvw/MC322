package com.rpglab.game.cenario;

import com.rpglab.game.personagens.herois.*;
import com.rpglab.game.personagens.monstros.*;
import com.rpglab.game.util.*;
import com.rpglab.game.itens.*;
import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * Classe que coordena toda a batalha/aventura do RPG.
 * Responsável por gerenciar as fases, o herói e o progresso do jogo.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Batalha {
    
    @XmlElement
    private Heroi heroi;
    
    @XmlElementWrapper(name = "fases")
    @XmlElement(name = "fase")
    private List<FaseDeCombate> fases;
    
    @XmlElement
    private int faseAtual;
    
    @XmlElement
    private Dificuldade dificuldade;
    
    @XmlTransient
    private GerenciadorDeInteracao gerenciador;
    
    // Construtor padrão necessário para JAXB
    public Batalha() {
        this.gerenciador = new GerenciadorDeInteracao();
    }
    
    /**
     * Construtor para iniciar uma nova batalha.
     * @param heroi O herói escolhido
     * @param fases Lista de fases da aventura
     * @param dificuldade Dificuldade selecionada
     */
    @SuppressWarnings("unchecked")
    public Batalha(Heroi heroi, List<? extends Fase> fases, Dificuldade dificuldade) {
        this.heroi = heroi;
        this.fases = (List<FaseDeCombate>) fases;  // Safe cast as we only use FaseDeCombate
        this.faseAtual = 0;
        this.dificuldade = dificuldade;
        this.gerenciador = new GerenciadorDeInteracao();
    }
    
    /**
     * Executa a próxima fase incompleta e o menu pós-combate.
     */
    public void executarProxFase() {
        // Verificar se já completou todas as fases
        if (faseAtual >= fases.size()) {
            System.out.println("Todas as fases foram completadas!");
            return;
        }
        
        // Verificar se há fases disponíveis
        if (fases == null || fases.isEmpty()) {
            System.out.println("Erro: Nenhuma fase disponível!");
            return;
        }
        
        Fase fase = fases.get(faseAtual);
        
        if (fase.isConcluida()) {
            faseAtual++;
            return;
        }
        
        exibirInicioFase(faseAtual + 1, fases.size());
        
        // Iniciar a fase
        fase.iniciar(heroi);
        
        // Verificar se o herói morreu
        if (!heroi.estaVivo()) {
            exibirGameOver();
            return;
        }
        
        // Marcar fase como concluída e mostrar narrativa de sucesso
        exibirSucessoFase(faseAtual + 1);
        
        // Mostrar status após a fase
        System.out.println("\n=== STATUS APÓS A FASE ===");
        heroi.exibirStatus();
        
        // Menu pós-fase (exceto na última)
        if (faseAtual < fases.size() - 1) {
            InputManager.esperarEnter("Pressione ENTER para o menu...");
            menuPosFase();
        } else {
            // Vitória final
            if (heroi.estaVivo()) {
                exibirVitoriaFinal();
            }
        }
        
        faseAtual++;
    }
    
    /**
     * Menu exibido após cada fase (exceto a última).
     */
    private void menuPosFase() {
        boolean continuarJogo = true;
        
        while (continuarJogo) {
            System.out.println("\n=== MENU PÓS-FASE ===");
            System.out.println("[1] Continuar para próxima fase");
            System.out.println("[2] Salvar Jogo");
            System.out.println("[3] Ver Status do Herói");
            System.out.println("[4] Desistir");
            
            int opcao = InputManager.lerInteiro("Escolha uma opção", 1, 4);
            
            switch (opcao) {
                case 1:
                    continuarJogo = false;
                    break;
                case 2:
                    salvarJogo();
                    break;
                case 3:
                    heroi.exibirStatus();
                    InputManager.esperarEnter("Pressione ENTER para continuar...");
                    break;
                case 4:
                    boolean confirma = InputManager.lerSimNao("Tem certeza que deseja desistir? (s/n)");
                    if (confirma) {
                        System.out.println("Você desistiu da aventura. Até a próxima!");
                        System.exit(0);
                    }
                    break;
            }
        }
    }
    
    /**
     * Salva o estado atual da batalha.
     */
    public void salvarJogo() {
        String nomeSave = GerenciadorDePersistencia.getNomeSavePadrao();
        GerenciadorDePersistencia.salvarBatalha(this, nomeSave);
    }
    
    /**
     * Carrega um jogo salvo.
     * @param nomeSave Nome do save a carregar
     * @return A batalha carregada, ou null se falhar
     */
    public static Batalha carregarJogo(String nomeSave) {
        Batalha batalha = GerenciadorDePersistencia.carregarBatalha(nomeSave);
        if (batalha != null) {
            batalha.gerenciador = new GerenciadorDeInteracao();
            
            // Verificar estado do jogo carregado
            System.out.println("\nVerificando estado do jogo carregado...");
            System.out.printf("Fase atual: %d/%d\n", 
                            batalha.getFaseAtual() + 1, 
                            batalha.getFases().size());
            System.out.println("Status do herói:");
            batalha.getHeroi().exibirStatus();
        }
        return batalha;
    }
    
    private boolean todasFasesConcluidas() {
        return fases.stream().allMatch(Fase::isConcluida);
    }
    
    public Heroi getHeroi() {
        return heroi;
    }
    
    public List<? extends Fase> getFases() {
        return fases;
    }
    
    public int getFaseAtual() {
        return faseAtual;
    }
    
    public Dificuldade getDificuldade() {
        return dificuldade;
    }
    
    // Métodos de exibição de narrativa
    
    private void exibirInicioFase(int faseNum, int totalFases) {
        System.out.println("\n" + "=".repeat(70));
        System.out.printf("                    ⚡ FASE %d DE %d ⚡\n", faseNum, totalFases);
        System.out.println("=".repeat(70));
        
        switch (faseNum) {
            case 1:
                System.out.println("\n🌙 Nosso herói se aproxima do primeiro desafio...");
                System.out.println("Os corredores sombrios ecoam com sussurros fantasmagóricos.");
                System.out.println("É hora de provar sua coragem contra os servos de Bowser!");
                break;
            case 2:
                System.out.println("\n🔮 A jornada continua pela Câmara das Ilusões...");
                System.out.println("A realidade se distorce ao redor do herói.");
                System.out.println("Inimigos mais poderosos aguardam nas sombras!");
                break;
            case 3:
                System.out.println("\n🔥 Finalmente, o Castelo de Bowser se ergue à frente!");
                System.out.println("Esta é a batalha final que decidirá o destino do reino.");
                System.out.println("O Rei dos Koopas aguarda... Que a batalha épica comece!");
                break;
        }
        System.out.println();
    }
    
    private void exibirSucessoFase(int fase) {
        System.out.println("\n" + "🎉".repeat(20));
        System.out.printf("          FASE %d CONCLUÍDA COM SUCESSO!\n", fase);
        System.out.println("🎉".repeat(20));
        System.out.println();
        
        switch (fase) {
            case 1:
                System.out.println("Os fantasmas recuam para as sombras!");
                System.out.println("O primeiro dos três selos foi quebrado.");
                break;
            case 2:
                System.out.println("As ilusões se desfazem diante da determinação do herói!");
                System.out.println("O segundo selo foi destruído.");
                break;
            case 3:
                System.out.println("Bowser foi derrotado e seu poder sombrio se dissipa!");
                System.out.println("O último selo foi quebrado!");
                break;
        }
    }
    
    private void exibirGameOver() {
        System.out.println("\n" + "💀".repeat(25));
        System.out.println("                    GAME OVER");
        System.out.println("💀".repeat(25));
        System.out.println();
        System.out.println("As forças das trevas prevaleceram...");
        System.out.println("O herói lutou bravamente, mas não foi suficiente.");
        System.out.println("O Reino Cogumelo permanecerá nas sombras...");
        System.out.println();
        System.out.println("=== STATUS FINAL ===");
        heroi.exibirStatus();
        System.out.println("\n🔄 Tente novamente para mudar o destino do reino!");
    }
    
    private void exibirVitoriaFinal() {
        System.out.println("\n" + "🏆".repeat(25));
        System.out.println("                     VITÓRIA ÉPICA!");
        System.out.println("🏆".repeat(25));
        System.out.println();
        System.out.println("🎊 PARABÉNS! Você completou todas as fases! 🎊");
        System.out.println();
        System.out.println("Com coragem e determinação, nosso herói conseguiu derrotar");
        System.out.println("todos os servos de Bowser e quebrar os três selos sombrios!");
        System.out.println();
        System.out.println("A luz voltou a brilhar sobre o Reino Cogumelo!");
        System.out.println("A Princesa Peach e todos os habitantes estão salvos!");
        System.out.println();
        System.out.println("🌟 O reino está salvo graças à sua bravura! 🌟");
        System.out.println();
        System.out.println("=== STATUS FINAL DO HERÓI VITORIOSO ===");
        heroi.exibirStatus();
        System.out.println();
        System.out.println("🎮 Obrigado por jogar Terras Sombrias - RPG! 🎮");
        System.out.println("✨ Que esta vitória seja lembrada para sempre! ✨");
        System.out.println();
        System.out.println("=".repeat(70));
    }
}
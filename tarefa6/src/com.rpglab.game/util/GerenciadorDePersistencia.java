package com.rpglab.game.util;

import com.rpglab.game.cenario.Batalha;
import javax.xml.bind.*;
import java.io.*;
import java.nio.file.*;

/**
 * Classe responsável por salvar e carregar o estado do jogo.
 * Utiliza JAXB para serialização em XML.
 */
public class GerenciadorDePersistencia {
    
    private static final String PASTA_SAVES = "saves";
    private static final String EXTENSAO = ".xml";
    
    static {
        // Garante que a pasta de saves existe
        try {
            Files.createDirectories(Paths.get(PASTA_SAVES));
        } catch (IOException e) {
            System.err.println("Erro ao criar pasta de saves: " + e.getMessage());
        }
    }
    
    /**
     * Salva o estado atual da batalha em um arquivo XML.
     * @param batalha A batalha a ser salva
     * @param nomeBatalha Nome do arquivo (sem extensão)
     */
    public static void salvarBatalha(Batalha batalha, String nomeBatalha) {
        try {
            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            String caminhoArquivo = PASTA_SAVES + File.separator + nomeBatalha + EXTENSAO;
            File arquivo = new File(caminhoArquivo);
            
            marshaller.marshal(batalha, arquivo);
            System.out.println("\n✓ Jogo salvo com sucesso em: " + caminhoArquivo);
            
        } catch (JAXBException e) {
            System.err.println("Erro ao salvar o jogo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Carrega uma batalha salva a partir de um arquivo XML.
     * @param nomeBatalha Nome do arquivo (sem extensão)
     * @return A batalha carregada, ou null se houver erro
     */
    public static Batalha carregarBatalha(String nomeBatalha) {
        try {
            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            String caminhoArquivo = PASTA_SAVES + File.separator + nomeBatalha + EXTENSAO;
            File arquivo = new File(caminhoArquivo);
            
            if (!arquivo.exists()) {
                System.out.println("Arquivo de save não encontrado: " + caminhoArquivo);
                return null;
            }
            
            Batalha batalha = (Batalha) unmarshaller.unmarshal(arquivo);
            System.out.println("\n✓ Jogo carregado com sucesso!");
            return batalha;
            
        } catch (JAXBException e) {
            System.err.println("Erro ao carregar o jogo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Verifica se existe algum jogo salvo.
     * @return true se existir pelo menos um save
     */
    public static boolean existeSaveDisponivel() {
        File pastaS = new File(PASTA_SAVES);
        if (!pastaS.exists() || !pastaS.isDirectory()) {
            return false;
        }
        
        File[] arquivos = pastaS.listFiles((dir, name) -> name.endsWith(EXTENSAO));
        return arquivos != null && arquivos.length > 0;
    }
    
    /**
     * Lista todos os saves disponíveis.
     * @return Array com os nomes dos saves (sem extensão)
     */
    public static String[] listarSaves() {
        File pasta = new File(PASTA_SAVES);
        if (!pasta.exists() || !pasta.isDirectory()) {
            return new String[0];
        }
        
        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(EXTENSAO));
        if (arquivos == null || arquivos.length == 0) {
            return new String[0];
        }
        
        String[] nomes = new String[arquivos.length];
        for (int i = 0; i < arquivos.length; i++) {
            nomes[i] = arquivos[i].getName().replace(EXTENSAO, "");
        }
        return nomes;
    }
    
    /**
     * Retorna o nome padrão para o save atual.
     * @return Nome do arquivo de save padrão
     */
    public static String getNomeSavePadrao() {
        return "save_atual";
    }
}
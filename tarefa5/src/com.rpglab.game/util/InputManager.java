package com.rpglab.game.util;

import java.util.*;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);
    
    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem + " (" + min + " - " + max + "): ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um número entre " + min + " e " + max + ".");
                    continue;
                }
                
                int valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("Fora do intervalo. Digite um número entre " + min + " e " + max + ".");
                    continue;
                }
                
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }
    }
    
    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine().trim();
    }
    
    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("s")) return true;
            if (input.equals("n")) return false;
            System.out.println("Digite 's' para sim ou 'n' para não.");
        }
    }
    
    public static void esperarEnter(String mensagem) {
        System.out.println(mensagem);
        scanner.nextLine();
    }
    
    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
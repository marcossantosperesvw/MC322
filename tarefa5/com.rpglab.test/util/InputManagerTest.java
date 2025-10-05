package com.rpglab.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class InputManagerTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    // Testes para lerSimNao
    @Test
    public void testLerSimNao_InputSim() {
        provideInput("s\n");
        assertTrue(InputManager.lerSimNao("Teste? (s/n)"));
    }

    @Test
    public void testLerSimNao_InputNao() {
        provideInput("n\n");
        assertFalse(InputManager.lerSimNao("Teste? (s/n)"));
    }

    @Test
    public void testLerSimNao_InputInvalidoDepoisValido() {
        provideInput("invalido\ns\n");
        assertTrue(InputManager.lerSimNao("Teste? (s/n)"));
        assertTrue(outContent.toString().contains("Digite 's' para sim ou 'n' para não."));
    }

    // Testes para lerString
    @Test
    public void testLerString_InputComum() {
        provideInput("Teste de String\n");
        assertEquals("Teste de String", InputManager.lerString("Digite algo:"));
    }
    
    @Test
    public void testLerInteiro_LancaExcecaoSemEntrada() {
        provideInput(""); // Sem entrada
        // A implementação de lerInteiro lança RuntimeException quando não encontra mais linhas
        assertThrows(RuntimeException.class, () -> {
            InputManager.lerInteiro("Digite um número", 1, 10);
        });
    }
}
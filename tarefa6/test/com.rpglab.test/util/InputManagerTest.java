package com.rpglab.test.util;
import com.rpglab.game.util.InputManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.rpglab.game.util.*; 




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
    @Test
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        InputManager.resetScanner();
    }

    // Testes para lerSimNao
    @Test 
    public void testEsperaEnter(){
        provideInput("\n");
        InputManager.esperarEnter("Pressione Enter para continuar...");
        assertEquals("Pressione Enter para continuar...\n", outContent.toString());
    }
    @Test
    public void testLerInteiro_ValidInput() {
        provideInput("5\n");
        int resultado = InputManager.lerInteiro("Digite um numero", 1, 10);
        assertEquals(5, resultado);
    }
    @Test
    public void testEsperaEnterExcecao(){
        provideInput(""); // Simula uma entrada vazia
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () ->{
            InputManager.esperarEnter("Pressione Enter para continuar...");
        });
    }
    @Test
    public void testLerSimNao_InputSim() {
        provideInput("s\n");
        assertTrue(InputManager.lerSimNao("(s/n)"));
    }
    @Test
    public void testLerSimNao_InputNao() {
        provideInput("n\n");
        assertFalse(InputManager.lerSimNao("(s/n)"));
    }
    @Test 
    public void testLerSimNaoExcecao(){
        provideInput("");
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () ->{
            InputManager.lerSimNao("(s/n)");
        });
    }


    // Testes para lerString
    
    @Test
    public void testLerInteiro_InvalidInput_nao_inteiro() {
    System.setOut(new PrintStream(outContent));

    provideInput("palavras\n");

    RuntimeException exception = assertThrows(RuntimeException.class, () ->
    InputManager.lerInteiro("Digite um numero", 1, 10));

    // Entrada invalida faz com que o InputManager espere nova entrada (nao existe entao da erro)
    assertEquals("Entrada nao disponivel.", exception.getMessage());

    // Verifica se a mensagem de entrada errada foi exibida
    assertEquals("Digite um numero (1 - 10): Valor invalido. Digite um numero inteiro.\n"+
    "Digite um numero (1 - 10): No line found\n", outContent.toString());

    }
}
package test;

import model.*;
import static org.junit.Assert.*;
import org.junit.*;

public class PilhaListaTeste {

    PilhaLista<Integer> pilha;
    @Before
    public void setUp() throws Exception {
        pilha = new PilhaLista<>();
    }

    /*
    Conferir se o método estaVazia() reconhece pilha vazia.
     */
    @Test
    public void Test01() {
        assertTrue(pilha.estaVazia());
    }

    /*
    Conferir se o método estaVazia() reconhece pilha não vazia.
     */
    @Test
    public void Test02() {
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    /*
    Conferir se os dados são empilhados e desempilhados corretamente
     */
    @Test
    public void Test03() {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals((Integer) 30, pilha.pop());
        assertEquals((Integer) 20, pilha.pop());
        assertEquals((Integer) 10, pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    /*
    Conferir se o método peek() retorna o topo da pilha
     */
    @Test
    public void Test04() {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals((Integer) 30, pilha.peek());
        assertEquals((Integer) 30, pilha.pop());
    }

    /*
    Conferir se o método liberar() remove os elementos da pilha
     */
    @Test
    public void Test05() {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }
}
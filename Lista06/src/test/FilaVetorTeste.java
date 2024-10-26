package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class FilaVetorTeste {

    FilaVetor<Integer> f;

    @Before
    public void init(){
        f = new FilaVetor<>(5);
    }

    @Test
    public void FilaVaziaTeste(){
        assertEquals(true, f.estaVazia());
    }

    @Test
    public void FilaNãoVaziaTeste(){
        f.inserir(10);
        assertEquals(false, f.estaVazia());
    }
    
    @Test
    public void FilaDadosTeste(){
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        assertEquals((Integer)10, f.retirar());
        assertEquals((Integer)20, f.retirar());
        assertEquals((Integer)30, f.retirar());
        assertEquals(true, f.estaVazia());
    }
    
    @Test(expected = FilhaCheiaException.class)
    public void FilaCheiaExceptionTeste(){
        f = new FilaVetor<>(3);
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.inserir(40);
    }

    @Test(expected = FilaVaziaException.class)
    public void FilaVaziaExceptionTeste(){
        f.retirar();
    }

    @Test
    public void FilaPeekTeste(){
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        assertEquals((Integer) 10, f.peek());
    }

    @Test
    public void FilaLiberarTeste(){
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.liberar();
        assertEquals(true, f.estaVazia());
    }

    @Test
    public void ConcatenarTeste(){
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);

        FilaVetor<Integer> f1 = new FilaVetor<>(3);
        f1.inserir(40);
        f1.inserir(50);

        FilaVetor<Integer> f3 = f.criarFilaConcatenada(f1);
        assertEquals("10,20,30,40,50", f3.toString());
        assertEquals(8, f3.getLimite());
    }
}

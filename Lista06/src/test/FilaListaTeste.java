package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class FilaListaTeste {
    
    FilaLista<Integer> f;

    @Before
    public void init(){
        f = new FilaLista<>();
    }

    @Test
    public void FilaVaziaTeste(){
        assertEquals(true, f.estaVazia());
    }
    
    @Test
    public void FilaNaoVaziaTeste(){
        f.inserir(10);
        assertEquals(false, f.estaVazia());
    }

    @Test
    public void FilaOrdemTeste(){
        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        
        assertEquals((Integer) 10, f.retirar());
        assertEquals((Integer) 20, f.retirar());
        assertEquals((Integer) 30, f.retirar());
        assertEquals(true, f.estaVazia());
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
}

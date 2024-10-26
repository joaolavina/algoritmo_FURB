package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ListaEstatica;

public class ListaEstaticaTest {
    
    ListaEstatica l;

    @Before
    public void init(){
        l = new ListaEstatica();
    }

    @Test
    public void IncluirDadosTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals("5,10,15,20", l.toString());
    }

    @Test
    public void ObterTamanhoListaTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(4, l.getTamanho());
    }

    @Test
    public void BuscarElementoTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(2, l.buscar(15));
    }

    @Test
    public void BuscarElementoInexistenteTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(-1, l.buscar(30));
    }

    @Test
    public void RetirarElementoTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.retirar(10);
        assertEquals(3, l.getTamanho());
        assertEquals("5,15,20", l.toString());
    }

    @Test
    public void RedimensionamentoTeste(){
        for (int i = 1; i <= 15; i++) {
            l.inserir(i);
        }

        assertEquals(15, l.getTamanho());
    }

    @Test
    public void ObterElementoTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(20, l.obterElemento(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ObterElementoTesteComExceção(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.obterElemento(5);
    }

    @Test
    public void VerificarLiberarTeste(){
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.liberar();
        assertEquals(true, l.estaVazia());
    }

}

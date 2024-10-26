package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class ListaDuplaTest {

    ListaDupla<Integer> l;

    @Before
    public void init() {
        l = new ListaDupla<>();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
    }

    @Test
    public void InclusaoListaDuplamenteEncadeadaTeste() {
        NoListaDupla<Integer> no = l.getPrimeiro();
        for (int i = 4; i > 0; i--) {
            assertEquals((Integer) (i * 5), no.getInfo());
            if (no.getProximo() != null) {
                no = no.getProximo();
            }
        }

        for (int i = 1; i < 5; i++) {
            assertEquals((Integer) (i * 5), no.getInfo());
            no = no.getAnterior();
        }

        assertEquals(null, no);

    }

    @Test
    public void BuscarElementoInicioTeste() {
        assertEquals((Integer) 20, l.buscar(20).getInfo());
    }

    @Test
    public void BuscarElementoMeioTeste() {
        assertEquals((Integer) 10, l.buscar(10).getInfo());
    }

    @Test
    public void RemoverElementoInicioTeste() {
        l.retirar(20);
        NoListaDupla<Integer> no = l.getPrimeiro();

        for (int i = 3; i > 0; i--) {
            assertEquals((Integer) (i * 5), no.getInfo());
            if (no.getProximo() != null) {
                no = no.getProximo();
            }
        }

        for (int i = 1; i < 4; i++) {
            assertEquals((Integer) (i * 5), no.getInfo());
            no = no.getAnterior();
        }

        assertEquals(null, no);
    }

    @Test
    public void RemoverElementoFimTeste() {
        l.retirar(5);
        NoListaDupla<Integer> no = l.getPrimeiro();

        for (int i = 4; i > 1; i--) {
            assertEquals((Integer) (i * 5), no.getInfo());
            if (no.getProximo() != null) {
                no = no.getProximo();
            }
        }

        for (int i = 2; i < 5; i++) {
            assertEquals((Integer) (i * 5), no.getInfo());
            no = no.getAnterior();
        }

        assertEquals(null, no);
    }

    @Test
    public void LiberarTeste() {
        
        NoListaDupla<Integer> no20 = l.getPrimeiro();
        NoListaDupla<Integer> no15 = no20.getProximo();
        NoListaDupla<Integer> no10 = no15.getProximo();
        NoListaDupla<Integer> no5 = no10.getProximo();

        l.liberar();

        assertEquals(null, no20.getAnterior());
        assertEquals(null, no20.getProximo());
        assertEquals(null, no15.getAnterior());
        assertEquals(null, no15.getProximo());
        assertEquals(null, no10.getAnterior());
        assertEquals(null, no10.getProximo());
        assertEquals(null, no5.getAnterior());
        assertEquals(null, no5.getProximo());
    }

}

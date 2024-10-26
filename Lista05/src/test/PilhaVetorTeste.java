package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class PilhaVetorTeste {

    PilhaVetor<Integer> p;

    @Before
    public void init() {
        p = new PilhaVetor<>(5);
    }

    @Test
    public void PilhaVaziaTeste() {
        assertEquals(true, p.estaVazia());
    }

    @Test
    public void PilhaNãoVaziaTeste() {
        p.push(10);
        assertEquals(false, p.estaVazia());
    }

    @Test
    public void EmpilharOrdemTeste() {
        p.push(10);
        p.push(20);
        p.push(30);
        assertEquals((Integer) 30, p.pop());        
        assertEquals((Integer) 20, p.pop());
        assertEquals((Integer) 10, p.pop());
        assertEquals(true, p.estaVazia());
    }

    @Test(expected = PilhaCheiaException.class)
    public void ExcederCapacidadeTeste() {
        p = new PilhaVetor<>(3);
        p.push(10);
        p.push(20);
        p.push(30);
        p.push(40);
    }

    @Test(expected = PilhaVaziaException.class)
    public void DesimpilharPilhaVaziaTeste() {
        p.pop();
    }

    @Test
    public void PeekTeste() {
        p.push(10);
        p.push(20);
        p.push(30);
        assertEquals((Integer) 30, p.peek());
        assertEquals((Integer) 30, p.pop());
    }

    @Test
    public void LiberarPilhaTeste() {
        p.push(10);
        p.push(20);
        p.push(30);
        p.liberar();
        assertEquals(true, p.estaVazia());
    }

    @Test
    public void ConcatenarTeste() {
        p.push(10);
        p.push(20);
        p.push(30);

        PilhaVetor<Integer> p2 = new PilhaVetor<>(2);

        p2.push(40);
        p2.push(50);
        p.concatenar(p2);
        assertEquals("50,40,30,20,10", p.toString());
    }


}
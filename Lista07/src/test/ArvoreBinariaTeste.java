package test;

import static org.junit.Assert.*;
import org.junit.*;

import model.*;

public class ArvoreBinariaTeste {

    ArvoreBinaria<Integer> a;

    @Before
    public void init() {
        a = new ArvoreBinaria<>();
    }

    @Test
    public void VaziaTeste() {
        assertTrue(a.estaVazia());
    }

    @Test
    public void NãoVaziaTeste() {
        NoArvoreBinaria<Integer> no = new NoArvoreBinaria<>(5);
        a.setRaiz(no);
        assertFalse(a.estaVazia());
    }

    @Test
    public void ToStringTeste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", a.toString());
    }

    @Test
    public void BuscarTrueNo1Teste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertTrue(a.pertence(1));
    }

    @Test
    public void BuscarTrueNo3Teste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertTrue(a.pertence(3));
    }

    @Test
    public void BuscarTrueNo6Teste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertTrue(a.pertence(6));
    }

    @Test
    public void BuscarTrueNo10Teste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertFalse(a.pertence(10));
    }

    @Test
    public void BuscarTrueNo10() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertFalse(a.pertence(10));
    }

    @Test
    public void ContarTeste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertEquals(6, a.ContarNos());
    }

    @Test
    public void ContarFolhasTeste() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);

        a.setRaiz(no1);

        assertEquals(false, a.pertence(10));
    }
}

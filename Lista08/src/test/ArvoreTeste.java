package test;

import static org.junit.Assert.*;
import org.junit.*;
import model.*;

public class ArvoreTeste {
    
    Arvore<Integer> a;

    @Before
    public void init(){
        a = new Arvore<>();

        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        a.setRaiz(no1);

        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        no1.setPrimeiro(no2);
        no2.setProximo(no3);
        no3.setProximo(no4);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        no2.setPrimeiro(no5);
        no5.setProximo(no6);
        no6.setProximo(no7);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8);
        no3.setPrimeiro(no8);

        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);
        no4.setPrimeiro(no9);
        no9.setProximo(no10);;
    }

    @Test
    public void StringTeste(){
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", a.toString());
    }

    @Test
    public void AcharNoTeste(){
        assertTrue(a.pertence(7));
    }

    @Test
    public void NaoAcharNoTeste(){
        assertFalse(a.pertence(55));
    }

    @Test
    public void ContarNosTeste(){
        assertEquals(10, a.ContarNos());
    }
}

package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ListaEstatica;

public class ListaEstaticaTeste {

    ListaEstatica<Integer> l;

    @Before
    public void init(){
        l = new ListaEstatica<>();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
    }

    @Test
    public void InverterComTamanhoParTeste(){
        l.inverter();
        assertEquals("20,15,10,5", l.toString());
    }
    
    @Test
    public void InverterComTamanhoImparTeste(){
        l.inserir(25);
        l.inverter();
        assertEquals("25,20,15,10,5", l.toString());
    }
    
    @Test
    public void InserirComPosicaoPositivaTeste(){
        l.inserir(2,3);
        assertEquals("5,10,3,15,20", l.toString());
    }

    @Test
    public void InserirPrimeiraPosicaoTeste(){
        l.inserir(0,45);
        assertEquals("45,5,10,15,20", l.toString());
    }

    @Test
    public void InserirUltimaPosicaoTeste(){
        l.inserir(3,45);
        assertEquals("5,10,15,45,20", l.toString());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void InserirComPosicaoNegativaTeste(){
        l.inserir(-8,45);
        assertEquals("45,5,10,15,20", l.toString());
    }

    @Test
    public void InserirComPosicaoMaiorQueTamanhoTeste(){
        l.inserir(5,25);
        assertEquals("5,10,15,20,25", l.toString());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void InserirComPosicaoMaiorQueTamanhoMaisUmTeste(){
        l.inserir(88,25);
        assertEquals("5,10,15,20,25", l.toString());
    }

    @Test
    public void InserirComPosicaoRedimensionarTeste(){
        l.inserir(25);
        l.inserir(30);
        l.inserir(35);
        l.inserir(40);
        l.inserir(45);
        l.inserir(50);
        l.inserir(55);
        assertEquals("5,10,15,20,25,30,35,40,45,50,55", l.toString());
    }
}
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
}
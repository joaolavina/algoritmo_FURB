package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ListaEncadeada;

public class ListaEncadeadaTeste {
    
    ListaEncadeada<Integer> l;

    @Before
    public void init(){
        l = new ListaEncadeada<>();
    }

    @Test 
    public void ListaVaziaTeste(){ //1
        assertEquals(true, l.estaVazia());
    }

    @Test
    public void ListaNaoVaziaTeste(){ //2
        l.inserir(5);
        assertEquals(false, l.estaVazia());
    }

    @Test
    public void InclusaoNumeroTeste(){ //3
        l.inserir(5);
        assertEquals((Integer) 5, l.obterNo(0).getInfo());
        assertEquals(1, l.obterComprimento());
    }

    @Test
    public void InclusaoTresNumeroTeste(){ //4
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        assertEquals(3, l.obterComprimento());
        assertEquals((Integer) 15, l.obterNo(0).getInfo());
        assertEquals((Integer) 10, l.obterNo(1).getInfo());
        assertEquals((Integer) 5, l.obterNo(2).getInfo());
    }

    @Test
    public void BuscaDadosPrimeiraPosicaoTeste(){ //5
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 20, l.buscar(20).getInfo());
    }

    @Test
    public void BuscarDadosMeioDaListaTeste(){ //6
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 15, l.buscar(15).getInfo());
    }

    @Test
    public void BuscarDadosInexistentesTeste(){ //7
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(null, l.buscar(50));
    }

    @Test
    public void ExclusaoDadoTeste(){ //8
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.retirar(20);
        assertEquals(3, l.obterComprimento());
        assertEquals((Integer) 15, l.obterNo(0).getInfo());
        assertEquals((Integer) 10, l.obterNo(1).getInfo());
        assertEquals((Integer) 5, l.obterNo(2).getInfo());
    }        

    @Test
    public void ExclusaoDadoMeioDaListaTeste(){ //9
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.retirar(15);
        assertEquals(3, l.obterComprimento());
        assertEquals((Integer) 20, l.obterNo(0).getInfo());
        assertEquals((Integer) 10, l.obterNo(1).getInfo());
        assertEquals((Integer) 5, l.obterNo(2).getInfo());
    }        

    @Test
    public void ObterNoTeste(){ //10
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 20, l.obterNo(0).getInfo());
    }        

    @Test
    public void ObterUltimoNoTeste(){ //11
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 5, l.obterNo(3).getInfo());
    }        

    @Test(expected = IndexOutOfBoundsException.class)
    public void ObterNoInexistenteTeste(){ //12
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.obterNo(10);
    }        
    
    @Test
    public void ObterComprimentoListaVaziaTeste(){ //13
        assertEquals(0, l.obterComprimento());
    }        
    
    @Test
    public void ObterComprimentoListaNaoVaziaTeste(){ //14
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(4, l.obterComprimento());
    }        

}
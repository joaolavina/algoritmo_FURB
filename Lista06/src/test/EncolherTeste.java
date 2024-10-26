package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.FilaVetor;

public class EncolherTeste {
    
    FilaVetor<Integer> f;

    @Before
    public void init(){
        f = new FilaVetor<>(9);

        for (int i = 0; i < 7; i++) {
            f.inserir(i);
        }

        f.retirar();
        f.retirar();
        f.retirar();
    }

    @Test
    public void TamanhoTeste(){
        f.encolher();
        assertEquals(4,f.tamanho);
    }

    @Test
    public void ToStringTeste(){
        f.encolher();
        assertEquals("3,4,5,6",f.toString());
    }

    @Test
    public void InicioTeste(){
        f.encolher();
        assertEquals(0, f.inicio);
    }

    @Test
    public void LimiteTeste(){
        f.encolher();
        assertEquals(f.tamanho, f.limite);
    }
}

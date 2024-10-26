package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import model.*;

public class MapaDispersaoTeste {

    MapaDispersao<Aluno> m;
    Aluno obj1;
    Aluno obj2;
    Aluno obj3;
    Aluno obj4;

    @Before
    public void init() {
        m = new MapaDispersao<>(53);
    }

    @Test
    public void LocalizarDadoTeste(){
        obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        m.inserir(12000, obj1);

        obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        m.inserir(14000, obj2);

        obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        m.inserir(12500, obj3);

        obj4 = new Aluno(13000 , "Lucas", LocalDate.of(1998, 11, 25));
        m.inserir(13000 , obj4);

        m.realocarMapa(5);

        assertEquals(obj1, m.buscar(12000));
    }

    @Test
    public void LocalizarDadosTeste(){
        obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        m.inserir(12000, obj1);

        obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        m.inserir(14000, obj2);

        obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        m.inserir(12500, obj3);

        obj4 = new Aluno(13000 , "Lucas", LocalDate.of(1998, 11, 25));
        m.inserir(13000 , obj4);

        assertEquals(obj1, m.buscar(12000));
        assertEquals(obj2, m.buscar(14000));
        assertEquals(obj3, m.buscar(12500));
        assertEquals(obj4, m.buscar(13000));
    }

    @Test
    public void LocalizarDadosColisaoTeste(){
        obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        m.inserir(12000, obj1);

        obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        m.inserir(14000, obj2);

        obj3 = new Aluno(14226 , "Marta", LocalDate.of(2001, 2, 18));
        m.inserir(14226 , obj3);

        obj4 = new Aluno(13000 , "Lucas", LocalDate.of(1998, 11, 25));
        m.inserir(17180 , obj4);

        assertEquals(obj1, m.buscar(12000));
        assertEquals(obj2, m.buscar(14000));
        assertEquals(obj3, m.buscar(14226));
        assertEquals(obj4, m.buscar(17180));
    }

    @Test
    public void TestarTamanho(){
        obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        m.inserir(12000, obj1);

        obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        m.inserir(14000, obj2);

        obj3 = new Aluno(72 , "Marta", LocalDate.of(2001, 2, 18));
        m.inserir(14226 , obj3);

        obj4 = new Aluno(42 , "Lucas", LocalDate.of(1998, 11, 25));
        m.inserir(17180 , obj4);

        m.realocarMapa(15);
        assertEquals(15, m.info.length);
    }

    @Test
    public void Colisao(){
        obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        m.inserir(12000, obj1);

        obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        m.inserir(14000, obj2);

        obj3 = new Aluno(72 , "Marta", LocalDate.of(2001, 2, 18));
        m.inserir(72 , obj3);

        obj4 = new Aluno(42 , "Lucas", LocalDate.of(1998, 11, 25));
        m.inserir(42 , obj4);

        m.realocarMapa(15);
        assertEquals(obj3, m.buscar(72));
        assertEquals(obj4, m.buscar(42));
    }
}

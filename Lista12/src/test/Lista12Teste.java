package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import view.*;

public class Lista12Teste {
    
    Integer[] vetor = {70,2,88,15,90,30};
    Integer[] vetorOrganizado = {2,15,30,70,88,90};
    OrdenacaoAbstract<Integer> ordenacao;

    @Test
    public void OrdenacaoBolhaTeste(){
        OrdenacaoBolha<Integer> ordenacao = new OrdenacaoBolha<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();

        assertArrayEquals(vetorOrganizado, ordenacao.getInfo());
    }

    @Test
    public void OrdenacaoBolhaOtimizadaTeste(){
        OrdenacaoBolhaOtimizada<Integer> ordenacao = new OrdenacaoBolhaOtimizada<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();

        assertArrayEquals(vetorOrganizado, ordenacao.getInfo());
    }

    @Test
    public void OrdenacaoQuickSortTeste(){
        OrdenacaoQuickSort<Integer> ordenacao = new OrdenacaoQuickSort<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();

        assertArrayEquals(vetorOrganizado, ordenacao.getInfo());
    }

    @Test
    public void OrdenacaoMergeSortTeste(){
        OrdenacaoMergeSort<Integer> ordenacao = new OrdenacaoMergeSort<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();

        assertArrayEquals(vetorOrganizado, ordenacao.getInfo());
    }
}

package org.ufpi.domain;

import java.math.BigDecimal;

public class Hibrido {
    static BigDecimal comparacoes = BigDecimal.ZERO;
    public static BigDecimal hibrido(int[] vetor, int length) {
        //verica se o vetor estar ordenado, se estiver apenas retorna o vetor
        boolean ordCres = verificaOrdenacaoCrecente(vetor, length);
        if (ordCres){
            return comparacoes;
        }
        //ok


        //verica se o vetor estar decrescente, se estiver chama o mergeSort e retorna o vetor
        boolean ordDecres = verificaOrdenacaoDecrescente(vetor, length);
        if (ordDecres){
            return comparacoes = comparacoes.add(MergeSort.mergeSort(vetor, 0, length-1));
            //ok
        }
        //usar o insertSort para ordenar o vetor
        return InsertionSort.insertionSort(vetor, length);
    }

    static boolean verificaOrdenacaoCrecente(int vetor[], int tamanho) {
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i - 1] > vetor[i]) {
                comparacoes = comparacoes.add(BigDecimal.ONE);
                return false;
            }
        }
        return true;
    }

    static boolean verificaOrdenacaoDecrescente(int vetor[], int tamanho) {
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i - 1] < vetor[i]) {
                comparacoes = comparacoes.add(BigDecimal.ONE);
                return false;
            }
        }
        return true;
    }
}

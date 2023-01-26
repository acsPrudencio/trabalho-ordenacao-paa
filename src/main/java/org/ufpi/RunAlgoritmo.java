package org.ufpi;

import org.ufpi.domain.*;
import org.ufpi.domain.enums.AlgoritmoEnum;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Locale;

import static org.ufpi.util.GeradorNumeros.*;

public class RunAlgoritmo {
    static double tempoExecucaoAleatorio = 0;
    static double tempoExecucaoCrescente = 0;
    static double tempoExecucaoDecrescente = 0;
    static BigInteger comparacoesAleatorio = BigInteger.ZERO;
    static BigInteger comparacoesCrescente = BigInteger.ZERO;
    static BigInteger comparacoesDecrescente = BigInteger.ZERO;
    public static void executa(int tamanho, int repeticoes, AlgoritmoEnum algoritmo) {
        Locale.setDefault(Locale.forLanguageTag("en-US"));

        for (int i = 0; i < repeticoes; i++){
            processar(tamanho, algoritmo);
        }
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(algoritmo + ": Media tempo de execução aleatorios: " + df.format(tempoExecucaoAleatorio /3) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações aleatorios: " + comparacoesAleatorio.divide(BigInteger.valueOf(3)));

        System.out.println(algoritmo + ": Media tempo de execução crescentes: " + df.format(tempoExecucaoCrescente) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações crescentes: " + comparacoesCrescente.divide(BigInteger.valueOf(3)));

        System.out.println(algoritmo + ": Media tempo de execução decrecente: " + df.format(tempoExecucaoDecrescente /3) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações decrecente: " + comparacoesDecrescente.divide(BigInteger.valueOf(3)));


    }
    public static void processar(int TAM, AlgoritmoEnum algoritmo) {

        // gerar o vetor com numeros

        int[] numerosAleatorios = gerarNumerosAleatorios(TAM);
        int[] numerosCrescentes = gerarNumerosCrescentes(TAM);
        int[] numerosDecrecente = gerarNumerosDecrescentes(TAM);

        // pegar tempo atual do sistema
        long inicio = System.nanoTime();
        // chamar funcao de ordenacao
        int comparacoes = 0;

        comparacoes = ordenarVetor(algoritmo, numerosAleatorios);
        // pegar tempo atual do sistema
        long fim = System.nanoTime();
        // calcular diferenca entre os tempos
        DecimalFormat df = new DecimalFormat("#.######");
        double tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoAleatorio += tempoDeExecucao;
        comparacoesAleatorio = comparacoesAleatorio.add(BigInteger.valueOf(comparacoes));


        // pegar tempo atual do sistema
        inicio = System.nanoTime();
        // chamar funcao de ordenacao
        comparacoes = ordenarVetor(algoritmo, numerosCrescentes);
        // pegar tempo atual do sistema
        fim = System.nanoTime();
        // calcular diferenca entre os tempos
        tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoCrescente += tempoDeExecucao;
        comparacoesCrescente = comparacoesCrescente.add(BigInteger.valueOf(comparacoes));

        // pegar tempo atual do sistema
        inicio = System.nanoTime();
        // chamar funcao de ordenacao
        comparacoes = ordenarVetor(algoritmo, numerosDecrecente);
        // pegar tempo atual do sistema
        fim = System.nanoTime();
        // calcular diferenca entre os tempos
        tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoDecrescente += tempoDeExecucao;
        comparacoesDecrescente = comparacoesDecrescente.add(BigInteger.valueOf(comparacoes));

    }

    private static int ordenarVetor(AlgoritmoEnum algoritmo, int[] vetor) {
        int comparacoes = 0;
        switch (algoritmo){
            case BUBBLESORT -> comparacoes = BubbleSort.bubbleSort(vetor, vetor.length);
            case HEAPSORT -> comparacoes = HeapSort.heapSort(vetor, vetor.length);
            case INSERTIONSORT -> comparacoes = InsertionSort.insertionSort(vetor, vetor.length);
            case MERGESORT -> comparacoes = MergeSort.mergeSort(vetor, 0, vetor.length-1);
            case QUICKSORT -> comparacoes = QuickSort.quickSort(vetor, 0, vetor.length-1);
        }
        return comparacoes;
    }
}

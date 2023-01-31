package org.ufpi;

import org.ufpi.domain.*;
import org.ufpi.domain.enums.AlgoritmoEnum;
import org.ufpi.util.TabelaLayout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.ufpi.util.GeradorNumeros.*;

public class RunAlgoritmo {
    static BigDecimal tempoExecucaoAleatorio = BigDecimal.ZERO;
    static BigDecimal tempoExecucaoCrescente = BigDecimal.ZERO;
    static BigDecimal tempoExecucaoDecrescente = BigDecimal.ZERO;
    static BigDecimal comparacoesAleatorio = BigDecimal.ZERO;
    static BigDecimal comparacoesCrescente = BigDecimal.ZERO;
    static BigDecimal comparacoesDecrescente = BigDecimal.ZERO;

    public static List<TabelaLayout> executa(int tamanho, int repeticoes, AlgoritmoEnum algoritmo) {
        Locale.setDefault(Locale.forLanguageTag("en-US"));

        for (int i = 0; i < repeticoes; i++) {
            processar(tamanho, algoritmo);
        }

        System.out.println(algoritmo + ": Media tempo de execução aleatorios: " + tempoExecucaoAleatorio.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações aleatorios: " + comparacoesAleatorio.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_UP));
        System.out.println(algoritmo + ": Media tempo de execução crescentes: " + tempoExecucaoCrescente.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações crescentes: " + comparacoesCrescente.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_UP));
        System.out.println(algoritmo + ": Media tempo de execução decrecente: " + tempoExecucaoDecrescente.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações decrecente: " + comparacoesDecrescente.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_UP));

        List<TabelaLayout> dadosProcessado = new ArrayList<>();
        dadosProcessado.add(new TabelaLayout(algoritmo.toString() + " Aleatorio: ", tempoExecucaoAleatorio.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP), comparacoesAleatorio.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_UP)));
        dadosProcessado.add(new TabelaLayout(algoritmo.toString() + " Crescente: ", tempoExecucaoCrescente.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP), comparacoesCrescente.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_UP)));
        dadosProcessado.add(new TabelaLayout(algoritmo.toString() + " Decrescente: ", tempoExecucaoDecrescente.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP), comparacoesDecrescente.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_UP)));

        return dadosProcessado;

    }

    public static void processar(int TAM, AlgoritmoEnum algoritmo) {

        int[] numerosAleatorios = gerarNumerosAleatorios(TAM);
        int[] numerosCrescentes = gerarNumerosCrescentes(TAM);
        int[] numerosDecrecente = gerarNumerosDecrescentes(TAM);

        long inicio = System.nanoTime();
        BigDecimal comparacoes = BigDecimal.ZERO;

        comparacoes = comparacoes.add(ordenarVetor(algoritmo, numerosAleatorios));
        long fim = System.nanoTime();
        double tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoAleatorio = tempoExecucaoAleatorio.add(BigDecimal.valueOf(tempoDeExecucao));
        comparacoesAleatorio = comparacoesAleatorio.add(comparacoes);


        inicio = System.nanoTime();
        comparacoes = ordenarVetor(algoritmo, numerosCrescentes);
        fim = System.nanoTime();
        tempoDeExecucao = (fim - inicio) / 1000000000.0;

        tempoExecucaoCrescente = tempoExecucaoCrescente.add(BigDecimal.valueOf(tempoDeExecucao));
        comparacoesCrescente = comparacoesCrescente.add(comparacoes);

        inicio = System.nanoTime();
        comparacoes = ordenarVetor(algoritmo, numerosDecrecente);
        fim = System.nanoTime();
        tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoDecrescente = tempoExecucaoDecrescente.add(BigDecimal.valueOf(tempoDeExecucao));
        comparacoesDecrescente = comparacoesDecrescente.add(comparacoes);

    }

    private static BigDecimal ordenarVetor(AlgoritmoEnum algoritmo, int[] vetor) {
        BigDecimal comparacoes = BigDecimal.ZERO;
        switch (algoritmo) {
            case BUBBLESORT -> comparacoes = BubbleSort.bubbleSort(vetor, vetor.length);
            case HEAPSORT -> comparacoes = HeapSort.heapSort(vetor, vetor.length);
            case INSERTIONSORT -> comparacoes = InsertionSort.insertionSort(vetor, vetor.length);
            case MERGESORT -> comparacoes = MergeSort.mergeSort(vetor, 0, vetor.length - 1);
            case QUICKSORT -> comparacoes = QuickSort.quickSort(vetor, 0, vetor.length - 1);
            case HIBRIDO -> comparacoes = Hibrido.hibrido(vetor,vetor.length);
        }
        return comparacoes;
    }
}

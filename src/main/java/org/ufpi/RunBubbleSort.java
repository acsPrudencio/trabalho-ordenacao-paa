package org.ufpi;

import org.ufpi.domain.BubbleSort;

import java.text.DecimalFormat;

import static org.ufpi.util.GeradorNumeros.*;
import static org.ufpi.util.GeradorNumeros.gerarNumerosCrescentes;

public class RunBubbleSort {
    static double tempoExecucaoAleatorio = 0;
    static double tempoExecucaoCrescente = 0;
    static double tempoExecucaoDecrescente = 0;
    static double comparacoesAleatorio = 0;
    static double comparacoesCrescente = 0;
    static double comparacoesDecrescente = 0;
    public void executa(int tamanho, int repeticoes) {
        for (int i = 0; i < repeticoes; i++){
            bubbleSort(tamanho);
        }
        String algoritmo = "BubbleSort";
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(algoritmo + ": Media tempo de execução aleatorios: " + df.format(tempoExecucaoAleatorio /3) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações aleatorios: " + comparacoesAleatorio /3);

        System.out.println(algoritmo + ": Media tempo de execução crescentes: " + df.format(tempoExecucaoCrescente) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações crescentes: " + comparacoesCrescente /3);

        System.out.println(algoritmo + ": Media tempo de execução decrecente: " + df.format(tempoExecucaoDecrescente /3) + " segundos");
        System.out.println(algoritmo + ": Media da quantidade de comparações decrecente: " + comparacoesDecrescente /3);


    }
    public static void bubbleSort(int REPT) {

        // gerar o vetor com numeros

        int[] numerosAleatorios = gerarNumerosAleatorios(REPT);
        int[] numerosCrescentes = gerarNumerosCrescentes(REPT);
        int[] numerosDecrecente = gerarNumerosDecrescentes(REPT);

        // pegar tempo atual do sistema
        long inicio = System.nanoTime();
        // chamar funcao de ordenacao
        int comparacoes = BubbleSort.bubbleSort(numerosAleatorios, numerosAleatorios.length);
        // pegar tempo atual do sistema
        long fim = System.nanoTime();
        // calcular diferenca entre os tempos
        DecimalFormat df = new DecimalFormat("#.######");
        double tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoAleatorio += tempoDeExecucao;
        comparacoesAleatorio += comparacoes;


        // pegar tempo atual do sistema
        inicio = System.nanoTime();
        // chamar funcao de ordenacao
        comparacoes = BubbleSort.bubbleSort(numerosCrescentes, numerosCrescentes.length);
        // pegar tempo atual do sistema
        fim = System.nanoTime();
        // calcular diferenca entre os tempos
        tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoCrescente += tempoDeExecucao;
        comparacoesCrescente += comparacoes;

        // pegar tempo atual do sistema
        inicio = System.nanoTime();
        // chamar funcao de ordenacao
        comparacoes = BubbleSort.bubbleSort(numerosDecrecente, numerosDecrecente.length);
        // pegar tempo atual do sistema
        fim = System.nanoTime();
        // calcular diferenca entre os tempos
        tempoDeExecucao = (fim - inicio) / 1000000000.0;
        tempoExecucaoDecrescente += tempoDeExecucao;
        comparacoesDecrescente += comparacoes;

    }
}

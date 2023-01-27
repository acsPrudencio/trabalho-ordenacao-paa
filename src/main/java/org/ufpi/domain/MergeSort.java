package org.ufpi.domain;

import java.math.BigDecimal;


public class MergeSort {

    public static BigDecimal merge(int[] numeros, int inicio, int meio, int fim) {
        BigDecimal count = BigDecimal.ZERO;
        int esquerda = meio - inicio + 1;
        int direita = fim - meio;

        int[] vetorEsquerda = new int[esquerda];
        int[] vetorDireita = new int[direita];
        int i;
        int j;
        int k = 0;
        for (i = 0; i < esquerda; i++) {
            vetorEsquerda[i] = numeros[inicio + i];
        }
        for (j = 0; j < direita; j++) {
            vetorDireita[j] = numeros[meio + j + 1];
        }
        i = 0;
        j = 0;
        k = inicio;
        while (i < esquerda && j < direita) {
            count = count.add(BigDecimal.valueOf(1));

            if (vetorEsquerda[i] <= vetorDireita[j]) {
                numeros[k] = vetorEsquerda[i];
                i = i + 1;
            } else {
                numeros[k] = vetorDireita[j];
                j = j + 1;
            }
            k = k + 1;
        }
        while (i < esquerda) {
            count = count.add(BigDecimal.valueOf(1));
            numeros[k] = vetorEsquerda[i];
            i = i + 1;
            k = k + 1;
        }
        while (j < direita) {
            count = count.add(BigDecimal.valueOf(1));
            numeros[k] = vetorDireita[j];
            j = j + 1;
            k = k + 1;
        }

        return count;
    }

    public static BigDecimal mergeSort(int[] numeros, int inicio, int fim) {
        BigDecimal count = BigDecimal.ZERO;

        if (inicio >= fim) {
            return count;
        } else {
            int meio = (inicio + fim) / 2;
            count = count.add(mergeSort(numeros, inicio, meio));
            count = count.add(mergeSort(numeros, meio + 1, fim));
            count = count.add(merge(numeros, inicio, meio, fim));
        }
        return count;
    }
}

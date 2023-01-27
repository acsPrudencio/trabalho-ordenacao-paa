package org.ufpi.domain;

import java.math.BigDecimal;

// CODIGO DO JOAO RODRIGUES
public class HeapSort {

    public static BigDecimal heapSort(int[] arr, int n) {
        BigDecimal iterCount = BigDecimal.ZERO;
        // Construir o heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrair um elemento por vez do heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            iterCount = iterCount.add(heapify(arr, i, 0));
        }
        return iterCount;
    }

    private static BigDecimal heapify(int[] arr, int n, int i) {
        BigDecimal iterCount = BigDecimal.ZERO;
        int largest = i; // Inicializa como raiz
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // Se o filho da esquerda for maior que a raiz
        if (l < n && arr[l] > arr[largest]) {
            iterCount = iterCount.add(BigDecimal.valueOf(1));
            largest = l;
        }

        // Se o filho da direita for maior que a raiz
        if (r < n && arr[r] > arr[largest]) {
            iterCount = iterCount.add(BigDecimal.valueOf(1));
            largest = r;
        }

        // Se não for a raiz
        if (largest != i) {
            iterCount = iterCount.add(BigDecimal.valueOf(1));
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
        return iterCount;
    }
}

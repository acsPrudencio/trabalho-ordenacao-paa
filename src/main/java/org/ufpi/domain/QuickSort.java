package org.ufpi.domain;

import java.math.BigDecimal;
import java.util.Random;

public class QuickSort {
    private static BigDecimal iterCount = BigDecimal.ZERO;

    public static BigDecimal quickSort(int[] A, int p, int r) {
        BigDecimal iterCount = BigDecimal.ZERO;

        if (p < r) {
            iterCount = iterCount.add(BigDecimal.valueOf(1));
            // q é o índice da particion
            int q = partitionRandomized(A, p, r);
            // Recursivamente ordenar elementos antes e depois
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }

        return iterCount;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index do menor elemento
        for (int j = low; j < high; j++) {
            // Se o elemento atual é menor ou igual ao pivot
            if (arr[j] <= pivot) {
                iterCount = iterCount.add(BigDecimal.valueOf(1));
                i++;
                // Troca
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static int partitionRandomized(int[] A, int p, int r) {
        int i = new Random().nextInt(p, r);
        iterCount = iterCount.add(BigDecimal.valueOf(1));
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return i;
    }
}

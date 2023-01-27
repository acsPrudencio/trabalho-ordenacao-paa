package org.ufpi.domain;

import java.math.BigDecimal;

public class InsertionSort {

    public static BigDecimal insertionSort(int[] numeros, int length) {
        BigDecimal count = BigDecimal.ZERO;

        for (int i = 1; i < length; i++) {
            int key = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > key) {
                numeros[j + 1] = numeros[j];
                j = j - 1;
                count = count.add(BigDecimal.valueOf(1));

            }
            numeros[j + 1] = key;
        }
        return count;
    }
}

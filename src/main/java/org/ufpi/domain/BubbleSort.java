package org.ufpi.domain;


import java.math.BigDecimal;

public class BubbleSort {
    public static BigDecimal bubbleSort(int[] numeros, int length) {
        BigDecimal cont = BigDecimal.ZERO;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (numeros[j] < numeros[j - 1]) {
                    cont = cont.add(BigDecimal.valueOf(1));
                    int aux = numeros[j];
                    numeros[j] = numeros[j - 1];
                    numeros[j - 1] = aux;
                }
            }
        }
        return cont;
    }
}
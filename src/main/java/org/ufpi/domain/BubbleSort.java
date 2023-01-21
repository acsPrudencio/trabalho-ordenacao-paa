package org.ufpi.domain;



public class BubbleSort {
    public static int bubbleSort(int[] numeros, int length) {
        int cont = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (numeros[j] < numeros[j - 1]) {
                    cont += 1;
                    int aux = numeros[j];
                    numeros[j] = numeros[j - 1];
                    numeros[j - 1] = aux;
                }
            }
        }
        return cont;
    }
}
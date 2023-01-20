package org.ufpi;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] numeros = {8, 3, 9, 1, 5};
        System.out.println("iteracoes: " + bubbleSort(numeros, numeros.length));
    }

    public static int bubbleSort(Integer[] numeros, int length) {
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
//        Arrays.stream(numeros).forEach(System.out::println);
        return cont;
    }
}
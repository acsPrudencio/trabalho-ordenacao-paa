package org.ufpi;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer [] numeros = {9,6,3,5,8,4,8,6};
        System.out.println("iteracoes " + insertionSort(numeros, numeros.length));
    }

    public static int insertionSort(Integer[] numeros, int length){
        int count = 0;
        for (int i = 1; i<length; i++){
            int key = numeros[i];
            int j = i-1;
            while (j >= 0 && numeros[j] > key){
                numeros[j+1] = numeros[j];
                j = j -1;
                count++;
            }
            numeros[j+1] = key;
        }
//        Arrays.stream(numeros).forEach(System.out::println);
        return count;
    }
}

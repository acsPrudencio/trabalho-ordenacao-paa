package org.ufpi.domain;

public class InsertionSort {

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
        return count;
    }
}

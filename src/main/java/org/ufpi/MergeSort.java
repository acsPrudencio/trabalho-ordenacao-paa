package org.ufpi;

import java.util.Arrays;


public class MergeSort {
    public static void main(String[] args) {
        int [] numeros = {0,9,7,4,1,19,0,3,5};
        System.out.println(mergeSort(numeros, 0, numeros.length-1));
    }

    public static int merge(int [] numeros, int inicio, int meio, int fim){
        int count = 0;
        int esquerda = meio - inicio + 1;
        int direita = fim - meio;

        int [] vetorEsquerda = new int[esquerda];
        int [] vetorDireita = new int[direita];
        int i;
        int j;
        int k = 0;
        for (i = 0; i < esquerda; i++){
            vetorEsquerda[i] = numeros[inicio+i];
        }
        for (j = 0; j < direita; j++){
            vetorDireita[j] = numeros[meio+j+1];
        }
        i = 0;
        j = 0;
        k = inicio;
        while (i < esquerda && j < direita){
            count++;
            if (vetorEsquerda[i] <= vetorDireita[j]){
                numeros[k] = vetorEsquerda[i];
                i  = i + 1;
            }else{
                numeros[k] = vetorDireita[j];
                j = j + 1;
            }
            k = k + 1;
        }
        while (i < esquerda){
            count++;
            numeros[k] = vetorEsquerda[i];
            i = i + 1;
            k = k + 1;
        }
        while (j < direita){
            count++;
            numeros[k] = vetorDireita[j];
            j = j + 1;
            k = k + 1;
        }

        return count;
    }
    public static int mergeSort(int [] numeros, int inicio, int fim){
        int count = 0;
        if(inicio >= fim){
            return count;
        }else {
            int meio = (inicio+fim)/2;
            count += mergeSort(numeros, inicio, meio);
            count += mergeSort(numeros, meio+1, fim);
            count += merge(numeros, inicio, meio, fim);
        }
        System.out.println(Arrays.toString(numeros));
        return count;
    }
}

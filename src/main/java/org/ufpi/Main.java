package org.ufpi;

import org.ufpi.domain.enums.AlgoritmoEnum;

public class Main {
    public static void main(String[] args) {

        int TAM = 30000;
        int REPT = 3;
        RunAlgoritmo.executa(TAM,REPT, AlgoritmoEnum.BUBBLESORT);
        RunAlgoritmo.executa(TAM,REPT, AlgoritmoEnum.HEAPSORT);
        RunAlgoritmo.executa(TAM,REPT, AlgoritmoEnum.INSERTIONSORT);
        RunAlgoritmo.executa(TAM,REPT, AlgoritmoEnum.QUICKSORT);
        RunAlgoritmo.executa(TAM,REPT, AlgoritmoEnum.MERGESORT);
    }
}

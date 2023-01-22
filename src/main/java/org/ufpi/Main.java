package org.ufpi;

import org.ufpi.domain.enums.AlgoritmoEnum;

public class Main {
    public static void main(String[] args) {
        RunAlgoritmo.executa(500,3, AlgoritmoEnum.BUBBLESORT);
        RunAlgoritmo.executa(500,3, AlgoritmoEnum.HEAPSORT);
        RunAlgoritmo.executa(500,3, AlgoritmoEnum.INSERTIONSORT);
        RunAlgoritmo.executa(500,3, AlgoritmoEnum.QUICKSORT);
        RunAlgoritmo.executa(500,3, AlgoritmoEnum.MERGESORT);
    }
}

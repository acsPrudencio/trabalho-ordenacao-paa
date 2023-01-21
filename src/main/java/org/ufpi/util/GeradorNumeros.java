package org.ufpi.util;

import java.util.Random;

public class GeradorNumeros {
    public static int[] gerarNumerosAleatorios(int n) {
        int[] numeros = new int[n];
        Random gerador = new Random();

        for (int i = 0; i < n; i++) {
            numeros[i] = gerador.nextInt();
        }
        return numeros;
    }

    public static int[] gerarNumerosCrescentes(int n) {
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = i;
        }
        return numeros;
    }

    public static int[] gerarNumerosDecrescentes(int n) {
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = n - i - 1;
        }
        return numeros;
    }
}

package org.ufpi;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.ufpi.domain.enums.AlgoritmoEnum;
import org.ufpi.util.TabelaLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.ufpi.CriarTabela.popularTabela;

public class Main {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("TabelaComparacoes");

        List<Integer> exec = new ArrayList<>(Arrays.asList(100, 500, 1000, 5000, 30000, 50000, 100000, 150000, 200000));

        exec.stream().forEach(TAM -> {
            int REPT = 3;
//            List<TabelaLayout> bubble = RunAlgoritmo.executa(TAM, REPT, AlgoritmoEnum.BUBBLESORT);
//            popularTabela(bubble, 0, sheet, workbook, TAM);
//            List<TabelaLayout> heap = RunAlgoritmo.executa(TAM, REPT, AlgoritmoEnum.HEAPSORT);
//            popularTabela(heap, 3, sheet, workbook, TAM);
//            List<TabelaLayout> insertion = RunAlgoritmo.executa(TAM, REPT, AlgoritmoEnum.INSERTIONSORT);
//            popularTabela(insertion, 6, sheet, workbook, TAM);
//            List<TabelaLayout> merge = RunAlgoritmo.executa(TAM, REPT, AlgoritmoEnum.MERGESORT);
//            popularTabela(merge, 9, sheet, workbook, TAM);
//            List<TabelaLayout> quick = RunAlgoritmo.executa(TAM, REPT, AlgoritmoEnum.QUICKSORT);
//            popularTabela(quick, 12, sheet, workbook, TAM);
            List<TabelaLayout> algHibrido = RunAlgoritmo.executa(TAM, REPT, AlgoritmoEnum.HIBRIDO);
            popularTabela(algHibrido, 0, sheet, workbook, TAM);

        });

    }
}

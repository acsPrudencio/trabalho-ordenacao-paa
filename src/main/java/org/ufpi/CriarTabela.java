package org.ufpi;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.ufpi.util.TabelaLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CriarTabela {

    public static void popularTabela(List<TabelaLayout> dados, int incio, HSSFSheet sheetAlunos,HSSFWorkbook workbook, int TAM) {

        int rownum = incio;

        for(TabelaLayout tb: dados){
            Row row = sheetAlunos.createRow(rownum++);
            int cellnum = 0;
            Cell cellAlgoritmo = row.createCell(cellnum++);
            cellAlgoritmo.setCellValue(tb.getAlgoritmo());
            Cell cellTempoExecucao = row.createCell(cellnum++);
            cellTempoExecucao.setCellValue(""+tb.getTempoExecucao());
            Cell cellComparacoes = row.createCell(cellnum++);
            cellComparacoes.setCellValue(tb.getComparacoes().toString());
        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File("Tabela"+TAM+".xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
        }
    }



}

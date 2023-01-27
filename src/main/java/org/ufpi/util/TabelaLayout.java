package org.ufpi.util;


import java.math.BigDecimal;


public class TabelaLayout {
    public String algoritmo;
    public BigDecimal tempoExecucao = BigDecimal.ZERO;
    public BigDecimal comparacoes = BigDecimal.ZERO;

    public TabelaLayout() {
    }

    public TabelaLayout(String algoritmo, BigDecimal tempoExecucao, BigDecimal comparacoes) {
        this.algoritmo = algoritmo;
        this.tempoExecucao = tempoExecucao;
        this.comparacoes = comparacoes;
    }


    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public BigDecimal getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(BigDecimal tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public BigDecimal getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(BigDecimal comparacoes) {
        this.comparacoes = comparacoes;
    }
}

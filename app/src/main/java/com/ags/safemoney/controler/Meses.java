package com.ags.safemoney.controler;

/**
 * Created by luiz.alexandre on 10/01/2017.
 */

public enum Meses {
    JANEIRO(1), FEVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5), JUNHO(6),
    JULHO(7), AGOSTO(8), SETEMBRO(9), OUTUBRO(10), NOVEMBRO(11), DEZEMBRO(12);

    private int valor;

    Meses(int valorMes) {
        valor = valorMes;
    }

    public int getValor() {
        return valor;
    }
}

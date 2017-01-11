package com.ags.safemoney.model;

import com.orm.SugarRecord;

/**
 * Created by luiz.alexandre on 10/01/2017.
 */

public class Despesa extends SugarRecord {

    private String descricao;
    private String mes;
    private Double valor;

    public Despesa() {
    }

    public Despesa(String descricao, String mes, Double valor) {
        this.descricao = descricao;
        this.mes = mes;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

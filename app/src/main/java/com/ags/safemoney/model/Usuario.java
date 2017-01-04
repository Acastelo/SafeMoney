package com.ags.safemoney.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by luiz.alexandre on 02/01/2017.
 */

public class Usuario extends SugarRecord {
    private String nome;

    @Unique
    private String email;
    private String senha;

    public Usuario(){ }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

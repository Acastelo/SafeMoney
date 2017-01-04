package com.ags.safemoney.controler;

import com.ags.safemoney.model.Usuario;

/**
 * Created by luiz.alexandre on 04/01/2017.
 */

public interface IController {

    void salvar(Usuario usuario);
    void listarTodos();
    void listar();

}

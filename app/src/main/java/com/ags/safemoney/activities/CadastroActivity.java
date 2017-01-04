package com.ags.safemoney.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ags.safemoney.R;
import com.ags.safemoney.controler.UsuarioController;
import com.ags.safemoney.controler.exception.ControllerException;
import com.ags.safemoney.model.Usuario;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnCriaConta;
    private TextView txtLogin;

    private Usuario usuario;
    private UsuarioController controller;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText) findViewById(R.id.cad_nome);
        edtEmail = (EditText) findViewById(R.id.cad_email);
        edtSenha = (EditText) findViewById(R.id.cad_senha);

        btnCriaConta = (Button) findViewById(R.id.btn_cria_conta);
        btnCriaConta.setOnClickListener(new BtnCriaContaListener());

        txtLogin = (TextView) findViewById(R.id.link_login);
        txtLogin.setOnClickListener(new LinkLoginListener());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void limpar(){
        edtNome.setText("");
        edtEmail.setText("");
        edtSenha.setText("");
    }
    private class LinkLoginListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            finish();
        }
    }

    private class BtnCriaContaListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String nome = edtNome.getText().toString();
            String email = edtEmail.getText().toString();
            String senha = edtSenha.getText().toString();

            usuario = new Usuario(nome, email, senha);
            try {
                usuario.save();
                Toast.makeText(CadastroActivity.this, getString(R.string.cadastro_ok), Toast.LENGTH_LONG).show();
            }catch (ControllerException e){
                e.printStackTrace();
                Toast.makeText(CadastroActivity.this, getString(R.string.cadastro_fail), Toast.LENGTH_LONG).show();
            }
            limpar();
        }
    }
}

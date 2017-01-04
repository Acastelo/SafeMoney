package com.ags.safemoney.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ags.safemoney.R;
import com.ags.safemoney.model.Usuario;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText edtLoginEmail;
    private EditText edtLoginSenha;
    private TextView txtConta;
    private Button btnLogin;

    private String email;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtLoginEmail = (EditText) findViewById(R.id.edtLoginEmail);
        edtLoginSenha = (EditText) findViewById(R.id.edtLoginSenha);


        txtConta = (TextView) findViewById(R.id.txtConta);
        txtConta.setOnClickListener(new TxtContaListener());

        btnLogin.setOnClickListener(new BtnLoginListener());
    }

    private class TxtContaListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent cadastro = new Intent(getApplicationContext(), CadastroActivity.class);
            startActivity(cadastro);
        }

    }

    private class BtnLoginListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            email = edtLoginEmail.getText().toString();
            senha = edtLoginSenha.getText().toString();

            if (email.equals("") || email.isEmpty()){
                Toast.makeText(LoginActivity.this, getString(R.string.email_obrigatorio), Toast.LENGTH_LONG).show();
            }else if (senha.equals("") || senha.isEmpty()){
                Toast.makeText(LoginActivity.this, getString(R.string.senha_obrigatorio), Toast.LENGTH_LONG).show();
            }else {
                List<Usuario> usuarios = Usuario.find(Usuario.class, "email = ?",  email);
                if (usuarios.isEmpty()){
                    Toast.makeText(LoginActivity.this, getString(R.string.login_incorreto), Toast.LENGTH_LONG).show();
                }else {
                    for (Usuario u : usuarios){
                        if (u.getSenha().equals(senha)){
                            Toast.makeText(LoginActivity.this, getString(R.string.sucesso_login), Toast.LENGTH_LONG).show();
                            Intent principal = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(principal);
                            finish();
                            return;
                        }
                    }
                    Toast.makeText(LoginActivity.this, getString(R.string.error_invalid_password), Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
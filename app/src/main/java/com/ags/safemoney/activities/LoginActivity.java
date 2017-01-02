package com.ags.safemoney.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ags.safemoney.R;

public class LoginActivity extends AppCompatActivity {

    private TextView txtConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtConta = (TextView) findViewById(R.id.txtConta);
        txtConta.setOnClickListener(new TxtContaListener());
    }

    private class TxtContaListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent cadastro = new Intent(getApplicationContext(), CadastroActivity.class);
            startActivity(cadastro);
        }

    }
}

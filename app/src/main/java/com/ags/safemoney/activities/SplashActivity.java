package com.ags.safemoney.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ags.safemoney.R;

public class SplashActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler h = new Handler();
        h.postDelayed(this, 1500);
    }


    @Override
    public void run() {
        startLogin();
        finish();
    }

    public void startLogin(){
        Intent telaLogin = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(telaLogin);
    }
}

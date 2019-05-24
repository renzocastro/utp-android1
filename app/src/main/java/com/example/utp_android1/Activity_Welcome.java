package com.example.utp_android1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__welcome);
    }

    public void BtnExiste_Click(View v){
        startActivity(new Intent(Activity_Welcome.this, Activity_Login.class));
    }
    public void TvNuevaCuenta_Click(View v){
        startActivity(new Intent(Activity_Welcome.this, Activity_CreateUser.class));
    }
}

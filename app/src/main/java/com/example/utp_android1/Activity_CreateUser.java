package com.example.utp_android1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Activity_CreateUser extends AppCompatActivity {

    EditText txt_nombres, txt_apellidos, txt_email, txt_password, txt_password2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__create_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.BindingControls();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(),Activity_Welcome.class) ;
        startActivityForResult(intent,0);
        return true ;
    }
    public void BtnCrear_Click(View v){
        //Log.i("@test","this is click event");
        String v_nombres = txt_nombres.getText().toString();
        String v_apellidos= txt_apellidos.getText().toString();
        String v_email = txt_email.getText().toString();
        String v_passwd = txt_password.getText().toString();
        String v_passwd2= txt_password2.getText().toString();
        Log.i("@test",v_nombres);
        Log.i("@test",v_apellidos);
    }

    public void BindingControls(){
        txt_nombres= (EditText) findViewById(R.id.et_nombres) ;
        txt_apellidos= (EditText) findViewById(R.id.et_apellidos) ;
        txt_email = (EditText) findViewById(R.id.et_email) ;
        txt_password = (EditText) findViewById(R.id.et_password) ;
        txt_password2 = (EditText) findViewById(R.id.et_password2) ;
    }
}

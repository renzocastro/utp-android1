package com.example.utp_android1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Activity_Login extends AppCompatActivity {

    EditText txt_password, txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.BindingControls();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(),Activity_Welcome.class) ;
        startActivityForResult(intent,0);
        return true ;
    }

    public void BtnIngresar_Click(View v){
        //Log.i("@test","this is click event");
        String v_email = txt_email.getText().toString();
        String v_passwd = txt_password.getText().toString();
        Log.i("@test",v_email);
        Log.i("@test",v_passwd);
    }

    public void BindingControls(){
        txt_email = (EditText) findViewById(R.id.et_email) ;
        txt_password = (EditText) findViewById(R.id.et_password) ;
    }
}

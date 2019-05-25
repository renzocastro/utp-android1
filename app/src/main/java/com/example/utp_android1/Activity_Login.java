package com.example.utp_android1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utp_android1.database.OpenHelper_User;
import com.example.utp_android1.model.User;

public class Activity_Login extends AppCompatActivity {

    EditText txt_password, txt_email;
    OpenHelper_User controller ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.BindingControls();
        controller = new OpenHelper_User(this,"",null,1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(),Activity_Welcome.class) ;
        startActivityForResult(intent,0);
        return true ;
    }

    public void BtnIngresar_Click(View v){
        String v_email = txt_email.getText().toString();
        String v_passwd = txt_password.getText().toString();
        if(this.ValidatingFields()) {
            Object outcome = controller.get_user(v_email);
            if (null == outcome) {
                Toast.makeText(getApplicationContext(), "NO PASO VALIDACION.", Toast.LENGTH_SHORT).show();
            } else {
                User objuser = ((User) outcome);
                String v_message = "BIENVENIDO "+objuser.getFirst_name();
                String v_current_passwd = objuser.getPassword();
                if (v_current_passwd.equals(v_passwd)) {
                    Toast.makeText(getApplicationContext(), v_message, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class) ;
                    startActivityForResult(intent,0);
                } else {
                    Toast.makeText(getApplicationContext(), "NO PASO VALIDACION.", Toast.LENGTH_SHORT).show();
                }
            }
        }
//        Log.i("@test",v_email);
//        Log.i("@test",v_passwd);
    }
    public Boolean ValidatingFields(){
        String v_email = txt_email.getText().toString();
        String v_passwd = txt_password.getText().toString();
        if( v_email.isEmpty() || v_passwd.isEmpty()){
            Toast.makeText(getApplicationContext(),"HAY CAMPOS SIN COMPLETAR.", Toast.LENGTH_SHORT).show();
            return false ;
        }
        return true ;
    }
    public void BindingControls(){
        txt_email = (EditText) findViewById(R.id.et_email) ;
        txt_password = (EditText) findViewById(R.id.et_password) ;
    }
}

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

public class Activity_CreateUser extends AppCompatActivity {

    int MIN_CHARS =6 ;
    EditText txt_nombres, txt_apellidos, txt_email, txt_password, txt_password2 ;
    OpenHelper_User controller ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__create_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.BindingControls();
        controller = new OpenHelper_User(this,"",null,1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        this.BackHome();
        return true ;
    }
    public void BackHome(){
        Intent intent = new Intent(getApplicationContext(),Activity_Welcome.class) ;
        startActivityForResult(intent,0);
    }
    public void BtnCrear_Click(View v){
        int v_id = 0 ;
        String v_nombres = txt_nombres.getText().toString();
        String v_apellidos= txt_apellidos.getText().toString();
        String v_username = v_nombres.substring(0,2).toLowerCase() + v_apellidos.toLowerCase();
        String v_email = txt_email.getText().toString();
        String v_passwd = txt_password.getText().toString();
        String v_passwd2= txt_password2.getText().toString();
        User objuser = new User(v_id,v_username,v_passwd,v_nombres,v_apellidos,v_email);
        if(this.ValidatingFields(objuser)){
            Object outcome = controller.get_user(objuser.getEmail()) ;
            if(null == outcome){
                controller.insert_user(objuser);
                Toast.makeText(getApplicationContext(),"REGISTRO SATISFACTORIO.", Toast.LENGTH_SHORT).show();
                this.CleanFields();
                this.BackHome();
            }else{
                Toast.makeText(getApplicationContext(),"USUARIO YA EXISTE.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public Boolean ValidatingFields(User objuser){
        String pass1 = objuser.getPassword() ;
        String pass2= txt_password2.getText().toString();
        if(objuser.getFirst_name().isEmpty() || objuser.getPassword().isEmpty() || objuser.getLast_name().isEmpty() || objuser.getEmail().isEmpty()){
            Toast.makeText(getApplicationContext(),"HAY CAMPOS SIN COMPLETAR.", Toast.LENGTH_SHORT).show();
            return false ;
        }
        if(pass1.length()<MIN_CHARS){
            Toast.makeText(getApplicationContext(),"LONGITUD DE CLAVE INCORRECTA.", Toast.LENGTH_SHORT).show();
            return false ;
        }
        if(!pass1.equals(pass2)){
            Toast.makeText(getApplicationContext(),"CLAVES DIFERENTES.", Toast.LENGTH_SHORT).show();
            return false ;
        }
        return true ;
    }
    public void CleanFields(){
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_email.setText("");
        txt_password.setText("");
        txt_password2.setText("");
    }
    public void BindingControls(){
        txt_nombres= (EditText) findViewById(R.id.et_nombres) ;
        txt_apellidos= (EditText) findViewById(R.id.et_apellidos) ;
        txt_email = (EditText) findViewById(R.id.et_email) ;
        txt_password = (EditText) findViewById(R.id.et_password) ;
        txt_password2 = (EditText) findViewById(R.id.et_password2) ;
    }
}

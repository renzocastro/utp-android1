package com.example.utp_android1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.utp_android1.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenHelper_User extends SQLiteOpenHelper {


    public OpenHelper_User(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "db.sqlite3", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"auth_user\" (\"id\" integer NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
                "\"password\" varchar(128) NOT NULL, \"last_login\" datetime NULL, \n" +
                "\"is_superuser\" bool NOT NULL, \"username\" varchar(150) NOT NULL UNIQUE, \n" +
                "\"first_name\" varchar(30) NOT NULL, \"email\" varchar(254) NOT NULL, \n" +
                "\"is_staff\" bool NOT NULL, \"is_active\" bool NOT NULL, \"date_joined\" datetime NOT NULL,\n" +
                "\"last_name\" varchar(150) NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS auth_user ;");
        onCreate(db);
    }

    public void insert_user(User objuser){
        ContentValues content =  new ContentValues() ;
        content.put("username",objuser.getUsername());
        content.put("password",objuser.getPassword());
        content.put("first_name",objuser.getFirst_name());
        content.put("last_name",objuser.getLast_name());
        content.put("email",objuser.getEmail());
        content.put("is_active",Integer.parseInt("1"));
        content.put("is_superuser",Integer.parseInt("0"));
        content.put("is_staff", Integer.parseInt("0"));
        content.put("date_joined", objuser.getDate_joined());
        Log.i("@test",content.toString());
        this.getWritableDatabase().insertOrThrow("auth_user","",content);
    }

    public User get_user(String vemail){
        String cmd = "select * from auth_user where email='"+vemail+"';" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(cmd,null);
        User objuser ;
        while(cursor.moveToNext()){
            int v_id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String v_username = cursor.getString(cursor.getColumnIndex("username"));
            String v_password= cursor.getString(cursor.getColumnIndex("password"));
            String v_first_name = cursor.getString(cursor.getColumnIndex("first_name"));
            String v_last_name = cursor.getString(cursor.getColumnIndex("last_name"));
            String v_email= cursor.getString(cursor.getColumnIndex("email"));
            objuser = new User(v_id, v_username,v_password,v_first_name,v_last_name,v_email);
            return objuser;
        }
        return null;
    }
    public List<User>get_users(){
        List<User> lsusers = new ArrayList<User>();
        String cmd = "select * from auth_user ;" ;
        Cursor cursor = this.getReadableDatabase().rawQuery(cmd,null);
        while(cursor.moveToNext()){
            int v_id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String v_username = cursor.getString(cursor.getColumnIndex("username"));
            String v_password= cursor.getString(cursor.getColumnIndex("password"));
            String v_first_name = cursor.getString(cursor.getColumnIndex("first_name"));
            String v_last_name = cursor.getString(cursor.getColumnIndex("last_name"));
            String v_email= cursor.getString(cursor.getColumnIndex("email"));
            User objuser = new User(v_id, v_username,v_password,v_first_name,v_last_name,v_email);
            lsusers.add(objuser);
        }
        return lsusers ;
    }
}

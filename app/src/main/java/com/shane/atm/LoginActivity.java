package com.shane.atm;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_userid;
    private EditText ed_passwd;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        SharedPreferences setting=getSharedPreferences("atm",MODE_PRIVATE);
        ed_userid.setText(setting.getString("PREF_USERID",""));
    }
    public void login(View view){
     String uid = ed_userid.getText().toString();
    String pwd =ed_passwd.getText().toString();
        if(uid.equals("shane")&&pwd.equals("123456")){
            Intent intent=getIntent();
            intent.putExtra("LOGIN_USERID",uid);
            intent.putExtra("LOGIN_PASSWD",pwd);
            setResult(RESULT_OK,getIntent());
            SharedPreferences sprf= getSharedPreferences("atm",MODE_PRIVATE);
            sprf.edit().putString("PREF_USERID",uid).commit();
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG);
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Login").setMessage("登入失敗")
                    .setNegativeButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("離開", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
        }
    }

    private void findViews() {
        ed_userid = (EditText) findViewById(R.id.ed_userid);
        ed_passwd = (EditText) findViewById(R.id.ed_passwd);
        bt_login = (Button) findViewById(R.id.button2);
    }
}

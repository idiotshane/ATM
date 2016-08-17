package com.shane.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean login=false;
    public static final  int FUNC_RESULT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    if(!login){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivityForResult(intent,FUNC_RESULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==FUNC_RESULT){
            if(resultCode==RESULT_OK){
                String uid=data.getStringExtra("LOGIN_USERID");
                String pwd =data.getStringExtra("LOGIN_PASSWD");
            }else{
                finish();
            }
        }
    }
}


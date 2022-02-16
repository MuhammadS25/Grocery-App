package com.example.logiin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.crypto.spec.OAEPParameterSpec;

import controller.dbhandler;

public class Welcome extends AppCompatActivity {
    private Button loginbtn;
    private Button rgstbtn;
    private dbhandler db=new dbhandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    loginbtn=(Button) findViewById(R.id.loginbtn);
        rgstbtn=(Button) findViewById(R.id.rgstbtn);
    rgstbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openActivity2();
        }
    });
    loginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openActivity3();
        }
    });
    }
    public void openActivity2(){
        Log.d("kk22","weeeelll");

        Intent intent = new Intent(Welcome.this,registration.class);
        Log.d("kk22","weeeelll");
        startActivity(intent);

    }

    public void openActivity3(){

        Intent intent = new Intent(Welcome.this,MainActivity.class);
        startActivity(intent);

    }
}
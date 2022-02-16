package com.example.logiin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import controller.dbhandler;
import model.User;

public class registration extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText pass;
    private EditText cpass;
    private Button rgst;
    private TextView text3;
    private dbhandler db=new dbhandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        pass=(EditText) findViewById(R.id.pass);
        username= (EditText) findViewById(R.id.Username);
        email=(EditText) findViewById(R.id.email);
        rgst=(Button) findViewById(R.id.rgst);
        text3=(TextView) findViewById(R.id.text3);
        cpass=(EditText) findViewById(R.id.cpass);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });

        rgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate(email,pass,cpass,username)){
                    openActivity2();
                }

            }
        });
    }
    public boolean validate(EditText email,EditText pass,EditText cpass,EditText username){
        String e= email.getText().toString();
        String p = pass.getText().toString();
        String c= cpass.getText().toString();
        String u = username.getText().toString();
        if (!(e.isEmpty()||p.isEmpty()||u.isEmpty())&&p.equals(c)){
            Log.d("kk222","weeeeeeeeeee");
            db.adduser(new User(u,e,p));
            Log.d("kk222","weeeeeeeeeee");
            return true;
        }
        Toast.makeText(this,"Please Fill all Fields",Toast.LENGTH_SHORT).show();
        return false;
    }
    public void openActivity5(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void openActivity2(){

        Intent intent = new Intent(this,haga.class);
        startActivity(intent);

    }
}
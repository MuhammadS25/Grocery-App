package com.example.logiin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import controller.dbhandler;
import model.Goods;
import model.User;
import utils.utils;

public class MainActivity extends AppCompatActivity {
private Button btn;
private EditText email;
private EditText pass;
private TextView text2;
dbhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new dbhandler(this);
     /*  deleteDatabase(utils.data_name);
        db.adduser(new User("mosabry25","muhammad.sabry.15@gmail.com","88888888"));
        db.adduser(new User("jeeka","jeka@gmail.com","7777777"));
        db.adduser(new User("wo7wo7","m.yehia@gmail.com","666666"));
        db.addgoods(new Goods("mango","fruit",50,Float.parseFloat("25.5")));
        db.addgoods(new Goods("orange","fruit",40,Float.parseFloat("3.5")));*/
        List<User> usersList=db.getUsers();
        for (User u:usersList){
            String myinfo="ID : "+u.getId()+" Username : "+u.getUsername()+" Email : "+
                    u.getEmail()+" Password : "+u.getPassword();
            Log.d("user66",myinfo);
        }
        List<Goods>goodsList=db.getAllgoods();
        for (Goods g:goodsList){
            String mygoods="ID : "+g.getId()+" Name : "+g.getName()+" Category : "+
                    g.getCategory()+" Quantity : "+g.getQuantity()+ " Price : "+g.getPrice();
            Log.d("Goods66",mygoods);
        }
        Goods g =db.getgoods("mango");
        Log.d("Mango_price",String.valueOf(g.getPrice()));
        g.setQuantity(g.getQuantity()-5);
        db.updategood(g);
        Goods g2=db.getgoods("mango");
        Log.d("Mango_quantity",String.valueOf(g2.getQuantity()));

        pass=(EditText) findViewById(R.id.pass);
        email=(EditText) findViewById(R.id.email);
        btn=(Button) findViewById(R.id.btn);
        text2=(TextView) findViewById(R.id.text2);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (validate(email,pass)) {
                   openActivity2();
               }

            }
        });

    }


    public void openActivity3(){

        Intent intent = new Intent(MainActivity.this,registration.class);
        startActivity(intent);

    }
public void openActivity2(){

    Intent intent = new Intent(MainActivity.this,haga.class);
    startActivity(intent);

}
public boolean validate(EditText email,EditText pass){

    String e= email.getText().toString();
     String p = pass.getText().toString();
     if (!e.isEmpty()&&!p.isEmpty()){
         List<User> usersList=db.getUsers();
         for (User user:usersList){
             if (e.equals(user.getUsername())&&p.equals(user.getPassword()))return true;
         }
     }

         Toast.makeText(this,"Invalid Email Or Password",Toast.LENGTH_SHORT).show();
         return false;

}
}
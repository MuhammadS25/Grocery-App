package com.example.logiin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Proteins extends AppCompatActivity {
    GridView gridView;
    TextView text;
    Button btn_fruit;
    Button btn_veg;
    Button btn_proteins;
    Button btn_add;
    Button btn_bascket;
    ImageView bascket;
    Animation anim;


    String[] numberword={"Pastrami"  , "Strips" , "Turkey" ,"Shrimp" , "Calamari" , "Ribeye"};
    double[] numberprices = {40 ,50 , 15, 25 , 35 ,45 ,55 , 60};
    int[] numberimage = {R.drawable.pastrami , R.drawable.strips ,R.drawable.turkey,R.drawable.shrimp,
            R.drawable.calamari,R.drawable.ribeye};

    int[] numberbtn = {R.id.btn1 , R.id.btn1  , R.id.btn1  , R.id.btn1  ,R.id.btn1  , R.id.btn1
            , R.id.btn1  ,R.id.btn1 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteins);
        gridView=findViewById(R.id.grid_view);
        MainAdapter adapter =new MainAdapter(Proteins.this ,numberword , numberimage ,numberbtn , numberprices);
        gridView.setAdapter(adapter);
        Button btn_fruit = (Button)findViewById(R.id.fruit_menuid);
        btn_fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Fruits" ,Toast.LENGTH_SHORT).show();
                Intent i =new Intent(Proteins.this , haga.class);
                startActivity(i);

            }
        });

        Button btn_veg = (Button)findViewById(R.id.veg_menuid);
        btn_veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Vegetables" ,Toast.LENGTH_SHORT).show();
                Intent i =new Intent(Proteins.this , vegetables.class);
                startActivity(i);
            }
        });

        Button btn_bascket = (Button)findViewById(R.id.bascket_menuid);
        btn_bascket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Your Bascket..." ,Toast.LENGTH_SHORT).show();
                Intent i =new Intent(Proteins.this ,bascket_activity.class);
                startActivity(i);
            }
        });


//******************************************************************************************************
        Button btn_add = (Button)findViewById(R.id.add_btn);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               basckett b=new basckett();

                product one= new product();
                String n1=numberword[0];
                double p1=numberprices[0];
                double q1=basckett.arr_qp[0];
                one.setName(n1);
                one.setPrice(p1);
                one.setQuantity(q1);
                if(one.getQuantity() != 0)
                {
                    b.order_bascket(one);
                }

                product two= new product();
                String n2=numberword[1];
                double p2=numberprices[1];
                double q2=basckett.arr_qp[1];
                two.setName(n2);
                two.setPrice(p2);
                two.setQuantity(q2);
                if(two.getQuantity() != 0)
                {
                    b.order_bascket(two);
                }

                product three= new product();
                String n3=numberword[2];
                double p3=numberprices[2];
                double q3=basckett.arr_qp[2];
                three.setName(n3);
                three.setPrice(p3);
                three.setQuantity(q3);
                if(three.getQuantity() != 0)
                {
                    b.order_bascket(three);
                }

                product four= new product();
                String n4=numberword[3];
                double p4=numberprices[3];
                double q4=basckett.arr_qp[3];
                four.setName(n4);
                four.setPrice(p4);
                four.setQuantity(q4);
                if(four.getQuantity() != 0)
                {
                    b.order_bascket(four);
                }

                product five= new product();
                String n5=numberword[4];
                double p5=numberprices[4];
                double q5=basckett.arr_qp[4];
                five.setName(n5);
                five.setPrice(p5);
                five.setQuantity(q5);
                if(five.getQuantity() != 0)
                {
                    b.order_bascket(five);
                }

                product six= new product();
                String n6=numberword[5];
                double p6=numberprices[5];
                double q6=basckett.arr_qp[5];
                six.setName(n6);
                six.setPrice(p6);
                six.setQuantity(q6);
                if(six.getQuantity() != 0)
                {
                    b.order_bascket(six);
                }

                Toast.makeText(getApplicationContext(), "Your Order is added suceesfully..." ,Toast.LENGTH_SHORT).show();
            }
        });

        //*****************************************************************************************************

        text = (TextView)findViewById(R.id.Protein_text);
        anim =AnimationUtils.loadAnimation(this, R.anim.animations);
        btn_fruit =(Button)findViewById(R.id.fruit_menuid);
        btn_proteins =(Button)findViewById(R.id.proteins_menuid);
        btn_veg =(Button)findViewById(R.id.veg_menuid);
        btn_add =(Button)findViewById(R.id.add_btn);
        btn_bascket =(Button)findViewById(R.id.bascket_menuid);
        bascket =(ImageView)findViewById(R.id.bascket_id);
        gridView =(GridView)findViewById(R.id.grid_view);
        anim = AnimationUtils.loadAnimation(this,R.anim.animations);
        text.setAnimation(anim);
        btn_fruit.setAnimation(anim);
        btn_proteins.setAnimation(anim);
        btn_veg.setAnimation(anim);
        btn_add.setAnimation(anim);
        btn_bascket.setAnimation(anim);
        bascket.setAnimation(anim);
        gridView.setAnimation(anim);

    }

}
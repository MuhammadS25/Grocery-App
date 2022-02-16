package com.example.logiin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class bascket_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bascket);

        ListView list=(ListView) findViewById(R.id.list);
        ListView list2=(ListView) findViewById(R.id.list2);
        ArrayList<String> names=new ArrayList<>();
        ArrayList<Double>cost=new ArrayList<>();
        double ptc,total_cost,sum_cost=0;

        for(int i=0;i< basckett.order.size();i++)
        {
            ptc=basckett.order.get(i).getPrice()*basckett.order.get(i).getQuantity();
            sum_cost+=ptc;
            names.add( basckett.order.get(i).getName());
            cost.add(ptc);
        }
        total_cost=sum_cost;

        ArrayAdapter namesadpt=new ArrayAdapter(this,android.R.layout.simple_list_item_1 , names);
        list.setAdapter(namesadpt);
        ArrayAdapter costadpt=new ArrayAdapter(this,android.R.layout.simple_list_item_1 , cost);
        list2.setAdapter(costadpt);
//*******************************************************************************
        Button c_btn=(Button) findViewById(R.id.cost);
        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView c_text=(TextView) findViewById(R.id.tcost);
                c_text.setText(String.valueOf(total_cost));
            }
        });
//************************************************************************************
        Button btn_done = (Button)findViewById(R.id.done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(names.size()>0)
                    Toast.makeText(getApplicationContext(), "You will get your order in minutes , Thanks...  " ,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), " Your bascket is empty !! No Items to get , Thanks... " ,Toast.LENGTH_SHORT).show();


            }
        });
 //*****************************************************************************************
       Button btn_cancel = (Button)findViewById(R.id.cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(names.size()>0)
                {
                    new AlertDialog.Builder(bascket_activity.this).setTitle("Do you want to remove the order!?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    names.clear();
                                    cost.clear();
                                    for(int j=0;j<basckett.order.size();j++) {
                                        basckett.order.remove(i);
                                    }
                                    TextView c_text2=(TextView) findViewById(R.id.tcost);
                                    c_text2.setText(String.valueOf(0.0));
                                    Toast.makeText(getApplicationContext(), "You order has been canceled !! , Thanks...  ", Toast.LENGTH_SHORT).show();
                                    namesadpt.notifyDataSetChanged();
                                    costadpt.notifyDataSetChanged();

                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();


                }
                else
                    Toast.makeText(getApplicationContext(), " Your bascket is empty !! No Items to be canceled , Thanks...  ", Toast.LENGTH_SHORT).show();


            }
        });

    }
}
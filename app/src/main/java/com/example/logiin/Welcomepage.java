package com.example.logiin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class Welcomepage extends AppCompatActivity {
    TextView textVie ;
    Animation anim;
    Button next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        textVie =(TextView)findViewById(R.id.textView);
        anim = AnimationUtils.loadAnimation(this, R.anim.animations);
        textVie.setAnimation(anim);

        next_btn=(Button) findViewById(R.id.nextbutton);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Welcomepage.this,Welcome.class);
                startActivity(intent);
            }
        });
    }
}
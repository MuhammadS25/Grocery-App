package com.example.logiin;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] numberWords;
    private int[] numberIamges;
    private  int[] numberbtton;
    private double[] prices;


    public MainAdapter(Context c , String[] numberWords , int[] numberIamges , int[] numberbtton , double[] pric){
        context =c;
        this.numberWords =numberWords;
        this.numberIamges =numberIamges;
        this.numberbtton =numberbtton;
        this.prices =pric;
    }
    @Override
    public int getCount() {
        return numberWords.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if (view== null){
            view = inflater.inflate(R.layout.row_item , null);
        }
        ImageView imageView = view.findViewById(R.id.image_view);
        TextView textView = view.findViewById(R.id.text_view);
        Button btttn1 =view.findViewById(R.id.btn1);
        Button btttn2 =view.findViewById(R.id.btn2);
        TextView textcount = view.findViewById(R.id.counter);
        TextView pri =view.findViewById(R.id.price);
        Button add_btn = view.findViewById(R.id.add_btn);

        btttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double q = Double.parseDouble(textcount.getText().toString());
                q =q+0.5;
                textcount.setText(String.valueOf(q));
                if(numberWords[i]=="mango"||numberWords[i]=="orange"||numberWords[i]=="grapes"||numberWords[i]=="pineapple"||
                        numberWords[i]=="kiwi"||numberWords[i]=="apple")
                basckett.arr_qf[i]=q;

               else if(numberWords[i]=="Tomato"||numberWords[i]=="Potato"||numberWords[i]=="Brinjal"||numberWords[i]=="Onion"||
                        numberWords[i]=="Carrot"|| numberWords[i]=="Pepper")
                    basckett.arr_qv[i]=q;
               else
                   basckett.arr_qp[i]=q;
            }
        });
        btttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double q =Double.parseDouble(textcount.getText().toString());
                if (q != 0){
                    q = q-0.5;
                    textcount.setText(String.valueOf(q));
                   if(numberWords[i]=="mango"||numberWords[i]=="orange"||numberWords[i]=="grapes"||numberWords[i]=="pineapple"||
                            numberWords[i]=="watermelon"|| numberWords[i]=="peach"||numberWords[i]=="kiwi"||numberWords[i]=="apple")
                        basckett.arr_qf[i]=q;

                    else if(numberWords[i]=="Tomato"||numberWords[i]=="potato"||numberWords[i]=="Brinjal"||numberWords[i]=="Onion"||
                            numberWords[i]=="Carrot"|| numberWords[i]=="Cucumbers"||numberWords[i]=="Garlic"||numberWords[i]=="Pepper")
                        basckett.arr_qv[i]=q;
                    else
                        basckett.arr_qp[i]=q;
                }
            }
        });



        imageView.setImageResource(numberIamges[i]);
        textView.setText(numberWords[i]);
        pri.setText(String.valueOf(prices[i]));

        return  view;
    }

}

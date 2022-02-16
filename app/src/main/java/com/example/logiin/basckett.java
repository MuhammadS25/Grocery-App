package com.example.logiin;

import java.util.ArrayList;

public class basckett {

    static double []arr_qf=new double[6];
    static double []arr_qv=new double[6];
    static double []arr_qp=new double[6];
    static ArrayList<product> order=new ArrayList<product>();

    public void order_bascket(product p)
    {

        order.add(p);
    }
}

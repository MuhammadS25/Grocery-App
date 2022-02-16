package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import model.Goods;
import model.User;
import utils.utils;

public class dbhandler extends SQLiteOpenHelper {
    public dbhandler( Context context) {
        super(context, utils.data_name, null, utils.data_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE ="CREATE TABLE " + utils.table_name + " (" +
                utils.key_id + " INTEGER PRIMARY KEY,"
                + utils.key_Username + " TEXT,"
                + utils.key_Email + " TEXT,"
                + utils.key_Password + " TEXT)";
        String CREATE_GOODS_TABLE ="CREATE TABLE " + utils.table_name2 + " (" +
                utils.key_id2 + " INTEGER PRIMARY KEY,"
                + utils.key_name2 + " TEXT,"
                + utils.key_category + " TEXT,"
                + utils.key_quantity + " TEXT," +
                utils.key_price + " TEXT)";

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_GOODS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+utils.table_name);
        db.execSQL("DROP TABLE IF EXISTS "+utils.table_name2);
        onCreate(db);

    }
    public void adduser(User user){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(utils.key_Username,user.getUsername());
        contentValues.put(utils.key_Email,user.getEmail());
        contentValues.put(utils.key_Password,user.getPassword());
        database.insert(utils.table_name,null,contentValues);
        database.close();

    }
    public User getuser(int id){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(utils.table_name,new String[]{utils.key_id,utils.key_Username,utils.key_Email
                        ,utils.key_Password},utils.key_id+"=?",new String[]{String.valueOf(id)},
                null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();
        User user=new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1)
                ,cursor.getString(2),cursor.getString(3));

        return user;

    }
    public List<User> getUsers(){
        SQLiteDatabase database=this.getReadableDatabase();
        List<User>usersList=new ArrayList<>();
        String getAll ="SELECT * FROM "+utils.table_name;
        Cursor cursor=database.rawQuery(getAll,null);

        if (cursor.moveToFirst())
            do {
                User user=new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                usersList.add(user);
            }while (cursor.moveToNext());


        return usersList;

    }
    public void addgoods(Goods goods){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(utils.key_name2,goods.getName());
        contentValues.put(utils.key_category,goods.getCategory());
        contentValues.put(utils.key_quantity,String.valueOf(goods.getQuantity()));
        contentValues.put(utils.key_price,String.valueOf(goods.getPrice()));
        Log.d("work66","weee");
        database.insert(utils.table_name2,null,contentValues);
        Log.d("work66","weee");
        database.close();

    }
    public Goods getgoods(String name){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(utils.table_name2,new String[]{utils.key_id2,utils.key_name2,utils.key_category
                        ,utils.key_quantity,utils.key_price},utils.key_name2+"=?",new String[]{name},
                null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();
        Goods goods=new Goods(Integer.parseInt(cursor.getString(0)),cursor.getString(1)
                ,cursor.getString(2),Integer.parseInt(cursor.getString(3))
                ,Float.parseFloat(cursor.getString(4)));

        return goods;

    }
    public List<Goods> getAllgoods(){
        SQLiteDatabase database=this.getReadableDatabase();
        List<Goods>goodsList=new ArrayList<>();
        String getAll ="SELECT * FROM "+utils.table_name2;
        Cursor cursor=database.rawQuery(getAll,null);

        if (cursor.moveToFirst())
            do {
                Goods goods=new Goods(Integer.parseInt(cursor.getString(0)),cursor.getString(1)
                        ,cursor.getString(2),Integer.parseInt(cursor.getString(3))
                        ,Float.parseFloat(cursor.getString(4)));
                goodsList.add(goods);
            }while (cursor.moveToNext());


        return goodsList;

    }
    public int updategood(Goods goods){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(utils.key_name2,goods.getName());
        contentValues.put(utils.key_category,goods.getCategory());
        contentValues.put(utils.key_quantity,String.valueOf(goods.getQuantity()));
        contentValues.put(utils.key_price,String.valueOf(goods.getPrice()));
        int res=database.update(utils.table_name2,contentValues,utils.key_name2+"=?",new String[]{String.valueOf(goods.getName())});
        database.close();
        return res;

    }

}

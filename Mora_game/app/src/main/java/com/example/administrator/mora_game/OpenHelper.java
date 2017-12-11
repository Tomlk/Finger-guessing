package com.example.administrator.mora_game;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/8.
 */

public class OpenHelper extends SQLiteOpenHelper {
    //建表语句
    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "userpwd text)";

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(CREATE_USER);//创建用户表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}

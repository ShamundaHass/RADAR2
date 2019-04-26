package com.example.hassan.radar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class userdbhelper extends SQLiteOpenHelper {

    private static final String databasename="userinfo.DB";
    private static final int database_version=1;
    private static final String database_query=
            "CREATE TABLE "+ usercontact.newuserinf.table_name+"("+ usercontact.newuserinf.mobile+" TEXT,"+usercontact.newuserinf.Firstname+" TEXT"+usercontact.newuserinf.lastname+"TEXT"+usercontact.newuserinf.email+"TEXT);";

    public userdbhelper(Context context){


    super(context,databasename,null,database_version);
        Log.e("Database Operation","Database created / opened");
    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(database_query);
        Log.e("Database Operation","Database created / opened");
    }

    public void addinformation(String mobile,String fname,String lname,String email,SQLiteDatabase sqLiteDatabase){

        ContentValues contextValues=new ContentValues();
        contextValues.put(usercontact.newuserinf.mobile,mobile);
        contextValues.put(usercontact.newuserinf.Firstname,fname);
        contextValues.put(usercontact.newuserinf.lastname,lname);
        contextValues.put(usercontact.newuserinf.email,email);

        sqLiteDatabase.insert(usercontact.newuserinf.table_name,null,contextValues);
        Log.e("Database Operation","one row inserted");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

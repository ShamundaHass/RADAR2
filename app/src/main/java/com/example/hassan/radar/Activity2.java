package com.example.hassan.radar;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends AppCompatActivity {
    EditText txtfirst,txtlast,txtemail;
    Button btnsend;
    TextView mobile_no;
    Context context=this;
    userdbhelper userdbhelper;
    SQLiteDatabase sqLiteDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        txtfirst=(EditText)findViewById(R.id.txtfirst);
        txtlast=(EditText)findViewById(R.id.txtlast);
        txtemail=(EditText)findViewById(R.id.txtemail);
        mobile_no=(TextView) findViewById(R.id.txtfirst);

        btnsend=(Button)findViewById(R.id.btnsend);
    }
    public void addContact(View v){

        String mobile=mobile_no.getText().toString();
        String fname=txtfirst.getText().toString();
        String lname=txtlast.getText().toString();
        String email=txtemail.getText().toString();


        userdbhelper= new userdbhelper(context);
        sqLiteDatabase=userdbhelper.getWritableDatabase();
        userdbhelper.addinformation(mobile,fname,lname,email,sqLiteDatabase);

        Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_LONG).show();
        userdbhelper.close();

        Intent intent=new Intent(Activity2.this,place_distination.class);
        startActivity(intent);
    }

}


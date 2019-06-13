package com.example.exercicientregable_andreu_martinez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textName,textSurname,textWeb,textPhone,textCount;
    String name,surname,web,phone;
    int count;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        inicializateTexts();
        inicializateStrings();
        sumCount();
        showResult();
    }

    private void sumCount(){
        int count=prefs.getInt("count", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("count", count+1);
        editor.commit();
    }

    private void inicializateTexts(){
        textName=findViewById(R.id.textName);
        textSurname=findViewById(R.id.textSurname);
        textWeb=findViewById(R.id.textWeb);
        textPhone=findViewById(R.id.textPhone);
        textCount=findViewById(R.id.count);
    }

    private void inicializateStrings(){
        name=getIntent().getStringExtra("editName");
        surname=getIntent().getStringExtra("editSurname");
        web=getIntent().getStringExtra("editWeb");
        phone=getIntent().getStringExtra("editPhone");
        count=prefs.getInt("count", 0);
    }

    private void showResult(){
        textCount.setText(""+count);
        textName.setText(name);
        textSurname.setText(surname);
        textWeb.setText(web);
        textPhone.setText(phone);
    }

    public void openWeb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+web));
        startActivity(intent);
    }

    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phone));
        startActivity(intent);
    }



}

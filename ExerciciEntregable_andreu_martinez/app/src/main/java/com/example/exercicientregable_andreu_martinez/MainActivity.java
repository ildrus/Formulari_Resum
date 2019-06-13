package com.example.exercicientregable_andreu_martinez;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName,editSurname,editWeb,editPhone;
    String name,surname,web,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializateEdits();
    }

    private void inicializateEdits(){
        editName=findViewById(R.id.editName);
        editSurname=findViewById(R.id.editSurname);
        editWeb=findViewById(R.id.editWeb);
        editPhone=findViewById(R.id.editPhone);
    }

    private void inicializationData(){
        name=editName.getText().toString();
        surname=editSurname.getText().toString();
        web=editWeb.getText().toString();
        phone=editPhone.getText().toString();
    }

    public void show(View view){
        inicializationData();
        if(!name.equals("")){
            if(!surname.equals("")){
                if(!web.equals("")){
                    if(!phone.equals("")){
                        changeLayout();
                    }
                    else{
                        editPhone.setError(getString(R.string.errorPhone));
                    }
                }
                else{
                    editWeb.setError(getString(R.string.errorWeb));
                }
            }
            else{
                editSurname.setError(getString(R.string.errorSurname));
            }
        }
        else{
            editName.setError(getString(R.string.errorName));
        }
    }

    public void delete(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getString(R.string.app_name));
        alertDialogBuilder.setMessage(getString(R.string.deleteContents)).setCancelable(false).setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    deleteAll();
                }}).setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }});
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void deleteAll(){
        editName.setText("");
        editSurname.setText("");
        editWeb.setText("");
        editPhone.setText("");
    }

    private void changeLayout(){
        Intent intent= new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("editName",editName.getText().toString());
        intent.putExtra("editSurname",editSurname.getText().toString());
        intent.putExtra("editWeb",editWeb.getText().toString());
        intent.putExtra("editPhone",editPhone.getText().toString());
        startActivity(intent);
    }
}

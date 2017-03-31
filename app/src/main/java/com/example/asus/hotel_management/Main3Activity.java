package com.example.asus.hotel_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    EditText Et2;
    Spinner spinsbrk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Et2=(EditText)findViewById(R.id.Et2);
        spinsbrk=(Spinner)findViewById(R.id.spinsbrk);


    }






}

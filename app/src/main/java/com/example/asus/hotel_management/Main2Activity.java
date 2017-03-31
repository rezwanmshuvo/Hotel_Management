package com.example.asus.hotel_management;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinbrk,spinLnc,spinDin;
    Button btnBrk,btnLnc,btnDin;
    EditText Et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinbrk=(Spinner)findViewById(R.id.spinbrk);
        spinLnc=(Spinner)findViewById(R.id.spinLnc);
        spinDin=(Spinner)findViewById(R.id.spinDin);

        btnBrk=(Button)findViewById(R.id.btnBrk);
        btnLnc=(Button)findViewById(R.id.btnLnc);
        btnDin=(Button)findViewById(R.id.btnDin);

        Et1=(EditText)findViewById(R.id.Et1);

        spinbrk.setOnItemSelectedListener(this);
        spinLnc.setOnItemSelectedListener(this);
        spinDin.setOnItemSelectedListener(this);


        loadSpinnerData();
        loadSpinnerDataTwo();
        loadSpinnerDataThree();

        btnBrk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String label = Et1.getText().toString();

                if (label.trim().length() > 0) {
                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    db.insertLabel(label);

                    // making input filed text to blank
                    Et1.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(Et1.getWindowToken(), 0);

                    // loading spinner with newly added data
                    loadSpinnerData();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter label name", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnLnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String label = Et1.getText().toString();

                if (label.trim().length() > 0) {
                    DatabaseHandlerTwo db = new DatabaseHandlerTwo(getApplicationContext());
                    db.insertLabelTwo(label);

                    // making input filed text to blank
                    Et1.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(Et1.getWindowToken(), 0);

                    // loading spinner with newly added data
                    loadSpinnerDataTwo();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter label name", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnDin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String label = Et1.getText().toString();

                if (label.trim().length() > 0) {
                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    db.insertLabel(label);

                    // making input filed text to blank
                    Et1.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(Et1.getWindowToken(), 0);

                    // loading spinner with newly added data
                    loadSpinnerDataThree();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter label name", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void loadSpinnerData() {
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinbrk.setAdapter(dataAdapter);
    }
    public void loadSpinnerDataTwo(){
        DatabaseHandlerTwo db = new DatabaseHandlerTwo(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinLnc.setAdapter(dataAdapter);

    }

    public void loadSpinnerDataThree(){
        DatabaseHandlerThree db = new DatabaseHandlerThree(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinDin.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();
        Et1.setText(label);

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

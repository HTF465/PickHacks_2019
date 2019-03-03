package com.example.pickhacks;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.concurrent.TimeUnit;

import BackEnd.Person;
import BackEnd.Processing;
import okhttp3.Callback;


public class MainActivity extends AppCompatActivity {

    Person thisPerson = null;
    static final String[] ex = {"Squat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button fab = findViewById(R.id.submit);

        Spinner spin = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.Exercise, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this.onItemSelectedListener1);





        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                TextView name = findViewById(R.id.name);
                TextView wieght = findViewById(R.id.weight);


                try {
                    if (thisPerson == null) {
                        thisPerson = new Person(name.getText().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                thisPerson.addExercise(ex[0],Integer.parseInt(wieght.getText().toString()));
                Processing process = new Processing();
                process.go(thisPerson);

                String o = "";
                int i = 0;
                while (i <= 45)
                {
                    o = process.goGo(thisPerson);
                    if (!o.equals("no notifications"))
                    {
                        break;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }

                Snackbar.make(view, o, Snackbar.LENGTH_LONG)
                         .setAction("Action", null).show();
            }


        });

    }

    AdapterView.OnItemSelectedListener onItemSelectedListener1 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String s1 = parent.getAdapter().getItem(position).toString();
            ex[0] = s1;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };




}

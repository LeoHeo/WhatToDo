package com.tishighnoongmail.whattodo;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditToDo extends AppCompatActivity {
    Intent intent = getIntent();
    ArrayList<String> dolist; // array of what to do id =
    ArrayAdapter<String> listadp; //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.editbar);
        setSupportActionBar(toolbar);




        String name = getIntent().getStringExtra("Task Name");
        EditText todoname = (EditText)findViewById(R.id.editname);
        todoname.setText(name); //propagate edit field, need to focus end of string
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_to_do, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cancel) {
            startActivity(new Intent(this, WhatToDo.class));
            this.finish();
            return true;
        }
        if (id == R.id.save) {
            startActivity(new Intent(this, WhatToDo.class));
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//item adder method
//    public void savetodo(View v) {
//        EditText newname = (EditText) findViewById(R.id.editname);
//        String name = newname.getText().toString();
//        EditText newdetails = (EditText) findViewById(R.id.editdetails);
//        String details = newdetails.getText().toString();
//        listadp.add(name);
//        newdo.setText("");
//        writeList();    }



    //read stuff method
    private void readList(){
        File filesDir = getFilesDir();
        File todofile = new File(filesDir, "WhatToDo.txt");
        try {
            dolist = new ArrayList<String>(FileUtils.readLines(todofile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //write stuff method
    private void writeList() {
        File filesDir = getFilesDir();
        File todofile = new File(filesDir, "WhatToDo.txt");
        try {
            FileUtils.writeLines(todofile, dolist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
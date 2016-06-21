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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditToDo extends AppCompatActivity {
    int code = 1;
    Intent data =  new Intent();
    EditText doname;
    EditText dodetails;
    Spinner priomenu;
    Spinner statusmenu;

    //ArrayList<NameValuePair> dodata = new ArrayList<NameValuePair>(); // array of what to do id =
    ArrayList<String> dodata = new ArrayList<>();
    ArrayAdapter<String> listadp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dodata); //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.editbar);
        setSupportActionBar(toolbar);



    }
    public void  onActivityResult(int requestCode, int code, Intent data) {
        // Check which request we're responding to
        if (requestCode == code) {
            // Make sure the request was successful
            if (code == RESULT_OK) {
                // Do something
                String name = getIntent().getStringExtra("Task Name");//propagate field from intent extra
                EditText todoname = (EditText) findViewById(R.id.editname);
                todoname.setText(name);
                //set other stuff
            }
        }

    }
//    Bundle newtodo = new Bundle();
//    doname = (EditText) findViewById(R.id.editname);
//    dodetails  = (EditText) findViewById(R.id.editdetails);
//    //doprio = (EditText) findViewById(R.id.editprio);
//    //dostatus = (EditText) findViewById(R.id.editstatus);
//            dodata.add(new BasicNameValuePair("do_name", doname.getText().toString()));
//            dodata.add(new BasicNameValuePair("do_details", dodetails.getText().toString()));
//            dodata.add(new BasicNameValuePair("do_priority", doprio.getText().toString()));
//            dodata.add(new BasicNameValuePair("do_status", dostatus.getText().toString()));
//    Intent updatehome = new Intent(this, WhatToDo.class);
//    updatehome.putExtra("todo data", dodata);
//    startActivity(updatehome);

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
        //cancel
        if (id == R.id.cancel) {
            this.finish();
            return true;
        }
        //save
        if (id == R.id.save) {
            doname = (EditText) findViewById(R.id.editname);
            //dodata.add(doname.getText().toString());
            //dodata.add(dodetails.getText().toString());
            //dodata.add(doprio.getText().toString());
            //dodata.add(dostatus.getText().toString());
            data.putExtra("Name", doname.getText().toString());
            setResult(RESULT_OK, data);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//  item adder method
//    public void savetodo(View v) {
//        EditText newname = (EditText) findViewById(R.id.editname);
//        String name = newname.getText().toString();
//        //EditText newdetails = (EditText) findViewById(R.id.editdetails);
//       // String details = newdetails.getText().toString();
//        listadp.add(name);
//        doname.setText("");
//        writeList();    }



    //read stuff method
    private void readList(){
        File filesDir = getFilesDir();
        File todofile = new File(filesDir, "WhatToDo.txt");
        try {
            dodata = new ArrayList<String>(FileUtils.readLines(todofile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //write stuff method
    private void writeList() {
        File filesDir = getFilesDir();
        File todofile = new File(filesDir, "WhatToDo.txt");
        try {
            FileUtils.writeLines(todofile, dodata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
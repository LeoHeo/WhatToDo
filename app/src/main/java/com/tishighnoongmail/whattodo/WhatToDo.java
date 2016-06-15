package com.tishighnoongmail.whattodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class WhatToDo extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.tishighnoon.whattodo.MESSAGE";
    ArrayList<String> dolist; // array of what to do id =
    ArrayAdapter<String> listadp; //
    ListView lvtodo; //list view variable id=listdo


    //make a list of items to view in list viewer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_do);
        lvtodo = (ListView) findViewById(R.id.listdo);
        dolist = new ArrayList<String>();
        readList();
        listadp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dolist);
        lvtodo.setAdapter(listadp); //hook array to the list view
        //dolist.add("first one");  //Test adding item 1
        //dolist.add("second one"); //test item2
        setupListViewListener();
    }

    //menu controls section
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true:
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        //handles actionbar item clicks, home/up buttons auto handle clicks...
//        //if parent activity is set in AndroidManifest.xml
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    //item adder method
    public void addbtn_click(View v){
        EditText newdo = (EditText) findViewById(R.id.newdo);
        String itemText = newdo.getText().toString();
        listadp.add(itemText);
        newdo.setText("");
        writeList();
    }
   //item deleter method on long press of item
    private void setupListViewListener() {
        lvtodo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                dolist.remove(pos);   //removes the list item
                listadp.notifyDataSetChanged(); //refreshes the listview
                writeList();
                return true;
            }
        });
    }


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


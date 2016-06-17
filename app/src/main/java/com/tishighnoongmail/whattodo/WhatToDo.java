package com.tishighnoongmail.whattodo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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
        deleteonlongclk();
        Entertodoinfo();
    }

    //item adder method
    public void addbtn_click(View v) {
        EditText newdo = (EditText) findViewById(R.id.newdo);
        String itemText = newdo.getText().toString();
        listadp.add(itemText);
        newdo.setText("");
        writeList();    }

//item editer
    public void Entertodoinfo() {
        lvtodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent edittodo = new Intent(WhatToDo.this, EditToDo.class); //new activity
                String taskname = (String)(lvtodo.getItemAtPosition(position));
                edittodo.putExtra("Task Name", (Serializable) taskname);//puts the Task made through to new activity
//                edittodo.putExtra();
//                edittodo.putExtra();
//                edittodo.putExtra();
//                edittodo.putExtra();
                startActivity(edittodo); // brings up the second activity
            }
        });
    }

   //item deleter method on long press of item
    private void deleteonlongclk() {
        lvtodo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, final int pos, long id) {
                AlertDialog.Builder deletealert = new AlertDialog.Builder(WhatToDo.this);
                deletealert.setMessage("Do you want to Delete this thing ToDo?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dolist.remove(pos);   //removes the list item
                                listadp.notifyDataSetChanged(); //refreshes the listview
                                writeList();    }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();    }
                        });
                AlertDialog alert = deletealert.create();
                alert.show();
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


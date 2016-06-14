package com.tishighnoongmail.whattodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


public class WhatToDo extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.tishighnoon.whattodo.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_do);
    }
    public void addbtn_click(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
     //   EditText editText = (EditText) findViewById(R.id.edit_message);
     //   String message = editText.getText().toString();
      //  intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}

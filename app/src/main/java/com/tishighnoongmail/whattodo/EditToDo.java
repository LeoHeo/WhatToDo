package com.tishighnoongmail.whattodo;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class EditToDo extends AppCompatActivity {
    Intent intent = getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);
        String name = getIntent().getStringExtra("Task Name");

        EditText todoname = (EditText)findViewById(R.id.editname);
        todoname.setText(name); //propagate edit field, need to focus end of string


//        // my_child_toolbar is defined in the layout file
//        Toolbar myChildToolbar =
//                (Toolbar) findViewById(R.id.);
//        setSupportActionBar(myChildToolbar);
//
//        // Get a support ActionBar corresponding to this toolbar
//        ActionBar ab = getSupportActionBar();
//
//        // Enable the Up button
//        ab.setDisplayHomeAsUpEnabled(true);
//    }
    }
//
//
//    public void addbtn_click(View v) {
//        EditText newdo = (EditText) findViewById(R.id.newdo);
//        String itemText = newdo.getText().toString();
//        datas.add(itemText);
//}

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }
}
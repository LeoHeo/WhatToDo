package com.tishighnoongmail.whattodo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View fragmentlayout = inflater.inflate(R.layout.fragment_detail,container, false);
        TextView title = (TextView) fragmentlayout.findViewById(R.id.viewtodoname);
        TextView details = (TextView) fragmentlayout.findViewById(R.id.viewtododetails);
        TextView priority = (Spinner) fragmentlayout.findViewById(R.id.priospinner);
        TextView status = (Spinner) fragmentlayout.findViewById(R.id.statusspinner);
        Intent intent = getActivity().getIntent();

        title.setText(intent.getExtras().getString(WhatToDo.TODO_TITLE_EXTRA));
        details.setText(intent.getExtras().getString(WhatToDo.TODO_DETAIL_EXTRA)

        Spinner priospinner = (Spinner) findViewById(R.id.priospinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.todo_priority, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priospinner.setAdapter(adapter);

        Spinner statuspinner = (Spinner) findViewById(R.id.statusspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.todo_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusspinner.setAdapter(adapter);

        todoid.setText(intent.getExtras().getString(WhatToDo.TODO_ID_EXTRA));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);


//        Could be used for the getting drop down text for detail file??
//        .setText(items[position]);??
    }
    }
    }

}

package com.tishighnoongmail.whattodo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhatToDoListFragment extends ListFragment{
    private ArrayList<ToDo> todos;
    private TodoAdapter todoAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        todos = new ArrayList<ToDo>();
        todos.add(new ToDo("Todo Name", "Todo details", ToDo.Priority.High, ToDo.Status.ToDo));
        todoAdapter = new TodoAdapter(getActivity(), todos);
        setListAdapter(todoAdapter);//set adapter to list of todos
//        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
//        getListView().setDividerHeight(1);




//        String[] values = new String[]{ "fe", "ews","srg", "egefe"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, values);
//        setListAdapter(adapter);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v, position, id);

        launchToDoDetail((position));
    }

    private void launchToDoDetail(int position){
        //grab todo info in the clicked todo
        ToDo todo = (ToDo) getListAdapter().getItem(position);
        //create that intent
        Intent intent = new Intent(getActivity(), ToDoDetail.class);
        intent.putExtra(WhatToDo.TODO_TITLE_EXTRA, todo.getTitle());
        intent.putExtra(WhatToDo.TODO_DETAIL_EXTRA, todo.getDetails());
        intent.putExtra(WhatToDo.TODO_PRIO_EXTRA, todo.getPriority());
        intent.putExtra(WhatToDo.TODO_STATUS_EXTRA, todo.getStatus());
        intent.putExtra(WhatToDo.TODO_ID_EXTRA, todo.getId());

        startActivity(intent);
    }


}

package com.tishighnoongmail.whattodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rcharkowicz on 6/21/2016.
 */
public class TodoAdapter extends ArrayAdapter<ToDo>{
    public static class ViewHolder{
        TextView title;
        TextView details;
        TextView priority;}

    public TodoAdapter(Context context, ArrayList<ToDo> todo) {
        super(context, 0, todo);
    }

    @Override
    public View getView(int position, View convertView, ViewGoup parent){
        //get to do item at this position
        ToDo todo = getItem(position);

        ViewHolder viewHolder; //create view holder

        if (convertView == null) { //set views so we dont search each time there is a new row

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.listtodoname);
            viewHolder.details = (TextView) convertView.findViewById(R.id.listtododetail);
            viewHolder.priority = (TextView) convertView.findViewById(R.id.listitemprio);
            //set tag to remember view holder
            convertView.setTag(viewHolder);

        }else {
            //have a view to convert, propagate the data into the view
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(todo.getTitle());
        viewHolder.details.setText(todo.getDetails());
        viewHolder.priority.setText(todo.getstringfromprio());
        //todoStatus.setText(todo.getstringfromstatus());


        //get corresponging spinner drop getDropDownView();

        return convertView;
    }
}

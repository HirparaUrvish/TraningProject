package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urvish.Activity.ListviewLayoutActivity;
import com.example.urvish.R;

public class ListviewLayoutActivityAdapter extends BaseAdapter {

    ListviewLayoutActivity listview_layout;
    String[] fruit;
    private int mSelectedItem;

    public ListviewLayoutActivityAdapter(ListviewLayoutActivity listview_layout, String[] fruit) {
        this.listview_layout = listview_layout;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        @SuppressLint("ViewHolder") View view1=View.inflate(listview_layout, R.layout.listitem,null);

        TextView text_view;
        text_view=view1.findViewById(R.id.text_view456);


        text_view.setText(fruit[i]);

        view1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                Toast.makeText(listview_layout, ""+fruit[i], Toast.LENGTH_SHORT).show();

            }
        });




        return view1;
    }

}

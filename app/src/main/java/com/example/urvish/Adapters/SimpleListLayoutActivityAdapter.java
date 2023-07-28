package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urvish.Activity.SimpleListLayoutActivity;
import com.example.urvish.R;

public class SimpleListLayoutActivityAdapter extends BaseAdapter {

    SimpleListLayoutActivity simplelist_layout;
    String[] listViewItems;

    public SimpleListLayoutActivityAdapter(SimpleListLayoutActivity simplelist_layout, String[] listViewItems) {
        this.simplelist_layout = simplelist_layout;
        this.listViewItems = listViewItems;
    }

    @Override
    public int getCount() {
        return listViewItems.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        @SuppressLint("ViewHolder") View  view1=View.inflate(simplelist_layout, R.layout.activity_simplelisttttt_layout,null);

        TextView text_view;

        text_view=view1.findViewById(R.id.text_view123);

        text_view.setText(listViewItems[i]);

        text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(simplelist_layout, ""+listViewItems[i], Toast.LENGTH_SHORT).show();

            }
        });


        return view1;
    }
}

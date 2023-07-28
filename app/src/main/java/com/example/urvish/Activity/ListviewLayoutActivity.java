package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.R;

public class ListviewLayoutActivity extends AppCompatActivity {

    ListView list_view;
    String[] fruit={"mango","Apple","Orange","Pineapple","Cherry","Litchi"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_layout);

        list_view=findViewById(R.id.list_view456);

        ArrayAdapter adapter = new ArrayAdapter<>( this,
                android.R.layout. simple_list_item_1 , fruit ) ;
        list_view.setAdapter(adapter) ;
        list_view.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick (AdapterView<?> parent , View view , int position , long id) {
                list_view.setSelector(R.color.teal_200);
            }
        }) ;

    }
}
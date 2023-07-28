package com.example.urvish.Activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.Adapters.SimpleListLayoutActivityAdapter;
import com.example.urvish.R;

public class SimpleListLayoutActivity extends AppCompatActivity {

    String[] listViewItems = {"item1","item2","item3","item4","item5","item6","item7","item8"};
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplelist_layout);

        list_view=findViewById(R.id.list_view123);

        SimpleListLayoutActivityAdapter custommmm=new SimpleListLayoutActivityAdapter(this,listViewItems);
        list_view.setAdapter(custommmm);

    }
}
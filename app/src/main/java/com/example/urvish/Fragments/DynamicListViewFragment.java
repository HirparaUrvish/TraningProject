package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.urvish.Activity.HomePageActivity;
import com.example.urvish.Adapters.DynamicListAdapter;
import com.example.urvish.R;


public class DynamicListViewFragment extends Fragment {

    ListView Dynamic_listview;

    String[] Name={"Urvish","Rohan","Raj","Ritul","Prince","Niraj","Milan","Harshit","Jenish","Bhautik","Urvish1","Rohan1","Raj1","Ritul1","Prince1","Niraj1","Milan1","Harshit1","Jenish1","Bhautik1","Urvish2","Rohan2","Raj2","Ritul2","Prince2","Niraj2","Milan2"};
    String[] Number={"6354166108","7069491548","9925921309","8320240000","9895969497","9909189654","9909122222","8585565625","9925375545","9979225630","6354166108","7069491548","9925921309","8320240000","9895969497","9909189654","9909122222","8585565625","9925375545","9979225630","6354166108","7069491548","9925921309","8320240000","9895969497","9909189654","9909122222"};
    int[] color={Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.MAGENTA};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewlist=inflater.inflate(R.layout.fragment_dynamic_list_view, container, false);
        viewlist.setFocusableInTouchMode(true);
        viewlist.requestFocus();
        viewlist.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)   {
                if (keyCode == KeyEvent.KEYCODE_BACK) {


                    FragmentTransaction transaction=getFragmentManager().beginTransaction();
                    transaction.replace(R.id.myview, BasicLayoutFragment.class,null);
                    transaction.commit();
                    HomePageActivity.toolbar.setTitle("Basic Layout");

                    return true;
                }
                return false;
            }
        });
        Dynamic_listview=viewlist.findViewById(R.id.Dynamic_listview);


        DynamicListAdapter dynamicListAdapter=new DynamicListAdapter(this,Name,Number,color);
        Dynamic_listview.setAdapter(dynamicListAdapter);

        // Inflate the layout for this fragment
        return viewlist;
    }
}
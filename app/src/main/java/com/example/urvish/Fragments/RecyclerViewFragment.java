package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.HomePageActivity;
import com.example.urvish.Adapters.RecyclerViewFragmentAdapter;
import com.example.urvish.R;


public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView_fragment;
    String[] Name={"Urvish","Rohan","Raj","Ritul","Prince","Niraj","Milan","Harshit","Jenish","Bhautik","Urvish","Rohan","Raj","Ritul","Prince","Niraj","Milan","Harshit","Jenish","Bhautik","Urvish","Rohan","Raj","Ritul","Prince","Niraj","Milan","Harshit","Jenish","Bhautik"};
    String[] Number={"6354166108","7069491548","9925921309","8320240000","9895969497","9909189654","9909122222","8585565625","9925375545","99792256300","6354166108","7069491548","9925921309","8320240000","9895969497","9909189654","9909122222","8585565625","9925375545","9979225630","6354166108","7069491548","9925921309","8320240000","9895969497","9909189654","9909122222","8585565625","9925375545","9979225630"};
    int[] images_view={R.drawable.root1,R.drawable.root3,R.drawable.root4,R.drawable.root1,R.drawable.root2,R.drawable.root1,
            R.drawable.root2,R.drawable.root3,R.drawable.root4,R.drawable.root1,R.drawable.root2,R.drawable.root1,R.drawable.root3,R.drawable.root4,R.drawable.root1,R.drawable.root2,R.drawable.root1,
            R.drawable.root2,R.drawable.root3,R.drawable.root4,R.drawable.root1,R.drawable.root2,R.drawable.root1,R.drawable.root3,R.drawable.root4,R.drawable.root1,R.drawable.root2,R.drawable.root1,
            R.drawable.root2,R.drawable.root3,R.drawable.root4,R.drawable.root1,R.drawable.root2};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1111=inflater.inflate(R.layout.fragment_recycler_view, container, false);
        view1111.setFocusableInTouchMode(true);
        view1111.requestFocus();
        view1111.setOnKeyListener(new View.OnKeyListener() {
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
        recyclerView_fragment=view1111.findViewById(R.id.recyclerView_fragment);

        RecyclerViewFragmentAdapter recyclerAdapter=new RecyclerViewFragmentAdapter(this,Name,Number,images_view);
        recyclerView_fragment.setAdapter(recyclerAdapter);

        // Inflate the layout for this fragment
        return view1111;
    }
}
package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.urvish.Activity.AndroidButtonActivity;
import com.example.urvish.Activity.CheckBoxActivity;
import com.example.urvish.Activity.DatePickerActivity;
import com.example.urvish.Activity.EditTextActivity;
import com.example.urvish.Activity.HomePageActivity;
import com.example.urvish.Activity.ImageButtonActivity;
import com.example.urvish.Activity.RadioButtonActivity;
import com.example.urvish.Activity.RattingBarActivity;
import com.example.urvish.Activity.SpinnerExampleActivity;
import com.example.urvish.Activity.SwitchButtonActivity;
import com.example.urvish.Activity.TimePickerActivity;
import com.example.urvish.Activity.toggleButtonActivity;
import com.example.urvish.Adapters.InputControlFragmentAdapter;
import com.example.urvish.R;


public class InputControlFragment extends Fragment {

    GridView grid_view;
    String[] button={"Android Button","Image Button","Edit Text","Check Box","Radio Button","Switch Button",
            "Toggle Button","Rating Bar","Spinner Example","Date Picker","Time Picker"};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view21=inflater.inflate(R.layout.fragment_input_,container,false);
        view21.setFocusableInTouchMode(true);
        view21.requestFocus();
        view21.setOnKeyListener(new View.OnKeyListener() {
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

        grid_view=view21.findViewById(R.id.grid_view);


        InputControlFragmentAdapter adapter=new InputControlFragmentAdapter(InputControlFragment.this,button);
        grid_view.setAdapter(adapter);

        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0)
                {
                    Intent intent=new Intent(getContext(), AndroidButtonActivity.class);
                    startActivity(intent);
                }
                if(i==1)
                {
                    Intent intent=new Intent(getContext(), ImageButtonActivity.class);
                    startActivity(intent);
                }
                if(i==2)
                {
                    Intent intent=new Intent(getContext(), EditTextActivity.class);
                    startActivity(intent);
                }
                if(i==3)
                {
                    Intent intent=new Intent(getContext(), CheckBoxActivity.class);
                    startActivity(intent);

                }
                if(i==4)
                {
                    Intent intent=new Intent(getContext(), RadioButtonActivity.class);
                    startActivity(intent);
                }
                if(i==5)
                {
                    Intent intent=new Intent(getContext(), SwitchButtonActivity.class);
                    startActivity(intent);
                }
                if(i==6)
                {
                    Intent intent=new Intent(getContext(), toggleButtonActivity.class);
                    startActivity(intent);
                }
                if(i==7)
                {
                    Intent intent=new Intent(getContext(), RattingBarActivity.class);
                    startActivity(intent);
                }
                if(i==8)
                {
                    Intent intent=new Intent(getContext(), SpinnerExampleActivity.class);
                    startActivity(intent);
                }
                if(i==9)
                {
                    Intent intent=new Intent(getContext(), DatePickerActivity.class);
                    startActivity(intent);
                }
                if(i==10)
                {
                    Intent intent=new Intent(getContext(), TimePickerActivity.class);
                    startActivity(intent);
                }


            }
        });


        return view21;

    }

}
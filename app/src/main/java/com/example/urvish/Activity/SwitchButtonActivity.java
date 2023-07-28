package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.R;

public class SwitchButtonActivity extends AppCompatActivity {

    Switch firsts,seconds,task1s,task2s,task3s,task4s;
    TextView switch_1,switch2,task1,task2,task3,task4;

    @SuppressLint({"M" +
            "issingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);

        firsts=findViewById(R.id.firsts);
        seconds=findViewById(R.id.seconds);
        task1s=findViewById(R.id.task1s);
        task2s=findViewById(R.id.task2s);
        task3s=findViewById(R.id.task3s);
        task4s=findViewById(R.id.task4s);

        switch_1=findViewById(R.id.switch1);
        switch2=findViewById(R.id.switch2);
        task1=findViewById(R.id.task1);
        task2=findViewById(R.id.task2);
        task3=findViewById(R.id.task3);
        task4=findViewById(R.id.task4);

        switch_1.setText("Switch  off");
        switch2.setText("Switch  off");
        task1.setText("Switch 1:off");
        task2.setText("Switch 2:off");
        task3.setText("Switch 3:off");
        task4.setText("Switch 4:off");

        firsts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(firsts.isChecked()){
                    switch_1.setText("Switch  on");
                }else{
                    switch_1.setText("Switch  off");
                }

            }
        });


        seconds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(seconds.isChecked()){
                    switch2.setText("Switch  on");
                }else{
                    switch2.setText("Switch  off");
                }

            }
        });

        task1s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(task1s.isChecked()){
                    task1.setText("Switch 1:on");
                }else{
                    task1.setText("Switch 1:off");
                }

            }
        });

        task2s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if(task2s.isChecked()){
                    task2.setText("Switch 2:on");
                }else{
                    task2.setText("Switch 2:off");
                }

            }
        });


        task3s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(task3s.isChecked()){
                    task3.setText("Switch 3:on");
                }else{
                    task3.setText("Switch 3:off");
                }

            }
        });


        task4s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(task4s.isChecked()){
                    task4.setText("Switch 4:on");
                }else{
                    task4.setText("Switch 4:off");
                }

            }
        });


    }


}
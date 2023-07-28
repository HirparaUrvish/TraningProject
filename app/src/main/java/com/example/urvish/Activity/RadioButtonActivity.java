package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;

public class RadioButtonActivity extends AppCompatActivity {

    RadioButton radio1,radio2,radio3,radio4,radio5,radio6,bihar,gujarat,delhi,bhopal,assam,ajmer,ladakh,diu,daman;
    TextView list_view_check,list_view_check1,list_view_check2;
    StringBuffer stringBuffer11=new StringBuffer();
    StringBuffer result1=new StringBuffer();
    AppCompatButton display;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radio1=findViewById(R.id.radio1);
        radio2=findViewById(R.id.radio2);
        radio3=findViewById(R.id.radio3);
        radio4=findViewById(R.id.radio4);
        bihar=findViewById(R.id.bihar);
        gujarat=findViewById(R.id.gujarat);
        delhi=findViewById(R.id.delhi);
        bhopal=findViewById(R.id.bhopal);
        assam=findViewById(R.id.assam);
        ajmer=findViewById(R.id.ajmer);
        ladakh=findViewById(R.id.ladakh);
        diu=findViewById(R.id.diu);
        radio5=findViewById(R.id.radio5);
        daman=findViewById(R.id.daman);
        radio6=findViewById(R.id.radio6);
        display=findViewById(R.id.display_button111);
        list_view_check=findViewById(R.id.list_view_check111);
        list_view_check1=findViewById(R.id.list_view_check1111);
        list_view_check2=findViewById(R.id.list_view_check11111);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer buffer=new StringBuffer();

                if(radio1.isChecked())
                {
                    buffer.append("\nRadio 1");
                }if(radio2.isChecked())
                {
                    buffer.append("\nRadio 2");
                }if(radio3.isChecked())
                {
                    buffer.append("\nRadio 3");
                }

                list_view_check.setText(buffer.toString());
                list_view_check1.setText(stringBuffer11.toString());
                list_view_check2.setText(result1.toString());

            }
        });


    }

    @SuppressLint("NonConstantResourceId")
    public void onCheckbox(View view) {

        switch (view.getId())
        {

            case R.id.radio4:

                radio5.setChecked(false);
                radio6.setChecked(false);
                if (radio4.isChecked()) {
                    stringBuffer11.delete(0, stringBuffer11.length());
                    stringBuffer11.append("Radio Button 4");

                }
                break;

            case R.id.radio5:

                radio4.setChecked(false);
                radio6.setChecked(false);
                if (radio5.isChecked()) {
                    stringBuffer11.delete(0, stringBuffer11.length());
                    stringBuffer11.append("Radio Button 5");

                }
                break;

            case R.id.radio6:

                radio4.setChecked(false);
                radio5.setChecked(false);
                if (radio6.isChecked()) {
                    stringBuffer11.delete(0, stringBuffer11.length());
                    stringBuffer11.append("Radio Button 6");

                }
                break;

        }

    }

    public void onCheckboxClicked(View view) {

        switch (view.getId())
        {
            case R.id.bihar:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (bihar.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Bihar");

                }
                break;

            case R.id.gujarat:

                bihar.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (gujarat.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Gujarat");
                }
                break;

            case R.id.delhi:

                gujarat.setChecked(false);
                bihar.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (delhi.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Delhi");

                }
                break;


            case R.id.bhopal:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bihar.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (bhopal.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Bhopal");

                }
                break;

            case R.id.assam:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                bihar.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (assam.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Assam");

                }
                break;


            case R.id.ajmer:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                bihar.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (ajmer.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Ajmer");

                }
                break;


            case R.id.ladakh:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                bihar.setChecked(false);
                diu.setChecked(false);
                daman.setChecked(false);
                if (ladakh.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Ladakh");

                }
                break;


            case R.id.diu:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                bihar.setChecked(false);
                daman.setChecked(false);
                if (diu.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Diu");

                }
                break;


            case R.id.daman:

                gujarat.setChecked(false);
                delhi.setChecked(false);
                bhopal.setChecked(false);
                assam.setChecked(false);
                ajmer.setChecked(false);
                ladakh.setChecked(false);
                diu.setChecked(false);
                bihar.setChecked(false);
                if (daman.isChecked()) {
                    result1.delete(0, result1.length());
                    result1.append("Daman");

                }
                break;

        }

    }
}
package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;

public class CheckBoxActivity extends AppCompatActivity {

    CheckBox checkBoxa, checkBoxb, checkBoxc, checkBoxd, checkBoxe, checkBoxf, checkBoxg, checkBoxh, checkBoxi, checkBox1, checkBox2, checkBox3, checkBox4;
    AppCompatButton display_button;
    TextView list_check, list_check1;
    StringBuffer stringBuffer = new StringBuffer();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        checkBoxa = findViewById(R.id.checkboxa);
        checkBoxb = findViewById(R.id.checkboxb);
        checkBoxc = findViewById(R.id.checkboxc);
        checkBoxd = findViewById(R.id.checkboxd);
        checkBoxe = findViewById(R.id.checkboxe);
        checkBoxf = findViewById(R.id.checkboxf);
        checkBoxg = findViewById(R.id.checkboxg);
        checkBoxh = findViewById(R.id.checkboxh);
        checkBoxi = findViewById(R.id.checkboxi);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);


        display_button = findViewById(R.id.display_button);
        list_check = findViewById(R.id.list_view_check);
        list_check1 = findViewById(R.id.list_view_check1);

        display_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                StringBuffer result = new StringBuffer();


                if (checkBoxa.isChecked()) {
                    result.append("\nDance");
                }
                if (checkBoxb.isChecked()) {
                    result.append("\nCricket");
                }
                if (checkBoxc.isChecked()) {
                    result.append("\nFootball");
                }
                if (checkBoxd.isChecked()) {
                    result.append("\nbasketball");
                }
                if (checkBoxe.isChecked()) {
                    result.append("\nCycling");
                }
                if (checkBoxf.isChecked()) {
                    result.append("\nWriting");
                }
                if (checkBoxg.isChecked()) {
                    result.append("\nReading");
                }
                if (checkBoxh.isChecked()) {
                    result.append("\nSwimming");
                }
                if (checkBoxi.isChecked()) {
                    result.append("\nDrawing");
                }
                onCheckboxClicked(view);

                list_check1.setText("" + stringBuffer.toString());
                list_check.setText("" + result.toString());

            }
        });

    }

    public void onCheckboxClicked(View view) {


        switch (view.getId()) {

            case R.id.checkbox1:

                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                if (checkBox1.isChecked()) {
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append("Android");
                }else{
                    stringBuffer.delete(0,stringBuffer.length());
                }
                break;

            case R.id.checkbox2:

                checkBox1.setChecked(false);
                checkBox4.setChecked(false);
                checkBox3.setChecked(false);
                if (checkBox2.isChecked()) {
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append("PHP");
                }else{
                    stringBuffer.delete(0,stringBuffer.length());
                }
                break;

            case R.id.checkbox3:

                checkBox2.setChecked(false);
                checkBox1.setChecked(false);
                checkBox4.setChecked(false);
                if (checkBox3.isChecked()) {
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append("Html");
                }else{
                    stringBuffer.delete(0,stringBuffer.length());
                }
                break;

            case R.id.checkbox4:

                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                if (checkBox4.isChecked()) {
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append("c");
                }else{
                    stringBuffer.delete(0,stringBuffer.length());
                }
                break;


        }

    }
}
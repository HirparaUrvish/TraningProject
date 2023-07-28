package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.R;

public class toggleButtonActivity extends AppCompatActivity {

    ToggleButton toggle_1, toggle_2, toggle_task1, toggle_task2, toggle_task3;
    TextView toggle_text1, toggle_text2, text_task1, text_task2;
    BluetoothAdapter bluetoothAdapter;
    public static final int BLUETOOTH_REQ_CODE = 1;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggle_1 = findViewById(R.id.toggle_1);
        text_task1 = findViewById(R.id.text_task1);
        text_task2 = findViewById(R.id.text_task2);
        toggle_2 = findViewById(R.id.toggle_2);
        toggle_text1 = findViewById(R.id.toggle_text1);
        toggle_text2 = findViewById(R.id.toggle_text2);
        toggle_task1 = findViewById(R.id.toggle_task1);
        toggle_task2 = findViewById(R.id.toggle_task2);
        toggle_task3 = findViewById(R.id.toggle_task3);



        toggle_text1.setText("Toggle is off");
        toggle_text2.setText("Toggle is off");
        text_task2.setText("Bluetooth is off");

        toggle_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (toggle_1.isChecked()) {
                    toggle_text1.setText("Toggle is on");
                } else {
                    toggle_text1.setText("Toggle is off");
                }

            }
        });

        toggle_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (toggle_2.isChecked()) {
                    toggle_text2.setText("Toggle is on");
                } else {
                    toggle_text2.setText("Toggle is off");

                }

            }
        });

        toggle_task1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(toggle_task1.isChecked())
                {
                    text_task1.setText("Wifi is On");
                }else
                {
                    text_task1.setText("Wifi is Off");
                }

            }
        });


        toggle_task2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if (!bluetoothAdapter.isEnabled()) {
                    text_task2.setText(" Bluetooth oFF");
                } else {
                    text_task2.setText(" Bluetooth ON");
                }

                if(toggle_task2.isChecked())
                {
                if (!bluetoothAdapter.isEnabled()) {
                   Intent  bluetoothTntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                   startActivityForResult(bluetoothTntent,BLUETOOTH_REQ_CODE);
                }}else{
                    bluetoothAdapter.disable();
                    text_task2.setText(" Bluetooth OFF");

                }

            }
        });

    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            text_task2.setText(" Bluetooth ON");
        }else
        if(resultCode == RESULT_CANCELED){
            Toast.makeText(toggleButtonActivity.this, "Bluetooth operation is cancelled",
                    Toast.LENGTH_SHORT).show();
        }
    }


}
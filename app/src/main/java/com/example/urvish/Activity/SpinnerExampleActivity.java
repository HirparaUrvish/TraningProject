package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;

public class SpinnerExampleActivity extends AppCompatActivity {

    Spinner spinner_item, spinner_country, spinner_state, spinner_city;
    TextView item_text, text_country;
    String[] item = {"item1", "item2", "item3", "item4", "item5", "item6"};
    String[] country = {"India", "Australia"};
    String[] aus_state = {"Queensland", "SouthAustralia"};
    String[] ind_state = {"Gujarat", "Bihar"};
    String[] quess_city = {"Brisbane", "Cairns"};
    String[] south_city = {"Adelaile", "Portvictoria"};
    String[] gujarat_city = {"Surat", "Bharuch", "Rajkot"};
    String[] bihar_city = {"Patna", "Goya"};
    String s1,s2,s3;
    AppCompatButton Display_item;


    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);

        spinner_item = findViewById(R.id.spinner_item);
        spinner_country = findViewById(R.id.spinner_country);
        Display_item = findViewById(R.id.Display_item);
        spinner_state = findViewById(R.id.spinner_state);
        spinner_city = findViewById(R.id.spinner_city);

        item_text = findViewById(R.id.item_text);
        text_country = findViewById(R.id.text_country);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, item);
        spinner_item.setAdapter(arrayAdapter);
        item_text.setText("You have selected item:"+item[0]);

        spinner_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                String selectedClass = adapterView.getItemAtPosition(i).toString();
                item_text.setText(selectedClass);

                switch (selectedClass) {
                    case "item1":
                        item_text.setText("You have selected item:item1");
                        break;
                    case "item2":
                        item_text.setText("You have selected item:item2");
                        break;
                    case "item3":
                        item_text.setText("You have selected item:item3");
                        break;
                    case "item4":
                        item_text.setText("You have selected item:item4");
                        break;
                    case "item5":
                        item_text.setText("You have selected item:item5");
                        break;
                    case "item6":
                        item_text.setText("You have selected item:item6");
                        break;
                }

                spinner_item.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_country.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                android.R.layout.simple_spinner_dropdown_item,country));

        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedClass1 = adapterView.getItemAtPosition(i).toString();
                switch (selectedClass1)
                {
                    case "India":
                        // assigning div item list defined in XML to the div Spinner
                        s1="India";
                        spinner_state.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,ind_state));
                        break;

                    case "Australia":
                        s1="Australia";
                        spinner_state.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,aus_state));
                        break;

            }

                //set divSpinner Visibility to Visible
                spinner_country.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedClass2 = adapterView.getItemAtPosition(i).toString();

                switch (selectedClass2)
                {
                    case "Gujarat":
                        s2="Gujarat";
                        // assigning div item list defined in XML to the div Spinner
                        spinner_city.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,gujarat_city));
                        break;

                    case "Bihar":
                        s2="Bihar";
                        spinner_city.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,bihar_city));
                        break;

                    case "SouthAustralia":
                        s2="SouthAustralia";
                        spinner_city.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,south_city));
                        break;

                    case "Queensland":
                        s2="Queensland";
                        spinner_city.setAdapter(new ArrayAdapter<String>(SpinnerExampleActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,quess_city));
                        break;

                }

                //set divSpinner Visibility to Visible
                spinner_city.setVisibility(View.VISIBLE);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedClass3 = adapterView.getItemAtPosition(i).toString();
                s3=selectedClass3;




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Display_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text_country.setText(""+s1+"->"+s2+"->"+s3);

            }
        });

    }
}
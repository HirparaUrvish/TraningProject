package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.Adapters.CityListAdapter;
import com.example.urvish.Adapters.CountryListAdapter;
import com.example.urvish.Adapters.StateListAdapter;
import com.example.urvish.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CountryStateCityActivity extends AppCompatActivity {

    String TAG = CountryStateCityActivity.class.getSimpleName();
    JSONArray jsonCountryArray;

    Spinner city_Spinner, state_Spinner, country_Spinner;
    public static int posOfItemSpinnerSelected = -1;
    public static int posOfItemSpinnerSelected1 = -1;
    public static int posOfItemSpinnerSelected2 = -1;


    @SuppressLint({"UseCompatLoadingForDrawables", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_state_city);


        country_Spinner = findViewById(R.id.country_Spinner);
        state_Spinner = findViewById(R.id.state_Spinner);
        city_Spinner = findViewById(R.id.city_Spinner);

        try {
            jsonCountryArray = new JSONObject(loadJSONFromAsset1()).optJSONArray("Countries");

            ArrayList<String> countryList = new ArrayList<>();

            for (int i = 0; i < jsonCountryArray.length(); i++) {
                countryList.add(jsonCountryArray.optJSONObject(i).optString("CountryName"));
            }

            CountryListAdapter countryListAdapter = new CountryListAdapter(this, countryList);
            country_Spinner.setAdapter(countryListAdapter);

            country_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ArrayList<String> stateArray = new ArrayList<>();
                    ((TextView)parent.getChildAt(0)).setBackgroundColor(Color.parseColor("#FFFFFF"));

                    posOfItemSpinnerSelected = position;
                    final JSONArray jsonStateArray = jsonCountryArray.optJSONObject(position).optJSONArray("States");

                    for (int i = 0; i < jsonStateArray.length(); i++) {
                        stateArray.add(jsonStateArray.optJSONObject(i).optString("StateName"));
                    }

                    StateListAdapter stateListAdapter = new StateListAdapter(CountryStateCityActivity.this, stateArray);
                    state_Spinner.setAdapter(stateListAdapter);

                    state_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final ArrayList<String> cityArray = new ArrayList<>();
                            ((TextView)parent.getChildAt(0)).setBackgroundColor(Color.parseColor("#FFFFFF"));
                                    posOfItemSpinnerSelected1 = position;



                            final JSONArray jsonCityArray = jsonStateArray.optJSONObject(position).optJSONArray("Cities");

                            for (int i = 0; i < jsonCityArray.length(); i++) {

                                cityArray.add(jsonCityArray.optString(i));
                            }

                            if (cityArray.isEmpty()) {
                                cityArray.add("No city Available");
                            }
                            CityListAdapter cityListAdapter = new CityListAdapter(CountryStateCityActivity.this, cityArray);
                            city_Spinner.setAdapter(cityListAdapter);

                            city_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    ((TextView)parent.getChildAt(0)).setBackgroundColor(Color.parseColor("#FFFFFF"));
                                            posOfItemSpinnerSelected2 = position;


                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "error=" + e.getMessage());
        }
    }

    public String loadJSONFromAsset1() {
        String json = null;
        try {
            InputStream is = CountryStateCityActivity.this.getAssets().open("country.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
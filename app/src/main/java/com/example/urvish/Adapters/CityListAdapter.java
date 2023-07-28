package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.urvish.Activity.CountryStateCityActivity;
import com.example.urvish.R;

import java.util.ArrayList;

public class CityListAdapter extends BaseAdapter {

    CountryStateCityActivity countryStateCity;
    ArrayList<String> cityArray;

    public CityListAdapter(CountryStateCityActivity countryStateCity, ArrayList<String> cityArray) {
        this.countryStateCity = countryStateCity;
        this.cityArray = cityArray;
    }

    @Override
    public int getCount() {
        return cityArray.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View view= LayoutInflater.from(countryStateCity).inflate(R.layout.simple_spinner_dropdown_item,parent,false);


        TextView textView;
        textView=view.findViewById(R.id.text_spinnnn);
        textView.setText(cityArray.get(position));


        if(position== CountryStateCityActivity.posOfItemSpinnerSelected2){
            textView.setBackgroundColor(Color.GREEN);
        } else {
            textView.setBackgroundColor((Color.WHITE));
        }


        return view;
    }

}

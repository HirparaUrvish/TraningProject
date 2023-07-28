package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.urvish.Fragments.InputControlFragment;
import com.example.urvish.R;

public class InputControlFragmentAdapter extends BaseAdapter {

    InputControlFragment input_fragment;
    String[] button;

    public InputControlFragmentAdapter(InputControlFragment input_fragment, String[] button) {
        this.input_fragment = input_fragment;
        this.button = button;
    }

    @Override
    public int getCount() {
        return button.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        @SuppressLint("ViewHolder") View view1=View.inflate(input_fragment.getActivity(), R.layout.inputdemo,null);

        TextView grid_textview;
        grid_textview=view1.findViewById(R.id.grid_textview);
        grid_textview.setText(button[i]);

        return view1;
    }
}

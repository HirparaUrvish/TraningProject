package com.example.urvish.Adapters;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.urvish.Fragments.DynamicListViewFragment;
import com.example.urvish.R;

public class DynamicListAdapter extends BaseAdapter {

    DynamicListViewFragment dynamicListViewFragment;
    String[] name;
    String[] number;
    int[] color;


    public DynamicListAdapter(DynamicListViewFragment dynamicListViewFragment, String[] name, String[] number, int[] color) {
        this.dynamicListViewFragment = dynamicListViewFragment;
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public int[] getColor() {

        return color;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    public int getViewTypeCount() {
        return getCount();
    }

    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = dynamicListViewFragment.getLayoutInflater();
            convertView = inflater.inflate(R.layout.dymanicadapterview, null);
            holder = new ViewHolder();
            holder.titleText = (TextView) convertView.findViewById(R.id.List_title);
            holder.imageView = (TextView) convertView.findViewById(R.id.List_icon);
            holder.subtitleText = (TextView) convertView.findViewById(R.id.List_subtitle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String s1 = String.valueOf(name[position].charAt(0));
        holder.titleText.setText(name[position]);
        holder.imageView.setText(s1.toUpperCase());

        //set background textview background
        if (position < color.length) {
            holder.imageView.setBackgroundColor(color[position]);
        } else {
            holder.imageView.setBackgroundColor(color[position % color.length]);
        }


        holder.subtitleText.setText(number[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] Items = {"Person", "Family", "Friend", "Unknown"};

                AlertDialog alertDialog;
                AlertDialog.Builder builder1 = new AlertDialog.Builder(dynamicListViewFragment.getActivity());
                builder1.setTitle("Option Dialog");
                builder1.setCancelable(true);
                builder1.setItems(Items, new DialogInterface.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    public void onClick(DialogInterface dialog, int which) {

                        if (Items[which].equals(Items[0])) {
                            holder.titleText.setTextColor(Color.BLUE);
                        } else if (Items[which].equals(Items[1])) {
                            holder.titleText.setTextColor(Color.GREEN);
                        } else if (Items[which].equals(Items[2])) {
                            holder.titleText.setTextColor(Color.RED);
                        } else {
                            holder.titleText.setTextColor(Color.MAGENTA);
                        }

                    }
                });
                alertDialog = builder1.create();
                alertDialog.show();
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView titleText;
        TextView imageView;
        TextView subtitleText;
    }

}

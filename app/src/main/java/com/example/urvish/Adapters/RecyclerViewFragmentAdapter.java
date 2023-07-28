package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Fragments.RecyclerViewFragment;
import com.example.urvish.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewFragmentAdapter extends RecyclerView.Adapter<RecyclerViewFragmentAdapter.myclass> {

    RecyclerViewFragment recyclerViewFragment;
    String[] name;
    String[] number;
    int[] images_view;
    int selectedPosition = -1;


    public RecyclerViewFragmentAdapter(RecyclerViewFragment recyclerViewFragment, String[] name, String[] number, int[] images_view) {
        this.recyclerViewFragment = recyclerViewFragment;
        this.name = name;
        this.number = number;
        this.images_view = images_view;
    }

    @NonNull
    @Override
    public RecyclerViewFragmentAdapter.myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(recyclerViewFragment.getActivity()).inflate(R.layout.recyclerviewdemo,parent,false);

        return new myclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFragmentAdapter.myclass holder, @SuppressLint("RecyclerView") int position) {


        holder.Recycler_image.setImageResource(images_view[position]);
        holder.Recycler_title.setText(name[position]);
        holder.Recycler_subtitle.setText(number[position]);

        holder.Recycler_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = position;
                notifyDataSetChanged();
            }
        });
        if(selectedPosition == position){
            holder.Recycler_title.setTextColor(Color.RED);
        }
        else
        {
           holder.Recycler_title.setTextColor(Color.BLACK);
        }


    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    public class myclass extends RecyclerView.ViewHolder {

        TextView Recycler_subtitle,Recycler_title;
        CircleImageView Recycler_image;

        public myclass(@NonNull View itemView) {
            super(itemView);

            Recycler_image=itemView.findViewById(R.id.Recycler_image11);
            Recycler_title=itemView.findViewById(R.id.Recycler_title);
            Recycler_subtitle=itemView.findViewById(R.id.Recycler_subtitle);

        }

    }

}


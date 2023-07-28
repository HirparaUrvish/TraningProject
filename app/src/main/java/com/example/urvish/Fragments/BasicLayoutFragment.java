package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.urvish.Activity.AbsoluteLayoutActivity;
import com.example.urvish.Activity.FrameLayoutActivity;
import com.example.urvish.Activity.HorizontalScrollViewLayoutActivity;
import com.example.urvish.Activity.LinearLayoutActivity;
import com.example.urvish.Activity.ListviewLayoutActivity;
import com.example.urvish.Activity.RelativeLayoutActivity;
import com.example.urvish.Activity.ScrollViewLayoutActivity;
import com.example.urvish.Activity.SimpleListLayoutActivity;
import com.example.urvish.Activity.TableLayoutActivity;
import com.example.urvish.Activity.ViewPositionLayoutActivity;
import com.example.urvish.R;


public class BasicLayoutFragment extends Fragment {

    TextView liner_layout, relative_layout, table_layout, frame_layout, absolute_layout, scroll_view_layout,
            horizontal_scroll_view_layout, simplelist_layout, list_view_layout, view_position_layout;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view11=inflater.inflate(R.layout.fragment_demo__layout,container,false);

        liner_layout =view11.findViewById(R.id.liner_layout);
        relative_layout = view11.findViewById(R.id.relative_layout);
        table_layout = view11.findViewById(R.id.table_layout);
        frame_layout = view11.findViewById(R.id.frame_layout);
        absolute_layout = view11.findViewById(R.id.absolute_layout);
        scroll_view_layout = view11.findViewById(R.id.scroll_view_layout);
        horizontal_scroll_view_layout = view11.findViewById(R.id.horizontal_scroll_view_layout);
        simplelist_layout = view11.findViewById(R.id.simplelist_layout);
        list_view_layout = view11.findViewById(R.id.list_view_layout);
        view_position_layout =view11. findViewById(R.id.view_position_layout);

        liner_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), LinearLayoutActivity.class);
                startActivity(intent);


            }
        });

        relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), RelativeLayoutActivity.class);
                startActivity(intent);

            }
        });

        table_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), TableLayoutActivity.class);
                startActivity(intent);

            }
        });

        frame_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), FrameLayoutActivity.class);
                startActivity(intent);

            }
        });

        absolute_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), AbsoluteLayoutActivity.class);
                startActivity(intent);


            }
        });

        scroll_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ScrollViewLayoutActivity.class);
                startActivity(intent);


            }
        });

        horizontal_scroll_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), HorizontalScrollViewLayoutActivity.class);
                startActivity(intent);

            }
        });

        simplelist_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SimpleListLayoutActivity.class);
                startActivity(intent);

            }
        });

        list_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ListviewLayoutActivity.class);
                startActivity(intent);

            }
        });

        view_position_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ViewPositionLayoutActivity.class);
                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return view11;
    }

}
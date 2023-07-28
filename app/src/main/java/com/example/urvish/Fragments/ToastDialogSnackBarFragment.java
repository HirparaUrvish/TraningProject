package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.urvish.Activity.DialogExampleActivity;
import com.example.urvish.Activity.HomePageActivity;
import com.example.urvish.Activity.SnackBarControlActivity;
import com.example.urvish.Activity.ToastExampleActivity;
import com.example.urvish.R;


public class ToastDialogSnackBarFragment extends Fragment {

    TextView toast_text, dialog_text, snack_text;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view55=inflater.inflate(R.layout.fragment_toast_, container, false);
        view55.setFocusableInTouchMode(true);
        view55.requestFocus();
        view55.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)   {
                if (keyCode == KeyEvent.KEYCODE_BACK) {


                    FragmentTransaction transaction=getFragmentManager().beginTransaction();
                    transaction.replace(R.id.myview, BasicLayoutFragment.class,null);
                    transaction.commit();
                    HomePageActivity.toolbar.setTitle("Basic Layout");

                    return true;
                }
                return false;
            }
        });

        toast_text = view55.findViewById(R.id.ttt1);
        dialog_text = view55.findViewById(R.id.ttt2);
        snack_text = view55.findViewById(R.id.ttt3);


        toast_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ToastExampleActivity.class);
                startActivity(intent);

            }
        });

        dialog_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DialogExampleActivity.class);
                startActivity(intent);

            }
        });

        snack_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SnackBarControlActivity.class);
                startActivity(intent);

            }
        });


        // Inflate the layout for this fragment

        return view55;
    }
}
package com.example.urvish.Fragments;

import static com.example.urvish.Activity.HomePageActivity.toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.urvish.R;


public class CardViewDemoFragment extends Fragment {


    TextView cardtext_view;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view900=inflater.inflate(R.layout.fragment_cardview, container, false);
        view900.setFocusableInTouchMode(true);
        view900.requestFocus();
        view900.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)   {
                if (keyCode == KeyEvent.KEYCODE_BACK) {


                    FragmentTransaction transaction=getFragmentManager().beginTransaction();
                    transaction.replace(R.id.myview, BasicLayoutFragment.class,null);
                    transaction.commit();
                    toolbar.setTitle("Basic Layout");

                    return true;
                }
                return false;
            }
        });
        cardtext_view=view900.findViewById(R.id.cardtext_view);

        cardtext_view.setText(HtmlCompat.fromHtml("<font color='#ff9d5c'> Small plates</font> salads & sandwiches an <br> intimate setting with 12 Indoor seats" +
                        "<br> plus patio seating gth", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Inflate the layout for this fragment
        return view900;
    }
}
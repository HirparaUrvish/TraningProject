package com.example.urvish.Fragments;

import static com.example.urvish.Activity.HomePageActivity.toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.urvish.R;

public class DrawableDemoFragment extends Fragment {
    Spinner image_spinner;
    ImageView image_zoom;
    String[] image = {"Zoom","Blink","Fade"};
    Animation zoomin;
    TextView textview1111111111;
    EditText text_drawable;
    String s1;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view51=inflater.inflate(R.layout.fragment_drawable_, container, false);
        view51.setFocusableInTouchMode(true);
        view51.requestFocus();
        view51.setOnKeyListener(new View.OnKeyListener() {
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
        image_spinner = view51.findViewById(R.id.image_spinner);
        image_zoom =view51. findViewById(R.id.image_zoom);
        textview1111111111 =view51. findViewById(R.id.textview1111111111);
        text_drawable =view51. findViewById(R.id.text_drawable);


        text_drawable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s1=text_drawable.getText().toString();
                textview1111111111.setText(s1);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, image);
        image_spinner.setAdapter(arrayAdapter);

        image_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedClass1 = adapterView.getItemAtPosition(i).toString();
                switch (selectedClass1) {
                    case "Zoom":
                        // assigning div item list defined in XML to the div Spinner
                        zoomin = AnimationUtils.loadAnimation(getActivity(), R.anim.ok);
                        image_zoom.setAnimation(zoomin);
                        image_zoom.startAnimation(zoomin);
                        break;

                    case "Blink":
                        Animation animation = new AlphaAnimation(1, 0); //to change visibility from visible to invisible
                        animation.setDuration(500); //1 second duration for each animation cycle
                        animation.setInterpolator(new LinearInterpolator());
                        animation.setRepeatCount(Animation.INFINITE); //repeating indefinitely
                        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
                        image_zoom.startAnimation(animation);
                        break;

                    case "Fade":
                        Animation aniFade = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in);
                        aniFade.setRepeatCount(Animation.INFINITE);
                        image_zoom.setAnimation(aniFade);
                        image_zoom.startAnimation(aniFade);
                        break;
                }
                //set divSpinner Visibility to Visible
                image_spinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        // Inflate the layout for this fragment
        return view51;
    }
}
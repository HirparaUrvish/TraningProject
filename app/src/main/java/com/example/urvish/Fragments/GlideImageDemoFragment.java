package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.urvish.Activity.HomePageActivity;
import com.example.urvish.R;

public class GlideImageDemoFragment extends Fragment {
    ImageView glide_image1, glide_image2;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view41=inflater.inflate(R.layout.fragment_glide_, container, false);
        view41.setFocusableInTouchMode(true);
        view41.requestFocus();
        view41.setOnKeyListener(new View.OnKeyListener() {
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
        // Inflate the layout for this fragment

        glide_image1 =view41. findViewById(R.id.glide_image1);
        glide_image2 = view41.findViewById(R.id.glide_image2);

        Glide.with(getActivity()).load("https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?cs=srgb&dl=pexels-pixabay-268533.jpg&fm=jpg").placeholder(R.drawable.img).error(R.drawable.img_1).into(glide_image1);
        Glide.with(getActivity()).load("https://thumbs.dreamstime.com/b/beautiful-rain-forest-ang-ka-nature-trail-doi-inthanon-national-park-thailand-36703721.jpg").placeholder(R.drawable.img).error(R.drawable.img_1).into(glide_image2);



        return view41;
    }
}
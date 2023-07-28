package com.example.urvish.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.urvish.Activity.HomePageActivity;
import com.example.urvish.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationViewFragment extends Fragment {

    BottomNavigationView Bottom_menu_bar;
    LinearLayout linearLayout;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view66 = inflater.inflate(R.layout.fragment_bottom_, container, false);
        view66.setFocusableInTouchMode(true);
        view66.requestFocus();
        view66.setOnKeyListener(new View.OnKeyListener() {
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
        Bottom_menu_bar = view66.findViewById(R.id.Bottom_menu_bar);
        linearLayout = view66.findViewById(R.id.mmmmmmmmmm);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        fragmentTransaction.replace(R.id.mmmmmmmmmm, BasicLayoutFragment.class, null);
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
        HomePageActivity.toolbar.setTitle("Basic Layout");

        Bottom_menu_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private NavigationBarView bottomNavigation;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.demo_navigation) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    fragmentTransaction.replace(R.id.mmmmmmmmmm, BasicLayoutFragment.class, null);
                    fragmentTransaction.addToBackStack(null);
                    // Commit the transaction
                    fragmentTransaction.commit();
                    HomePageActivity.toolbar.setTitle("Basic Layout");
                    return true;


                }
                if (item.getItemId() == R.id.input_navigation) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    fragmentTransaction.replace(R.id.mmmmmmmmmm, InputControlFragment.class, null);
                    fragmentTransaction.addToBackStack(null);
                    // Commit the transaction
                    fragmentTransaction.commit();
                    HomePageActivity.toolbar.setTitle("Input Control");
                    return true;
                }
                if (item.getItemId() == R.id.dialog_navigation) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    fragmentTransaction.replace(R.id.mmmmmmmmmm, ToastDialogSnackBarFragment.class, null);
                    fragmentTransaction.addToBackStack(null);
                    // Commit the transaction
                    fragmentTransaction.commit();
                    HomePageActivity.toolbar.setTitle("Toast,Dialog and SnackBar");
                    return true;
                }
                return false;
            }
        });

        // Inflate the layout for this fragment
        return view66;
    }
}



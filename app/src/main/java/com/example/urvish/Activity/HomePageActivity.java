package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.urvish.Fragments.BasicLayoutFragment;
import com.example.urvish.Fragments.BottomNavigationViewFragment;
import com.example.urvish.Fragments.CardViewDemoFragment;
import com.example.urvish.Fragments.DrawableDemoFragment;
import com.example.urvish.Fragments.DynamicListViewFragment;
import com.example.urvish.Fragments.GlideImageDemoFragment;
import com.example.urvish.Fragments.InputControlFragment;
import com.example.urvish.Fragments.RecyclerViewFragment;
import com.example.urvish.Fragments.ToastDialogSnackBarFragment;
import com.example.urvish.R;
import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;
    LinearLayout linearLayout;
    NavigationView navigationView;
    public static Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        drawer_layout = findViewById(R.id.drawer_layout);
        linearLayout = findViewById(R.id.myview);
        navigationView = findViewById(R.id.navi_demooo);
        toolbar = findViewById(R.id.toll_bar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(HomePageActivity.this, drawer_layout, toolbar, R.string.open, R.string.close);

        actionBarDrawerToggle.syncState();

        getSupportActionBar();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.myview, BasicLayoutFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
        toolbar.setTitle("Basic Layout");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bbasic_layout) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, BasicLayoutFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Basic Layout");
                }
                if (item.getItemId() == R.id.input_navigation) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, InputControlFragment.class,null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Input Control");
                }
                if (item.getItemId() == R.id.dialog_navigation) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, ToastDialogSnackBarFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Toast,Dialog and SnackBar");
                }
                if (item.getItemId() == R.id.image_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, GlideImageDemoFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Image Load Using Glide");
                }
                if (item.getItemId() == R.id.Drawable_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, DrawableDemoFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Drawable");
                }
                if (item.getItemId() == R.id.Bottom_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, BottomNavigationViewFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Bottom Navigation");
                }
                if (item.getItemId() == R.id.Bottom_Sheet_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, BottomSheetActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.Cardview_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, CardViewDemoFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Card View");
                }
                if (item.getItemId() == R.id.Dynamic_listview_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, DynamicListViewFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Dynamic List View");
                }
                if (item.getItemId() == R.id.RecyclerView_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.myview, RecyclerViewFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                    toolbar.setTitle("Recycle View");
                }
                if (item.getItemId() == R.id.Usergson_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, UserDetailsGetUsingGsonActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.Countryjson_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, CountryStateCityActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.Json_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, JsonActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.Collasping_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, CollapsingTooalbarActivity.class);
                    startActivity(intent);
                }if (item.getItemId() == R.id.Database_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, SQLiteDataBaseActivity.class);
                    startActivity(intent);
                }if (item.getItemId() == R.id.Api_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, UserUsingVolleyActivity.class);
                    startActivity(intent);
                }if (item.getItemId() == R.id.Api1_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, UserUsingRetrofitActivity.class);
                    startActivity(intent);
                }if (item.getItemId() == R.id.Woc_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, WocDesignActivity.class);
                    startActivity(intent);
                }if (item.getItemId() == R.id.MVP_nevi) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                    Intent intent = new Intent(HomePageActivity.this, MVPArchitectureActivity.class);
                    startActivity(intent);
                }

                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Confirm Exit")
                .setMessage("Do you want to exit app?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create().show();
    }
}
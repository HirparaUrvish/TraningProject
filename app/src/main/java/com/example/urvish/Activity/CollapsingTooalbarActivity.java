package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Adapters.CollapsingTooalbarActivityAdapter;
import com.example.urvish.R;
import com.example.urvish.modelClasses.EmployDetailResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class CollapsingTooalbarActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView collapsing_recyclerview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tooalbar);
        toolbar = findViewById(R.id.toolbar12);
        setSupportActionBar(toolbar);

        collapsing_recyclerview = findViewById(R.id.collapsing_recyclerview);

        Gson gson = new Gson();
        EmployDetailResponse personString = gson.fromJson(loadJSONFromAsset(), EmployDetailResponse.class);

        CollapsingTooalbarActivityAdapter collapsingAdapter = new CollapsingTooalbarActivityAdapter(CollapsingTooalbarActivity.this, personString);
        collapsing_recyclerview.setAdapter(collapsingAdapter);


    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = CollapsingTooalbarActivity.this.getAssets().open("dummy.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(CollapsingTooalbarActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();

    }
}
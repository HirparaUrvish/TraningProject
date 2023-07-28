
package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Adapters.JsonActivityAdapter;
import com.example.urvish.R;
import com.example.urvish.modelClasses.SimpleJsonResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class JsonActivity extends Activity {
    RecyclerView simplejson_recyclerview;

    /*ArrayList<String> namelist11 = new ArrayList<String>();
    ArrayList<String> strength11 = new ArrayList<String>();
    ArrayList<String> dose11 = new ArrayList<String>();
    ArrayList<String> route11 = new ArrayList<String>();
    ArrayList<String> sig11 = new ArrayList<String>();
    ArrayList<String> pillCount11 = new ArrayList<String>();
    ArrayList<String> refills11 = new ArrayList<String>();
    ArrayList<String> namelab = new ArrayList<String>();
    ArrayList<String> timelab = new ArrayList<String>();
    ArrayList<String> locationlab = new ArrayList<String>();*/

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        simplejson_recyclerview=findViewById(R.id.simplejson_recyclerview);

        Gson gson=new Gson();
        SimpleJsonResponse permedical =gson.fromJson(loadJSONFromAssettt(),SimpleJsonResponse.class);


        /*try {
            JSONObject jsonObj = new JSONObject(loadJSONFromAssettt());
            JSONArray simplearray = jsonObj.getJSONArray("medications");

            for (int r = 0; r < simplearray.length(); r++) {
                JSONObject c = simplearray.getJSONObject(r);

                JSONArray sarry = c.getJSONArray("aceInhibitors");
                for (int q = 0; q < sarry.length(); q++) {
                    JSONObject sarryy = sarry.getJSONObject(q);
                    namelist11.add(sarryy.getString("name"));
                    strength11.add(sarryy.getString("strength"));
                    dose11.add(sarryy.getString("dose"));
                    route11.add(sarryy.getString("route"));
                    sig11.add(sarryy.getString("sig"));
                    pillCount11.add(sarryy.getString("pillCount"));
                    refills11.add(sarryy.getString("refills"));
                }

            }

            JSONArray simplearrayy = jsonObj.getJSONArray("labs");
            for (int p = 0; p < simplearrayy.length(); p++) {
                JSONObject cc = simplearrayy.getJSONObject(p);
                namelab.add(cc.getString("name"));
                timelab.add(cc.getString("time"));
                locationlab.add(cc.getString("location"));
            }*/

        JsonActivityAdapter simpleAdapter21=new JsonActivityAdapter(JsonActivity.this,/*namelist11,strength11,dose11,route11,sig11,pillCount11,refills11,
                    namelab,timelab,locationlab*/permedical);
        simplejson_recyclerview.setAdapter(simpleAdapter21);


       /* } catch (JSONException e) {
            e.printStackTrace();
        }*/

    }

    public String loadJSONFromAssettt() {
        String json = null;
        try {
            InputStream is = JsonActivity.this.getAssets().open("simple.json");
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
}

package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Adapters.UserDetailsGetUsingGsonActivityAdapter;
import com.example.urvish.R;
import com.example.urvish.modelClasses.EmployDetailResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class UserDetailsGetUsingGsonActivity extends Activity {

    String TAG = UserDetailsGetUsingGsonActivity.class.getSimpleName();
    /*int a = 0;
    ArrayList<String> taglist = new ArrayList<String>();
    ArrayList<String> namelist = new ArrayList<String>();
    ArrayList<String> genderlist = new ArrayList<String>();
    ArrayList<String> eyelist = new ArrayList<String>();
    ArrayList<String> emaillist = new ArrayList<String>();
    ArrayList<String> phonelist = new ArrayList<String>();
    ArrayList<String> companylist = new ArrayList<String>();
    ArrayList<String> addresslist = new ArrayList<String>();
    ArrayList<String> fruitlist = new ArrayList<String>();
    ArrayList<String> balancelist = new ArrayList<String>();
    ArrayList<String> idlist = new ArrayList<String>();
    ArrayList<String> friendnamelist = new ArrayList<String>();*/
    RecyclerView Usergson_recyclerview;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detailsgetusing_gson);

        Usergson_recyclerview = findViewById(R.id.Usergson_recyclerview);

        Gson gson = new Gson();
        EmployDetailResponse personString = gson.fromJson(loadJSONFromAsset(), EmployDetailResponse.class);


        /*try {
            JSONObject jsonObj = new JSONObject(loadJSONFromAsset());
            JSONArray contacts = jsonObj.getJSONArray("EmployeeDetails");


            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);
                ArrayList<String> taglist11 = new ArrayList<String>();
                ArrayList<String> fri11 = new ArrayList<String>();
                namelist.add(c.getString("name"));
                genderlist.add(c.getString("gender"));
                eyelist.add(c.getString("eyeColor"));
                emaillist.add(c.getString("email"));
                phonelist.add(c.getString("phone"));
                companylist.add(c.getString("company"));
                addresslist.add(c.getString("address"));
                fruitlist.add(c.getString("favoriteFruit"));
                balancelist.add(c.getString("balance"));
                JSONArray tags = c.getJSONArray("tags");
                for (int l = 0; l < tags.length(); l++) {
                    taglist11.add((String) tags.get(l));
                }
                taglist.add(taglist11.toString();)
                JSONArray friend = c.getJSONArray("friends");
                for (int y = 0; y < friend.length(); y++) {
                    JSONObject fri = friend.getJSONObject(y);
                    int id = fri.getInt("id");
                    fri11.add(String.valueOf(id));
                    a = fri11.size();
                }
                friendnamelist.add(String.valueOf(a));
            }*/

        UserDetailsGetUsingGsonActivityAdapter usergsonAdapter = new UserDetailsGetUsingGsonActivityAdapter(UserDetailsGetUsingGsonActivity.this,/* taglist, namelist, genderlist, eyelist, emaillist, phonelist, companylist
                    , addresslist, friendnamelist, idlist, fruitlist, balancelist*/personString);
        Usergson_recyclerview.setAdapter(usergsonAdapter);

/*
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = UserDetailsGetUsingGsonActivity.this.getAssets().open("dummy.json");
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

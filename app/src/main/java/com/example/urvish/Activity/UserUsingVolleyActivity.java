package com.example.urvish.Activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.urvish.Adapters.UserUsingVolleyActivityAdapter;
import com.example.urvish.R;
import com.example.urvish.modelClasses.VolleyModalClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserUsingVolleyActivity extends AppCompatActivity {

    public static RecyclerView User_recyclerview;
    public static ArrayList<VolleyModalClass> volleystring = new ArrayList<>();
    FloatingActionButton volley_add;
    public static UserUsingVolleyActivityAdapter uservolleyAdapter;
    private ProgressBar loadingPB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userusingvolley);

        User_recyclerview = findViewById(R.id.User_recyclerview);
        volley_add = findViewById(R.id.volley_add);
        loadingPB = findViewById(R.id.idLoadingPB);

        volley_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserUsingVolleyActivity.this, VolleyUserAddActivity.class);
                startActivity(intent);
                finish();

            }
        });

        getAllUserData();


    }

    public void getAllUserData() {

        RequestQueue queue = Volley.newRequestQueue(UserUsingVolleyActivity.this);
        String url = "https://gorest.co.in/public/v2/users";
        loadingPB.setVisibility(View.VISIBLE);

// Request a string response from the provided URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        if(response!=null){
                        volleystring.clear();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject responseObj = response.getJSONObject(i);

                                Log.i(TAG, "onResponse: " + response);

                                int id = responseObj.getInt("id");
                                String name = responseObj.getString("name");
                                String email = responseObj.getString("email");
                                String gender = responseObj.getString("gender");
                                String status = responseObj.getString("status");

                                VolleyModalClass EX = new VolleyModalClass(id, name, email, gender, status);
                                volleystring.add(EX);

                                initAdapter();

                                loadingPB.setVisibility(View.GONE);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }else{
                            Toast.makeText(UserUsingVolleyActivity.this, "Response is null", Toast.LENGTH_SHORT).show();
                            loadingPB.setVisibility(View.GONE);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserUsingVolleyActivity.this, "Response is null", Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821");
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821");
                params.put("Content-Type", "application/json");
                params.put("Accept", "application/json");
                return params;
            }
        };

// Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);

    }

    private void initAdapter() {


        uservolleyAdapter = new UserUsingVolleyActivityAdapter(UserUsingVolleyActivity.this, volleystring);
        User_recyclerview.setAdapter(uservolleyAdapter);


        uservolleyAdapter.setOnAPIResponse(new UserUsingVolleyActivityAdapter.OnAPIResponse() {
            @Override
            public void deleteUser(VolleyModalClass example) {

                Log.i(TAG, "deleteUser: example : " + example);

                AlertDialog.Builder builder = new AlertDialog.Builder(UserUsingVolleyActivity.this);
                builder.setMessage("Do you want to Delete " + example.getName() + " User Information ?")
                        .setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        deleteUserAPI(example);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void UserUpadet(VolleyModalClass ll) {

                Intent intent = new Intent(UserUsingVolleyActivity.this, VolleyUserAddActivity.class);
                intent.putExtra("name", ll.getName());
                intent.putExtra("email", ll.getEmail());
                intent.putExtra("gender", ll.getGender());
                intent.putExtra("status", ll.getStatus());
                intent.putExtra("id", ll.getId());
                startActivity(intent);
                finish();
            }

        });
    }

    private void deleteUserAPI(VolleyModalClass example) {
        RequestQueue queue = Volley.newRequestQueue(UserUsingVolleyActivity.this);
        int iqd = example.getId();
        String url = "https://gorest.co.in/public/v2/users/" + iqd;

        Log.i(TAG, "onClick: " + url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        if (response != null) {
                            getAllUserData();
                            Log.i(TAG, "onResponse: " + response.toString());
                            Toast.makeText(UserUsingVolleyActivity.this, "User Delete Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(UserUsingVolleyActivity.this, "not ok", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                getAllUserData();
                Log.i(TAG, "onErrorResponse: " + error);
                Toast.makeText(UserUsingVolleyActivity.this, "User Delete Successfully", Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821");
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821");
                params.put("Content-Type", "application/json");
                params.put("Accept", "application/json");
                return params;
            }


        };
        queue.add(jsonObjectRequest);
    }


}

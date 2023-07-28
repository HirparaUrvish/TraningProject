package com.example.urvish.Activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyUserAddActivity extends AppCompatActivity {

    EditText volley_name1, volley_email1, volley_gender1, volley_status1;
    AppCompatButton volley_ok1;
    TextView volleyr;
    private ProgressBar loadingPB;
    private int position = -1;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyuseradd);

        volley_name1 = findViewById(R.id.volley_name1);
        volley_email1 = findViewById(R.id.volley_email1);
        volley_gender1 = findViewById(R.id.volley_gender1);
        volley_status1 = findViewById(R.id.volley_status1);
        volleyr = findViewById(R.id.volleyr);
        volley_ok1 = findViewById(R.id.volley_ok1);
        loadingPB = findViewById(R.id.idLoadingPB1);

        int iddd = getIntent().getIntExtra("id", 0);
        String name1 = getIntent().getStringExtra("name");
        String email1 = getIntent().getStringExtra("email");
        String gender1 = getIntent().getStringExtra("gender");
        String status1 = getIntent().getStringExtra("status");

        if (iddd != 0) {
            position = iddd;
            volleyr.setText("Update User Using OBVolley");
            volley_ok1.setText("Update User");
        }

        if (position != -1) {
            volley_name1.setText(name1);
            volley_email1.setText(email1);
            volley_gender1.setText(gender1);
            volley_status1.setText(status1);
        }

        Log.i(TAG, "onCreate: " + name1);
        Log.i(TAG, "onCreate: " + email1);
        Log.i(TAG, "onCreate: " + gender1);
        Log.i(TAG, "onCreate: " + status1);
        Log.i(TAG, "onCreate: " + position);


        volley_ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == -1) {
                    String name = String.valueOf(volley_name1.getText());
                    String email = String.valueOf(volley_email1.getText());
                    String gender = String.valueOf(volley_gender1.getText());
                    String status = String.valueOf(volley_status1.getText());

                    if (name.equals("")) {
                        volley_name1.setError("Please enter your Name");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.equals("") && UserUsingVolleyActivity.volleystring.contains(email)) {
                        volley_email1.setError("please enter your Email");
                    } else if (gender.equals("")) {
                        volley_gender1.setError("Please enter your Age");
                    } else if (!gender.equals("male") && !gender.equals("female")) {
                        volley_gender1.setError("Invalid gender");
                    } else if (status.equals("")) {
                        volley_status1.setError("please enter status");
                    } else if (!status.equals("Active") && !status.equals("active") && !status.equals("Inactive") && !status.equals("inactive")) {
                        volley_status1.setError("please enter valid status");
                    } else {
                        InsertNewUser(name, email, gender, status);
                    }
                } else {
                    String name = String.valueOf(volley_name1.getText());
                    String email = String.valueOf(volley_email1.getText());
                    String gender = String.valueOf(volley_gender1.getText());
                    String status = String.valueOf(volley_status1.getText());

                    Log.i(TAG, "onCreate: " + name);
                    Log.i(TAG, "onCreate: " + email);
                    Log.i(TAG, "onCreate: " + gender);
                    Log.i(TAG, "onCreate: " + status);
                    Log.i(TAG, "onCreate: " + position);

                    if (name.equals("")) {
                        volley_name1.setError("Please enter your Name");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.equals("") && UserUsingVolleyActivity.volleystring.contains(email)) {
                        volley_email1.setError("please enter your Email");
                    } else if (gender.equals("")) {
                        volley_gender1.setError("Please enter your Age");
                    } else if (!gender.equals("male") && !gender.equals("female")) {
                        volley_gender1.setError("Invalid gender");
                    } else if (status.equals("")) {
                        volley_status1.setError("please enter status");
                    } else if (!status.equals("Active") && !status.equals("active") && !status.equals("Inactive") && !status.equals("inactive")) {
                        volley_status1.setError("please enter valid status");
                    } else {
                        UpdaetaUser(name, email, gender, status);
                    }

                }

            }

        });

    }

    private void InsertNewUser(String name, String email, String gender, String status) {
        loadingPB.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(VolleyUserAddActivity.this);
        String url = "https://gorest.co.in/public/v2/users";

        JSONObject params1 = new JSONObject();
        try {
            params1.put("name", name);
            params1.put("email", email);
            params1.put("gender", gender);
            params1.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.POST, url, params1,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i(TAG, "onResponse: " + response.toString());


                        Log.i(TAG, "onResponse: " + response.toString());

                        AfternewAdd();

                        loadingPB.setVisibility(View.GONE);

                        Intent intent = new Intent(VolleyUserAddActivity.this, UserUsingVolleyActivity.class);
                        startActivity(intent);
                        finish();

                        Toast.makeText(VolleyUserAddActivity.this, "User Add Successfully", Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG, "onErrorResponse: " + error);
                loadingPB.setVisibility(View.GONE);
                Toast.makeText(VolleyUserAddActivity.this, "This Email Already Existed please enter any new email", Toast.LENGTH_SHORT).show();
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

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }


        };
        queue.add(jsonArrayRequest);
    }

    private void AfternewAdd() {
        RequestQueue queue = Volley.newRequestQueue(VolleyUserAddActivity.this);
        String url = "https://gorest.co.in/public/v2/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject responseObj = response.getJSONObject(i);

                                Log.i(TAG, "onResponse: " + response);

                                UserUsingVolleyActivity.volleystring.clear();

                                int id = responseObj.getInt("id");
                                String name = responseObj.getString("name");
                                String email = responseObj.getString("email");
                                String gender = responseObj.getString("gender");
                                String status = responseObj.getString("status");

                                VolleyModalClass EX = new VolleyModalClass(id, name, email, gender, status);
                                UserUsingVolleyActivity.volleystring.add(EX);

                                UserUsingVolleyActivity.uservolleyAdapter = new UserUsingVolleyActivityAdapter(VolleyUserAddActivity.this, UserUsingVolleyActivity.volleystring);
                                UserUsingVolleyActivity.User_recyclerview.setAdapter(UserUsingVolleyActivity.uservolleyAdapter);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

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


        queue.add(jsonArrayRequest);
    }

    private void UpdaetaUser(String name, String email, String gender, String status) {

        RequestQueue queue = Volley.newRequestQueue(VolleyUserAddActivity.this);
        String url = "https://gorest.co.in/public/v2/users/" + position;
        JSONObject params1 = new JSONObject();
        try {
            params1.put("name", name);
            params1.put("email", email);
            params1.put("gender", gender);
            params1.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, params1,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        Log.i(TAG, "onResponse: " + response.toString());
                        Toast.makeText(VolleyUserAddActivity.this, "User Update Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(VolleyUserAddActivity.this, UserUsingVolleyActivity.class);
                        startActivity(intent);
                        finish();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG, "onErrorResponse: " + error);
                Toast.makeText(VolleyUserAddActivity.this, "User was not  Update", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(VolleyUserAddActivity.this, UserUsingVolleyActivity.class);
        startActivity(intent);
        finish();
    }


}
package com.example.urvish.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.Adapters.RetrofitUserAddActivityAdapter;
import com.example.urvish.HelperClasses.UserForRetrofitRepository;
import com.example.urvish.R;
import com.example.urvish.modelClasses.RetrofitModal;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitUserAddActivity extends AppCompatActivity {

    EditText retrofit_name1, retrofit_email1, retrofit_gender1, retrofit_status1;
    AppCompatButton retrofit_ok1;
    private ProgressBar loadingPB;
    TextView retro1;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_user_add);

        retrofit_name1 = findViewById(R.id.retrofit_name1);
        retrofit_email1 = findViewById(R.id.retrofit_email1);
        retrofit_gender1 = findViewById(R.id.retrofit_gender1);
        retrofit_status1 = findViewById(R.id.retrofit_status1);
        retrofit_ok1 = findViewById(R.id.retrofit_ok1);
        loadingPB = findViewById(R.id.loadingPB1);
        retro1 = findViewById(R.id.retro1);

        int iddd = getIntent().getIntExtra("id", 0);
        String name1 = getIntent().getStringExtra("name");
        String email1 = getIntent().getStringExtra("email");
        String gender1 = getIntent().getStringExtra("gender");
        String status1 = getIntent().getStringExtra("status");

        if (iddd != 0) {
            position = iddd;
            retro1.setText("Update User Using  Retrofit");
            retrofit_ok1.setText("Update User");
        }

        if (position != -1) {
            retrofit_name1.setText(name1);
            retrofit_email1.setText(email1);
            retrofit_gender1.setText(gender1);
            retrofit_status1.setText(status1);
        }


        retrofit_ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == -1) {
                    String name = String.valueOf(retrofit_name1.getText());
                    String email = String.valueOf(retrofit_email1.getText());
                    String gender = String.valueOf(retrofit_gender1.getText());
                    String status = String.valueOf(retrofit_status1.getText());

                    if (name.equals("")) {
                        retrofit_name1.setError("Please enter your Name");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.equals("") && UserUsingRetrofitActivity.RetrofitStringg.contains(email)) {
                        retrofit_email1.setError("please enter your Email");
                    } else if (gender.equals("")) {
                        retrofit_gender1.setError("Please enter your Age");
                    } else if (!gender.equals("male") && !gender.equals("female")) {
                        retrofit_gender1.setError("Invalid gender");
                    } else if (status.equals("")) {
                        retrofit_status1.setError("please enter status");
                    } else if (!status.equals("Active") && !status.equals("active") && !status.equals("Inactive") && !status.equals("inactive")) {
                        retrofit_status1.setError("please enter valid status");
                    } else {
                        InsertNewUsers(name, email, gender, status);
                    }
                } else {
                    String name = String.valueOf(retrofit_name1.getText());
                    String email = String.valueOf(retrofit_email1.getText());
                    String gender = String.valueOf(retrofit_gender1.getText());
                    String status = String.valueOf(retrofit_status1.getText());

                    if (name.equals("")) {
                        retrofit_name1.setError("Please enter your Name");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.equals("") && UserUsingRetrofitActivity.RetrofitStringg.contains(email)) {
                        retrofit_email1.setError("please enter your Email");
                    } else if (gender.equals("")) {
                        retrofit_gender1.setError("Please enter your Age");
                    } else if (!gender.equals("male") && !gender.equals("female")) {
                        retrofit_gender1.setError("Invalid gender");
                    } else if (status.equals("")) {
                        retrofit_status1.setError("please enter status");
                    } else if (!status.equals("Active") && !status.equals("active") && !status.equals("Inactive") && !status.equals("inactive")) {
                        retrofit_status1.setError("please enter valid status");
                    } else {
                        UpdaetaUserretrofit(name, email, gender, status);
                    }
                }
            }
        });
    }

    private void UpdaetaUserretrofit(String name, String email, String gender, String status) {
        loadingPB.setVisibility(View.VISIBLE);
        HashMap<String, String> fields = new HashMap<>();
        fields.put("name", name);
        fields.put("email", email);
        fields.put("gender", gender);
        fields.put("status", status);

        int url1 = position;

        UserForRetrofitRepository.callmyapi().UpdateRetrofitUser(url1,fields).enqueue(new Callback<RetrofitModal>() {
            @Override
            public void onResponse(Call<RetrofitModal> call, Response<RetrofitModal> response) {
                if (response.body() != null) {
                    loadingPB.setVisibility(View.GONE);
                    Toast.makeText(RetrofitUserAddActivity.this, "User Update Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RetrofitUserAddActivity.this, UserUsingRetrofitActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    loadingPB.setVisibility(View.GONE);
                    Toast.makeText(RetrofitUserAddActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RetrofitModal> call, Throwable t) {
                loadingPB.setVisibility(View.GONE);
                Toast.makeText(RetrofitUserAddActivity.this, "User Was Not Update", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void InsertNewUsers(String name, String email, String gender, String status) {

        loadingPB.setVisibility(View.VISIBLE);

        HashMap<String, String> fields = new HashMap<>();
        fields.put("name", name);
        fields.put("email", email);
        fields.put("gender", gender);
        fields.put("status", status);

        UserForRetrofitRepository.callmyapi().AddNewRetrofitUser(fields).enqueue(new Callback<RetrofitModal>() {
            @Override
            public void onResponse(Call<RetrofitModal> call, Response<RetrofitModal> response) {
                if (response.body() != null) {
                    Toast.makeText(RetrofitUserAddActivity.this, "User Add Successfully", Toast.LENGTH_SHORT).show();
                    AfternewAdd();
                    Intent intent = new Intent(RetrofitUserAddActivity.this, UserUsingRetrofitActivity.class);
                    startActivity(intent);
                    finish();
                    loadingPB.setVisibility(View.GONE);
                } else {
                    Toast.makeText(RetrofitUserAddActivity.this, "Something Wrong please Try Again", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RetrofitUserAddActivity.this, UserUsingRetrofitActivity.class);
                    startActivity(intent);
                    finish();
                    loadingPB.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<RetrofitModal> call, Throwable t) {
                Toast.makeText(RetrofitUserAddActivity.this, "Response is null Please Try Again", Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
            }
        });


    }

    private void AfternewAdd() {

        UserUsingRetrofitActivity.RetrofitStringg.clear();

        UserForRetrofitRepository.callmyapi().getRetrofitUser().enqueue(new Callback<List<RetrofitModal>>() {
            @Override
            public void onResponse(Call<List<RetrofitModal>> call, Response<List<RetrofitModal>> response) {

                if (response.body() != null) {
                    UserUsingRetrofitActivity.RetrofitStringg = response.body();
                    initAdapter();
                    loadingPB.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<RetrofitModal>> call, Throwable t) {

            }
        });

    }

    private void initAdapter() {
        UserUsingRetrofitActivity.retrofitAdapter = new RetrofitUserAddActivityAdapter(RetrofitUserAddActivity.this, (List<RetrofitModal>) UserUsingRetrofitActivity.RetrofitStringg);
        UserUsingRetrofitActivity.retrofit_recyclerview.setAdapter(UserUsingRetrofitActivity.retrofitAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(RetrofitUserAddActivity.this, UserUsingRetrofitActivity.class);
        startActivity(intent);
        finish();
    }
}
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

import com.example.urvish.Adapters.RetrofitUserAddActivityAdapter;
import com.example.urvish.HelperClasses.UserForRetrofitRepository;
import com.example.urvish.R;
import com.example.urvish.modelClasses.RetrofitModal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserUsingRetrofitActivity extends AppCompatActivity {

    public static RecyclerView retrofit_recyclerview;
    FloatingActionButton retrofit_Add;
    static List<RetrofitModal> RetrofitStringg;
    public static RetrofitUserAddActivityAdapter retrofitAdapter;
    private ProgressBar loadingPB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userusing_retrofit);

        retrofit_recyclerview = findViewById(R.id.retrofit_recyclerview);
        retrofit_Add = findViewById(R.id.retrofit_add);
        loadingPB = findViewById(R.id.loadingPB);

        retrofit_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserUsingRetrofitActivity.this, RetrofitUserAddActivity.class);
                startActivity(intent);
                finish();
                Log.i(TAG, "onClick: " + RetrofitStringg.toString());

            }
        });
        GetRetrofitUser();
    }

    private void GetRetrofitUser() {
        loadingPB.setVisibility(View.VISIBLE);
        UserForRetrofitRepository.callmyapi().getRetrofitUser().enqueue(new Callback<List<RetrofitModal>>() {
            @Override
            public void onResponse(Call<List<RetrofitModal>> call, Response<List<RetrofitModal>> response) {
                if (response.body() != null) {
                    RetrofitStringg = response.body();
                    initAdapter();
                    loadingPB.setVisibility(View.GONE);
                }else{
                    Toast.makeText(UserUsingRetrofitActivity.this, "Response Null", Toast.LENGTH_SHORT).show();
                    loadingPB.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<RetrofitModal>> call, Throwable t) {
                loadingPB.setVisibility(View.GONE);
                Toast.makeText(UserUsingRetrofitActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initAdapter() {
        retrofitAdapter = new RetrofitUserAddActivityAdapter(UserUsingRetrofitActivity.this, (List<RetrofitModal>) RetrofitStringg);
        retrofit_recyclerview.setAdapter(retrofitAdapter);

        retrofitAdapter.setOneeAPIResponse(new RetrofitUserAddActivityAdapter.OneeAPIResponse() {
            @Override
            public void deleteUserretrofit(RetrofitModal ll) {

                Log.i(TAG, "deleteUser: example : " + ll);

                AlertDialog.Builder builder = new AlertDialog.Builder(UserUsingRetrofitActivity.this);
                builder.setMessage("Do you want to Delete " + ll.getName() + " User Information ?")
                        .setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        deleteUserRetrofit1(ll);

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
            public void UserUpadetretrofit(RetrofitModal ll) {

                Intent intent = new Intent(UserUsingRetrofitActivity.this, RetrofitUserAddActivity.class);
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

    private void deleteUserRetrofit1(RetrofitModal ll) {
        loadingPB.setVisibility(View.VISIBLE);

        int url1 = ll.getId();

        UserForRetrofitRepository.callmyapi().DeleteRetrofitUser(url1).enqueue(new Callback<RetrofitModal>() {
            @Override
            public void onResponse(Call<RetrofitModal> call, Response<RetrofitModal> response) {

                if(response.body()!=null)
                {
                    Toast.makeText(UserUsingRetrofitActivity.this, "User Delete Successfully", Toast.LENGTH_SHORT).show();
                    loadingPB.setVisibility(View.GONE);
                }else{
                    Toast.makeText(UserUsingRetrofitActivity.this, "Something Wrong Please Try Again", Toast.LENGTH_SHORT).show();
                    loadingPB.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<RetrofitModal> call, Throwable t) {
                Toast.makeText(UserUsingRetrofitActivity.this, "Response is Null Please Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
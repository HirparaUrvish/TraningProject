package com.example.urvish.Activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Adapters.WocDesignActivityCourseAdapter;
import com.example.urvish.R;
import com.example.urvish.modelClasses.WocCourseModal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

 public class WocDesignActivity extends AppCompatActivity implements WocDesignActivityCourseAdapter.OnImageAndTextUpdateListener {

    private RecyclerView woc_recyclerView;
    private EditText woc_edittext;
    private AppCompatButton woc_send;
    private CheckBox woc_check;
    private ImageButton woc_image;
    private StringBuffer user_checkwoc = new StringBuffer();
    private int setgrvity;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    private WocDesignActivityCourseAdapter adapter;
    private ArrayList<WocCourseModal> courseModalArrayList;
    private Uri resultUri1;
    private String imagesss;
    private int position = -1;
    private ImageView woc_selecte_image;
    private ImageView Woc_image_cancle;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woc2);

        woc_recyclerView = findViewById(R.id.woc_recyclerview11);
        woc_edittext = findViewById(R.id.woc_edittext);
        woc_send = findViewById(R.id.woc_send);
        woc_check = findViewById(R.id.woc_check);
        woc_image = findViewById(R.id.woc_image);
        woc_selecte_image = findViewById(R.id.woc_select_image);
        Woc_image_cancle = findViewById(R.id.Woc_image_cancle);

        woc_edittext.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (getResources().getConfiguration().keyboardHidden == Configuration.KEYBOARDHIDDEN_NO) { // Check if keyboard is not hidden
                    if (position != -1) {
                        woc_recyclerView.scrollToPosition(position);
                    }
                }
            }
        });

        woc_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(WocDesignActivity.this);

            }
        });

        Woc_image_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultUri1 = null;
                woc_selecte_image.setVisibility(View.GONE);
                Woc_image_cancle.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (woc_edittext.getText().toString().isEmpty()) {
                        woc_send.setVisibility(View.GONE);
                    }
                }
            }
        });

        //show save sharedPreference in recyclerview
        loadData();

        //Join adapter to recyclerview
        buildRecyclerView();


        woc_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().equals("")) {
                    woc_send.setVisibility(View.VISIBLE);
                } else {
                    woc_send.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        imagesss = "";
        woc_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == -1) {

                    //check message type sender or receiver
                    if (woc_check.isChecked()) {
                        user_checkwoc.delete(0, user_checkwoc.length());
                        user_checkwoc.append("User");
                        setgrvity = Gravity.RIGHT;
                    } else {
                        user_checkwoc.delete(0, user_checkwoc.length());
                        user_checkwoc.append("Admin");
                        setgrvity = Gravity.LEFT;
                    }

                    //string covert message sender or receiver
                    String sendername = user_checkwoc.toString();

                    //user Message
                    String usermassage = woc_edittext.getText().toString();

                    //message Time
                    Calendar calendar = Calendar.getInstance();
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat mdformat = new SimpleDateFormat("hh:mm aa");
                    String strDate = "" + mdformat.format(calendar.getTime());

                    //message Date
                    long currentTimeInMillis = System.currentTimeMillis();

                    //user send imagess
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                        if (resultUri1 == null || resultUri1.toString().isEmpty()) {
                            imagesss = "";
                        } else {
                            imagesss = resultUri1.toString();
                        }
                    }
                    Log.i(TAG, "onClick: " + imagesss);

                    //create model class
                    courseModalArrayList.add(new WocCourseModal(user_checkwoc.toString(), sendername, usermassage, strDate, imagesss, setgrvity, currentTimeInMillis));
                    adapter.notifyItemInserted(courseModalArrayList.size());
                    adapter.notifyItemChanged(courseModalArrayList.size());
                    resultUri1 = null;
                    woc_edittext.setText("");
                    Woc_image_cancle.setVisibility(View.GONE);
                    woc_selecte_image.setVisibility(View.GONE);
                    woc_send.setVisibility(View.GONE);
                    woc_recyclerView.scrollToPosition(courseModalArrayList.size() - 1);

                    //Save in sharedPreference
                    saveData();
                } else {
                    WocCourseModal cc = courseModalArrayList.get(position);
                    String update_message = woc_edittext.getText().toString();
                    String update_image = "";
                    woc_send.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                        if (resultUri1 == null || resultUri1.toString().isEmpty()) {
                            update_image = cc.getImagesss();
                            cc.setImagesss(update_image);
                        } else {
                            update_image = resultUri1.toString();
                            cc.setImagesss(update_image);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                        if(!update_image.isEmpty())
                        {
                            woc_send.setVisibility(View.VISIBLE);
                        }
                    }
                    cc.setUsermassage(update_message);
                    adapter.notifyItemChanged(position);
                    resultUri1 = null;
                    woc_edittext.setText("");
                    Woc_image_cancle.setVisibility(View.GONE);
                    woc_selecte_image.setVisibility(View.GONE);
                    woc_send.setVisibility(View.GONE);
                    sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(courseModalArrayList);
                    editor.putString("courses", json);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                        editor.apply();
                    }
                    position = -1;
                }
            }
        });
    }

    private void buildRecyclerView() {
        adapter = new WocDesignActivityCourseAdapter(courseModalArrayList, WocDesignActivity.this);
        adapter.setOnImageAndTextUpdateListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setStackFromEnd(true);
        manager.setReverseLayout(false);
        woc_recyclerView.setNestedScrollingEnabled(false);
        woc_recyclerView.setLayoutManager(manager);
        woc_recyclerView.setAdapter(adapter);
    }

    private void saveData() {
        sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(courseModalArrayList);
        editor.putString("courses", json);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            editor.apply();
        }
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("courses",
                null);
        Type type = new TypeToken<ArrayList<WocCourseModal>>() {
        }.getType();
        courseModalArrayList = gson.fromJson(json, type);
        if (courseModalArrayList == null) {
            courseModalArrayList = new ArrayList<>();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                resultUri1 = result.getUri();
                WocDesignActivityCourseAdapter.adpateruri = result.getUri();
                woc_selecte_image.setImageURI(resultUri1);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (resultUri1 != null || resultUri1.toString().isEmpty()) {
                        Woc_image_cancle.setVisibility(View.VISIBLE);
                        woc_selecte_image.setVisibility(View.VISIBLE);
                        woc_selecte_image.setImageURI(resultUri1);
                        woc_send.setVisibility(View.VISIBLE);
                    }
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    @Override
    public void onImageAndTextUpdate(int position, Uri imageUri, String text) {
        this.position = position;
        woc_edittext.setText(text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (imageUri != null && !imageUri.toString().isEmpty()) {
                woc_selecte_image.setVisibility(View.VISIBLE);
                Woc_image_cancle.setVisibility(View.VISIBLE);
                woc_selecte_image.setImageURI(imageUri);
            } else {
                woc_selecte_image.setVisibility(View.GONE);
                Woc_image_cancle.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(WocDesignActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

}

package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.HelperClasses.SQLiteDatabaseHelperClass;
import com.example.urvish.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SQLteUpdateActivity extends AppCompatActivity {

    CircleImageView user_image;
    EditText user_name, user_email, user_age, user_number;
    AppCompatButton user_ok;
    RadioButton user_male,user_female;
    String MobilePattern = "[0-9]{10}";
    Uri resultUri7;
    StringBuffer user_check7=new StringBuffer();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqite_update);

        user_image = findViewById(R.id.user_image1);
        user_name = findViewById(R.id.user_name1);
        user_email = findViewById(R.id.user_email1);
        user_age = findViewById(R.id.user_age1);
        user_number = findViewById(R.id.user_number1);
        user_male = findViewById(R.id.user_male1);
        user_female = findViewById(R.id.user_female1);
        user_ok = findViewById(R.id.user_ok1);

        int id9=getIntent().getIntExtra("id0",0);
        String name9=getIntent().getStringExtra("name0");
        String email9=getIntent().getStringExtra("email0");
        String age9=getIntent().getStringExtra("age0");
        String number9=getIntent().getStringExtra("number0");
        String gender9=getIntent().getStringExtra("gender0");
        String image9=getIntent().getStringExtra("image0");

        user_name.setText(name9);
        user_email.setText(email9);
        user_age.setText(age9);
        user_number.setText(number9);

        if(gender9.equals("male"))
        {
            user_male.setChecked(true);
            user_female.setChecked(false);
        }else
        {
            user_male.setChecked(false);
            user_female.setChecked(true);
        }
        user_image.setImageURI(Uri.parse(image9));

        user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(SQLteUpdateActivity.this);
            }
        });

        user_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name7, email7,age7, number7;
                name7 = String.valueOf(user_name.getText());
                email7 = String.valueOf(user_email.getText());
                age7= String.valueOf(user_age.getText());
                number7 = String.valueOf(user_number.getText());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (user_check7.toString().isEmpty()) {
                        user_check7.append("male");
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if(resultUri7==null || resultUri7.toString().isEmpty())
                    {
                        resultUri7= Uri.parse(image9);
                    }
                }
                String uuuuuu= String.valueOf(resultUri7);
                String chckegender=user_check7.toString();
                if(name7.equals(""))
                {
                    user_name.setError("Please enter your Name");
                }else if(email7.equals(""))
                {
                    user_email.setError("please enter your Email");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email7).matches())
                {
                    user_email.setError("Invalid Email Address");
                }else if(age7.equals(""))
                {
                    user_age.setError("Please enter your Age");
                }else if(number7.equals(""))
                {
                    user_number.setError("please enter your Phone no.");
                }else if(!number7.matches(MobilePattern))
                {
                    user_number.setError("Invalid Phone no.");
                }else if(name7.equals(name9) && email7.equals(email9) && age7.equals(age9) && number7.equals(number9) && chckegender.equals(gender9) && uuuuuu.equals(image9))
                {
                    Toast.makeText(SQLteUpdateActivity.this, "No Update Need", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SQLteUpdateActivity.this, SQLiteDataBaseActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(SQLteUpdateActivity.this, "Data Update successfully", Toast.LENGTH_SHORT).show();
                    SQLiteDatabaseHelperClass dbhelper=new SQLiteDatabaseHelperClass(SQLteUpdateActivity.this);
                    dbhelper.Updatedata(name7,email7,age7,number7, String.valueOf(resultUri7),chckegender,id9);
                    Intent intent=new Intent(SQLteUpdateActivity.this, SQLiteDataBaseActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                resultUri7 = result.getUri();
                user_image.setImageURI(resultUri7);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    public void Ongender1(View view) {

        switch (view.getId()) {

            case R.id.user_male1:

                user_female.setChecked(false);
                if (user_male.isChecked()) {
                    user_check7.delete(0, user_check7.length());
                    user_check7.append("male");

                }
                break;

            case R.id.user_female1:

                user_male.setChecked(false);
                if (user_female.isChecked()) {
                    user_check7.delete(0, user_check7.length());
                    user_check7.append("female");

                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Data not Update")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(SQLteUpdateActivity.this, SQLiteDataBaseActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}
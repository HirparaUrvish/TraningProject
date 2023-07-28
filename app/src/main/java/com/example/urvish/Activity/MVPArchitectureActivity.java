package com.example.urvish.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.HelperClasses.MVPArchitecturePresenter;
import com.example.urvish.InterfaceClasses.MVPArchitectureContract;
import com.example.urvish.R;

public class MVPArchitectureActivity extends AppCompatActivity implements MVPArchitectureContract.View {

    EditText email_mvp, password_mvp;
    AppCompatButton submit_mvp;
    MVPArchitecturePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);

        email_mvp = findViewById(R.id.email_mvp);
        password_mvp = findViewById(R.id.password_mvp);
        submit_mvp = findViewById(R.id.submit_mvp);

        presenter = new MVPArchitecturePresenter(this);

        submit_mvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email_mvp.getText().toString();
                String password = password_mvp.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    OnError("Enter a Details");
                } else {
                    presenter.dologin(email, password);
                    email_mvp.setText("");
                    password_mvp.setText("");
                }

            }
        });

    }

    @Override
    public void Onsuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
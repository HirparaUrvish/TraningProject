package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetActivity extends AppCompatActivity {

    AppCompatButton customsheet,daynamicsheet;
    private BottomSheetBehavior mBottomSheetBehavior1;
    LinearLayout bottomSheet;
    ImageView note_Sheet, bluetooth_sheet, mail_sheet, share_sheet, copy_sheet, delete_sheet,arrow_home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomsheet);

        customsheet=findViewById(R.id.custom_sheet);
        daynamicsheet=findViewById(R.id.dynamic_sheet);
        bottomSheet=findViewById(R.id.modalBottomSheetContainer);
        note_Sheet =findViewById(R.id.note_sheet);
        bluetooth_sheet =findViewById(R.id.bluetooth_sheet);
        mail_sheet =findViewById(R.id.mail_sheet);
        share_sheet =findViewById(R.id.share_sheet);
        copy_sheet =findViewById(R.id.copy_sheet);
        delete_sheet =findViewById(R.id.delete_sheet);
        arrow_home=findViewById(R.id.arrow_home);

        arrow_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(BottomSheetActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior1.setHideable(true);
        mBottomSheetBehavior1.setPeekHeight(120);
        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_HIDDEN);


        customsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(mBottomSheetBehavior1.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    customsheet.setText("Hide Sheet");
                }
                else if(mBottomSheetBehavior1.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_HIDDEN);
                    customsheet.setText("Expanded sheet");
                }
                else if(mBottomSheetBehavior1.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
                    customsheet.setText("Collapsed sheet");

                    note_Sheet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BottomSheetActivity.this, "Note", Toast.LENGTH_SHORT).show();

                        }
                    });
                    bluetooth_sheet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BottomSheetActivity.this, "Bluetooth", Toast.LENGTH_SHORT).show();

                        }
                    });
                    mail_sheet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BottomSheetActivity.this, "Mail", Toast.LENGTH_SHORT).show();

                        }
                    });
                    share_sheet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BottomSheetActivity.this, "Share", Toast.LENGTH_SHORT).show();

                        }
                    });
                    copy_sheet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BottomSheetActivity.this, "Copy", Toast.LENGTH_SHORT).show();

                        }
                    });
                    delete_sheet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BottomSheetActivity.this, "Delete", Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }
        });

        daynamicsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showBottomSheetDialog();

            }
        });

    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);

        ImageView note_sheet = bottomSheetDialog.findViewById(R.id.note_sheett);
        ImageView bluetooth_sheet = bottomSheetDialog.findViewById(R.id.bluetooth_sheett);
        ImageView mail_sheet = bottomSheetDialog.findViewById(R.id.mail_sheett);
        ImageView share_sheet = bottomSheetDialog.findViewById(R.id.share_sheett);
        ImageView copy_sheet = bottomSheetDialog.findViewById(R.id.copy_sheett);
        ImageView delete_sheet = bottomSheetDialog.findViewById(R.id.delete_sheett);

        bottomSheetDialog.setCanceledOnTouchOutside(false);

        note_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BottomSheetActivity.this, "Note", Toast.LENGTH_SHORT).show();

            }
        });

        bluetooth_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BottomSheetActivity.this, "Bluetooth", Toast.LENGTH_SHORT).show();

            }
        });

        mail_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BottomSheetActivity.this, "Mail", Toast.LENGTH_SHORT).show();

            }
        });

        share_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BottomSheetActivity.this, "Share", Toast.LENGTH_SHORT).show();

            }
        });

        copy_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BottomSheetActivity.this, "Copy", Toast.LENGTH_SHORT).show();

            }
        });

        delete_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BottomSheetActivity.this, "Delete", Toast.LENGTH_SHORT).show();

            }
        });

        bottomSheetDialog.show();
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(BottomSheetActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}
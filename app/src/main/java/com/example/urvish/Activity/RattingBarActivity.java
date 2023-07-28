package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.R;
import com.hsalf.smilerating.SmileRating;

public class RattingBarActivity extends AppCompatActivity {

    RatingBar ratingBar1, ratingBar2, ratingBar3;
    SmileRating smiley_rating;
    TextView rate1, rate2, rate3, rate4;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratting_bar);

        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);
        smiley_rating=(SmileRating)findViewById(R.id.smiley_rating);
        rate1 = findViewById(R.id.rate1);
        rate2 = findViewById(R.id.rate2);
        rate3 = findViewById(R.id.rate3);
        rate4 = findViewById(R.id.rate4);

        rate1.setText("Rate:");
        rate2.setText("Rate:");
        rate3.setText("Rate:");
        rate4.setText("Rate:");

        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                String ss= String.valueOf(ratingBar1.getRating());
                rate1.setText("Rate:"+ss);

            }
        });

        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                String ss= String.valueOf(ratingBar2.getRating());
                rate2.setText("Rate:"+ss);

            }
        });

        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                String ss= String.valueOf(ratingBar3.getRating());
                rate3.setText("Rate:"+ss);

            }
        });


        smiley_rating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {

                switch (smiley) {
                    case SmileRating.BAD:
                        rate4.setText("Rate:Bad");
                        break;
                    case SmileRating.GOOD:
                        rate4.setText("Rate:Good");
                        break;
                    case SmileRating.GREAT:
                        rate4.setText("Rate:Great");
                        break;
                    case SmileRating.OKAY:
                        rate4.setText("Rate:Okay");
                        break;
                    case SmileRating.TERRIBLE:
                        rate4.setText("Rate:Ter");
                        break;
                    case SmileRating.NONE:
                        rate4.setText("Rate:None");
                        break;
                }

                }
            });


        }
    }
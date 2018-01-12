package com.example.ajsor.aaronsstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Rating;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Shared Preferneces
        SharedPreferences prefs = getSharedPreferences("MAIN_PREFS_FILE", MODE_PRIVATE);
        boolean FirstVisit = prefs.getBoolean("firstVisit", true);
        SharedPreferences RatingBarsFun = getSharedPreferences("Ratings", MODE_PRIVATE);

            //First Object
            Button cmdInfo1 = findViewById(R.id.btnFirstInfo);
            Button cmdPurchase1 = findViewById(R.id.btnFirstPurchase);
            //TextView Link
            TextView lblInfo1 = findViewById(R.id.txtFirstView);
            //Rating Bar1
            final RatingBar R1 = findViewById(R.id.RATE1);
            float setbar1 = RatingBarsFun.getFloat("RatingBar1", 0f);
            R1.setRating(setbar1);
            R1.setEnabled(false);

            //Second Object
            Button cmdInfo2 = findViewById(R.id.btnSecondInfo);
            Button cmdPurchase2 = findViewById(R.id.btnSecondPurchase);
            //Text view Link
            TextView lblInfo2 = findViewById(R.id.txtSecondView);
            //Rating Bar2
            final RatingBar R2 = findViewById(R.id.RATE2);
            float setbar2 = RatingBarsFun.getFloat("RatingBar2", 0f);
            R2.setRating(setbar2);
            R2.setEnabled(false);

        if (FirstVisit){
            Boolean Answer = VersChecker();
            if (Answer == false){
                Toast.makeText(this, "This devie is upto date", Toast.LENGTH_LONG).show();
                prefs.edit().putBoolean("firstVisit", false).commit();
            }
            else {
                cmdInfo1.setVisibility(View.GONE);
                cmdInfo2.setVisibility(View.GONE);
                cmdPurchase1.setVisibility(View.GONE);
                cmdPurchase2.setVisibility(View.GONE);
                lblInfo1.setVisibility(View.GONE);
                lblInfo2.setVisibility(View.GONE);
                Toast.makeText(this, "Your Device is Out of Date, Try Updating!", Toast.LENGTH_LONG).show();
            }
        }
        else{

        }

            //Gather Bundle
            //Bundle RatingBundle = getIntent().getExtras();
            //final Float Rating1 = RatingBundle.getFloat("RatingBar1");
            //final Float Rating2 = RatingBundle.getFloat("RatingBar2");

            //Link Button Pages
            cmdInfo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Push Bundle Go to Next Page
                    startActivity(new Intent(Main.this, InfoRating1.class));
                    //Intent Stars = new Intent();
                  //  Stars.putExtra("Star1", Rating1);
                  //  Stars.putExtra("Star2", Rating2);

                }
            });
            cmdInfo2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Push bundle go to next page
                    startActivity(new Intent(Main.this, InfoRating2.class));
                    //Intent Stars = new Intent();
                   // Stars.putExtra("Star1", Rating1);
                   // Stars.putExtra("Star2", Rating2);
                }
            });


    }


    //Check if above kitkat, if true then do nothing otherwise
    private boolean VersChecker() {
        Boolean VCheck;

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            VCheck = true;
        } else {
            VCheck = false;
        }
        return VCheck;
    }

}

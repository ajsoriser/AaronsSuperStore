package com.example.ajsor.aaronsstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class InfoRating1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rating1);

        SharedPreferences prefs = getSharedPreferences("Ratings", MODE_PRIVATE);
          Button cmdBack = findViewById(R.id.btnBack);
          final RatingBar PrettyStars1 = findViewById(R.id.StarPower1);
          Float RevertBar = prefs.getFloat("RatingBar1", 0);
          PrettyStars1.setRating(RevertBar);
        final SharedPreferences.Editor RateEdit = prefs.edit();
//        Bundle Ratings = getIntent().getExtras();
//        final Float Rating1 = Ratings.getFloat("Star1");
//        PrettyStars1.setRating(Rating1);
//        final Float Rating2 = Ratings.getFloat("Star2");

        cmdBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateEdit.putFloat("RatingBar1", PrettyStars1.getRating());
                final Float numstars = PrettyStars1.getRating();
                Log.d("myDisplay", Float.toString(numstars));
                RateEdit.apply();
                startActivity(new Intent(InfoRating1.this, Main.class));
//                Intent SendData1 = new Intent();
//                SendData1.putExtra("RatingBar1", PrettyStars1.getRating());
//                SendData1.putExtra("RatingBar2", Rating2);
            }
        });
    }
}

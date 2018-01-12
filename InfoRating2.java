package com.example.ajsor.aaronsstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class InfoRating2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rating2);

        SharedPreferences prefs = getSharedPreferences("Ratings", MODE_PRIVATE);
        Button cmdBack = findViewById(R.id.btnBacky);
        final RatingBar PrettyStars2 = findViewById(R.id.StarPower2);
        Float RevertBar = prefs.getFloat("RatingBar2", 0);
        PrettyStars2.setRating(RevertBar);
        final SharedPreferences.Editor RateEdit = prefs.edit();
//        Bundle Ratings = getIntent().getExtras();
//        final Float Rating1 = Ratings.getFloat("Star1");
//        final Float Rating2 = Ratings.getFloat("Star2");
//        PrettyStars2.setRating(Rating2);

        cmdBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateEdit.putFloat("RatingBar2", PrettyStars2.getRating());
                final Float numstars = PrettyStars2.getRating();
                Log.d("myDisplay", Float.toString(numstars));
                RateEdit.apply();
                startActivity(new Intent(InfoRating2.this, Main.class));
//                Intent SendData2 = new Intent();
//                SendData2.putExtra("RatingBar2", PrettyStars2.getRating());
//                SendData2.putExtra("RatingBar1", Rating2);

            }
        });
    }
}

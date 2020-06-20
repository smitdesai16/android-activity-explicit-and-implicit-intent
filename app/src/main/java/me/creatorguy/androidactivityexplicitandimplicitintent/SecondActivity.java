package me.creatorguy.androidactivityexplicitandimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static TextView tvSecondBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvSecondBanner = findViewById(R.id.tvSecondBanner);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(intent.hasExtra("data")) {
            tvSecondBanner.setText(bundle.getString("data"));
        }
    }
}
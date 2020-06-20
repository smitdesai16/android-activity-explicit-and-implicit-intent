package me.creatorguy.androidactivityexplicitandimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvSecondBanner = findViewById(R.id.tvSecondBanner);
        Button btnSecondClose = findViewById(R.id.btnSecondClose);

        btnSecondClose.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(intent.hasExtra("data")) {
            tvSecondBanner.setText(bundle.getString("data"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSecondClose:
                finish();
                break;

            default:
                break;
        }
    }
}
package me.creatorguy.androidactivityexplicitandimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static Button btnMainExplicitIntent, btnMainExplicitIntentBundle, btnMainExplicitIntentExtra, btnMainImplicitIntent, btnMainImplicitIntentBundle, btnMainImplicitIntentExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMainExplicitIntent = findViewById(R.id.btnMainExplicitIntent);
        btnMainExplicitIntentBundle = findViewById(R.id.btnMainExplicitIntentBundle);
        btnMainExplicitIntentExtra = findViewById(R.id.btnMainExplicitIntentExtra);
        btnMainImplicitIntent = findViewById(R.id.btnMainImplicitIntent);
        btnMainImplicitIntentBundle = findViewById(R.id.btnMainImplicitIntentBundle);
        btnMainImplicitIntentExtra = findViewById(R.id.btnMainImplicitIntentExtra);


        btnMainExplicitIntent.setOnClickListener(this);
        btnMainExplicitIntentBundle.setOnClickListener(this);
        btnMainExplicitIntentExtra.setOnClickListener(this);
        btnMainImplicitIntent.setOnClickListener(this);
        btnMainImplicitIntentBundle.setOnClickListener(this);
        btnMainImplicitIntentExtra.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMainExplicitIntent:
                Intent explicitIntent = new Intent(this, SecondActivity.class);
                startActivity(explicitIntent);
                break;

            case R.id.btnMainExplicitIntentBundle:
                Intent explicitIntentBundle = new Intent(this, SecondActivity.class);
                Bundle explicitBundle = new Bundle();
                explicitBundle.putString("data", "btnMainExplicitIntentBundle");
                explicitIntentBundle.putExtras(explicitBundle);
                startActivity(explicitIntentBundle);
                break;

            case R.id.btnMainExplicitIntentExtra:
                Intent explicitIntentExtra = new Intent(this, SecondActivity.class);
                explicitIntentExtra.putExtra("data", "btnMainExplicitIntentExtra");
                startActivity(explicitIntentExtra);
                break;

            case R.id.btnMainImplicitIntent:
                break;

            case R.id.btnMainImplicitIntentBundle:
                break;

            case R.id.btnMainImplicitIntentExtra:
                break;

            default:
                break;
        }
    }
}
package me.creatorguy.androidactivityexplicitandimplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_GALLERY = 1000;
    private ImageView ivMain;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMain = findViewById(R.id.ivMain);

        Button btnMainExplicitIntent = findViewById(R.id.btnMainExplicitIntent);
        Button btnMainExplicitIntentBundle = findViewById(R.id.btnMainExplicitIntentBundle);
        Button btnMainExplicitIntentExtra = findViewById(R.id.btnMainExplicitIntentExtra);
        Button btnMainImplicitIntentLink = findViewById(R.id.btnMainImplicitIntentLink);
        Button btnMainImplicitIntentMapLink = findViewById(R.id.btnMainImplicitIntentMapLink);
        Button btnMainImplicitIntentMapGeo = findViewById(R.id.btnMainImplicitIntentMapGeo);
        Button btnMainImplicitIntentDialANumber = findViewById(R.id.btnMainImplicitIntentDialANumber);
        Button btnMainImplicitIntentPickImage = findViewById(R.id.btnMainImplicitIntentPickImage);
        Button btnMainImplicitIntentSendText = findViewById(R.id.btnMainImplicitIntentSendText);
        Button btnMainImplicitIntentSendImage = findViewById(R.id.btnMainImplicitIntentSendImage);
        Button btnMainImplicitIntentSendEmail = findViewById(R.id.btnMainImplicitIntentSendEmail);

        btnMainExplicitIntent.setOnClickListener(this);
        btnMainExplicitIntentBundle.setOnClickListener(this);
        btnMainExplicitIntentExtra.setOnClickListener(this);
        btnMainImplicitIntentLink.setOnClickListener(this);
        btnMainImplicitIntentMapLink.setOnClickListener(this);
        btnMainImplicitIntentMapGeo.setOnClickListener(this);
        btnMainImplicitIntentDialANumber.setOnClickListener(this);
        btnMainImplicitIntentPickImage.setOnClickListener(this);
        btnMainImplicitIntentSendText.setOnClickListener(this);
        btnMainImplicitIntentSendImage.setOnClickListener(this);
        btnMainImplicitIntentSendEmail.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == Activity.RESULT_OK) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ivMain.setImageBitmap(bitmap);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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

            case R.id.btnMainImplicitIntentLink:
                Uri githubProfileUri = Uri.parse("https://github.com/smitdesai16");
                Intent implicitIntentLink = new Intent(Intent.ACTION_VIEW, githubProfileUri);
                startActivity(implicitIntentLink);
                break;

            case R.id.btnMainImplicitIntentMapLink:
                Uri googleMapUri = Uri.parse("https://maps.google.com/maps?q=37.422,-122.084");
                Intent implicitIntentMapLink = new Intent(Intent.ACTION_VIEW, googleMapUri);
                startActivity(implicitIntentMapLink);
                break;

            case R.id.btnMainImplicitIntentMapGeo:
                Uri googleMapGeo = Uri.parse("geo:37.422,-122.084");
                Intent implicitIntentMapGeo = new Intent(Intent.ACTION_VIEW, googleMapGeo);
                startActivity(implicitIntentMapGeo);
                break;

            case R.id.btnMainImplicitIntentDialANumber:
                Uri numberToDial = Uri.parse("tel:5555555555");
                Intent implicitIntentDialANumber = new Intent(Intent.ACTION_VIEW, numberToDial);
                startActivity(implicitIntentDialANumber);
                break;

            case R.id.btnMainImplicitIntentPickImage:
                Intent implicitIntentPickImage = new Intent();
                implicitIntentPickImage.setAction(Intent.ACTION_GET_CONTENT);
                implicitIntentPickImage.setType("image/*");
                implicitIntentPickImage.putExtra("return-data", true);
                startActivityForResult(implicitIntentPickImage, REQUEST_CODE_GALLERY);
                break;

            case R.id.btnMainImplicitIntentSendText:
                Intent implicitIntentSendText = new Intent(Intent.ACTION_SEND);
                implicitIntentSendText.putExtra(Intent.EXTRA_TEXT, "Greetings from smit desai");
                implicitIntentSendText.setType("text/*");
                startActivity(implicitIntentSendText);
                break;

            case R.id.btnMainImplicitIntentSendImage:
                if(imageUri == null) {
                    Toast.makeText(this, "No image picked", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent implicitIntentSendImage = new Intent(Intent.ACTION_SEND);
                implicitIntentSendImage.putExtra(Intent.EXTRA_STREAM, imageUri);
                implicitIntentSendImage.setType(getContentResolver().getType(imageUri));
                startActivity(implicitIntentSendImage);
                break;

            case R.id.btnMainImplicitIntentSendEmail:
                Intent implicitIntentSendEmail = new Intent(Intent.ACTION_SEND);
                implicitIntentSendEmail.setType("message/rfc822");
                implicitIntentSendEmail.putExtra(Intent.EXTRA_EMAIL, new  String[] { "recipient@example.com" });
                implicitIntentSendEmail.putExtra(Intent.EXTRA_SUBJECT, "My Subject");
                implicitIntentSendEmail.putExtra(Intent.EXTRA_TEXT, "Email Content");

                /*
                if(implicitIntentSendEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(implicitIntentSendEmail);
                } else {
                    Toast.makeText(this, "No email application found", Toast.LENGTH_SHORT).show();
                }
                */

                startActivity(Intent.createChooser(implicitIntentSendEmail, "Send To"));
                break;

            default:
                break;
        }
    }
}
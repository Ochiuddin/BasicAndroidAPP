package com.example.assignment2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Full Name: Md Ochiuddin Miah\nStudent ID: 1424016");

        Button explicitButton = findViewById(R.id.button_explicit);
        Button implicitButton = findViewById(R.id.button_implicit);
        Button viewImageActivityButton = findViewById(R.id.button_view_image_activity);

        explicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, "com.example.assignment2.MSE412") == PackageManager.PERMISSION_GRANTED) {
                    Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(explicitIntent);
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{"com.example.assignment2.MSE412"}, REQUEST_PERMISSION_CODE);
                }
            }
        });

        implicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicitIntent = new Intent("com.example.assignment2.OPEN_SECOND_ACTIVITY");
                startActivity(implicitIntent);
            }
        });

        viewImageActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }


}

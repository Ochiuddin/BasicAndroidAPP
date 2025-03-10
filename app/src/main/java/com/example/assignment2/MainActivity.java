package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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
                Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(explicitIntent);
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

package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textViewChallenges);
        textView.setText("Mobile Software Engineering Challenges:\n" +
                "1. Battery Life Optimization\n" +
                "2. Screen Size Variability\n" +
                "3. Security and Privacy\n" +
                "4. Network Connectivity Issues\n" +
                "5. Performance Optimization");

        Button mainButton = findViewById(R.id.button_main);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}

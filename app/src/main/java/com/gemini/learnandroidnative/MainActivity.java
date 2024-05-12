package com.gemini.learnandroidnative;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = findViewById(R.id.btnClick);
        Button btnYoutube = findViewById(R.id.btnYoutube);

        btnClick.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MessageActivity.class);
            startActivity(intent);
        });

        btnYoutube.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/"));
            startActivity(intent);
        });
    }
}
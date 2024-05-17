package com.gemini.learnandroidnative;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Button btnClick = findViewById(R.id.btn_close);

        Intent intent = getIntent();
        String value = intent.getStringExtra("KeyOne");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();

        btnClick.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("ReturnKeyOne", "This is return value one");
        intent.putExtra("ReturnKeyTwo", "This is the second return value");
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
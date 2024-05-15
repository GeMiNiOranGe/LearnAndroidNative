package com.gemini.learnandroidnative;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = findViewById(R.id.btn_click);
        Button btnYoutube = findViewById(R.id.btn_youtube);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        handleData(data);
                    }
                }
        );

        btnClick.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MessageActivity.class);

            intent.putExtra("KeyOne", "Send value one");
            intent.putExtra("KeyTwo", "Send the second value");

            launcher.launch(intent);
        });

        btnYoutube.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/"));
            startActivity(intent);
        });
    }

    private void handleData(Intent data) {
        if (data == null) {
            return;
        }

        String value = data.getStringExtra("ReturnKeyOne");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }
}
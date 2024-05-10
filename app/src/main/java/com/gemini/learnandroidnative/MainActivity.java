package com.gemini.learnandroidnative;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String message = savedInstanceState == null ? "This is a bug." : "Welcome to this repo.";
        Log.e(TAG, message);

        setContentView(R.layout.activity_main);
    }
}
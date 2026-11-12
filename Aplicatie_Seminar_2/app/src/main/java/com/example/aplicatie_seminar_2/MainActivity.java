package com.example.aplicatie_seminar_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicluViata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cerința 3: Log.v() în onCreate
        Log.v(TAG, "onCreate() a fost apelată - Verbose Log");

        Button btnOpenSecond = findViewById(R.id.btnOpenSecond);
        Button btnOpenThird = findViewById(R.id.btnOpenThird);

        // Cerința 6: Lansarea celei de-a doua activități cu mesaj prin Intent
        btnOpenSecond.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("MESAJ_CHEIE", "Salut! Acesta este mesajul trimis din MainActivity.");
            startActivity(intent);
        });

        // Lansarea celei de-a treia activități (Cerința 7)
        btnOpenThird.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }

    // Cerințele 2 și 3: Metodele ciclului de viață + Log-uri diferite
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() a fost apelată - Info Log");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() a fost apelată - Debug Log");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause() a fost apelată - Warning Log");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop() a fost apelată - Error Log");
    }
}
package com.example.aplicatie_seminar_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvMesaj = findViewById(R.id.tvMesajPrimit);
        Button button = findViewById(R.id.back_button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Preluarea mesajului din Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("MESAJ_CHEIE")) {
            String mesaj = intent.getStringExtra("MESAJ_CHEIE");
            tvMesaj.setText(mesaj);
        }

    }
}
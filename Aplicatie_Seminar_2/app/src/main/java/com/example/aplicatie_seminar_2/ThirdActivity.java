package com.example.aplicatie_seminar_2; // Același pachet ca în SecondActivity!

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        EditText etMesaj = findViewById(R.id.etMesaj);
        Button btnInchide = findViewById(R.id.btnInchide);

        btnInchide.setOnClickListener(v -> {
            String mesajIntrodus = etMesaj.getText().toString().trim();

            if (mesajIntrodus.isEmpty()) {
                mesajIntrodus = "Nu ați introdus niciun mesaj!";
            }

            // 1. Afișarea mesajului în Toast
            Toast.makeText(getApplicationContext(), "Mesaj: " + mesajIntrodus, Toast.LENGTH_LONG).show();

            // 2. Trimiterea mesajului către SecondActivity folosind cheia "MESAJ_CHEIE"
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            intent.putExtra("MESAJ_CHEIE", mesajIntrodus);
            startActivity(intent);

            finish();
        });
    }
}

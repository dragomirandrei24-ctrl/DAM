package com.example.aplicatie_seminar_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvAfisareDrona;

    // Mecanismul de întoarcere a rezultatului din a doua activitate (Cerințele 4 și 5)
    private final ActivityResultLauncher<Intent> adaugaDronaLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Drona dronaPrimita = result.getData().getParcelableExtra("CHEIE_DRONA");
                            if (dronaPrimita != null) {
                                // Afișăm obiectul în TextView (apelează Drona.toString())
                                tvAfisareDrona.setText(dronaPrimita.toString());
                            }
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAfisareDrona = findViewById(R.id.tvAfisareDrona);
        Button btnAdaugaObiect = findViewById(R.id.btnAdaugaObiect);

        // Cerința 3: Deschiderea activității de colectare a datelor
        btnAdaugaObiect.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdaugaDronaActivity.class);
            adaugaDronaLauncher.launch(intent);
        });
    }
}
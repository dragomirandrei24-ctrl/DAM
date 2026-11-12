package com.example.aplicatie_seminar_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referințe către elementele din XML
        EditText etInput = findViewById(R.id.etInput);
        Switch swConfirmare = findViewById(R.id.swConfirmare);
        Button btnAction = findViewById(R.id.btnAction);
        TextView tvOutput = findViewById(R.id.tvOutput);

        // Cerința 5: Setăm inițial butonul ca fiind dezactivat
        btnAction.setEnabled(false);

        // Cerința 5: Activăm/dezactivăm butonul dinamic în funcție de starea Switch-ului
        swConfirmare.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btnAction.setEnabled(isChecked);
        });

        // Cerințele 6, 7 și 8: Tratarea evenimentului de apăsare a butonului
        btnAction.setOnClickListener(v -> {
            String textIntrodus = etInput.getText().toString().trim();

            // Cerința 6: Verificăm dacă EditText-ul nu este gol
            if (!textIntrodus.isEmpty()) {
                // Cerința 7: Schimbăm textul din TextView și afișăm un Toast scurt
                tvOutput.setText(textIntrodus);
                Toast.makeText(
                        MainActivity.this,
                        getString(R.string.toast_confirmare),
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                // Cerința 8: Dacă este gol, setăm o eroare direct pe EditText
                etInput.setError(getString(R.string.eroare_camp_gol));
                etInput.requestFocus();
            }
        });
    }
}
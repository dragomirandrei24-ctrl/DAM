package com.example.aplicatie_seminar_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AdaugaDronaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_drona);

        EditText etModel = findViewById(R.id.etModel);
        EditText etAutonomie = findViewById(R.id.etAutonomie);
        Switch swCamera4K = findViewById(R.id.swCamera4K);
        RadioGroup rgControl = findViewById(R.id.rgControl);
        Spinner spCategorie = findViewById(R.id.spCategorie);
        RatingBar rbPerformanta = findViewById(R.id.rbPerformanta);
        CheckBox cbGPS = findViewById(R.id.cbGPS);
        CheckBox cbSenzori = findViewById(R.id.cbSenzori);
        CheckBox cbFollowMe = findViewById(R.id.cbFollowMe);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        // Popularea Spinner-ului cu valorile din enum-ul CategorieDrona
        ArrayAdapter<Drona.CategorieDrona> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Drona.CategorieDrona.values()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategorie.setAdapter(adapter);

        // Cerința 4: Crearea obiectului Parcelable și trimiterea înapoi în MainActivity
        btnSalveaza.setOnClickListener(v -> {
            String model = etModel.getText().toString().trim();
            String autonomieStr = etAutonomie.getText().toString().trim();

            if (model.isEmpty() || autonomieStr.isEmpty()) {
                Toast.makeText(this, "Completați modelul și autonomia!", Toast.LENGTH_SHORT).show();
                return;
            }

            int autonomie = Integer.parseInt(autonomieStr);
            boolean areCamera4K = swCamera4K.isChecked();

            // Preluare text din RadioButton-ul selectat
            int selectedRadioId = rgControl.getCheckedRadioButtonId();
            RadioButton rbSelectat = findViewById(selectedRadioId);
            String tipControl = rbSelectat != null ? rbSelectat.getText().toString() : "Necunoscut";

            // Preluare enum din Spinner
            Drona.CategorieDrona categorie = (Drona.CategorieDrona) spCategorie.getSelectedItem();

            // Preluare valoare din RatingBar
            float rating = rbPerformanta.getRating();

            // Preluare opțiuni bifate din CheckBox-uri într-un String[]
            List<String> optiuniList = new ArrayList<>();
            if (cbGPS.isChecked()) optiuniList.add(cbGPS.getText().toString());
            if (cbSenzori.isChecked()) optiuniList.add(cbSenzori.getText().toString());
            if (cbFollowMe.isChecked()) optiuniList.add(cbFollowMe.getText().toString());
            String[] optiuniExtra = optiuniList.toArray(new String[0]);

            // Instanțierea obiectului Drona
            Drona dronaNoua = new Drona(
                    model, autonomie, areCamera4K, tipControl,
                    categorie, rating, optiuniExtra
            );

            // Returnarea obiectului Parcelable către MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("CHEIE_DRONA", dronaNoua);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
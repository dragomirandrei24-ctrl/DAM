package com.example.practia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddCascaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_casca);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button);
        EditText EDmodel = findViewById(R.id.EDmodel);
        EditText EDautonomie = findViewById(R.id.EDautonomie);
        Spinner SPtipCasca = findViewById(R.id.SPtipCasca);
        CheckBox checkBox = findViewById(R.id.checkBox);

        ArrayAdapter<TipCasca> adapterSpinner = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TipCasca.values()
        );
        // OBLIGATORIU: atașăm adaptorul la Spinner
        SPtipCasca.setAdapter(adapterSpinner);

        button.setOnClickListener(view -> {
            String model = EDmodel.getText().toString();
            int autonomie = Integer.parseInt(EDautonomie.getText().toString());
            TipCasca tipCasca = (TipCasca) SPtipCasca.getSelectedItem();
            boolean noiseCancelling = checkBox.isChecked();

            Casca casca = new Casca(model, autonomie, tipCasca, noiseCancelling);
            Intent intent = new Intent();
            intent.putExtra("casca", casca);
            setResult(RESULT_OK, intent);
            Toast.makeText(this, "Casca adaugata cu succes!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_adauga_casca) {
            Intent intent = new Intent(this, AddCascaActivity.class);
            startActivityForResult(intent, 0);
            return true;
        }
        else if (item.getItemId() == R.id.menu_principal) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
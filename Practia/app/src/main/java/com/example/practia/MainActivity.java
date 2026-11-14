package com.example.practia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Lista rămâne în MainActivity ca să nu se șteargă când schimbi paginile
    private ArrayList<Casca> listaCasti = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
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
        else if (item.getItemId() == R.id.menu_lista_casi) {
            Intent intent = new Intent(this, ListaCastiActivity.class);
            // Trimitem toată lista de căști adunate până acum către ListaCastiActivity
            intent.putParcelableArrayListExtra("lista", listaCasti);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Aici ajunge casca trimisă din AddCascaActivity (varianta cu 3 parametri!)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK && data != null) {
            Casca casca = data.getParcelableExtra("casca");
            if (casca != null) {
                listaCasti.add(casca);
            }
        }
    }
}
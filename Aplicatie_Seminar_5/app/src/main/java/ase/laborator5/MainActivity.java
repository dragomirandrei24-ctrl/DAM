package ase.laborator5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int ADD_COMPUTER_CODE = 5;
    private ListView listView;
    private List<Computer> listaObiecte;
    private ComputerListAdaptor adaptor;

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
        listaObiecte = new ArrayList<>();

        listView = findViewById(R.id.listView);

        adaptor = new ComputerListAdaptor(this, listaObiecte);

        listView.setAdapter(adaptor);

        Button addComputerButton = findViewById(R.id.addComputerButton);

        addComputerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddComputerActivity.class);
            startActivityForResult(intent, ADD_COMPUTER_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_COMPUTER_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                Computer computer = data.getParcelableExtra("computer");
                if (computer != null) {
                    listaObiecte.add(computer);
                    Log.e("MainActivity", computer.toString());
                    adaptor.notifyDataSetChanged();
                }
            }
        }
    }
}
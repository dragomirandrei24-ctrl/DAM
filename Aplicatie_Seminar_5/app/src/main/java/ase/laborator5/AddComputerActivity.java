package ase.laborator5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddComputerActivity extends AppCompatActivity {

    private EditText ramEditText;
    private EditText storageEditText;
    private EditText manufactureEditText;
    private EditText purchaceDateEditText;
    private CheckBox touchscreenCheckBox;
    private CalendarView purchaceDateCalendarView;

    private CheckBox cbTastaturaIluminata;
    private CheckBox cbWebcam;
    private CheckBox cbMouseWireless;
    private CheckBox cbMonitor;

    private Button addComputerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_computer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ramEditText = findViewById(R.id.ramEditText_AddComputer);
        storageEditText = findViewById(R.id.storageEditText_AddComputer);
        manufactureEditText = findViewById(R.id.manufactureEditText_AddComputer);
        purchaceDateEditText = findViewById(R.id.purchaceDateEditText_AddComputer);
        touchscreenCheckBox = findViewById(R.id.touchscreenCheckBox_AddComputer);
        purchaceDateCalendarView = findViewById(R.id.purchaceDateCalendarView_AddComputer);

        cbTastaturaIluminata = findViewById(R.id.cbTastaturaIluminata_AddComputer);
        cbWebcam = findViewById(R.id.cbWebcam_AddComputer);
        cbMouseWireless = findViewById(R.id.cbMouseWireless_AddComputer);
        cbMonitor = findViewById(R.id.cbMonitor_AddComputer);

        addComputerButton = findViewById(R.id.button);

        addComputerButton.setOnClickListener(v -> {
            String ramStr = ramEditText.getText().toString().trim();
            String storageStr = storageEditText.getText().toString().trim();
            Integer ram = ramStr.isEmpty() ? 0 : Integer.parseInt(ramStr);
            Integer storage = storageStr.isEmpty() ? 0 : Integer.parseInt(storageStr);
            String manufacture = manufactureEditText.getText().toString();
            Date purchaceDate = new Date(purchaceDateCalendarView.getDate());
            Boolean touchScreen = touchscreenCheckBox.isChecked();

            List<String> optiuniExtra = new ArrayList<>();
            if (cbTastaturaIluminata.isChecked()) {
                optiuniExtra.add(getString(R.string.tastatura_iluminata));
            }
            if (cbWebcam.isChecked()) {
                optiuniExtra.add(getString(R.string.webcam));
            }
            if (cbMouseWireless.isChecked()) {
                optiuniExtra.add(getString(R.string.mouse_wireless));
            }
            if (cbMonitor.isChecked()) {
                optiuniExtra.add(getString(R.string.monitor));
            }

            Computer computer = new Computer(ram, storage, manufacture, purchaceDate, touchScreen, optiuniExtra);

            Intent intent = new Intent();
            intent.putExtra("computer", computer);

            setResult(RESULT_OK, intent);
            finish();
        });
    }
}

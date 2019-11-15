package com.byfrunze.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDecr;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDecr = findViewById(R.id.editTextDescription);
        spinnerDaysOfWeek = findViewById(R.id.spinnerDaysOfWeek);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);
    }

    public void onClickAddNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String decription = editTextDecr.getText().toString().trim();
        String daysOfWeek = spinnerDaysOfWeek.getSelectedItem().toString();
        int radioBtnId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioBtnId);
        int priority = Integer.parseInt(radioButton.getText().toString());
        Note note = new Note(title, decription, daysOfWeek, priority);
        MainActivity.notes.add(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

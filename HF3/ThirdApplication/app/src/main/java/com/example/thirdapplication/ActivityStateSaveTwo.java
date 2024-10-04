package com.example.thirdapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityStateSaveTwo extends AppCompatActivity {
    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_state_save_two);

         editText = findViewById(R.id.editText);
         checkBox = findViewById(R.id.checkBox);

        if(savedInstanceState != null) {
            String editTextValue = savedInstanceState.getString("editTextValue");
            boolean checkBoxState = savedInstanceState.getBoolean("checkBoxState");

            editText.setText(editTextValue);
            checkBox.setChecked(checkBoxState);
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
            super.onSaveInstanceState(outState);


            outState.putString("editTextValue",editText.getText().toString());
            outState.putBoolean("checkBoxState",checkBox.isChecked());
    }
}
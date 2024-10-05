package com.example.mylinearlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear_layout);

        TextView textView = findViewById(R.id.txtView);
        EditText editText = findViewById(R.id.edtText);
        Button button = findViewById(R.id.btnLogin);
        Button button1 = findViewById(R.id.btnHome);
        Button button2 = findViewById(R.id.btnSignUp);

    }
}
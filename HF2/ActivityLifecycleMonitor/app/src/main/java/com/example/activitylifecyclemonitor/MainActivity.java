package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtSzoveg;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtSzoveg = findViewById(R.id.txtSzoveg);
        txtSzoveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSzoveg.append("\n" + txtSzoveg.getText().toString());
            }
        });
        editText = findViewById(R.id.edtText);

        Button gomb = findViewById(R.id.btnMainActivity);
        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityTwo.class);
                startActivity(intent);
            }
        });


        Log.d("Statusz:", "MainActivity - onCreate");
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("txt", txtSzoveg.getText().toString());
        Log.d("Statusz:","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtSzoveg.setText(savedInstanceState.getString("txt"));
        Log.d("Statusz:","onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz:","MainActivity - onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz:","MainActivity - onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz:","MainActivity - onPause");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz:","MainActivity - onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz:","MainActivity - onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz:","MainActivity - onDestroy");
    }
}

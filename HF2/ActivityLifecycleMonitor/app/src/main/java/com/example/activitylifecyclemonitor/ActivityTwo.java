package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        TextView textView =findViewById(R.id.textView);
        Log.d("Statusz:","ActivityTwo - onCreate");
        Button gomb = findViewById(R.id.btnMainActivity);
        Button gomb1 = findViewById(R.id.btnActivityThree);
        gomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTwo.this,ActivityThree.class);
                startActivity(intent);
            }
        });
        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(ActivityTwo.this,MainActivity.class);
                startActivity(intent);
            }
        });
        }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz:","ActivityTwo - onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz:","ActivityTwo - onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz:","ActivityTwo - onPause");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz:","ActivityTwo - onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz:","ActivityTwo - onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz:","ActivityTwo - onDestroy");
    }
}



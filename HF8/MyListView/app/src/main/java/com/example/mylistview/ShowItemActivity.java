package com.example.mylistview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_item);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String currencyName = extras.getString("currency_name");
            double currencyPrice = extras.getDouble("currency_price");

            TextView currencyDetails = findViewById(R.id.currency_details);
            currencyDetails.setText("Pénznem: " + currencyName + "\nVételi ár: " + String.format("%.2f", currencyPrice));
        }
    }
}
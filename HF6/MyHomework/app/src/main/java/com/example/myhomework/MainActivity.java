package com.example.myhomework;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String[] nameArray = {"EUR","USD","GBP","AUD",
            "CAD","CHF","DKK","HUF" };

    String[] infoArray = {
            "Euro",
            "Dolar american",
            "Lira sterlina",
            "Dolar australian",
            "Dolar canadian",
            "Franc elvetian",
            "Coroana daneza",
            "Forint maghiar",
    };

    String[] priceArray = {
            "Cumpără 4,4100 RON\nVinde 4,5500 RON",
            "Cumpără 3,9750 RON\nVinde 4,1450 RON",
            "Cumpără 6,1250 RON\nVinde 6,3550 RON",
            "Cumpără 2,9600 RON\nVinde 3,0600 RON",
            "Cumpără 3,0950 RON\nVinde 3,2650 RON",
            "Cumpără 4,2300 RON\nVinde 4,3300 RON",
            "Cumpără 0,5850 RON\nVinde 0,6150 RON",
            "Cumpără 0,0136 RON\nVinde 0,0146 RON"
    };


    Integer[] imageArray = {R.drawable.eur,
            R.drawable.usd,
            R.drawable.gbp,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf
    };
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
        ListView list = findViewById(R.id.ListView);
        CustomAdapter adapter = new CustomAdapter(this,nameArray,infoArray,imageArray);
        list.setAdapter(adapter);
        setTitle("");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.showPrices(view,priceArray[position]);
            }
        });

    }
}
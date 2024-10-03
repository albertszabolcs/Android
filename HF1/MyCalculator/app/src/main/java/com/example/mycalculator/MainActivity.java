package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText szam1;
    EditText szam2;
    TextView eredmeny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       szam1 = findViewById(R.id.edtText);
       szam2 = findViewById(R.id.edtText1);
       eredmeny = findViewById(R.id.textView);

        Button osszeadasGomb = findViewById(R.id.osszeadasbutton);
        Button kivonasGomb = findViewById(R.id.kivonasbutton);
        Button szorzasGomb = findViewById(R.id.szorzasbutton);
        Button osztasGomb = findViewById(R.id.osztasbutton);

        osszeadasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Muveletvegrehajtas('+');
            }
        });
        kivonasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Muveletvegrehajtas('-');
            }
        });
        szorzasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Muveletvegrehajtas('*');
            }
        });
        osztasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Muveletvegrehajtas('/');
            }
        });
    }

    private void Muveletvegrehajtas(char operator) {
        try {

            double elsoSzam = Double.parseDouble(szam1.getText().toString());
            double masodikSzam = Double.parseDouble(szam2.getText().toString());
            double Eredmeny = 0;

            switch (operator) {
                case '+':
                    Eredmeny = elsoSzam + masodikSzam;
                    break;
                case '-':
                    Eredmeny = elsoSzam - masodikSzam;
                    break;
                case '*':
                    Eredmeny = elsoSzam * masodikSzam;
                    break;
                case '/':
                    if (masodikSzam == 0) {
                        throw new ArithmeticException("Nullával nem lehet osztani");
                    }
                    Eredmeny = elsoSzam / masodikSzam;
                    break;
            }
            this.eredmeny.setText(String.valueOf(Eredmeny));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Hibás számbevitel!", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}





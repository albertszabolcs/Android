package com.example.myproducts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txtProductDisplay;
    private EditText edtProductCode,edtProductName,edtProductPrice;
    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtProductCode  = findViewById(R.id.edtProductCode);
        edtProductName = findViewById(R.id.edtProductName);
        edtProductPrice = findViewById(R.id.edtProductPrice);
        txtProductDisplay = findViewById(R.id.txtProductDisplay);

        Button ADDPRODUCT= findViewById(R.id.btnADDPRODUCT);
        Button CANCEL = findViewById(R.id.btnCANCEL);
        Button ShowProducts = findViewById(R.id.btnShowproducts);

        ADDPRODUCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = edtProductCode.getText().toString();
                String name = edtProductName.getText().toString();
                String price =edtProductPrice.getText().toString();

                Product product = new Product(code,name,price);
                products.add(product);

                edtProductCode.setText("");
                edtProductName.setText("");
                edtProductPrice.setText("");

            }
        });
        CANCEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtProductCode.setText("");
                edtProductName.setText("");
                edtProductPrice.setText("");

            }
        });
        ShowProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    StringBuilder productDisplay = new StringBuilder();
                    for (Product product : products) {
                        productDisplay.append(product.toString()).append("\n");
                    }
                txtProductDisplay.setText(productDisplay.toString());
            }
        });
    }
}
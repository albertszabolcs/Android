package com.example.myrecyclerviewcardview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String[] nameArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider","Lion","Cat","Disznyo","Dog","Giraffe","Horse","Octopus2","Octopus3"};
    String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary",
            "Scary",
            "Scary",
            "Scary"
    };

    Integer[] imageArray = {
            R.drawable.cat, R.drawable.disznyo, R.drawable.dog,
            R.drawable.giraffe, R.drawable.horse, R.drawable.lion,
            R.drawable.octopus3, R.drawable.rabbit, R.drawable.sheep
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CustomAdapter adapter = new CustomAdapter(this,nameArray,infoArray,imageArray);
        recyclerView.setAdapter(adapter);


    }
}
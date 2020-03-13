package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.myapplication.ButtonParametrs.buttons;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i = 0; i < buttons.size();i++){
            Button button = new Button(Main2Activity.this);
            button.setY(buttons.get(i).getButtonY());
            button.setX(buttons.get(i).getButtonX());
            addContentView(button, new ViewGroup.LayoutParams(buttons.get(i).getWidth(),buttons.get(i).getHeight()));
        }
    }
}

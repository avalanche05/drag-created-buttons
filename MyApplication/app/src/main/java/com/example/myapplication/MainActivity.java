package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> buttons = new ArrayList<>();
    private int i = 0;
    private TextView textView;
    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = new Button(MainActivity.this);
        addContentView(button,new ViewGroup.LayoutParams(100,100));
        add(button);

    }
    public void add(View button){
        button.setOnTouchListener(new View.OnTouchListener() {
            float dX;
            float dY;
            @SuppressLint("ResourceType")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        Button button = new Button(MainActivity.this);
                        addContentView(button,new ViewGroup.LayoutParams(100,100));
                        System.out.println("ID: "+button.getId()+"; X:"+button.getX()+"; Y:"+button.getY());
                        buttons.add(button);
                        add(button);


                        break;
                    default:
                        return true;
                }

                return true;
            }
        });
    }
}

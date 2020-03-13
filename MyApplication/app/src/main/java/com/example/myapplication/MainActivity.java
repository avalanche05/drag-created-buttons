package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.myapplication.ButtonParametrs.buttons;

public class MainActivity extends AppCompatActivity {
    private Button b;
    private int i = 1;
    private TextView textView;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return true;
    }
    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        Button button = new Button(MainActivity.this);
        addContentView(button,new ViewGroup.LayoutParams(250,250));
        button.setClickable(false);
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
                        button.setClickable(false);
                        b = (Button) view;
                        if(b.getX() > 50 || b.getY() > 50) {
                            if(b.getText().toString().isEmpty()) {
                                b.setText(""+i++);
                                buttons.add(new ButtonParametrs(b.getX(),b.getY(),b.getWidth(),b.getHeight()));
                                System.out.println(buttons.size()-1 + " place");
                            }
                            else{
                                buttons.set(Integer.parseInt(b.getText().toString()) - 1,new ButtonParametrs(b.getX(),b.getY(),b.getWidth(),b.getHeight()));
                                System.out.println(Integer.parseInt(b.getText().toString()) - 1 + " text");
                            }
                            addContentView(button, new ViewGroup.LayoutParams(250, 250));
                            add(button);
                        }

                        break;
                    default:
                        return true;
                }

                return true;
            }
        });
    }
    public void changeActivity(View view){
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            b.setScaleX(mScaleFactor);
            b.setScaleY(mScaleFactor);
            return true;
        }
    }
}

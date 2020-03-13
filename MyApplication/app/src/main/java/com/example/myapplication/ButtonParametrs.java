package com.example.myapplication;

import java.util.ArrayList;

public class ButtonParametrs {
    private float buttonX;
    private float buttonY;
    private int height;
    private int width;
    public static ArrayList<ButtonParametrs> buttons = new ArrayList<>();
    public ButtonParametrs(float x, float y, int height, int width){
        buttonX = x;
        buttonY = y;
        this.height = height;
        this.width = width;
    }

    public float getButtonX() {
        return buttonX;
    }

    public float getButtonY() {
        return buttonY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

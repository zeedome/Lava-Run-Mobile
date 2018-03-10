package com.example.modz.lavarun;

import android.graphics.Rect;

/**
 * Created by Modz on 3/10/2018.
 */

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int height;
    protected int width;


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public  Rect getRectangle(){
        return  new Rect(x,y,x+width,y+height);
    }
}

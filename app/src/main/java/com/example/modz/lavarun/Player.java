package com.example.modz.lavarun;

import android.graphics.Bitmap;
import android.view.animation.Animation;

/**
 * Created by Modz on 3/10/2018.
 */

public class Player extends GameObject{
    private Bitmap spritesheet;
    private int score;
    private double dya;
    private boolean;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;


    public Player(Bitmap res, int w, int h, int numFrames){
        x =100;
        y=GamePanel.HEIGHT/2;
        dy=0;
        height= h;
        width =w;

        Bitmap[] image = new Bitmap[numFrames];

        for(int i = 0; i<image.length;i++){

            image [i]= Bitmap.createBitmap(spritesheet,i*width,0,width,height);

            animation.setFrames(image);
            animation.setDelay(10);
            startTime = System.nanoTime();

        }

        public void setUp (boolean b){up = b;}

    }
}

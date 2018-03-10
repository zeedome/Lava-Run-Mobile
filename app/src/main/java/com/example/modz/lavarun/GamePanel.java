package com.example.modz.lavarun;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Modz on 3/9/2018.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 856;
    public static final int MOVESPEED = 7;
    private MainThread thread;
    private Background bg;
    public GamePanel(Context context){
        super(context);

        //add the callback to the surfaceHolder to interrupt the events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);

        //make gamePanel focus so it can handle the evnts
        setFocusable(true);


    }
    //pre defined methods ng surfaceHolder na kelangan i-override
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        bg = new Background(BitmapFactory.decodeResource(getResources(),R.drawable.background));

        //safely start the gameloop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        //will try to stop the thread
        while (retry){
            try {
                thread.setRunning(false);
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }

    public void update(){

        bg.update();
    }
    @Override
    public  void draw(Canvas canvas) {
        //getwidth kinukuha length ng phone ng user
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);
        if(canvas!=null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX,scaleFactorY);
            super.draw(canvas);
            bg.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}

package com.example.hw22;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SurfaceListner implements View.OnTouchListener {

    TextView drawingName;
    SurfaceController SurfaceController;
    //SeekbarController SBController;
    private int xTap;
    private int yTap;

    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;

    protected CustomElement currentElement = null;

    int[] color = {0,0,0};


    public SurfaceListner(SurfaceController passedInSurfaceController,
                          SeekBar redSB, SeekBar greenSB, SeekBar blueSB,
                          TextView passedInName){

        SurfaceController = passedInSurfaceController;
        redBar = redSB;
        greenBar = greenSB;
        blueBar = blueSB;
        //SBController = passedInSBController;
        drawingName = passedInName;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        xTap = (int)event.getX();
        yTap = (int)event.getY();
        int r;
        int[] rgb = null;

        if( SurfaceController.lPupil.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.lPupil;
            setSeekBars(SurfaceController.lPupil);

        }
        else if (SurfaceController.lEye.containsPoint(xTap, yTap)){
            setSeekBars(SurfaceController.lEye);
            currentElement = SurfaceController.lEye;
        }
        else if (SurfaceController.rPupil.containsPoint(xTap, yTap)){
            setSeekBars(SurfaceController.rPupil);
            currentElement = SurfaceController.rPupil;
        }
        else if (SurfaceController.rEye.containsPoint(xTap, yTap)){
            setSeekBars(SurfaceController.rEye);
            currentElement = SurfaceController.rEye;
        }
        else if (SurfaceController.mouth.containsPoint(xTap, yTap)){
            setSeekBars(SurfaceController.mouth);
            currentElement = SurfaceController.mouth;
        }
        else if (SurfaceController.head.containsPoint(xTap, yTap)){
            setSeekBars(SurfaceController.head);
            currentElement = SurfaceController.head;
        }

        SurfaceController.head.setColor(0xFF456589);

        SurfaceController.invalidate();

        return true;
    }
    /*
    External Citation
    Date: 18 February 2019
    Problem: I didn't know how to get RGB values from a an int.
    Resource: https://stackoverflow.com/questions/20326784
    /how-can-i-get-red-value-from-rgb-value-android
    Solution: I used the example code from this post.
    */
    private void setSeekBars(CustomElement currentElement){
        color[0] = (currentElement.getColor() >> 16) & 0xFF;
        color[1] = (currentElement.getColor() >> 8) & 0xFF;
        color[2] = (currentElement.getColor() >> 0) & 0xFF;

        int returnColor = Color.rgb(color[0], color[1], color[2]);
        currentElement.setColor(returnColor);

        redBar.setProgress(color[0]);
        greenBar.setProgress(color[1]);
        blueBar.setProgress(color[2]);
        drawingName.setText(currentElement.myName);

    }
}

package com.example.hw22;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Listener implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    private SurfaceController SurfaceController;

    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;

    private CustomElement currentElement = null;

    private TextView drawingName;
    private TextView redTV;
    private TextView greenTV;
    private TextView blueTV;

    private SurfaceController theSurfaceController;

    private int red;
    private int green;
    private int blue;


    public Listener(SurfaceController passedInSurfaceController,
                    SeekBar redSB, SeekBar greenSB, SeekBar blueSB,
                    TextView passedInName, TextView passedRedTV,
                    TextView passedGreenTV, TextView passedBlueTV){

        SurfaceController = passedInSurfaceController;
        redBar = redSB;
        greenBar = greenSB;
        blueBar = blueSB;
        drawingName = passedInName;

        redBar = redSB;
        redTV = passedRedTV;
        redBar.setOnSeekBarChangeListener(this);

        greenBar = greenSB;
        greenTV = passedGreenTV;
        greenBar.setOnSeekBarChangeListener(this);

        blueBar = blueSB;
        blueTV = passedBlueTV;
        blueBar.setOnSeekBarChangeListener(this);

       theSurfaceController = passedInSurfaceController;
       theSurfaceController.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int xTap = (int)event.getX();
        int yTap = (int)event.getY();

        if( SurfaceController.lPupil.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.lPupil;
            setSeekBars(SurfaceController.lPupil);

        }
        else if (SurfaceController.lEye.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.lEye;
            setSeekBars(SurfaceController.lEye);
        }
        else if (SurfaceController.rPupil.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.rPupil;
            setSeekBars(SurfaceController.rPupil);
        }
        else if (SurfaceController.rEye.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.rEye;
            setSeekBars(SurfaceController.rEye);
        }
        else if (SurfaceController.mouth.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.mouth;
            setSeekBars(SurfaceController.mouth);
        }
        else if (SurfaceController.head.containsPoint(xTap, yTap)){
            currentElement = SurfaceController.head;
            setSeekBars(SurfaceController.head);
        }

        SurfaceController.invalidate();
        return true;
    }

    private void setSeekBars(CustomElement passedInElement){

        /**
        External Citation
        Date: 18 February 2019
        Problem: I didn't know how to get RGB values from a an int.
        Resource: https://stackoverflow.com/questions/20326784
        /how-can-i-get-red-value-from-rgb-value-android
        Solution: I used the example code from this post.
        */
        int tempColor = passedInElement.getColor();
        red = (tempColor >> 16) & 0xFF;
        green = (tempColor >> 8) & 0xFF;
        blue = (tempColor >> 0) & 0xFF;

        redBar.setProgress(red);
        greenBar.setProgress(green);
        blueBar.setProgress(blue);
        drawingName.setText(currentElement.myName);

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(seekBar == redBar) {
            redTV.setText("" + progress );
            red = progress;
        }
        else if (seekBar == greenBar){
            greenTV.setText("" + progress);
            green = progress;
        }
        else if (seekBar == blueBar ){
            blueTV.setText("" + progress );
            blue = progress;
        }

        int returnColor = Color.rgb(red, green, blue);
        currentElement.setColor(returnColor);

        SurfaceController.invalidate();
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //IGNORE
    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //IGNORE
    }


}



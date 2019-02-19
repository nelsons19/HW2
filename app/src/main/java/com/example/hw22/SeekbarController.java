package com.example.hw22;

import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * This class defines the Controller for all seek bars.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class SeekbarController implements SeekBar.OnSeekBarChangeListener {
    protected SeekBar redBar;
    protected SeekBar greenBar;
    protected SeekBar blueBar;
    protected TextView redTV;
    protected TextView greenTV;
    protected TextView blueTV;

    private SurfaceController theSurfaceController;

    private SurfaceListner displayListener;

    public SeekbarController(SeekBar redSB, SeekBar greenSB, SeekBar blueSB, TextView passedRedTV,
                             TextView passedGreenTV, TextView passedBlueTV, SurfaceController passedInSurfaceController,
                              SurfaceListner listener){
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

        displayListener = listener;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red = displayListener.color[0];
        int green = displayListener.color[1];
        int blue = displayListener.color[2];
        if(seekBar == redBar) {
            redTV.setText("" + progress);
            red += progress;
        }
        else if (seekBar == greenBar){
            greenTV.setText("" + progress);
            green += progress;
        }
        else{
            blueTV.setText("" + progress);
            blue += progress;
        }
        int returnColor = Color.rgb(red, green, blue);

        if(displayListener.currentElement == theSurfaceController.lPupil) {
            theSurfaceController.lPupil.setColor(returnColor);

        }
        displayListener.SurfaceController.invalidate();
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

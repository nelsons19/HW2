package com.example.hw22;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class CustomElement -->
 *
 * This class defines the Controller for all seek bars.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class SeekbarController implements SeekBar.OnSeekBarChangeListener {
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;
    TextView redTV;
    TextView greenTV;
    TextView blueTV;

    int rValue = 0;

    public SeekbarController(SeekBar redSB, SeekBar greenSB, SeekBar blueSB, TextView passedRedTV,
                             TextView passedGreenTV, TextView passedBlueTV){
        redBar = redSB;
        redTV = passedRedTV;
        redBar.setOnSeekBarChangeListener(this);

        greenBar = greenSB;
        greenTV = passedGreenTV;
        greenBar.setOnSeekBarChangeListener(this);

        blueBar = blueSB;
        blueTV = passedBlueTV;
        blueBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == redBar) {
            redTV.setText("" + progress);
        }
        else if (seekBar == greenBar){
            greenTV.setText("" + progress);
        }
        else{
            blueTV.setText("" + progress);
        }
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

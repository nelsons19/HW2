package com.example.hw22;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    SeekBar redValueSB = null;
    SeekBar greenValueSB = null;
    SeekBar blueValueSB = null;

    TextView redValue = null;
    TextView greenValue = null;
    TextView blueValue = null;

    SurfaceView mySurfaceview = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_layout);
        //initialize and set listener for seek bars
        redValueSB = (findViewById(R.id.redValueSB));
        redValueSB.setOnSeekBarChangeListener(this);

        greenValueSB = (findViewById(R.id.greenValueSB));
        greenValueSB.setOnSeekBarChangeListener(this);

        blueValueSB = (findViewById(R.id.blueValueSB));
        blueValueSB.setOnSeekBarChangeListener(this);

        redValue = (findViewById(R.id.redValue));
        greenValue = (findViewById(R.id.greenValue));
        blueValue = (findViewById(R.id.blueValue));

        mySurfaceview = (findViewById(R.id.mySurfaceview));
        SurfaceController painter = new SurfaceController(this);
        mySurfaceview.setOnTouchListener(painter);

            }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == redValueSB) {
            redValue.setText("" + progress);
        }
        else if (seekBar == greenValueSB){
            greenValue.setText("" + progress);
        }
        else{
            blueValue.setText("" + progress);
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

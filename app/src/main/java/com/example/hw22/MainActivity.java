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

public class MainActivity extends AppCompatActivity {
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

        greenValueSB = (findViewById(R.id.greenValueSB));
        //greenValueSB.setOnSeekBarChangeListener(this);

        blueValueSB = (findViewById(R.id.blueValueSB));
        //blueValueSB.setOnSeekBarChangeListener(this);

        redValue = (findViewById(R.id.redValue));
        greenValue = (findViewById(R.id.greenValue));
        blueValue = (findViewById(R.id.blueValue));

        SeekbarController cont = new SeekbarController(redValueSB, greenValueSB, blueValueSB,
                                        redValue, greenValue, blueValue);

        mySurfaceview = (findViewById(R.id.mySurfaceview));
        SurfaceController surface = new SurfaceController(this);
        mySurfaceview.setOnTouchListener(surface);

    }
}

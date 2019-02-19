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
    public SeekBar redValueSB = null;
    SeekBar greenValueSB = null;
    SeekBar blueValueSB = null;

    TextView redValue = null;
    TextView greenValue = null;
    TextView blueValue = null;
    TextView name = null;

    SurfaceView mySurfaceview = null;
    public SurfaceController surface;
    SurfaceListner theSurfaceListener = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_layout);
        //View testView = new View(findViewById(R.id.sliders));

        //initialize and set listener for seek bars
        redValueSB = (findViewById(R.id.redValueSB));

        greenValueSB = (findViewById(R.id.greenValueSB));
        //greenValueSB.setOnSeekBarChangeListener(this);

        blueValueSB = (findViewById(R.id.blueValueSB));
        //blueValueSB.setOnSeekBarChangeListener(this);

        redValue = (findViewById(R.id.redValue));
        greenValue = (findViewById(R.id.greenValue));
        blueValue = (findViewById(R.id.blueValue));
        name = (findViewById(R.id.drawingName));

        SeekbarController cont = new SeekbarController(redValueSB, greenValueSB, blueValueSB,
                                        redValue, greenValue, blueValue);

        mySurfaceview = (findViewById(R.id.mySurfaceview));
        surface = new SurfaceController(this);
        theSurfaceListener = new SurfaceListner(surface, name);
        mySurfaceview.setOnTouchListener(theSurfaceListener);

        //name.setText(surface.getName()); // think I will be changing this

        //surface.invalidate();


    }
}

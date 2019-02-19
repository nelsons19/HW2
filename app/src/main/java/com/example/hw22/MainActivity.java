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

    //Create instances of all objects that will be used
    private SeekBar redValueSB = null;
    private SeekBar greenValueSB = null;
    private SeekBar blueValueSB = null;

    private TextView redValue = null;
    private TextView greenValue = null;
    private TextView blueValue = null;
    private TextView name = null;

    private SurfaceController surface;

    private Listener theListener = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_layout);

        //Find and initialize all seek bars so values can be changed
        redValueSB = (findViewById(R.id.redValueSB));
        greenValueSB = (findViewById(R.id.greenValueSB));
        blueValueSB = (findViewById(R.id.blueValueSB));

        //Find and initialize all seek bars so values can be changed
        redValue = (findViewById(R.id.redValue));
        greenValue = (findViewById(R.id.greenValue));
        blueValue = (findViewById(R.id.blueValue));
        name = (findViewById(R.id.drawingName));

        surface = (findViewById(R.id.mySurfaceview));

        theListener = new Listener(surface, redValueSB, greenValueSB,
                                    blueValueSB, name, redValue, greenValue,
                                    blueValue);
        surface.setOnTouchListener(theListener);

    }
}

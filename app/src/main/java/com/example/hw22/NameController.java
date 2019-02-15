package com.example.hw22;


import android.view.SurfaceView;
import android.widget.TextView;

public class NameController {
    TextView elementName;
    int x;
    int y;
    SurfaceController surface;

    public NameController(TextView name, int xVal, int yVal, SurfaceController initSurface){
        elementName = name;
        x = xVal;
        y = yVal;
        surface = initSurface;
    }

    public void getElementName() {
        if (surface.head.containsPoint(x, y)) {
            elementName.setText(surface.head.myName);
        }
    }
}

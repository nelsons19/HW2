package com.example.hw22;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SurfaceListner implements View.OnTouchListener {

    TextView drawingName;
    SurfaceController controller;
    private int xTap;
    private int yTap;

    public SurfaceListner(SurfaceController passedInController, TextView passedInName){
        drawingName = passedInName;
        controller = passedInController;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        xTap = (int)event.getX();
        yTap = (int)event.getY();
        int test = 0;

        if( controller.lPupil.containsPoint(xTap, yTap)){
            drawingName.setText(controller.lPupil.myName);
        }
        else if (controller.lEye.containsPoint(xTap, yTap)){
            drawingName.setText(controller.lEye.myName);
        }
        else if (controller.rPupil.containsPoint(xTap, yTap)){
            drawingName.setText(controller.rPupil.myName);
        }
        else if (controller.rEye.containsPoint(xTap, yTap)){
            drawingName.setText(controller.rEye.myName);
        }
        else if (controller.mouth.containsPoint(xTap, yTap)){
            drawingName.setText(controller.mouth.myName);
        }
        else if (controller.head.containsPoint(xTap, yTap)){
            drawingName.setText(controller.head.myName);
        }

        controller.head.setColor(0xFF456589);

        controller.invalidate();

        return true;
    }
}

package com.example.hw22;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import com.example.*;

import java.security.PublicKey;

/**
 * <!-- class CustomElement -->
 *
 * This class defines the Controller for the surface view.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class SurfaceController extends SurfaceView implements View.OnTouchListener{

    public CustomCircle head = new CustomCircle("head",0xFFFFE0BD,600,600,600);
    public CustomCircle lEye = new CustomCircle("left eye",0xFFFFFFFF,300,400,200);
    public CustomCircle rEye = new CustomCircle("right eye",0xFFFFFFFF,900,400,200);
    public CustomCircle lPupil = new CustomCircle( "left pupil", 0xFF6C3483,350,450,75);
    public CustomCircle rPupil = new CustomCircle( "right pupil", 0xFF6C3483,950,450,75);
    public CustomRect mouth = new CustomRect("mouth", 0xFF000000, 300, 800, 600, 900);

    public int xVal;
    public int yVal;

    public SurfaceController(Context context) {
        super(context);
        setWillNotDraw(false);
        init();
    }

    public SurfaceController(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        init();
    }

    public SurfaceController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //Set canvas background color
        canvas.drawColor(0xFFFFFFFF);



        head.drawMe(canvas);
        lEye.drawMe(canvas);
        rEye.drawMe(canvas);
        lPupil.drawMe(canvas);
        rPupil.drawMe(canvas);
        mouth.drawMe(canvas);




    }

    @Override
    public boolean onTouch(View myView, MotionEvent event) {
        xVal = (int)event.getX();
        yVal = (int)event.getY();

        /*if (head.containsPoint(xVal, yVal)) {
            head.setColor(0xFF456589);
        }

        head.setColor(0xFF456589);*/

        this.invalidate();

        return true;
    }
}

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
import java.util.ArrayList;

/**
 * This class defines the Controller for the surface view.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class SurfaceController extends SurfaceView /*implements View.OnTouchListener*/{

    public CustomCircle head = new CustomCircle("head",0xFFFFE0BD,600,600,600);
    public CustomCircle lEye = new CustomCircle("left eye",0xFFFFFFFF,300,400,200);
    public CustomCircle rEye = new CustomCircle("right eye",0xFFFFFFFF,900,400,200);
    public CustomCircle lPupil = new CustomCircle( "left pupil", 0xFF6C3483,350,450,75);
    public CustomCircle rPupil = new CustomCircle( "right pupil", 0xFF6C3483,950,450,75);
    public CustomRect mouth = new CustomRect("mouth", 0xFF000000, 300, 800, 600, 900);

    public int xTap;
    public int yTap;

    Context theContext;


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
        //TODO: this.setOnTouchListener(this);
        this.setLayerType(this.LAYER_TYPE_SOFTWARE, null);
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

    /*@Override
    public boolean onTouch(View myView, MotionEvent event) {
        xTap = (int)event.getX();
        yTap = (int)event.getY();
        int test = 0;

        if( lPupil.containsPoint(xTap, yTap)){
            test = xTap;
        }
        else if (lEye.containsPoint(xTap, yTap)){
            test = xTap;
        }
        else if (rPupil.containsPoint(xTap, yTap)){
            test = xTap;
        }
        else if (rEye.containsPoint(xTap, yTap)){
            test = xTap;
        }
        else if (mouth.containsPoint(xTap, yTap)){
            test = xTap;
        }
        else if (head.containsPoint(xTap, yTap)){
            test = xTap;
        }

        if (head.containsPoint(xTap, yTap)) {
            CustomCircle testCir = new CustomCircle("test", 0xFF000000, xTap, yTap, 100);

        }

        head.setColor(0xFF456589);

        this.invalidate();

        return true;
    }*/
    public String getName() {
        String toReturn = "0";
    if (head.containsPoint(xTap, yTap)){
        toReturn = head.getName();
    }
    return toReturn;
    }
}

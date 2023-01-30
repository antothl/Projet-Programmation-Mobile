package com.example.projet.model;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

import com.example.projet.R;
/*classe correspondant au ballon*/
public class jeuBalle extends View implements SensorEventListener {

    private Paint paint = new Paint();
    private Bitmap ballBitmap;

    private int imageWidth;
    private int imageHeight;
    private int currentX;
    private int currentY;


    public jeuBalle( Context context ) {
        super( context );
        this.init( context );
    }

    public jeuBalle( Context context, AttributeSet attrSet ) {
        super( context, attrSet );
        this.init( context );
    }

    private void init( Context context ) {
        this.ballBitmap =
                BitmapFactory.decodeResource(getResources(), R.drawable.football );
        this.imageWidth = ballBitmap.getWidth();
        this.imageHeight = ballBitmap.getHeight();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        this.currentX = (getWidth() - this.imageWidth) / 2;
        this.currentY = (getHeight() - this.imageHeight) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap( this.ballBitmap, this.currentX, this.currentY, this.paint );
    }

    private void moveImage( float x, float y ) {
        this.currentX += (int) x;
        this.currentY += (int) y;

        if ( this.currentX < 0 ) {
            this.currentX = 0;
        } else if ( this.currentX + this.imageWidth > this.getWidth() ){
            this.currentX = this.getWidth() - this.imageWidth;
        }

        if ( this.currentY < 0 ) {
            this.currentY = 0;
        } else if ( this.currentY + this.imageHeight > this.getHeight() ){
            this.currentY = this.getHeight() - this.imageHeight;
        }

        this.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        //float z = event.values[2];

        this.moveImage( -x*5, y*5 );
    }


}
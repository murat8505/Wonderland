package com.Wonderland.graphicObjects;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.Wonderland.helpers.Constants;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Used to display background in menus.
 * It adds the logic to make it "touchable" for menu elements
 */
public class MyImageView extends ImageView {

    /**
     * Touch listener
     */
    private MyOnTouchEvent myOnTouchEvent;

    /**
     * Real size of the background image (default value)
     */
    private int[] size = Constants.BACKGROUND_SIZE;

    public MyImageView(Context context) {
        super(context);
        initialize();
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    private void initialize() {
        final ImageView imageView = this;

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                // remove movement events for scrollView
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int touchX = (int) event.getX();
                    int touchY = (int) event.getY();

                    // Scalo la posizione per ottenere x e y
                    int imageY = touchY * size[1] / imageView.getHeight();
                    int imageX = touchX * size[0] / imageView.getWidth();

                    if (myOnTouchEvent != null)
                        myOnTouchEvent.position(imageX, imageY);
                }

                // if I don't return true on ACTION_DOWN I will never get ACTION_UP
                return event.getAction() == MotionEvent.ACTION_DOWN;
            }
        });
    }

    private void setOnTouchListener() {

    }

    /**
     * Set new default size of the background image
     *
     * @param size int[], dimensions of the image (x,y)
     */
    public void setSize(int[] size) {
        this.size = size;
    }

    /**
     * Set touche events response
     *
     * @param myOnTouchEvent, MyOnTouchEvent interface
     */
    public void setMyOnTouchEvent(MyOnTouchEvent myOnTouchEvent) {
        this.myOnTouchEvent = myOnTouchEvent;

        initialize();
    }

    /**
     * Custom touch interface to handle touche events
     */
    public interface MyOnTouchEvent {
        public void position(int x, int y);
    }
}

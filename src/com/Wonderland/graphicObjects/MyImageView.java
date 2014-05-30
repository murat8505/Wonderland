package com.Wonderland.graphicObjects;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Used to display background in menus.
 * It adds the logic to make it "touchable" for menu elements
 */
public class MyImageView extends ImageView {

    private MyOnTouchEvent myOnTouchEvent;

    public MyImageView(Context context) {
        super(context);
        initialize(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    private void initialize(Context context) {

    }

    public void setUp(final int[] SIZE) {

        final ImageView imageView = this;

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                int touchX = (int) event.getX();
                int touchY = (int) event.getY();

                // Scalo la posizione per ottenere x e y
                int imageY = touchY * SIZE[1] / imageView.getHeight();
                int imageX = touchX * SIZE[0] / imageView.getWidth();

                if (myOnTouchEvent != null)
                    myOnTouchEvent.position(imageX, imageY);

                return false;
            }
        });
    }

    /**
     * Set touche events response
     *
     * @param myOnTouchEvent, MyOnTouchEvent interface
     */
    public void setMyOnTouchEvent(MyOnTouchEvent myOnTouchEvent) {
        this.myOnTouchEvent = myOnTouchEvent;
    }

    /**
     * Custom touch interface to handle touche events
     */
    public interface MyOnTouchEvent {
        public void position(int x, int y);
    }
}

package com.Wonderland.graphicObjects;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.Wonderland.main.R;

/**
 * Created by marco on 02/06/14.
 */
public class BrightnessSeekBar extends RelativeLayout {

    private AudioManager audioManager;

    /**
     * Looper to control changes in brightness
     */
    private Handler handler = new Handler(Looper.getMainLooper());


    public BrightnessSeekBar(Context context) {
        super(context);
        initialize(context);
    }

    public BrightnessSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public BrightnessSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    private void initialize(final Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.brightness_seekbar, this, true);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        final WindowManager.LayoutParams layout = ((Activity) context).getWindow().getAttributes();

        // set max value on the seekbar
        seekBar.setMax(255);


        // start control cycle on the volume level
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                float prevBrightness = layout.screenBrightness;
                seekBar.setProgress((int) prevBrightness);

                handler.postDelayed(this, 100);
            }
        }, 100);

        //l listener to change brightness on user touch
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, final int i, boolean b) {
                layout.screenBrightness = i;
                ((Activity) context).getWindow().setAttributes(layout);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

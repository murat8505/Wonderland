package com.Wonderland.graphicObjects;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.Wonderland.main.R;

/**
 * Created by marco on 02/06/14.
 */
public class BrightnessSeekBar extends RelativeLayout {

    private int brightness;

    private static final int MINIMUM = 20;

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
        seekBar.setMax(255 - MINIMUM);
        seekBar.setKeyProgressIncrement(1);

        //Get the content resolver
        final ContentResolver cResolver = context.getContentResolver();

        //Get the current window
        final Window window = ((Activity) context).getWindow();

        // start control cycle on the volume level
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
                    seekBar.setProgress(brightness - MINIMUM);
                    handler.postDelayed(this, 100);

                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                    Log.e("Error", "Cannot access system brightness");
                }


            }
        }, 100);

        //l listener to change brightness on user touch
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean b) {

                //Set the system brightness using the brightness variable value
                System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness - MINIMUM);
                //Get the current window attributes
                WindowManager.LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                layoutpars.screenBrightness = (brightness - MINIMUM) / (float) 255;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);

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

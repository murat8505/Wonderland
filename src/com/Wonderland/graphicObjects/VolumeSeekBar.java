package com.Wonderland.graphicObjects;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.Wonderland.main.R;

/**
 * Created by marco on 22/04/14.
 * <p/>
 * Stand alone volume bar.
 * <p/>
 * It's a seekbar which control the STREAM_MUSIC volume.
 * It has an Handler which verifies every 100ms the volume level to maintain consistency with
 * changes using hw buttons
 */
public class VolumeSeekBar extends RelativeLayout {

    private AudioManager audioManager;
    private int streamType = AudioManager.STREAM_MUSIC;

    /**
     * Looper tocontrol changes in volume
     */
    private Handler handler = new Handler(Looper.getMainLooper());


    public VolumeSeekBar(Context context) {
        super(context);
        initialize(context);
    }

    public VolumeSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public VolumeSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    private void initialize(final Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.volume_seekbar, this, true);

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        // set max volume on the seekbar
        int max_volume = audioManager.getStreamMaxVolume(streamType);
        seekBar.setMax(max_volume);


        // start control cycle on the volume level
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(audioManager.getStreamVolume(streamType));

                handler.postDelayed(this, 100);
            }
        }, 100);

        //l listener to change volume on user touch
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, final int i, boolean b) {

                audioManager.setStreamVolume(streamType, i, 0);
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

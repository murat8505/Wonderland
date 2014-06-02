package com.Wonderland.graphicObjects;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;

/**
 * Created by marco on 24/04/14.
 * <p/>
 * Stand alone player for audio or video file
 */
public class Player extends LinearLayout {

    /**
     * Play or pause imageview
     */
    private ImageButton playOrPause;

    /**
     * textView for time passed and remaining
     */
    private TextView timePassed, timeRemaining;

    /**
     * Seekbar to show the progress of the reproduction
     */
    private SeekBar seekBar;

    private String path;

    private VideoView video;

    private Context context;

    /**
     * Handler to manage update of the seekbar position and of time passed and remaining
     */
    private Handler handler;
    /**
     * Runnable which updates seekbar and time passed and remaining
     */
    private Runnable mUpdateTimeTask = new Runnable() {
        @Override
        public void run() {

            long totalDuration = video.getDuration();
            long currentDuration = video.getCurrentPosition();

            timePassed.setText("" + Helper.milliSecondsToTimer(currentDuration));

            timeRemaining.setText("-" + Helper.milliSecondsToTimer(totalDuration - currentDuration));

            // Updating progress bar
            int progress = (int) (Helper.getProgressPercentage(currentDuration, totalDuration));

            seekBar.setProgress(progress);

            // Running this thread after 100 milliseconds
            handler.postDelayed(this, 100);
        }
    };


    public Player(Context context) {
        super(context);
        init(context);
    }

    public Player(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Player(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.player, this, true);

        playOrPause = (ImageButton) findViewById(R.id.playOrPause);
        timePassed = (TextView) findViewById(R.id.timePassed);
        timeRemaining = (TextView) findViewById(R.id.timeRemaining);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setProgress(0);
        seekBar.setMax(100);


        // listener to seek the correct time on seekbar touch
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(mUpdateTimeTask);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(mUpdateTimeTask);

                int totalDuration = video.getDuration();
                int currentPosition = Helper.progressToTimer(seekBar.getProgress(), totalDuration);

                // forward or backward to certain seconds
                video.seekTo(currentPosition);

                // update timer progress again
                updateSeekBar();
            }
        });

        playOrPause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (video.isPlaying())
                    pause();
                else
                    resume();
            }
        });

        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * initialize handler to continually update seekbar
     */
    private void updateSeekBar() {
        handler.postDelayed(mUpdateTimeTask, 100);
    }

    /**
     * set the path of the file to play, and the VideoView
     *
     * @param path,  String - complete path
     * @param video, VideoView
     */
    public void setFile(String path, VideoView video) {
        this.path = path;
        this.video = video;

        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer player) {
                pause();
                seekBar.setProgress(0);
                player.seekTo(0);
            }
        });

        play();
    }

    /**
     * Start playing
     */
    private void play() {

        try {
            video.setVideoPath(path);

            resume();

        } catch (Exception exception) {
            Helper.showOpenFileErrorAlertDialog(context);
        }
    }

    /**
     * Resume playing
     */
    private void resume() {
        video.start();

        playOrPause.setImageResource(R.drawable.pause);

        updateSeekBar();
    }

    /**
     * Pause playing
     */
    public void pause() {
        video.pause();
        playOrPause.setImageResource(R.drawable.play);

        handler.removeCallbacks(mUpdateTimeTask);
    }


    /**
     * Release player
     */
    public void release() {

        video.stopPlayback();
        handler.removeCallbacks(mUpdateTimeTask);


    }
}
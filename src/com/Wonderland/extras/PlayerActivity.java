package com.Wonderland.extras;

import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.graphicObjects.Player;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.main.R;

/**
 * Created by marco on 22/04/14.
 */
public class PlayerActivity extends MyActivity {

    private Player player;
    private VideoView video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);

        video = (VideoView) findViewById(R.id.PlaybackView);
        video.setMediaController(null);


        player = (Player) findViewById(R.id.player);

        String video = getIntent().getExtras().getString(Constants.VIDEO_PATH);
        String audio = getIntent().getExtras().getString(Constants.AUDIO_PATH);

        if (audio != null)
            setAudioMode(audio);
        else if (video != null)
            setVideoMode(video);
        else
            finish();

        TextView close = (TextView) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public String getActivityTitle() {
        return null;
    }

    @Override
    public void onBack() {

    }

    private void setAudioMode(String path) {

        findViewById(R.id.brightness).setVisibility(View.GONE);

        Drawable d = getResources().getDrawable(R.drawable.audio_item);
        int h = d.getIntrinsicHeight();
        int w = d.getIntrinsicWidth();

        ViewGroup.LayoutParams params = video.getLayoutParams();
        params.width = w;
        params.height = h;
        video.invalidate();

        video.setBackground(d);

        initializePlayer(path);
    }

    private void setVideoMode(String path) {
        initializePlayer(path);
    }

    private void initializePlayer(String path) {
        setTile(path);
        player.setFile(path, video);
    }

    private void setTile(String path) {

        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);

        String autor = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        TextView authorTextView = (TextView) findViewById(R.id.author);
        authorTextView.setText(autor);

        String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        GroupActionBar actionBar = (GroupActionBar) findViewById(R.id.menuActionBar);
        actionBar.setText(title);
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.pause();
    }

}

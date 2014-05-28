package com.Wonderland.extras;

import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.graphicObjects.Player;
import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;

/**
 * Created by marco on 22/04/14.
 */
public class AudioRep extends Activity {

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_player_activity);


        player = (Player) findViewById(R.id.audioPlayer);

        String path = getIntent().getExtras().getString(Constants.AUDIO);

        player.setFile(path);

        setTile(path);

        TextView close = (TextView) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBack();
            }
        });
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

    private void myBack() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        //do nothing
    }
}

package com.Wonderland.extras;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.Wonderland.graphicObjects.GridArrayAdapter;
import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;

import java.io.File;
import java.util.List;

/**
 * Created by marco on 19/04/14.
 */
public class Audio extends Activity {

    private GroupActionBar groupActionBar;
    private MediaPlayer player;
    private List<File> list;
    private GridArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.extras);

        final Context extras = this;

        groupActionBar = (GroupActionBar) findViewById(R.id.menuActionBar);
        groupActionBar.setText(getSectionTitle());
        groupActionBar.setBackButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startMenuActivity(extras, R.string.extras);
                player.release();
            }
        });

        GridView gridView = (GridView) findViewById(R.id.gridView);

        player = new MediaPlayer();
        list = Helper.listFiles(Constants.AUDIO_PATH);

        adapter = new GridArrayAdapter(this, R.layout.audio_button, list);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(extras, AudioRep.class);
                i.putExtra(Constants.AUDIO, list.get(position).getAbsolutePath());
                extras.startActivity(i);
            }
        });


    }


    public int getSectionTitle() {
        return R.string.audioTitle;
    }


}

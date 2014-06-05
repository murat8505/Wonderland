package com.Wonderland.extras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.Wonderland.graphicObjects.ExtrasGridArrayAdapter;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.main.R;

import java.io.File;
import java.util.List;

/**
 * Created by marco on 19/04/14.
 * <p/>
 * List of files for the Extras menu
 */
public abstract class AbstractGridViewActivity extends MyActivity {

    protected GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.extras);

        gridView = (GridView) findViewById(R.id.gridView);
    }

    protected void setAdapter(final String path) {

        final List<File> list = Helper.listFiles(path);

        ExtrasGridArrayAdapter adapter = new ExtrasGridArrayAdapter(this, R.layout.extras_gridview_element, list);

        if (path.equals(Constants.VIDEO_PATH))
            adapter.isVideo();
        else if (path.equals(Constants.AUDIO_PATH))
            adapter.isAudio();
        else
            adapter.isWallPaper();

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i;

                if (path.equals(Constants.WALLPAPER_PATH)) {
                    i = new Intent(activity, WallPaperViewActivity.class);
                    i.putExtra(path, list.get(position).getAbsolutePath());
                } else {
                    i = new Intent(activity, PlayerActivity.class);
                    i.putExtra(path, list.get(position).getAbsolutePath());
                }

                activity.startActivity(i);
            }
        });
    }

}

package com.Wonderland.extras.sections;

import android.os.Bundle;

import com.Wonderland.extras.AbstractGridViewActivity;
import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

/**
 * Created by marco on 02/06/14.
 */
public class WallPaperActivity extends AbstractGridViewActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter(Constants.WALLPAPER_PATH);

        boolean pauseOnScroll = false; // or true
        boolean pauseOnFling = true; // or false

        PauseOnScrollListener listener = new PauseOnScrollListener(ImageLoader.getInstance(), pauseOnScroll, pauseOnFling);
        gridView.setOnScrollListener(listener);
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.wallpaperTitle);
    }
}

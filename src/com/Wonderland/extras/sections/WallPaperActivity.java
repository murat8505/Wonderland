package com.Wonderland.extras.sections;

import android.os.Bundle;

import com.Wonderland.extras.AbstractGridViewActivity;
import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;

/**
 * Created by marco on 02/06/14.
 */
public class WallPaperActivity extends AbstractGridViewActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter(Constants.WALLPAPER_PATH);
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.wallpaperTitle);
    }
}

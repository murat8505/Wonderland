package com.Wonderland.extras;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.main.R;

/**
 * Created by marco on 02/06/14.
 */
public class WallPaperViewActivity extends MyActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpaper);

        String path = getIntent().getExtras().getString(Constants.WALLPAPER_PATH);

        ImageView wallpaper = (ImageView) findViewById(R.id.wallpaper);

        Bitmap myBitmap = BitmapFactory.decodeFile(path);
        wallpaper.setImageBitmap(myBitmap);

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
        return getString(R.string.wallpaperTitle);
    }

}
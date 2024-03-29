package com.Wonderland.main;

import android.os.Bundle;

import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * MainActivity
 */
public class MainActivity extends MyActivity {


    private Singleton singleton = Singleton.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        MyImageView myImageView = (MyImageView) findViewById(R.id.home);
        myImageView.setMyOnTouchEvent(new MyImageView.MyOnTouchEvent() {
            @Override
            public void position(int x, int y) {
                findButtonPressed(x, y);
            }
        });

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config);
    }


    /**
     * This is the method called from the onTouchListener on the background menu.
     * It has to open the correct activity for every menu entry touched
     *
     * @param x, int - x coordinate
     * @param y, int - y coordinate
     */
    private void findButtonPressed(int x, int y) {

        if (Helper.testPointInPolygon(x, y, singleton.getStory()))
            Helper.startMenuActivity(this, R.string.story);
        else if (Helper.testPointInPolygon(x, y, singleton.getCharacters()))
            Helper.startActivity(this, CharacterMenuActivity.class);
        else if (Helper.testPointInPolygon(x, y, singleton.getExtras()))
            Helper.startMenuActivity(this, R.string.extras);
        else if (Helper.testPointInPolygon(x, y, singleton.getShop()))
            Helper.startMenuActivity(this, R.string.shop);
    }


    @Override
    public String getActivityTitle() {
        return null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

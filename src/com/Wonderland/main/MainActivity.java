package com.Wonderland.main;

import android.os.Bundle;

import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;

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
        myImageView.setUp(Constants.BACKGROUND_SIZE);
        myImageView.setMyOnTouchEvent(new MyImageView.MyOnTouchEvent() {
            @Override
            public void position(int x, int y) {
                findButtonPressed(x, y);
            }
        });
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
            Helper.showLazyAlertDialog(this);
    }


    @Override
    public String getActivityTitle() {
        return null;
    }

    @Override
    public Class getPreviousActivity() {
        return null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

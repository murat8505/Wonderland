package com.Wonderland.main;

import android.content.Intent;
import android.os.Bundle;

import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;

/**
 * Created by marco on 19/04/14.
 * <p/>
 * Common Activity for (almost all) menus
 */
public class MenuActivity extends MyActivity {

    /**
     *
     */
    private Class[] options;
    private Singleton singleton = Singleton.getInstance();

    private int title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        // get the value to know which menu open
        Intent intent = getIntent();
        title = intent.getIntExtra(Constants.TITLE, 0);

        options = Constants.MENU_OPTIONS.get(title);


        MyImageView myImageView = (MyImageView) findViewById(R.id.menuImageView);
        myImageView.setImageResource(Constants.MENU_BACKGROUND.get(title));
        myImageView.setMyOnTouchEvent(new MyImageView.MyOnTouchEvent() {
            @Override
            public void position(int x, int y) {
                findButtonPressed(x, y);
            }
        });

    }

    /**
     * Find which menu option is pressed and start the correct action
     *
     * @param x, int - x coordinate
     * @param y, int - y coordinate
     */
    private void findButtonPressed(int x, int y) {

        for (int i = 0; i < 3; i++)
            if (Helper.testPointInPolygon(x, y, singleton.getMenuOptions()[i])) {
                Helper.startActivity(this, options[i]);
                break;
            }
    }

    @Override
    public String getActivityTitle() {
        return getString(title);
    }

    @Override
    public Class getPreviousActivity() {
        return MainActivity.class;
    }
}

package com.Wonderland.main;

import android.os.Bundle;

import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;
import com.Wonderland.polygon.Polygon;

/**
 * Created by marco on 30/05/14.
 *
 * This Activity shows all the locations and bind every characters to it
 */
public class CharacterMenuActivity extends MyActivity {

    /**
     * Locations image, {@link com.Wonderland.graphicObjects.MyImageView}
     */
    private MyImageView locations;

    /**
     * Array of all the locations
     */
    private Polygon[] locationsP = Singleton.getInstance().getLocations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_menu);

        locations = (MyImageView) findViewById(R.id.locations);
        locations.setSize(Constants.LOCATION_BACKGROUND_SIZE);
        locations.setMyOnTouchEvent(new MyImageView.MyOnTouchEvent() {
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

        for (int i = 0; i < locationsP.length; i++)
            if (Helper.testPointInPolygon(x, y, locationsP[i])) {
                showMenu(Constants.LOCATION_ICON_BINDING[i]);
                break;
            }

    }

    /**
     * Show the pop-up menu with the corrects characters
     *
     * @param list
     */
    private void showMenu(int[] list) {
        Constants.CHARACTERS[list[0]].startApplication(this);
    }

    @Override
    public String getActivityTitle() {
        return null;
    }

    @Override
    public Class getPreviousActivity() {
        return MainActivity.class;
    }
}

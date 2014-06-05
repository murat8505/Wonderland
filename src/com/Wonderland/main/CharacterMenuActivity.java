package com.Wonderland.main;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.Wonderland.graphicObjects.CharacterArrayAdapter;
import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;
import com.Wonderland.polygon.Polygon;

/**
 * Created by marco on 30/05/14.
 * <p/>
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

    /**
     * ArrayAdapter of the ListView that show the characters found in every place
     */
    private CharacterArrayAdapter arrayAdapter;

    /**
     * ListView of the icons
     */
    private ListView listView;

    private MyImageView.MyOnTouchEvent event = new MyImageView.MyOnTouchEvent() {

        @Override
        public void position(int x, int y) {
            findButtonPressed(x, y);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_menu);

        locations = (MyImageView) findViewById(R.id.locations);
        locations.setSize(Constants.LOCATION_BACKGROUND_SIZE);
        locations.setMyOnTouchEvent(event);
        prepareListView();
    }

    /**
     * Initialize the ListView and the ArrayAdapter with an empty array.
     * Also set the onItemClickListener to open the correct activity
     */
    private void prepareListView() {

        arrayAdapter = new CharacterArrayAdapter(this, R.layout.characters_listview_row);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        listView.setDivider(getResources().getDrawable(R.drawable.listview_divider));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayAdapter.getItem(i).startApplication(activity);
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
     * @param list int[], list of ids of the corresponding Characters objects.
     *             {@link com.Wonderland.helpers.Constants#CHARACTERS},
     *             {@link com.Wonderland.helpers.Constants#LOCATION_ICON_BINDING}
     */
    private void showMenu(int[] list) {


        if (list.length > 4) {
            ViewGroup.LayoutParams l = listView.getLayoutParams();
            int height = (int) (4.5 * getResources().getDimension(R.dimen.icon_row));
            l.height = height;
        }


        for (int i = 0; i < list.length; i++)
            arrayAdapter.add(Constants.CHARACTERS[list[i]]);

        arrayAdapter.notifyDataSetChanged();

        locations.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent e) {

                // clear the arrayAdapter and restore the touchEvent
                resetListView();
                locations.setMyOnTouchEvent(event);

                return false;
            }
        });
    }

    private void resetListView() {
        arrayAdapter.clear();
        ViewGroup.LayoutParams l = listView.getLayoutParams();
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        l.height = height;
    }

    @Override
    public String getActivityTitle() {
        return null;
    }

    @Override
    public void onBackPressed() {
        resetListView();
    }
}

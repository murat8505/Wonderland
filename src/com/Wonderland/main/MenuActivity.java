package com.Wonderland.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.Singleton;

/**
 * Created by marco on 19/04/14.
 * <p/>
 * Common Activity for (almost all) menus
 */
public class MenuActivity extends Activity {

    /**
     *
     */
    private Class[] options;
    private Singleton singleton = Singleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        // get the value to know which menu open
        Intent intent = getIntent();
        int title = intent.getIntExtra(Constants.TITLE, 0);

        options = Constants.MENU_OPTIONS.get(title);


        final Activity menu = this;

        GroupActionBar groupActionBar = (GroupActionBar) findViewById(R.id.menuActionBar);
        groupActionBar.setText(title);
        groupActionBar.setBackButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(menu, MainActivity.class);
            }
        });


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
    public void onBackPressed() {
        // do nothing;
    }

}

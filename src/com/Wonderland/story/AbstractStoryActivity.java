package com.Wonderland.story;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.graphicObjects.MyTabWidget;
import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * This is the Story activity. It's used form all the activities of the "Story" menu
 */
public abstract class AbstractStoryActivity extends FragmentActivity {

    protected MyTabWidget myTabWidget;
    protected GroupActionBar groupActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        final Activity story = this;

        // Set the "back to menu" button
        groupActionBar = (GroupActionBar) findViewById(R.id.menuActionBar);
        groupActionBar.setText(getSectionTitle());
        groupActionBar.setBackButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startMenuActivity(story, R.string.story);
            }
        });

        myTabWidget = (MyTabWidget) findViewById(R.id.tabwidget);

        setData();

        myTabWidget.setButtons();
    }

    /**
     * Set the data in the TabWidget, number of pages, contents, ecc
     */
    public abstract void setData();

    /**
     * Return the Title of the section. Used to set the title in the bar
     *
     * @return String - the title of the section
     */
    public abstract int getSectionTitle();
}

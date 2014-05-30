package com.Wonderland.helpers;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.main.R;

/**
 * Created by marco on 30/05/14.
 * <p/>
 * Base activity, implemets some useful methods and fields
 */
public abstract class MyActivity extends Activity {

    /**
     * This activity
     */
    public Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // fix screen orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Set the title and the back button listener for the action bar
        GroupActionBar groupActionBar = (GroupActionBar) findViewById(R.id.menuActionBar);
        groupActionBar.setText(getActivityTitle());

        groupActionBar.setBackButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(activity, getPreviousActivity());
            }
        });
    }

    /**
     * @return String, the title the activity if exist or is not set, null otherwise.
     * {@link com.Wonderland.graphicObjects.GroupActionBar#setText(int)}
     */
    public abstract String getActivityTitle();

    /**
     * @return class, the activity to which return, or null if it isn't.
     * {@link com.Wonderland.graphicObjects.GroupActionBar#setOnClickListener(android.view.View.OnClickListener)}
     */
    public abstract Class getPreviousActivity();

    @Override
    public void onBackPressed() {
        //Do nothing
    }
}

package com.Wonderland.helpers;

import android.app.Activity;
import android.view.View;

import com.Wonderland.graphicObjects.GroupActionBar;
import com.Wonderland.main.R;

/**
 * Created by marco on 30/05/14.
 */
public abstract class MyActivity extends Activity {

    public Activity activity = this;


    @Override
    protected void onStart() {
        super.onStart();

        GroupActionBar groupActionBar = (GroupActionBar) findViewById(R.id.menuActionBar);
        groupActionBar.setText(getActivityTitle());

        groupActionBar.setBackButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(activity, getPreviousActivity());
            }
        });
    }

    public abstract String getActivityTitle();

    public abstract Class getPreviousActivity();

    @Override
    public void onBackPressed() {
        //Do nothing
    }
}

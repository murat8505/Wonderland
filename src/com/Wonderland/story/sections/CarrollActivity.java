package com.Wonderland.story.sections;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.story.AbstractStoryActivity;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Carroll section
 */
public class CarrollActivity extends AbstractStoryActivity {

    @Override
    public void setData() {
        myTabWidget.addTab(R.string.carroll_title, Constants.CARROLL_1, R.drawable.carroll_1);
        myTabWidget.addTab(0, Constants.CARROLL_2, R.drawable.carroll_2);
        myTabWidget.addTab(0, Constants.CARROLL_3, R.drawable.carroll_3);
    }

    @Override
    public int getSectionTitle() {
        return R.string.carroll;
    }
}

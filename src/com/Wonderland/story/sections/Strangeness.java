package com.Wonderland.story.sections;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.story.AbstractStoryActivity;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Strangeness section
 */
public class Strangeness extends AbstractStoryActivity {

    @Override
    public void setData() {
        myTabWidget.addTab(R.string.strangeness_title, Constants.curiosity_1, R.drawable.curiosity_1);
        myTabWidget.addTab(0, Constants.curiosity_2, R.drawable.curiosity_2);
        myTabWidget.addTab(0, Constants.curiosity_3, R.drawable.curiosity_3);
    }

    @Override
    public int getSectionTitle() {
        return R.string.strangeness;
    }
}

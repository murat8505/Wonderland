package com.Wonderland.story.sections;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.story.AbstractStoryActivity;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Plot section
 */
public class Plot extends AbstractStoryActivity {

    @Override
    public void setData() {
        myTabWidget.addTab(R.string.plot_title, Constants.PLOT_1, R.drawable.plot_1);
        myTabWidget.addTab(0, Constants.PLOT_2, R.drawable.plot_2);
        myTabWidget.addTab(0, Constants.PLOT_3, R.drawable.plot_3);
    }

    @Override
    public int getSectionTitle() {
        return R.string.plot;
    }
}

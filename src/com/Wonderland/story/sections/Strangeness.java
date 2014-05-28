package com.Wonderland.story.sections;

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
        myTabWidget.addTab(R.string.strangeness_title, R.string.story_text_1, R.drawable.personaggio_plot1);
        myTabWidget.addTab(0, R.string.story_text_2, R.drawable.personaggio_plot1);
        myTabWidget.addTab(0, R.string.story_text_1, R.drawable.personaggio_plot1);
    }

    @Override
    public int getSectionTitle() {
        return R.string.strangeness;
    }
}

package com.Wonderland.graphicObjects;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.story.Page;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Tabwidget with Intents.
 * Customized to use buttons to navigate instead of tabhosts
 */
public class MyTabWidget extends LinearLayout {

    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
    Intent intent;  // Reusable Intent for each tab
    int tabCounter = 0;
    int currentTab = 0;
    private Context context;
    private FragmentTabHost tabHost;
    private Button forward, backward;

    public MyTabWidget(Context context) {
        super(context);
        init(context);
    }

    public MyTabWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyTabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_tabwidget, this, true);

        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        tabHost.setup(context, ((FragmentActivity) context).getSupportFragmentManager(), R.id.tabFrameLayout);
        tabHost.getTabWidget().setVisibility(GONE);

        forward = (Button) findViewById(R.id.forward);
        backward = (Button) findViewById(R.id.backward);
    }

    /**
     * Method to add tabs
     *
     * @param title, int - id of the title. if 0 it will not be displayed
     * @param text,  int - id of the text
     * @param image, int - id of the resource image
     */
    public void addTab(int title, int text, int image) {

        spec = tabHost.newTabSpec("tab" + tabCounter).setIndicator("tab" + tabCounter);
        tabCounter++;

        Bundle bundle = new Bundle();
        bundle.putInt(Constants.TITLE, title);
        bundle.putInt(Constants.IMAGE, image);
        bundle.putInt(Constants.TEXT, text);

        tabHost.addTab(spec, Page.class, bundle);

        tabHost.setCurrentTab(0);
        backward.setVisibility(INVISIBLE);
    }

    /**
     * Initialize navigation buttons of the tabhost
     */
    public void setButtons() {

        forward.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTab++;
                tabHost.setCurrentTab(currentTab);

                if (currentTab + 1 >= tabCounter)
                    forward.setVisibility(INVISIBLE);
                backward.setVisibility(VISIBLE);
            }
        });

        backward.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTab--;
                tabHost.setCurrentTab(currentTab);

                if (currentTab == 0)
                    backward.setVisibility(INVISIBLE);

                forward.setVisibility(VISIBLE);
            }
        });


    }

    public Button getForwardButton() {
        return forward;
    }

    public Button getBackwardButton() {
        return backward;
    }

    public TabHost getTabHost() {
        return (TabHost) findViewById(R.id.tabhost);
    }
}
package com.Wonderland.graphicObjects;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;

/**
 * Created by marco on 17/04/14.
 * <p/>
 * Custom back menu button
 */
public class BackMenuButton extends RelativeLayout {


    public BackMenuButton(Context context) {
        super(context);
        init(context);
    }

    public BackMenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BackMenuButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.back_menu_button, this, true);
    }


    /**
     * Set to show the text "W" or not
     *
     * @param show
     */
    public void showText(boolean show) {
        findViewById(R.id.menuBackText).setVisibility(Helper.getVisibility(show));
    }

}

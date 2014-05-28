package com.Wonderland.graphicObjects;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;

/**
 * Created by marco on 17/04/14.
 * <p/>
 * Upper bar menu, with title and back buttons
 */
public class GroupActionBar extends LinearLayout {

    private Context context;

    public GroupActionBar(Context context) {
        super(context);
        initialize(context, null);
    }

    public GroupActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public GroupActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initialize(Context context, AttributeSet attrs) {
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.group_action_bar, this, true);

        setText(R.string.app_name);
        showBackButton(false);


        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.GroupActionBar,
                    0, 0);
            try {
                String mText = a.getString(R.styleable.GroupActionBar_setText);
                setText(mText);

                boolean showBackButton = a.getBoolean(R.styleable.GroupActionBar_showBackButton, false);
                showBackButton(showBackButton);

                boolean showBackButtonText = a.getBoolean(R.styleable.GroupActionBar_showBackButtonText, false);
                showBackButtonText(showBackButtonText);

            } finally {
                a.recycle();
            }
        }
    }

    /**
     * Set title
     *
     * @param title, String
     */
    public void setText(String title) {
        ((TextView) this.findViewById(R.id.title)).setText(title);
    }

    /**
     * Set title
     *
     * @param id, int - id of resource
     */
    public void setText(int id) {
        ((TextView) this.findViewById(R.id.title)).setText(id);
    }

    /**
     * Show back button
     *
     * @param show, boolean
     */
    public void showBackButton(boolean show) {
        findViewById(R.id.group_back).setVisibility(Helper.getVisibility(show));
    }

    /**
     * Show the "W" in the back button
     *
     * @param show, boolean
     */
    public void showBackButtonText(boolean show) {
        ((BackMenuButton) findViewById(R.id.group_back)).showText(show);
    }

    /**
     * Set the listener in the back button
     *
     * @param onClickListener, OnClickListener
     */
    public void setBackButtonOnClickListener(OnClickListener onClickListener) {
        ((BackMenuButton) findViewById(R.id.group_back)).setOnClickListener(onClickListener);
    }

}
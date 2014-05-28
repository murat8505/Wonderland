package com.Wonderland.graphicObjects;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.Wonderland.helpers.Singleton;

import java.io.File;

/**
 * Created by marco on 17/04/14.
 * <p/>
 * Uses Pharmacy Font and if the text is too long for the textView it continually
 * do an horizontal scrolling
 */
public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
        initialize(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    private void initialize(Context context) {
        this.setTypeface(Singleton.getInstance().getPharmacyFont(context));

        this.setSingleLine();
        this.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.setMarqueeRepeatLimit(-1);
        this.setHorizontallyScrolling(true);
        this.setGravity(Gravity.CENTER);
    }

    /**
     * Set the file name extracted from File object.
     * Perform some additional operations like remove extension, sequence number ("01 filename"), and replacing "_" with "/"
     *
     * @param file File
     */
    public void setFileName(File file) {

        String name = file.getName();

        int extension = name.lastIndexOf(".");

        if (extension > -1)
            name = name.substring(0, extension);

        name = name.substring(3).replace("_", "/");

        setText(name);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

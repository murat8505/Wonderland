package com.Wonderland.helpers;

import android.graphics.Point;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * Used to flow the text around an image
 */
public class FlowTextHelper {

    private static boolean mNewClassAvailable;

    public static void tryFlowText(String text, View thumbnailView, TextView messageView, Display display) {
        // There is nothing I can do for older versions, so just return
        if (!mNewClassAvailable) return;

        Point displaysize = new Point();
        display.getRealSize(displaysize);

        // Get height and width of the image and height of the text line
        thumbnailView.measure(displaysize.x, displaysize.y);
        int height = thumbnailView.getMeasuredHeight();
        int width = thumbnailView.getMeasuredWidth();
        float textLineHeight = messageView.getPaint().getTextSize();

        // Set the span according to the number of lines and width of the image
        // the "2" is indicative, I've found out it's better
        int lines = (int) Math.round(height / textLineHeight) - 2;
        //For an html text you can use this line: SpannableStringBuilder ss = (SpannableStringBuilder)Html.fromHtml(text);
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new MyLeadingMarginSpan2(lines, width), 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        messageView.setText(ss);

        // Align the text with the image by removing the rule that the text is to the right of the image
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) messageView.getLayoutParams();
        int[] rules = params.getRules();
        rules[RelativeLayout.RIGHT_OF] = 0;
    }
}

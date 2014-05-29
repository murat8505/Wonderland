package com.Wonderland.story;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Wonderland.graphicObjects.MyTextView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.FlowTextHelper;
import com.Wonderland.main.R;

/**
 * Created by marco on 18/04/14.
 * <p/>
 * This is the content of the Tabwidget
 */
public class Page extends Fragment {

    /**
     * Resource of the image of the page to show
     */
    private int image;

    /**
     * String of the text to show in the frame
     */
    private String text;

    /**
     * Resource of the title of the frame
     */
    private int title;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // recover the arguments from the intent
        Bundle sender = getArguments();
        image = sender.getInt(Constants.IMAGE, 0);
        text = sender.getString(Constants.TEXT);
        title = sender.getInt(Constants.TITLE, 0);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.page, container, false);

        ImageView imageView = (ImageView) v.findViewById(R.id.image);
        imageView.setImageResource(image);

        TextView textView = (TextView) v.findViewById(R.id.message_view);


        Display display = getActivity().getWindowManager().getDefaultDisplay();
        FlowTextHelper.tryFlowText(text, imageView, textView, display);


        MyTextView myTextView = (MyTextView) v.findViewById(R.id.pageTitle);

        // set the title or remove it
        if (title != 0)
            myTextView.setText(title);
        else
            myTextView.setVisibility(View.GONE);

        return v;
    }


}

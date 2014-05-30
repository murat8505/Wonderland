package com.Wonderland.graphicObjects.icons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;

/**
 * Created by marco on 29/05/14.
 */
public class IconBar extends LinearLayout {

    private Context context;

    private Button up, down;

    private ListView listView;


    public IconBar(Context context) {
        super(context);
        initialize(context);
    }

    public IconBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public IconBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    private void initialize(Context context) {
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.icon_list, this, true);

        up = (Button) findViewById(R.id.buttonUp);
        down = (Button) findViewById(R.id.buttonDown);

        listView = (ListView) findViewById(R.id.iconListView);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = listView.getFirstVisiblePosition();

                if (position > 0)
                    executeScroll(position - 1);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = listView.getLastVisiblePosition();

                int all = listView.getAdapter().getCount();

                if (position < all)
                    executeScroll(listView.getFirstVisiblePosition() + 1);
            }
        });
    }

    private void executeScroll(final int position) {
        listView.post(new Runnable() {
            public void run() {
                listView.setSelection(position);
            }
        });
    }

    public void navigateTo(int position) {
        listView.smoothScrollToPosition(position);
    }


    public void setOnClickListener(IconAdapter.OnClickListener l) {
        IconAdapter adapter = new IconAdapter(context, 0, Constants.CHARACTERS);
        adapter.setOnClickListener(l);
        listView.setAdapter(adapter);
    }

    public void setSelected(int position) {
        executeScroll(position);
    }
}

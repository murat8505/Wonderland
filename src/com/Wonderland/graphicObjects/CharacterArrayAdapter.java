package com.Wonderland.graphicObjects;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Wonderland.characters.Character;
import com.Wonderland.main.R;

import java.util.List;

/**
 * Created by marco on 30/05/14.
 *
 * This ArrayAdapter is build to center the longest object horizontally, and align all other
 * objects to this.
 */
public class CharacterArrayAdapter extends MyArrayAdapter<Character> {

    /**
     * Margin left
     */
    private int marginLeft = 0;

    public CharacterArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CharacterArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    protected MyHolder initializeHolder(View row) {
        MyHolder holder = new MyHolder();
        holder.icon = (ImageView) row.findViewById(R.id.icon);
        holder.name = (TextView) row.findViewById(R.id.name);

        return holder;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        MyHolder holder = null;

        if (row == null) {
            row = inflateRow(parent);
            holder = initializeHolder(row);
            row.setTag(holder);

        } else
            holder = (MyHolder) row.getTag();

        Character object = getItem(position);
        updateHolder(object, holder);


        // Update the margin left of every row to align to the longest object
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(holder.icon.getLayoutParams());
        params.setMargins(marginLeft, 0, 0, 0);
        holder.icon.setLayoutParams(params);

        return row;
    }

    @Override
    protected void updateHolder(Character object, Holder holder) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.name.setText(object.getName());
        myHolder.icon.setImageDrawable(object.getDrawableIcon(context));
    }

    static class MyHolder extends Holder {
        ImageView icon;
        TextView name;
    }

    /**
     * Method to calculate the left margin of the object to center the longest
     */
    private void calculateLeftMargin() {

        // reset the left margin
        marginLeft = 0;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // lenght of the screen
        int width = size.x;
        int height = context.getResources().getDimensionPixelSize(R.dimen.icon_row);

        LinearLayout linearLayout = new LinearLayout(context);
        View row = inflateRow(linearLayout);

        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        TextView name = (TextView) row.findViewById(R.id.name);

        // max length of the object
        int maxLength = 0;

        for (int i = 0; i < getCount(); i++) {

            Character c = getItem(i);

            icon.setImageDrawable(c.getDrawableImage(context));
            name.setText(c.getName());

            row.measure(width, height);

            int max = icon.getMeasuredWidth() + name.getMeasuredWidth();

            if (maxLength < max)
                maxLength = max;
        }

        // margin left to center the longest object
        marginLeft = (width - maxLength) / 2;
    }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();

        calculateLeftMargin();
    }
}


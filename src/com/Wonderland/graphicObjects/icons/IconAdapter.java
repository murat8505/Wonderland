package com.Wonderland.graphicObjects.icons;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.Wonderland.characters.Character;

/**
 * Created by marco on 29/05/14.
 * <p/>
 * Adapter to show character's icons in a listview
 */
public class IconAdapter extends ArrayAdapter<com.Wonderland.characters.Character> {

    private Context context;

    /**
     * Array of Characters objects {@link com.Wonderland.characters.Character}
     */
    private Character[] characters;

    /**
     * OnclickListener called on click of an icon
     */
    private OnClickListener onClickListener;

    public IconAdapter(Context context, int resource, Character[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.characters = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            ImageView imageView = new ImageView(context);
            row = imageView;
        }

        ImageView imageView = (ImageView) row;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(characters[position]);
            }
        });

        imageView.setImageDrawable(characters[position].getDrawableIcon(context));
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        return row;
    }

    /**
     * Set OnclickListener
     *
     * @param onClickListener {@link com.Wonderland.graphicObjects.icons.IconAdapter.OnClickListener}
     */
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    /**
     * OnclickListener interface for {@link com.Wonderland.graphicObjects.icons.IconAdapter}
     */
    public interface OnClickListener {

        /**
         * Called on click event
         *
         * @param character {@link com.Wonderland.characters.Character}
         */
        public void onClick(Character character);
    }
}

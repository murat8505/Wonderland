package com.Wonderland.graphicObjects.icons;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.Wonderland.characters.Character;

/**
 * Created by marco on 29/05/14.
 */
public class IconAdapter extends ArrayAdapter<com.Wonderland.characters.Character> {

    private Context context;

    private Character[] characters;
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

        imageView.setImageDrawable(characters[position].getDrawableId(context));
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        return row;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        public void onClick(Character character);
    }
}

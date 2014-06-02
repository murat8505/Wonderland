package com.Wonderland.graphicObjects;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Wonderland.characters.Character;
import com.Wonderland.main.R;

import java.util.List;

/**
 * Created by marco on 30/05/14.
 */
public class CharacterArrayAdapter extends MyArrayAdapter<Character> {

    public CharacterArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CharacterArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    protected Holder initializeHolder(View row) {
        MyHolder holder = new MyHolder();
        holder.icon = (ImageView) row.findViewById(R.id.icon);
        holder.name = (TextView) row.findViewById(R.id.name);

        return holder;
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
}


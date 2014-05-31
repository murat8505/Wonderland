package com.Wonderland.graphicObjects;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Wonderland.characters.Character;
import com.Wonderland.main.R;

import java.util.ArrayList;

/**
 * Created by marco on 30/05/14.
 */
public class CharacterArrayAdapter extends ArrayAdapter<com.Wonderland.characters.Character> {

    private Context context;
    private int resource;
    private ArrayList<Character> characters = new ArrayList<Character>();


    public CharacterArrayAdapter(Context context, int resource) {
        super(context, resource);
        initialize(context, resource);
    }

    private void initialize(Context context, int resource) {

        this.context = context;
        this.resource = resource;
    }

    @Override
    public synchronized void add(Character object) {
        characters.add(object);
    }

    @Override
    public synchronized void clear() {
        characters.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Character getItem(int position) {
        return characters.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        Holder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder = new Holder();
            holder.icon = (ImageView) row.findViewById(R.id.icon);
            holder.name = (TextView) row.findViewById(R.id.name);

            row.setTag(holder);
        } else
            holder = (Holder) row.getTag();

        Character character = characters.get(position);
        holder.name.setText(character.getName());
        holder.icon.setImageDrawable(character.getDrawableIcon(context));

        return row;
    }

    /**
     * Static class, is used as cache of the ImageView and TextView to improve performance
     */
    static class Holder {

        ImageView icon;
        TextView name;
    }
}
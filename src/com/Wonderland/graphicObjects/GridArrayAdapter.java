package com.Wonderland.graphicObjects;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.Wonderland.main.R;

import java.io.File;
import java.util.List;

/**
 * Created by marco on 19/04/14.
 * <p/>
 * A Grid array used to show mp3, video or wallpapers
 */
public class GridArrayAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private List<File> objects;


    public GridArrayAdapter(Context context, int resource, List<File> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
        }

        File object = objects.get(position);

        MyTextView myTextView = (MyTextView) row.findViewById(R.id.title);
        myTextView.setFileName(object);
        myTextView.setSelected(true);

        return row;
    }
}

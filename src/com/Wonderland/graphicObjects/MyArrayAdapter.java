package com.Wonderland.graphicObjects;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 02/06/14.
 * <p/>
 * Base Object for all arrayAdapters
 */
public abstract class MyArrayAdapter<T> extends ArrayAdapter<T> {

    /**
     * List of object to be displayed
     */
    private List<T> list = new ArrayList<T>();

    /**
     * Context
     */
    protected Context context;

    /**
     * Id of the view to be shown
     */
    private int resource;

    public MyArrayAdapter(Context context, int resource) {
        super(context, resource);
        initialize(context, resource);
    }

    public MyArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        initialize(context, resource);
        this.list = objects;
    }

    /**
     * Initialize the variables
     *
     * @param context  Context
     * @param resource int - id of the layout
     */
    private void initialize(Context context, int resource) {
        this.context = context;
        this.resource = resource;
    }

    @Override
    public synchronized void add(T object) {
        list.add(object);
    }

    @Override
    public synchronized void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        Holder holder = null;

        if (row == null) {
            row = inflateRow(parent);
            holder = initializeHolder(row);
            row.setTag(holder);

        } else
            holder = (Holder) row.getTag();

        T object = getItem(position);
        updateHolder(object, holder);

        return row;
    }

    /**
     * Create and return a new View inflating the layout.
     * If you have to create the view "row" in another way override this method.
     *
     * @param parent ViewGroup - parent of "row"
     * @return View
     */
    protected View inflateRow(ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(resource, parent, false);
        return row;
    }

    /**
     * Initialize the holder object and return it.
     * <p/>
     * Ex: if we have created a new innerClass defined: <pre>static class MyHolder extends Holder</pre>
     * <p/>
     * the code will be
     * <p/>
     * <pre>
     *     {@code
     *
     *   MyHolder holder = new MyHolder();
     *   holder.icon = (ImageView) row.findViewById(R.id.icon);
     *   holder.name = (TextView) row.findViewById(R.id.name);
     *   return holder;
     *     }
     * </pre>
     *
     * @param row View
     * @return Holder
     */
    protected abstract Holder initializeHolder(View row);

    /**
     * Update the values of the holder (and consequentially of the view).
     * <p/>
     * Ex: if we have created a new innerClass defined: <pre>static class MyHolder extends Holder</pre>
     * <p/>
     * the code will be
     * <p/>
     * <pre>
     *     {@code
     *
     *   MyHolder myHolder = (MyHolder) holder;
     *   myHolder.name.setText(object.getName());
     *   myHolder.icon.setImageDrawable(object.getDrawableIcon(context));
     *     }
     * </pre>
     *
     * @param object T - the object to be shown in the view
     * @param holder Holder
     * @return Holder
     */
    protected abstract void updateHolder(T object, Holder holder);


    /**
     * Static class, is used as cache of the view to improve performance.
     * <p/>
     * In the class that extends this arrayAdapter, you have to create another static inner class
     * that extends this one.
     * Here you have to put only the TextView, ImageView, ecc... that you have to set in the layout.
     * <p/>
     * <p/>
     * -- Ex: if your resource layout has one TextView and one ImageView the class will be:
     * <p/>
     * <pre>
     * {@code
     *
     * static class MyHolder extends Holder {
     *  ImageView icon;
     *  TextView name;
     * }
     * }
     * </pre>
     */
    abstract static class Holder {
    }

}

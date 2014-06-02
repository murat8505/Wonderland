package com.Wonderland.graphicObjects;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.Wonderland.characters.Character;
import com.Wonderland.main.R;

import java.util.List;

/**
 * Created by marco on 29/05/14.
 * <p/>
 * Adapter to show character's icons in a listView
 */
public class IconAdapter extends MyArrayAdapter<Character> {

    /**
     * OnclickListener called on click of an icon
     */
    private OnClickListener onClickListener;

    public IconAdapter(Context context, int resource) {
        super(context, resource);
    }

    public IconAdapter(Context context, int resource, List<Character> objects) {
        super(context, resource, objects);
    }

    public IconAdapter(Context context, int resource, Character[] objects) {
        super(context, resource);

        for (Character c : objects)
            add(c);
    }

    @Override
    protected Holder initializeHolder(View row) {

        MyHolder holder = new MyHolder();
        holder.icon = (ImageView) row.findViewById(R.id.icon);
        return holder;
    }

    @Override
    protected void updateHolder(final Character object, Holder holder) {

        final MyHolder myHolder = (MyHolder) holder;
        myHolder.icon.setImageDrawable(object.getDrawableIcon(context));

        myHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(object);
            }
        });
    }


    /**
     * Set OnclickListener
     *
     * @param onClickListener {@link com.Wonderland.graphicObjects.IconAdapter.OnClickListener}
     */
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    /**
     * OnclickListener interface for {@link com.Wonderland.graphicObjects.IconAdapter}
     */
    public interface OnClickListener {

        /**
         * Called on click event
         *
         * @param character {@link com.Wonderland.characters.Character}
         */
        public void onClick(Character character);
    }

    static class MyHolder extends Holder {
        ImageView icon;
    }
}

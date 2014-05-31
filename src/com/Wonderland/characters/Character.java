package com.Wonderland.characters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.Wonderland.helpers.Constants;

/**
 * Created by marco on 29/05/14.
 */
public class Character {

    /**
     * Mantain trace of the position in the
     */
    private int position;

    /**
     * Id of the drawable small icon
     */
    private int drawableId;

    /**
     * Text will be show up in the activity
     */
    private String text;

    /**
     * Name of the character
     */
    private String Name;

    /**
     * Image that will be shown in the activity
     */
    private int drawableImage;


    public Character(int position, int drawableId, String text, String name, int drawableImage) {
        this.drawableId = drawableId;
        this.text = text;
        Name = name;
        this.drawableImage = drawableImage;
        this.position = position;
    }

    /**
     * Return the drawable corresponding at the id
     *
     * @param context Context
     * @return Drawable
     */
    public Drawable getDrawableIcon(Context context) {
        return context.getResources().getDrawable(drawableId);
    }

    /**
     * @return String, the name of the character
     */
    public String getName() {
        return Name;
    }

    /**
     * @return String, the text description of the character
     */
    public String getText() {
        return text;
    }

    /**
     * Return the position in the Array in {@link com.Wonderland.helpers.Constants#CHARACTERS}
     *
     * @return int
     */
    public int getPosition() {
        return position;
    }

    /**
     * Return the drawable corresponding at the id
     *
     * @param context Context
     * @return Drawable
     */
    public Drawable getDrawableImage(Context context) {
        return context.getResources().getDrawable(drawableImage);
    }

    /**
     * Set the parameters and start the corret application, see {@link com.Wonderland.characters.CharacterActivity}
     *
     * @param context Context
     */
    public void startApplication(Context context) {
        Intent i = new Intent(context, CharacterActivity.class);
        i.putExtra(Constants.ID, position);
        context.startActivity(i);
    }
}

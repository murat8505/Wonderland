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


    public Character(int drawableId, String text, String name, int drawableImage) {
        this.drawableId = drawableId;
        this.text = text;
        Name = name;
        this.drawableImage = drawableImage;
    }


    public Drawable getDrawableId(Context context) {
        return context.getResources().getDrawable(drawableId);
    }

    public String getName() {
        return Name;
    }

    public Drawable getDrawableImage(Context context) {
        return context.getResources().getDrawable(drawableImage);
    }

    public void startApplication(Context context) {

        Intent i = new Intent(context, CharacterActivity.class);
        i.putExtra(Constants.ID, position);
        context.startActivity(i);
    }
}

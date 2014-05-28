package com.Wonderland.helpers;

import android.content.Context;
import android.graphics.Typeface;

import com.Wonderland.polygon.Polygon;

/**
 * Created by marco on 19/04/14.
 * <p/>
 * Maintains some common elements in memory for continue usages
 */
public class Singleton {

    private static Singleton ourInstance = new Singleton();
    /**
     * Font used for every title
     */
    private static Typeface pharmacyFont;
    /**
     * Polygons of the Main menu buttons
     */
    private Polygon story, characters, extras, shop;
    /**
     * polygons of the flasks menu buttons
     */
    private Polygon[] menuOptions;

    private Singleton() {

        // initialize all polygons
        story = Helper.createPolygon(Constants.STORY_COORD);
        characters = Helper.createPolygon(Constants.CHARACTERS_COORD);
        extras = Helper.createPolygon(Constants.EXTRAS_COORD);
        shop = Helper.createPolygon(Constants.SHOP_COORD);


        menuOptions = new Polygon[Constants.MENU_OPTIONS_COORDINATES.length];
        for (int i = 0; i < Constants.MENU_OPTIONS_COORDINATES.length; i++)
            menuOptions[i] = Helper.createPolygon(Constants.MENU_OPTIONS_COORDINATES[i]);

    }

    public static Singleton getInstance() {
        return ourInstance;
    }

    /**
     * Return the PharmacyFont
     *
     * @param context, Context
     * @return Typeface
     */
    public static Typeface getPharmacyFont(Context context) {

        if (pharmacyFont == null)
            pharmacyFont = Typeface.createFromAsset(context.getAssets(), Constants.PHARMACY_FONT);

        return pharmacyFont;
    }

    /**
     * Return Story menu Polygon
     *
     * @return Polygon
     */
    public Polygon getStory() {
        return story;
    }

    /**
     * Return Characters menu Polygon
     *
     * @return Polygon
     */
    public Polygon getCharacters() {
        return characters;
    }

    /**
     * Return Extras menu Polygon
     *
     * @return Polygon
     */
    public Polygon getExtras() {
        return extras;
    }

    /**
     * Return Shop menu Polygon
     *
     * @return Polygon
     */
    public Polygon getShop() {
        return shop;
    }

    /**
     * Return Flasks menu Polygons
     *
     * @return Polygon
     */
    public Polygon[] getMenuOptions() {
        return menuOptions;
    }
}

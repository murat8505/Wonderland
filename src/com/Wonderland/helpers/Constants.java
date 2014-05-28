package com.Wonderland.helpers;

import com.Wonderland.extras.Audio;
import com.Wonderland.main.R;
import com.Wonderland.story.sections.Carroll;
import com.Wonderland.story.sections.Plot;
import com.Wonderland.story.sections.Strangeness;

import java.util.Hashtable;

/**
 * Created by marco on 19/04/14.
 */
public class Constants {

    /**
     * Path of the Fonts in assets
     */
    public static final String PHARMACY_FONT = "fonts/PHARMACY.ttf";

    /**
     * Path of the folder containing audio, video and wallpapers
     */
    public static final String BASE_PATH = "/Wonderland/";

    /**
     * Path of the audio folder
     */
    public static final String AUDIO_PATH = "audio";

    /**
     * extension of audio files
     */
    public static final String AUDIO_EXTENSION = ".m4a";


    /**
     * Path of video folder
     */
    public static final String VIDEO_PATH = "video";

    /**
     * Path of wallpapers
     */
    public static final String WALLPAPER_PATH = "wallpaper";


    public static final String IMAGE = "image";
    public static final String TEXT = "text";
    public static final String TITLE = "title";
    public static final String AUDIO = "audio";
    public static final String VIDEO = "video";


    /**
     * Size in pixels of the background in menu pages.
     * It's needed to obtain corret coordinates during touch
     */
    public static final int[] BACKGROUND_SIZE = {640, 1006};


    /**
     * Main menu, coordinates of the "story" arrow
     */
    public static final int[] STORY_COORD = {162, 202, 335, 129, 324, 199, 178, 260};

    /**
     * Main menu, coordinates of the "characters" arrow
     */
    public static final int[] CHARACTERS_COORD = {262, 416, 534, 172, 528, 262, 298, 466};

    /**
     * Main menu, coordinates of the "extras" arrow
     */
    public static final int[] EXTRAS_COORD = {142, 576, 412, 602, 412, 652, 206, 662};

    /**
     * Main menu, coordinates of the "shop" arrow
     */
    public static final int[] SHOP_COORD = {248, 732, 452, 684, 406, 754, 256, 794};
    /**
     * Hashtable of menu background
     */
    public static final Hashtable<Integer, Integer> MENU_BACKGROUND = new Hashtable<Integer, Integer>() {
        {
            put(R.string.story, R.drawable.story_menu);
            put(R.string.extras, R.drawable.extras_menu);
        }
    };
    /**
     * Flasks menu, coordinates of the first flask on top
     */
    private static final int[] FIRST_MENU = {145, 113, 126, 141, 126, 154, 136, 172, 121, 195, 121, 364, 178, 375, 243, 356, 242, 195, 226, 166, 238, 149, 238, 136, 221, 128, 222, 107, 182, 101};
    /**
     * Flasks menu, coordinates of the first point (top lef corner of the plug) of the second menu
     */
    private static final int[] SECOND_MENU = {464, 390};
    /**
     * Flasks menu, coordinates of the first point (top lef corner of the plug) of the third menu
     */
    private static final int[] THIRD_MENU = {161, 668};
    /**
     * All Flasks menu
     */
    public static final int[][] MENU_OPTIONS_COORDINATES = {FIRST_MENU, buildOtherFlasksMenus(SECOND_MENU), buildOtherFlasksMenus(THIRD_MENU)};
    /**
     * Array of class objects, needed to forward Main menu buttons
     */
    private static final Class[] STORY_OPTIONS = {Plot.class, Carroll.class, Strangeness.class};
    /**
     * Array of class objects, needed to forward Extras menu buttons
     */
    private static final Class[] EXTRAS_OPTIONS = {Plot.class, Audio.class, Strangeness.class};
    /**
     * Hashtable of menu menu options
     */
    public static final Hashtable<Integer, Class<?>[]> MENU_OPTIONS = new Hashtable<Integer, Class<?>[]>() {
        {
            put(R.string.story, STORY_OPTIONS);
            put(R.string.extras, EXTRAS_OPTIONS);
        }
    };

    /**
     * Translate the coordinates of the first flask menu to obtain the other two
     *
     * @param firstPoint, int[]
     * @return int[] of coordinates
     */
    public static int[] buildOtherFlasksMenus(int[] firstPoint) {

        int delta_x = firstPoint[0] - FIRST_MENU[0];
        int delta_y = firstPoint[1] - FIRST_MENU[1];

        int[] out = new int[FIRST_MENU.length];

        for (int i = 0; i < FIRST_MENU.length; i += 2) {
            out[i] = FIRST_MENU[i] + delta_x;
            out[i + 1] = FIRST_MENU[i + 1] + delta_y;
        }

        return out;
    }
}

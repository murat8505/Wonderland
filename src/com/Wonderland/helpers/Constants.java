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
    public static final int[] BACKGROUND_SIZE = {480, 703};


    /**
     * Main menu, coordinates of the "story" arrow
     */
    public static final int[] STORY_COORD = {120, 105, 250, 55, 245, 112, 136, 160};

    /**
     * Main menu, coordinates of the "characters" arrow
     */
    public static final int[] CHARACTERS_COORD = {194, 269, 398, 89, 388, 126, 395, 156, 222, 309};

    /**
     * Main menu, coordinates of the "extras" arrow
     */
    public static final int[] EXTRAS_COORD = {105, 388, 307, 409, 306, 445, 158, 450};

    /**
     * Main menu, coordinates of the "shop" arrow
     */
    public static final int[] SHOP_COORD = {186, 503, 339, 470, 329, 487, 314, 493, 304, 521, 192, 549};

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
    private static final int[] FIRST_MENU = {114, 61, 142, 51, 167, 59, 169, 73, 177, 76, 181, 80, 177, 92, 171, 96, 174, 111, 183, 117, 184, 231, 139, 238, 98, 232, 100, 115, 110, 102, 103, 88, 103, 80, 112, 74};
    /**
     * Flasks menu, coordinates of the first point (top lef corner of the plug) of the second menu
     */
    private static final int[] SECOND_MENU = {329, 266};
    /**
     * Flasks menu, coordinates of the first point (top lef corner of the plug) of the third menu
     */
    private static final int[] THIRD_MENU = {114, 468};
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
     * Hashtable of menu options
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


    /**
     * Plot text
     * <p/>
     * WARNING!!! Text with /n or other shortcut will not work. Need tests
     */

    public static final String plot_1 = "Onob advises her to alter her size using a mysterious drink and food." +
            "She drinks from a bottle marked 'Drink Me', and shrinks down to the proper size to open the door. " +
            "But when Alice learns the door's locked and she's too small to reach the key atop the table, " +
            "a box of 'Eat Me' appeared.On the bank of a tranquil river, a girl called Alice grows bored of " +
            "listening to her older sister read aloud from a history book of William I of England." +
            "When her sister chastises Alice\'s daydreaming, Alice tells her kitten Dinah tha she would prefer " +
            "to live in a nonsensical dreamland called Wonderland. Alice and Dinah spot a waistcoat-wearing " +
            "White Rabbit passing by, and Alice gives chase as he rushes off crying that he is 'late for an important date'." +
            "Alice follows him into a rabbit hole and falls";

    public static final String plot_2 = plot_1;

    public static final String plot_3 = plot_1;


    /**
     * Carroll text
     */

    public static final String carroll_1 = "Onob advises her to alter her size using a mysterious drink and food." +
            "She drinks from a bottle marked 'Drink Me', and shrinks down to the proper size to open the door. " +
            "But when Alice learns the door's locked and she's too small to reach the key atop the table, " +
            "a box of 'Eat Me' appeared.On the bank of a tranquil river, a girl called Alice grows bored of " +
            "listening to her older sister read aloud from a history book of William I of England." +
            "When her sister chastises Alice\'s daydreaming, Alice tells her kitten Dinah tha she would prefer " +
            "to live in a nonsensical dreamland called Wonderland. Alice and Dinah spot a waistcoat-wearing " +
            "White Rabbit passing by, and Alice gives chase as he rushes off crying that he is 'late for an important date'." +
            "Alice follows him into a rabbit hole and falls";

    public static final String carroll_2 = carroll_1;

    public static final String carroll_3 = carroll_1;


    /**
     * Strangeness text
     */

    public static final String curiosity_1 = "Onob advises her to alter her size using a mysterious drink and food." +
            "She drinks from a bottle marked 'Drink Me', and shrinks down to the proper size to open the door. " +
            "But when Alice learns the door's locked and she's too small to reach the key atop the table, " +
            "a box of 'Eat Me' appeared.On the bank of a tranquil river, a girl called Alice grows bored of " +
            "listening to her older sister read aloud from a history book of William I of England." +
            "When her sister chastises Alice\'s daydreaming, Alice tells her kitten Dinah tha she would prefer " +
            "to live in a nonsensical dreamland called Wonderland. Alice and Dinah spot a waistcoat-wearing " +
            "White Rabbit passing by, and Alice gives chase as he rushes off crying that he is 'late for an important date'." +
            "Alice follows him into a rabbit hole and falls";

    public static final String curiosity_2 = curiosity_1;

    public static final String curiosity_3 = curiosity_1;

}

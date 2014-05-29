package com.Wonderland.helpers;


import com.Wonderland.characters.Character;
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
    public static final String ID = "id";


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

    public static final String PLOT_1 = "Onob advises her to alter her size using a mysterious drink and food." +
            "She drinks from a bottle marked 'Drink Me', and shrinks down to the proper size to open the door. " +
            "But when Alice learns the door's locked and she's too small to reach the key atop the table, " +
            "a box of 'Eat Me' appeared.On the bank of a tranquil river, a girl called Alice grows bored of " +
            "listening to her older sister read aloud from a history book of William I of England." +
            "When her sister chastises Alice\'s daydreaming, Alice tells her kitten Dinah tha she would prefer " +
            "to live in a nonsensical dreamland called Wonderland. Alice and Dinah spot a waistcoat-wearing " +
            "White Rabbit passing by, and Alice gives chase as he rushes off crying that he is 'late for an important date'." +
            "Alice follows him into a rabbit hole and falls";

    public static final String PLOT_2 = PLOT_1;

    public static final String PLOT_3 = PLOT_1;


    /**
     * Carroll text
     */

    public static final String CARROLL_1 = "Onob advises her to alter her size using a mysterious drink and food." +
            "She drinks from a bottle marked 'Drink Me', and shrinks down to the proper size to open the door. " +
            "But when Alice learns the door's locked and she's too small to reach the key atop the table, " +
            "a box of 'Eat Me' appeared.On the bank of a tranquil river, a girl called Alice grows bored of " +
            "listening to her older sister read aloud from a history book of William I of England." +
            "When her sister chastises Alice\'s daydreaming, Alice tells her kitten Dinah tha she would prefer " +
            "to live in a nonsensical dreamland called Wonderland. Alice and Dinah spot a waistcoat-wearing " +
            "White Rabbit passing by, and Alice gives chase as he rushes off crying that he is 'late for an important date'." +
            "Alice follows him into a rabbit hole and falls";

    public static final String CARROLL_2 = CARROLL_1;

    public static final String CARROLL_3 = CARROLL_1;


    /**
     * Strangeness text
     */

    public static final String CURIOSITY_1 = "Onob advises her to alter her size using a mysterious drink and food." +
            "She drinks from a bottle marked 'Drink Me', and shrinks down to the proper size to open the door. " +
            "But when Alice learns the door's locked and she's too small to reach the key atop the table, " +
            "a box of 'Eat Me' appeared.On the bank of a tranquil river, a girl called Alice grows bored of " +
            "listening to her older sister read aloud from a history book of William I of England." +
            "When her sister chastises Alice\'s daydreaming, Alice tells her kitten Dinah tha she would prefer " +
            "to live in a nonsensical dreamland called Wonderland. Alice and Dinah spot a waistcoat-wearing " +
            "White Rabbit passing by, and Alice gives chase as he rushes off crying that he is 'late for an important date'." +
            "Alice follows him into a rabbit hole and falls";

    public static final String CURIOSITY_2 = CURIOSITY_1;

    public static final String CURIOSITY_3 = CURIOSITY_1;


    /**
     * Characters descriptions
     */
    public static final String[] CHARACTERS_DESCRIPTION = {
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,
            CURIOSITY_1,

    };

    /**
     * Characters name
     */
    public static final String[] CHARACTERS_NAME = {
            "Alice",
            "Lorina",
            "Dinah",
            "White Rabbit",
            "Doorknob",
            "Captain Dodo",
            "Tweedledee Tweedledum",
            "Walrus",
            "The Carpenter",
            "Oysters",
            "Bill The Lizard",
            "Winged Animals",
            "Flowers",
            "Caterpillar",
            "Bird",
            "Cheshire Cat",
            "Mad Hatter",
            "March Hare",
            "Dormouse",
            "Mome Rats",
            "Strange Animals",
            "Cards",
            "Queen",
            "King",
            "Juri"
    };


    /**
     * List of characters objects
     */
    public static final com.Wonderland.characters.Character[] CHARACTERS = {
            new Character(R.drawable.icon_alice_1, CHARACTERS_DESCRIPTION[0], CHARACTERS_NAME[0], R.drawable.alice_1),
            new Character(R.drawable.icon_lorina_2, CHARACTERS_DESCRIPTION[1], CHARACTERS_NAME[1], R.drawable.lorina_2),
            new Character(R.drawable.icon_dinah_3, CHARACTERS_DESCRIPTION[2], CHARACTERS_NAME[2], R.drawable.dinah_3),
            new Character(R.drawable.icon_whiterabbit_4, CHARACTERS_DESCRIPTION[3], CHARACTERS_NAME[3], R.drawable.white_rabbit_4),
            new Character(R.drawable.icon_doorknob_5, CHARACTERS_DESCRIPTION[4], CHARACTERS_NAME[4], R.drawable.door_knob_5),
            new Character(R.drawable.icon_capt_dodo_6, CHARACTERS_DESCRIPTION[6], CHARACTERS_NAME[6], R.drawable.capt_dodo_6),
            new Character(R.drawable.icon_tweedledeetweedledum_7, CHARACTERS_DESCRIPTION[7], CHARACTERS_NAME[7], R.drawable.tweedledee_tweedledum_7),
            new Character(R.drawable.icon_thewalrus_8, CHARACTERS_DESCRIPTION[8], CHARACTERS_NAME[8], R.drawable.walrus_8),
            new Character(R.drawable.icon_the_carpenter_9, CHARACTERS_DESCRIPTION[9], CHARACTERS_NAME[9], R.drawable.the_carpenter_9),
            new Character(R.drawable.icon_oysters_10, CHARACTERS_DESCRIPTION[10], CHARACTERS_NAME[10], R.drawable.oysters_10),
            new Character(R.drawable.icon_billthelizard_11, CHARACTERS_DESCRIPTION[11], CHARACTERS_NAME[11], R.drawable.bill_the_lizard_11),
            new Character(R.drawable.icon_wingedanimals_12, CHARACTERS_DESCRIPTION[12], CHARACTERS_NAME[12], R.drawable.winged_animals_12),
            new Character(R.drawable.icon_flowers_13, CHARACTERS_DESCRIPTION[13], CHARACTERS_NAME[13], R.drawable.flowers_13),
            new Character(R.drawable.icon_caterpillar_14, CHARACTERS_DESCRIPTION[14], CHARACTERS_NAME[14], R.drawable.caterpiller_14),
            new Character(R.drawable.icon_bird_15, CHARACTERS_DESCRIPTION[15], CHARACTERS_NAME[15], R.drawable.bird_15),
            new Character(R.drawable.icon_cheshirecat_19, CHARACTERS_DESCRIPTION[16], CHARACTERS_NAME[16], R.drawable.cheshire_cat_16),
            new Character(R.drawable.icon_madhatter_16, CHARACTERS_DESCRIPTION[17], CHARACTERS_NAME[17], R.drawable.mad_hatter_17),
            new Character(R.drawable.icon_marchhare_17, CHARACTERS_DESCRIPTION[18], CHARACTERS_NAME[18], R.drawable.march_hare_18),
            new Character(R.drawable.icon_dormouse_18, CHARACTERS_DESCRIPTION[19], CHARACTERS_NAME[19], R.drawable.dormouse_19),
            new Character(R.drawable.icon_momeraths_20, CHARACTERS_DESCRIPTION[20], CHARACTERS_NAME[20], R.drawable.mome_raths_20),
            new Character(R.drawable.icon_strangeanimals_21, CHARACTERS_DESCRIPTION[21], CHARACTERS_NAME[21], R.drawable.strange_animals_21),
            new Character(R.drawable.icon_cards_22, CHARACTERS_DESCRIPTION[22], CHARACTERS_NAME[22], R.drawable.cards_22),
            new Character(R.drawable.icon_queen_23, CHARACTERS_DESCRIPTION[23], CHARACTERS_NAME[23], R.drawable.queen_23),
            new Character(R.drawable.icon_king_24, CHARACTERS_DESCRIPTION[24], CHARACTERS_NAME[24], R.drawable.king_24),
            new Character(R.drawable.icon_juri_25, CHARACTERS_DESCRIPTION[25], CHARACTERS_NAME[25], R.drawable.juri_25)
    };

}

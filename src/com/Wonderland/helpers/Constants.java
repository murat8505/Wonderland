package com.Wonderland.helpers;


import com.Wonderland.characters.Character;
import com.Wonderland.extras.sections.AudioActivity;
import com.Wonderland.extras.sections.VideoActivity;
import com.Wonderland.extras.sections.WallPaperActivity;
import com.Wonderland.main.R;
import com.Wonderland.shop.ClothingMenuActivity;
import com.Wonderland.shop.direct.GadgetActivity;
import com.Wonderland.shop.direct.HomeActivity;
import com.Wonderland.story.sections.CarrollActivity;
import com.Wonderland.story.sections.PlotActivity;
import com.Wonderland.story.sections.StrangenessActivity;

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
     * Path of video folder
     */
    public static final String VIDEO_PATH = "video";

    /**
     * Path of shop folder
     */
    public static final String SHOP_PATH = "shop";

    /**
     * Path of gadget shop folder
     */
    public static final String GADGET_SHOP_PATH = SHOP_PATH + "/" + "gadget";

    /**
     * Path of home shop folder
     */
    public static final String HOME_SHOP_PATH = SHOP_PATH + "/" + "home";

    /**
     * Path of clothing shop folder
     */
    public static final String CLOTHING_SHOP_PATH = SHOP_PATH + "/" + "clothing";

    /**
     * Path of man clothing shop folder
     */
    public static final String MAN_CLOTHING_SHOP_PATH = CLOTHING_SHOP_PATH + "/" + "man";

    /**
     * Path of woman clothing shop folder
     */
    public static final String WOMAN_CLOTHING_SHOP_PATH = CLOTHING_SHOP_PATH + "/" + "woman";

    /**
     * Path of baby clothing shop folder
     */
    public static final String BABY_CLOTHING_SHOP_PATH = CLOTHING_SHOP_PATH + "/" + "baby";

    /**
     * Path of wallpapers
     */
    public static final String WALLPAPER_PATH = "wallpaper";


    public static final String IMAGE = "image";
    public static final String TEXT = "text";
    public static final String TITLE = "title";
    public static final String ID = "id";


    /**
     * Size in pixels of the background in menu pages.
     * It's needed to obtain correct coordinates during touch
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
            put(R.string.shop, R.drawable.shop_menu);
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
    public static final int[][] MENU_OPTIONS_COORDINATES = {FIRST_MENU, Helper.buildOtherMenus(SECOND_MENU, FIRST_MENU, 1), Helper.buildOtherMenus(THIRD_MENU, FIRST_MENU, 1)};
    /**
     * Array of class objects, needed to forward Main menu buttons
     */
    private static final Class[] STORY_OPTIONS = {PlotActivity.class, CarrollActivity.class, StrangenessActivity.class};
    /**
     * Array of class objects, needed to forward Extras menu buttons
     */
    private static final Class[] EXTRAS_OPTIONS = {VideoActivity.class, AudioActivity.class, WallPaperActivity.class};
    /**
     * Array of class objects, needed to forward Shop menu buttons
     */
    private static final Class[] SHOP_OPTIONS = {ClothingMenuActivity.class, HomeActivity.class, GadgetActivity.class};


    /**
     * Hashtable of menu options
     */
    public static final Hashtable<Integer, Class<?>[]> MENU_OPTIONS = new Hashtable<Integer, Class<?>[]>() {
        {
            put(R.string.story, STORY_OPTIONS);
            put(R.string.extras, EXTRAS_OPTIONS);
            put(R.string.shop, SHOP_OPTIONS);
        }
    };


    /**
     * Size in pixels of the background in characters page.
     * It's needed to obtain correct coordinates during touch
     */
    public static final int[] LOCATION_BACKGROUND_SIZE = {480, 1610};

    /**
     * Radius in px of every menu
     */
    public static final int RADIUS = 61;

    /**
     * Center point of every menu
     */
    public static final int[] LAWN = {110, 84};
    public static final int[] HALL = {336, 132};
    public static final int[] SEA = {369, 344};
    public static final int[] WOOD = {161, 424};
    public static final int[] BEACH = {357, 553};
    public static final int[] W_R_HOUSE = {111, 674};
    public static final int[] MEADOW = {321, 780};
    public static final int[] M_H_HOUSE = {148, 1027};
    public static final int[] FOREST = {367, 996};
    public static final int[] TULGEY_WOOD = {85, 1279};
    public static final int[] QUEEN_G = {334, 1271};
    public static final int[] COURT_H = {378, 1494};

    /**
     * This object binds the locations on the map with the relative characters.
     * The order is the same showed up for center points (1 -> Lawn, ...)
     */
    public static final int[][] LOCATION_ICON_BINDING = {
            {0, 1, 2, 3},
            {4},
            {5},
            {6},
            {7, 8, 9},
            {3, 5, 10},
            {11, 12, 13, 14},
            {3, 18, 16, 17},
            {15},
            {15, 19, 20},
            {3, 21, 22, 23},
            {3, 15, 16, 17, 18, 21, 22, 23, 24}
    };

    /**
     * Plot text
     * <p/>
     * WARNING!!! Text with /n or other shortcut will not work. Need tests
     */

    public static final String PLOT_1 = "On the bank of a river a little girl named Alice, bored because of her older sister, goes away with her kitten Dinah; they spot a waistcoat-wearing White Rabbit passing by and Alice gives chase as he rushes off crying that he is \"late for an important date\". Alice follows him into a rabbit hole and falls into a labyrinth. She sees the White Rabbit disappear into a tiny door and tries to follow him, but the Doorknob advises her to alter her size using some mysterious drink and food. After some attempts she passes through the keyhole of the door reaching Wonderland. She meets several strange characters including the Dodo, Tweedledee and Tweedledum who tell the tale of \"The Walrus and the Carpenter\"";

    public static final String PLOT_2 = "Alice eventually finds the White Rabbit in his house, but before she can ask what he is late for, she is sent to fetch some gloves after being mistaken for his housemaid. She eats a cookie, grows into a giant and then can't exit. The White Rabbit, the Dodo and the chimney sweep Bill the Lizard plot to burn the house down: Alice escapes by eating a carrot and shrinking down to the size of an insect and then she meets some talking flowers. Alice is instructed by the hookah-smoking Caterpillar to eat a part of his mushroom to grow back to her original size.";

    public static final String PLOT_3 = "Alice meets the Cheshire Cat who advises her to visit the Mad Hatter, the March Hare and the Dormouse at the mad tea party. Alice now decides to go home, but she gets lost in the Tulgey Wood. The Cheshire Cat appears and leads Alice into a giant hedge maze ruled by the tyrannical Queen of Hearts, who invites Alice in a bizarre croquet match. Due to the Cheshire Cat, Alice is put on trial. She eats the remains of the Caterpillar's mushroom: then, being giant, Alice feels free to openly insult the Queen. But soon she shrinks to her normal size and she is forced to flee because the Queen orders her execution. Alice is pursued by most of the Wonderland's characters until she finally reunites with the Doorknob, who then tells her she is having a dream, forcing Alice to wake up.";


    /**
     * Carroll text
     */

    public static final String CARROLL_1 = "Although they differ in some details, the plots of the Lewis Carroll's book and the Disney version (1951) of Alice in Wonderland follow pretty similar lines until the Caucus-race. After this episode we can identify the following differences: " +
            "After the race Alice meets Tweedledum and Tweedledee (Disney), instead of being sent directly to the White Rabbit's house to fetch his gloves and fan (book); " +
            "Tweedledum and Tweedledee appear in the book “Through the Looking Glass”, the sequel of Alice's Adventures in Wonderland;";

    public static final String CARROLL_2 = "After visiting the White Rabbit's house Alice meets the talking flowers (Disney), another scene from “Through the Looking Glass”, instead of encountering a vast puppy and trying to play with it (book); " +
            "After meeting the Caterpillar and then frightening a bird, in the book Alice discovers the Duchess' house, the fish and frog footmen and meets the terrifying Duchess and her pig-baby; " +
            "Alice then visits the mad tea party and the White Rabbit also attends (Disney), differently from the book; " +
            "After leaving the tea party, Alice gets lost in the frightening Tulgey Wood until the Cheshire Cat reappears, showing her the door to the Queen's garden (Disney); in the book instead, after the party, she finds a door which leads her directly to the garden;";

    public static final String CARROLL_3 = "After playing croquet with the Queen, in the book only, Alice meets the Duchess again, the Gryphon and the Mock Turtle; " +
            "The Queen thinks that she has been humiliated by Alice during the croquet match, and wants Alice to be tried (Disney); in the book, the Knave of Hearts is accused of the theft of the Queen of Hearts' tarts, and Alice is called as witness; " +
            "The Doorknob appears only in the Disney movie. " +
            "The Dodo is believed to represent Lewis Carroll (real name Charles Lutwidge Dodgson): owing to his stammer, Carroll would pronounce his real name 'Do-Do-Dodgson'.";


    /**
     * Strangeness text
     */

    public static final String CURIOSITY_1 = "\"Alice\" means \"noble\" and \"kind\". " +
            "Alice is one of the few human heroines who has not been seen barefoot in any of her media. The other heroines include Snow White, Eilonwy, Belle, and Merida. " +
            "Her facial features are extremely similar to Wendy from Peter Pan. " +
            "Alice received her name after the daughter of Lewis Carroll's friend, \"Alice Liddel\". " +
            "Alice's birthday would be on May 4th.";

    public static final String CURIOSITY_2 = "Despite being a generally neutral character, the Cheshire Cat is apparently considered a villain by the Walt Disney Company. " +
            "When Alice first hears the Cheshire Cat, he is singing the first and last stanza of the poem \"Jabberwocky\". " +
            "The Queen of Hearts was the one begun as a video trend in which characters outside Alice in Wonderland would tell the Queen of Hearts herself to shut up or otherwise insult or defeat her.";

    public static final String CURIOSITY_3 = "The White Rabbit has four fingers. " +
            "The '10/6' on the Mad Hatter's top hat is not a fraction, but the price of the hat, ten shillings and sispence, in the former currency of Britain. There were twelve pence in a shilling and twenty shillings in a pound. In 1971, this complicated money system was changed to a decimal-based one, doing away with the shilling. " +
            "A test cel setup of Alice, Dinah, and the Sister from the final scene of the film shows that Dinah was a black cat, not orange.";


    /**
     * Characters descriptions
     */
    private static final String[] CHARACTERS_DESCRIPTION = {
            "Alice is a beautiful young girl living in what is assumed to be the Victorian era; she is about 9-11 years old.\n" +
                    "Alice is depicted as a daydreamer first and foremost. Prior to arriving in Wonderland, she sat on the bank of a river listening to her sister reading lessons, which she didn't like as the book, her sister was reading, had no pictures, and claimed, \"In my world, the books would be nothing but pictures!\" This gives some idea of Alice's large imagination.\n" +
                    "She is also very adventurous and curious.",
            "Lorina is a very practical, no-nonsense and beautiful young woman and wishes for Alice to be the same way.",
            "Dinah is Alice's cute and pretty small red kitten.",
            "The White Rabbit is the very reason Alice gets stuck in Wonderland. He is small and plumpis and is a jittery, seemingly elderly, character. It can be concluded that the rabbit is the most sane of Wonderland's residents; he is known to be stressful, however this is not the case. He was only stressed because of his ill-tempered Queen who will surely kill the rabbit for being tardy.\n" +
                    "He was not particularly kind to Alice, not because he wishes to be or because he is an antagonist, but because he is following his Queen's orders.",
            "The Doorknob is the main entrance to Wonderland and is a generally nice character; however he has the tendency to joke around during serious situations but overall well meaning.",
            "Capt. Dodo, otherwise known as Pat the Dodo, is in charge of handling the Caucus Race, an event in which everyone runs at an equal pace and in a circle in an attempt to get dry.",
            "The Tweedles are two fat brothers dressed in school boy uniforms and wearing propeller caps; they take particular delight in reciting poems and songs. They're playful, jolly which can seem a little annoying and enjoy company; they will always insist in a little game. They also have the ability to multiply.",
            "The Walrus is a jobless traveler whose story was told to Alice by Tweedle Dee and Tweedle Dum.\n" +
                    "He acts as the leader; he is a conniving character who resorts to trickery to get what he wants. While the Carpenter believes that finding employment will better improve their lives, work is the last thing on the Walrus's mind, regardless of his constant ramblings of \"cabbages and kings\" (his way of saying that their futures will soon enough be bright). He is also very greedy and self-conceited, not hesitating to eat all of the naive oysters (whom he deceptively convinced to follow him ashore and into a restaurant that Carpenter built out of salvaged remnants of a boat) by himself, much to the Carpenter's rage of being left out of the feast.",
            "The Carpenter is a jobless traveler whose story was told to Alice by Tweedle Dee and Tweedle Dum.\n" +
                    "He acts as the Walrus's dimwitted sidekick and talks in an Irish accent. He often acts before he thinks (nearly blurting out to the oysters their plans to eat them), leading to his smarter friend constantly punishing him through slapstick forms of abuse. Despite his stupidity, he is shown to be less despicable than the Walrus and very eco-friendly when he suggests that they clean up the garbage that was lingering on the beach only to have the Walrus turn down this idea when he knew it involved work. He is also a speedy builder, constructing a small restaurant out of a destroyed boat in seconds as soon as the Walrus lured the oysters inside. However, the Carpenter does not take being swindled himself very well, bringing him to the point of enraged retribution on the Walrus when the latter devoured all of the oysters himself, leaving none for the Carpenter.",
            "The Curios Oysters are a family of young female oysters and their mother; their bottom shell appears to be a built in bed while their top shells appear to be bonnets.\n" +
                    "The little oysters are tricked by The Walrus and the Carpenter into going for a walk.",
            "Bill is first seen walking with a ladder. He is simple and helpful and his job is chimney sweep.",
            "Winged animals contain Rocking Horse Flies and Bread-&-Butter Flies. They are animated objects with wings; they live between flowers and roses.",
            "Flowers are the most beautiful creatures of the meadow; they have brightly colors and magnificent voices. The regal flower is the white rose, adorned with dew.",
            "The Caterpillar smokes a hookah from which colorful smoke rises, spelling out the words he says. He often over-enunciates certurn words such as 'exactly' and 'correctly'. The Caterpillar has a passion for recitation and grammar as well as a short temper which can easily be set off. A few times he also doesn't remember who he earlier talked to, as he asked who Alice was a few times.",
            "The mother Bird attacks Alice, accusing her of being a serpent.",
            "The Cheshire Cat is a mysterious pink and purple striped cat with a devious, mischievous personality. He has a permanent smile on his face and can disappear at will. The cat is a very odd being able to reshape his body to either amuse or frighten his visitors. He's very mysterious, and in his own way, very dark. Like all members of Wonderland, the Cheshire Cat is mad, but unlike the others, he admits it with pride. All of Wonderland's inhabitants appear to hold a fear over the Cheshire Cat, even the Queen of Hearts, most likely due to the fact that he is the maddest and craziest of them all, or it could be due to his unique abilities.",
            "He appears as a short, hyperactive man with grey hair, a large nose and a comical voice. Alice stumbles upon the Mad Hatter and the March Hare having an \"un-birthday\" party for themselves.\n" +
                    "The Hatter asks her the infamous riddle \"Why is a raven like a writing desk?\" but when she tries to answer, the Hatter denies asking her the riddle.",
            "The March Hare is The Mad Hatter's best friend; of course, he's mad, too. Together enjoy tea during the Unbirthday Party. Although they are close and both insane, March Hare seems to be a bit more loud and wild than the Hatter who is abit more gentleman like. Besides the Cheshire Cat, the March Hare seems to be the only one not to have a true fear of the Queen of Hearts being that he was capable of screaming in her face \"Nothing Whatever!\"",
            "The Dormouse is a friend of the Mad Hatter and the March Hare. He's sleepy, droopy and lives in a yellow teapot. He goes on a crazed frenzy saying \"Cat cat cat cat cat!\" when hears the word \"cat\"; the Dormouse goes back to sleep only when someone applies jam to his nose.",
            "The Mome Raths are bipedal creatures without arms. They have two google eyes and fuzzy hair on their heads like a troll doll; when they sleep only their fuzzy hair is visible. They gather around and make an arrow formation: they point to a pink path that leads out of Tulgey Wood.",
            "A lot of strange animals inhabit the Tulgey Wood; they are half animal and half object. They tend to hide themselves away the trees.",
            "The Card Soldiers are the loyal servants of The Queen of Hearts. They make up the Queen's military force and they always obey her orders. However, this is mostly due to the tremendous fear they have of her rather than loyalty.",
            "The Queen of Hearts is the main antagonist: she is the tyrannical and deranged ruler of Wonderland. She has a very psychotic personality. All the residents of Wonderland are mad (insane) in some way, but the Queen of Hearts is the most dangerous of them all, by being the ruler of the land. She completely dominates her weak husband, the King of Hearts. She is also very egotistical, as she likes to hear the words \"Yes, your majesty\" and insists that \"All ways are my ways!\"" +
                    "Like any insane person, she has huge mood swings, from content to enraged at a moment's notice. Her immediate solution to every problem is beheading, whether her roses have been planted white, she misses a shot in croquet or feels insulted in any way.",
            "The King of Hearts is the meek and tiny husband of the temperamental Queen of Hearts and, unlike most instances, is generally the lesser of the two monarchs. He is much smaller than his wife, as well as meeker; while he tries to please the queen, at the same time, he is one of the few people who is able to change her mind about anything, such as altering Alice's beheading to a trial instead. He seems to act more like a son to his wife than a husband, as he asks her to put Alice on trial in a childlike manner, and she pats him on the head like he were a child after taking his suggestion for the trial, as well as using him as a shield against an oversized Alice. Unfortunately, he is only created in Alice's dreams, and vanishes from her mind once she awakens.",
            "The Juri is composed of different animals, subdued of the Queen's madness; their judgment isn't impartial.",

    };

    /**
     * Characters name
     */
    private static final String[] CHARACTERS_NAME = {
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
            new Character(0, R.drawable.icon_alice_1, CHARACTERS_DESCRIPTION[0], CHARACTERS_NAME[0], R.drawable.alice_1),
            new Character(1, R.drawable.icon_lorina_2, CHARACTERS_DESCRIPTION[1], CHARACTERS_NAME[1], R.drawable.lorina_2),
            new Character(2, R.drawable.icon_dinah_3, CHARACTERS_DESCRIPTION[2], CHARACTERS_NAME[2], R.drawable.dinah_3),
            new Character(3, R.drawable.icon_whiterabbit_4, CHARACTERS_DESCRIPTION[3], CHARACTERS_NAME[3], R.drawable.white_rabbit_4),
            new Character(4, R.drawable.icon_doorknob_5, CHARACTERS_DESCRIPTION[4], CHARACTERS_NAME[4], R.drawable.door_knob_5),
            new Character(5, R.drawable.icon_capt_dodo_6, CHARACTERS_DESCRIPTION[5], CHARACTERS_NAME[5], R.drawable.capt_dodo_6),
            new Character(6, R.drawable.icon_tweedledeetweedledum_7, CHARACTERS_DESCRIPTION[6], CHARACTERS_NAME[6], R.drawable.tweedledee_tweedledum_7),
            new Character(7, R.drawable.icon_thewalrus_8, CHARACTERS_DESCRIPTION[7], CHARACTERS_NAME[7], R.drawable.walrus_8),
            new Character(8, R.drawable.icon_the_carpenter_9, CHARACTERS_DESCRIPTION[8], CHARACTERS_NAME[8], R.drawable.the_carpenter_9),
            new Character(9, R.drawable.icon_oysters_10, CHARACTERS_DESCRIPTION[9], CHARACTERS_NAME[9], R.drawable.oysters_10),
            new Character(10, R.drawable.icon_billthelizard_11, CHARACTERS_DESCRIPTION[10], CHARACTERS_NAME[10], R.drawable.bill_the_lizard_11),
            new Character(11, R.drawable.icon_wingedanimals_12, CHARACTERS_DESCRIPTION[11], CHARACTERS_NAME[11], R.drawable.winged_animals_12),
            new Character(12, R.drawable.icon_flowers_13, CHARACTERS_DESCRIPTION[12], CHARACTERS_NAME[12], R.drawable.flowers_13),
            new Character(13, R.drawable.icon_caterpillar_14, CHARACTERS_DESCRIPTION[13], CHARACTERS_NAME[13], R.drawable.caterpiller_14),
            new Character(14, R.drawable.icon_bird_15, CHARACTERS_DESCRIPTION[14], CHARACTERS_NAME[14], R.drawable.bird_15),
            new Character(15, R.drawable.icon_cheshirecat_19, CHARACTERS_DESCRIPTION[15], CHARACTERS_NAME[15], R.drawable.cheshire_cat_16),
            new Character(16, R.drawable.icon_madhatter_16, CHARACTERS_DESCRIPTION[16], CHARACTERS_NAME[16], R.drawable.mad_hatter_17),
            new Character(17, R.drawable.icon_marchhare_17, CHARACTERS_DESCRIPTION[17], CHARACTERS_NAME[17], R.drawable.march_hare_18),
            new Character(18, R.drawable.icon_dormouse_18, CHARACTERS_DESCRIPTION[18], CHARACTERS_NAME[18], R.drawable.dormouse_19),
            new Character(19, R.drawable.icon_momeraths_20, CHARACTERS_DESCRIPTION[19], CHARACTERS_NAME[19], R.drawable.mome_raths_20),
            new Character(20, R.drawable.icon_strangeanimals_21, CHARACTERS_DESCRIPTION[20], CHARACTERS_NAME[20], R.drawable.strange_animals_21),
            new Character(21, R.drawable.icon_cards_22, CHARACTERS_DESCRIPTION[21], CHARACTERS_NAME[21], R.drawable.cards_22),
            new Character(22, R.drawable.icon_queen_23, CHARACTERS_DESCRIPTION[22], CHARACTERS_NAME[22], R.drawable.queen_23),
            new Character(23, R.drawable.icon_king_24, CHARACTERS_DESCRIPTION[23], CHARACTERS_NAME[23], R.drawable.king_24),
            new Character(24, R.drawable.icon_juri_25, CHARACTERS_DESCRIPTION[24], CHARACTERS_NAME[24], R.drawable.juri_25)
    };


    /**
     * Clothing menu, coordinates of the first clothing on top
     */
    private static final int[] FIRST_CLOTHING_MENU = {105, 66, 126, 85, 135, 76, 235, 83, 251, 115, 259, 165, 201, 165, 206, 181, 167, 186, 152, 238, 124, 116, 88, 81};
    /**
     * Clothing menu, coordinates of the first point (top right corner) of the second menu (it's mirrored)
     */
    private static final int[] SECOND_CLOTHING_MENU = {402, 269};
    /**
     * Clothing menu, coordinates of the first point (top left corner) of the third menu
     */
    private static final int[] THIRD_CLOTHING_MENU = {108, 465};
    /**
     * All Clothing menus
     */
    public static final int[][] MENU_CLOTHING_COORDINATES = {FIRST_MENU, Helper.buildOtherMenus(SECOND_CLOTHING_MENU, FIRST_CLOTHING_MENU, -1), Helper.buildOtherMenus(THIRD_CLOTHING_MENU, FIRST_CLOTHING_MENU, 1)};


}

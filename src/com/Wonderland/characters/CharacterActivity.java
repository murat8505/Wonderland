package com.Wonderland.characters;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.Wonderland.extras.sections.WallPaperActivity;
import com.Wonderland.graphicObjects.IconAdapter;
import com.Wonderland.graphicObjects.IconBar;
import com.Wonderland.graphicObjects.MyTextView;
import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;
import com.Wonderland.main.R;

/**
 * Created by marco on 29/05/14.
 * <p/>
 * Activity to show one {@link com.Wonderland.characters.Character}
 */
public class CharacterActivity extends MyActivity {

    /**
     * Character to display, can be changed in every moment
     */
    private Character character;

    /**
     * Button to open Wallpaper section
     */
    private ImageButton gallery;

    /**
     * Name of the character
     */
    private MyTextView name;

    /**
     * Description of the character
     */
    private TextView description;

    /**
     * Descriptive image of the character
     */
    private ImageView characterImage;

    /**
     * Lateral iconBar {@link com.Wonderland.graphicObjects.IconBar}
     */
    private IconBar bar;

    Singleton singleton = Singleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.character);

        gallery = (ImageButton) findViewById(R.id.galleryButton);
        name = (MyTextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);
        characterImage = (ImageView) findViewById(R.id.characterImage);


        bar = (IconBar) findViewById(R.id.bar);
        bar.setOnClickListener(new IconAdapter.OnClickListener() {
            @Override
            public void onClick(Character character) {
                setCharacter(character);
            }
        });

        int position = getIntent().getIntExtra(Constants.ID, 0);
        singleton.setCharacterDisplayed(Constants.CHARACTERS[position]);

    }

    /**
     * Change the character and reset all fields of the View.
     * Can be called in every moment
     *
     * @param character Character - character to show
     */
    private void setCharacter(Character character) {
        this.character = character;

        name.setText(character.getName());
        description.setText(character.getText());
        characterImage.setImageDrawable(character.getDrawableImage(this));

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(activity, WallPaperActivity.class);
            }
        });

//        bar.setSelected(character.getPosition());
    }

    @Override
    protected void onStart() {
        super.onStart();

        // If I try to set the first element of the bar in another "moment" scroll position
        // is incorrect, probably because it isn't been instantiated yet
        setCharacter(singleton.getCharacterDisplayed());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        singleton.setCharacterDisplayed(character);
    }

    @Override
    public String getActivityTitle() {
        return null;
    }
}

package com.Wonderland.shop;

import android.os.Bundle;

import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.helpers.Singleton;
import com.Wonderland.main.R;
import com.Wonderland.shop.menuOptions.BabyActivity;
import com.Wonderland.shop.menuOptions.FemaleActivity;
import com.Wonderland.shop.menuOptions.MaleActivity;

/**
 * Created by marco on 05/06/14.
 */
public class ClothingMenuActivity extends MyActivity {

    private Singleton singleton = Singleton.getInstance();


    @Override
    public String getActivityTitle() {
        return getString(R.string.clothingShopTitle);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        MyImageView myImageView = (MyImageView) findViewById(R.id.menuImageView);
        myImageView.setImageResource(R.drawable.clothing_menu);
        myImageView.setMyOnTouchEvent(new MyImageView.MyOnTouchEvent() {
            @Override
            public void position(int x, int y) {
                findButtonPressed(x, y);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        groupActionBar.showBackButtonText(false);
        groupActionBar.showBackButton(true);
    }

    /**
     * Find which menu option is pressed and start the correct action
     *
     * @param x, int - x coordinate
     * @param y, int - y coordinate
     */
    private void findButtonPressed(int x, int y) {

        if (Helper.testPointInPolygon(x, y, singleton.getClothingMenuOptions()[0]))
            Helper.startActivity(this, MaleActivity.class);
        else if (Helper.testPointInPolygon(x, y, singleton.getClothingMenuOptions()[1]))
            Helper.startActivity(this, FemaleActivity.class);
        else if (Helper.testPointInPolygon(x, y, singleton.getClothingMenuOptions()[2]))
            Helper.startActivity(this, BabyActivity.class);
    }

}

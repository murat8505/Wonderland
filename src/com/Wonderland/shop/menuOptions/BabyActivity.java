package com.Wonderland.shop.menuOptions;

import android.os.Bundle;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.shop.AbstractShopActivity;

/**
 * Created by marco on 05/06/14.
 */
public class BabyActivity extends AbstractShopActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter(Constants.BABY_CLOTHING_SHOP_PATH);
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.babyTitle);
    }
}

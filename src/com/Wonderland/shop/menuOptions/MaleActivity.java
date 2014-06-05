package com.Wonderland.shop.menuOptions;

import android.os.Bundle;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.shop.AbstractShopActivity;

/**
 * Created by marco on 05/06/14.
 */
public class MaleActivity extends AbstractShopActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter(Constants.MAN_CLOTHING_SHOP_PATH);
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.maleTitle);
    }

}

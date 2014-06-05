package com.Wonderland.shop.direct;

import android.os.Bundle;

import com.Wonderland.helpers.Constants;
import com.Wonderland.main.R;
import com.Wonderland.shop.AbstractShopActivity;

/**
 * Created by marco on 05/06/14.
 */
public class GadgetActivity extends AbstractShopActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter(Constants.GADGET_SHOP_PATH);
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.gadgetTitle);
    }
}

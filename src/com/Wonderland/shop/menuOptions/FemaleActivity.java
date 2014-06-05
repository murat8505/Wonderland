package com.Wonderland.shop.menuOptions;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;
import com.Wonderland.shop.AbstractShopActivity;
import com.Wonderland.shop.ReviewRegisterBuyActivity;

/**
 * Created by marco on 05/06/14.
 */
public class FemaleActivity extends AbstractShopActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAdapter(Constants.WOMAN_CLOTHING_SHOP_PATH);
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.femaleTitle);
    }

    @Override
    protected void setAdapter(String path) {
        super.setAdapter(path);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Helper.startActivity(activity, ReviewRegisterBuyActivity.class);
                }
            }
        });
    }

}

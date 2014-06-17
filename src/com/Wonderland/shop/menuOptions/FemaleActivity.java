package com.Wonderland.shop.menuOptions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.Wonderland.helpers.Constants;
import com.Wonderland.helpers.Helper;
import com.Wonderland.main.R;
import com.Wonderland.shop.AbstractShopActivity;
import com.Wonderland.shop.ReviewRegisterBuyActivity;

import java.io.File;
import java.util.List;

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

        final List<File> list = Helper.listFiles(Constants.WOMAN_CLOTHING_SHOP_PATH);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent i = new Intent(activity, ReviewRegisterBuyActivity.class);
                    String name = Helper.parseFileName(list.get(position).getName());
                    i.putExtra(Constants.TITLE, name);
                    activity.startActivity(i);
                }
            }
        });
    }

}

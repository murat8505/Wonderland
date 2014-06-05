package com.Wonderland.shop;

import android.os.Bundle;
import android.widget.GridView;

import com.Wonderland.graphicObjects.ExtrasGridArrayAdapter;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.main.R;

import java.io.File;
import java.util.List;

/**
 * Created by marco on 05/06/14.
 */
public abstract class AbstractShopActivity extends MyActivity {

    protected GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        gridView = (GridView) findViewById(R.id.gridView);
    }

    protected void setAdapter(final String path) {

        final List<File> list = Helper.listFiles(path);

        ExtrasGridArrayAdapter adapter = new ExtrasGridArrayAdapter(this, R.layout.extras_gridview_element, list);

        adapter.isWallPaper();

        gridView.setAdapter(adapter);
    }
}

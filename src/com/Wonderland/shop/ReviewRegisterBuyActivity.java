package com.Wonderland.shop;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.Wonderland.graphicObjects.MyImageView;
import com.Wonderland.helpers.Helper;
import com.Wonderland.helpers.MyActivity;
import com.Wonderland.main.R;
import com.Wonderland.polygon.Point;
import com.Wonderland.polygon.Polygon;

/**
 * Created by marco on 05/06/14.
 */
public class ReviewRegisterBuyActivity extends MyActivity {

    //BACKGROUND_SIZE

    private static final int[] BUY = {332, 610};
    private static final int[] CREATE_ACCOUNT = {146, 554};
    private static final int[] CREATE_ACCOUNT_2 = {147, 559};
    private static final int[] BUY_2 = {325, 573};

    private static final int[] BUY_BUTTON_SIZE = {122, 40};
    private static final int[] CREATE_BUTTON_SIZE = {192, 51};

    private Polygon[] buttons = new Polygon[4];

    private MyImageView myImageView;

    private int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.review_register_buy);
        myImageView = (MyImageView) findViewById(R.id.myImageView);

        buttons[0] = buildPolygon(BUY, BUY_BUTTON_SIZE);
        buttons[1] = buildPolygon(CREATE_ACCOUNT, CREATE_BUTTON_SIZE);
        buttons[2] = buildPolygon(CREATE_ACCOUNT_2, CREATE_BUTTON_SIZE);
        buttons[3] = buildPolygon(BUY_2, BUY_BUTTON_SIZE);


        myImageView.setBackground(getResources().getDrawable(R.drawable.detail));
        myImageView.setMyOnTouchEvent(new MyImageView.MyOnTouchEvent() {
            @Override
            public void position(int x, int y) {
                onClick(x, y);
            }
        });


    }

    @Override
    public String getActivityTitle() {
        return "T-shirt";
    }

    private void onClick(int x, int y) {

        if (Helper.testPointInPolygon(x, y, buttons[step])) {
            switch (step) {
                case 0:
                    myImageView.setBackground(getResources().getDrawable(R.drawable.reg1));
                    groupActionBar.setText("Log in");
                    break;
                case 1:
                    myImageView.setBackground(getResources().getDrawable(R.drawable.reg2));
                    groupActionBar.setText("Register");
                    break;
                case 2:
                    myImageView.setBackground(getResources().getDrawable(R.drawable.reg3));
                    groupActionBar.setText("Cart");
                    break;
                case 3:
                    finish();
                    break;
            }
            step++;
        }

    }

    private Polygon buildPolygon(int[] point, int[] size) {

        Polygon.Builder builder = new Polygon.Builder();

        builder.addVertex(new Point(point[0], point[1]));
        builder.addVertex(new Point(point[0], point[1] + size[1]));
        builder.addVertex(new Point(point[0] + size[0], point[1] + size[1]));
        builder.addVertex(new Point(point[0] + size[0], point[1]));

        Polygon polygon = builder.build();

        return polygon;
    }
}

package com.Wonderland.main;

import android.app.Application;

import com.Wonderland.helpers.Singleton;

/**
 * Created by marco on 17/04/14.
 * <p/>
 * Override to initialize my Singleton
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Singleton.getInstance();
    }

}

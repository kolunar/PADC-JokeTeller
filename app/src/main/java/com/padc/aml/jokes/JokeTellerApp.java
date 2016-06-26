package com.padc.aml.jokes;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 6/25/2016.
 */
public class JokeTellerApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }

    // object level context can't be called in class level static method
    public static Context getContext() {
        return context;
    }
}

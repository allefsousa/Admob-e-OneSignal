package com.developer.allef.adbmob;

import android.app.Application;
import android.util.Log;

import com.onesignal.OneSignal;

/**
 * Created by Allef on 25/02/2017.
 *
 * classe para inicializar as push messages do one signal.
 *
 *
 */

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("OneSignalTag", "Before OneSignal init");

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.startInit(this).init();

        Log.d("OneSignalTag", "After OneSignal init");
    }
}

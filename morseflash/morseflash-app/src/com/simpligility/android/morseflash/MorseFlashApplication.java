package com.simpligility.android.morseflash;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import com.simpligility.android.os.StrictModeWrapper;

/**
 * The MorseFlashApplication is a simple way to hold some data and make it accessible to any activity.
 *
 * @author Manfred Moser <manfred@simpligility.com>
 */
public class MorseFlashApplication extends Application {

    public String message;

    private static boolean strictModeAvailable;

    static {
        try {
            StrictModeWrapper.checkAvailable();
            strictModeAvailable = true;
        } catch (Throwable throwable) {
            strictModeAvailable = false;
        }
    }

    @Override
    public void onCreate() {
        if (strictModeAvailable) {
            int applicationFlags = getApplicationInfo().flags;
            if ((applicationFlags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
                StrictModeWrapper.enableDefaults();
            }
        }
        super.onCreate();
    }
}

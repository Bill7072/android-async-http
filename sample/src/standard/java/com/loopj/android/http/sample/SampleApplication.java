package com.loopj.android.http.sample;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import static android.os.Build.VERSION.SDK_INT;

public class SampleApplication extends Application {

    private static final String LOG_TAG = "SampleApplication";

    @Override
    public void onCreate() {
        setStrictMode();
        super.onCreate();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setStrictMode() {
        if (SDK_INT > 3) {
            Log.d(LOG_TAG, "Enabling StrictMode policy over Sample application");
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .permitDiskReads()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }
}

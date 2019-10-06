package com.presto.dhara.creditcardapp;

import android.app.Application;
import android.content.res.Configuration;

import com.presto.dhara.creditcardapp.utils.ReleaseTree;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class CreditCardApplication extends Application {

    private static final String TAG = CreditCardApplication.class.getSimpleName();

    private static CreditCardApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            initLeakCanary();
            Timber.d("onCreate: firestore logging enabled");
        } else {
            Timber.plant(new ReleaseTree());
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static CreditCardApplication getInstance() {
        return mInstance;
    }

    /**
     * use LeakCanary to check any leak in app's DEBUG build
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

}

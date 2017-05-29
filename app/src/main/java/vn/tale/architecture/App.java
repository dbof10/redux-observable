package vn.tale.architecture;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.litho.LithoWebKitInspector;
import com.facebook.soloader.SoLoader;
import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 Created by Giang Nguyen on 2/21/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    public static App get(Context context) {
        return ((App) context.getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initTimber();
        SoLoader.init(this, false);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableWebKitInspector(new LithoWebKitInspector(this))
                        .build());
        Fresco.initialize(this);

        appComponent = makeAppComponent();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent makeAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule())
                .appSingletonModule(new AppSingletonModule())
                .build();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    private static class CrashReportingTree extends Timber.Tree {

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            Log.println(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    Log.e(tag, message, t);
                } else if (priority == Log.WARN) {
                    Log.w(tag, message, t);
                }
            }
        }
    }
}

package owner.practice.appchangelanguage;

import android.app.Application;
import android.content.Context;

import owner.practice.appchangelanguage.helper.LocaleHelper;

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}

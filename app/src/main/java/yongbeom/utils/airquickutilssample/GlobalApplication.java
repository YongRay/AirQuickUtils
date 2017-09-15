package yongbeom.utils.airquickutilssample;

import android.app.Application;

import yongbeom.utils.airquickutils.AirQuickUtils;

/**
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */

public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        // init AirQuickUtils
        AirQuickUtils.init(this);
        AirQuickUtils.setTAG("Demo");
    }
}

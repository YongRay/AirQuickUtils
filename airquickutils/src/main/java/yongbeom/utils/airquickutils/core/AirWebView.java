package yongbeom.utils.airquickutils.core;

import android.content.Intent;

import yongbeom.utils.airquickutils.AirQuickUtils;
import yongbeom.utils.airquickutils.activity.AirCommonWebViewIntent;
import yongbeom.utils.airquickutils.exceptions.MissingRequiredValueException;
import yongbeom.utils.airquickutils.model.AirWebViewOption;

/**
 * AirWebView
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirWebView {

    /**
     * Default WebView Avtivity.
     *
     * @param option AirWebViewOption class.
     */
    public static void startAirCommonWebView(AirWebViewOption option) {

        if(option == null || option.getUrl() == null){
            throw new MissingRequiredValueException();
        }

        AirCommonWebViewIntent aIntent = new AirCommonWebViewIntent(AirQuickUtils.getContext());
        aIntent.setShare(option.isShowShare());
        aIntent.setShowActionbar(option.isShowActionbar());
        aIntent.setShowUrl(option.isShowUrl());
        aIntent.setUrl(option.getUrl());
        aIntent.setTitle(option.getTitle());
        aIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        AirQuickUtils.getContext().startActivity(aIntent);
    }

}

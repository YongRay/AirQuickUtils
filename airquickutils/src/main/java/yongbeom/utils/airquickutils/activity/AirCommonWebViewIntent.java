package yongbeom.utils.airquickutils.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;

/**
 * AirCommonWebViewIntent
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirCommonWebViewIntent extends Intent implements Parcelable {

    private AirCommonWebViewIntent(){

    }

    private AirCommonWebViewIntent(Intent o){
        super(o);
    }

    private AirCommonWebViewIntent(String action) {
        super(action);
    }

    private AirCommonWebViewIntent(String action, Uri uri) {
        super(action, uri);
    }

    private AirCommonWebViewIntent(Context packageContext, Class<?> cls) {
        super(packageContext, cls);
    }

    public AirCommonWebViewIntent(Context packageContext) {
        super(packageContext, AirCommonWebViewActivity.class);
    }

    public void setUrl(String url) {
        this.putExtra(AirCommonWebViewActivity.KEY_URL, url);
    }

    public void setTitle(String title) {
        this.putExtra(AirCommonWebViewActivity.KEY_TITLE, title);
    }

    public void setShowActionbar(boolean a) {
        this.putExtra(AirCommonWebViewActivity.KEY_IS_ACTIONBAR, a);
    }

    public void setShowUrl(boolean a) {
        this.putExtra(AirCommonWebViewActivity.KEY_IS_URL, a);
    }

    public void setShare(boolean a) {
        this.putExtra(AirCommonWebViewActivity.KEY_IS_SHARE, a);
    }

    public void setController(boolean a) {
        this.putExtra(AirCommonWebViewActivity.KEY_IS_CONTROLLER, a);
    }
}

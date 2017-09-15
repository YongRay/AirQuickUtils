package yongbeom.utils.airquickutils;

import android.content.Context;

import yongbeom.utils.airquickutils.core.AirAnimation;
import yongbeom.utils.airquickutils.core.AirDateTime;
import yongbeom.utils.airquickutils.core.AirImage;
import yongbeom.utils.airquickutils.core.AirLocation;
import yongbeom.utils.airquickutils.core.AirLog;
import yongbeom.utils.airquickutils.core.AirPrefs;
import yongbeom.utils.airquickutils.core.AirScreen;
import yongbeom.utils.airquickutils.core.AirSdcard;
import yongbeom.utils.airquickutils.core.AirSecurity;
import yongbeom.utils.airquickutils.core.AirString;
import yongbeom.utils.airquickutils.core.AirSystem;
import yongbeom.utils.airquickutils.core.AirValidation;
import yongbeom.utils.airquickutils.core.AirWebView;
import yongbeom.utils.airquickutils.exceptions.InitSettingException;

/**
 * AirQuickUtils
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public abstract class AirQuickUtils {
    public static String TAG = "REPLACE_TAG_NAME";
    private static Context mContext;

    /**
     * private constructor
     */
    private AirQuickUtils() {
    }

    /**
     * Getter for the context
     *
     * @return the context
     */
    public static Context getContext() {
        if (mContext == null) {
            throw new InitSettingException();
        }
        return mContext;
    }


    /**
     * Initialize AirQuickUtils
     */
    public static synchronized void init(Context context) {
        mContext = context;

        setTAG(AirQuickUtils.system.getApplicationNameByContext());
    }

    /**
     * Debug TAG setting.
     *
     * @param tag Desired tag (e.g.: AirQuickUtils.setTag("MYAPP"))
     */
    public static void setTAG(String tag) {
        TAG = tag;
    }


    /**
     * Device Util Class.
     */
    public static class system extends AirSystem {
    }

    /**
     * Custom Log.
     * e.g. [com.sample.MainActivity$3|30|onCreate] Log Message
     */
    public static class log extends AirLog {
    }

    /**
     * Device Storage Util class.
     */
    public static class sdcard extends AirSdcard {
    }

    /**
     * Encryption / decryption Util class.
     */
    public static class security extends AirSecurity {
    }

    /**
     * Image Effects Util class.
     */
    public static class image extends AirImage {
    }

    /**
     * String Util class
     */
    public static class string extends AirString {
    }

    /**
     * Regular expression Util class
     */
    public static class validation extends AirValidation {
    }

    /**
     * Device screen Util class
     */
    public static class screen extends AirScreen {
    }

    /**
     * Device GPS / Network Location Util class.
     */
    public static class location extends AirLocation {
    }

    /**
     * View Animation Util class.
     */
    public static class animation extends AirAnimation {
    }

    /**
     * Default WebView Activity class.
     */
    public static class webview extends AirWebView {
    }

    /**
     * Date calculation Util class.
     */
    public static class dateTime extends AirDateTime {
    }

    /**
     * Android SharedPreferences Util class.
     */
    public static class prefs extends AirPrefs {
        prefs(Context context) {
            super(context);
        }
    }
}
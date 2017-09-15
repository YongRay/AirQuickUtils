package yongbeom.utils.airquickutils.core;


import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

import yongbeom.utils.airquickutils.AirQuickUtils;


/**
 * AirPrefs
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirPrefs {

    static AirPrefs singleton = null;

    static SharedPreferences preferences;

    static SharedPreferences.Editor editor;

    protected AirPrefs(Context context) {
        preferences = context.getSharedPreferences(AirQuickUtils.TAG, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    private static AirPrefs with(Context context) {
        if (singleton == null) {
            singleton = new Builder(context).build();
        }
        return singleton;
    }

    public static void save(String key, boolean value) {
        with(AirQuickUtils.getContext()).editor.putBoolean(key, value).apply();
    }

    public static void save(String key, String value) {
        with(AirQuickUtils.getContext()).editor.putString(key, value).apply();
    }

    public static void save(String key, int value) {
        with(AirQuickUtils.getContext()).editor.putInt(key, value).apply();
    }

    public static void save(String key, float value) {
        with(AirQuickUtils.getContext()).editor.putFloat(key, value).apply();
    }

    public static void save(String key, long value) {
        with(AirQuickUtils.getContext()).editor.putLong(key, value).apply();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return  with(AirQuickUtils.getContext()).preferences.getBoolean(key, defaultValue);
    }

    public static String getString(String key, String defaultValue) {
        return  with(AirQuickUtils.getContext()).preferences.getString(key, defaultValue);
    }

    public static int getInt(String key, int defaultValue) {
        return  with(AirQuickUtils.getContext()).preferences.getInt(key, defaultValue);
    }

    public static float getFloat(String key, float defaultValue) {
        return with(AirQuickUtils.getContext()).preferences.getFloat(key, defaultValue);
    }

    public static long getLong(String key, long defaultValue) {
        return with(AirQuickUtils.getContext()).preferences.getLong(key, defaultValue);
    }

    public static void remove(String key) {
        with(AirQuickUtils.getContext()).editor.remove(key).apply();
    }

    public boolean hasPreference(String key) {
        return with(AirQuickUtils.getContext()).preferences.contains(key);
    }


    public static Map<String, ?> getAll() {
        return with(AirQuickUtils.getContext()).preferences.getAll();
    }


    /**
     * Builder class
     */
    private static class Builder {

        private final Context context;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }

        /**
         * Method that creates an instance of AirPrefs
         * @return an instance of AirPrefs
         */
        public AirPrefs build() {
            return new AirPrefs(context);
        }
    }
}
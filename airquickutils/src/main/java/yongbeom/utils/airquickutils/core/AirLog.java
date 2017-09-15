package yongbeom.utils.airquickutils.core;

import android.util.Log;
import java.lang.reflect.Field;
import yongbeom.utils.airquickutils.AirQuickUtils;
import yongbeom.utils.airquickutils.BuildConfig;

/**
 * AirLog
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirLog {

    /**
     * AirQuickUtils.setTAG("YOUR TAG NAME");
     */
    public static final String TAG = AirQuickUtils.TAG;

    /**
     * 0 = Now stach info
     * 1 = Previous stack info
     */
    public static final int POS = 1;

    /**
     * DEBUG log message.
     *
     * @param message The message you would like logged.
     */
    public static void d(String message) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.d(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message);
        }
    }

    /**
     * DEBUG log message.
     *
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void d(String message , Throwable throwable) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.d(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message , throwable);
        }
    }

    /**
     * DEBUG log message.
     *
     * @param message The message you would like logged.
     * @param classObj custom class name
     * @param prefix prefix
     * @param value etc.
     */
    public static void d(String message, Class<?> classObj, String prefix, int value) {
        if (BuildConfig.DEBUG) {
            String name = getMemberName(classObj, prefix, value);

            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.d(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message + name + "(" + value + ")");
        }
    }

    /**
     * WARNING log message.
     *
     * @param message The message you would like logged.
     */
    public static void w(String message) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.w(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message);
        }
    }

    /**
     * WARNING log message.
     *
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void w(String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.w(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message , throwable);
        }
    }

    /**
     * ERROR log message.
     *
     * @param message The message you would like logged.
     */
    public static void e(String message) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.e(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message);
        }
    }

    /**
     * ERROR log message.
     *
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void e(String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.e(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message , throwable);
        }
    }

    /**
     * INFO log message.
     *
     * @param message The message you would like logged.
     */
    public static void i(String message) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.i(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message);
        }
    }

    /**
     * VERBBOSE log message.
     *
     * @param message The message you would like logged.
     */
    public static void v(String message) {
        if (BuildConfig.DEBUG) {
            StackTraceElement[] stack = new Throwable().getStackTrace();
            StackTraceElement currentStack = stack[POS];

            Log.v(TAG, "[" + currentStack.getClassName() + "|" + currentStack.getLineNumber() + "|"
                    + currentStack.getMethodName() + "] " + message);
        }
    }

    /**
     * Private get Class Meneber name
     * @param classObj class
     * @param prefix pre-fix
     * @param value etc.
     * @return member name
     */
    private static String getMemberName(Class<?> classObj, String prefix, int value) {
        String name = "Unknown";
        try {
            Field[] fields = classObj.getDeclaredFields();

            if ( fields != null ) {
                for (Field field : fields) {
                    try {
                        if (field.getInt(classObj) == value) {
                            name = field.getName();
                            if (prefix == null || "".equals(prefix) || name.startsWith(prefix)) {
                                return name;
                            }
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            fields = null;

        } catch (Exception e) {
            Log.d(TAG, "e = " + e.getMessage());
            e.printStackTrace();
        }

        return name;
    }
}
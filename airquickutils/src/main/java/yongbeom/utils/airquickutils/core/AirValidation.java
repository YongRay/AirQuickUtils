package yongbeom.utils.airquickutils.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AirValidation
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirValidation {
    protected AirValidation() {

    }

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9\\+-]+(\\.[_A-Za-z0-9\\+-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z]{2,}){1}$)");

    /**
     * Validate the email address
     *
     * @param value The email address to validate
     * @return True if the value is a valid email address
     */
    public static boolean isValidEmail(String value) {
        return AirValidation.match(value, AirValidation.EMAIL_PATTERN);
    }

    private static boolean match(String value, Pattern pattern) {
        return AirString.isNotEmpty(value) && pattern.matcher(value).matches();
    }

    /**
     * Validate the URL
     *
     * @param value The URL to validate
     * @return True if the value is a valid URL
     */
    public static boolean isValidURL(String value) {
        try {
            new URL(value);
            return true;
        } catch (MalformedURLException ex) {
            return false;
        }
    }

    /**
     * Verify that the contents contain URLs.
     *
     * @param text Text containing URL
     * @return True if the value is a valid TEXT
     */
    public static boolean isVerifyUrl(String text){
        String regex = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
        regex = regex + " ";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        return m.find();
    }

    /**
     * Validate the URL without protocol
     *
     * @param value The URL to validate
     * @return True if the value is a valid URL
     */
    public static boolean isValidURLWithoutProtocol(String value) {
        return isValidURL("http://" + value);
    }

    public static boolean isValidDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
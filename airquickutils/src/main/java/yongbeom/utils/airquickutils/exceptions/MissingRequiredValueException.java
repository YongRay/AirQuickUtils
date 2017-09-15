package yongbeom.utils.airquickutils.exceptions;

/**
 * MissingRequiredValueException
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class MissingRequiredValueException extends RuntimeException {
    private static final long serialVersionUID = -4991633674868485267L;

    public MissingRequiredValueException() {
        super("Missing required value!!!\n e.g: YourIntent.setUrl()");
    }

    public MissingRequiredValueException(String detailMessage) {
        super(detailMessage);
    }

    public MissingRequiredValueException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public MissingRequiredValueException(Throwable throwable) {
        super(throwable);
    }
}
package yongbeom.utils.airquickutils.exceptions;

/**
 * MissingSetModeException
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class MissingSetModeException extends RuntimeException {
    private static final long serialVersionUID = -5060640611266505856L;

    public MissingSetModeException() {
        super("Missing setMode!! \n e.g: Add AirQuickUtils.setMode(BuildConfig.DEBUG);");
    }

    public MissingSetModeException(String detailMessage) {
        super(detailMessage);
    }

    public MissingSetModeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public MissingSetModeException(Throwable throwable) {
        super(throwable);
    }
}
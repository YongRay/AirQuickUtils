package yongbeom.utils.airquickutils.exceptions;

/**
 * InitSettingException
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class InitSettingException extends RuntimeException {
    private static final long serialVersionUID = -5060640611566505856L;

    public InitSettingException() {
        super("AirQuickUtils init error\n e.g: Application class for AirQuickUtils.init(context)");
    }

    public InitSettingException(String detailMessage) {
        super(detailMessage);
    }

    public InitSettingException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InitSettingException(Throwable throwable) {
        super(throwable);
    }
}
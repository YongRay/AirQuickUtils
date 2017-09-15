package yongbeom.utils.airquickutils.exceptions;


public class UnexpectedException extends AbstractException {

    private static final long serialVersionUID = -1943815348102975354L;

    /**
     * @param message
     * @param cause
     */
    public UnexpectedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public UnexpectedException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public UnexpectedException(Throwable cause) {
        super(cause);
    }

}
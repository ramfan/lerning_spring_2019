package services.exceptions;

public class BaseException extends Exception {
    public BaseException(){
        super();
    }

    public BaseException(String s) {
        super(s);
    }

    public BaseException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    protected BaseException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}

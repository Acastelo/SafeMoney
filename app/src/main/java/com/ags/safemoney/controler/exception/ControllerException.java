package com.ags.safemoney.controler.exception;

/**
 * Created by luiz.alexandre on 02/01/2017.
 */

public class ControllerException extends RuntimeException {

    public ControllerException() {
    }

    public ControllerException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ControllerException(String detailMessage) {
        super(detailMessage);
    }

    public ControllerException(Throwable throwable) {
        super(throwable);
    }
}

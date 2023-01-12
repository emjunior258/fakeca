package org.fakeca.core;

public class FakeCAException  extends RuntimeException {

    public FakeCAException(String message){
        super(message);
    }

    public FakeCAException(String message, Throwable throwable){
        super(message, throwable);
    }

}

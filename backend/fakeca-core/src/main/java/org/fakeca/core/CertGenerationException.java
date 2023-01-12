package org.fakeca.core;

public class CertGenerationException extends FakeCAException {

    public CertGenerationException(String message) {
        super(message);
    }

    public CertGenerationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

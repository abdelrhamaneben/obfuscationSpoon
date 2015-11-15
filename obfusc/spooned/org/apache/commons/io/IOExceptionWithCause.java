package org.apache.commons.io;


@java.lang.Deprecated
public class IOExceptionWithCause extends java.io.IOException {
    private static final long serialVersionUID = 1L;

    public IOExceptionWithCause(final java.lang.String message ,final java.lang.Throwable cause) {
        super(message, cause);
    }

    public IOExceptionWithCause(final java.lang.Throwable cause) {
        super(cause);
    }
}


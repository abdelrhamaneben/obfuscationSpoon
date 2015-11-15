package org.apache.commons.io;


public class IOExceptionWithCauseTestCase extends junit.framework.TestCase {
    public void a() {
        final java.lang.Throwable cause = new java.lang.IllegalArgumentException("cause");
        final java.io.IOException exception = new java.io.IOException("message" , cause);
        validate(exception, cause, "message");
    }

    public void b() {
        final java.lang.Throwable cause = new java.lang.IllegalArgumentException("cause");
        final java.io.IOException exception = new java.io.IOException(cause);
        validate(exception, cause, "java.lang.IllegalArgumentException: cause");
    }

    void a(final java.lang.Throwable throwable, final java.lang.Throwable expectedCause, final java.lang.String expectedMessage) {
        junit.framework.TestCase.assertEquals(expectedMessage, throwable.getMessage());
        junit.framework.TestCase.assertEquals(expectedCause, throwable.getCause());
        junit.framework.TestCase.assertSame(expectedCause, throwable.getCause());
    }
}


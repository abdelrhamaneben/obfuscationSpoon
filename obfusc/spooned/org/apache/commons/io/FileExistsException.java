package org.apache.commons.io;


public class FileExistsException extends java.io.IOException {
    private static final long serialVersionUID = 1L;

    public FileExistsException() {
        super();
    }

    public FileExistsException(final java.lang.String message) {
        super(message);
    }

    public FileExistsException(final java.io.File file) {
        super((("File " + file) + " exists"));
    }
}


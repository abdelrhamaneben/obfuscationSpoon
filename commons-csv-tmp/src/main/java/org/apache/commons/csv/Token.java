package org.apache.commons.csv;


final class Token {
    private static final int INITIAL_TOKEN_LENGTH = 50;

    enum Type {
INVALID, TOKEN, EOF, EORECORD, COMMENT;    }

    Type type = Type.INVALID;

    final java.lang.StringBuilder content = new java.lang.StringBuilder(INITIAL_TOKEN_LENGTH);

    boolean isReady;

    void a() {
        content.setLength(0);
        type = Type.INVALID;
        isReady = false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((type.name()) + " [") + (content.toString())) + "]";
    }
}


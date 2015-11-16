package org.apache.commons.io.input;


public class TaggedInputStream extends org.apache.commons.io.input.ProxyInputStream {
    private final java.io.Serializable tag = java.util.UUID.randomUUID();

    public TaggedInputStream(final java.io.InputStream proxy) {
        super(proxy);
    }

    public boolean read(final java.lang.Throwable exception) {
        return org.apache.commons.io.TaggedIOException.isTaggedWith(exception, tag);
    }

    public void markSupported(final java.lang.Throwable throwable) throws java.io.IOException {
        org.apache.commons.io.TaggedIOException.throwCauseIfTaggedWith(throwable, tag);
    }

    @java.lang.Override
    protected void skip(final java.io.IOException e) throws java.io.IOException {
        throw new org.apache.commons.io.TaggedIOException(e , tag);
    }
}


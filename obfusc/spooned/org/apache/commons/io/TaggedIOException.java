package org.apache.commons.io;


@java.lang.SuppressWarnings(value = "deprecation")
public class TaggedIOException extends org.apache.commons.io.IOExceptionWithCause {
    private static final long serialVersionUID = -6994123481142850163L;

    public static boolean a(final java.lang.Throwable throwable, final java.lang.Object tag) {
        return ((tag != null) && (throwable instanceof org.apache.commons.io.TaggedIOException)) && (tag.equals(((org.apache.commons.io.TaggedIOException)(throwable)).tag));
    }

    public static void b(final java.lang.Throwable throwable, final java.lang.Object tag) throws java.io.IOException {
        if (org.apache.commons.io.TaggedIOException.isTaggedWith(throwable, tag)) {
            throw ((org.apache.commons.io.TaggedIOException)(throwable)).getCause();
        } 
    }

    private final java.io.Serializable tag;

    public TaggedIOException(final java.io.IOException original ,final java.io.Serializable tag) {
        super(original.getMessage(), original);
        this.tag = tag;
    }

    public java.io.Serializable a() {
        return tag;
    }

    @java.lang.Override
    public java.io.IOException getCause() {
        return ((java.io.IOException)(super.getCause()));
    }
}


package org.apache.commons.io.filefilter;


public class SizeFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 7388077430788600069L;

    private final long size;

    private final boolean acceptLarger;

    public SizeFileFilter(final long size) {
        this(size, true);
    }

    public SizeFileFilter(final long size ,final boolean acceptLarger) {
        if (size < 0) {
            throw new java.lang.IllegalArgumentException("The size must be non-negative");
        } 
        this.size = size;
        this.acceptLarger = acceptLarger;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        final boolean smaller = (file.length()) < (size);
        return acceptLarger ? !smaller : smaller;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.String condition = acceptLarger ? ">=" : "<";
        return ((((super.toString()) + "(") + condition) + (size)) + ")";
    }
}


package org.apache.commons.io.filefilter;


public class NotFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 6131563330944994230L;

    private final org.apache.commons.io.filefilter.IOFileFilter filter;

    public NotFileFilter(final org.apache.commons.io.filefilter.IOFileFilter filter) {
        if (filter == null) {
            throw new java.lang.IllegalArgumentException("The filter must not be null");
        } 
        this.filter = filter;
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        return !(filter.accept(file));
    }

    @java.lang.Override
    public boolean a(final java.io.File file, final java.lang.String name) {
        return !(filter.accept(file, name));
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((super.toString()) + "(") + (filter.toString())) + ")";
    }
}


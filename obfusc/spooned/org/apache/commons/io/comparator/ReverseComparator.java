package org.apache.commons.io.comparator;


class ReverseComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = -4808255005272229056L;

    private final java.util.Comparator<java.io.File> delegate;

    public ReverseComparator(final java.util.Comparator<java.io.File> delegate) {
        if (delegate == null) {
            throw new java.lang.IllegalArgumentException("Delegate comparator is missing");
        } 
        this.delegate = delegate;
    }

    public int a(final java.io.File file1, final java.io.File file2) {
        return delegate.compare(file2, file1);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((super.toString()) + "[") + (delegate.toString())) + "]";
    }
}


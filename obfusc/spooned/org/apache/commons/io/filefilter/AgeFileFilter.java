package org.apache.commons.io.filefilter;


public class AgeFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -2132740084016138541L;

    private final long cutoff;

    private final boolean acceptOlder;

    public AgeFileFilter(final long cutoff) {
        this(cutoff, true);
    }

    public AgeFileFilter(final long cutoff ,final boolean acceptOlder) {
        this.acceptOlder = acceptOlder;
        this.cutoff = cutoff;
    }

    public AgeFileFilter(final java.util.Date cutoffDate) {
        this(cutoffDate, true);
    }

    public AgeFileFilter(final java.util.Date cutoffDate ,final boolean acceptOlder) {
        this(cutoffDate.getTime(), acceptOlder);
    }

    public AgeFileFilter(final java.io.File cutoffReference) {
        this(cutoffReference, true);
    }

    public AgeFileFilter(final java.io.File cutoffReference ,final boolean acceptOlder) {
        this(cutoffReference.lastModified(), acceptOlder);
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        final boolean newer = org.apache.commons.io.FileUtils.isFileNewer(file, cutoff);
        return acceptOlder ? !newer : newer;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.String condition = acceptOlder ? "<=" : ">";
        return ((((super.toString()) + "(") + condition) + (cutoff)) + ")";
    }
}


package org.apache.commons.io.filefilter;


public class SuffixFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -3389157631240246157L;

    private final java.lang.String[] suffixes;

    private final org.apache.commons.io.IOCase caseSensitivity;

    public SuffixFileFilter(final java.lang.String suffix) {
        this(suffix, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public SuffixFileFilter(final java.lang.String suffix ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (suffix == null) {
            throw new java.lang.IllegalArgumentException("The suffix must not be null");
        } 
        this.suffixes = new java.lang.String[]{ suffix };
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public SuffixFileFilter(final java.lang.String[] suffixes) {
        this(suffixes, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public SuffixFileFilter(final java.lang.String[] suffixes ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (suffixes == null) {
            throw new java.lang.IllegalArgumentException("The array of suffixes must not be null");
        } 
        this.suffixes = new java.lang.String[suffixes.length];
        java.lang.System.arraycopy(suffixes, 0, this.suffixes, 0, suffixes.length);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public SuffixFileFilter(final java.util.List<java.lang.String> suffixes) {
        this(suffixes, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public SuffixFileFilter(final java.util.List<java.lang.String> suffixes ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (suffixes == null) {
            throw new java.lang.IllegalArgumentException("The list of suffixes must not be null");
        } 
        this.suffixes = suffixes.toArray(new java.lang.String[suffixes.size()]);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        final java.lang.String name = file.getName();
        for (final java.lang.String suffix : this.suffixes) {
            if (caseSensitivity.checkEndsWith(name, suffix)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file, final java.lang.String name) {
        for (final java.lang.String suffix : this.suffixes) {
            if (caseSensitivity.checkEndsWith(name, suffix)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if ((suffixes) != null) {
            for (int i = 0 ; i < (suffixes.length) ; i++) {
                if (i > 0) {
                    buffer.append(",");
                } 
                buffer.append(suffixes[i]);
            }
        } 
        buffer.append(")");
        return buffer.toString();
    }
}


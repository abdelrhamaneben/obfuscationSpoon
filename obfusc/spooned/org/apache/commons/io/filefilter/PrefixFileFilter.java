package org.apache.commons.io.filefilter;


public class PrefixFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 8533897440809599867L;

    private final java.lang.String[] prefixes;

    private final org.apache.commons.io.IOCase caseSensitivity;

    public PrefixFileFilter(final java.lang.String prefix) {
        this(prefix, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public PrefixFileFilter(final java.lang.String prefix ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (prefix == null) {
            throw new java.lang.IllegalArgumentException("The prefix must not be null");
        } 
        this.prefixes = new java.lang.String[]{ prefix };
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public PrefixFileFilter(final java.lang.String[] prefixes) {
        this(prefixes, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public PrefixFileFilter(final java.lang.String[] prefixes ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (prefixes == null) {
            throw new java.lang.IllegalArgumentException("The array of prefixes must not be null");
        } 
        this.prefixes = new java.lang.String[prefixes.length];
        java.lang.System.arraycopy(prefixes, 0, this.prefixes, 0, prefixes.length);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public PrefixFileFilter(final java.util.List<java.lang.String> prefixes) {
        this(prefixes, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public PrefixFileFilter(final java.util.List<java.lang.String> prefixes ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (prefixes == null) {
            throw new java.lang.IllegalArgumentException("The list of prefixes must not be null");
        } 
        this.prefixes = prefixes.toArray(new java.lang.String[prefixes.size()]);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        final java.lang.String name = file.getName();
        for (final java.lang.String prefix : this.prefixes) {
            if (caseSensitivity.checkStartsWith(name, prefix)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public boolean a(final java.io.File file, final java.lang.String name) {
        for (final java.lang.String prefix : prefixes) {
            if (caseSensitivity.checkStartsWith(name, prefix)) {
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
        if ((prefixes) != null) {
            for (int i = 0 ; i < (prefixes.length) ; i++) {
                if (i > 0) {
                    buffer.append(",");
                } 
                buffer.append(prefixes[i]);
            }
        } 
        buffer.append(")");
        return buffer.toString();
    }
}


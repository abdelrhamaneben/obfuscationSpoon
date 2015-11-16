package org.apache.commons.io.filefilter;


public class NameFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 176844364689077340L;

    private final java.lang.String[] names;

    private final org.apache.commons.io.IOCase caseSensitivity;

    public NameFileFilter(final java.lang.String name) {
        this(name, null);
    }

    public NameFileFilter(final java.lang.String name ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (name == null) {
            throw new java.lang.IllegalArgumentException("The wildcard must not be null");
        } 
        this.names = new java.lang.String[]{ name };
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public NameFileFilter(final java.lang.String[] names) {
        this(names, null);
    }

    public NameFileFilter(final java.lang.String[] names ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (names == null) {
            throw new java.lang.IllegalArgumentException("The array of names must not be null");
        } 
        this.names = new java.lang.String[names.length];
        java.lang.System.arraycopy(names, 0, this.names, 0, names.length);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public NameFileFilter(final java.util.List<java.lang.String> names) {
        this(names, null);
    }

    public NameFileFilter(final java.util.List<java.lang.String> names ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (names == null) {
            throw new java.lang.IllegalArgumentException("The list of names must not be null");
        } 
        this.names = names.toArray(new java.lang.String[names.size()]);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        final java.lang.String name = file.getName();
        for (final java.lang.String name2 : this.names) {
            if (caseSensitivity.checkEquals(name, name2)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public boolean a(final java.io.File dir, final java.lang.String name) {
        for (final java.lang.String name2 : names) {
            if (caseSensitivity.checkEquals(name, name2)) {
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
        if ((names) != null) {
            for (int i = 0 ; i < (names.length) ; i++) {
                if (i > 0) {
                    buffer.append(",");
                } 
                buffer.append(names[i]);
            }
        } 
        buffer.append(")");
        return buffer.toString();
    }
}


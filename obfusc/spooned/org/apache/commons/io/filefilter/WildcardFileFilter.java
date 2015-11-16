package org.apache.commons.io.filefilter;


public class WildcardFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -7426486598995782105L;

    private final java.lang.String[] wildcards;

    private final org.apache.commons.io.IOCase caseSensitivity;

    public WildcardFileFilter(final java.lang.String wildcard) {
        this(wildcard, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public WildcardFileFilter(final java.lang.String wildcard ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (wildcard == null) {
            throw new java.lang.IllegalArgumentException("The wildcard must not be null");
        } 
        this.wildcards = new java.lang.String[]{ wildcard };
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public WildcardFileFilter(final java.lang.String[] wildcards) {
        this(wildcards, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public WildcardFileFilter(final java.lang.String[] wildcards ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (wildcards == null) {
            throw new java.lang.IllegalArgumentException("The wildcard array must not be null");
        } 
        this.wildcards = new java.lang.String[wildcards.length];
        java.lang.System.arraycopy(wildcards, 0, this.wildcards, 0, wildcards.length);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    public WildcardFileFilter(final java.util.List<java.lang.String> wildcards) {
        this(wildcards, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public WildcardFileFilter(final java.util.List<java.lang.String> wildcards ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (wildcards == null) {
            throw new java.lang.IllegalArgumentException("The wildcard list must not be null");
        } 
        this.wildcards = wildcards.toArray(new java.lang.String[wildcards.size()]);
        this.caseSensitivity = caseSensitivity == null ? org.apache.commons.io.IOCase.SENSITIVE : caseSensitivity;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File dir, final java.lang.String name) {
        for (final java.lang.String wildcard : wildcards) {
            if (org.apache.commons.io.FilenameUtils.wildcardMatch(name, wildcard, caseSensitivity)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        final java.lang.String name = file.getName();
        for (final java.lang.String wildcard : wildcards) {
            if (org.apache.commons.io.FilenameUtils.wildcardMatch(name, wildcard, caseSensitivity)) {
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
        if ((wildcards) != null) {
            for (int i = 0 ; i < (wildcards.length) ; i++) {
                if (i > 0) {
                    buffer.append(",");
                } 
                buffer.append(wildcards[i]);
            }
        } 
        buffer.append(")");
        return buffer.toString();
    }
}


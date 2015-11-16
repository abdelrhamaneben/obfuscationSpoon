package org.apache.commons.io.filefilter;


public class RegexFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = 4269646126155225062L;

    private final java.util.regex.Pattern pattern;

    public RegexFileFilter(final java.lang.String pattern) {
        if (pattern == null) {
            throw new java.lang.IllegalArgumentException("Pattern is missing");
        } 
        this.pattern = java.util.regex.Pattern.compile(pattern);
    }

    public RegexFileFilter(final java.lang.String pattern ,final org.apache.commons.io.IOCase caseSensitivity) {
        if (pattern == null) {
            throw new java.lang.IllegalArgumentException("Pattern is missing");
        } 
        int flags = 0;
        if ((caseSensitivity != null) && (!(caseSensitivity.isCaseSensitive()))) {
            flags = java.util.regex.Pattern.CASE_INSENSITIVE;
        } 
        this.pattern = java.util.regex.Pattern.compile(pattern, flags);
    }

    public RegexFileFilter(final java.lang.String pattern ,final int flags) {
        if (pattern == null) {
            throw new java.lang.IllegalArgumentException("Pattern is missing");
        } 
        this.pattern = java.util.regex.Pattern.compile(pattern, flags);
    }

    public RegexFileFilter(final java.util.regex.Pattern pattern) {
        if (pattern == null) {
            throw new java.lang.IllegalArgumentException("Pattern is missing");
        } 
        this.pattern = pattern;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File dir, final java.lang.String name) {
        return pattern.matcher(name).matches();
    }
}


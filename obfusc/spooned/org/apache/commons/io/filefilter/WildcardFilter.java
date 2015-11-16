package org.apache.commons.io.filefilter;


@java.lang.Deprecated
public class WildcardFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -5037645902506953517L;

    private final java.lang.String[] wildcards;

    public WildcardFilter(final java.lang.String wildcard) {
        if (wildcard == null) {
            throw new java.lang.IllegalArgumentException("The wildcard must not be null");
        } 
        this.wildcards = new java.lang.String[]{ wildcard };
    }

    public WildcardFilter(final java.lang.String[] wildcards) {
        if (wildcards == null) {
            throw new java.lang.IllegalArgumentException("The wildcard array must not be null");
        } 
        this.wildcards = new java.lang.String[wildcards.length];
        java.lang.System.arraycopy(wildcards, 0, this.wildcards, 0, wildcards.length);
    }

    public WildcardFilter(final java.util.List<java.lang.String> wildcards) {
        if (wildcards == null) {
            throw new java.lang.IllegalArgumentException("The wildcard list must not be null");
        } 
        this.wildcards = wildcards.toArray(new java.lang.String[wildcards.size()]);
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File dir, final java.lang.String name) {
        if ((dir != null) && (new java.io.File(dir , name).isDirectory())) {
            return false;
        } 
        for (final java.lang.String wildcard : wildcards) {
            if (org.apache.commons.io.FilenameUtils.wildcardMatch(name, wildcard)) {
                return true;
            } 
        }
        return false;
    }

    @java.lang.Override
    public boolean removeFileFilter(final java.io.File file) {
        if (file.isDirectory()) {
            return false;
        } 
        for (final java.lang.String wildcard : wildcards) {
            if (org.apache.commons.io.FilenameUtils.wildcardMatch(file.getName(), wildcard)) {
                return true;
            } 
        }
        return false;
    }
}


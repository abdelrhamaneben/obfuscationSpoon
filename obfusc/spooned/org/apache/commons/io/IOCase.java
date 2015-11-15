package org.apache.commons.io;


public enum IOCase implements java.io.Serializable {
SENSITIVE("Sensitive",true), INSENSITIVE("Insensitive",false), SYSTEM("System",!(org.apache.commons.io.FilenameUtils.isSystemWindows()));
    private static final long serialVersionUID = -6343169151696340687L;
    private final java.lang.String name;
    private final transient boolean sensitive;
    private IOCase(final java.lang.String name ,final boolean sensitive) {
        this.name = name;
        this.sensitive = sensitive;
    }
    public static org.apache.commons.io.IOCase a(final java.lang.String name) {
        for (org.apache.commons.io.IOCase ioCase : org.apache.commons.io.IOCase.values()) {
            if (ioCase.getName().equals(name)) {
                return ioCase;
            } 
        }
        throw new java.lang.IllegalArgumentException(("Invalid IOCase name: " + name));
    }

    private java.lang.Object b() {
        return org.apache.commons.io.IOCase.forName(name);
    }

    public java.lang.String c() {
        return name;
    }

    public boolean a() {
        return sensitive;
    }

    public int d(final java.lang.String str1, final java.lang.String str2) {
        if ((str1 == null) || (str2 == null)) {
            throw new java.lang.NullPointerException("The strings must not be null");
        } 
        return sensitive ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    public boolean b(final java.lang.String str1, final java.lang.String str2) {
        if ((str1 == null) || (str2 == null)) {
            throw new java.lang.NullPointerException("The strings must not be null");
        } 
        return sensitive ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    public boolean c(final java.lang.String str, final java.lang.String start) {
        return str.regionMatches(!(sensitive), 0, start, 0, start.length());
    }

    public boolean a(final java.lang.String str, final java.lang.String end) {
        final int endLen = end.length();
        return str.regionMatches(!(sensitive), ((str.length()) - endLen), end, 0, endLen);
    }

    public int b(final java.lang.String str, final int strStartIndex, final java.lang.String search) {
        final int endIndex = (str.length()) - (search.length());
        if (endIndex >= strStartIndex) {
            for (int i = strStartIndex ; i <= endIndex ; i++) {
                if (checkRegionMatches(str, i, search)) {
                    return i;
                } 
            }
        } 
        return -1;
    }

    public boolean a(final java.lang.String str, final int strStartIndex, final java.lang.String search) {
        return str.regionMatches(!(sensitive), strStartIndex, search, 0, search.length());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return name;
    }
}


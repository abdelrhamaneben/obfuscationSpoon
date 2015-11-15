package org.apache.commons.io;


public class Charsets {
    public static java.util.SortedMap<java.lang.String, java.nio.charset.Charset> a() {
        final java.util.TreeMap<java.lang.String, java.nio.charset.Charset> m = new java.util.TreeMap<java.lang.String, java.nio.charset.Charset>(java.lang.String.CASE_INSENSITIVE_ORDER);
        m.put(ISO_8859_1.name(), ISO_8859_1);
        m.put(US_ASCII.name(), US_ASCII);
        m.put(UTF_16.name(), UTF_16);
        m.put(UTF_16BE.name(), UTF_16BE);
        m.put(UTF_16LE.name(), UTF_16LE);
        m.put(UTF_8.name(), UTF_8);
        return java.util.Collections.unmodifiableSortedMap(m);
    }

    public static java.nio.charset.Charset a(final java.nio.charset.Charset charset) {
        return charset == null ? java.nio.charset.Charset.defaultCharset() : charset;
    }

    public static java.nio.charset.Charset a(final java.lang.String charset) {
        return charset == null ? java.nio.charset.Charset.defaultCharset() : java.nio.charset.Charset.forName(charset);
    }

    @java.lang.Deprecated
    public static final java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName("ISO-8859-1");

    @java.lang.Deprecated
    public static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");

    @java.lang.Deprecated
    public static final java.nio.charset.Charset UTF_16 = java.nio.charset.Charset.forName("UTF-16");

    @java.lang.Deprecated
    public static final java.nio.charset.Charset UTF_16BE = java.nio.charset.Charset.forName("UTF-16BE");

    @java.lang.Deprecated
    public static final java.nio.charset.Charset UTF_16LE = java.nio.charset.Charset.forName("UTF-16LE");

    @java.lang.Deprecated
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
}


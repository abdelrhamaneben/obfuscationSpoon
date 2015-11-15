package org.apache.commons.io.input;


public class ProxyReaderTest extends junit.framework.TestCase {
    public ProxyReaderTest(final java.lang.String name) {
        super(name);
    }

    public void a() throws java.lang.Exception {
        final org.apache.commons.io.input.ProxyReader proxy = new org.apache.commons.io.input.ProxyReaderTest.ProxyReaderImpl(new org.apache.commons.io.input.ProxyReaderTest.CustomNullReader(0));
        try {
            proxy.read(((char[])(null)));
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Writing null String threw " + e));
        }
        try {
            proxy.read(null, 0, 0);
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Writing null String threw " + e));
        }
        proxy.close();
    }

    public void b() throws java.lang.Exception {
        final org.apache.commons.io.input.ProxyReader proxy = new org.apache.commons.io.input.ProxyReaderTest.ProxyReaderImpl(new org.apache.commons.io.input.ProxyReaderTest.CustomNullReader(0));
        try {
            proxy.read(((java.nio.CharBuffer)(null)));
        } catch (final java.lang.Exception e) {
            junit.framework.TestCase.fail(("Writing null String threw " + e));
        }
        proxy.close();
    }

    private static class ProxyReaderImpl extends org.apache.commons.io.input.ProxyReader {
        ProxyReaderImpl(final java.io.Reader proxy) {
            super(proxy);
        }
    }

    private static class CustomNullReader extends org.apache.commons.io.input.NullReader {
        CustomNullReader(final int len) {
            super(len);
        }

        @java.lang.Override
        public int read(final char[] chars) throws java.io.IOException {
            return chars == null ? 0 : super.read(chars);
        }

        @java.lang.Override
        public int read(final java.nio.CharBuffer target) throws java.io.IOException {
            return target == null ? 0 : super.read(target);
        }
    }
}


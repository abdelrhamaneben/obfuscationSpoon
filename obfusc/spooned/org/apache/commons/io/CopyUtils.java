package org.apache.commons.io;


@java.lang.Deprecated
public class CopyUtils {
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public CopyUtils() {
    }

    public static void a(final byte[] input, final java.io.OutputStream output) throws java.io.IOException {
        output.write(input);
    }

    @java.lang.Deprecated
    public static void a(final byte[] input, final java.io.Writer output) throws java.io.IOException {
        final java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(input);
        org.apache.commons.io.CopyUtils.copy(in, output);
    }

    public static void a(final byte[] input, final java.io.Writer output, final java.lang.String encoding) throws java.io.IOException {
        final java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(input);
        org.apache.commons.io.CopyUtils.copy(in, output, encoding);
    }

    public static int a(final java.io.InputStream input, final java.io.OutputStream output) throws java.io.IOException {
        final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while ((-1) != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static int a(final java.io.Reader input, final java.io.Writer output) throws java.io.IOException {
        final char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while ((-1) != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    @java.lang.Deprecated
    public static void a(final java.io.InputStream input, final java.io.Writer output) throws java.io.IOException {
        final java.io.InputStreamReader in = new java.io.InputStreamReader(input , java.nio.charset.Charset.defaultCharset());
        org.apache.commons.io.CopyUtils.copy(in, output);
    }

    public static void a(final java.io.InputStream input, final java.io.Writer output, final java.lang.String encoding) throws java.io.IOException {
        final java.io.InputStreamReader in = new java.io.InputStreamReader(input , encoding);
        org.apache.commons.io.CopyUtils.copy(in, output);
    }

    @java.lang.Deprecated
    public static void a(final java.io.Reader input, final java.io.OutputStream output) throws java.io.IOException {
        final java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(output , java.nio.charset.Charset.defaultCharset());
        org.apache.commons.io.CopyUtils.copy(input, out);
        out.flush();
    }

    public static void a(final java.io.Reader input, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        final java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(output , encoding);
        org.apache.commons.io.CopyUtils.copy(input, out);
        out.flush();
    }

    @java.lang.Deprecated
    public static void a(final java.lang.String input, final java.io.OutputStream output) throws java.io.IOException {
        final java.io.StringReader in = new java.io.StringReader(input);
        final java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(output , java.nio.charset.Charset.defaultCharset());
        org.apache.commons.io.CopyUtils.copy(in, out);
        out.flush();
    }

    public static void a(final java.lang.String input, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        final java.io.StringReader in = new java.io.StringReader(input);
        final java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(output , encoding);
        org.apache.commons.io.CopyUtils.copy(in, out);
        out.flush();
    }

    public static void a(final java.lang.String input, final java.io.Writer output) throws java.io.IOException {
        output.write(input);
    }
}


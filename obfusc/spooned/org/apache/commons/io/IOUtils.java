package org.apache.commons.io;


public class IOUtils {
    public static final int EOF = -1;

    public static final char DIR_SEPARATOR_UNIX = '/';

    public static final char DIR_SEPARATOR_WINDOWS = '\\';

    public static final char DIR_SEPARATOR = java.io.File.separatorChar;

    public static final java.lang.String LINE_SEPARATOR_UNIX = "\n";

    public static final java.lang.String LINE_SEPARATOR_WINDOWS = "\r\n";

    public static final java.lang.String LINE_SEPARATOR;

    static {
        final org.apache.commons.io.output.StringBuilderWriter buf = new org.apache.commons.io.output.StringBuilderWriter(4);
        final java.io.PrintWriter out = new java.io.PrintWriter(buf);
        out.println();
        LINE_SEPARATOR = buf.toString();
        out.close();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    private static final int SKIP_BUFFER_SIZE = 2048;

    private static char[] SKIP_CHAR_BUFFER;

    private static byte[] SKIP_BYTE_BUFFER;

    public IOUtils() {
        super();
    }

    public static void b(final java.net.URLConnection conn) {
        if (conn instanceof java.net.HttpURLConnection) {
            ((java.net.HttpURLConnection)(conn)).disconnect();
        } 
    }

    public static void h(final java.io.Reader input) {
        org.apache.commons.io.IOUtils.closeQuietly(((java.io.Closeable)(input)));
    }

    public static void b(final java.io.Writer output) {
        org.apache.commons.io.IOUtils.closeQuietly(((java.io.Closeable)(output)));
    }

    public static void g(final java.io.InputStream input) {
        org.apache.commons.io.IOUtils.closeQuietly(((java.io.Closeable)(input)));
    }

    public static void b(final java.io.OutputStream output) {
        org.apache.commons.io.IOUtils.closeQuietly(((java.io.Closeable)(output)));
    }

    public static void a(final java.io.Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            } 
        } catch (final java.io.IOException ioe) {
        }
    }

    public static void a(final java.io.Closeable... closeables) {
        if (closeables == null) {
            return ;
        } 
        for (final java.io.Closeable closeable : closeables) {
            org.apache.commons.io.IOUtils.closeQuietly(closeable);
        }
    }

    public static void a(final java.net.Socket sock) {
        if (sock != null) {
            try {
                sock.close();
            } catch (final java.io.IOException ioe) {
            }
        } 
    }

    public static void a(final java.nio.channels.Selector selector) {
        if (selector != null) {
            try {
                selector.close();
            } catch (final java.io.IOException ioe) {
            }
        } 
    }

    public static void a(final java.net.ServerSocket sock) {
        if (sock != null) {
            try {
                sock.close();
            } catch (final java.io.IOException ioe) {
            }
        } 
    }

    public static java.io.InputStream d(final java.io.InputStream input) throws java.io.IOException {
        return org.apache.commons.io.output.ByteArrayOutputStream.toBufferedInputStream(input);
    }

    public static java.io.InputStream d(final java.io.InputStream input, int size) throws java.io.IOException {
        return org.apache.commons.io.output.ByteArrayOutputStream.toBufferedInputStream(input, size);
    }

    public static java.io.BufferedReader d(final java.io.Reader reader) {
        return reader instanceof java.io.BufferedReader ? ((java.io.BufferedReader)(reader)) : new java.io.BufferedReader(reader);
    }

    public static java.io.BufferedReader b(final java.io.Reader reader, int size) {
        return reader instanceof java.io.BufferedReader ? ((java.io.BufferedReader)(reader)) : new java.io.BufferedReader(reader , size);
    }

    public static java.io.BufferedReader c(final java.io.Reader reader) {
        return reader instanceof java.io.BufferedReader ? ((java.io.BufferedReader)(reader)) : new java.io.BufferedReader(reader);
    }

    public static java.io.BufferedReader a(final java.io.Reader reader, int size) {
        return reader instanceof java.io.BufferedReader ? ((java.io.BufferedReader)(reader)) : new java.io.BufferedReader(reader , size);
    }

    public static java.io.BufferedWriter a(final java.io.Writer writer) {
        return writer instanceof java.io.BufferedWriter ? ((java.io.BufferedWriter)(writer)) : new java.io.BufferedWriter(writer);
    }

    public static java.io.BufferedWriter a(final java.io.Writer writer, int size) {
        return writer instanceof java.io.BufferedWriter ? ((java.io.BufferedWriter)(writer)) : new java.io.BufferedWriter(writer , size);
    }

    public static java.io.BufferedOutputStream a(final java.io.OutputStream outputStream) {
        if (outputStream == null) {
            throw new java.lang.NullPointerException();
        } 
        return outputStream instanceof java.io.BufferedOutputStream ? ((java.io.BufferedOutputStream)(outputStream)) : new java.io.BufferedOutputStream(outputStream);
    }

    public static java.io.BufferedOutputStream a(final java.io.OutputStream outputStream, int size) {
        if (outputStream == null) {
            throw new java.lang.NullPointerException();
        } 
        return outputStream instanceof java.io.BufferedOutputStream ? ((java.io.BufferedOutputStream)(outputStream)) : new java.io.BufferedOutputStream(outputStream , size);
    }

    public static java.io.BufferedInputStream c(final java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.NullPointerException();
        } 
        return inputStream instanceof java.io.BufferedInputStream ? ((java.io.BufferedInputStream)(inputStream)) : new java.io.BufferedInputStream(inputStream);
    }

    public static java.io.BufferedInputStream c(final java.io.InputStream inputStream, int size) {
        if (inputStream == null) {
            throw new java.lang.NullPointerException();
        } 
        return inputStream instanceof java.io.BufferedInputStream ? ((java.io.BufferedInputStream)(inputStream)) : new java.io.BufferedInputStream(inputStream , size);
    }

    public static byte[] a(final java.io.InputStream input) throws java.io.IOException {
        final org.apache.commons.io.output.ByteArrayOutputStream output = new org.apache.commons.io.output.ByteArrayOutputStream();
        org.apache.commons.io.IOUtils.copy(input, output);
        return output.toByteArray();
    }

    public static byte[] a(final java.io.InputStream input, final long size) throws java.io.IOException {
        if (size > (java.lang.Integer.MAX_VALUE)) {
            throw new java.lang.IllegalArgumentException(("Size cannot be greater than Integer max value: " + size));
        } 
        return org.apache.commons.io.IOUtils.toByteArray(input, ((int)(size)));
    }

    public static byte[] b(final java.io.InputStream input, final int size) throws java.io.IOException {
        if (size < 0) {
            throw new java.lang.IllegalArgumentException(("Size must be equal or greater than zero: " + size));
        } 
        if (size == 0) {
            return new byte[0];
        } 
        final byte[] data = new byte[size];
        int offset = 0;
        int readed;
        while ((offset < size) && ((readed = input.read(data, offset, (size - offset))) != (EOF))) {
            offset += readed;
        }
        if (offset != size) {
            throw new java.io.IOException(((("Unexpected readed size. current: " + offset) + ", excepted: ") + size));
        } 
        return data;
    }

    @java.lang.Deprecated
    public static byte[] a(final java.io.Reader input) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toByteArray(input, java.nio.charset.Charset.defaultCharset());
    }

    public static byte[] a(final java.io.Reader input, final java.nio.charset.Charset encoding) throws java.io.IOException {
        final org.apache.commons.io.output.ByteArrayOutputStream output = new org.apache.commons.io.output.ByteArrayOutputStream();
        org.apache.commons.io.IOUtils.copy(input, output, encoding);
        return output.toByteArray();
    }

    public static byte[] a(final java.io.Reader input, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toByteArray(input, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static byte[] a(final java.lang.String input) throws java.io.IOException {
        return input.getBytes(java.nio.charset.Charset.defaultCharset());
    }

    public static byte[] a(final java.net.URI uri) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toByteArray(uri.toURL());
    }

    public static byte[] a(final java.net.URL url) throws java.io.IOException {
        final java.net.URLConnection conn = url.openConnection();
        try {
            return org.apache.commons.io.IOUtils.toByteArray(conn);
        } finally {
            org.apache.commons.io.IOUtils.close(conn);
        }
    }

    public static byte[] a(final java.net.URLConnection urlConn) throws java.io.IOException {
        final java.io.InputStream inputStream = urlConn.getInputStream();
        try {
            return org.apache.commons.io.IOUtils.toByteArray(inputStream);
        } finally {
            inputStream.close();
        }
    }

    @java.lang.Deprecated
    public static char[] b(final java.io.InputStream is) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toCharArray(is, java.nio.charset.Charset.defaultCharset());
    }

    public static char[] a(final java.io.InputStream is, final java.nio.charset.Charset encoding) throws java.io.IOException {
        final java.io.CharArrayWriter output = new java.io.CharArrayWriter();
        org.apache.commons.io.IOUtils.copy(is, output, encoding);
        return output.toCharArray();
    }

    public static char[] a(final java.io.InputStream is, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toCharArray(is, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static char[] b(final java.io.Reader input) throws java.io.IOException {
        final java.io.CharArrayWriter sw = new java.io.CharArrayWriter();
        org.apache.commons.io.IOUtils.copy(input, sw);
        return sw.toCharArray();
    }

    @java.lang.Deprecated
    public static java.lang.String e(final java.io.InputStream input) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(input, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String b(final java.io.InputStream input, final java.nio.charset.Charset encoding) throws java.io.IOException {
        final org.apache.commons.io.output.StringBuilderWriter sw = new org.apache.commons.io.output.StringBuilderWriter();
        org.apache.commons.io.IOUtils.copy(input, sw, encoding);
        return sw.toString();
    }

    public static java.lang.String b(final java.io.InputStream input, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(input, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static java.lang.String e(final java.io.Reader input) throws java.io.IOException {
        final org.apache.commons.io.output.StringBuilderWriter sw = new org.apache.commons.io.output.StringBuilderWriter();
        org.apache.commons.io.IOUtils.copy(input, sw);
        return sw.toString();
    }

    @java.lang.Deprecated
    public static java.lang.String b(final java.net.URI uri) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(uri, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String a(final java.net.URI uri, final java.nio.charset.Charset encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(uri.toURL(), org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static java.lang.String a(final java.net.URI uri, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(uri, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.lang.String b(final java.net.URL url) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(url, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String a(final java.net.URL url, final java.nio.charset.Charset encoding) throws java.io.IOException {
        final java.io.InputStream inputStream = url.openStream();
        try {
            return org.apache.commons.io.IOUtils.toString(inputStream, encoding);
        } finally {
            inputStream.close();
        }
    }

    public static java.lang.String a(final java.net.URL url, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toString(url, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.lang.String a(final byte[] input) throws java.io.IOException {
        return new java.lang.String(input , java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String a(final byte[] input, final java.lang.String encoding) throws java.io.IOException {
        return new java.lang.String(input , org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.util.List<java.lang.String> f(final java.io.InputStream input) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.readLines(input, java.nio.charset.Charset.defaultCharset());
    }

    public static java.util.List<java.lang.String> c(final java.io.InputStream input, final java.nio.charset.Charset encoding) throws java.io.IOException {
        final java.io.InputStreamReader reader = new java.io.InputStreamReader(input , org.apache.commons.io.Charsets.toCharset(encoding));
        return org.apache.commons.io.IOUtils.readLines(reader);
    }

    public static java.util.List<java.lang.String> c(final java.io.InputStream input, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.readLines(input, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static java.util.List<java.lang.String> f(final java.io.Reader input) throws java.io.IOException {
        final java.io.BufferedReader reader = org.apache.commons.io.IOUtils.toBufferedReader(input);
        final java.util.List<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
        java.lang.String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        return list;
    }

    public static org.apache.commons.io.LineIterator g(final java.io.Reader reader) {
        return new org.apache.commons.io.LineIterator(reader);
    }

    public static org.apache.commons.io.LineIterator d(final java.io.InputStream input, final java.nio.charset.Charset encoding) throws java.io.IOException {
        return new org.apache.commons.io.LineIterator(new java.io.InputStreamReader(input , org.apache.commons.io.Charsets.toCharset(encoding)));
    }

    public static org.apache.commons.io.LineIterator d(final java.io.InputStream input, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.lineIterator(input, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.io.InputStream a(final java.lang.CharSequence input) {
        return org.apache.commons.io.IOUtils.toInputStream(input, java.nio.charset.Charset.defaultCharset());
    }

    public static java.io.InputStream a(final java.lang.CharSequence input, final java.nio.charset.Charset encoding) {
        return org.apache.commons.io.IOUtils.toInputStream(input.toString(), encoding);
    }

    public static java.io.InputStream a(final java.lang.CharSequence input, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.toInputStream(input, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.io.InputStream b(final java.lang.String input) {
        return org.apache.commons.io.IOUtils.toInputStream(input, java.nio.charset.Charset.defaultCharset());
    }

    public static java.io.InputStream a(final java.lang.String input, final java.nio.charset.Charset encoding) {
        return new java.io.ByteArrayInputStream(input.getBytes(org.apache.commons.io.Charsets.toCharset(encoding)));
    }

    public static java.io.InputStream a(final java.lang.String input, final java.lang.String encoding) throws java.io.IOException {
        final byte[] bytes = input.getBytes(org.apache.commons.io.Charsets.toCharset(encoding));
        return new java.io.ByteArrayInputStream(bytes);
    }

    public static void a(final byte[] data, final java.io.OutputStream output) throws java.io.IOException {
        if (data != null) {
            output.write(data);
        } 
    }

    public static void b(final byte[] data, final java.io.OutputStream output) throws java.io.IOException {
        if (data != null) {
            int bytes = data.length;
            int offset = 0;
            while (bytes > 0) {
                int chunk = java.lang.Math.min(bytes, DEFAULT_BUFFER_SIZE);
                output.write(data, offset, chunk);
                bytes -= chunk;
                offset += chunk;
            }
        } 
    }

    @java.lang.Deprecated
    public static void a(final byte[] data, final java.io.Writer output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final byte[] data, final java.io.Writer output, final java.nio.charset.Charset encoding) throws java.io.IOException {
        if (data != null) {
            output.write(new java.lang.String(data , org.apache.commons.io.Charsets.toCharset(encoding)));
        } 
    }

    public static void a(final byte[] data, final java.io.Writer output, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static void a(final char[] data, final java.io.Writer output) throws java.io.IOException {
        if (data != null) {
            output.write(data);
        } 
    }

    public static void b(final char[] data, final java.io.Writer output) throws java.io.IOException {
        if (data != null) {
            int bytes = data.length;
            int offset = 0;
            while (bytes > 0) {
                int chunk = java.lang.Math.min(bytes, DEFAULT_BUFFER_SIZE);
                output.write(data, offset, chunk);
                bytes -= chunk;
                offset += chunk;
            }
        } 
    }

    @java.lang.Deprecated
    public static void a(final char[] data, final java.io.OutputStream output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final char[] data, final java.io.OutputStream output, final java.nio.charset.Charset encoding) throws java.io.IOException {
        if (data != null) {
            output.write(new java.lang.String(data).getBytes(org.apache.commons.io.Charsets.toCharset(encoding)));
        } 
    }

    public static void a(final char[] data, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static void a(final java.lang.CharSequence data, final java.io.Writer output) throws java.io.IOException {
        if (data != null) {
            org.apache.commons.io.IOUtils.write(data.toString(), output);
        } 
    }

    @java.lang.Deprecated
    public static void a(final java.lang.CharSequence data, final java.io.OutputStream output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final java.lang.CharSequence data, final java.io.OutputStream output, final java.nio.charset.Charset encoding) throws java.io.IOException {
        if (data != null) {
            org.apache.commons.io.IOUtils.write(data.toString(), output, encoding);
        } 
    }

    public static void a(final java.lang.CharSequence data, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static void a(final java.lang.String data, final java.io.Writer output) throws java.io.IOException {
        if (data != null) {
            output.write(data);
        } 
    }

    @java.lang.Deprecated
    public static void a(final java.lang.String data, final java.io.OutputStream output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final java.lang.String data, final java.io.OutputStream output, final java.nio.charset.Charset encoding) throws java.io.IOException {
        if (data != null) {
            output.write(data.getBytes(org.apache.commons.io.Charsets.toCharset(encoding)));
        } 
    }

    public static void a(final java.lang.String data, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static void a(final java.lang.StringBuffer data, final java.io.Writer output) throws java.io.IOException {
        if (data != null) {
            output.write(data.toString());
        } 
    }

    @java.lang.Deprecated
    public static void a(final java.lang.StringBuffer data, final java.io.OutputStream output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.write(data, output, ((java.lang.String)(null)));
    }

    @java.lang.Deprecated
    public static void a(final java.lang.StringBuffer data, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        if (data != null) {
            output.write(data.toString().getBytes(org.apache.commons.io.Charsets.toCharset(encoding)));
        } 
    }

    @java.lang.Deprecated
    public static void a(final java.util.Collection<?> lines, final java.lang.String lineEnding, final java.io.OutputStream output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.writeLines(lines, lineEnding, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final java.util.Collection<?> lines, java.lang.String lineEnding, final java.io.OutputStream output, final java.nio.charset.Charset encoding) throws java.io.IOException {
        if (lines == null) {
            return ;
        } 
        if (lineEnding == null) {
            lineEnding = LINE_SEPARATOR;
        } 
        final java.nio.charset.Charset cs = org.apache.commons.io.Charsets.toCharset(encoding);
        for (final java.lang.Object line : lines) {
            if (line != null) {
                output.write(line.toString().getBytes(cs));
            } 
            output.write(lineEnding.getBytes(cs));
        }
    }

    public static void a(final java.util.Collection<?> lines, final java.lang.String lineEnding, final java.io.OutputStream output, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.writeLines(lines, lineEnding, output, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public static void a(final java.util.Collection<?> lines, java.lang.String lineEnding, final java.io.Writer writer) throws java.io.IOException {
        if (lines == null) {
            return ;
        } 
        if (lineEnding == null) {
            lineEnding = LINE_SEPARATOR;
        } 
        for (final java.lang.Object line : lines) {
            if (line != null) {
                writer.write(line.toString());
            } 
            writer.write(lineEnding);
        }
    }

    public static int a(final java.io.InputStream input, final java.io.OutputStream output) throws java.io.IOException {
        final long count = org.apache.commons.io.IOUtils.copyLarge(input, output);
        if (count > (java.lang.Integer.MAX_VALUE)) {
            return -1;
        } 
        return ((int)(count));
    }

    public static long a(final java.io.InputStream input, final java.io.OutputStream output, final int bufferSize) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.copyLarge(input, output, new byte[bufferSize]);
    }

    public static long b(final java.io.InputStream input, final java.io.OutputStream output) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.copy(input, output, DEFAULT_BUFFER_SIZE);
    }

    public static long a(final java.io.InputStream input, final java.io.OutputStream output, final byte[] buffer) throws java.io.IOException {
        long count = 0;
        int n;
        while ((EOF) != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static long a(final java.io.InputStream input, final java.io.OutputStream output, final long inputOffset, final long length) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.copyLarge(input, output, inputOffset, length, new byte[DEFAULT_BUFFER_SIZE]);
    }

    public static long a(final java.io.InputStream input, final java.io.OutputStream output, final long inputOffset, final long length, final byte[] buffer) throws java.io.IOException {
        if (inputOffset > 0) {
            org.apache.commons.io.IOUtils.skipFully(input, inputOffset);
        } 
        if (length == 0) {
            return 0;
        } 
        final int bufferLength = buffer.length;
        int bytesToRead = bufferLength;
        if ((length > 0) && (length < bufferLength)) {
            bytesToRead = ((int)(length));
        } 
        int read;
        long totalRead = 0;
        while ((bytesToRead > 0) && ((EOF) != (read = input.read(buffer, 0, bytesToRead)))) {
            output.write(buffer, 0, read);
            totalRead += read;
            if (length > 0) {
                bytesToRead = ((int)(java.lang.Math.min((length - totalRead), bufferLength)));
            } 
        }
        return totalRead;
    }

    @java.lang.Deprecated
    public static void a(final java.io.InputStream input, final java.io.Writer output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.copy(input, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final java.io.InputStream input, final java.io.Writer output, final java.nio.charset.Charset inputEncoding) throws java.io.IOException {
        final java.io.InputStreamReader in = new java.io.InputStreamReader(input , org.apache.commons.io.Charsets.toCharset(inputEncoding));
        org.apache.commons.io.IOUtils.copy(in, output);
    }

    public static void a(final java.io.InputStream input, final java.io.Writer output, final java.lang.String inputEncoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.copy(input, output, org.apache.commons.io.Charsets.toCharset(inputEncoding));
    }

    public static int a(final java.io.Reader input, final java.io.Writer output) throws java.io.IOException {
        final long count = org.apache.commons.io.IOUtils.copyLarge(input, output);
        if (count > (java.lang.Integer.MAX_VALUE)) {
            return -1;
        } 
        return ((int)(count));
    }

    public static long b(final java.io.Reader input, final java.io.Writer output) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.copyLarge(input, output, new char[DEFAULT_BUFFER_SIZE]);
    }

    public static long a(final java.io.Reader input, final java.io.Writer output, final char[] buffer) throws java.io.IOException {
        long count = 0;
        int n;
        while ((EOF) != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static long a(final java.io.Reader input, final java.io.Writer output, final long inputOffset, final long length) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.copyLarge(input, output, inputOffset, length, new char[DEFAULT_BUFFER_SIZE]);
    }

    public static long a(final java.io.Reader input, final java.io.Writer output, final long inputOffset, final long length, final char[] buffer) throws java.io.IOException {
        if (inputOffset > 0) {
            org.apache.commons.io.IOUtils.skipFully(input, inputOffset);
        } 
        if (length == 0) {
            return 0;
        } 
        int bytesToRead = buffer.length;
        if ((length > 0) && (length < (buffer.length))) {
            bytesToRead = ((int)(length));
        } 
        int read;
        long totalRead = 0;
        while ((bytesToRead > 0) && ((EOF) != (read = input.read(buffer, 0, bytesToRead)))) {
            output.write(buffer, 0, read);
            totalRead += read;
            if (length > 0) {
                bytesToRead = ((int)(java.lang.Math.min((length - totalRead), buffer.length)));
            } 
        }
        return totalRead;
    }

    @java.lang.Deprecated
    public static void a(final java.io.Reader input, final java.io.OutputStream output) throws java.io.IOException {
        org.apache.commons.io.IOUtils.copy(input, output, java.nio.charset.Charset.defaultCharset());
    }

    public static void a(final java.io.Reader input, final java.io.OutputStream output, final java.nio.charset.Charset outputEncoding) throws java.io.IOException {
        final java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(output , org.apache.commons.io.Charsets.toCharset(outputEncoding));
        org.apache.commons.io.IOUtils.copy(input, out);
        out.flush();
    }

    public static void a(final java.io.Reader input, final java.io.OutputStream output, final java.lang.String outputEncoding) throws java.io.IOException {
        org.apache.commons.io.IOUtils.copy(input, output, org.apache.commons.io.Charsets.toCharset(outputEncoding));
    }

    public static boolean a(java.io.InputStream input1, java.io.InputStream input2) throws java.io.IOException {
        if (input1 == input2) {
            return true;
        } 
        if (!(input1 instanceof java.io.BufferedInputStream)) {
            input1 = new java.io.BufferedInputStream(input1);
        } 
        if (!(input2 instanceof java.io.BufferedInputStream)) {
            input2 = new java.io.BufferedInputStream(input2);
        } 
        int ch = input1.read();
        while ((EOF) != ch) {
            final int ch2 = input2.read();
            if (ch != ch2) {
                return false;
            } 
            ch = input1.read();
        }
        final int ch2 = input2.read();
        return ch2 == (EOF);
    }

    public static boolean a(java.io.Reader input1, java.io.Reader input2) throws java.io.IOException {
        if (input1 == input2) {
            return true;
        } 
        input1 = org.apache.commons.io.IOUtils.toBufferedReader(input1);
        input2 = org.apache.commons.io.IOUtils.toBufferedReader(input2);
        int ch = input1.read();
        while ((EOF) != ch) {
            final int ch2 = input2.read();
            if (ch != ch2) {
                return false;
            } 
            ch = input1.read();
        }
        final int ch2 = input2.read();
        return ch2 == (EOF);
    }

    public static boolean b(final java.io.Reader input1, final java.io.Reader input2) throws java.io.IOException {
        if (input1 == input2) {
            return true;
        } 
        final java.io.BufferedReader br1 = org.apache.commons.io.IOUtils.toBufferedReader(input1);
        final java.io.BufferedReader br2 = org.apache.commons.io.IOUtils.toBufferedReader(input2);
        java.lang.String line1 = br1.readLine();
        java.lang.String line2 = br2.readLine();
        while (((line1 != null) && (line2 != null)) && (line1.equals(line2))) {
            line1 = br1.readLine();
            line2 = br2.readLine();
        }
        return line1 == null ? line2 == null ? true : false : line1.equals(line2);
    }

    public static long b(final java.io.InputStream input, final long toSkip) throws java.io.IOException {
        if (toSkip < 0) {
            throw new java.lang.IllegalArgumentException(("Skip count must be non-negative, actual: " + toSkip));
        } 
        if ((org.apache.commons.io.IOUtils.SKIP_BYTE_BUFFER) == null) {
            org.apache.commons.io.IOUtils.SKIP_BYTE_BUFFER = new byte[SKIP_BUFFER_SIZE];
        } 
        long remain = toSkip;
        while (remain > 0) {
            final long n = input.read(org.apache.commons.io.IOUtils.SKIP_BYTE_BUFFER, 0, ((int)(java.lang.Math.min(remain, SKIP_BUFFER_SIZE))));
            if (n < 0) {
                break;
            } 
            remain -= n;
        }
        return toSkip - remain;
    }

    public static long a(final java.nio.channels.ReadableByteChannel input, final long toSkip) throws java.io.IOException {
        if (toSkip < 0) {
            throw new java.lang.IllegalArgumentException(("Skip count must be non-negative, actual: " + toSkip));
        } 
        final java.nio.ByteBuffer skipByteBuffer = java.nio.ByteBuffer.allocate(((int)(java.lang.Math.min(toSkip, SKIP_BUFFER_SIZE))));
        long remain = toSkip;
        while (remain > 0) {
            skipByteBuffer.position(0);
            skipByteBuffer.limit(((int)(java.lang.Math.min(remain, SKIP_BUFFER_SIZE))));
            final int n = input.read(skipByteBuffer);
            if (n == (EOF)) {
                break;
            } 
            remain -= n;
        }
        return toSkip - remain;
    }

    public static long a(final java.io.Reader input, final long toSkip) throws java.io.IOException {
        if (toSkip < 0) {
            throw new java.lang.IllegalArgumentException(("Skip count must be non-negative, actual: " + toSkip));
        } 
        if ((org.apache.commons.io.IOUtils.SKIP_CHAR_BUFFER) == null) {
            org.apache.commons.io.IOUtils.SKIP_CHAR_BUFFER = new char[SKIP_BUFFER_SIZE];
        } 
        long remain = toSkip;
        while (remain > 0) {
            final long n = input.read(org.apache.commons.io.IOUtils.SKIP_CHAR_BUFFER, 0, ((int)(java.lang.Math.min(remain, SKIP_BUFFER_SIZE))));
            if (n < 0) {
                break;
            } 
            remain -= n;
        }
        return toSkip - remain;
    }

    public static void c(final java.io.InputStream input, final long toSkip) throws java.io.IOException {
        if (toSkip < 0) {
            throw new java.lang.IllegalArgumentException(("Bytes to skip must not be negative: " + toSkip));
        } 
        final long skipped = org.apache.commons.io.IOUtils.skip(input, toSkip);
        if (skipped != toSkip) {
            throw new java.io.EOFException(((("Bytes to skip: " + toSkip) + " actual: ") + skipped));
        } 
    }

    public static void b(final java.nio.channels.ReadableByteChannel input, final long toSkip) throws java.io.IOException {
        if (toSkip < 0) {
            throw new java.lang.IllegalArgumentException(("Bytes to skip must not be negative: " + toSkip));
        } 
        final long skipped = org.apache.commons.io.IOUtils.skip(input, toSkip);
        if (skipped != toSkip) {
            throw new java.io.EOFException(((("Bytes to skip: " + toSkip) + " actual: ") + skipped));
        } 
    }

    public static void b(final java.io.Reader input, final long toSkip) throws java.io.IOException {
        final long skipped = org.apache.commons.io.IOUtils.skip(input, toSkip);
        if (skipped != toSkip) {
            throw new java.io.EOFException(((("Chars to skip: " + toSkip) + " actual: ") + skipped));
        } 
    }

    public static int a(final java.io.Reader input, final char[] buffer, final int offset, final int length) throws java.io.IOException {
        if (length < 0) {
            throw new java.lang.IllegalArgumentException(("Length must not be negative: " + length));
        } 
        int remaining = length;
        while (remaining > 0) {
            final int location = length - remaining;
            final int count = input.read(buffer, (offset + location), remaining);
            if ((EOF) == count) {
                break;
            } 
            remaining -= count;
        }
        return length - remaining;
    }

    public static int a(final java.io.Reader input, final char[] buffer) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.read(input, buffer, 0, buffer.length);
    }

    public static int a(final java.io.InputStream input, final byte[] buffer, final int offset, final int length) throws java.io.IOException {
        if (length < 0) {
            throw new java.lang.IllegalArgumentException(("Length must not be negative: " + length));
        } 
        int remaining = length;
        while (remaining > 0) {
            final int location = length - remaining;
            final int count = input.read(buffer, (offset + location), remaining);
            if ((EOF) == count) {
                break;
            } 
            remaining -= count;
        }
        return length - remaining;
    }

    public static int a(final java.io.InputStream input, final byte[] buffer) throws java.io.IOException {
        return org.apache.commons.io.IOUtils.read(input, buffer, 0, buffer.length);
    }

    public static int a(final java.nio.channels.ReadableByteChannel input, final java.nio.ByteBuffer buffer) throws java.io.IOException {
        final int length = buffer.remaining();
        while ((buffer.remaining()) > 0) {
            final int count = input.read(buffer);
            if ((EOF) == count) {
                break;
            } 
        }
        return length - (buffer.remaining());
    }

    public static void b(final java.io.Reader input, final char[] buffer, final int offset, final int length) throws java.io.IOException {
        final int actual = org.apache.commons.io.IOUtils.read(input, buffer, offset, length);
        if (actual != length) {
            throw new java.io.EOFException(((("Length to read: " + length) + " actual: ") + actual));
        } 
    }

    public static void b(final java.io.Reader input, final char[] buffer) throws java.io.IOException {
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, buffer.length);
    }

    public static void b(final java.io.InputStream input, final byte[] buffer, final int offset, final int length) throws java.io.IOException {
        final int actual = org.apache.commons.io.IOUtils.read(input, buffer, offset, length);
        if (actual != length) {
            throw new java.io.EOFException(((("Length to read: " + length) + " actual: ") + actual));
        } 
    }

    public static void b(final java.io.InputStream input, final byte[] buffer) throws java.io.IOException {
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, buffer.length);
    }

    public static byte[] a(final java.io.InputStream input, final int length) throws java.io.IOException {
        final byte[] buffer = new byte[length];
        org.apache.commons.io.IOUtils.readFully(input, buffer, 0, buffer.length);
        return buffer;
    }

    public static void b(final java.nio.channels.ReadableByteChannel input, final java.nio.ByteBuffer buffer) throws java.io.IOException {
        final int expected = buffer.remaining();
        final int actual = org.apache.commons.io.IOUtils.read(input, buffer);
        if (actual != expected) {
            throw new java.io.EOFException(((("Length to read: " + expected) + " actual: ") + actual));
        } 
    }
}


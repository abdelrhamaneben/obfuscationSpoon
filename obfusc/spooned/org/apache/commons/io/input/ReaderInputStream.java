package org.apache.commons.io.input;


public class ReaderInputStream extends java.io.InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    private final java.io.Reader reader;

    private final java.nio.charset.CharsetEncoder encoder;

    private final java.nio.CharBuffer encoderIn;

    private final java.nio.ByteBuffer encoderOut;

    private java.nio.charset.CoderResult lastCoderResult;

    private boolean endOfInput;

    public ReaderInputStream(final java.io.Reader reader ,final java.nio.charset.CharsetEncoder encoder) {
        this(reader, encoder, DEFAULT_BUFFER_SIZE);
    }

    public ReaderInputStream(final java.io.Reader reader ,final java.nio.charset.CharsetEncoder encoder ,final int bufferSize) {
        this.reader = reader;
        this.encoder = encoder;
        this.encoderIn = java.nio.CharBuffer.allocate(bufferSize);
        this.encoderIn.flip();
        this.encoderOut = java.nio.ByteBuffer.allocate(128);
        this.encoderOut.flip();
    }

    public ReaderInputStream(final java.io.Reader reader ,final java.nio.charset.Charset charset ,final int bufferSize) {
        this(reader, charset.newEncoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPLACE).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPLACE), bufferSize);
    }

    public ReaderInputStream(final java.io.Reader reader ,final java.nio.charset.Charset charset) {
        this(reader, charset, DEFAULT_BUFFER_SIZE);
    }

    public ReaderInputStream(final java.io.Reader reader ,final java.lang.String charsetName ,final int bufferSize) {
        this(reader, java.nio.charset.Charset.forName(charsetName), bufferSize);
    }

    public ReaderInputStream(final java.io.Reader reader ,final java.lang.String charsetName) {
        this(reader, charsetName, DEFAULT_BUFFER_SIZE);
    }

    @java.lang.Deprecated
    public ReaderInputStream(final java.io.Reader reader) {
        this(reader, java.nio.charset.Charset.defaultCharset());
    }

    private void a() throws java.io.IOException {
        if ((!(endOfInput)) && (((lastCoderResult) == null) || (lastCoderResult.isUnderflow()))) {
            encoderIn.compact();
            final int position = encoderIn.position();
            final int c = reader.read(encoderIn.array(), position, encoderIn.remaining());
            if (c == (org.apache.commons.io.IOUtils.EOF)) {
                endOfInput = true;
            } else {
                encoderIn.position((position + c));
            }
            encoderIn.flip();
        } 
        encoderOut.compact();
        lastCoderResult = encoder.encode(encoderIn, encoderOut, endOfInput);
        encoderOut.flip();
    }

    @java.lang.Override
    public int read(final byte[] b, int off, int len) throws java.io.IOException {
        if (b == null) {
            throw new java.lang.NullPointerException("Byte array must not be null");
        } 
        if (((len < 0) || (off < 0)) || ((off + len) > (b.length))) {
            throw new java.lang.IndexOutOfBoundsException(((((("Array Size=" + (b.length)) + ", offset=") + off) + ", length=") + len));
        } 
        int read = 0;
        if (len == 0) {
            return 0;
        } 
        while (len > 0) {
            if (encoderOut.hasRemaining()) {
                final int c = java.lang.Math.min(encoderOut.remaining(), len);
                encoderOut.get(b, off, c);
                off += c;
                len -= c;
                read += c;
            } else {
                fillBuffer();
                if ((endOfInput) && (!(encoderOut.hasRemaining()))) {
                    break;
                } 
            }
        }
        return (read == 0) && (endOfInput) ? org.apache.commons.io.IOUtils.EOF : read;
    }

    @java.lang.Override
    public int read(final byte[] b) throws java.io.IOException {
        return read(b, 0, b.length);
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        for ( ;  ; ) {
            if (encoderOut.hasRemaining()) {
                return (encoderOut.get()) & 255;
            } 
            fillBuffer();
            if ((endOfInput) && (!(encoderOut.hasRemaining()))) {
                return org.apache.commons.io.IOUtils.EOF;
            } 
        }
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        reader.close();
    }
}


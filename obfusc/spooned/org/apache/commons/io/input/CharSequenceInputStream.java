package org.apache.commons.io.input;


public class CharSequenceInputStream extends java.io.InputStream {
    private static final int BUFFER_SIZE = 2048;

    private static final int NO_MARK = -1;

    private final java.nio.charset.CharsetEncoder encoder;

    private final java.nio.CharBuffer cbuf;

    private final java.nio.ByteBuffer bbuf;

    private int mark_cbuf;

    private int mark_bbuf;

    public CharSequenceInputStream(final java.lang.CharSequence cs ,final java.nio.charset.Charset charset ,final int bufferSize) {
        super();
        this.encoder = charset.newEncoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPLACE).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPLACE);
        final float maxBytesPerChar = encoder.maxBytesPerChar();
        if (bufferSize < maxBytesPerChar) {
            throw new java.lang.IllegalArgumentException(((("Buffer size " + bufferSize) + " is less than maxBytesPerChar ") + maxBytesPerChar));
        } 
        this.bbuf = java.nio.ByteBuffer.allocate(bufferSize);
        this.bbuf.flip();
        this.cbuf = java.nio.CharBuffer.wrap(cs);
        this.mark_cbuf = NO_MARK;
        this.mark_bbuf = NO_MARK;
    }

    public CharSequenceInputStream(final java.lang.CharSequence cs ,final java.lang.String charset ,final int bufferSize) {
        this(cs, java.nio.charset.Charset.forName(charset), bufferSize);
    }

    public CharSequenceInputStream(final java.lang.CharSequence cs ,final java.nio.charset.Charset charset) {
        this(cs, charset, BUFFER_SIZE);
    }

    public CharSequenceInputStream(final java.lang.CharSequence cs ,final java.lang.String charset) {
        this(cs, charset, BUFFER_SIZE);
    }

    private void a() throws java.nio.charset.CharacterCodingException {
        this.bbuf.compact();
        final java.nio.charset.CoderResult result = this.encoder.encode(this.cbuf, this.bbuf, true);
        if (result.isError()) {
            result.throwException();
        } 
        this.bbuf.flip();
    }

    @java.lang.Override
    public int read(final byte[] b, int off, int len) throws java.io.IOException {
        if (b == null) {
            throw new java.lang.NullPointerException("Byte array is null");
        } 
        if ((len < 0) || ((off + len) > (b.length))) {
            throw new java.lang.IndexOutOfBoundsException(((((("Array Size=" + (b.length)) + ", offset=") + off) + ", length=") + len));
        } 
        if (len == 0) {
            return 0;
        } 
        if ((!(this.bbuf.hasRemaining())) && (!(this.cbuf.hasRemaining()))) {
            return org.apache.commons.io.IOUtils.EOF;
        } 
        int bytesRead = 0;
        while (len > 0) {
            if (this.bbuf.hasRemaining()) {
                final int chunk = java.lang.Math.min(this.bbuf.remaining(), len);
                this.bbuf.get(b, off, chunk);
                off += chunk;
                len -= chunk;
                bytesRead += chunk;
            } else {
                fillBuffer();
                if ((!(this.bbuf.hasRemaining())) && (!(this.cbuf.hasRemaining()))) {
                    break;
                } 
            }
        }
        return (bytesRead == 0) && (!(this.cbuf.hasRemaining())) ? org.apache.commons.io.IOUtils.EOF : bytesRead;
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        for ( ;  ; ) {
            if (this.bbuf.hasRemaining()) {
                return (this.bbuf.get()) & 255;
            } else {
                fillBuffer();
                if ((!(this.bbuf.hasRemaining())) && (!(this.cbuf.hasRemaining()))) {
                    return org.apache.commons.io.IOUtils.EOF;
                } 
            }
        }
    }

    @java.lang.Override
    public int read(final byte[] b) throws java.io.IOException {
        return read(b, 0, b.length);
    }

    @java.lang.Override
    public long skip(long n) throws java.io.IOException {
        long skipped = 0;
        while ((n > 0) && ((available()) > 0)) {
            read();
            n--;
            skipped++;
        }
        return skipped;
    }

    @java.lang.Override
    public int available() throws java.io.IOException {
        return (this.bbuf.remaining()) + (this.cbuf.remaining());
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
    }

    @java.lang.Override
    public synchronized void mark(final int readlimit) {
        this.mark_cbuf = this.cbuf.position();
        this.mark_bbuf = this.bbuf.position();
        this.cbuf.mark();
        this.bbuf.mark();
    }

    @java.lang.Override
    public synchronized void reset() throws java.io.IOException {
        if ((this.mark_cbuf) != (NO_MARK)) {
            if ((this.cbuf.position()) != 0) {
                this.encoder.reset();
                this.cbuf.rewind();
                this.bbuf.rewind();
                this.bbuf.limit(0);
                while ((this.cbuf.position()) < (this.mark_cbuf)) {
                    this.bbuf.rewind();
                    this.bbuf.limit(0);
                    fillBuffer();
                }
            } 
            if ((this.cbuf.position()) != (this.mark_cbuf)) {
                throw new java.lang.IllegalStateException((((("Unexpected CharBuffer postion: actual=" + (cbuf.position())) + " ") + "expected=") + (this.mark_cbuf)));
            } 
            this.bbuf.position(this.mark_bbuf);
            this.mark_cbuf = NO_MARK;
            this.mark_bbuf = NO_MARK;
        } 
    }

    @java.lang.Override
    public boolean markSupported() {
        return true;
    }
}


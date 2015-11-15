package org.apache.commons.io.input;


public class ReversedLinesFileReader implements java.io.Closeable {
    private final int blockSize;

    private final java.nio.charset.Charset encoding;

    private final java.io.RandomAccessFile randomAccessFile;

    private final long totalByteLength;

    private final long totalBlockCount;

    private final byte[][] newLineSequences;

    private final int avoidNewlineSplitBufferSize;

    private final int byteDecrement;

    private FilePart currentFilePart;

    private boolean trailingNewlineOfFileSkipped = false;

    @java.lang.Deprecated
    public ReversedLinesFileReader(final java.io.File file) throws java.io.IOException {
        this(file, 4096, java.nio.charset.Charset.defaultCharset());
    }

    public ReversedLinesFileReader(final java.io.File file ,final java.nio.charset.Charset charset) throws java.io.IOException {
        this(file, 4096, charset);
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public ReversedLinesFileReader(final java.io.File file ,final int blockSize ,final java.nio.charset.Charset encoding) throws java.io.IOException {
        this.blockSize = blockSize;
        this.encoding = encoding;
        randomAccessFile = new java.io.RandomAccessFile(file , "r");
        totalByteLength = randomAccessFile.length();
        int lastBlockLength = ((int)((totalByteLength) % blockSize));
        if (lastBlockLength > 0) {
            totalBlockCount = ((totalByteLength) / blockSize) + 1;
        } else {
            totalBlockCount = (totalByteLength) / blockSize;
            if ((totalByteLength) > 0) {
                lastBlockLength = blockSize;
            } 
        }
        currentFilePart = new FilePart(totalBlockCount , lastBlockLength , null);
        final java.nio.charset.Charset charset = org.apache.commons.io.Charsets.toCharset(encoding);
        final java.nio.charset.CharsetEncoder charsetEncoder = charset.newEncoder();
        final float maxBytesPerChar = charsetEncoder.maxBytesPerChar();
        if (maxBytesPerChar == 1.0F) {
            byteDecrement = 1;
        } else if (charset == (org.apache.commons.io.Charsets.UTF_8)) {
            byteDecrement = 1;
        } else if (((((charset == (java.nio.charset.Charset.forName("Shift_JIS"))) || (charset == (java.nio.charset.Charset.forName("windows-31j")))) || (charset == (java.nio.charset.Charset.forName("x-windows-949")))) || (charset == (java.nio.charset.Charset.forName("gbk")))) || (charset == (java.nio.charset.Charset.forName("x-windows-950")))) {
            byteDecrement = 1;
        } else if ((charset == (org.apache.commons.io.Charsets.UTF_16BE)) || (charset == (org.apache.commons.io.Charsets.UTF_16LE))) {
            byteDecrement = 2;
        } else if (charset == (org.apache.commons.io.Charsets.UTF_16)) {
            throw new java.io.UnsupportedEncodingException(("For UTF-16, you need to specify the byte order (use UTF-16BE or " + "UTF-16LE)"));
        } else {
            throw new java.io.UnsupportedEncodingException(((("Encoding " + encoding) + " is not supported yet (feel free to ") + "submit a patch)"));
        }
        newLineSequences = new byte[][]{ "\r\n".getBytes(encoding) , "\n".getBytes(encoding) , "\r".getBytes(encoding) };
        avoidNewlineSplitBufferSize = newLineSequences[0].length;
    }

    public ReversedLinesFileReader(final java.io.File file ,final int blockSize ,final java.lang.String encoding) throws java.io.IOException {
        this(file, blockSize, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    public java.lang.String a() throws java.io.IOException {
        java.lang.String line = currentFilePart.readLine();
        while (line == null) {
            currentFilePart = currentFilePart.rollOver();
            if ((currentFilePart) != null) {
                line = currentFilePart.readLine();
            } else {
                break;
            }
        }
        if (("".equals(line)) && (!(trailingNewlineOfFileSkipped))) {
            trailingNewlineOfFileSkipped = true;
            line = readLine();
        } 
        return line;
    }

    public void b() throws java.io.IOException {
        randomAccessFile.close();
    }

    private class FilePart {
        private final long no;

        private final byte[] data;

        private byte[] leftOver;

        private int currentLastBytePos;

        private FilePart(final long no ,final int length ,final byte[] leftOverOfLastFilePart) throws java.io.IOException {
            this.no = no;
            final int dataLength = length + (leftOverOfLastFilePart != null ? leftOverOfLastFilePart.length : 0);
            this.data = new byte[dataLength];
            final long off = (no - 1) * (blockSize);
            if (no > 0) {
                randomAccessFile.seek(off);
                final int countRead = randomAccessFile.read(data, 0, length);
                if (countRead != length) {
                    throw new java.lang.IllegalStateException("Count of requested bytes and actually read bytes don\'t match");
                } 
            } 
            if (leftOverOfLastFilePart != null) {
                java.lang.System.arraycopy(leftOverOfLastFilePart, 0, data, length, leftOverOfLastFilePart.length);
            } 
            this.currentLastBytePos = (data.length) - 1;
            this.leftOver = null;
        }

        private FilePart b() throws java.io.IOException {
            if ((currentLastBytePos) > (-1)) {
                throw new java.lang.IllegalStateException((("Current currentLastCharPos unexpectedly positive... " + "last readLine() should have returned something! currentLastCharPos=") + (currentLastBytePos)));
            } 
            if ((no) > 1) {
                return new FilePart(((no) - 1) , blockSize , leftOver);
            } else {
                if ((leftOver) != null) {
                    throw new java.lang.IllegalStateException(("Unexpected leftover of the last block: leftOverOfThisFilePart=" + (new java.lang.String(leftOver , encoding))));
                } 
                return null;
            }
        }

        private java.lang.String a() throws java.io.IOException {
            java.lang.String line = null;
            int newLineMatchByteCount;
            final boolean isLastFilePart = (no) == 1;
            int i = currentLastBytePos;
            while (i > (-1)) {
                if ((!isLastFilePart) && (i < (avoidNewlineSplitBufferSize))) {
                    createLeftOver();
                    break;
                } 
                if ((newLineMatchByteCount = getNewLineMatchByteCount(data, i)) > 0) {
                    final int lineStart = i + 1;
                    final int lineLengthBytes = ((currentLastBytePos) - lineStart) + 1;
                    if (lineLengthBytes < 0) {
                        throw new java.lang.IllegalStateException(("Unexpected negative line length=" + lineLengthBytes));
                    } 
                    final byte[] lineData = new byte[lineLengthBytes];
                    java.lang.System.arraycopy(data, lineStart, lineData, 0, lineLengthBytes);
                    line = new java.lang.String(lineData , encoding);
                    currentLastBytePos = i - newLineMatchByteCount;
                    break;
                } 
                i -= byteDecrement;
                if (i < 0) {
                    createLeftOver();
                    break;
                } 
            }
            if (isLastFilePart && ((leftOver) != null)) {
                line = new java.lang.String(leftOver , encoding);
                leftOver = null;
            } 
            return line;
        }

        private void c() {
            final int lineLengthBytes = (currentLastBytePos) + 1;
            if (lineLengthBytes > 0) {
                leftOver = new byte[lineLengthBytes];
                java.lang.System.arraycopy(data, 0, leftOver, 0, lineLengthBytes);
            } else {
                leftOver = null;
            }
            currentLastBytePos = -1;
        }

        private int a(final byte[] data, final int i) {
            for (final byte[] newLineSequence : newLineSequences) {
                boolean match = true;
                for (int j = (newLineSequence.length) - 1 ; j >= 0 ; j--) {
                    final int k = (i + j) - ((newLineSequence.length) - 1);
                    match &= (k >= 0) && ((data[k]) == (newLineSequence[j]));
                }
                if (match) {
                    return newLineSequence.length;
                } 
            }
            return 0;
        }
    }
}


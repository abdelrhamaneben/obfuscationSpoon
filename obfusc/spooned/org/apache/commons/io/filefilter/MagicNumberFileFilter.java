package org.apache.commons.io.filefilter;


public class MagicNumberFileFilter extends org.apache.commons.io.filefilter.AbstractFileFilter implements java.io.Serializable {
    private static final long serialVersionUID = -547733176983104172L;

    private final byte[] magicNumbers;

    private final long byteOffset;

    public MagicNumberFileFilter(final byte[] magicNumber) {
        this(magicNumber, 0);
    }

    public MagicNumberFileFilter(final java.lang.String magicNumber) {
        this(magicNumber, 0);
    }

    public MagicNumberFileFilter(final java.lang.String magicNumber ,final long offset) {
        if (magicNumber == null) {
            throw new java.lang.IllegalArgumentException("The magic number cannot be null");
        } 
        if (magicNumber.isEmpty()) {
            throw new java.lang.IllegalArgumentException("The magic number must contain at least one byte");
        } 
        if (offset < 0) {
            throw new java.lang.IllegalArgumentException("The offset cannot be negative");
        } 
        this.magicNumbers = magicNumber.getBytes(java.nio.charset.Charset.defaultCharset());
        this.byteOffset = offset;
    }

    public MagicNumberFileFilter(final byte[] magicNumber ,final long offset) {
        if (magicNumber == null) {
            throw new java.lang.IllegalArgumentException("The magic number cannot be null");
        } 
        if ((magicNumber.length) == 0) {
            throw new java.lang.IllegalArgumentException("The magic number must contain at least one byte");
        } 
        if (offset < 0) {
            throw new java.lang.IllegalArgumentException("The offset cannot be negative");
        } 
        this.magicNumbers = new byte[magicNumber.length];
        java.lang.System.arraycopy(magicNumber, 0, this.magicNumbers, 0, magicNumber.length);
        this.byteOffset = offset;
    }

    @java.lang.Override
    public boolean a(final java.io.File file) {
        if (((file != null) && (file.isFile())) && (file.canRead())) {
            java.io.RandomAccessFile randomAccessFile = null;
            try {
                final byte[] fileBytes = new byte[this.magicNumbers.length];
                randomAccessFile = new java.io.RandomAccessFile(file , "r");
                randomAccessFile.seek(byteOffset);
                final int read = randomAccessFile.read(fileBytes);
                if (read != (magicNumbers.length)) {
                    return false;
                } 
                return java.util.Arrays.equals(this.magicNumbers, fileBytes);
            } catch (final java.io.IOException ioe) {
            } finally {
                org.apache.commons.io.IOUtils.closeQuietly(randomAccessFile);
            }
        } 
        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder(super.toString());
        builder.append("(");
        builder.append(new java.lang.String(magicNumbers , java.nio.charset.Charset.defaultCharset()));
        builder.append(",");
        builder.append(this.byteOffset);
        builder.append(")");
        return builder.toString();
    }
}


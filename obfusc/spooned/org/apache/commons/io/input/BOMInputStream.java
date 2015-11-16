package org.apache.commons.io.input;


public class BOMInputStream extends org.apache.commons.io.input.ProxyInputStream {
    private final boolean include;

    private final java.util.List<org.apache.commons.io.ByteOrderMark> boms;

    private org.apache.commons.io.ByteOrderMark byteOrderMark;

    private int[] firstBytes;

    private int fbLength;

    private int fbIndex;

    private int markFbIndex;

    private boolean markedAtStart;

    public BOMInputStream(final java.io.InputStream delegate) {
        this(delegate, false, org.apache.commons.io.ByteOrderMark.UTF_8);
    }

    public BOMInputStream(final java.io.InputStream delegate ,final boolean include) {
        this(delegate, include, org.apache.commons.io.ByteOrderMark.UTF_8);
    }

    public BOMInputStream(final java.io.InputStream delegate ,final org.apache.commons.io.ByteOrderMark... boms) {
        this(delegate, false, boms);
    }

    private static final java.util.Comparator<org.apache.commons.io.ByteOrderMark> ByteOrderMarkLengthComparator = new java.util.Comparator<org.apache.commons.io.ByteOrderMark>() {
        public int a(final org.apache.commons.io.ByteOrderMark bom1, final org.apache.commons.io.ByteOrderMark bom2) {
            final int len1 = bom1.length();
            final int len2 = bom2.length();
            if (len1 > len2) {
                return org.apache.commons.io.IOUtils.EOF;
            } 
            if (len2 > len1) {
                return 1;
            } 
            return 0;
        }
    };

    public BOMInputStream(final java.io.InputStream delegate ,final boolean include ,final org.apache.commons.io.ByteOrderMark... boms) {
        super(delegate);
        if ((boms == null) || ((boms.length) == 0)) {
            throw new java.lang.IllegalArgumentException("No BOMs specified");
        } 
        this.include = include;
        java.util.Arrays.sort(boms, ByteOrderMarkLengthComparator);
        this.boms = java.util.Arrays.asList(boms);
    }

    public boolean a() throws java.io.IOException {
        return (getBOM()) != null;
    }

    public boolean a(final org.apache.commons.io.ByteOrderMark bom) throws java.io.IOException {
        if (!(boms.contains(bom))) {
            throw new java.lang.IllegalArgumentException(("Stream not configure to detect " + bom));
        } 
        return ((byteOrderMark) != null) && (getBOM().equals(bom));
    }

    public org.apache.commons.io.ByteOrderMark e() throws java.io.IOException {
        if ((firstBytes) == null) {
            fbLength = 0;
            final int maxBomSize = boms.get(0).length();
            firstBytes = new int[maxBomSize];
            for (int i = 0 ; i < (firstBytes.length) ; i++) {
                firstBytes[i] = in.read();
                (fbLength)++;
                if ((firstBytes[i]) < 0) {
                    break;
                } 
            }
            byteOrderMark = find();
            if ((byteOrderMark) != null) {
                if (!(include)) {
                    if ((byteOrderMark.length()) < (firstBytes.length)) {
                        fbIndex = byteOrderMark.length();
                    } else {
                        fbLength = 0;
                    }
                } 
            } 
        } 
        return byteOrderMark;
    }

    public java.lang.String c() throws java.io.IOException {
        getBOM();
        return (byteOrderMark) == null ? null : byteOrderMark.getCharsetName();
    }

    private int b() throws java.io.IOException {
        getBOM();
        return (fbIndex) < (fbLength) ? firstBytes[(fbIndex)++] : org.apache.commons.io.IOUtils.EOF;
    }

    private org.apache.commons.io.ByteOrderMark d() {
        for (final org.apache.commons.io.ByteOrderMark bom : boms) {
            if (matches(bom)) {
                return bom;
            } 
        }
        return null;
    }

    private boolean b(final org.apache.commons.io.ByteOrderMark bom) {
        for (int i = 0 ; i < (bom.length()) ; i++) {
            if ((bom.get(i)) != (firstBytes[i])) {
                return false;
            } 
        }
        return true;
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        final int b = readFirstBytes();
        return b >= 0 ? b : in.read();
    }

    @java.lang.Override
    public int read(final byte[] buf, int off, int len) throws java.io.IOException {
        int firstCount = 0;
        int b = 0;
        while ((len > 0) && (b >= 0)) {
            b = readFirstBytes();
            if (b >= 0) {
                buf[off++] = ((byte)(b & 255));
                len--;
                firstCount++;
            } 
        }
        final int secondCount = in.read(buf, off, len);
        return secondCount < 0 ? firstCount > 0 ? firstCount : org.apache.commons.io.IOUtils.EOF : firstCount + secondCount;
    }

    @java.lang.Override
    public int read(final byte[] buf) throws java.io.IOException {
        return read(buf, 0, buf.length);
    }

    @java.lang.Override
    public synchronized void mark(final int readlimit) {
        markFbIndex = fbIndex;
        markedAtStart = (firstBytes) == null;
        in.mark(readlimit);
    }

    @java.lang.Override
    public synchronized void reset() throws java.io.IOException {
        fbIndex = markFbIndex;
        if (markedAtStart) {
            firstBytes = null;
        } 
        in.reset();
    }

    @java.lang.Override
    public long skip(long n) throws java.io.IOException {
        int skipped = 0;
        while ((n > skipped) && ((readFirstBytes()) >= 0)) {
            skipped++;
        }
        return (in.skip((n - skipped))) + skipped;
    }
}


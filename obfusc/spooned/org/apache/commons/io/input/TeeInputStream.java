package org.apache.commons.io.input;


public class TeeInputStream extends org.apache.commons.io.input.ProxyInputStream {
    private final java.io.OutputStream branch;

    private final boolean closeBranch;

    public TeeInputStream(final java.io.InputStream input ,final java.io.OutputStream branch) {
        this(input, branch, false);
    }

    public TeeInputStream(final java.io.InputStream input ,final java.io.OutputStream branch ,final boolean closeBranch) {
        super(input);
        this.branch = branch;
        this.closeBranch = closeBranch;
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        try {
            super.close();
        } finally {
            if (closeBranch) {
                branch.close();
            } 
        }
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        final int ch = super.read();
        if (ch != (org.apache.commons.io.IOUtils.EOF)) {
            branch.write(ch);
        } 
        return ch;
    }

    @java.lang.Override
    public int read(final byte[] bts, final int st, final int end) throws java.io.IOException {
        final int n = super.read(bts, st, end);
        if (n != (-1)) {
            branch.write(bts, st, n);
        } 
        return n;
    }

    @java.lang.Override
    public int read(final byte[] bts) throws java.io.IOException {
        final int n = super.read(bts);
        if (n != (org.apache.commons.io.IOUtils.EOF)) {
            branch.write(bts, 0, n);
        } 
        return n;
    }
}


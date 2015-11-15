package org.apache.commons.io.input;


public class UnixLineEndingInputStream extends java.io.InputStream {
    private boolean slashNSeen = false;

    private boolean slashRSeen = false;

    private boolean eofSeen = false;

    private final java.io.InputStream target;

    private final boolean ensureLineFeedAtEndOfFile;

    public UnixLineEndingInputStream(java.io.InputStream in ,boolean ensureLineFeedAtEndOfFile) {
        this.target = in;
        this.ensureLineFeedAtEndOfFile = ensureLineFeedAtEndOfFile;
    }

    private int a() throws java.io.IOException {
        final int target = this.target.read();
        eofSeen = target == (-1);
        if (eofSeen) {
            return target;
        } 
        slashNSeen = target == '\n';
        slashRSeen = target == '\r';
        return target;
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        boolean previousWasSlashR = slashRSeen;
        if (eofSeen) {
            return eofGame(previousWasSlashR);
        } else {
            int target = readWithUpdate();
            if (eofSeen) {
                return eofGame(previousWasSlashR);
            } 
            if (slashRSeen) {
                return '\n';
            } 
            if (previousWasSlashR && (slashNSeen)) {
                return read();
            } 
            return target;
        }
    }

    private int a(boolean previousWasSlashR) {
        if (previousWasSlashR || (!(ensureLineFeedAtEndOfFile))) {
            return -1;
        } 
        if (!(slashNSeen)) {
            slashNSeen = true;
            return '\n';
        } else {
            return -1;
        }
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        super.close();
        target.close();
    }

    @java.lang.Override
    public synchronized void mark(int readlimit) {
        throw new java.lang.UnsupportedOperationException("Mark notsupported");
    }
}


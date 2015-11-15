package org.apache.commons.io.input;


public class WindowsLineEndingInputStream extends java.io.InputStream {
    private boolean slashRSeen = false;

    private boolean slashNSeen = false;

    private boolean injectSlashN = false;

    private boolean eofSeen = false;

    private final java.io.InputStream target;

    private final boolean ensureLineFeedAtEndOfFile;

    public WindowsLineEndingInputStream(java.io.InputStream in ,boolean ensureLineFeedAtEndOfFile) {
        this.target = in;
        this.ensureLineFeedAtEndOfFile = ensureLineFeedAtEndOfFile;
    }

    private int b() throws java.io.IOException {
        final int target = this.target.read();
        eofSeen = target == (-1);
        if (eofSeen) {
            return target;
        } 
        slashRSeen = target == '\r';
        slashNSeen = target == '\n';
        return target;
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        if (eofSeen) {
            return eofGame();
        } else if (injectSlashN) {
            injectSlashN = false;
            return '\n';
        } else {
            boolean prevWasSlashR = slashRSeen;
            int target = readWithUpdate();
            if (eofSeen) {
                return eofGame();
            } 
            if (target == '\n') {
                if (!prevWasSlashR) {
                    injectSlashN = true;
                    return '\r';
                } 
            } 
            return target;
        }
    }

    private int a() {
        if (!(ensureLineFeedAtEndOfFile)) {
            return -1;
        } 
        if ((!(slashNSeen)) && (!(slashRSeen))) {
            slashRSeen = true;
            return '\r';
        } 
        if (!(slashNSeen)) {
            slashRSeen = false;
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
        throw new java.lang.UnsupportedOperationException("Mark not supported");
    }
}


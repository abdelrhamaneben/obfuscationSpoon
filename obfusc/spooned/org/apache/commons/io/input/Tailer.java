package org.apache.commons.io.input;


public class Tailer implements java.lang.Runnable {
    private static final int DEFAULT_DELAY_MILLIS = 1000;

    private static final java.lang.String RAF_MODE = "r";

    private static final int DEFAULT_BUFSIZE = 4096;

    private static final java.nio.charset.Charset DEFAULT_CHARSET = java.nio.charset.Charset.defaultCharset();

    private final byte[] inbuf;

    private final java.io.File file;

    private final java.nio.charset.Charset cset;

    private final long delayMillis;

    private final boolean end;

    private final org.apache.commons.io.input.TailerListener listener;

    private final boolean reOpen;

    private volatile boolean run = true;

    public Tailer(final java.io.File file ,final org.apache.commons.io.input.TailerListener listener) {
        this(file, listener, DEFAULT_DELAY_MILLIS);
    }

    public Tailer(final java.io.File file ,final org.apache.commons.io.input.TailerListener listener ,final long delayMillis) {
        this(file, listener, delayMillis, false);
    }

    public Tailer(final java.io.File file ,final org.apache.commons.io.input.TailerListener listener ,final long delayMillis ,final boolean end) {
        this(file, listener, delayMillis, end, DEFAULT_BUFSIZE);
    }

    public Tailer(final java.io.File file ,final org.apache.commons.io.input.TailerListener listener ,final long delayMillis ,final boolean end ,final boolean reOpen) {
        this(file, listener, delayMillis, end, reOpen, DEFAULT_BUFSIZE);
    }

    public Tailer(final java.io.File file ,final org.apache.commons.io.input.TailerListener listener ,final long delayMillis ,final boolean end ,final int bufSize) {
        this(file, listener, delayMillis, end, false, bufSize);
    }

    public Tailer(final java.io.File file ,final org.apache.commons.io.input.TailerListener listener ,final long delayMillis ,final boolean end ,final boolean reOpen ,final int bufSize) {
        this(file, DEFAULT_CHARSET, listener, delayMillis, end, reOpen, bufSize);
    }

    public Tailer(final java.io.File file ,final java.nio.charset.Charset cset ,final org.apache.commons.io.input.TailerListener listener ,final long delayMillis ,final boolean end ,final boolean reOpen ,final int bufSize) {
        this.file = file;
        this.delayMillis = delayMillis;
        this.end = end;
        this.inbuf = new byte[bufSize];
        this.listener = listener;
        listener.init(this);
        this.reOpen = reOpen;
        this.cset = cset;
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final org.apache.commons.io.input.TailerListener listener, final long delayMillis, final boolean end, final int bufSize) {
        return org.apache.commons.io.input.Tailer.create(file, listener, delayMillis, end, false, bufSize);
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final org.apache.commons.io.input.TailerListener listener, final long delayMillis, final boolean end, final boolean reOpen, final int bufSize) {
        return org.apache.commons.io.input.Tailer.create(file, DEFAULT_CHARSET, listener, delayMillis, end, reOpen, bufSize);
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final java.nio.charset.Charset charset, final org.apache.commons.io.input.TailerListener listener, final long delayMillis, final boolean end, final boolean reOpen, final int bufSize) {
        final org.apache.commons.io.input.Tailer tailer = new org.apache.commons.io.input.Tailer(file , charset , listener , delayMillis , end , reOpen , bufSize);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final org.apache.commons.io.input.TailerListener listener, final long delayMillis, final boolean end) {
        return org.apache.commons.io.input.Tailer.create(file, listener, delayMillis, end, DEFAULT_BUFSIZE);
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final org.apache.commons.io.input.TailerListener listener, final long delayMillis, final boolean end, final boolean reOpen) {
        return org.apache.commons.io.input.Tailer.create(file, listener, delayMillis, end, reOpen, DEFAULT_BUFSIZE);
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final org.apache.commons.io.input.TailerListener listener, final long delayMillis) {
        return org.apache.commons.io.input.Tailer.create(file, listener, delayMillis, false);
    }

    public static org.apache.commons.io.input.Tailer a(final java.io.File file, final org.apache.commons.io.input.TailerListener listener) {
        return org.apache.commons.io.input.Tailer.create(file, listener, DEFAULT_DELAY_MILLIS, false);
    }

    public java.io.File b() {
        return file;
    }

    protected boolean a() {
        return run;
    }

    public long c() {
        return delayMillis;
    }

    public void d() {
        java.io.RandomAccessFile reader = null;
        try {
            long last = 0;
            long position = 0;
            while ((getRun()) && (reader == null)) {
                try {
                    reader = new java.io.RandomAccessFile(file , RAF_MODE);
                } catch (final java.io.FileNotFoundException e) {
                    listener.fileNotFound();
                }
                if (reader == null) {
                    java.lang.Thread.sleep(delayMillis);
                } else {
                    position = end ? file.length() : 0;
                    last = file.lastModified();
                    reader.seek(position);
                }
            }
            while (getRun()) {
                final boolean newer = org.apache.commons.io.FileUtils.isFileNewer(file, last);
                final long length = file.length();
                if (length < position) {
                    listener.fileRotated();
                    try {
                        final java.io.RandomAccessFile save = reader;
                        reader = new java.io.RandomAccessFile(file , RAF_MODE);
                        try {
                            readLines(save);
                        } catch (java.io.IOException ioe) {
                            listener.handle(ioe);
                        }
                        position = 0;
                        org.apache.commons.io.IOUtils.closeQuietly(save);
                    } catch (final java.io.FileNotFoundException e) {
                        listener.fileNotFound();
                    }
                    continue;
                } else {
                    if (length > position) {
                        position = readLines(reader);
                        last = file.lastModified();
                    } else if (newer) {
                        position = 0;
                        reader.seek(position);
                        position = readLines(reader);
                        last = file.lastModified();
                    } 
                }
                if (reOpen) {
                    org.apache.commons.io.IOUtils.closeQuietly(reader);
                } 
                java.lang.Thread.sleep(delayMillis);
                if ((getRun()) && (reOpen)) {
                    reader = new java.io.RandomAccessFile(file , RAF_MODE);
                    reader.seek(position);
                } 
            }
        } catch (final java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            stop(e);
        } catch (final java.lang.Exception e) {
            stop(e);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(reader);
        }
    }

    private void a(final java.lang.Exception e) {
        listener.handle(e);
        stop();
    }

    public void e() {
        this.run = false;
    }

    private long a(final java.io.RandomAccessFile reader) throws java.io.IOException {
        java.io.ByteArrayOutputStream lineBuf = new java.io.ByteArrayOutputStream(64);
        long pos = reader.getFilePointer();
        long rePos = pos;
        int num;
        boolean seenCR = false;
        while ((getRun()) && ((num = reader.read(inbuf)) != (org.apache.commons.io.IOUtils.EOF))) {
            for (int i = 0 ; i < num ; i++) {
                final byte ch = inbuf[i];
                switch (ch) {
                    case '\n' :
                        seenCR = false;
                        listener.handle(new java.lang.String(lineBuf.toByteArray() , cset));
                        lineBuf.reset();
                        rePos = (pos + i) + 1;
                        break;
                    case '\r' :
                        if (seenCR) {
                            lineBuf.write('\r');
                        } 
                        seenCR = true;
                        break;
                    default :
                        if (seenCR) {
                            seenCR = false;
                            listener.handle(new java.lang.String(lineBuf.toByteArray() , cset));
                            lineBuf.reset();
                            rePos = (pos + i) + 1;
                        } 
                        lineBuf.write(ch);
                }
            }
            pos = reader.getFilePointer();
        }
        org.apache.commons.io.IOUtils.closeQuietly(lineBuf);
        reader.seek(rePos);
        if ((listener) instanceof org.apache.commons.io.input.TailerListenerAdapter) {
            ((org.apache.commons.io.input.TailerListenerAdapter)(listener)).endOfFileReached();
        } 
        return rePos;
    }
}


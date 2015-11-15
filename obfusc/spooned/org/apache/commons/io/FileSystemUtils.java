package org.apache.commons.io;


public class FileSystemUtils {
    private static final org.apache.commons.io.FileSystemUtils INSTANCE = new org.apache.commons.io.FileSystemUtils();

    private static final int INIT_PROBLEM = -1;

    private static final int OTHER = 0;

    private static final int WINDOWS = 1;

    private static final int UNIX = 2;

    private static final int POSIX_UNIX = 3;

    private static final int OS;

    private static final java.lang.String DF;

    static {
        int os = OTHER;
        java.lang.String dfPath = "df";
        try {
            java.lang.String osName = java.lang.System.getProperty("os.name");
            if (osName == null) {
                throw new java.io.IOException("os.name not found");
            } 
            osName = osName.toLowerCase(java.util.Locale.ENGLISH);
            if (osName.contains("windows")) {
                os = WINDOWS;
            } else if (((((((osName.contains("linux")) || (osName.contains("mpe/ix"))) || (osName.contains("freebsd"))) || (osName.contains("irix"))) || (osName.contains("digital unix"))) || (osName.contains("unix"))) || (osName.contains("mac os x"))) {
                os = UNIX;
            } else if (((osName.contains("sun os")) || (osName.contains("sunos"))) || (osName.contains("solaris"))) {
                os = POSIX_UNIX;
                dfPath = "/usr/xpg4/bin/df";
            } else if ((osName.contains("hp-ux")) || (osName.contains("aix"))) {
                os = POSIX_UNIX;
            } else {
                os = OTHER;
            }
        } catch (final java.lang.Exception ex) {
            os = INIT_PROBLEM;
        }
        OS = os;
        DF = dfPath;
    }

    public FileSystemUtils() {
        super();
    }

    @java.lang.Deprecated
    public static long a(final java.lang.String path) throws java.io.IOException {
        return INSTANCE.freeSpaceOS(path, OS, false, -1);
    }

    public static long b(final java.lang.String path) throws java.io.IOException {
        return org.apache.commons.io.FileSystemUtils.freeSpaceKb(path, -1);
    }

    public static long a(final java.lang.String path, final long timeout) throws java.io.IOException {
        return INSTANCE.freeSpaceOS(path, OS, true, timeout);
    }

    public static long a() throws java.io.IOException {
        return org.apache.commons.io.FileSystemUtils.freeSpaceKb(-1);
    }

    public static long a(final long timeout) throws java.io.IOException {
        return org.apache.commons.io.FileSystemUtils.freeSpaceKb(new java.io.File(".").getAbsolutePath(), timeout);
    }

    long a(final java.lang.String path, final int os, final boolean kb, final long timeout) throws java.io.IOException {
        if (path == null) {
            throw new java.lang.IllegalArgumentException("Path must not be null");
        } 
        switch (os) {
            case WINDOWS :
                return kb ? (freeSpaceWindows(path, timeout)) / (org.apache.commons.io.FileUtils.ONE_KB) : freeSpaceWindows(path, timeout);
            case UNIX :
                return freeSpaceUnix(path, kb, false, timeout);
            case POSIX_UNIX :
                return freeSpaceUnix(path, kb, true, timeout);
            case OTHER :
                throw new java.lang.IllegalStateException("Unsupported operating system");
            default :
                throw new java.lang.IllegalStateException("Exception caught when determining operating system");
        }
    }

    long b(java.lang.String path, final long timeout) throws java.io.IOException {
        path = org.apache.commons.io.FilenameUtils.normalize(path, false);
        if (((path.length()) > 0) && ((path.charAt(0)) != '\"')) {
            path = ("\"" + path) + "\"";
        } 
        final java.lang.String[] cmdAttribs = new java.lang.String[]{ "cmd.exe" , "/C" , "dir /a /-c " + path };
        final java.util.List<java.lang.String> lines = performCommand(cmdAttribs, java.lang.Integer.MAX_VALUE, timeout);
        for (int i = (lines.size()) - 1 ; i >= 0 ; i--) {
            final java.lang.String line = lines.get(i);
            if ((line.length()) > 0) {
                return parseDir(line, path);
            } 
        }
        throw new java.io.IOException(((("Command line \'dir /-c\' did not return any info " + "for path \'") + path) + "\'"));
    }

    long b(final java.lang.String line, final java.lang.String path) throws java.io.IOException {
        int bytesStart = 0;
        int bytesEnd = 0;
        int j = (line.length()) - 1;
        innerLoop1 : while (j >= 0) {
            final char c = line.charAt(j);
            if (java.lang.Character.isDigit(c)) {
                bytesEnd = j + 1;
                break innerLoop1;
            } 
            j--;
        }
        innerLoop2 : while (j >= 0) {
            final char c = line.charAt(j);
            if (((!(java.lang.Character.isDigit(c))) && (c != ',')) && (c != '.')) {
                bytesStart = j + 1;
                break innerLoop2;
            } 
            j--;
        }
        if (j < 0) {
            throw new java.io.IOException(((("Command line \'dir /-c\' did not return valid info " + "for path \'") + path) + "\'"));
        } 
        final java.lang.StringBuilder buf = new java.lang.StringBuilder(line.substring(bytesStart, bytesEnd));
        for (int k = 0 ; k < (buf.length()) ; k++) {
            if (((buf.charAt(k)) == ',') || ((buf.charAt(k)) == '.')) {
                buf.deleteCharAt(k--);
            } 
        }
        return parseBytes(buf.toString(), path);
    }

    long a(final java.lang.String path, final boolean kb, final boolean posix, final long timeout) throws java.io.IOException {
        if (path.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Path must not be empty");
        } 
        java.lang.String flags = "-";
        if (kb) {
            flags += "k";
        } 
        if (posix) {
            flags += "P";
        } 
        final java.lang.String[] cmdAttribs = (flags.length()) > 1 ? new java.lang.String[]{ DF , flags , path } : new java.lang.String[]{ DF , path };
        final java.util.List<java.lang.String> lines = performCommand(cmdAttribs, 3, timeout);
        if ((lines.size()) < 2) {
            throw new java.io.IOException((((((("Command line \'" + (DF)) + "\' did not return info as expected ") + "for path \'") + path) + "\'- response was ") + lines));
        } 
        final java.lang.String line2 = lines.get(1);
        java.util.StringTokenizer tok = new java.util.StringTokenizer(line2 , " ");
        if ((tok.countTokens()) < 4) {
            if (((tok.countTokens()) == 1) && ((lines.size()) >= 3)) {
                final java.lang.String line3 = lines.get(2);
                tok = new java.util.StringTokenizer(line3 , " ");
            } else {
                throw new java.io.IOException(((((("Command line \'" + (DF)) + "\' did not return data as expected ") + "for path \'") + path) + "\'- check path is valid"));
            }
        } else {
            tok.nextToken();
        }
        tok.nextToken();
        tok.nextToken();
        final java.lang.String freeSpace = tok.nextToken();
        return parseBytes(freeSpace, path);
    }

    long a(final java.lang.String freeSpace, final java.lang.String path) throws java.io.IOException {
        try {
            final long bytes = java.lang.Long.parseLong(freeSpace);
            if (bytes < 0) {
                throw new java.io.IOException(((((("Command line \'" + (DF)) + "\' did not find free space in response ") + "for path \'") + path) + "\'- check path is valid"));
            } 
            return bytes;
        } catch (final java.lang.NumberFormatException ex) {
            throw new java.io.IOException(((((("Command line \'" + (DF)) + "\' did not return numeric data as expected ") + "for path \'") + path) + "\'- check path is valid") , ex);
        }
    }

    java.util.List<java.lang.String> a(final java.lang.String[] cmdAttribs, final int max, final long timeout) throws java.io.IOException {
        final java.util.List<java.lang.String> lines = new java.util.ArrayList<java.lang.String>(20);
        java.lang.Process proc = null;
        java.io.InputStream in = null;
        java.io.OutputStream out = null;
        java.io.InputStream err = null;
        java.io.BufferedReader inr = null;
        try {
            final java.lang.Thread monitor = org.apache.commons.io.ThreadMonitor.start(timeout);
            proc = openProcess(cmdAttribs);
            in = proc.getInputStream();
            out = proc.getOutputStream();
            err = proc.getErrorStream();
            inr = new java.io.BufferedReader(new java.io.InputStreamReader(in , java.nio.charset.Charset.defaultCharset()));
            java.lang.String line = inr.readLine();
            while ((line != null) && ((lines.size()) < max)) {
                line = line.toLowerCase(java.util.Locale.ENGLISH).trim();
                lines.add(line);
                line = inr.readLine();
            }
            proc.waitFor();
            org.apache.commons.io.ThreadMonitor.stop(monitor);
            if ((proc.exitValue()) != 0) {
                throw new java.io.IOException(((("Command line returned OS error code \'" + (proc.exitValue())) + "\' for command ") + (java.util.Arrays.asList(cmdAttribs))));
            } 
            if (lines.isEmpty()) {
                throw new java.io.IOException((("Command line did not return any info " + "for command ") + (java.util.Arrays.asList(cmdAttribs))));
            } 
            return lines;
        } catch (final java.lang.InterruptedException ex) {
            throw new java.io.IOException((((("Command line threw an InterruptedException " + "for command ") + (java.util.Arrays.asList(cmdAttribs))) + " timeout=") + timeout) , ex);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
            org.apache.commons.io.IOUtils.closeQuietly(out);
            org.apache.commons.io.IOUtils.closeQuietly(err);
            org.apache.commons.io.IOUtils.closeQuietly(inr);
            if (proc != null) {
                proc.destroy();
            } 
        }
    }

    java.lang.Process a(final java.lang.String[] cmdAttribs) throws java.io.IOException {
        return java.lang.Runtime.getRuntime().exec(cmdAttribs);
    }
}


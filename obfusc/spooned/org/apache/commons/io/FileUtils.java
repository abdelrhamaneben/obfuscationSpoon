package org.apache.commons.io;


public class FileUtils {
    public FileUtils() {
        super();
    }

    public static final long ONE_KB = 1024;

    public static final java.math.BigInteger ONE_KB_BI = java.math.BigInteger.valueOf(ONE_KB);

    public static final long ONE_MB = (ONE_KB) * (ONE_KB);

    public static final java.math.BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);

    private static final long FILE_COPY_BUFFER_SIZE = (ONE_MB) * 30;

    public static final long ONE_GB = (ONE_KB) * (ONE_MB);

    public static final java.math.BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);

    public static final long ONE_TB = (ONE_KB) * (ONE_GB);

    public static final java.math.BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);

    public static final long ONE_PB = (ONE_KB) * (ONE_TB);

    public static final java.math.BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);

    public static final long ONE_EB = (ONE_KB) * (ONE_PB);

    public static final java.math.BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);

    public static final java.math.BigInteger ONE_ZB = java.math.BigInteger.valueOf(ONE_KB).multiply(java.math.BigInteger.valueOf(ONE_EB));

    public static final java.math.BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);

    public static final java.io.File[] EMPTY_FILE_ARRAY = new java.io.File[0];

    public static java.io.File a(final java.io.File directory, final java.lang.String... names) {
        if (directory == null) {
            throw new java.lang.NullPointerException("directory must not be null");
        } 
        if (names == null) {
            throw new java.lang.NullPointerException("names must not be null");
        } 
        java.io.File file = directory;
        for (final java.lang.String name : names) {
            file = new java.io.File(file , name);
        }
        return file;
    }

    public static java.io.File a(final java.lang.String... names) {
        if (names == null) {
            throw new java.lang.NullPointerException("names must not be null");
        } 
        java.io.File file = null;
        for (final java.lang.String name : names) {
            if (file == null) {
                file = new java.io.File(name);
            } else {
                file = new java.io.File(file , name);
            }
        }
        return file;
    }

    public static java.lang.String c() {
        return java.lang.System.getProperty("java.io.tmpdir");
    }

    public static java.io.File a() {
        return new java.io.File(org.apache.commons.io.FileUtils.getTempDirectoryPath());
    }

    public static java.lang.String d() {
        return java.lang.System.getProperty("user.home");
    }

    public static java.io.File b() {
        return new java.io.File(org.apache.commons.io.FileUtils.getUserDirectoryPath());
    }

    public static java.io.FileInputStream e(final java.io.File file) throws java.io.IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new java.io.IOException((("File \'" + file) + "\' exists but is a directory"));
            } 
            if ((file.canRead()) == false) {
                throw new java.io.IOException((("File \'" + file) + "\' cannot be read"));
            } 
        } else {
            throw new java.io.FileNotFoundException((("File \'" + file) + "\' does not exist"));
        }
        return new java.io.FileInputStream(file);
    }

    public static java.io.FileOutputStream f(final java.io.File file) throws java.io.IOException {
        return org.apache.commons.io.FileUtils.openOutputStream(file, false);
    }

    public static java.io.FileOutputStream a(final java.io.File file, final boolean append) throws java.io.IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new java.io.IOException((("File \'" + file) + "\' exists but is a directory"));
            } 
            if ((file.canWrite()) == false) {
                throw new java.io.IOException((("File \'" + file) + "\' cannot be written to"));
            } 
        } else {
            final java.io.File parent = file.getParentFile();
            if (parent != null) {
                if ((!(parent.mkdirs())) && (!(parent.isDirectory()))) {
                    throw new java.io.IOException((("Directory \'" + parent) + "\' could not be created"));
                } 
            } 
        }
        return new java.io.FileOutputStream(file , append);
    }

    public static java.lang.String a(final java.math.BigInteger size) {
        java.lang.String displaySize;
        if ((size.divide(ONE_EB_BI).compareTo(java.math.BigInteger.ZERO)) > 0) {
            displaySize = (java.lang.String.valueOf(size.divide(ONE_EB_BI))) + " EB";
        } else if ((size.divide(ONE_PB_BI).compareTo(java.math.BigInteger.ZERO)) > 0) {
            displaySize = (java.lang.String.valueOf(size.divide(ONE_PB_BI))) + " PB";
        } else if ((size.divide(ONE_TB_BI).compareTo(java.math.BigInteger.ZERO)) > 0) {
            displaySize = (java.lang.String.valueOf(size.divide(ONE_TB_BI))) + " TB";
        } else if ((size.divide(ONE_GB_BI).compareTo(java.math.BigInteger.ZERO)) > 0) {
            displaySize = (java.lang.String.valueOf(size.divide(ONE_GB_BI))) + " GB";
        } else if ((size.divide(ONE_MB_BI).compareTo(java.math.BigInteger.ZERO)) > 0) {
            displaySize = (java.lang.String.valueOf(size.divide(ONE_MB_BI))) + " MB";
        } else if ((size.divide(ONE_KB_BI).compareTo(java.math.BigInteger.ZERO)) > 0) {
            displaySize = (java.lang.String.valueOf(size.divide(ONE_KB_BI))) + " KB";
        } else {
            displaySize = (java.lang.String.valueOf(size)) + " bytes";
        }
        return displaySize;
    }

    public static java.lang.String a(final long size) {
        return org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.math.BigInteger.valueOf(size));
    }

    public static void ac(final java.io.File file) throws java.io.IOException {
        if (!(file.exists())) {
            final java.io.OutputStream out = org.apache.commons.io.FileUtils.openOutputStream(file);
            org.apache.commons.io.IOUtils.closeQuietly(out);
        } 
        final boolean success = file.setLastModified(java.lang.System.currentTimeMillis());
        if (!success) {
            throw new java.io.IOException(("Unable to set the last modification time for " + file));
        } 
    }

    public static java.io.File[] a(final java.util.Collection<java.io.File> files) {
        return files.toArray(new java.io.File[files.size()]);
    }

    private static void a(final java.util.Collection<java.io.File> files, final java.io.File directory, final org.apache.commons.io.filefilter.IOFileFilter filter, final boolean includeSubDirectories) {
        final java.io.File[] found = directory.listFiles(((java.io.FileFilter)(filter)));
        if (found != null) {
            for (final java.io.File file : found) {
                if (file.isDirectory()) {
                    if (includeSubDirectories) {
                        files.add(file);
                    } 
                    org.apache.commons.io.FileUtils.innerListFiles(files, file, filter, includeSubDirectories);
                } else {
                    files.add(file);
                }
            }
        } 
    }

    public static java.util.Collection<java.io.File> a(final java.io.File directory, final org.apache.commons.io.filefilter.IOFileFilter fileFilter, final org.apache.commons.io.filefilter.IOFileFilter dirFilter) {
        org.apache.commons.io.FileUtils.validateListFilesParameters(directory, fileFilter);
        final org.apache.commons.io.filefilter.IOFileFilter effFileFilter = org.apache.commons.io.FileUtils.setUpEffectiveFileFilter(fileFilter);
        final org.apache.commons.io.filefilter.IOFileFilter effDirFilter = org.apache.commons.io.FileUtils.setUpEffectiveDirFilter(dirFilter);
        final java.util.Collection<java.io.File> files = new java.util.LinkedList<java.io.File>();
        org.apache.commons.io.FileUtils.innerListFiles(files, directory, org.apache.commons.io.filefilter.FileFilterUtils.or(effFileFilter, effDirFilter), false);
        return files;
    }

    private static void a(final java.io.File directory, final org.apache.commons.io.filefilter.IOFileFilter fileFilter) {
        if (!(directory.isDirectory())) {
            throw new java.lang.IllegalArgumentException(("Parameter \'directory\' is not a directory: " + directory));
        } 
        if (fileFilter == null) {
            throw new java.lang.NullPointerException("Parameter \'fileFilter\' is null");
        } 
    }

    private static org.apache.commons.io.filefilter.IOFileFilter b(final org.apache.commons.io.filefilter.IOFileFilter fileFilter) {
        return org.apache.commons.io.filefilter.FileFilterUtils.and(fileFilter, org.apache.commons.io.filefilter.FileFilterUtils.notFileFilter(org.apache.commons.io.filefilter.DirectoryFileFilter.INSTANCE));
    }

    private static org.apache.commons.io.filefilter.IOFileFilter a(final org.apache.commons.io.filefilter.IOFileFilter dirFilter) {
        return dirFilter == null ? org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE : org.apache.commons.io.filefilter.FileFilterUtils.and(dirFilter, org.apache.commons.io.filefilter.DirectoryFileFilter.INSTANCE);
    }

    public static java.util.Collection<java.io.File> b(final java.io.File directory, final org.apache.commons.io.filefilter.IOFileFilter fileFilter, final org.apache.commons.io.filefilter.IOFileFilter dirFilter) {
        org.apache.commons.io.FileUtils.validateListFilesParameters(directory, fileFilter);
        final org.apache.commons.io.filefilter.IOFileFilter effFileFilter = org.apache.commons.io.FileUtils.setUpEffectiveFileFilter(fileFilter);
        final org.apache.commons.io.filefilter.IOFileFilter effDirFilter = org.apache.commons.io.FileUtils.setUpEffectiveDirFilter(dirFilter);
        final java.util.Collection<java.io.File> files = new java.util.LinkedList<java.io.File>();
        if (directory.isDirectory()) {
            files.add(directory);
        } 
        org.apache.commons.io.FileUtils.innerListFiles(files, directory, org.apache.commons.io.filefilter.FileFilterUtils.or(effFileFilter, effDirFilter), true);
        return files;
    }

    public static java.util.Iterator<java.io.File> c(final java.io.File directory, final org.apache.commons.io.filefilter.IOFileFilter fileFilter, final org.apache.commons.io.filefilter.IOFileFilter dirFilter) {
        return org.apache.commons.io.FileUtils.listFiles(directory, fileFilter, dirFilter).iterator();
    }

    public static java.util.Iterator<java.io.File> d(final java.io.File directory, final org.apache.commons.io.filefilter.IOFileFilter fileFilter, final org.apache.commons.io.filefilter.IOFileFilter dirFilter) {
        return org.apache.commons.io.FileUtils.listFilesAndDirs(directory, fileFilter, dirFilter).iterator();
    }

    private static java.lang.String[] b(final java.lang.String[] extensions) {
        final java.lang.String[] suffixes = new java.lang.String[extensions.length];
        for (int i = 0 ; i < (extensions.length) ; i++) {
            suffixes[i] = "." + (extensions[i]);
        }
        return suffixes;
    }

    public static java.util.Collection<java.io.File> a(final java.io.File directory, final java.lang.String[] extensions, final boolean recursive) {
        org.apache.commons.io.filefilter.IOFileFilter filter;
        if (extensions == null) {
            filter = org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE;
        } else {
            final java.lang.String[] suffixes = org.apache.commons.io.FileUtils.toSuffixes(extensions);
            filter = new org.apache.commons.io.filefilter.SuffixFileFilter(suffixes);
        }
        return org.apache.commons.io.FileUtils.listFiles(directory, filter, (recursive ? org.apache.commons.io.filefilter.TrueFileFilter.INSTANCE : org.apache.commons.io.filefilter.FalseFileFilter.INSTANCE));
    }

    public static java.util.Iterator<java.io.File> b(final java.io.File directory, final java.lang.String[] extensions, final boolean recursive) {
        return org.apache.commons.io.FileUtils.listFiles(directory, extensions, recursive).iterator();
    }

    public static boolean a(final java.io.File file1, final java.io.File file2) throws java.io.IOException {
        final boolean file1Exists = file1.exists();
        if (file1Exists != (file2.exists())) {
            return false;
        } 
        if (!file1Exists) {
            return true;
        } 
        if ((file1.isDirectory()) || (file2.isDirectory())) {
            throw new java.io.IOException("Can\'t compare directories, only files");
        } 
        if ((file1.length()) != (file2.length())) {
            return false;
        } 
        if (file1.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        } 
        java.io.InputStream input1 = null;
        java.io.InputStream input2 = null;
        try {
            input1 = new java.io.FileInputStream(file1);
            input2 = new java.io.FileInputStream(file2);
            return org.apache.commons.io.IOUtils.contentEquals(input1, input2);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(input1);
            org.apache.commons.io.IOUtils.closeQuietly(input2);
        }
    }

    public static boolean a(final java.io.File file1, final java.io.File file2, final java.lang.String charsetName) throws java.io.IOException {
        final boolean file1Exists = file1.exists();
        if (file1Exists != (file2.exists())) {
            return false;
        } 
        if (!file1Exists) {
            return true;
        } 
        if ((file1.isDirectory()) || (file2.isDirectory())) {
            throw new java.io.IOException("Can\'t compare directories, only files");
        } 
        if (file1.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        } 
        java.io.Reader input1 = null;
        java.io.Reader input2 = null;
        try {
            if (charsetName == null) {
                input1 = new java.io.InputStreamReader(new java.io.FileInputStream(file1) , java.nio.charset.Charset.defaultCharset());
                input2 = new java.io.InputStreamReader(new java.io.FileInputStream(file2) , java.nio.charset.Charset.defaultCharset());
            } else {
                input1 = new java.io.InputStreamReader(new java.io.FileInputStream(file1) , charsetName);
                input2 = new java.io.InputStreamReader(new java.io.FileInputStream(file2) , charsetName);
            }
            return org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(input1, input2);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(input1);
            org.apache.commons.io.IOUtils.closeQuietly(input2);
        }
    }

    public static java.io.File a(final java.net.URL url) {
        if ((url == null) || (!("file".equalsIgnoreCase(url.getProtocol())))) {
            return null;
        } else {
            java.lang.String filename = url.getFile().replace('/', java.io.File.separatorChar);
            filename = org.apache.commons.io.FileUtils.decodeUrl(filename);
            return new java.io.File(filename);
        }
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    static java.lang.String a(final java.lang.String url) {
        java.lang.String decoded = url;
        if ((url != null) && ((url.indexOf('%')) >= 0)) {
            final int n = url.length();
            final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
            final java.nio.ByteBuffer bytes = java.nio.ByteBuffer.allocate(n);
            for (int i = 0 ; i < n ; ) {
                if ((url.charAt(i)) == '%') {
                    try {
                        do {
                            final byte octet = ((byte)(java.lang.Integer.parseInt(url.substring((i + 1), (i + 3)), 16)));
                            bytes.put(octet);
                            i += 3;
                        } while ((i < n) && ((url.charAt(i)) == '%') );
                        continue;
                    } catch (final java.lang.RuntimeException e) {
                    } finally {
                        if ((bytes.position()) > 0) {
                            bytes.flip();
                            buffer.append(org.apache.commons.io.Charsets.UTF_8.decode(bytes).toString());
                            bytes.clear();
                        } 
                    }
                } 
                buffer.append(url.charAt(i++));
            }
            decoded = buffer.toString();
        } 
        return decoded;
    }

    public static java.io.File[] a(final java.net.URL[] urls) {
        if ((urls == null) || ((urls.length) == 0)) {
            return EMPTY_FILE_ARRAY;
        } 
        final java.io.File[] files = new java.io.File[urls.length];
        for (int i = 0 ; i < (urls.length) ; i++) {
            final java.net.URL url = urls[i];
            if (url != null) {
                if ((url.getProtocol().equals("file")) == false) {
                    throw new java.lang.IllegalArgumentException(("URL could not be converted to a File: " + url));
                } 
                files[i] = org.apache.commons.io.FileUtils.toFile(url);
            } 
        }
        return files;
    }

    public static java.net.URL[] a(final java.io.File[] files) throws java.io.IOException {
        final java.net.URL[] urls = new java.net.URL[files.length];
        for (int i = 0 ; i < (urls.length) ; i++) {
            urls[i] = files[i].toURI().toURL();
        }
        return urls;
    }

    public static void i(final java.io.File srcFile, final java.io.File destDir) throws java.io.IOException {
        org.apache.commons.io.FileUtils.copyFileToDirectory(srcFile, destDir, true);
    }

    public static void c(final java.io.File srcFile, final java.io.File destDir, final boolean preserveFileDate) throws java.io.IOException {
        if (destDir == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        } 
        if ((destDir.exists()) && ((destDir.isDirectory()) == false)) {
            throw new java.lang.IllegalArgumentException((("Destination \'" + destDir) + "\' is not a directory"));
        } 
        final java.io.File destFile = new java.io.File(destDir , srcFile.getName());
        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile, preserveFileDate);
    }

    public static void h(final java.io.File srcFile, final java.io.File destFile) throws java.io.IOException {
        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile, true);
    }

    public static void b(final java.io.File srcFile, final java.io.File destFile, final boolean preserveFileDate) throws java.io.IOException {
        org.apache.commons.io.FileUtils.checkFileRequirements(srcFile, destFile);
        if (srcFile.isDirectory()) {
            throw new java.io.IOException((("Source \'" + srcFile) + "\' exists but is a directory"));
        } 
        if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
            throw new java.io.IOException((((("Source \'" + srcFile) + "\' and destination \'") + destFile) + "\' are the same"));
        } 
        final java.io.File parentFile = destFile.getParentFile();
        if (parentFile != null) {
            if ((!(parentFile.mkdirs())) && (!(parentFile.isDirectory()))) {
                throw new java.io.IOException((("Destination \'" + parentFile) + "\' directory cannot be created"));
            } 
        } 
        if ((destFile.exists()) && ((destFile.canWrite()) == false)) {
            throw new java.io.IOException((("Destination \'" + destFile) + "\' exists but is read-only"));
        } 
        org.apache.commons.io.FileUtils.doCopyFile(srcFile, destFile, preserveFileDate);
    }

    public static long a(final java.io.File input, final java.io.OutputStream output) throws java.io.IOException {
        final java.io.FileInputStream fis = new java.io.FileInputStream(input);
        try {
            return org.apache.commons.io.IOUtils.copyLarge(fis, output);
        } finally {
            fis.close();
        }
    }

    private static void d(final java.io.File srcFile, final java.io.File destFile, final boolean preserveFileDate) throws java.io.IOException {
        if ((destFile.exists()) && (destFile.isDirectory())) {
            throw new java.io.IOException((("Destination \'" + destFile) + "\' exists but is a directory"));
        } 
        java.io.FileInputStream fis = null;
        java.io.FileOutputStream fos = null;
        java.nio.channels.FileChannel input = null;
        java.nio.channels.FileChannel output = null;
        try {
            fis = new java.io.FileInputStream(srcFile);
            fos = new java.io.FileOutputStream(destFile);
            input = fis.getChannel();
            output = fos.getChannel();
            final long size = input.size();
            long pos = 0;
            long count = 0;
            while (pos < size) {
                final long remain = size - pos;
                count = remain > (FILE_COPY_BUFFER_SIZE) ? FILE_COPY_BUFFER_SIZE : remain;
                final long bytesCopied = output.transferFrom(input, pos, count);
                if (bytesCopied == 0) {
                    break;
                } 
                pos += bytesCopied;
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(output, fos, input, fis);
        }
        final long srcLen = srcFile.length();
        final long dstLen = destFile.length();
        if (srcLen != dstLen) {
            throw new java.io.IOException(((((((("Failed to copy full contents from \'" + srcFile) + "\' to \'") + destFile) + "\' Expected length: ") + srcLen) + " Actual: ") + dstLen));
        } 
        if (preserveFileDate) {
            destFile.setLastModified(srcFile.lastModified());
        } 
    }

    public static void g(final java.io.File srcDir, final java.io.File destDir) throws java.io.IOException {
        if (srcDir == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if ((srcDir.exists()) && ((srcDir.isDirectory()) == false)) {
            throw new java.lang.IllegalArgumentException((("Source \'" + destDir) + "\' is not a directory"));
        } 
        if (destDir == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        } 
        if ((destDir.exists()) && ((destDir.isDirectory()) == false)) {
            throw new java.lang.IllegalArgumentException((("Destination \'" + destDir) + "\' is not a directory"));
        } 
        org.apache.commons.io.FileUtils.copyDirectory(srcDir, new java.io.File(destDir , srcDir.getName()), true);
    }

    public static void f(final java.io.File srcDir, final java.io.File destDir) throws java.io.IOException {
        org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir, true);
    }

    public static void a(final java.io.File srcDir, final java.io.File destDir, final boolean preserveFileDate) throws java.io.IOException {
        org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir, null, preserveFileDate);
    }

    public static void a(final java.io.File srcDir, final java.io.File destDir, final java.io.FileFilter filter) throws java.io.IOException {
        org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir, filter, true);
    }

    public static void a(final java.io.File srcDir, final java.io.File destDir, final java.io.FileFilter filter, final boolean preserveFileDate) throws java.io.IOException {
        org.apache.commons.io.FileUtils.checkFileRequirements(srcDir, destDir);
        if (!(srcDir.isDirectory())) {
            throw new java.io.IOException((("Source \'" + srcDir) + "\' exists but is not a directory"));
        } 
        if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
            throw new java.io.IOException((((("Source \'" + srcDir) + "\' and destination \'") + destDir) + "\' are the same"));
        } 
        java.util.List<java.lang.String> exclusionList = null;
        if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath())) {
            final java.io.File[] srcFiles = filter == null ? srcDir.listFiles() : srcDir.listFiles(filter);
            if ((srcFiles != null) && ((srcFiles.length) > 0)) {
                exclusionList = new java.util.ArrayList<java.lang.String>(srcFiles.length);
                for (final java.io.File srcFile : srcFiles) {
                    final java.io.File copiedFile = new java.io.File(destDir , srcFile.getName());
                    exclusionList.add(copiedFile.getCanonicalPath());
                }
            } 
        } 
        org.apache.commons.io.FileUtils.doCopyDirectory(srcDir, destDir, filter, preserveFileDate, exclusionList);
    }

    private static void e(java.io.File src, java.io.File dest) throws java.io.FileNotFoundException {
        if (src == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if (dest == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        } 
        if (!(src.exists())) {
            throw new java.io.FileNotFoundException((("Source \'" + src) + "\' does not exist"));
        } 
    }

    private static void a(final java.io.File srcDir, final java.io.File destDir, final java.io.FileFilter filter, final boolean preserveFileDate, final java.util.List<java.lang.String> exclusionList) throws java.io.IOException {
        final java.io.File[] srcFiles = filter == null ? srcDir.listFiles() : srcDir.listFiles(filter);
        if (srcFiles == null) {
            throw new java.io.IOException(("Failed to list contents of " + srcDir));
        } 
        if (destDir.exists()) {
            if ((destDir.isDirectory()) == false) {
                throw new java.io.IOException((("Destination \'" + destDir) + "\' exists but is not a directory"));
            } 
        } else {
            if ((!(destDir.mkdirs())) && (!(destDir.isDirectory()))) {
                throw new java.io.IOException((("Destination \'" + destDir) + "\' directory cannot be created"));
            } 
        }
        if ((destDir.canWrite()) == false) {
            throw new java.io.IOException((("Destination \'" + destDir) + "\' cannot be written to"));
        } 
        for (final java.io.File srcFile : srcFiles) {
            final java.io.File dstFile = new java.io.File(destDir , srcFile.getName());
            if ((exclusionList == null) || (!(exclusionList.contains(srcFile.getCanonicalPath())))) {
                if (srcFile.isDirectory()) {
                    org.apache.commons.io.FileUtils.doCopyDirectory(srcFile, dstFile, filter, preserveFileDate, exclusionList);
                } else {
                    org.apache.commons.io.FileUtils.doCopyFile(srcFile, dstFile, preserveFileDate);
                }
            } 
        }
        if (preserveFileDate) {
            destDir.setLastModified(srcDir.lastModified());
        } 
    }

    public static void a(final java.net.URL source, final java.io.File destination) throws java.io.IOException {
        org.apache.commons.io.FileUtils.copyInputStreamToFile(source.openStream(), destination);
    }

    public static void a(final java.net.URL source, final java.io.File destination, final int connectionTimeout, final int readTimeout) throws java.io.IOException {
        final java.net.URLConnection connection = source.openConnection();
        connection.setConnectTimeout(connectionTimeout);
        connection.setReadTimeout(readTimeout);
        org.apache.commons.io.FileUtils.copyInputStreamToFile(connection.getInputStream(), destination);
    }

    public static void a(final java.io.InputStream source, final java.io.File destination) throws java.io.IOException {
        try {
            org.apache.commons.io.FileUtils.copyToFile(source, destination);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(source);
        }
    }

    public static void b(final java.io.InputStream source, final java.io.File destination) throws java.io.IOException {
        final java.io.FileOutputStream output = org.apache.commons.io.FileUtils.openOutputStream(destination);
        try {
            org.apache.commons.io.IOUtils.copy(source, output);
            output.close();
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(output);
        }
    }

    public static void w(final java.io.File directory) throws java.io.IOException {
        if (!(directory.exists())) {
            return ;
        } 
        if (!(org.apache.commons.io.FileUtils.isSymlink(directory))) {
            org.apache.commons.io.FileUtils.cleanDirectory(directory);
        } 
        if (!(directory.delete())) {
            final java.lang.String message = ("Unable to delete directory " + directory) + ".";
            throw new java.io.IOException(message);
        } 
    }

    public static boolean a(final java.io.File file) {
        if (file == null) {
            return false;
        } 
        try {
            if (file.isDirectory()) {
                org.apache.commons.io.FileUtils.cleanDirectory(file);
            } 
        } catch (final java.lang.Exception ignored) {
        }
        try {
            return file.delete();
        } catch (final java.lang.Exception ignored) {
            return false;
        }
    }

    public static boolean b(final java.io.File directory, final java.io.File child) throws java.io.IOException {
        if (directory == null) {
            throw new java.lang.IllegalArgumentException("Directory must not be null");
        } 
        if (!(directory.isDirectory())) {
            throw new java.lang.IllegalArgumentException(("Not a directory: " + directory));
        } 
        if (child == null) {
            return false;
        } 
        if ((!(directory.exists())) || (!(child.exists()))) {
            return false;
        } 
        final java.lang.String canonicalParent = directory.getCanonicalPath();
        final java.lang.String canonicalChild = child.getCanonicalPath();
        return org.apache.commons.io.FilenameUtils.directoryContains(canonicalParent, canonicalChild);
    }

    public static void u(final java.io.File directory) throws java.io.IOException {
        final java.io.File[] files = org.apache.commons.io.FileUtils.verifiedListFiles(directory);
        java.io.IOException exception = null;
        for (final java.io.File file : files) {
            try {
                org.apache.commons.io.FileUtils.forceDelete(file);
            } catch (final java.io.IOException ioe) {
                exception = ioe;
            }
        }
        if (null != exception) {
            throw exception;
        } 
    }

    private static java.io.File[] g(java.io.File directory) throws java.io.IOException {
        if (!(directory.exists())) {
            final java.lang.String message = directory + " does not exist";
            throw new java.lang.IllegalArgumentException(message);
        } 
        if (!(directory.isDirectory())) {
            final java.lang.String message = directory + " is not a directory";
            throw new java.lang.IllegalArgumentException(message);
        } 
        final java.io.File[] files = directory.listFiles();
        if (files == null) {
            throw new java.io.IOException(("Failed to list contents of " + directory));
        } 
        return files;
    }

    public static boolean a(final java.io.File file, final int seconds) {
        long finishAt = (java.lang.System.currentTimeMillis()) + (seconds * 1000);
        boolean wasInterrupted = false;
        try {
            while (!(file.exists())) {
                long remaining = finishAt - (java.lang.System.currentTimeMillis());
                if (remaining < 0) {
                    return false;
                } 
                try {
                    java.lang.Thread.sleep(java.lang.Math.min(100, remaining));
                } catch (final java.lang.InterruptedException ignore) {
                    wasInterrupted = true;
                } catch (final java.lang.Exception ex) {
                    break;
                }
            }
        } finally {
            if (wasInterrupted) {
                java.lang.Thread.currentThread().interrupt();
            } 
        }
        return true;
    }

    public static java.lang.String a(final java.io.File file, final java.nio.charset.Charset encoding) throws java.io.IOException {
        java.io.InputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(file);
            return org.apache.commons.io.IOUtils.toString(in, org.apache.commons.io.Charsets.toCharset(encoding));
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    public static java.lang.String a(final java.io.File file, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.FileUtils.readFileToString(file, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.lang.String h(final java.io.File file) throws java.io.IOException {
        return org.apache.commons.io.FileUtils.readFileToString(file, java.nio.charset.Charset.defaultCharset());
    }

    public static byte[] d(final java.io.File file) throws java.io.IOException {
        java.io.InputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(file);
            return org.apache.commons.io.IOUtils.toByteArray(in);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    public static java.util.List<java.lang.String> b(final java.io.File file, final java.nio.charset.Charset encoding) throws java.io.IOException {
        java.io.InputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(file);
            return org.apache.commons.io.IOUtils.readLines(in, org.apache.commons.io.Charsets.toCharset(encoding));
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    public static java.util.List<java.lang.String> b(final java.io.File file, final java.lang.String encoding) throws java.io.IOException {
        return org.apache.commons.io.FileUtils.readLines(file, org.apache.commons.io.Charsets.toCharset(encoding));
    }

    @java.lang.Deprecated
    public static java.util.List<java.lang.String> m(final java.io.File file) throws java.io.IOException {
        return org.apache.commons.io.FileUtils.readLines(file, java.nio.charset.Charset.defaultCharset());
    }

    public static org.apache.commons.io.LineIterator c(final java.io.File file, final java.lang.String encoding) throws java.io.IOException {
        java.io.InputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(file);
            return org.apache.commons.io.IOUtils.lineIterator(in, encoding);
        } catch (final java.io.IOException ex) {
            org.apache.commons.io.IOUtils.closeQuietly(in);
            throw ex;
        } catch (final java.lang.RuntimeException ex) {
            org.apache.commons.io.IOUtils.closeQuietly(in);
            throw ex;
        }
    }

    public static org.apache.commons.io.LineIterator s(final java.io.File file) throws java.io.IOException {
        return org.apache.commons.io.FileUtils.lineIterator(file, null);
    }

    public static void a(final java.io.File file, final java.lang.String data, final java.nio.charset.Charset encoding) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeStringToFile(file, data, encoding, false);
    }

    public static void a(final java.io.File file, final java.lang.String data, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeStringToFile(file, data, encoding, false);
    }

    public static void a(final java.io.File file, final java.lang.String data, final java.nio.charset.Charset encoding, final boolean append) throws java.io.IOException {
        java.io.OutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(file, append);
            org.apache.commons.io.IOUtils.write(data, out, encoding);
            out.close();
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
    }

    public static void a(final java.io.File file, final java.lang.String data, final java.lang.String encoding, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeStringToFile(file, data, org.apache.commons.io.Charsets.toCharset(encoding), append);
    }

    @java.lang.Deprecated
    public static void d(final java.io.File file, final java.lang.String data) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeStringToFile(file, data, java.nio.charset.Charset.defaultCharset(), false);
    }

    @java.lang.Deprecated
    public static void a(final java.io.File file, final java.lang.String data, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeStringToFile(file, data, java.nio.charset.Charset.defaultCharset(), append);
    }

    @java.lang.Deprecated
    public static void a(final java.io.File file, final java.lang.CharSequence data) throws java.io.IOException {
        org.apache.commons.io.FileUtils.write(file, data, java.nio.charset.Charset.defaultCharset(), false);
    }

    @java.lang.Deprecated
    public static void a(final java.io.File file, final java.lang.CharSequence data, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.write(file, data, java.nio.charset.Charset.defaultCharset(), append);
    }

    public static void a(final java.io.File file, final java.lang.CharSequence data, final java.nio.charset.Charset encoding) throws java.io.IOException {
        org.apache.commons.io.FileUtils.write(file, data, encoding, false);
    }

    public static void a(final java.io.File file, final java.lang.CharSequence data, final java.lang.String encoding) throws java.io.IOException {
        org.apache.commons.io.FileUtils.write(file, data, encoding, false);
    }

    public static void a(final java.io.File file, final java.lang.CharSequence data, final java.nio.charset.Charset encoding, final boolean append) throws java.io.IOException {
        final java.lang.String str = data == null ? null : data.toString();
        org.apache.commons.io.FileUtils.writeStringToFile(file, str, encoding, append);
    }

    public static void a(final java.io.File file, final java.lang.CharSequence data, final java.lang.String encoding, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.write(file, data, org.apache.commons.io.Charsets.toCharset(encoding), append);
    }

    public static void a(final java.io.File file, final byte[] data) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, false);
    }

    public static void a(final java.io.File file, final byte[] data, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, 0, data.length, append);
    }

    public static void a(final java.io.File file, final byte[] data, final int off, final int len) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, off, len, false);
    }

    public static void a(final java.io.File file, final byte[] data, final int off, final int len, final boolean append) throws java.io.IOException {
        java.io.OutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(file, append);
            out.write(data, off, len);
            out.close();
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
    }

    public static void a(final java.io.File file, final java.lang.String encoding, final java.util.Collection<?> lines) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, encoding, lines, null, false);
    }

    public static void a(final java.io.File file, final java.lang.String encoding, final java.util.Collection<?> lines, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, encoding, lines, null, append);
    }

    public static void a(final java.io.File file, final java.util.Collection<?> lines) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, null, lines, null, false);
    }

    public static void a(final java.io.File file, final java.util.Collection<?> lines, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, null, lines, null, append);
    }

    public static void a(final java.io.File file, final java.lang.String encoding, final java.util.Collection<?> lines, final java.lang.String lineEnding) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, encoding, lines, lineEnding, false);
    }

    public static void a(final java.io.File file, final java.lang.String encoding, final java.util.Collection<?> lines, final java.lang.String lineEnding, final boolean append) throws java.io.IOException {
        java.io.FileOutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(file, append);
            final java.io.BufferedOutputStream buffer = new java.io.BufferedOutputStream(out);
            org.apache.commons.io.IOUtils.writeLines(lines, lineEnding, buffer, encoding);
            buffer.flush();
            out.close();
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
    }

    public static void a(final java.io.File file, final java.util.Collection<?> lines, final java.lang.String lineEnding) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, null, lines, lineEnding, false);
    }

    public static void a(final java.io.File file, final java.util.Collection<?> lines, final java.lang.String lineEnding, final boolean append) throws java.io.IOException {
        org.apache.commons.io.FileUtils.writeLines(file, null, lines, lineEnding, append);
    }

    public static void y(final java.io.File file) throws java.io.IOException {
        if (file.isDirectory()) {
            org.apache.commons.io.FileUtils.deleteDirectory(file);
        } else {
            final boolean filePresent = file.exists();
            if (!(file.delete())) {
                if (!filePresent) {
                    throw new java.io.FileNotFoundException(("File does not exist: " + file));
                } 
                final java.lang.String message = "Unable to delete file: " + file;
                throw new java.io.IOException(message);
            } 
        }
    }

    public static void z(final java.io.File file) throws java.io.IOException {
        if (file.isDirectory()) {
            org.apache.commons.io.FileUtils.deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void x(final java.io.File directory) throws java.io.IOException {
        if (!(directory.exists())) {
            return ;
        } 
        directory.deleteOnExit();
        if (!(org.apache.commons.io.FileUtils.isSymlink(directory))) {
            org.apache.commons.io.FileUtils.cleanDirectoryOnExit(directory);
        } 
    }

    private static void v(final java.io.File directory) throws java.io.IOException {
        final java.io.File[] files = org.apache.commons.io.FileUtils.verifiedListFiles(directory);
        java.io.IOException exception = null;
        for (final java.io.File file : files) {
            try {
                org.apache.commons.io.FileUtils.forceDeleteOnExit(file);
            } catch (final java.io.IOException ioe) {
                exception = ioe;
            }
        }
        if (null != exception) {
            throw exception;
        } 
    }

    public static void aa(final java.io.File directory) throws java.io.IOException {
        if (directory.exists()) {
            if (!(directory.isDirectory())) {
                final java.lang.String message = (("File " + directory) + " exists and is ") + "not a directory. Unable to create directory.";
                throw new java.io.IOException(message);
            } 
        } else {
            if (!(directory.mkdirs())) {
                if (!(directory.isDirectory())) {
                    final java.lang.String message = "Unable to create directory " + directory;
                    throw new java.io.IOException(message);
                } 
            } 
        }
    }

    public static void ab(final java.io.File file) throws java.io.IOException {
        final java.io.File parent = file.getParentFile();
        if (parent == null) {
            return ;
        } 
        org.apache.commons.io.FileUtils.forceMkdir(parent);
    }

    public static long o(final java.io.File file) {
        if (!(file.exists())) {
            final java.lang.String message = file + " does not exist";
            throw new java.lang.IllegalArgumentException(message);
        } 
        if (file.isDirectory()) {
            return org.apache.commons.io.FileUtils.sizeOfDirectory0(file);
        } else {
            return file.length();
        }
    }

    public static java.math.BigInteger i(final java.io.File file) {
        if (!(file.exists())) {
            final java.lang.String message = file + " does not exist";
            throw new java.lang.IllegalArgumentException(message);
        } 
        if (file.isDirectory()) {
            return org.apache.commons.io.FileUtils.sizeOfDirectoryBig0(file);
        } else {
            return java.math.BigInteger.valueOf(file.length());
        }
    }

    public static long q(final java.io.File directory) {
        org.apache.commons.io.FileUtils.checkDirectory(directory);
        return org.apache.commons.io.FileUtils.sizeOfDirectory0(directory);
    }

    private static long r(final java.io.File directory) {
        final java.io.File[] files = directory.listFiles();
        if (files == null) {
            return 0L;
        } 
        long size = 0;
        for (final java.io.File file : files) {
            try {
                if (!(org.apache.commons.io.FileUtils.isSymlink(file))) {
                    size += org.apache.commons.io.FileUtils.sizeOf0(file);
                    if (size < 0) {
                        break;
                    } 
                } 
            } catch (final java.io.IOException ioe) {
            }
        }
        return size;
    }

    private static long p(java.io.File file) {
        if (file.isDirectory()) {
            return org.apache.commons.io.FileUtils.sizeOfDirectory0(file);
        } else {
            return file.length();
        }
    }

    public static java.math.BigInteger k(final java.io.File directory) {
        org.apache.commons.io.FileUtils.checkDirectory(directory);
        return org.apache.commons.io.FileUtils.sizeOfDirectoryBig0(directory);
    }

    private static java.math.BigInteger l(final java.io.File directory) {
        final java.io.File[] files = directory.listFiles();
        if (files == null) {
            return java.math.BigInteger.ZERO;
        } 
        java.math.BigInteger size = java.math.BigInteger.ZERO;
        for (final java.io.File file : files) {
            try {
                if (!(org.apache.commons.io.FileUtils.isSymlink(file))) {
                    size = size.add(org.apache.commons.io.FileUtils.sizeOfBig0(file));
                } 
            } catch (final java.io.IOException ioe) {
            }
        }
        return size;
    }

    private static java.math.BigInteger j(final java.io.File fileOrDir) {
        if (fileOrDir.isDirectory()) {
            return org.apache.commons.io.FileUtils.sizeOfDirectoryBig0(fileOrDir);
        } else {
            return java.math.BigInteger.valueOf(fileOrDir.length());
        }
    }

    private static void t(final java.io.File directory) {
        if (!(directory.exists())) {
            throw new java.lang.IllegalArgumentException((directory + " does not exist"));
        } 
        if (!(directory.isDirectory())) {
            throw new java.lang.IllegalArgumentException((directory + " is not a directory"));
        } 
    }

    public static boolean c(final java.io.File file, final java.io.File reference) {
        if (reference == null) {
            throw new java.lang.IllegalArgumentException("No specified reference file");
        } 
        if (!(reference.exists())) {
            throw new java.lang.IllegalArgumentException((("The reference file \'" + reference) + "\' doesn\'t exist"));
        } 
        return org.apache.commons.io.FileUtils.isFileNewer(file, reference.lastModified());
    }

    public static boolean a(final java.io.File file, final java.util.Date date) {
        if (date == null) {
            throw new java.lang.IllegalArgumentException("No specified date");
        } 
        return org.apache.commons.io.FileUtils.isFileNewer(file, date.getTime());
    }

    public static boolean a(final java.io.File file, final long timeMillis) {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("No specified file");
        } 
        if (!(file.exists())) {
            return false;
        } 
        return (file.lastModified()) > timeMillis;
    }

    public static boolean d(final java.io.File file, final java.io.File reference) {
        if (reference == null) {
            throw new java.lang.IllegalArgumentException("No specified reference file");
        } 
        if (!(reference.exists())) {
            throw new java.lang.IllegalArgumentException((("The reference file \'" + reference) + "\' doesn\'t exist"));
        } 
        return org.apache.commons.io.FileUtils.isFileOlder(file, reference.lastModified());
    }

    public static boolean b(final java.io.File file, final java.util.Date date) {
        if (date == null) {
            throw new java.lang.IllegalArgumentException("No specified date");
        } 
        return org.apache.commons.io.FileUtils.isFileOlder(file, date.getTime());
    }

    public static boolean b(final java.io.File file, final long timeMillis) {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("No specified file");
        } 
        if (!(file.exists())) {
            return false;
        } 
        return (file.lastModified()) < timeMillis;
    }

    public static long n(final java.io.File file) throws java.io.IOException {
        final java.util.zip.CRC32 crc = new java.util.zip.CRC32();
        org.apache.commons.io.FileUtils.checksum(file, crc);
        return crc.getValue();
    }

    public static java.util.zip.Checksum a(final java.io.File file, final java.util.zip.Checksum checksum) throws java.io.IOException {
        if (file.isDirectory()) {
            throw new java.lang.IllegalArgumentException("Checksums can\'t be computed on directories");
        } 
        java.io.InputStream in = null;
        try {
            in = new java.util.zip.CheckedInputStream(new java.io.FileInputStream(file) , checksum);
            org.apache.commons.io.IOUtils.copy(in, new org.apache.commons.io.output.NullOutputStream());
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
        return checksum;
    }

    public static void j(final java.io.File srcDir, final java.io.File destDir) throws java.io.IOException {
        if (srcDir == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if (destDir == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        } 
        if (!(srcDir.exists())) {
            throw new java.io.FileNotFoundException((("Source \'" + srcDir) + "\' does not exist"));
        } 
        if (!(srcDir.isDirectory())) {
            throw new java.io.IOException((("Source \'" + srcDir) + "\' is not a directory"));
        } 
        if (destDir.exists()) {
            throw new org.apache.commons.io.FileExistsException((("Destination \'" + destDir) + "\' already exists"));
        } 
        final boolean rename = srcDir.renameTo(destDir);
        if (!rename) {
            if (destDir.getCanonicalPath().startsWith(((srcDir.getCanonicalPath()) + (java.io.File.separator)))) {
                throw new java.io.IOException(((("Cannot move directory: " + srcDir) + " to a subdirectory of itself: ") + destDir));
            } 
            org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir);
            org.apache.commons.io.FileUtils.deleteDirectory(srcDir);
            if (srcDir.exists()) {
                throw new java.io.IOException((((("Failed to delete original directory \'" + srcDir) + "\' after copy to \'") + destDir) + "\'"));
            } 
        } 
    }

    public static void e(final java.io.File src, final java.io.File destDir, final boolean createDestDir) throws java.io.IOException {
        if (src == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if (destDir == null) {
            throw new java.lang.NullPointerException("Destination directory must not be null");
        } 
        if ((!(destDir.exists())) && createDestDir) {
            destDir.mkdirs();
        } 
        if (!(destDir.exists())) {
            throw new java.io.FileNotFoundException((((("Destination directory \'" + destDir) + "\' does not exist [createDestDir=") + createDestDir) + "]"));
        } 
        if (!(destDir.isDirectory())) {
            throw new java.io.IOException((("Destination \'" + destDir) + "\' is not a directory"));
        } 
        org.apache.commons.io.FileUtils.moveDirectory(src, new java.io.File(destDir , src.getName()));
    }

    public static void k(final java.io.File srcFile, final java.io.File destFile) throws java.io.IOException {
        if (srcFile == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if (destFile == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        } 
        if (!(srcFile.exists())) {
            throw new java.io.FileNotFoundException((("Source \'" + srcFile) + "\' does not exist"));
        } 
        if (srcFile.isDirectory()) {
            throw new java.io.IOException((("Source \'" + srcFile) + "\' is a directory"));
        } 
        if (destFile.exists()) {
            throw new org.apache.commons.io.FileExistsException((("Destination \'" + destFile) + "\' already exists"));
        } 
        if (destFile.isDirectory()) {
            throw new java.io.IOException((("Destination \'" + destFile) + "\' is a directory"));
        } 
        final boolean rename = srcFile.renameTo(destFile);
        if (!rename) {
            org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
            if (!(srcFile.delete())) {
                org.apache.commons.io.FileUtils.deleteQuietly(destFile);
                throw new java.io.IOException((((("Failed to delete original file \'" + srcFile) + "\' after copy to \'") + destFile) + "\'"));
            } 
        } 
    }

    public static void f(final java.io.File srcFile, final java.io.File destDir, final boolean createDestDir) throws java.io.IOException {
        if (srcFile == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if (destDir == null) {
            throw new java.lang.NullPointerException("Destination directory must not be null");
        } 
        if ((!(destDir.exists())) && createDestDir) {
            destDir.mkdirs();
        } 
        if (!(destDir.exists())) {
            throw new java.io.FileNotFoundException((((("Destination directory \'" + destDir) + "\' does not exist [createDestDir=") + createDestDir) + "]"));
        } 
        if (!(destDir.isDirectory())) {
            throw new java.io.IOException((("Destination \'" + destDir) + "\' is not a directory"));
        } 
        org.apache.commons.io.FileUtils.moveFile(srcFile, new java.io.File(destDir , srcFile.getName()));
    }

    public static void g(final java.io.File src, final java.io.File destDir, final boolean createDestDir) throws java.io.IOException {
        if (src == null) {
            throw new java.lang.NullPointerException("Source must not be null");
        } 
        if (destDir == null) {
            throw new java.lang.NullPointerException("Destination must not be null");
        } 
        if (!(src.exists())) {
            throw new java.io.FileNotFoundException((("Source \'" + src) + "\' does not exist"));
        } 
        if (src.isDirectory()) {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(src, destDir, createDestDir);
        } else {
            org.apache.commons.io.FileUtils.moveFileToDirectory(src, destDir, createDestDir);
        }
    }

    public static boolean c(final java.io.File file) throws java.io.IOException {
        if (org.apache.commons.io.Java7Support.isAtLeastJava7()) {
            return org.apache.commons.io.Java7Support.isSymLink(file);
        } 
        if (file == null) {
            throw new java.lang.NullPointerException("File must not be null");
        } 
        if (org.apache.commons.io.FilenameUtils.isSystemWindows()) {
            return false;
        } 
        java.io.File fileInCanonicalDir = null;
        if ((file.getParent()) == null) {
            fileInCanonicalDir = file;
        } else {
            final java.io.File canonicalDir = file.getParentFile().getCanonicalFile();
            fileInCanonicalDir = new java.io.File(canonicalDir , file.getName());
        }
        if (fileInCanonicalDir.getCanonicalFile().equals(fileInCanonicalDir.getAbsoluteFile())) {
            return org.apache.commons.io.FileUtils.isBrokenSymlink(file);
        } else {
            return true;
        }
    }

    private static boolean b(final java.io.File file) throws java.io.IOException {
        if (file.exists()) {
            return false;
        } 
        final java.io.File canon = file.getCanonicalFile();
        java.io.File parentDir = canon.getParentFile();
        if ((parentDir == null) || (!(parentDir.exists()))) {
            return false;
        } 
        java.io.File[] fileInDir = parentDir.listFiles(new java.io.FileFilter() {
            public boolean a(java.io.File aFile) {
                return aFile.equals(canon);
            }
        });
        return (fileInDir != null) && ((fileInDir.length) > 0);
    }
}


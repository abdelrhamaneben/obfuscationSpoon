package org.apache.commons.io;


public class FilenameUtils {
    private static final int NOT_FOUND = -1;

    public static final char EXTENSION_SEPARATOR = '.';

    public static final java.lang.String EXTENSION_SEPARATOR_STR = java.lang.Character.toString(EXTENSION_SEPARATOR);

    private static final char UNIX_SEPARATOR = '/';

    private static final char WINDOWS_SEPARATOR = '\\';

    private static final char SYSTEM_SEPARATOR = java.io.File.separatorChar;

    private static final char OTHER_SEPARATOR;

    static {
        if (org.apache.commons.io.FilenameUtils.isSystemWindows()) {
            OTHER_SEPARATOR = UNIX_SEPARATOR;
        } else {
            OTHER_SEPARATOR = WINDOWS_SEPARATOR;
        }
    }

    public FilenameUtils() {
        super();
    }

    static boolean a() {
        return (SYSTEM_SEPARATOR) == (WINDOWS_SEPARATOR);
    }

    private static boolean a(final char ch) {
        return (ch == (UNIX_SEPARATOR)) || (ch == (WINDOWS_SEPARATOR));
    }

    public static java.lang.String l(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.doNormalize(filename, SYSTEM_SEPARATOR, true);
    }

    public static java.lang.String b(final java.lang.String filename, final boolean unixSeparator) {
        final char separator = unixSeparator ? UNIX_SEPARATOR : WINDOWS_SEPARATOR;
        return org.apache.commons.io.FilenameUtils.doNormalize(filename, separator, true);
    }

    public static java.lang.String m(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.doNormalize(filename, SYSTEM_SEPARATOR, false);
    }

    public static java.lang.String c(final java.lang.String filename, final boolean unixSeparator) {
        final char separator = unixSeparator ? UNIX_SEPARATOR : WINDOWS_SEPARATOR;
        return org.apache.commons.io.FilenameUtils.doNormalize(filename, separator, false);
    }

    private static java.lang.String a(final java.lang.String filename, final char separator, final boolean keepSeparator) {
        if (filename == null) {
            return null;
        } 
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(filename);
        int size = filename.length();
        if (size == 0) {
            return filename;
        } 
        final int prefix = org.apache.commons.io.FilenameUtils.getPrefixLength(filename);
        if (prefix < 0) {
            return null;
        } 
        final char[] array = new char[size + 2];
        filename.getChars(0, filename.length(), array, 0);
        final char otherSeparator = separator == (SYSTEM_SEPARATOR) ? OTHER_SEPARATOR : SYSTEM_SEPARATOR;
        for (int i = 0 ; i < (array.length) ; i++) {
            if ((array[i]) == otherSeparator) {
                array[i] = separator;
            } 
        }
        boolean lastIsDirectory = true;
        if ((array[(size - 1)]) != separator) {
            array[size++] = separator;
            lastIsDirectory = false;
        } 
        for (int i = prefix + 1 ; i < size ; i++) {
            if (((array[i]) == separator) && ((array[(i - 1)]) == separator)) {
                java.lang.System.arraycopy(array, i, array, (i - 1), (size - i));
                size--;
                i--;
            } 
        }
        for (int i = prefix + 1 ; i < size ; i++) {
            if ((((array[i]) == separator) && ((array[(i - 1)]) == '.')) && ((i == (prefix + 1)) || ((array[(i - 2)]) == separator))) {
                if (i == (size - 1)) {
                    lastIsDirectory = true;
                } 
                java.lang.System.arraycopy(array, (i + 1), array, (i - 1), (size - i));
                size -= 2;
                i--;
            } 
        }
        outer : for (int i = prefix + 2 ; i < size ; i++) {
            if (((((array[i]) == separator) && ((array[(i - 1)]) == '.')) && ((array[(i - 2)]) == '.')) && ((i == (prefix + 2)) || ((array[(i - 3)]) == separator))) {
                if (i == (prefix + 2)) {
                    return null;
                } 
                if (i == (size - 1)) {
                    lastIsDirectory = true;
                } 
                int j;
                for (j = i - 4 ; j >= prefix ; j--) {
                    if ((array[j]) == separator) {
                        java.lang.System.arraycopy(array, (i + 1), array, (j + 1), (size - i));
                        size -= i - j;
                        i = j + 1;
                        continue outer;
                    } 
                }
                java.lang.System.arraycopy(array, (i + 1), array, prefix, (size - i));
                size -= (i + 1) - prefix;
                i = prefix + 1;
            } 
        }
        if (size <= 0) {
            return "";
        } 
        if (size <= prefix) {
            return new java.lang.String(array , 0 , size);
        } 
        if (lastIsDirectory && keepSeparator) {
            return new java.lang.String(array , 0 , size);
        } 
        return new java.lang.String(array , 0 , (size - 1));
    }

    public static java.lang.String i(final java.lang.String basePath, final java.lang.String fullFilenameToAdd) {
        final int prefix = org.apache.commons.io.FilenameUtils.getPrefixLength(fullFilenameToAdd);
        if (prefix < 0) {
            return null;
        } 
        if (prefix > 0) {
            return org.apache.commons.io.FilenameUtils.normalize(fullFilenameToAdd);
        } 
        if (basePath == null) {
            return null;
        } 
        final int len = basePath.length();
        if (len == 0) {
            return org.apache.commons.io.FilenameUtils.normalize(fullFilenameToAdd);
        } 
        final char ch = basePath.charAt((len - 1));
        if (org.apache.commons.io.FilenameUtils.isSeparator(ch)) {
            return org.apache.commons.io.FilenameUtils.normalize((basePath + fullFilenameToAdd));
        } else {
            return org.apache.commons.io.FilenameUtils.normalize(((basePath + '/') + fullFilenameToAdd));
        }
    }

    public static boolean a(final java.lang.String canonicalParent, final java.lang.String canonicalChild) throws java.io.IOException {
        if (canonicalParent == null) {
            throw new java.lang.IllegalArgumentException("Directory must not be null");
        } 
        if (canonicalChild == null) {
            return false;
        } 
        if (org.apache.commons.io.IOCase.SYSTEM.checkEquals(canonicalParent, canonicalChild)) {
            return false;
        } 
        return org.apache.commons.io.IOCase.SYSTEM.checkStartsWith(canonicalChild, canonicalParent);
    }

    public static java.lang.String p(final java.lang.String path) {
        if ((path == null) || ((path.indexOf(WINDOWS_SEPARATOR)) == (NOT_FOUND))) {
            return path;
        } 
        return path.replace(WINDOWS_SEPARATOR, UNIX_SEPARATOR);
    }

    public static java.lang.String q(final java.lang.String path) {
        if ((path == null) || ((path.indexOf(UNIX_SEPARATOR)) == (NOT_FOUND))) {
            return path;
        } 
        return path.replace(UNIX_SEPARATOR, WINDOWS_SEPARATOR);
    }

    public static java.lang.String o(final java.lang.String path) {
        if (path == null) {
            return null;
        } 
        if (org.apache.commons.io.FilenameUtils.isSystemWindows()) {
            return org.apache.commons.io.FilenameUtils.separatorsToWindows(path);
        } else {
            return org.apache.commons.io.FilenameUtils.separatorsToUnix(path);
        }
    }

    public static int a(final java.lang.String filename) {
        if (filename == null) {
            return NOT_FOUND;
        } 
        final int len = filename.length();
        if (len == 0) {
            return 0;
        } 
        char ch0 = filename.charAt(0);
        if (ch0 == ':') {
            return NOT_FOUND;
        } 
        if (len == 1) {
            if (ch0 == '~') {
                return 2;
            } 
            return org.apache.commons.io.FilenameUtils.isSeparator(ch0) ? 1 : 0;
        } else {
            if (ch0 == '~') {
                int posUnix = filename.indexOf(UNIX_SEPARATOR, 1);
                int posWin = filename.indexOf(WINDOWS_SEPARATOR, 1);
                if ((posUnix == (NOT_FOUND)) && (posWin == (NOT_FOUND))) {
                    return len + 1;
                } 
                posUnix = posUnix == (NOT_FOUND) ? posWin : posUnix;
                posWin = posWin == (NOT_FOUND) ? posUnix : posWin;
                return (java.lang.Math.min(posUnix, posWin)) + 1;
            } 
            final char ch1 = filename.charAt(1);
            if (ch1 == ':') {
                ch0 = java.lang.Character.toUpperCase(ch0);
                if ((ch0 >= 'A') && (ch0 <= 'Z')) {
                    if ((len == 2) || ((org.apache.commons.io.FilenameUtils.isSeparator(filename.charAt(2))) == false)) {
                        return 2;
                    } 
                    return 3;
                } 
                return NOT_FOUND;
            } else if ((org.apache.commons.io.FilenameUtils.isSeparator(ch0)) && (org.apache.commons.io.FilenameUtils.isSeparator(ch1))) {
                int posUnix = filename.indexOf(UNIX_SEPARATOR, 2);
                int posWin = filename.indexOf(WINDOWS_SEPARATOR, 2);
                if ((((posUnix == (NOT_FOUND)) && (posWin == (NOT_FOUND))) || (posUnix == 2)) || (posWin == 2)) {
                    return NOT_FOUND;
                } 
                posUnix = posUnix == (NOT_FOUND) ? posWin : posUnix;
                posWin = posWin == (NOT_FOUND) ? posUnix : posWin;
                return (java.lang.Math.min(posUnix, posWin)) + 1;
            } else {
                return org.apache.commons.io.FilenameUtils.isSeparator(ch0) ? 1 : 0;
            }
        }
    }

    public static int c(final java.lang.String filename) {
        if (filename == null) {
            return NOT_FOUND;
        } 
        final int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        final int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return java.lang.Math.max(lastUnixPos, lastWindowsPos);
    }

    public static int b(final java.lang.String filename) {
        if (filename == null) {
            return NOT_FOUND;
        } 
        final int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        final int lastSeparator = org.apache.commons.io.FilenameUtils.indexOfLastSeparator(filename);
        return lastSeparator > extensionPos ? NOT_FOUND : extensionPos;
    }

    public static java.lang.String k(final java.lang.String filename) {
        if (filename == null) {
            return null;
        } 
        final int len = org.apache.commons.io.FilenameUtils.getPrefixLength(filename);
        if (len < 0) {
            return null;
        } 
        if (len > (filename.length())) {
            org.apache.commons.io.FilenameUtils.failIfNullBytePresent((filename + (UNIX_SEPARATOR)));
            return filename + (UNIX_SEPARATOR);
        } 
        java.lang.String path = filename.substring(0, len);
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(path);
        return path;
    }

    public static java.lang.String i(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.doGetPath(filename, 1);
    }

    public static java.lang.String j(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.doGetPath(filename, 0);
    }

    private static java.lang.String a(final java.lang.String filename, final int separatorAdd) {
        if (filename == null) {
            return null;
        } 
        final int prefix = org.apache.commons.io.FilenameUtils.getPrefixLength(filename);
        if (prefix < 0) {
            return null;
        } 
        final int index = org.apache.commons.io.FilenameUtils.indexOfLastSeparator(filename);
        final int endIndex = index + separatorAdd;
        if (((prefix >= (filename.length())) || (index < 0)) || (prefix >= endIndex)) {
            return "";
        } 
        java.lang.String path = filename.substring(prefix, endIndex);
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(path);
        return path;
    }

    public static java.lang.String f(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.doGetFullPath(filename, true);
    }

    public static java.lang.String g(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.doGetFullPath(filename, false);
    }

    private static java.lang.String a(final java.lang.String filename, final boolean includeSeparator) {
        if (filename == null) {
            return null;
        } 
        final int prefix = org.apache.commons.io.FilenameUtils.getPrefixLength(filename);
        if (prefix < 0) {
            return null;
        } 
        if (prefix >= (filename.length())) {
            if (includeSeparator) {
                return org.apache.commons.io.FilenameUtils.getPrefix(filename);
            } else {
                return filename;
            }
        } 
        final int index = org.apache.commons.io.FilenameUtils.indexOfLastSeparator(filename);
        if (index < 0) {
            return filename.substring(0, prefix);
        } 
        int end = index + (includeSeparator ? 1 : 0);
        if (end == 0) {
            end++;
        } 
        return filename.substring(0, end);
    }

    public static java.lang.String h(final java.lang.String filename) {
        if (filename == null) {
            return null;
        } 
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(filename);
        final int index = org.apache.commons.io.FilenameUtils.indexOfLastSeparator(filename);
        return filename.substring((index + 1));
    }

    private static void s(java.lang.String path) {
        int len = path.length();
        for (int i = 0 ; i < len ; i++) {
            if ((path.charAt(i)) == 0) {
                throw new java.lang.IllegalArgumentException(("Null byte present in file/path name. There are no " + "known legitimate use cases for such data, but several injection attacks may use it"));
            } 
        }
    }

    public static java.lang.String d(final java.lang.String filename) {
        return org.apache.commons.io.FilenameUtils.removeExtension(org.apache.commons.io.FilenameUtils.getName(filename));
    }

    public static java.lang.String e(final java.lang.String filename) {
        if (filename == null) {
            return null;
        } 
        final int index = org.apache.commons.io.FilenameUtils.indexOfExtension(filename);
        if (index == (NOT_FOUND)) {
            return "";
        } else {
            return filename.substring((index + 1));
        }
    }

    public static java.lang.String n(final java.lang.String filename) {
        if (filename == null) {
            return null;
        } 
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(filename);
        final int index = org.apache.commons.io.FilenameUtils.indexOfExtension(filename);
        if (index == (NOT_FOUND)) {
            return filename;
        } else {
            return filename.substring(0, index);
        }
    }

    public static boolean b(final java.lang.String filename1, final java.lang.String filename2) {
        return org.apache.commons.io.FilenameUtils.equals(filename1, filename2, false, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public static boolean e(final java.lang.String filename1, final java.lang.String filename2) {
        return org.apache.commons.io.FilenameUtils.equals(filename1, filename2, false, org.apache.commons.io.IOCase.SYSTEM);
    }

    public static boolean c(final java.lang.String filename1, final java.lang.String filename2) {
        return org.apache.commons.io.FilenameUtils.equals(filename1, filename2, true, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public static boolean d(final java.lang.String filename1, final java.lang.String filename2) {
        return org.apache.commons.io.FilenameUtils.equals(filename1, filename2, true, org.apache.commons.io.IOCase.SYSTEM);
    }

    public static boolean a(java.lang.String filename1, java.lang.String filename2, final boolean normalized, org.apache.commons.io.IOCase caseSensitivity) {
        if ((filename1 == null) || (filename2 == null)) {
            return (filename1 == null) && (filename2 == null);
        } 
        if (normalized) {
            filename1 = org.apache.commons.io.FilenameUtils.normalize(filename1);
            filename2 = org.apache.commons.io.FilenameUtils.normalize(filename2);
            if ((filename1 == null) || (filename2 == null)) {
                throw new java.lang.NullPointerException("Error normalizing one or both of the file names");
            } 
        } 
        if (caseSensitivity == null) {
            caseSensitivity = org.apache.commons.io.IOCase.SENSITIVE;
        } 
        return caseSensitivity.checkEquals(filename1, filename2);
    }

    public static boolean f(final java.lang.String filename, final java.lang.String extension) {
        if (filename == null) {
            return false;
        } 
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(filename);
        if ((extension == null) || (extension.isEmpty())) {
            return (org.apache.commons.io.FilenameUtils.indexOfExtension(filename)) == (NOT_FOUND);
        } 
        final java.lang.String fileExt = org.apache.commons.io.FilenameUtils.getExtension(filename);
        return fileExt.equals(extension);
    }

    public static boolean a(final java.lang.String filename, final java.lang.String[] extensions) {
        if (filename == null) {
            return false;
        } 
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(filename);
        if ((extensions == null) || ((extensions.length) == 0)) {
            return (org.apache.commons.io.FilenameUtils.indexOfExtension(filename)) == (NOT_FOUND);
        } 
        final java.lang.String fileExt = org.apache.commons.io.FilenameUtils.getExtension(filename);
        for (final java.lang.String extension : extensions) {
            if (fileExt.equals(extension)) {
                return true;
            } 
        }
        return false;
    }

    public static boolean a(final java.lang.String filename, final java.util.Collection<java.lang.String> extensions) {
        if (filename == null) {
            return false;
        } 
        org.apache.commons.io.FilenameUtils.failIfNullBytePresent(filename);
        if ((extensions == null) || (extensions.isEmpty())) {
            return (org.apache.commons.io.FilenameUtils.indexOfExtension(filename)) == (NOT_FOUND);
        } 
        final java.lang.String fileExt = org.apache.commons.io.FilenameUtils.getExtension(filename);
        for (final java.lang.String extension : extensions) {
            if (fileExt.equals(extension)) {
                return true;
            } 
        }
        return false;
    }

    public static boolean g(final java.lang.String filename, final java.lang.String wildcardMatcher) {
        return org.apache.commons.io.FilenameUtils.wildcardMatch(filename, wildcardMatcher, org.apache.commons.io.IOCase.SENSITIVE);
    }

    public static boolean h(final java.lang.String filename, final java.lang.String wildcardMatcher) {
        return org.apache.commons.io.FilenameUtils.wildcardMatch(filename, wildcardMatcher, org.apache.commons.io.IOCase.SYSTEM);
    }

    public static boolean a(final java.lang.String filename, final java.lang.String wildcardMatcher, org.apache.commons.io.IOCase caseSensitivity) {
        if ((filename == null) && (wildcardMatcher == null)) {
            return true;
        } 
        if ((filename == null) || (wildcardMatcher == null)) {
            return false;
        } 
        if (caseSensitivity == null) {
            caseSensitivity = org.apache.commons.io.IOCase.SENSITIVE;
        } 
        final java.lang.String[] wcs = org.apache.commons.io.FilenameUtils.splitOnTokens(wildcardMatcher);
        boolean anyChars = false;
        int textIdx = 0;
        int wcsIdx = 0;
        final java.util.Stack<int[]> backtrack = new java.util.Stack<int[]>();
        do {
            if ((backtrack.size()) > 0) {
                final int[] array = backtrack.pop();
                wcsIdx = array[0];
                textIdx = array[1];
                anyChars = true;
            } 
            while (wcsIdx < (wcs.length)) {
                if (wcs[wcsIdx].equals("?")) {
                    textIdx++;
                    if (textIdx > (filename.length())) {
                        break;
                    } 
                    anyChars = false;
                } else if (wcs[wcsIdx].equals("*")) {
                    anyChars = true;
                    if (wcsIdx == ((wcs.length) - 1)) {
                        textIdx = filename.length();
                    } 
                } else {
                    if (anyChars) {
                        textIdx = caseSensitivity.checkIndexOf(filename, textIdx, wcs[wcsIdx]);
                        if (textIdx == (NOT_FOUND)) {
                            break;
                        } 
                        final int repeat = caseSensitivity.checkIndexOf(filename, (textIdx + 1), wcs[wcsIdx]);
                        if (repeat >= 0) {
                            backtrack.push(new int[]{ wcsIdx , repeat });
                        } 
                    } else {
                        if (!(caseSensitivity.checkRegionMatches(filename, textIdx, wcs[wcsIdx]))) {
                            break;
                        } 
                    }
                    textIdx += wcs[wcsIdx].length();
                    anyChars = false;
                }
                wcsIdx++;
            }
            if ((wcsIdx == (wcs.length)) && (textIdx == (filename.length()))) {
                return true;
            } 
        } while ((backtrack.size()) > 0 );
        return false;
    }

    static java.lang.String[] r(final java.lang.String text) {
        if (((text.indexOf('?')) == (NOT_FOUND)) && ((text.indexOf('*')) == (NOT_FOUND))) {
            return new java.lang.String[]{ text };
        } 
        final char[] array = text.toCharArray();
        final java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
        final java.lang.StringBuilder buffer = new java.lang.StringBuilder();
        char prevChar = 0;
        for (final char ch : array) {
            if ((ch == '?') || (ch == '*')) {
                if ((buffer.length()) != 0) {
                    list.add(buffer.toString());
                    buffer.setLength(0);
                } 
                if (ch == '?') {
                    list.add("?");
                } else if (prevChar != '*') {
                    list.add("*");
                } 
            } else {
                buffer.append(ch);
            }
            prevChar = ch;
        }
        if ((buffer.length()) != 0) {
            list.add(buffer.toString());
        } 
        return list.toArray(new java.lang.String[list.size()]);
    }
}


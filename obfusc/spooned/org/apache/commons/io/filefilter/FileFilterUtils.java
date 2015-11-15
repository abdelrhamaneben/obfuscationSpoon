package org.apache.commons.io.filefilter;


public class FileFilterUtils {
    public FileFilterUtils() {
    }

    public static java.io.File[] a(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File... files) {
        if (filter == null) {
            throw new java.lang.IllegalArgumentException("file filter is null");
        } 
        if (files == null) {
            return new java.io.File[0];
        } 
        final java.util.List<java.io.File> acceptedFiles = new java.util.ArrayList<java.io.File>();
        for (final java.io.File file : files) {
            if (file == null) {
                throw new java.lang.IllegalArgumentException("file array contains null");
            } 
            if (filter.accept(file)) {
                acceptedFiles.add(file);
            } 
        }
        return acceptedFiles.toArray(new java.io.File[acceptedFiles.size()]);
    }

    public static java.io.File[] a(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.lang.Iterable<java.io.File> files) {
        final java.util.List<java.io.File> acceptedFiles = org.apache.commons.io.filefilter.FileFilterUtils.filterList(filter, files);
        return acceptedFiles.toArray(new java.io.File[acceptedFiles.size()]);
    }

    public static java.util.List<java.io.File> b(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.lang.Iterable<java.io.File> files) {
        return org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, files, new java.util.ArrayList<java.io.File>());
    }

    public static java.util.List<java.io.File> b(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File... files) {
        final java.io.File[] acceptedFiles = org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, files);
        return java.util.Arrays.asList(acceptedFiles);
    }

    public static java.util.Set<java.io.File> c(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File... files) {
        final java.io.File[] acceptedFiles = org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, files);
        return new java.util.HashSet<java.io.File>(java.util.Arrays.asList(acceptedFiles));
    }

    public static java.util.Set<java.io.File> c(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.lang.Iterable<java.io.File> files) {
        return org.apache.commons.io.filefilter.FileFilterUtils.filter(filter, files, new java.util.HashSet<java.io.File>());
    }

    private static <T extends java.util.Collection<java.io.File>>T a(final org.apache.commons.io.filefilter.IOFileFilter filter, final java.lang.Iterable<java.io.File> files, final T acceptedFiles) {
        if (filter == null) {
            throw new java.lang.IllegalArgumentException("file filter is null");
        } 
        if (files != null) {
            for (final java.io.File file : files) {
                if (file == null) {
                    throw new java.lang.IllegalArgumentException("file collection contains null");
                } 
                if (filter.accept(file)) {
                    acceptedFiles.add(file);
                } 
            }
        } 
        return acceptedFiles;
    }

    public static org.apache.commons.io.filefilter.IOFileFilter c(final java.lang.String prefix) {
        return new org.apache.commons.io.filefilter.PrefixFileFilter(prefix);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b(final java.lang.String prefix, final org.apache.commons.io.IOCase caseSensitivity) {
        return new org.apache.commons.io.filefilter.PrefixFileFilter(prefix , caseSensitivity);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter d(final java.lang.String suffix) {
        return new org.apache.commons.io.filefilter.SuffixFileFilter(suffix);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter c(final java.lang.String suffix, final org.apache.commons.io.IOCase caseSensitivity) {
        return new org.apache.commons.io.filefilter.SuffixFileFilter(suffix , caseSensitivity);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b(final java.lang.String name) {
        return new org.apache.commons.io.filefilter.NameFileFilter(name);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.lang.String name, final org.apache.commons.io.IOCase caseSensitivity) {
        return new org.apache.commons.io.filefilter.NameFileFilter(name , caseSensitivity);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a() {
        return org.apache.commons.io.filefilter.DirectoryFileFilter.DIRECTORY;
    }

    public static org.apache.commons.io.filefilter.IOFileFilter c() {
        return org.apache.commons.io.filefilter.FileFileFilter.FILE;
    }

    @java.lang.Deprecated
    public static org.apache.commons.io.filefilter.IOFileFilter a(final org.apache.commons.io.filefilter.IOFileFilter filter1, final org.apache.commons.io.filefilter.IOFileFilter filter2) {
        return new org.apache.commons.io.filefilter.AndFileFilter(filter1 , filter2);
    }

    @java.lang.Deprecated
    public static org.apache.commons.io.filefilter.IOFileFilter b(final org.apache.commons.io.filefilter.IOFileFilter filter1, final org.apache.commons.io.filefilter.IOFileFilter filter2) {
        return new org.apache.commons.io.filefilter.OrFileFilter(filter1 , filter2);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b(final org.apache.commons.io.filefilter.IOFileFilter... filters) {
        return new org.apache.commons.io.filefilter.AndFileFilter(org.apache.commons.io.filefilter.FileFilterUtils.toList(filters));
    }

    public static org.apache.commons.io.filefilter.IOFileFilter c(final org.apache.commons.io.filefilter.IOFileFilter... filters) {
        return new org.apache.commons.io.filefilter.OrFileFilter(org.apache.commons.io.filefilter.FileFilterUtils.toList(filters));
    }

    public static java.util.List<org.apache.commons.io.filefilter.IOFileFilter> a(final org.apache.commons.io.filefilter.IOFileFilter... filters) {
        if (filters == null) {
            throw new java.lang.IllegalArgumentException("The filters must not be null");
        } 
        final java.util.List<org.apache.commons.io.filefilter.IOFileFilter> list = new java.util.ArrayList<org.apache.commons.io.filefilter.IOFileFilter>(filters.length);
        for (int i = 0 ; i < (filters.length) ; i++) {
            if ((filters[i]) == null) {
                throw new java.lang.IllegalArgumentException((("The filter[" + i) + "] is null"));
            } 
            list.add(filters[i]);
        }
        return list;
    }

    public static org.apache.commons.io.filefilter.IOFileFilter e(final org.apache.commons.io.filefilter.IOFileFilter filter) {
        return new org.apache.commons.io.filefilter.NotFileFilter(filter);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter d() {
        return org.apache.commons.io.filefilter.TrueFileFilter.TRUE;
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b() {
        return org.apache.commons.io.filefilter.FalseFileFilter.FALSE;
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.io.FileFilter filter) {
        return new org.apache.commons.io.filefilter.DelegateFileFilter(filter);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.io.FilenameFilter filter) {
        return new org.apache.commons.io.filefilter.DelegateFileFilter(filter);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final long cutoff) {
        return new org.apache.commons.io.filefilter.AgeFileFilter(cutoff);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final long cutoff, final boolean acceptOlder) {
        return new org.apache.commons.io.filefilter.AgeFileFilter(cutoff , acceptOlder);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.util.Date cutoffDate) {
        return new org.apache.commons.io.filefilter.AgeFileFilter(cutoffDate);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.util.Date cutoffDate, final boolean acceptOlder) {
        return new org.apache.commons.io.filefilter.AgeFileFilter(cutoffDate , acceptOlder);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.io.File cutoffReference) {
        return new org.apache.commons.io.filefilter.AgeFileFilter(cutoffReference);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.io.File cutoffReference, final boolean acceptOlder) {
        return new org.apache.commons.io.filefilter.AgeFileFilter(cutoffReference , acceptOlder);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b(final long threshold) {
        return new org.apache.commons.io.filefilter.SizeFileFilter(threshold);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b(final long threshold, final boolean acceptLarger) {
        return new org.apache.commons.io.filefilter.SizeFileFilter(threshold , acceptLarger);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final long minSizeInclusive, final long maxSizeInclusive) {
        final org.apache.commons.io.filefilter.IOFileFilter minimumFilter = new org.apache.commons.io.filefilter.SizeFileFilter(minSizeInclusive , true);
        final org.apache.commons.io.filefilter.IOFileFilter maximumFilter = new org.apache.commons.io.filefilter.SizeFileFilter((maxSizeInclusive + 1L) , false);
        return new org.apache.commons.io.filefilter.AndFileFilter(minimumFilter , maximumFilter);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.lang.String magicNumber) {
        return new org.apache.commons.io.filefilter.MagicNumberFileFilter(magicNumber);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final java.lang.String magicNumber, final long offset) {
        return new org.apache.commons.io.filefilter.MagicNumberFileFilter(magicNumber , offset);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final byte[] magicNumber) {
        return new org.apache.commons.io.filefilter.MagicNumberFileFilter(magicNumber);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter a(final byte[] magicNumber, final long offset) {
        return new org.apache.commons.io.filefilter.MagicNumberFileFilter(magicNumber , offset);
    }

    private static final org.apache.commons.io.filefilter.IOFileFilter cvsFilter = org.apache.commons.io.filefilter.FileFilterUtils.notFileFilter(org.apache.commons.io.filefilter.FileFilterUtils.and(org.apache.commons.io.filefilter.FileFilterUtils.directoryFileFilter(), org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter("CVS")));

    private static final org.apache.commons.io.filefilter.IOFileFilter svnFilter = org.apache.commons.io.filefilter.FileFilterUtils.notFileFilter(org.apache.commons.io.filefilter.FileFilterUtils.and(org.apache.commons.io.filefilter.FileFilterUtils.directoryFileFilter(), org.apache.commons.io.filefilter.FileFilterUtils.nameFileFilter(".svn")));

    public static org.apache.commons.io.filefilter.IOFileFilter a(final org.apache.commons.io.filefilter.IOFileFilter filter) {
        if (filter == null) {
            return cvsFilter;
        } else {
            return org.apache.commons.io.filefilter.FileFilterUtils.and(filter, cvsFilter);
        }
    }

    public static org.apache.commons.io.filefilter.IOFileFilter d(final org.apache.commons.io.filefilter.IOFileFilter filter) {
        if (filter == null) {
            return svnFilter;
        } else {
            return org.apache.commons.io.filefilter.FileFilterUtils.and(filter, svnFilter);
        }
    }

    public static org.apache.commons.io.filefilter.IOFileFilter b(final org.apache.commons.io.filefilter.IOFileFilter filter) {
        if (filter == null) {
            return org.apache.commons.io.filefilter.DirectoryFileFilter.DIRECTORY;
        } 
        return new org.apache.commons.io.filefilter.AndFileFilter(org.apache.commons.io.filefilter.DirectoryFileFilter.DIRECTORY , filter);
    }

    public static org.apache.commons.io.filefilter.IOFileFilter c(final org.apache.commons.io.filefilter.IOFileFilter filter) {
        if (filter == null) {
            return org.apache.commons.io.filefilter.FileFileFilter.FILE;
        } 
        return new org.apache.commons.io.filefilter.AndFileFilter(org.apache.commons.io.filefilter.FileFileFilter.FILE , filter);
    }
}


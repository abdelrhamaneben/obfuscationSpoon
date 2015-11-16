package org.apache.commons.io.filefilter;


public abstract class IOFileFilterAbstractTestCase extends junit.framework.TestCase {
    public IOFileFilterAbstractTestCase(final java.lang.String name) {
        super(name);
    }

    public static void getFilenameResults(final int testNumber, final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File file, final boolean expected) throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(((((((("test " + testNumber) + " Filter(File) ") + (filter.getClass().getName())) + " not ") + expected) + " for ") + file), expected, filter.accept(file));
    }

    public static void a(final int testNumber, final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File file, final boolean expected) throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(((((((("test " + testNumber) + " Filter(File, String) ") + (filter.getClass().getName())) + " not ") + expected) + " for ") + file), expected, filter.accept(file.getParentFile(), file.getName()));
    }

    public static void assertFilenameFiltering(final int testNumber, final org.apache.commons.io.filefilter.IOFileFilter filter, final java.io.File file, final boolean expected) throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(((((((("test " + testNumber) + " Filter(File) ") + (filter.getClass().getName())) + " not ") + expected) + " for ") + file), expected, filter.accept(file));
        if ((file != null) && ((file.getParentFile()) != null)) {
            junit.framework.TestCase.assertEquals(((((((("test " + testNumber) + " Filter(File, String) ") + (filter.getClass().getName())) + " not ") + expected) + " for ") + file), expected, filter.accept(file.getParentFile(), file.getName()));
        } else if (file == null) {
            junit.framework.TestCase.assertEquals((((((("test " + testNumber) + " Filter(File, String) ") + (filter.getClass().getName())) + " not ") + expected) + " for null"), expected, filter.accept(file));
        } 
    }

    public static void getFilenameResults(final int testNumber, final TesterTrueFileFilter[] filters, final boolean[] invoked) {
        for (int i = 1 ; i < (filters.length) ; i++) {
            junit.framework.TestCase.assertEquals((((("test " + testNumber) + " filter ") + i) + " invoked"), invoked[(i - 1)], filters[i].isInvoked());
        }
    }

    public static void getFilenameResults(final int testNumber, final TesterFalseFileFilter[] filters, final boolean[] invoked) {
        for (int i = 1 ; i < (filters.length) ; i++) {
            junit.framework.TestCase.assertEquals((((("test " + testNumber) + " filter ") + i) + " invoked"), invoked[(i - 1)], filters[i].isInvoked());
        }
    }

    public static java.io.File getFilenameResults(final java.lang.String key, final java.lang.String defaultPath) {
        final java.lang.String workingPathName = java.lang.System.getProperty(key, defaultPath);
        return new java.io.File(workingPathName);
    }

    public static void getFilenameResults(final TesterFalseFileFilter[] filters) {
        for (final TesterFalseFileFilter filter : filters) {
            if (filter != null) {
                filter.reset();
            } 
        }
    }

    public static void getFilenameResults(final TesterTrueFileFilter[] filters) {
        for (final TesterTrueFileFilter filter : filters) {
            if (filter != null) {
                filter.reset();
            } 
        }
    }

    class TesterTrueFileFilter extends org.apache.commons.io.filefilter.TrueFileFilter {
        private static final long serialVersionUID = 1828930358172422914L;

        private boolean invoked;

        @java.lang.Override
        public boolean a(final java.io.File file) {
            setInvoked(true);
            return super.accept(file);
        }

        @java.lang.Override
        public boolean a(final java.io.File file, final java.lang.String str) {
            setInvoked(true);
            return super.accept(file, str);
        }

        public boolean a() {
            return this.invoked;
        }

        public void a(final boolean invoked) {
            this.invoked = invoked;
        }

        public void a() {
            setInvoked(false);
        }
    }

    class TesterFalseFileFilter extends org.apache.commons.io.filefilter.FalseFileFilter {
        private static final long serialVersionUID = -3603047664010401872L;

        private boolean invoked;

        @java.lang.Override
        public boolean isInvoked(final java.io.File file) {
            setInvoked(true);
            return super.accept(file);
        }

        @java.lang.Override
        public boolean isInvoked(final java.io.File file, final java.lang.String str) {
            setInvoked(true);
            return super.accept(file, str);
        }

        public boolean isInvoked() {
            return this.invoked;
        }

        public void isInvoked(final boolean invoked) {
            this.invoked = invoked;
        }

        public void accept() {
            setInvoked(false);
        }
    }
}


package org.apache.commons.io;


public class LineIteratorTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    public LineIteratorTestCase(final java.lang.String name) {
        super(name);
    }

    private void a(final java.util.List<java.lang.String> lines, final org.apache.commons.io.LineIterator iterator) {
        try {
            for (int i = 0 ; i < (lines.size()) ; i++) {
                final java.lang.String line = iterator.nextLine();
                junit.framework.TestCase.assertEquals(("nextLine() line " + i), lines.get(i), line);
            }
            junit.framework.TestCase.assertFalse("No more expected", iterator.hasNext());
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    private java.util.List<java.lang.String> a(final java.io.File file, final int lineCount) throws java.io.IOException {
        final java.util.List<java.lang.String> lines = createStringLines(lineCount);
        org.apache.commons.io.FileUtils.writeLines(file, lines);
        return lines;
    }

    private java.util.List<java.lang.String> a(final java.io.File file, final java.lang.String encoding, final int lineCount) throws java.io.IOException {
        final java.util.List<java.lang.String> lines = createStringLines(lineCount);
        org.apache.commons.io.FileUtils.writeLines(file, encoding, lines);
        return lines;
    }

    private java.util.List<java.lang.String> a(final int lineCount) {
        final java.util.List<java.lang.String> lines = new java.util.ArrayList<java.lang.String>();
        for (int i = 0 ; i < lineCount ; i++) {
            lines.add(("LINE " + i));
        }
        return lines;
    }

    @java.lang.Override
    @org.junit.Before
    protected void setUp() throws java.lang.Exception {
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        if (dir.exists()) {
            org.apache.commons.io.FileUtils.deleteDirectory(dir);
        } 
        dir.mkdirs();
    }

    @java.lang.Override
    @org.junit.After
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
    }

    @org.junit.Test
    public void b() throws java.lang.Exception {
        try {
            new org.apache.commons.io.LineIterator(null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    @org.junit.Test
    public void p() throws java.lang.Exception {
        doTestFileWithSpecifiedLines(0);
    }

    @org.junit.Test
    public void l() throws java.lang.Exception {
        doTestFileWithSpecifiedLines(1);
    }

    @org.junit.Test
    public void n() throws java.lang.Exception {
        doTestFileWithSpecifiedLines(2);
    }

    @org.junit.Test
    public void m() throws java.lang.Exception {
        doTestFileWithSpecifiedLines(3);
    }

    @org.junit.Test
    public void f() throws java.lang.Exception {
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "dummy-missing-file.txt");
        org.apache.commons.io.LineIterator iterator = null;
        try {
            iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, "UTF-8");
            junit.framework.TestCase.fail("Expected FileNotFoundException");
        } catch (final java.io.FileNotFoundException expected) {
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    @org.junit.Test
    public void o() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-validEncoding.txt");
        createLinesFile(testFile, encoding, 3);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
        try {
            int count = 0;
            while (iterator.hasNext()) {
                junit.framework.TestCase.assertNotNull(iterator.next());
                count++;
            }
            junit.framework.TestCase.assertEquals(3, count);
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    @org.junit.Test
    public void e() throws java.lang.Exception {
        final java.lang.String encoding = "XXXXXXXX";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-invalidEncoding.txt");
        createLinesFile(testFile, "UTF-8", 3);
        org.apache.commons.io.LineIterator iterator = null;
        try {
            iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
            junit.framework.TestCase.fail("Expected UnsupportedCharsetException");
        } catch (final java.nio.charset.UnsupportedCharsetException expected) {
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    @org.junit.Test
    public void g() throws java.lang.Exception {
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-nextOnly.txt");
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, 3);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile);
        assertLines(lines, iterator);
    }

    @org.junit.Test
    public void h() throws java.lang.Exception {
        final java.lang.String encoding = null;
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-nextOnly.txt");
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, encoding, 3);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
        assertLines(lines, iterator);
    }

    @org.junit.Test
    public void i() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-nextOnly.txt");
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, encoding, 3);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
        assertLines(lines, iterator);
    }

    @org.junit.Test
    public void j() throws java.lang.Exception {
        final java.lang.String encoding = null;
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-nextOnly.txt");
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, encoding, 3);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
        try {
            for (int i = 0 ; i < (lines.size()) ; i++) {
                final java.lang.String line = iterator.next();
                junit.framework.TestCase.assertEquals(("next() line " + i), lines.get(i), line);
            }
            junit.framework.TestCase.assertEquals("No more expected", false, iterator.hasNext());
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    @org.junit.Test
    public void k() throws java.lang.Exception {
        final java.io.Reader reader = new java.io.BufferedReader(new java.io.StringReader("")) {
            @java.lang.Override
            public java.lang.String readLine() throws java.io.IOException {
                throw new java.io.IOException("hasNext");
            }
        };
        try {
            new org.apache.commons.io.LineIterator(reader).hasNext();
            junit.framework.TestCase.fail("Expected IllegalStateException");
        } catch (final java.lang.IllegalStateException e) {
        }
    }

    @org.junit.Test
    public void a() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "LineIterator-closeEarly.txt");
        createLinesFile(testFile, encoding, 3);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
        try {
            junit.framework.TestCase.assertNotNull("Line expected", iterator.next());
            junit.framework.TestCase.assertTrue("More expected", iterator.hasNext());
            iterator.close();
            junit.framework.TestCase.assertFalse("No more expected", iterator.hasNext());
            try {
                iterator.next();
                junit.framework.TestCase.fail();
            } catch (final java.util.NoSuchElementException ex) {
            }
            try {
                iterator.nextLine();
                junit.framework.TestCase.fail();
            } catch (final java.util.NoSuchElementException ex) {
            }
            iterator.close();
            try {
                iterator.next();
                junit.framework.TestCase.fail();
            } catch (final java.util.NoSuchElementException ex) {
            }
            try {
                iterator.nextLine();
                junit.framework.TestCase.fail();
            } catch (final java.util.NoSuchElementException ex) {
            }
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    private void b(final int lineCount) throws java.io.IOException {
        final java.lang.String encoding = "UTF-8";
        final java.lang.String fileName = ("LineIterator-" + lineCount) + "-test.txt";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , fileName);
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, encoding, lineCount);
        final org.apache.commons.io.LineIterator iterator = org.apache.commons.io.FileUtils.lineIterator(testFile, encoding);
        try {
            try {
                iterator.remove();
                junit.framework.TestCase.fail("Remove is unsupported");
            } catch (final java.lang.UnsupportedOperationException ex) {
            }
            int idx = 0;
            while (iterator.hasNext()) {
                final java.lang.String line = iterator.next();
                junit.framework.TestCase.assertEquals(("Comparing line " + idx), lines.get(idx), line);
                junit.framework.TestCase.assertTrue(((("Exceeded expected idx=" + idx) + " size=") + (lines.size())), (idx < (lines.size())));
                idx++;
            }
            junit.framework.TestCase.assertEquals("Line Count doesn\'t match", idx, lines.size());
            try {
                iterator.next();
                junit.framework.TestCase.fail("Expected NoSuchElementException");
            } catch (final java.util.NoSuchElementException expected) {
            }
            try {
                iterator.nextLine();
                junit.framework.TestCase.fail("Expected NoSuchElementException");
            } catch (final java.util.NoSuchElementException expected) {
            }
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }

    @org.junit.Test
    public void d() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.lang.String fileName = "LineIterator-Filter-test.txt";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , fileName);
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, encoding, 9);
        final java.io.Reader reader = new java.io.FileReader(testFile);
        testFiltering(lines, reader);
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.lang.String fileName = "LineIterator-Filter-test.txt";
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , fileName);
        final java.util.List<java.lang.String> lines = createLinesFile(testFile, encoding, 9);
        final java.io.Reader reader = new java.io.BufferedReader(new java.io.FileReader(testFile));
        testFiltering(lines, reader);
    }

    private void a(final java.util.List<java.lang.String> lines, final java.io.Reader reader) {
        final org.apache.commons.io.LineIterator iterator = new org.apache.commons.io.LineIterator(reader) {
            @java.lang.Override
            protected boolean isValidLine(final java.lang.String line) {
                final char c = line.charAt(((line.length()) - 1));
                return ((c - 48) % 3) != 1;
            }
        };
        try {
            try {
                iterator.remove();
                junit.framework.TestCase.fail("Remove is unsupported");
            } catch (final java.lang.UnsupportedOperationException ex) {
            }
            int idx = 0;
            int actualLines = 0;
            while (iterator.hasNext()) {
                final java.lang.String line = iterator.next();
                actualLines++;
                junit.framework.TestCase.assertEquals(("Comparing line " + idx), lines.get(idx), line);
                junit.framework.TestCase.assertTrue(((("Exceeded expected idx=" + idx) + " size=") + (lines.size())), (idx < (lines.size())));
                idx++;
                if ((idx % 3) == 1) {
                    idx++;
                } 
            }
            junit.framework.TestCase.assertEquals("Line Count doesn\'t match", 9, lines.size());
            junit.framework.TestCase.assertEquals("Line Count doesn\'t match", 9, idx);
            junit.framework.TestCase.assertEquals("Line Count doesn\'t match", 6, actualLines);
            try {
                iterator.next();
                junit.framework.TestCase.fail("Expected NoSuchElementException");
            } catch (final java.util.NoSuchElementException expected) {
            }
            try {
                iterator.nextLine();
                junit.framework.TestCase.fail("Expected NoSuchElementException");
            } catch (final java.util.NoSuchElementException expected) {
            }
        } finally {
            org.apache.commons.io.LineIterator.closeQuietly(iterator);
        }
    }
}


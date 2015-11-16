package org.apache.commons.io.input;


public class TailerTest extends org.apache.commons.io.testtools.FileBasedTestCase {
    private org.apache.commons.io.input.Tailer tailer;

    public TailerTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        if ((tailer) != null) {
            tailer.stop();
            java.lang.Thread.sleep(1000);
        } 
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
        java.lang.Thread.sleep(1000);
    }

    public void d() throws java.lang.Exception {
        final long delay = 50;
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testLongFile.txt");
        createFile(file, 0);
        final java.io.Writer writer = new java.io.FileWriter(file , true);
        for (int i = 0 ; i < 100000 ; i++) {
            writer.write("LineLineLineLineLineLineLineLineLineLine\n");
        }
        writer.write("SBTOURIST\n");
        org.apache.commons.io.IOUtils.closeQuietly(writer);
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        tailer = new org.apache.commons.io.input.Tailer(file , listener , delay , false);
        final long start = java.lang.System.currentTimeMillis();
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        java.util.List<java.lang.String> lines = listener.getLines();
        while ((lines.isEmpty()) || (!(lines.get(((lines.size()) - 1)).equals("SBTOURIST")))) {
            lines = listener.getLines();
        }
        java.lang.System.out.println(("Elapsed: " + ((java.lang.System.currentTimeMillis()) - start)));
        listener.clear();
    }

    public void a() throws java.lang.Exception {
        final long delay = 50;
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testBufferBreak.txt");
        createFile(file, 0);
        writeString(file, "SBTOURIST\n");
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        tailer = new org.apache.commons.io.input.Tailer(file , listener , delay , false , 1);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        java.util.List<java.lang.String> lines = listener.getLines();
        while ((lines.isEmpty()) || (!(lines.get(((lines.size()) - 1)).equals("SBTOURIST")))) {
            lines = listener.getLines();
        }
        listener.clear();
    }

    @java.lang.SuppressWarnings(value = "deprecation")
    public void e() throws java.lang.Exception {
        java.lang.System.out.println(("testMultiByteBreak() Default charset: " + (java.nio.charset.Charset.defaultCharset().displayName())));
        final long delay = 50;
        final java.io.File origin = new java.io.File(getClass().getResource("/test-file-utf8.bin").toURI());
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMultiByteBreak.txt");
        createFile(file, 0);
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final java.lang.String osname = java.lang.System.getProperty("os.name");
        final boolean isWindows = osname.startsWith("Windows");
        final java.nio.charset.Charset charsetUTF8 = org.apache.commons.io.Charsets.UTF_8;
        tailer = new org.apache.commons.io.input.Tailer(file , charsetUTF8 , listener , delay , false , isWindows , 4096);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        java.io.Writer out = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file) , charsetUTF8);
        java.io.BufferedReader reader = null;
        try {
            java.util.List<java.lang.String> lines = new java.util.ArrayList<java.lang.String>();
            reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(origin) , charsetUTF8));
            java.lang.String line = null;
            while ((line = reader.readLine()) != null) {
                out.write(line);
                out.write("\n");
                lines.add(line);
            }
            out.close();
            final long testDelayMillis = delay * 10;
            java.lang.Thread.sleep(testDelayMillis);
            java.util.List<java.lang.String> tailerlines = listener.getLines();
            junit.framework.TestCase.assertEquals("line count", lines.size(), tailerlines.size());
            for (int i = 0, len = lines.size() ; i < len ; i++) {
                final java.lang.String expected = lines.get(i);
                final java.lang.String actual = tailerlines.get(i);
                if (!(expected.equals(actual))) {
                    junit.framework.TestCase.fail(((((((((("Line: " + i) + "\nExp: (") + (expected.length())) + ") ") + expected) + "\nAct: (") + (actual.length())) + ") ") + actual));
                } 
            }
        } finally {
            tailer.stop();
            org.apache.commons.io.IOUtils.closeQuietly(reader);
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
    }

    public void j() throws java.lang.Exception {
        final long delay = 50;
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "tailer2-test.txt");
        createFile(file, 0);
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final org.apache.commons.io.input.Tailer tailer = new org.apache.commons.io.input.Tailer(file , listener , delay , false);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        final java.io.FileWriter writer = null;
        try {
            writeString(file, "Line");
            java.lang.Thread.sleep((delay * 2));
            java.util.List<java.lang.String> lines = listener.getLines();
            junit.framework.TestCase.assertEquals("1 line count", 0, lines.size());
            writeString(file, " one\n");
            java.lang.Thread.sleep((delay * 2));
            lines = listener.getLines();
            junit.framework.TestCase.assertEquals("1 line count", 1, lines.size());
            junit.framework.TestCase.assertEquals("1 line 1", "Line one", lines.get(0));
            listener.clear();
        } finally {
            tailer.stop();
            java.lang.Thread.sleep((delay * 2));
            org.apache.commons.io.IOUtils.closeQuietly(writer);
        }
    }

    public void h() throws java.lang.Exception {
        final long delayMillis = 50;
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "tailer1-test.txt");
        createFile(file, 0);
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final java.lang.String osname = java.lang.System.getProperty("os.name");
        final boolean isWindows = osname.startsWith("Windows");
        tailer = new org.apache.commons.io.input.Tailer(file , listener , delayMillis , false , isWindows);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        write(file, "Line one", "Line two");
        final long testDelayMillis = delayMillis * 10;
        java.lang.Thread.sleep(testDelayMillis);
        java.util.List<java.lang.String> lines = listener.getLines();
        junit.framework.TestCase.assertEquals("1 line count", 2, lines.size());
        junit.framework.TestCase.assertEquals("1 line 1", "Line one", lines.get(0));
        junit.framework.TestCase.assertEquals("1 line 2", "Line two", lines.get(1));
        listener.clear();
        write(file, "Line three");
        java.lang.Thread.sleep(testDelayMillis);
        lines = listener.getLines();
        junit.framework.TestCase.assertEquals("2 line count", 1, lines.size());
        junit.framework.TestCase.assertEquals("2 line 3", "Line three", lines.get(0));
        listener.clear();
        lines = org.apache.commons.io.FileUtils.readLines(file, "UTF-8");
        junit.framework.TestCase.assertEquals("3 line count", 3, lines.size());
        junit.framework.TestCase.assertEquals("3 line 1", "Line one", lines.get(0));
        junit.framework.TestCase.assertEquals("3 line 2", "Line two", lines.get(1));
        junit.framework.TestCase.assertEquals("3 line 3", "Line three", lines.get(2));
        file.delete();
        final boolean exists = file.exists();
        junit.framework.TestCase.assertFalse("File should not exist", exists);
        createFile(file, 0);
        java.lang.Thread.sleep(testDelayMillis);
        write(file, "Line four");
        java.lang.Thread.sleep(testDelayMillis);
        lines = listener.getLines();
        junit.framework.TestCase.assertEquals("4 line count", 1, lines.size());
        junit.framework.TestCase.assertEquals("4 line 3", "Line four", lines.get(0));
        listener.clear();
        tailer.stop();
        tailer = null;
        thread.interrupt();
        java.lang.Thread.sleep((testDelayMillis * 4));
        write(file, "Line five");
        junit.framework.TestCase.assertEquals("4 line count", 0, listener.getLines().size());
        junit.framework.TestCase.assertNotNull("Missing InterruptedException", listener.exception);
        junit.framework.TestCase.assertTrue(("Unexpected Exception: " + (listener.exception)), ((listener.exception) instanceof java.lang.InterruptedException));
        junit.framework.TestCase.assertEquals("Expected init to be called", 1, listener.initialised);
        junit.framework.TestCase.assertEquals("fileNotFound should not be called", 0, listener.notFound);
        junit.framework.TestCase.assertEquals("fileRotated should be be called", 1, listener.rotated);
    }

    public void i() throws java.lang.Exception {
        final long delayMillis = 50;
        final long testDelayMillis = delayMillis * 10;
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "tailer1-test.txt");
        createFile(file, 0);
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final java.lang.String osname = java.lang.System.getProperty("os.name");
        final boolean isWindows = osname.startsWith("Windows");
        tailer = new org.apache.commons.io.input.Tailer(file , listener , delayMillis , false , isWindows);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        write(file, "line1", "line2", "line3");
        java.lang.Thread.sleep(testDelayMillis);
        write(file, "line4", "line5", "line6");
        java.lang.Thread.sleep(testDelayMillis);
        write(file, "line7", "line8", "line9");
        java.lang.Thread.sleep(testDelayMillis);
        junit.framework.TestCase.assertEquals("end of file reached 3 times", 3, listener.reachedEndOfFile);
    }

    @java.lang.Override
    protected void a(final java.io.File file, final long size) throws java.io.IOException {
        super.createFile(file, size);
        java.io.RandomAccessFile reader = null;
        try {
            while (reader == null) {
                try {
                    reader = new java.io.RandomAccessFile(file.getPath() , "r");
                } catch (final java.io.FileNotFoundException e) {
                }
                try {
                    java.lang.Thread.sleep(200L);
                } catch (final java.lang.InterruptedException e) {
                }
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(reader);
        }
    }

    private void a(final java.io.File file, final java.lang.String... lines) throws java.lang.Exception {
        java.io.FileWriter writer = null;
        try {
            writer = new java.io.FileWriter(file , true);
            for (final java.lang.String line : lines) {
                writer.write((line + "\n"));
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(writer);
        }
    }

    private void b(final java.io.File file, final java.lang.String... strings) throws java.lang.Exception {
        java.io.FileWriter writer = null;
        try {
            writer = new java.io.FileWriter(file , true);
            for (final java.lang.String string : strings) {
                writer.write(string);
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(writer);
        }
    }

    public void f() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "nosuchfile");
        junit.framework.TestCase.assertFalse("nosuchfile should not exist", file.exists());
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final int delay = 100;
        final int idle = 50;
        tailer = org.apache.commons.io.input.Tailer.create(file, listener, delay, false);
        java.lang.Thread.sleep(idle);
        tailer.stop();
        tailer = null;
        java.lang.Thread.sleep((delay + idle));
        junit.framework.TestCase.assertNull("Should not generate Exception", listener.exception);
        junit.framework.TestCase.assertEquals("Expected init to be called", 1, listener.initialised);
        junit.framework.TestCase.assertTrue("fileNotFound should be called", ((listener.notFound) > 0));
        junit.framework.TestCase.assertEquals("fileRotated should be not be called", 0, listener.rotated);
        junit.framework.TestCase.assertEquals("end of file never reached", 0, listener.reachedEndOfFile);
    }

    public void c() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "nosuchfile");
        junit.framework.TestCase.assertFalse("nosuchfile should not exist", file.exists());
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final int delay = 1000;
        final int idle = 50;
        org.apache.commons.io.input.Tailer tailer = new org.apache.commons.io.input.Tailer(file , listener , delay , false , 4096);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        java.lang.Thread.sleep(idle);
        thread.interrupt();
        tailer = null;
        java.lang.Thread.sleep((delay + idle));
        junit.framework.TestCase.assertNotNull("Missing InterruptedException", listener.exception);
        junit.framework.TestCase.assertTrue(("Unexpected Exception: " + (listener.exception)), ((listener.exception) instanceof java.lang.InterruptedException));
        junit.framework.TestCase.assertEquals("Expected init to be called", 1, listener.initialised);
        junit.framework.TestCase.assertTrue("fileNotFound should be called", ((listener.notFound) > 0));
        junit.framework.TestCase.assertEquals("fileRotated should be not be called", 0, listener.rotated);
        junit.framework.TestCase.assertEquals("end of file never reached", 0, listener.reachedEndOfFile);
    }

    public void g() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "nosuchfile");
        junit.framework.TestCase.assertFalse("nosuchfile should not exist", file.exists());
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        final int delay = 100;
        final int idle = 50;
        tailer = new org.apache.commons.io.input.Tailer(file , listener , delay , false);
        final java.util.concurrent.Executor exec = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
        exec.execute(tailer);
        java.lang.Thread.sleep(idle);
        tailer.stop();
        tailer = null;
        java.lang.Thread.sleep((delay + idle));
        junit.framework.TestCase.assertNull("Should not generate Exception", listener.exception);
        junit.framework.TestCase.assertEquals("Expected init to be called", 1, listener.initialised);
        junit.framework.TestCase.assertTrue("fileNotFound should be called", ((listener.notFound) > 0));
        junit.framework.TestCase.assertEquals("fileRotated should be not be called", 0, listener.rotated);
        junit.framework.TestCase.assertEquals("end of file never reached", 0, listener.reachedEndOfFile);
    }

    public void b() throws java.lang.Exception {
        final long delayMillis = 50;
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "tailer-testio334.txt");
        createFile(file, 0);
        final org.apache.commons.io.input.TailerTest.TestTailerListener listener = new org.apache.commons.io.input.TailerTest.TestTailerListener();
        tailer = new org.apache.commons.io.input.Tailer(file , listener , delayMillis , false);
        final java.lang.Thread thread = new java.lang.Thread(tailer);
        thread.start();
        writeString(file, "CRLF\r\n", "LF\n", "CR\r", "CRCR\r\r", "trail");
        final long testDelayMillis = delayMillis * 10;
        java.lang.Thread.sleep(testDelayMillis);
        final java.util.List<java.lang.String> lines = listener.getLines();
        junit.framework.TestCase.assertEquals("line count", 4, lines.size());
        junit.framework.TestCase.assertEquals("line 1", "CRLF", lines.get(0));
        junit.framework.TestCase.assertEquals("line 2", "LF", lines.get(1));
        junit.framework.TestCase.assertEquals("line 3", "CR", lines.get(2));
        junit.framework.TestCase.assertEquals("line 4", "CRCR\r", lines.get(3));
        tailer.stop();
        tailer = null;
        thread.interrupt();
        java.lang.Thread.sleep(testDelayMillis);
    }

    private static class TestTailerListener extends org.apache.commons.io.input.TailerListenerAdapter {
        private final java.util.List<java.lang.String> lines = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.String>());

        volatile java.lang.Exception exception = null;

        volatile int notFound = 0;

        volatile int rotated = 0;

        volatile int initialised = 0;

        volatile int reachedEndOfFile = 0;

        public void b(final java.lang.String line) {
            lines.add(line);
        }

        public java.util.List<java.lang.String> d() {
            return lines;
        }

        public void e() {
            lines.clear();
        }

        public void b(final java.lang.Exception e) {
            exception = e;
        }

        public void b(final org.apache.commons.io.input.Tailer tailer) {
            (initialised)++;
        }

        public void g() {
            (notFound)++;
        }

        public void h() {
            (rotated)++;
        }

        public void f() {
            (reachedEndOfFile)++;
        }
    }
}


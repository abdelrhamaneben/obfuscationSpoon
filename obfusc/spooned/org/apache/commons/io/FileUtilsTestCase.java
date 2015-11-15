package org.apache.commons.io;


@java.lang.SuppressWarnings(value = "deprecation")
public class FileUtilsTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final int TEST_DIRECTORY_SIZE = 0;

    private static final java.math.BigInteger TEST_DIRECTORY_SIZE_BI = java.math.BigInteger.ZERO;

    private static final java.math.BigInteger TEST_DIRECTORY_SIZE_GT_ZERO_BI = java.math.BigInteger.valueOf(100);

    private static final org.apache.commons.io.FileUtilsTestCase.ListDirectoryWalker LIST_WALKER = new org.apache.commons.io.FileUtilsTestCase.ListDirectoryWalker();

    private final java.io.File testFile1;

    private final java.io.File testFile2;

    private final int testFile1Size;

    private final int testFile2Size;

    public FileUtilsTestCase(final java.lang.String name) {
        super(name);
        testFile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file1-test.txt");
        testFile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file1a-test.txt");
        testFile1Size = ((int)(testFile1.length()));
        testFile2Size = ((int)(testFile2.length()));
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
        createFile(testFile1, testFile1Size);
        createFile(testFile2, testFile2Size);
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
        org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().mkdirs();
        createFile(testFile1, testFile1Size);
        createFile(testFile2, testFile2Size);
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.deleteDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
    }

    public void au() {
        final java.io.File expected_A = new java.io.File("src");
        final java.io.File expected_B = new java.io.File(expected_A , "main");
        final java.io.File expected_C = new java.io.File(expected_B , "java");
        junit.framework.TestCase.assertEquals("A", expected_A, org.apache.commons.io.FileUtils.getFile("src"));
        junit.framework.TestCase.assertEquals("B", expected_B, org.apache.commons.io.FileUtils.getFile("src", "main"));
        junit.framework.TestCase.assertEquals("C", expected_C, org.apache.commons.io.FileUtils.getFile("src", "main", "java"));
        try {
            org.apache.commons.io.FileUtils.getFile(((java.lang.String[])(null)));
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (final java.lang.NullPointerException e) {
        }
    }

    public void av() {
        final java.io.File parent = new java.io.File("parent");
        final java.io.File expected_A = new java.io.File(parent , "src");
        final java.io.File expected_B = new java.io.File(expected_A , "main");
        final java.io.File expected_C = new java.io.File(expected_B , "java");
        junit.framework.TestCase.assertEquals("A", expected_A, org.apache.commons.io.FileUtils.getFile(parent, "src"));
        junit.framework.TestCase.assertEquals("B", expected_B, org.apache.commons.io.FileUtils.getFile(parent, "src", "main"));
        junit.framework.TestCase.assertEquals("C", expected_C, org.apache.commons.io.FileUtils.getFile(parent, "src", "main", "java"));
        try {
            org.apache.commons.io.FileUtils.getFile(parent, ((java.lang.String[])(null)));
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.getFile(((java.io.File)(null)), "src");
            junit.framework.TestCase.fail("Expected NullPointerException");
        } catch (final java.lang.NullPointerException e) {
        }
    }

    public void ax() {
        junit.framework.TestCase.assertEquals(java.lang.System.getProperty("java.io.tmpdir"), org.apache.commons.io.FileUtils.getTempDirectoryPath());
    }

    public void aw() {
        final java.io.File tempDirectory = new java.io.File(java.lang.System.getProperty("java.io.tmpdir"));
        junit.framework.TestCase.assertEquals(tempDirectory, org.apache.commons.io.FileUtils.getTempDirectory());
    }

    public void az() {
        junit.framework.TestCase.assertEquals(java.lang.System.getProperty("user.home"), org.apache.commons.io.FileUtils.getUserDirectoryPath());
    }

    public void ay() {
        final java.io.File userDirectory = new java.io.File(java.lang.System.getProperty("user.home"));
        junit.framework.TestCase.assertEquals(userDirectory, org.apache.commons.io.FileUtils.getUserDirectory());
    }

    public void dx() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test.txt");
        createLineBasedFile(file, new java.lang.String[]{ "Hello" });
        java.io.FileInputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(file);
            junit.framework.TestCase.assertEquals('H', in.read());
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    public void dy() throws java.lang.Exception {
        final java.io.File directory = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "subdir");
        directory.mkdirs();
        java.io.FileInputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(directory);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ioe) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    public void dz() throws java.lang.Exception {
        final java.io.File directory = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test.txt");
        java.io.FileInputStream in = null;
        try {
            in = org.apache.commons.io.FileUtils.openInputStream(directory);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ioe) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    void a(final boolean createFile) throws java.lang.Exception {
        final java.io.File file = new java.io.File("test.txt");
        junit.framework.TestCase.assertNull(file.getParentFile());
        try {
            if (createFile) {
                createLineBasedFile(file, new java.lang.String[]{ "Hello" });
            } 
            java.io.FileOutputStream out = null;
            try {
                out = org.apache.commons.io.FileUtils.openOutputStream(file);
                out.write(0);
            } finally {
                org.apache.commons.io.IOUtils.closeQuietly(out);
            }
            junit.framework.TestCase.assertTrue(file.exists());
        } finally {
            if ((file.delete()) == false) {
                file.deleteOnExit();
            } 
        }
    }

    public void ec() throws java.lang.Exception {
        openOutputStream_noParent(true);
    }

    public void ed() throws java.lang.Exception {
        openOutputStream_noParent(false);
    }

    public void ea() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test.txt");
        createLineBasedFile(file, new java.lang.String[]{ "Hello" });
        java.io.FileOutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(file);
            out.write(0);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
        junit.framework.TestCase.assertTrue(file.exists());
    }

    public void eb() throws java.lang.Exception {
        final java.io.File directory = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "subdir");
        directory.mkdirs();
        java.io.FileOutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(directory);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ioe) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
    }

    public void ee() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "a/test.txt");
        java.io.FileOutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(file);
            out.write(0);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
        junit.framework.TestCase.assertTrue(file.exists());
    }

    public void ef() throws java.lang.Exception {
        final java.lang.String longStr = "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" + ("abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" + ("abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" + ("abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" + ("abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" + "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz"))));
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , (("a/" + longStr) + "/test.txt"));
        java.io.FileOutputStream out = null;
        try {
            out = org.apache.commons.io.FileUtils.openOutputStream(file);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ioe) {
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(out);
        }
    }

    public void b() {
        final java.math.BigInteger b1023 = java.math.BigInteger.valueOf(1023);
        final java.math.BigInteger b1025 = java.math.BigInteger.valueOf(1025);
        final java.math.BigInteger KB1 = java.math.BigInteger.valueOf(1024);
        final java.math.BigInteger MB1 = KB1.multiply(KB1);
        final java.math.BigInteger GB1 = MB1.multiply(KB1);
        final java.math.BigInteger GB2 = GB1.add(GB1);
        final java.math.BigInteger TB1 = GB1.multiply(KB1);
        final java.math.BigInteger PB1 = TB1.multiply(KB1);
        final java.math.BigInteger EB1 = PB1.multiply(KB1);
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.math.BigInteger.ZERO), "0 bytes");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.math.BigInteger.ONE), "1 bytes");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(b1023), "1023 bytes");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(KB1), "1 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(b1025), "1 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(MB1.subtract(java.math.BigInteger.ONE)), "1023 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(MB1), "1 MB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(MB1.add(java.math.BigInteger.ONE)), "1 MB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(GB1.subtract(java.math.BigInteger.ONE)), "1023 MB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(GB1), "1 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(GB1.add(java.math.BigInteger.ONE)), "1 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(GB2), "2 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(GB2.subtract(java.math.BigInteger.ONE)), "1 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(TB1), "1 TB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(PB1), "1 PB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(EB1), "1 EB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.lang.Long.MAX_VALUE), "7 EB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.math.BigInteger.valueOf(java.lang.Character.MAX_VALUE)), "63 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.math.BigInteger.valueOf(java.lang.Short.MAX_VALUE)), "31 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.math.BigInteger.valueOf(java.lang.Integer.MAX_VALUE)), "1 GB");
    }

    public void c() {
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(0), "0 bytes");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(1), "1 bytes");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(1023), "1023 bytes");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(1024), "1 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(1025), "1 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize((1024 * 1023)), "1023 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize((1024 * 1024)), "1 MB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize((1024 * 1025)), "1 MB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(((1024 * 1024) * 1023)), "1023 MB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(((1024 * 1024) * 1024)), "1 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(((1024 * 1024) * 1025)), "1 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize((((1024L * 1024) * 1024) * 2)), "2 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(((((1024 * 1024) * 1024) * 2) - 1)), "1 GB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize((((1024L * 1024) * 1024) * 1024)), "1 TB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(((((1024L * 1024) * 1024) * 1024) * 1024)), "1 PB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize((((((1024L * 1024) * 1024) * 1024) * 1024) * 1024)), "1 EB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.lang.Long.MAX_VALUE), "7 EB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.lang.Character.MAX_VALUE), "63 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.lang.Short.MAX_VALUE), "31 KB");
        junit.framework.TestCase.assertEquals(org.apache.commons.io.FileUtils.byteCountToDisplaySize(java.lang.Integer.MAX_VALUE), "1 GB");
    }

    public void cd() throws java.lang.Exception {
        final java.net.URL url = new java.net.URL("file" , null , "a/b/c/file.txt");
        final java.io.File file = org.apache.commons.io.FileUtils.toFile(url);
        junit.framework.TestCase.assertTrue(file.toString().contains("file.txt"));
    }

    public void ce() throws java.lang.Exception {
        final java.net.URL url = new java.net.URL("file" , null , "a/b/c/file%20n%61me%2520.tx%74");
        final java.io.File file = org.apache.commons.io.FileUtils.toFile(url);
        junit.framework.TestCase.assertTrue(file.toString().contains("file name%20.txt"));
    }

    public void cf() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FileUtils.toFile(null));
        junit.framework.TestCase.assertEquals(null, org.apache.commons.io.FileUtils.toFile(new java.net.URL("http://jakarta.apache.org")));
    }

    public void cg() throws java.lang.Exception {
        final java.net.URL url = new java.net.URL("file" , null , "a/b/c/file%%20%me.txt%");
        final java.io.File file = org.apache.commons.io.FileUtils.toFile(url);
        junit.framework.TestCase.assertTrue(file.toString().contains("file% %me.txt%"));
    }

    public void ch() throws java.lang.Exception {
        final java.net.URL url = new java.net.URL("file" , null , "both%20are%20100%20%25%20true");
        final java.io.File file = org.apache.commons.io.FileUtils.toFile(url);
        junit.framework.TestCase.assertEquals("both are 100 % true", file.toString());
    }

    public void ci() throws java.lang.Exception {
        final java.net.URL url = new java.net.URL("file" , null , "/home/%C3%A4%C3%B6%C3%BC%C3%9F");
        final java.io.File file = org.apache.commons.io.FileUtils.toFile(url);
        junit.framework.TestCase.assertTrue(file.toString().contains("äöüß"));
    }

    public void ae() {
        junit.framework.TestCase.assertEquals("", org.apache.commons.io.FileUtils.decodeUrl(""));
        junit.framework.TestCase.assertEquals("foo", org.apache.commons.io.FileUtils.decodeUrl("foo"));
        junit.framework.TestCase.assertEquals("+", org.apache.commons.io.FileUtils.decodeUrl("+"));
        junit.framework.TestCase.assertEquals("% ", org.apache.commons.io.FileUtils.decodeUrl("%25%20"));
        junit.framework.TestCase.assertEquals("%20", org.apache.commons.io.FileUtils.decodeUrl("%2520"));
        junit.framework.TestCase.assertEquals("jar:file:/C:/dir/sub dir/1.0/foo-1.0.jar!/org/Bar.class", org.apache.commons.io.FileUtils.decodeUrl("jar:file:/C:/dir/sub%20dir/1.0/foo-1.0.jar!/org/Bar.class"));
    }

    public void ag() {
        junit.framework.TestCase.assertEquals(" ", org.apache.commons.io.FileUtils.decodeUrl(" "));
        junit.framework.TestCase.assertEquals("äöüß", org.apache.commons.io.FileUtils.decodeUrl("äöüß"));
        junit.framework.TestCase.assertEquals("%", org.apache.commons.io.FileUtils.decodeUrl("%"));
        junit.framework.TestCase.assertEquals("% ", org.apache.commons.io.FileUtils.decodeUrl("%%20"));
        junit.framework.TestCase.assertEquals("%2", org.apache.commons.io.FileUtils.decodeUrl("%2"));
        junit.framework.TestCase.assertEquals("%2G", org.apache.commons.io.FileUtils.decodeUrl("%2G"));
    }

    public void ah() {
        junit.framework.TestCase.assertNull(org.apache.commons.io.FileUtils.decodeUrl(null));
    }

    public void af() {
        junit.framework.TestCase.assertEquals("äöüß", org.apache.commons.io.FileUtils.decodeUrl("%C3%A4%C3%B6%C3%BC%C3%9F"));
    }

    public void cj() throws java.lang.Exception {
        final java.net.URL[] urls = new java.net.URL[]{ new java.net.URL("file" , null , "file1.txt") , new java.net.URL("file" , null , "file2.txt") };
        final java.io.File[] files = org.apache.commons.io.FileUtils.toFiles(urls);
        junit.framework.TestCase.assertEquals(urls.length, files.length);
        junit.framework.TestCase.assertEquals(("File: " + (files[0])), true, files[0].toString().contains("file1.txt"));
        junit.framework.TestCase.assertEquals(("File: " + (files[1])), true, files[1].toString().contains("file2.txt"));
    }

    public void ck() throws java.lang.Exception {
        final java.net.URL[] urls = new java.net.URL[]{ new java.net.URL("file" , null , "file1.txt") , null };
        final java.io.File[] files = org.apache.commons.io.FileUtils.toFiles(urls);
        junit.framework.TestCase.assertEquals(urls.length, files.length);
        junit.framework.TestCase.assertEquals(("File: " + (files[0])), true, files[0].toString().contains("file1.txt"));
        junit.framework.TestCase.assertEquals(("File: " + (files[1])), null, files[1]);
    }

    public void cl() throws java.lang.Exception {
        final java.net.URL[] urls = null;
        final java.io.File[] files = org.apache.commons.io.FileUtils.toFiles(urls);
        junit.framework.TestCase.assertEquals(0, files.length);
    }

    public void cm() throws java.lang.Exception {
        final java.net.URL[] urls = new java.net.URL[0];
        final java.io.File[] files = org.apache.commons.io.FileUtils.toFiles(urls);
        junit.framework.TestCase.assertEquals(0, files.length);
    }

    public void cn() throws java.lang.Exception {
        final java.net.URL[] urls = new java.net.URL[]{ new java.net.URL("file" , null , "file1.txt") , new java.net.URL("http" , "jakarta.apache.org" , "file1.txt") };
        try {
            org.apache.commons.io.FileUtils.toFiles(urls);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void co() throws java.lang.Exception {
        final java.io.File[] files = new java.io.File[]{ new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file1.txt") , new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "file2.txt") , new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test file.txt") };
        final java.net.URL[] urls = org.apache.commons.io.FileUtils.toURLs(files);
        junit.framework.TestCase.assertEquals(files.length, urls.length);
        junit.framework.TestCase.assertTrue(urls[0].toExternalForm().startsWith("file:"));
        junit.framework.TestCase.assertTrue(urls[0].toExternalForm().contains("file1.txt"));
        junit.framework.TestCase.assertTrue(urls[1].toExternalForm().startsWith("file:"));
        junit.framework.TestCase.assertTrue(urls[1].toExternalForm().contains("file2.txt"));
        junit.framework.TestCase.assertTrue(urls[2].toExternalForm().startsWith("file:"));
        junit.framework.TestCase.assertTrue(urls[2].toExternalForm().contains("test%20file.txt"));
    }

    public void cp() throws java.lang.Exception {
        final java.io.File[] files = new java.io.File[0];
        final java.net.URL[] urls = org.apache.commons.io.FileUtils.toURLs(files);
        junit.framework.TestCase.assertEquals(0, urls.length);
    }

    public void k() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        final java.io.File file2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + "2"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(file, file));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(file, file2));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(file2, file2));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(file2, file));
        try {
            org.apache.commons.io.FileUtils.contentEquals(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
            junit.framework.TestCase.fail("Comparing directories should fail with an IOException");
        } catch (final java.io.IOException ioe) {
        }
        final java.io.File objFile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + ".object"));
        objFile1.deleteOnExit();
        org.apache.commons.io.FileUtils.copyURLToFile(getClass().getResource("/java/lang/Object.class"), objFile1);
        final java.io.File objFile1b = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + ".object2"));
        objFile1.deleteOnExit();
        org.apache.commons.io.FileUtils.copyURLToFile(getClass().getResource("/java/lang/Object.class"), objFile1b);
        final java.io.File objFile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + ".collection"));
        objFile2.deleteOnExit();
        org.apache.commons.io.FileUtils.copyURLToFile(getClass().getResource("/java/util/Collection.class"), objFile2);
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEquals(objFile1, objFile2));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEquals(objFile1b, objFile2));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(objFile1, objFile1b));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(objFile1, objFile1));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(objFile1b, objFile1b));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(objFile2, objFile2));
        file.createNewFile();
        file2.createNewFile();
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(file, file));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(file, file2));
    }

    public void l() throws java.lang.Exception {
        final java.io.File file1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        final java.io.File file2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + "2"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file1, file1, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file1, file2, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file2, file2, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file2, file1, null));
        try {
            org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), null);
            junit.framework.TestCase.fail("Comparing directories should fail with an IOException");
        } catch (final java.io.IOException ioe) {
        }
        final java.io.File tfile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + ".txt1"));
        tfile1.deleteOnExit();
        org.apache.commons.io.FileUtils.write(tfile1, "123\r");
        final java.io.File tfile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + ".txt2"));
        tfile1.deleteOnExit();
        org.apache.commons.io.FileUtils.write(tfile2, "123\n");
        final java.io.File tfile3 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , ((getName()) + ".collection"));
        tfile3.deleteOnExit();
        org.apache.commons.io.FileUtils.write(tfile3, "123\r\n2");
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(tfile1, tfile1, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(tfile2, tfile2, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(tfile3, tfile3, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(tfile1, tfile2, null));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(tfile1, tfile3, null));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(tfile2, tfile3, null));
        final java.net.URL urlCR = getClass().getResource("FileUtilsTestDataCR.dat");
        junit.framework.TestCase.assertNotNull(urlCR);
        final java.io.File cr = new java.io.File(urlCR.getPath());
        junit.framework.TestCase.assertTrue(cr.exists());
        final java.net.URL urlCRLF = getClass().getResource("FileUtilsTestDataCRLF.dat");
        junit.framework.TestCase.assertNotNull(urlCRLF);
        final java.io.File crlf = new java.io.File(urlCRLF.getPath());
        junit.framework.TestCase.assertTrue(crlf.exists());
        final java.net.URL urlLF = getClass().getResource("FileUtilsTestDataLF.dat");
        junit.framework.TestCase.assertNotNull(urlLF);
        final java.io.File lf = new java.io.File(urlLF.getPath());
        junit.framework.TestCase.assertTrue(lf.exists());
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(cr, cr, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(crlf, crlf, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(lf, lf, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(cr, crlf, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(cr, lf, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(crlf, lf, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(cr, cr));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(crlf, crlf));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEquals(lf, lf));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEquals(cr, crlf));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEquals(cr, lf));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.FileUtils.contentEquals(crlf, lf));
        file1.createNewFile();
        file2.createNewFile();
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file1, file1, null));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file1, file2, null));
    }

    public void ac() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        file.deleteOnExit();
        final java.lang.String resourceName = "/java/lang/Object.class";
        org.apache.commons.io.FileUtils.copyURLToFile(getClass().getResource(resourceName), file);
        final java.io.FileInputStream fis = new java.io.FileInputStream(file);
        try {
            junit.framework.TestCase.assertTrue("Content is not equal.", org.apache.commons.io.IOUtils.contentEquals(getClass().getResourceAsStream(resourceName), fis));
        } finally {
            fis.close();
        }
    }

    public void ad() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testCopyURLToFileWithTimeout");
        file.deleteOnExit();
        final java.lang.String resourceName = "/java/lang/Object.class";
        org.apache.commons.io.FileUtils.copyURLToFile(getClass().getResource(resourceName), file, 500, 500);
        final java.io.FileInputStream fis = new java.io.FileInputStream(file);
        try {
            junit.framework.TestCase.assertTrue("Content is not equal.", org.apache.commons.io.IOUtils.contentEquals(getClass().getResourceAsStream(resourceName), fis));
        } finally {
            fis.close();
        }
    }

    public void as() throws java.lang.Exception {
        org.apache.commons.io.FileUtils.forceMkdir(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        testFile.deleteOnExit();
        testFile.createNewFile();
        junit.framework.TestCase.assertTrue("Test file does not exist.", testFile.exists());
        try {
            org.apache.commons.io.FileUtils.forceMkdir(testFile);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.io.IOException ex) {
        }
        testFile.delete();
        org.apache.commons.io.FileUtils.forceMkdir(testFile);
        junit.framework.TestCase.assertTrue("Directory was not created.", testFile.exists());
    }

    public void at() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory().exists());
        final java.io.File testParentDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testForceMkdirParent");
        try {
            testParentDir.delete();
            junit.framework.TestCase.assertFalse(testParentDir.exists());
            final java.io.File testFile = new java.io.File(testParentDir , "test.txt");
            junit.framework.TestCase.assertFalse(testParentDir.exists());
            junit.framework.TestCase.assertFalse(testFile.exists());
            org.apache.commons.io.FileUtils.forceMkdirParent(testFile);
            junit.framework.TestCase.assertTrue(testParentDir.exists());
            junit.framework.TestCase.assertFalse(testFile.exists());
            org.apache.commons.io.FileUtils.forceMkdirParent(testFile);
            junit.framework.TestCase.assertTrue(testParentDir.exists());
            junit.framework.TestCase.assertFalse(testFile.exists());
        } finally {
            testParentDir.delete();
        }
    }

    public void cb() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        try {
            org.apache.commons.io.FileUtils.sizeOfDirectory(file);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        file.createNewFile();
        file.deleteOnExit();
        try {
            org.apache.commons.io.FileUtils.sizeOfDirectory(file);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        file.delete();
        file.mkdir();
        createCircularSymLink(file);
        junit.framework.TestCase.assertEquals("Unexpected directory size", TEST_DIRECTORY_SIZE, org.apache.commons.io.FileUtils.sizeOfDirectory(file));
    }

    private void a(final java.io.File file) throws java.io.IOException {
        if (!(org.apache.commons.io.FilenameUtils.isSystemWindows())) {
            java.lang.Runtime.getRuntime().exec((((("ln -s " + file) + "/.. ") + file) + "/cycle"));
        } else {
            try {
                java.lang.Runtime.getRuntime().exec((((("mklink /D " + file) + "/cycle") + file) + "/.. "));
            } catch (final java.io.IOException ioe) {
            }
        }
    }

    public void cc() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        try {
            org.apache.commons.io.FileUtils.sizeOfDirectoryAsBigInteger(file);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        file.createNewFile();
        file.deleteOnExit();
        try {
            org.apache.commons.io.FileUtils.sizeOfDirectoryAsBigInteger(file);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        file.delete();
        file.mkdir();
        createCircularSymLink(file);
        junit.framework.TestCase.assertEquals("Unexpected directory size", TEST_DIRECTORY_SIZE_BI, org.apache.commons.io.FileUtils.sizeOfDirectoryAsBigInteger(file));
        file.delete();
        file.mkdir();
        final java.io.File nonEmptyFile = new java.io.File(file , ("nonEmptyFile" + (java.lang.System.nanoTime())));
        createFile(nonEmptyFile, TEST_DIRECTORY_SIZE_GT_ZERO_BI.longValue());
        nonEmptyFile.deleteOnExit();
        junit.framework.TestCase.assertEquals("Unexpected directory size", TEST_DIRECTORY_SIZE_GT_ZERO_BI, org.apache.commons.io.FileUtils.sizeOfDirectoryAsBigInteger(file));
        nonEmptyFile.delete();
        file.delete();
    }

    public void j() {
        final java.io.File start = new java.io.File("src/test/java");
        final long sizeLong1 = org.apache.commons.io.FileUtils.sizeOf(start);
        final java.math.BigInteger sizeBig = org.apache.commons.io.FileUtils.sizeOfAsBigInteger(start);
        final long sizeLong2 = org.apache.commons.io.FileUtils.sizeOf(start);
        junit.framework.TestCase.assertEquals("Size should not change", sizeLong1, sizeLong2);
        junit.framework.TestCase.assertEquals("longSize should equal BigSize", sizeLong1, sizeBig.longValue());
    }

    public void bz() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        try {
            org.apache.commons.io.FileUtils.sizeOf(null);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.sizeOf(file);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        file.createNewFile();
        file.deleteOnExit();
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.FileUtils.sizeOf(file));
        file.delete();
        junit.framework.TestCase.assertEquals("Unexpected files size", testFile1Size, org.apache.commons.io.FileUtils.sizeOf(testFile1));
        junit.framework.TestCase.assertEquals("Unexpected directory size", TEST_DIRECTORY_SIZE, org.apache.commons.io.FileUtils.sizeOf(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory()));
    }

    public void ca() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , getName());
        try {
            org.apache.commons.io.FileUtils.sizeOfAsBigInteger(null);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.sizeOfAsBigInteger(file);
            junit.framework.TestCase.fail("Exception expected.");
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        file.createNewFile();
        file.deleteOnExit();
        junit.framework.TestCase.assertEquals(java.math.BigInteger.ZERO, org.apache.commons.io.FileUtils.sizeOfAsBigInteger(file));
        file.delete();
        junit.framework.TestCase.assertEquals("Unexpected files size", java.math.BigInteger.valueOf(testFile1Size), org.apache.commons.io.FileUtils.sizeOfAsBigInteger(testFile1));
        junit.framework.TestCase.assertEquals("Unexpected directory size", TEST_DIRECTORY_SIZE_BI, org.apache.commons.io.FileUtils.sizeOfAsBigInteger(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory()));
    }

    public void bd() throws java.lang.Exception {
        final java.io.File reference = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "FileUtils-reference.txt");
        final java.io.File oldFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "FileUtils-old.txt");
        final java.io.File newFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "FileUtils-new.txt");
        final java.io.File invalidFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "FileUtils-invalid-file.txt");
        createFile(oldFile, 0);
        do {
            try {
                java.lang.Thread.sleep(1000);
            } catch (final java.lang.InterruptedException ie) {
            }
            createFile(reference, 0);
        } while ((oldFile.lastModified()) == (reference.lastModified()) );
        final java.util.Date date = new java.util.Date();
        final long now = date.getTime();
        do {
            try {
                java.lang.Thread.sleep(1000);
            } catch (final java.lang.InterruptedException ie) {
            }
            createFile(newFile, 0);
        } while ((reference.lastModified()) == (newFile.lastModified()) );
        junit.framework.TestCase.assertFalse("Old File - Newer - File", org.apache.commons.io.FileUtils.isFileNewer(oldFile, reference));
        junit.framework.TestCase.assertFalse("Old File - Newer - Date", org.apache.commons.io.FileUtils.isFileNewer(oldFile, date));
        junit.framework.TestCase.assertFalse("Old File - Newer - Mili", org.apache.commons.io.FileUtils.isFileNewer(oldFile, now));
        junit.framework.TestCase.assertTrue("New File - Newer - File", org.apache.commons.io.FileUtils.isFileNewer(newFile, reference));
        junit.framework.TestCase.assertTrue("New File - Newer - Date", org.apache.commons.io.FileUtils.isFileNewer(newFile, date));
        junit.framework.TestCase.assertTrue("New File - Newer - Mili", org.apache.commons.io.FileUtils.isFileNewer(newFile, now));
        junit.framework.TestCase.assertFalse("Invalid - Newer - File", org.apache.commons.io.FileUtils.isFileNewer(invalidFile, reference));
        final java.lang.String invalidFileName = invalidFile.getName();
        try {
            org.apache.commons.io.FileUtils.isFileNewer(newFile, invalidFile);
            junit.framework.TestCase.fail("Should have cause IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException iae) {
            final java.lang.String message = iae.getMessage();
            junit.framework.TestCase.assertTrue(((("Message should contain: " + invalidFileName) + " but was: ") + message), message.contains(invalidFileName));
        }
        junit.framework.TestCase.assertTrue("Old File - Older - File", org.apache.commons.io.FileUtils.isFileOlder(oldFile, reference));
        junit.framework.TestCase.assertTrue("Old File - Older - Date", org.apache.commons.io.FileUtils.isFileOlder(oldFile, date));
        junit.framework.TestCase.assertTrue("Old File - Older - Mili", org.apache.commons.io.FileUtils.isFileOlder(oldFile, now));
        junit.framework.TestCase.assertFalse("New File - Older - File", org.apache.commons.io.FileUtils.isFileOlder(newFile, reference));
        junit.framework.TestCase.assertFalse("New File - Older - Date", org.apache.commons.io.FileUtils.isFileOlder(newFile, date));
        junit.framework.TestCase.assertFalse("New File - Older - Mili", org.apache.commons.io.FileUtils.isFileOlder(newFile, now));
        junit.framework.TestCase.assertFalse("Invalid - Older - File", org.apache.commons.io.FileUtils.isFileOlder(invalidFile, reference));
        try {
            org.apache.commons.io.FileUtils.isFileOlder(newFile, invalidFile);
            junit.framework.TestCase.fail("Should have cause IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException iae) {
            final java.lang.String message = iae.getMessage();
            junit.framework.TestCase.assertTrue(((("Message should contain: " + invalidFileName) + " but was: ") + message), message.contains(invalidFileName));
        }
        try {
            org.apache.commons.io.FileUtils.isFileNewer(null, now);
            junit.framework.TestCase.fail("Newer Null, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileNewer(oldFile, ((java.io.File)(null)));
            junit.framework.TestCase.fail("Newer Null reference, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileNewer(oldFile, invalidFile);
            junit.framework.TestCase.fail("Newer invalid reference, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileNewer(oldFile, ((java.util.Date)(null)));
            junit.framework.TestCase.fail("Newer Null date, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileOlder(null, now);
            junit.framework.TestCase.fail("Older Null, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileOlder(oldFile, ((java.io.File)(null)));
            junit.framework.TestCase.fail("Older Null reference, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileOlder(oldFile, invalidFile);
            junit.framework.TestCase.fail("Older invalid reference, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
        try {
            org.apache.commons.io.FileUtils.isFileOlder(oldFile, ((java.util.Date)(null)));
            junit.framework.TestCase.fail("Older Null date, expected IllegalArgumentExcepion");
        } catch (final java.lang.IllegalArgumentException expected) {
        }
    }

    public void v() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copy1.txt");
        org.apache.commons.io.FileUtils.copyFile(testFile1, destination);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertEquals("Check Full copy", testFile1Size, destination.length());
    }

    public void aa() throws java.lang.Exception {
        final java.io.ByteArrayOutputStream destination = new java.io.ByteArrayOutputStream();
        org.apache.commons.io.FileUtils.copyFile(testFile1, destination);
        junit.framework.TestCase.assertEquals("Check Full copy size", testFile1Size, destination.size());
        final byte[] expected = org.apache.commons.io.FileUtils.readFileToByteArray(testFile1);
        org.junit.Assert.assertArrayEquals("Check Full copy", expected, destination.toByteArray());
    }

    public void a() throws java.lang.Exception {
        final java.io.File largeFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "large.txt");
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copylarge.txt");
        java.lang.System.out.println(("START:   " + (new java.util.Date())));
        createFile(largeFile, org.apache.commons.io.FileUtils.ONE_GB);
        java.lang.System.out.println(("CREATED: " + (new java.util.Date())));
        org.apache.commons.io.FileUtils.copyFile(largeFile, destination);
        java.lang.System.out.println(("COPIED:  " + (new java.util.Date())));
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertEquals("Check Full copy", largeFile.length(), destination.length());
    }

    public void x() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copy2.txt");
        org.apache.commons.io.FileUtils.copyFile(testFile1, destination);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertEquals("Check Full copy", testFile2Size, destination.length());
    }

    public void ab() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copy3.txt");
        org.apache.commons.io.FileUtils.copyFile(testFile1, destination);
        try {
            org.apache.commons.io.FileUtils.copyFile(destination, destination);
            junit.framework.TestCase.fail("file copy to self should not be possible");
        } catch (final java.io.IOException ioe) {
        }
    }

    public void z() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copy2.txt");
        org.apache.commons.io.FileUtils.copyFile(testFile1, destination, false);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertEquals("Check Full copy", testFile2Size, destination.length());
    }

    public void q() throws java.lang.Exception {
        createFile(testFile1, 1234);
        createFile(testFile2, 4321);
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(srcDir , "sub");
        subDir.mkdir();
        final java.io.File subFile = new java.io.File(subDir , "A.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(subFile, "HELLO WORLD", "UTF8");
        final java.io.File destDir = new java.io.File(java.lang.System.getProperty("java.io.tmpdir") , "tmp-FileUtilsTestCase");
        org.apache.commons.io.FileUtils.deleteDirectory(destDir);
        final java.io.File actualDestDir = new java.io.File(destDir , srcDir.getName());
        org.apache.commons.io.FileUtils.copyDirectoryToDirectory(srcDir, destDir);
        junit.framework.TestCase.assertTrue("Check exists", destDir.exists());
        junit.framework.TestCase.assertTrue("Check exists", actualDestDir.exists());
        final long srcSize = org.apache.commons.io.FileUtils.sizeOfDirectory(srcDir);
        junit.framework.TestCase.assertTrue("Size > 0", (srcSize > 0));
        junit.framework.TestCase.assertEquals("Check size", srcSize, org.apache.commons.io.FileUtils.sizeOfDirectory(actualDestDir));
        junit.framework.TestCase.assertTrue(new java.io.File(actualDestDir , "sub/A.txt").exists());
        org.apache.commons.io.FileUtils.deleteDirectory(destDir);
    }

    public void u() throws java.lang.Exception {
        createFile(testFile1, 1234);
        createFile(testFile2, 4321);
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(srcDir , "sub");
        subDir.mkdir();
        final java.io.File subFile = new java.io.File(subDir , "A.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(subFile, "HELLO WORLD", "UTF8");
        final java.io.File destDir = new java.io.File(java.lang.System.getProperty("java.io.tmpdir") , "tmp-FileUtilsTestCase");
        org.apache.commons.io.FileUtils.deleteDirectory(destDir);
        org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir);
        junit.framework.TestCase.assertTrue("Check exists", destDir.exists());
        final long sizeOfSrcDirectory = org.apache.commons.io.FileUtils.sizeOfDirectory(srcDir);
        junit.framework.TestCase.assertTrue("Size > 0", (sizeOfSrcDirectory > 0));
        junit.framework.TestCase.assertEquals("Check size", sizeOfSrcDirectory, org.apache.commons.io.FileUtils.sizeOfDirectory(destDir));
        junit.framework.TestCase.assertTrue(new java.io.File(destDir , "sub/A.txt").exists());
        org.apache.commons.io.FileUtils.deleteDirectory(destDir);
    }

    public void r() throws java.lang.Exception {
        createFile(testFile1, 1234);
        createFile(testFile2, 4321);
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(srcDir , "sub");
        subDir.mkdir();
        final java.io.File subFile = new java.io.File(subDir , "A.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(subFile, "HELLO WORLD", "UTF8");
        final java.io.File destDir = new java.io.File(java.lang.System.getProperty("java.io.tmpdir") , "tmp-FileUtilsTestCase");
        org.apache.commons.io.FileUtils.deleteDirectory(destDir);
        destDir.mkdirs();
        org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir);
        final long srcSize = org.apache.commons.io.FileUtils.sizeOfDirectory(srcDir);
        junit.framework.TestCase.assertTrue("Size > 0", (srcSize > 0));
        junit.framework.TestCase.assertEquals(srcSize, org.apache.commons.io.FileUtils.sizeOfDirectory(destDir));
        junit.framework.TestCase.assertTrue(new java.io.File(destDir , "sub/A.txt").exists());
    }

    public void n() throws java.lang.Exception {
        final java.io.File grandParentDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "grandparent");
        final java.io.File parentDir = new java.io.File(grandParentDir , "parent");
        final java.io.File childDir = new java.io.File(parentDir , "child");
        createFilesForTestCopyDirectory(grandParentDir, parentDir, childDir);
        final org.apache.commons.io.filefilter.NameFileFilter filter = new org.apache.commons.io.filefilter.NameFileFilter(new java.lang.String[]{ "parent" , "child" , "file3.txt" });
        final java.io.File destDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copydest");
        org.apache.commons.io.FileUtils.copyDirectory(grandParentDir, destDir, filter);
        final java.util.List<java.io.File> files = LIST_WALKER.list(destDir);
        junit.framework.TestCase.assertEquals(3, files.size());
        junit.framework.TestCase.assertEquals("parent", files.get(0).getName());
        junit.framework.TestCase.assertEquals("child", files.get(1).getName());
        junit.framework.TestCase.assertEquals("file3.txt", files.get(2).getName());
    }

    public void o() throws java.lang.Exception {
        final java.io.File source = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "source");
        final java.io.File sourceDirectory = new java.io.File(source , "directory");
        final java.io.File sourceFile = new java.io.File(sourceDirectory , "hello.txt");
        source.mkdirs();
        sourceDirectory.mkdir();
        org.apache.commons.io.FileUtils.writeStringToFile(sourceFile, "HELLO WORLD", "UTF8");
        sourceFile.setLastModified(1000000002000L);
        sourceDirectory.setLastModified(1000000001000L);
        source.setLastModified(1000000000000L);
        final java.io.File target = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "target");
        final java.io.File targetDirectory = new java.io.File(target , "directory");
        final java.io.File targetFile = new java.io.File(targetDirectory , "hello.txt");
        org.apache.commons.io.FileUtils.copyDirectory(source, target, false);
        junit.framework.TestCase.assertTrue((1000000000000L != (target.lastModified())));
        junit.framework.TestCase.assertTrue((1000000001000L != (targetDirectory.lastModified())));
        junit.framework.TestCase.assertTrue((1000000002000L != (targetFile.lastModified())));
        org.apache.commons.io.FileUtils.deleteDirectory(target);
        org.apache.commons.io.FileUtils.copyDirectory(source, target, true);
        junit.framework.TestCase.assertEquals(1000000000000L, target.lastModified());
        junit.framework.TestCase.assertEquals(1000000001000L, targetDirectory.lastModified());
        junit.framework.TestCase.assertEquals(1000000002000L, targetFile.lastModified());
        org.apache.commons.io.FileUtils.deleteDirectory(target);
        target.mkdirs();
        org.apache.commons.io.FileUtils.copyDirectory(source, target, true);
        junit.framework.TestCase.assertEquals(1000000000000L, target.lastModified());
        junit.framework.TestCase.assertEquals(1000000001000L, targetDirectory.lastModified());
        junit.framework.TestCase.assertEquals(1000000002000L, targetFile.lastModified());
        org.apache.commons.io.FileUtils.deleteDirectory(target);
        targetDirectory.mkdirs();
        org.apache.commons.io.FileUtils.copyDirectory(source, target, true);
        junit.framework.TestCase.assertEquals(1000000000000L, target.lastModified());
        junit.framework.TestCase.assertEquals(1000000001000L, targetDirectory.lastModified());
        junit.framework.TestCase.assertEquals(1000000002000L, targetFile.lastModified());
        org.apache.commons.io.FileUtils.deleteDirectory(target);
    }

    public void p() throws java.lang.Exception {
        final java.io.File grandParentDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "grandparent");
        final java.io.File parentDir = new java.io.File(grandParentDir , "parent");
        final java.io.File childDir = new java.io.File(parentDir , "child");
        createFilesForTestCopyDirectory(grandParentDir, parentDir, childDir);
        final long expectedCount = (LIST_WALKER.list(grandParentDir).size()) + (LIST_WALKER.list(parentDir).size());
        final long expectedSize = (org.apache.commons.io.FileUtils.sizeOfDirectory(grandParentDir)) + (org.apache.commons.io.FileUtils.sizeOfDirectory(parentDir));
        org.apache.commons.io.FileUtils.copyDirectory(parentDir, childDir);
        junit.framework.TestCase.assertEquals(expectedCount, LIST_WALKER.list(grandParentDir).size());
        junit.framework.TestCase.assertEquals(expectedSize, org.apache.commons.io.FileUtils.sizeOfDirectory(grandParentDir));
        junit.framework.TestCase.assertTrue("Count > 0", (expectedCount > 0));
        junit.framework.TestCase.assertTrue("Size > 0", (expectedSize > 0));
    }

    public void s() throws java.lang.Exception {
        final java.io.File grandParentDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "grandparent");
        final java.io.File parentDir = new java.io.File(grandParentDir , "parent");
        final java.io.File childDir = new java.io.File(parentDir , "child");
        createFilesForTestCopyDirectory(grandParentDir, parentDir, childDir);
        final long expectedCount = (LIST_WALKER.list(grandParentDir).size()) * 2;
        final long expectedSize = (org.apache.commons.io.FileUtils.sizeOfDirectory(grandParentDir)) * 2;
        org.apache.commons.io.FileUtils.copyDirectory(grandParentDir, childDir);
        junit.framework.TestCase.assertEquals(expectedCount, LIST_WALKER.list(grandParentDir).size());
        junit.framework.TestCase.assertEquals(expectedSize, org.apache.commons.io.FileUtils.sizeOfDirectory(grandParentDir));
        junit.framework.TestCase.assertTrue("Size > 0", (expectedSize > 0));
    }

    public void t() throws java.lang.Exception {
        final java.io.File dir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "itself");
        dir.mkdirs();
        org.apache.commons.io.FileUtils.copyDirectoryToDirectory(dir, dir);
        junit.framework.TestCase.assertEquals(1, LIST_WALKER.list(dir).size());
    }

    private void a(final java.io.File grandParentDir, final java.io.File parentDir, final java.io.File childDir) throws java.lang.Exception {
        final java.io.File childDir2 = new java.io.File(parentDir , "child2");
        final java.io.File grandChildDir = new java.io.File(childDir , "grandChild");
        final java.io.File grandChild2Dir = new java.io.File(childDir2 , "grandChild2");
        final java.io.File file1 = new java.io.File(grandParentDir , "file1.txt");
        final java.io.File file2 = new java.io.File(parentDir , "file2.txt");
        final java.io.File file3 = new java.io.File(childDir , "file3.txt");
        final java.io.File file4 = new java.io.File(childDir2 , "file4.txt");
        final java.io.File file5 = new java.io.File(grandChildDir , "file5.txt");
        final java.io.File file6 = new java.io.File(grandChild2Dir , "file6.txt");
        org.apache.commons.io.FileUtils.deleteDirectory(grandParentDir);
        grandChildDir.mkdirs();
        grandChild2Dir.mkdirs();
        org.apache.commons.io.FileUtils.writeStringToFile(file1, "File 1 in grandparent", "UTF8");
        org.apache.commons.io.FileUtils.writeStringToFile(file2, "File 2 in parent", "UTF8");
        org.apache.commons.io.FileUtils.writeStringToFile(file3, "File 3 in child", "UTF8");
        org.apache.commons.io.FileUtils.writeStringToFile(file4, "File 4 in child2", "UTF8");
        org.apache.commons.io.FileUtils.writeStringToFile(file5, "File 5 in grandChild", "UTF8");
        org.apache.commons.io.FileUtils.writeStringToFile(file6, "File 6 in grandChild2", "UTF8");
    }

    public void m() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.copyDirectory(null, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.copyDirectory(new java.io.File("a"), null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.copyDirectory(null, new java.io.File("a"));
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.copyDirectory(new java.io.File("doesnt-exist"), new java.io.File("a"));
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.copyDirectory(testFile1, new java.io.File("a"));
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.copyDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), testFile1);
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
        try {
            org.apache.commons.io.FileUtils.copyDirectory(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory());
            junit.framework.TestCase.fail();
        } catch (final java.io.IOException ex) {
        }
    }

    public void ao() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copy1.txt");
        destination.createNewFile();
        junit.framework.TestCase.assertTrue("Copy1.txt doesn\'t exist to delete", destination.exists());
        org.apache.commons.io.FileUtils.forceDelete(destination);
        junit.framework.TestCase.assertTrue("Check No Exist", !(destination.exists()));
    }

    public void ap() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "copy2.txt");
        destination.createNewFile();
        junit.framework.TestCase.assertTrue("Copy2.txt doesn\'t exist to delete", destination.exists());
        org.apache.commons.io.FileUtils.forceDelete(destination);
        junit.framework.TestCase.assertTrue("Check No Exist", !(destination.exists()));
    }

    public void aq() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "no_such_file");
        junit.framework.TestCase.assertTrue("Check No Exist", !(destination.exists()));
        try {
            org.apache.commons.io.FileUtils.forceDelete(destination);
            junit.framework.TestCase.fail("Should generate FileNotFoundException");
        } catch (final java.io.FileNotFoundException ignored) {
        }
    }

    public void w() throws java.lang.Exception {
        final java.io.File directory = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "subdir");
        if (!(directory.exists())) {
            directory.mkdirs();
        } 
        final java.io.File destination = new java.io.File(directory , testFile1.getName());
        org.apache.commons.io.FileUtils.copyFileToDirectory(testFile1, directory);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertEquals("Check Full copy", testFile1Size, destination.length());
        try {
            org.apache.commons.io.FileUtils.copyFileToDirectory(destination, directory);
            junit.framework.TestCase.fail("Should not be able to copy a file into the same directory as itself");
        } catch (final java.io.IOException ioe) {
        }
    }

    public void y() throws java.lang.Exception {
        final java.io.File directory = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "subdir");
        if (!(directory.exists())) {
            directory.mkdirs();
        } 
        final java.io.File destination = new java.io.File(directory , testFile1.getName());
        org.apache.commons.io.FileUtils.copyFileToDirectory(testFile1, directory);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertEquals("Check Full copy", testFile2Size, destination.length());
    }

    public void ar() throws java.lang.Exception {
        final java.io.File testDirectory = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        org.apache.commons.io.FileUtils.forceDelete(testDirectory.getParentFile());
        junit.framework.TestCase.assertTrue("Check No Exist", !(testDirectory.getParentFile().exists()));
    }

    public void an() throws java.lang.Exception {
        final java.io.File file1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test.txt");
        final java.lang.String filename = file1.getAbsolutePath();
        final java.io.OutputStream out = new java.io.FileOutputStream(file1);
        try {
            out.write("This is a test".getBytes("UTF-8"));
        } finally {
            out.close();
        }
        final java.io.File file2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "test2.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file2, filename, "UTF-8");
        junit.framework.TestCase.assertTrue(file2.exists());
        junit.framework.TestCase.assertTrue(((file2.length()) > 0));
        final java.lang.String file2contents = org.apache.commons.io.FileUtils.readFileToString(file2, "UTF-8");
        junit.framework.TestCase.assertTrue("Second file\'s contents correct", filename.equals(file2contents));
        junit.framework.TestCase.assertTrue(file2.delete());
        final java.lang.String contents = org.apache.commons.io.FileUtils.readFileToString(new java.io.File(filename), "UTF-8");
        junit.framework.TestCase.assertEquals("FileUtils.fileRead()", "This is a test", contents);
    }

    public void cq() throws java.io.IOException {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "touch.txt");
        if (file.exists()) {
            file.delete();
        } 
        junit.framework.TestCase.assertTrue("Bad test: test file still exists", !(file.exists()));
        org.apache.commons.io.FileUtils.touch(file);
        junit.framework.TestCase.assertTrue("FileUtils.touch() created file", file.exists());
        final java.io.FileOutputStream out = new java.io.FileOutputStream(file);
        junit.framework.TestCase.assertEquals("Created empty file.", 0, file.length());
        out.write(0);
        out.close();
        junit.framework.TestCase.assertEquals("Wrote one byte to file", 1, file.length());
        final long y2k = new java.util.GregorianCalendar(2000 , 0 , 1).getTime().getTime();
        final boolean res = file.setLastModified(y2k);
        junit.framework.TestCase.assertEquals("Bad test: set lastModified failed", true, res);
        junit.framework.TestCase.assertEquals("Bad test: set lastModified set incorrect value", y2k, file.lastModified());
        final long now = java.lang.System.currentTimeMillis();
        org.apache.commons.io.FileUtils.touch(file);
        junit.framework.TestCase.assertEquals("FileUtils.touch() didn\'t empty the file.", 1, file.length());
        junit.framework.TestCase.assertEquals("FileUtils.touch() changed lastModified", false, (y2k == (file.lastModified())));
        junit.framework.TestCase.assertEquals("FileUtils.touch() changed lastModified to more than now-3s", true, ((file.lastModified()) >= (now - 3000)));
        junit.framework.TestCase.assertEquals("FileUtils.touch() changed lastModified to less than now+3s", true, ((file.lastModified()) <= (now + 3000)));
    }

    public void bg() throws java.lang.Exception {
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(srcDir , "list_test");
        subDir.mkdir();
        final java.io.File subDir2 = new java.io.File(subDir , "subdir");
        subDir2.mkdir();
        final java.lang.String[] fileNames = new java.lang.String[]{ "a.txt" , "b.txt" , "c.txt" , "d.txt" , "e.txt" , "f.txt" };
        final int[] fileSizes = new int[]{ 123 , 234 , 345 , 456 , 678 , 789 };
        for (int i = 0 ; i < (fileNames.length) ; ++i) {
            final java.io.File theFile = new java.io.File(subDir , fileNames[i]);
            createFile(theFile, fileSizes[i]);
        }
        final java.util.Collection<java.io.File> files = org.apache.commons.io.FileUtils.listFiles(subDir, new org.apache.commons.io.filefilter.WildcardFileFilter("*.*"), new org.apache.commons.io.filefilter.WildcardFileFilter("*"));
        final int count = files.size();
        final java.lang.Object[] fileObjs = files.toArray();
        junit.framework.TestCase.assertEquals(fileNames.length, files.size());
        final java.util.Map<java.lang.String, java.lang.String> foundFileNames = new java.util.HashMap<java.lang.String, java.lang.String>();
        for (int i = 0 ; i < count ; ++i) {
            boolean found = false;
            for (int j = 0 ; (!found) && (j < (fileNames.length)) ; ++j) {
                if (fileNames[j].equals(((java.io.File)(fileObjs[i])).getName())) {
                    foundFileNames.put(fileNames[j], fileNames[j]);
                    found = true;
                } 
            }
        }
        junit.framework.TestCase.assertEquals(foundFileNames.size(), fileNames.length);
        subDir.delete();
    }

    public void bh() throws java.io.IOException {
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir1 = new java.io.File(srcDir , "subdir");
        subDir1.mkdir();
        final java.io.File subDir2 = new java.io.File(subDir1 , "subdir2");
        subDir2.mkdir();
        final java.io.File someFile = new java.io.File(subDir2 , "a.txt");
        createFile(someFile, 100);
        final java.io.File subDir3 = new java.io.File(subDir2 , "subdir3");
        subDir3.mkdir();
        final java.util.Collection<java.io.File> files = org.apache.commons.io.FileUtils.listFilesAndDirs(subDir1, new org.apache.commons.io.filefilter.WildcardFileFilter("*.*"), new org.apache.commons.io.filefilter.WildcardFileFilter("*"));
        junit.framework.TestCase.assertEquals(4, files.size());
        junit.framework.TestCase.assertTrue("Should contain the directory.", files.contains(subDir1));
        junit.framework.TestCase.assertTrue("Should contain the directory.", files.contains(subDir2));
        junit.framework.TestCase.assertTrue("Should contain the file.", files.contains(someFile));
        junit.framework.TestCase.assertTrue("Should contain the directory.", files.contains(subDir3));
        subDir1.delete();
    }

    public void be() throws java.lang.Exception {
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir = new java.io.File(srcDir , "list_test");
        subDir.mkdir();
        final java.lang.String[] fileNames = new java.lang.String[]{ "a.txt" , "b.txt" , "c.txt" , "d.txt" , "e.txt" , "f.txt" };
        final int[] fileSizes = new int[]{ 123 , 234 , 345 , 456 , 678 , 789 };
        for (int i = 0 ; i < (fileNames.length) ; ++i) {
            final java.io.File theFile = new java.io.File(subDir , fileNames[i]);
            createFile(theFile, fileSizes[i]);
        }
        final java.util.Iterator<java.io.File> files = org.apache.commons.io.FileUtils.iterateFiles(subDir, new org.apache.commons.io.filefilter.WildcardFileFilter("*.*"), new org.apache.commons.io.filefilter.WildcardFileFilter("*"));
        final java.util.Map<java.lang.String, java.lang.String> foundFileNames = new java.util.HashMap<java.lang.String, java.lang.String>();
        while (files.hasNext()) {
            boolean found = false;
            final java.lang.String fileName = files.next().getName();
            for (int j = 0 ; (!found) && (j < (fileNames.length)) ; ++j) {
                if (fileNames[j].equals(fileName)) {
                    foundFileNames.put(fileNames[j], fileNames[j]);
                    found = true;
                } 
            }
        }
        junit.framework.TestCase.assertEquals(foundFileNames.size(), fileNames.length);
        subDir.delete();
    }

    public void bf() throws java.io.IOException {
        final java.io.File srcDir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File subDir1 = new java.io.File(srcDir , "subdir");
        subDir1.mkdir();
        final java.io.File subDir2 = new java.io.File(subDir1 , "subdir2");
        subDir2.mkdir();
        final java.io.File someFile = new java.io.File(subDir2 , "a.txt");
        createFile(someFile, 100);
        final java.io.File subDir3 = new java.io.File(subDir2 , "subdir3");
        subDir3.mkdir();
        final java.util.Collection<java.io.File> filesAndDirs = java.util.Arrays.asList(subDir1, subDir2, someFile, subDir3);
        int filesCount = 0;
        final java.util.Iterator<java.io.File> files = org.apache.commons.io.FileUtils.iterateFilesAndDirs(subDir1, new org.apache.commons.io.filefilter.WildcardFileFilter("*.*"), new org.apache.commons.io.filefilter.WildcardFileFilter("*"));
        while (files.hasNext()) {
            filesCount++;
            final java.io.File file = files.next();
            junit.framework.TestCase.assertTrue("Should contain the directory/file", filesAndDirs.contains(file));
        }
        junit.framework.TestCase.assertEquals(filesCount, filesAndDirs.size());
    }

    public void bw() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "read.obj");
        final java.io.FileOutputStream out = new java.io.FileOutputStream(file);
        final byte[] text = "Hello /u1234".getBytes();
        out.write(text);
        out.close();
        final java.lang.String data = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals("Hello /u1234", data);
    }

    public void bx() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "read.obj");
        final java.io.FileOutputStream out = new java.io.FileOutputStream(file);
        final byte[] text = "Hello /u1234".getBytes("UTF8");
        out.write(text);
        out.close();
        final java.lang.String data = org.apache.commons.io.FileUtils.readFileToString(file, "UTF8");
        junit.framework.TestCase.assertEquals("Hello /u1234", data);
    }

    public void bv() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "read.txt");
        final java.io.FileOutputStream out = new java.io.FileOutputStream(file);
        out.write(11);
        out.write(21);
        out.write(31);
        out.close();
        final byte[] data = org.apache.commons.io.FileUtils.readFileToByteArray(file);
        junit.framework.TestCase.assertEquals(3, data.length);
        junit.framework.TestCase.assertEquals(11, data[0]);
        junit.framework.TestCase.assertEquals(21, data[1]);
        junit.framework.TestCase.assertEquals(31, data[2]);
    }

    public void by() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        try {
            final java.lang.String[] data = new java.lang.String[]{ "hello" , "/u1234" , "" , "this is" , "some text" };
            createLineBasedFile(file, data);
            final java.util.List<java.lang.String> lines = org.apache.commons.io.FileUtils.readLines(file, "UTF-8");
            junit.framework.TestCase.assertEquals(java.util.Arrays.asList(data), lines);
        } finally {
            deleteFile(file);
        }
    }

    public void dl() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "Hello /u1234", "UTF8");
        final byte[] text = "Hello /u1234".getBytes("UTF8");
        assertEqualContent(text, file);
    }

    public void dm() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "Hello /u1234", ((java.lang.String)(null)));
        final byte[] text = "Hello /u1234".getBytes();
        assertEqualContent(text, file);
    }

    public void dn() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "Hello /u1234", ((java.nio.charset.Charset)(null)));
        final byte[] text = "Hello /u1234".getBytes();
        assertEqualContent(text, file);
    }

    public void cx() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.txt");
        org.apache.commons.io.FileUtils.write(file, "Hello /u1234", "UTF8");
        final byte[] text = "Hello /u1234".getBytes("UTF8");
        assertEqualContent(text, file);
    }

    public void cy() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.txt");
        org.apache.commons.io.FileUtils.write(file, "Hello /u1234", ((java.lang.String)(null)));
        final byte[] text = "Hello /u1234".getBytes();
        assertEqualContent(text, file);
    }

    public void cr() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.obj");
        final byte[] data = new byte[]{ 11 , 21 , 31 };
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data);
        assertEqualContent(data, file);
    }

    public void cu() throws java.lang.Exception {
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "write.obj");
        final byte[] data = new byte[]{ 11 , 21 , 32 , 41 , 51 };
        final byte[] writtenData = new byte[3];
        java.lang.System.arraycopy(data, 1, writtenData, 0, 3);
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, 1, 3);
        assertEqualContent(writtenData, file);
    }

    public void de() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeLines(file, "US-ASCII", list, "*");
        final java.lang.String expected = "hello*world**this is**some text*";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file, "US-ASCII");
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void df() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeLines(file, "US-ASCII", null, "*");
        junit.framework.TestCase.assertEquals("Sizes differ", 0, file.length());
    }

    public void dg() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeLines(file, "US-ASCII", list, null);
        final java.lang.String expected = (((((((("hello" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "world") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "this is") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "some text") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file, "US-ASCII");
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void db() throws java.lang.Exception {
        final java.lang.Object[] data = new java.lang.Object[]{ "hello" , new java.lang.StringBuffer("world") , "" , "this is" , null , "some text" };
        final java.util.List<java.lang.Object> list = java.util.Arrays.asList(data);
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeLines(file, "US-ASCII", list);
        final java.lang.String expected = (((((((("hello" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "world") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "this is") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "some text") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file, "US-ASCII");
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dk() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, null, linesToAppend, null, true);
        final java.lang.String expected = ((("This line was there before you..." + "my first line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dj() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, null, linesToAppend, null, false);
        final java.lang.String expected = (("my first line" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void di() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, linesToAppend, null, true);
        final java.lang.String expected = ((("This line was there before you..." + "my first line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dh() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, linesToAppend, null, false);
        final java.lang.String expected = (("my first line" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void da() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, null, linesToAppend, true);
        final java.lang.String expected = ((("This line was there before you..." + "my first line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void cz() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, null, linesToAppend, false);
        final java.lang.String expected = (("my first line" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dd() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, linesToAppend, true);
        final java.lang.String expected = ((("This line was there before you..." + "my first line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dc() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final java.util.List<java.lang.String> linesToAppend = java.util.Arrays.asList("my first line", "The second Line");
        org.apache.commons.io.FileUtils.writeLines(file, linesToAppend, false);
        final java.lang.String expected = (("my first line" + (org.apache.commons.io.IOUtils.LINE_SEPARATOR)) + "The second Line") + (org.apache.commons.io.IOUtils.LINE_SEPARATOR);
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dq() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "this is brand new data", ((java.lang.String)(null)), true);
        final java.lang.String expected = "This line was there before you..." + "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dp() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "this is brand new data", ((java.lang.String)(null)), false);
        final java.lang.String expected = "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void ds() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "this is brand new data", true);
        final java.lang.String expected = "This line was there before you..." + "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dr() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "this is brand new data", false);
        final java.lang.String expected = "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void du() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.write(file, "this is brand new data", ((java.lang.String)(null)), true);
        final java.lang.String expected = "This line was there before you..." + "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dt() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.write(file, "this is brand new data", ((java.lang.String)(null)), false);
        final java.lang.String expected = "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dw() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.write(file, "this is brand new data", true);
        final java.lang.String expected = "This line was there before you..." + "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void dv() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.write(file, "this is brand new data", false);
        final java.lang.String expected = "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void ct() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, "this is brand new data".getBytes(), true);
        final java.lang.String expected = "This line was there before you..." + "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void cs() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, "this is brand new data".getBytes(), false);
        final java.lang.String expected = "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void cw() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final byte[] data = "SKIP_THIS_this is brand new data_AND_SKIP_THIS".getBytes(org.apache.commons.io.Charsets.UTF_8);
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, 10, 22, true);
        final java.lang.String expected = "This line was there before you..." + "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file, org.apache.commons.io.Charsets.UTF_8);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void cv() throws java.lang.Exception {
        final java.io.File file = newFile("lines.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, "This line was there before you...");
        final byte[] data = "SKIP_THIS_this is brand new data_AND_SKIP_THIS".getBytes(org.apache.commons.io.Charsets.UTF_8);
        org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, 10, 22, false);
        final java.lang.String expected = "this is brand new data";
        final java.lang.String actual = org.apache.commons.io.FileUtils.readFileToString(file, org.apache.commons.io.Charsets.UTF_8);
        junit.framework.TestCase.assertEquals(expected, actual);
    }

    public void e() throws java.lang.Exception {
        final java.lang.String text = "Imagination is more important than knowledge - Einstein";
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "checksum-test.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, text, "US-ASCII");
        final java.util.zip.Checksum expectedChecksum = new java.util.zip.CRC32();
        expectedChecksum.update(text.getBytes("US-ASCII"), 0, text.length());
        final long expectedValue = expectedChecksum.getValue();
        final long resultValue = org.apache.commons.io.FileUtils.checksumCRC32(file);
        junit.framework.TestCase.assertEquals(expectedValue, resultValue);
    }

    public void d() throws java.lang.Exception {
        final java.lang.String text = "Imagination is more important than knowledge - Einstein";
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "checksum-test.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, text, "US-ASCII");
        final java.util.zip.Checksum expectedChecksum = new java.util.zip.CRC32();
        expectedChecksum.update(text.getBytes("US-ASCII"), 0, text.length());
        final long expectedValue = expectedChecksum.getValue();
        final java.util.zip.Checksum testChecksum = new java.util.zip.CRC32();
        final java.util.zip.Checksum resultChecksum = org.apache.commons.io.FileUtils.checksum(file, testChecksum);
        final long resultValue = resultChecksum.getValue();
        junit.framework.TestCase.assertSame(testChecksum, resultChecksum);
        junit.framework.TestCase.assertEquals(expectedValue, resultValue);
    }

    public void i() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.checksum(null, new java.util.zip.CRC32());
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void h() throws java.lang.Exception {
        final java.lang.String text = "Imagination is more important than knowledge - Einstein";
        final java.io.File file = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "checksum-test.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file, text, "US-ASCII");
        try {
            org.apache.commons.io.FileUtils.checksum(file, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void g() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.checksum(new java.io.File("."), new java.util.zip.CRC32());
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void f() throws java.lang.Exception {
        final java.lang.String text1 = "Imagination is more important than knowledge - Einstein";
        final java.io.File file1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "checksum-test.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file1, text1, "US-ASCII");
        final java.lang.String text2 = "To be or not to be - Shakespeare";
        final java.io.File file2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "checksum-test2.txt");
        org.apache.commons.io.FileUtils.writeStringToFile(file2, text2, "US-ASCII");
        final java.util.zip.Checksum expectedChecksum = new java.util.zip.CRC32();
        expectedChecksum.update(text1.getBytes("US-ASCII"), 0, text1.length());
        expectedChecksum.update(text2.getBytes("US-ASCII"), 0, text2.length());
        final long expectedValue = expectedChecksum.getValue();
        final java.util.zip.Checksum testChecksum = new java.util.zip.CRC32();
        org.apache.commons.io.FileUtils.checksum(file1, testChecksum);
        org.apache.commons.io.FileUtils.checksum(file2, testChecksum);
        final long resultValue = testChecksum.getValue();
        junit.framework.TestCase.assertEquals(expectedValue, resultValue);
    }

    public void ai() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(testFile1);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void al() {
        try {
            org.apache.commons.io.FileUtils.deleteQuietly(null);
        } catch (final java.lang.Exception ex) {
            junit.framework.TestCase.fail(ex.getMessage());
        }
    }

    public void aj() throws java.io.IOException {
        final java.io.File testDirectory = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testDeleteQuietlyDir");
        final java.io.File testFile = new java.io.File(testDirectory , "testDeleteQuietlyFile");
        testDirectory.mkdirs();
        createFile(testFile, 0);
        junit.framework.TestCase.assertTrue(testDirectory.exists());
        junit.framework.TestCase.assertTrue(testFile.exists());
        org.apache.commons.io.FileUtils.deleteQuietly(testDirectory);
        junit.framework.TestCase.assertFalse("Check No Exist", testDirectory.exists());
        junit.framework.TestCase.assertFalse("Check No Exist", testFile.exists());
    }

    public void ak() throws java.io.IOException {
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testDeleteQuietlyFile");
        createFile(testFile, 0);
        junit.framework.TestCase.assertTrue(testFile.exists());
        org.apache.commons.io.FileUtils.deleteQuietly(testFile);
        junit.framework.TestCase.assertFalse("Check No Exist", testFile.exists());
    }

    public void am() {
        final java.io.File testFile = new java.io.File("testDeleteQuietlyNonExistent");
        junit.framework.TestCase.assertFalse(testFile.exists());
        try {
            org.apache.commons.io.FileUtils.deleteQuietly(testFile);
        } catch (final java.lang.Exception ex) {
            junit.framework.TestCase.fail(ex.getMessage());
        }
    }

    public void bs() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "move1.txt");
        org.apache.commons.io.FileUtils.moveFile(testFile1, destination);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertTrue("Original deleted", !(testFile1.exists()));
    }

    public void bp() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "move2.txt");
        final java.io.File src = new java.io.File(testFile1.getAbsolutePath()) {
            private static final long serialVersionUID = 1L;

            @java.lang.Override
            public boolean renameTo(final java.io.File f) {
                return false;
            }
        };
        org.apache.commons.io.FileUtils.moveFile(src, destination);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertTrue("Original deleted", !(src.exists()));
    }

    public void bq() throws java.lang.Exception {
        final java.io.File destination = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "move3.txt");
        final java.io.File src = new java.io.File(testFile1.getAbsolutePath()) {
            private static final long serialVersionUID = 1L;

            @java.lang.Override
            public boolean renameTo(final java.io.File f) {
                return false;
            }

            @java.lang.Override
            public boolean delete() {
                return false;
            }
        };
        try {
            org.apache.commons.io.FileUtils.moveFile(src, destination);
            junit.framework.TestCase.fail("move should have failed as src has not been deleted");
        } catch (final java.io.IOException e) {
            junit.framework.TestCase.assertTrue("Check Rollback", !(destination.exists()));
            junit.framework.TestCase.assertTrue("Original exists", src.exists());
        }
    }

    public void br() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.moveFile(null, new java.io.File("foo"));
            junit.framework.TestCase.fail("Expected NullPointerException when source is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveFile(new java.io.File("foo"), null);
            junit.framework.TestCase.fail("Expected NullPointerException when destination is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveFile(new java.io.File("nonexistant"), new java.io.File("foo"));
            junit.framework.TestCase.fail("Expected FileNotFoundException for source");
        } catch (final java.io.FileNotFoundException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveFile(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory(), new java.io.File("foo"));
            junit.framework.TestCase.fail("Expected IOException when source is a directory");
        } catch (final java.io.IOException e) {
        }
        final java.io.File testSourceFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileSource");
        final java.io.File testDestFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileSource");
        createFile(testSourceFile, 0);
        createFile(testDestFile, 0);
        try {
            org.apache.commons.io.FileUtils.moveFile(testSourceFile, testDestFile);
            junit.framework.TestCase.fail("Expected FileExistsException when dest already exists");
        } catch (final org.apache.commons.io.FileExistsException e) {
        }
    }

    public void bn() throws java.lang.Exception {
        final java.io.File destDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "moveFileDestDir");
        final java.io.File movedFile = new java.io.File(destDir , testFile1.getName());
        junit.framework.TestCase.assertFalse("Check Exist before", destDir.exists());
        junit.framework.TestCase.assertFalse("Check Exist before", movedFile.exists());
        org.apache.commons.io.FileUtils.moveFileToDirectory(testFile1, destDir, true);
        junit.framework.TestCase.assertTrue("Check Exist after", movedFile.exists());
        junit.framework.TestCase.assertTrue("Original deleted", !(testFile1.exists()));
    }

    public void bo() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(null, new java.io.File("foo"), true);
            junit.framework.TestCase.fail("Expected NullPointerException when source is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(new java.io.File("foo"), null, true);
            junit.framework.TestCase.fail("Expected NullPointerException when destination is null");
        } catch (final java.lang.NullPointerException e) {
        }
        final java.io.File testFile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileFile1");
        final java.io.File testFile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileFile2");
        createFile(testFile1, 0);
        createFile(testFile2, 0);
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(testFile1, testFile2, true);
            junit.framework.TestCase.fail("Expected IOException when dest not a directory");
        } catch (final java.io.IOException e) {
        }
        final java.io.File nonexistant = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileNonExistant");
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(testFile1, nonexistant, false);
            junit.framework.TestCase.fail("Expected IOException when dest does not exist and create=false");
        } catch (final java.io.IOException e) {
        }
    }

    public void bm() throws java.lang.Exception {
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File src = new java.io.File(dir , "testMoveDirectory1Source");
        final java.io.File testDir = new java.io.File(src , "foo");
        final java.io.File testFile = new java.io.File(testDir , "bar");
        testDir.mkdirs();
        createFile(testFile, 0);
        final java.io.File destination = new java.io.File(dir , "testMoveDirectory1Dest");
        org.apache.commons.io.FileUtils.deleteDirectory(destination);
        org.apache.commons.io.FileUtils.moveDirectory(src, destination);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertTrue("Original deleted", !(src.exists()));
        final java.io.File movedDir = new java.io.File(destination , testDir.getName());
        final java.io.File movedFile = new java.io.File(movedDir , testFile.getName());
        junit.framework.TestCase.assertTrue("Check dir moved", movedDir.exists());
        junit.framework.TestCase.assertTrue("Check file moved", movedFile.exists());
    }

    public void bk() throws java.lang.Exception {
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File src = new java.io.File(dir, "testMoveDirectory2Source") {
            private static final long serialVersionUID = 1L;

            @java.lang.Override
            public boolean renameTo(final java.io.File dest) {
                return false;
            }
        };
        final java.io.File testDir = new java.io.File(src , "foo");
        final java.io.File testFile = new java.io.File(testDir , "bar");
        testDir.mkdirs();
        createFile(testFile, 0);
        final java.io.File destination = new java.io.File(dir , "testMoveDirectory1Dest");
        org.apache.commons.io.FileUtils.deleteDirectory(destination);
        org.apache.commons.io.FileUtils.moveDirectory(src, destination);
        junit.framework.TestCase.assertTrue("Check Exist", destination.exists());
        junit.framework.TestCase.assertTrue("Original deleted", !(src.exists()));
        final java.io.File movedDir = new java.io.File(destination , testDir.getName());
        final java.io.File movedFile = new java.io.File(movedDir , testFile.getName());
        junit.framework.TestCase.assertTrue("Check dir moved", movedDir.exists());
        junit.framework.TestCase.assertTrue("Check file moved", movedFile.exists());
    }

    public void bl() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.moveDirectory(null, new java.io.File("foo"));
            junit.framework.TestCase.fail("Expected NullPointerException when source is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveDirectory(new java.io.File("foo"), null);
            junit.framework.TestCase.fail("Expected NullPointerException when destination is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveDirectory(new java.io.File("nonexistant"), new java.io.File("foo"));
            junit.framework.TestCase.fail("Expected FileNotFoundException for source");
        } catch (final java.io.FileNotFoundException e) {
        }
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveDirectoryFile");
        createFile(testFile, 0);
        try {
            org.apache.commons.io.FileUtils.moveDirectory(testFile, new java.io.File("foo"));
            junit.framework.TestCase.fail("Expected IOException when source is not a directory");
        } catch (final java.io.IOException e) {
        }
        final java.io.File testSrcFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveDirectorySource");
        final java.io.File testDestFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveDirectoryDest");
        testSrcFile.mkdir();
        testDestFile.mkdir();
        try {
            org.apache.commons.io.FileUtils.moveDirectory(testSrcFile, testDestFile);
            junit.framework.TestCase.fail("Expected FileExistsException when dest already exists");
        } catch (final org.apache.commons.io.FileExistsException e) {
        }
    }

    public void bi() throws java.lang.Exception {
        final java.io.File dir = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File src = new java.io.File(dir , "testMoveDirectory1Source");
        final java.io.File testChildDir = new java.io.File(src , "foo");
        final java.io.File testFile = new java.io.File(testChildDir , "bar");
        testChildDir.mkdirs();
        createFile(testFile, 0);
        final java.io.File destDir = new java.io.File(dir , "testMoveDirectory1Dest");
        org.apache.commons.io.FileUtils.deleteDirectory(destDir);
        junit.framework.TestCase.assertFalse("Check Exist before", destDir.exists());
        org.apache.commons.io.FileUtils.moveDirectoryToDirectory(src, destDir, true);
        junit.framework.TestCase.assertTrue("Check Exist after", destDir.exists());
        junit.framework.TestCase.assertTrue("Original deleted", !(src.exists()));
        final java.io.File movedDir = new java.io.File(destDir , src.getName());
        final java.io.File movedChildDir = new java.io.File(movedDir , testChildDir.getName());
        final java.io.File movedFile = new java.io.File(movedChildDir , testFile.getName());
        junit.framework.TestCase.assertTrue("Check dir moved", movedDir.exists());
        junit.framework.TestCase.assertTrue("Check child dir moved", movedChildDir.exists());
        junit.framework.TestCase.assertTrue("Check file moved", movedFile.exists());
    }

    public void bj() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(null, new java.io.File("foo"), true);
            junit.framework.TestCase.fail("Expected NullPointerException when source is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(new java.io.File("foo"), null, true);
            junit.framework.TestCase.fail("Expected NullPointerException when destination is null");
        } catch (final java.lang.NullPointerException e) {
        }
        final java.io.File testFile1 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileFile1");
        final java.io.File testFile2 = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileFile2");
        createFile(testFile1, 0);
        createFile(testFile2, 0);
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(testFile1, testFile2, true);
            junit.framework.TestCase.fail("Expected IOException when dest not a directory");
        } catch (final java.io.IOException e) {
        }
        final java.io.File nonexistant = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveFileNonExistant");
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(testFile1, nonexistant, false);
            junit.framework.TestCase.fail("Expected IOException when dest does not exist and create=false");
        } catch (final java.io.IOException e) {
        }
    }

    public void bt() throws java.lang.Exception {
        final java.io.File destDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveToDirectoryDestDir");
        final java.io.File testDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveToDirectoryTestDir");
        final java.io.File testFile = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "testMoveToDirectoryTestFile");
        testDir.mkdirs();
        createFile(testFile, 0);
        final java.io.File movedFile = new java.io.File(destDir , testFile.getName());
        final java.io.File movedDir = new java.io.File(destDir , testFile.getName());
        junit.framework.TestCase.assertFalse("Check File Doesnt exist", movedFile.exists());
        junit.framework.TestCase.assertFalse("Check Dir Doesnt exist", movedDir.exists());
        org.apache.commons.io.FileUtils.moveToDirectory(testFile, destDir, true);
        junit.framework.TestCase.assertTrue("Check File exists", movedFile.exists());
        junit.framework.TestCase.assertFalse("Check Original File doesn\'t exist", testFile.exists());
        org.apache.commons.io.FileUtils.moveToDirectory(testDir, destDir, true);
        junit.framework.TestCase.assertTrue("Check Dir exists", movedDir.exists());
        junit.framework.TestCase.assertFalse("Check Original Dir doesn\'t exist", testDir.exists());
    }

    public void bu() throws java.lang.Exception {
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(null, new java.io.File("foo"), true);
            junit.framework.TestCase.fail("Expected NullPointerException when source is null");
        } catch (final java.lang.NullPointerException e) {
        }
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(new java.io.File("foo"), null, true);
            junit.framework.TestCase.fail("Expected NullPointerException when destination is null");
        } catch (final java.lang.NullPointerException e) {
        }
        final java.io.File nonexistant = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "nonexistant");
        final java.io.File destDir = new java.io.File(org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory() , "MoveToDirectoryDestDir");
        try {
            org.apache.commons.io.FileUtils.moveToDirectory(nonexistant, destDir, true);
            junit.framework.TestCase.fail("Expected IOException when source does not exist");
        } catch (final java.io.IOException e) {
        }
    }

    public void bb() throws java.lang.Exception {
        final java.io.File testDirectory = org.apache.commons.io.testtools.FileBasedTestCase.getTestDirectory();
        final java.io.File src = new java.io.File(testDirectory , "dir1");
        final java.io.File dest = new java.io.File(src , "dir2");
        junit.framework.TestCase.assertTrue(dest.mkdirs());
        junit.framework.TestCase.assertTrue(src.exists());
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(src, dest, false);
            junit.framework.TestCase.fail("expected IOException");
        } catch (final java.io.IOException ioe) {
        }
        junit.framework.TestCase.assertTrue(src.exists());
    }

    public void ba() throws java.lang.Exception {
        final java.io.File dir = new java.io.File("target" , "IO276");
        junit.framework.TestCase.assertTrue((dir + " should not be present"), dir.mkdirs());
        final java.io.File file = new java.io.File(dir , "IO276.txt");
        junit.framework.TestCase.assertTrue((file + " should not be present"), file.createNewFile());
        org.apache.commons.io.FileUtils.forceDeleteOnExit(dir);
    }

    private static class ShorterFile extends java.io.File {
        private static final long serialVersionUID = 1L;

        public ShorterFile(java.lang.String pathname) {
            super(pathname);
        }

        @java.lang.Override
        public long length() {
            return (super.length()) - 1;
        }
    }

    public void bc() throws java.lang.Exception {
        java.io.File inFile = new java.io.File("pom.xml");
        java.io.File outFile = new org.apache.commons.io.FileUtilsTestCase.ShorterFile("target/pom.tmp");
        try {
            org.apache.commons.io.FileUtils.copyFile(inFile, outFile);
            junit.framework.TestCase.fail("Expected IOException");
        } catch (java.lang.Exception e) {
            final java.lang.String msg = e.toString();
            junit.framework.TestCase.assertTrue(msg, msg.contains("Failed to copy full contents"));
        } finally {
            outFile.delete();
        }
    }

    static class ListDirectoryWalker extends org.apache.commons.io.DirectoryWalker<java.io.File> {
        ListDirectoryWalker() {
            super();
        }

        java.util.List<java.io.File> a(final java.io.File startDirectory) throws java.io.IOException {
            final java.util.ArrayList<java.io.File> files = new java.util.ArrayList<java.io.File>();
            walk(startDirectory, files);
            return files;
        }

        @java.lang.Override
        protected void e(final java.io.File directory, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            if (depth > 0) {
                results.add(directory);
            } 
        }

        @java.lang.Override
        protected void f(final java.io.File file, final int depth, final java.util.Collection<java.io.File> results) throws java.io.IOException {
            results.add(file);
        }
    }
}


package org.apache.commons.io;


public class IOCaseTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final boolean WINDOWS = (java.io.File.separatorChar) == '\\';

    public IOCaseTestCase(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    protected void setUp() throws java.lang.Exception {
    }

    @java.lang.Override
    protected void tearDown() throws java.lang.Exception {
    }

    public void k() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(org.apache.commons.io.IOCase.SENSITIVE, org.apache.commons.io.IOCase.forName("Sensitive"));
        junit.framework.TestCase.assertEquals(org.apache.commons.io.IOCase.INSENSITIVE, org.apache.commons.io.IOCase.forName("Insensitive"));
        junit.framework.TestCase.assertEquals(org.apache.commons.io.IOCase.SYSTEM, org.apache.commons.io.IOCase.forName("System"));
        try {
            org.apache.commons.io.IOCase.forName("Blah");
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
        try {
            org.apache.commons.io.IOCase.forName(null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.IllegalArgumentException ex) {
        }
    }

    public void n() throws java.lang.Exception {
        junit.framework.TestCase.assertSame(org.apache.commons.io.IOCase.SENSITIVE, serialize(org.apache.commons.io.IOCase.SENSITIVE));
        junit.framework.TestCase.assertSame(org.apache.commons.io.IOCase.INSENSITIVE, serialize(org.apache.commons.io.IOCase.INSENSITIVE));
        junit.framework.TestCase.assertSame(org.apache.commons.io.IOCase.SYSTEM, serialize(org.apache.commons.io.IOCase.SYSTEM));
    }

    public void l() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals("Sensitive", org.apache.commons.io.IOCase.SENSITIVE.getName());
        junit.framework.TestCase.assertEquals("Insensitive", org.apache.commons.io.IOCase.INSENSITIVE.getName());
        junit.framework.TestCase.assertEquals("System", org.apache.commons.io.IOCase.SYSTEM.getName());
    }

    public void o() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals("Sensitive", org.apache.commons.io.IOCase.SENSITIVE.toString());
        junit.framework.TestCase.assertEquals("Insensitive", org.apache.commons.io.IOCase.INSENSITIVE.toString());
        junit.framework.TestCase.assertEquals("System", org.apache.commons.io.IOCase.SYSTEM.toString());
    }

    public void m() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.isCaseSensitive());
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.INSENSITIVE.isCaseSensitive());
        junit.framework.TestCase.assertEquals(!(WINDOWS), org.apache.commons.io.IOCase.SYSTEM.isCaseSensitive());
    }

    public void testGetPath_with_nullbyte() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(((org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("ABC", "")) > 0));
        junit.framework.TestCase.assertTrue(((org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("", "ABC")) < 0));
        junit.framework.TestCase.assertTrue(((org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("ABC", "DEF")) < 0));
        junit.framework.TestCase.assertTrue(((org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("DEF", "ABC")) > 0));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("ABC", "ABC"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("", ""));
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("ABC", null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo(null, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo(null, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void testCopyDirectoryToItself() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("ABC", "ABC"));
        junit.framework.TestCase.assertTrue(((org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("ABC", "abc")) < 0));
        junit.framework.TestCase.assertTrue(((org.apache.commons.io.IOCase.SENSITIVE.checkCompareTo("abc", "ABC")) > 0));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.INSENSITIVE.checkCompareTo("ABC", "ABC"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.INSENSITIVE.checkCompareTo("ABC", "abc"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.INSENSITIVE.checkCompareTo("abc", "ABC"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SYSTEM.checkCompareTo("ABC", "ABC"));
        junit.framework.TestCase.assertEquals(WINDOWS, ((org.apache.commons.io.IOCase.SYSTEM.checkCompareTo("ABC", "abc")) == 0));
        junit.framework.TestCase.assertEquals(WINDOWS, ((org.apache.commons.io.IOCase.SYSTEM.checkCompareTo("abc", "ABC")) == 0));
    }

    public void d() throws java.lang.Exception {
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "A"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "AB"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "ABC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "BC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "C"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "ABCD"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("", "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("", ""));
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkEquals(null, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkEquals(null, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void c() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "ABC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEquals("ABC", "Abc"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkEquals("ABC", "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkEquals("ABC", "Abc"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SYSTEM.checkEquals("ABC", "ABC"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.IOCase.SYSTEM.checkEquals("ABC", "Abc"));
    }

    public void j() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "A"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "AB"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "ABC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "BC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "C"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "ABCD"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("", "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("", ""));
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith(null, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith(null, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void i() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "AB"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkStartsWith("ABC", "Ab"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkStartsWith("ABC", "AB"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkStartsWith("ABC", "Ab"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SYSTEM.checkStartsWith("ABC", "AB"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.IOCase.SYSTEM.checkStartsWith("ABC", "Ab"));
    }

    public void b() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "A"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "AB"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "BC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "C"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "ABCD"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("", "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("", ""));
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith(null, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith(null, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void a() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "BC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkEndsWith("ABC", "Bc"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkEndsWith("ABC", "BC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkEndsWith("ABC", "Bc"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SYSTEM.checkEndsWith("ABC", "BC"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.IOCase.SYSTEM.checkEndsWith("ABC", "Bc"));
    }

    public void f() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "A"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 1, "A"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "AB"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 1, "AB"));
        junit.framework.TestCase.assertEquals(0, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "ABC"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 1, "ABC"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "D"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 3, "D"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 4, "D"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "DE"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 3, "DE"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 4, "DE"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "DEF"));
        junit.framework.TestCase.assertEquals(3, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 3, "DEF"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 4, "DEF"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "J"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 8, "J"));
        junit.framework.TestCase.assertEquals(9, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 9, "J"));
        junit.framework.TestCase.assertEquals(8, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "IJ"));
        junit.framework.TestCase.assertEquals(8, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 8, "IJ"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 9, "IJ"));
        junit.framework.TestCase.assertEquals(7, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 6, "HIJ"));
        junit.framework.TestCase.assertEquals(7, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 7, "HIJ"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 8, "HIJ"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABCDEFGHIJ", 0, "DED"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("DEF", 0, "ABCDEFGHIJ"));
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABC", 0, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf(null, 0, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf(null, 0, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void e() throws java.lang.Exception {
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABC", 0, "BC"));
        junit.framework.TestCase.assertEquals(-1, org.apache.commons.io.IOCase.SENSITIVE.checkIndexOf("ABC", 0, "Bc"));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.IOCase.INSENSITIVE.checkIndexOf("ABC", 0, "BC"));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.IOCase.INSENSITIVE.checkIndexOf("ABC", 0, "Bc"));
        junit.framework.TestCase.assertEquals(1, org.apache.commons.io.IOCase.SYSTEM.checkIndexOf("ABC", 0, "BC"));
        junit.framework.TestCase.assertEquals((WINDOWS ? 1 : -1), org.apache.commons.io.IOCase.SYSTEM.checkIndexOf("ABC", 0, "Bc"));
    }

    public void h() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "A"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "AB"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "ABC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "BC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "C"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "ABCD"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("", 0, "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("", 0, ""));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, ""));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, "A"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, "AB"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, "ABC"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, "BC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, "C"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, "ABCD"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("", 1, "ABC"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("", 1, ""));
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches(null, 0, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches(null, 0, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 1, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches(null, 1, "ABC");
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
        try {
            org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches(null, 1, null);
            junit.framework.TestCase.fail();
        } catch (final java.lang.NullPointerException ex) {
        }
    }

    public void g() throws java.lang.Exception {
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "AB"));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.IOCase.SENSITIVE.checkRegionMatches("ABC", 0, "Ab"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkRegionMatches("ABC", 0, "AB"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.INSENSITIVE.checkRegionMatches("ABC", 0, "Ab"));
        junit.framework.TestCase.assertTrue(org.apache.commons.io.IOCase.SYSTEM.checkRegionMatches("ABC", 0, "AB"));
        junit.framework.TestCase.assertEquals(WINDOWS, org.apache.commons.io.IOCase.SYSTEM.checkRegionMatches("ABC", 0, "Ab"));
    }

    private org.apache.commons.io.IOCase testCopyDirectoryToItself(final org.apache.commons.io.IOCase value) throws java.lang.Exception {
        final java.io.ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
        final java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(buf);
        out.writeObject(value);
        out.flush();
        out.close();
        final java.io.ByteArrayInputStream bufin = new java.io.ByteArrayInputStream(buf.toByteArray());
        final java.io.ObjectInputStream in = new java.io.ObjectInputStream(bufin);
        return ((org.apache.commons.io.IOCase)(in.readObject()));
    }
}


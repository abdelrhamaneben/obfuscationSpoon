package org.apache.commons.io;


public class ByteOrderMarkTestCase extends org.apache.commons.io.testtools.FileBasedTestCase {
    private static final org.apache.commons.io.ByteOrderMark TEST_BOM_1 = new org.apache.commons.io.ByteOrderMark("test1" , 1);

    private static final org.apache.commons.io.ByteOrderMark TEST_BOM_2 = new org.apache.commons.io.ByteOrderMark("test2" , 1 , 2);

    private static final org.apache.commons.io.ByteOrderMark TEST_BOM_3 = new org.apache.commons.io.ByteOrderMark("test3" , 1 , 2 , 3);

    public ByteOrderMarkTestCase(final java.lang.String name) {
        super(name);
    }

    public void a() {
        junit.framework.TestCase.assertEquals("test1 name", "test1", TEST_BOM_1.getCharsetName());
        junit.framework.TestCase.assertEquals("test2 name", "test2", TEST_BOM_2.getCharsetName());
        junit.framework.TestCase.assertEquals("test3 name", "test3", TEST_BOM_3.getCharsetName());
    }

    public void b() {
        junit.framework.TestCase.assertNotNull(java.nio.charset.Charset.forName(org.apache.commons.io.ByteOrderMark.UTF_8.getCharsetName()));
        junit.framework.TestCase.assertNotNull(java.nio.charset.Charset.forName(org.apache.commons.io.ByteOrderMark.UTF_16BE.getCharsetName()));
        junit.framework.TestCase.assertNotNull(java.nio.charset.Charset.forName(org.apache.commons.io.ByteOrderMark.UTF_16LE.getCharsetName()));
        junit.framework.TestCase.assertNotNull(java.nio.charset.Charset.forName(org.apache.commons.io.ByteOrderMark.UTF_32BE.getCharsetName()));
        junit.framework.TestCase.assertNotNull(java.nio.charset.Charset.forName(org.apache.commons.io.ByteOrderMark.UTF_32LE.getCharsetName()));
    }

    public void h() {
        junit.framework.TestCase.assertEquals("test1 length", 1, TEST_BOM_1.length());
        junit.framework.TestCase.assertEquals("test2 length", 2, TEST_BOM_2.length());
        junit.framework.TestCase.assertEquals("test3 length", 3, TEST_BOM_3.length());
    }

    public void e() {
        junit.framework.TestCase.assertEquals("test1 get(0)", 1, TEST_BOM_1.get(0));
        junit.framework.TestCase.assertEquals("test2 get(0)", 1, TEST_BOM_2.get(0));
        junit.framework.TestCase.assertEquals("test2 get(1)", 2, TEST_BOM_2.get(1));
        junit.framework.TestCase.assertEquals("test3 get(0)", 1, TEST_BOM_3.get(0));
        junit.framework.TestCase.assertEquals("test3 get(1)", 2, TEST_BOM_3.get(1));
        junit.framework.TestCase.assertEquals("test3 get(2)", 3, TEST_BOM_3.get(2));
    }

    public void f() {
        junit.framework.TestCase.assertTrue("test1 bytes", java.util.Arrays.equals(TEST_BOM_1.getBytes(), new byte[]{ ((byte)(1)) }));
        junit.framework.TestCase.assertTrue("test1 bytes", java.util.Arrays.equals(TEST_BOM_2.getBytes(), new byte[]{ ((byte)(1)) , ((byte)(2)) }));
        junit.framework.TestCase.assertTrue("test1 bytes", java.util.Arrays.equals(TEST_BOM_3.getBytes(), new byte[]{ ((byte)(1)) , ((byte)(2)) , ((byte)(3)) }));
    }

    public void c() {
        junit.framework.TestCase.assertTrue("test1 equals", TEST_BOM_1.equals(TEST_BOM_1));
        junit.framework.TestCase.assertTrue("test2 equals", TEST_BOM_2.equals(TEST_BOM_2));
        junit.framework.TestCase.assertTrue("test3 equals", TEST_BOM_3.equals(TEST_BOM_3));
        junit.framework.TestCase.assertFalse("Object not equal", TEST_BOM_1.equals(new java.lang.Object()));
        junit.framework.TestCase.assertFalse("test1-1 not equal", TEST_BOM_1.equals(new org.apache.commons.io.ByteOrderMark("1a" , 2)));
        junit.framework.TestCase.assertFalse("test1-2 not test2", TEST_BOM_1.equals(new org.apache.commons.io.ByteOrderMark("1b" , 1 , 2)));
        junit.framework.TestCase.assertFalse("test2 not equal", TEST_BOM_2.equals(new org.apache.commons.io.ByteOrderMark("2" , 1 , 1)));
        junit.framework.TestCase.assertFalse("test3 not equal", TEST_BOM_3.equals(new org.apache.commons.io.ByteOrderMark("3" , 1 , 2 , 4)));
    }

    public void g() {
        final int bomClassHash = org.apache.commons.io.ByteOrderMark.class.hashCode();
        junit.framework.TestCase.assertEquals("hash test1 ", (bomClassHash + 1), TEST_BOM_1.hashCode());
        junit.framework.TestCase.assertEquals("hash test2 ", (bomClassHash + 3), TEST_BOM_2.hashCode());
        junit.framework.TestCase.assertEquals("hash test3 ", (bomClassHash + 6), TEST_BOM_3.hashCode());
    }

    public void d() {
        try {
            new org.apache.commons.io.ByteOrderMark(null , 1 , 2 , 3);
            junit.framework.TestCase.fail("null charset name, expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        try {
            new org.apache.commons.io.ByteOrderMark("" , 1 , 2 , 3);
            junit.framework.TestCase.fail("no charset name, expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        try {
            new org.apache.commons.io.ByteOrderMark("a" , ((int[])(null)));
            junit.framework.TestCase.fail("null bytes, expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        try {
            new org.apache.commons.io.ByteOrderMark("b");
            junit.framework.TestCase.fail("empty bytes, expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }

    public void i() {
        junit.framework.TestCase.assertEquals("test1 ", "ByteOrderMark[test1: 0x1]", TEST_BOM_1.toString());
        junit.framework.TestCase.assertEquals("test2 ", "ByteOrderMark[test2: 0x1,0x2]", TEST_BOM_2.toString());
        junit.framework.TestCase.assertEquals("test3 ", "ByteOrderMark[test3: 0x1,0x2,0x3]", TEST_BOM_3.toString());
    }
}


package org.apache.commons.io.input;


public class SwappedDataInputStreamTest extends junit.framework.TestCase {
    private org.apache.commons.io.input.SwappedDataInputStream sdis;

    private byte[] bytes;

    public SwappedDataInputStreamTest(final java.lang.String name) {
        super(name);
    }

    @java.lang.Override
    public void setUp() {
        bytes = new byte[]{ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 };
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(bytes);
        this.sdis = new org.apache.commons.io.input.SwappedDataInputStream(bais);
    }

    @java.lang.Override
    public void tearDown() {
        this.sdis = null;
    }

    public void a() throws java.io.IOException {
        bytes = new byte[]{ 0 , 1 , 2 };
        final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(bytes);
        final org.apache.commons.io.input.SwappedDataInputStream sdis = new org.apache.commons.io.input.SwappedDataInputStream(bais);
        junit.framework.TestCase.assertEquals(false, sdis.readBoolean());
        junit.framework.TestCase.assertEquals(true, sdis.readBoolean());
        junit.framework.TestCase.assertEquals(true, sdis.readBoolean());
        sdis.close();
    }

    public void b() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(1, this.sdis.readByte());
    }

    public void c() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(((char)(513)), this.sdis.readChar());
    }

    public void d() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(java.lang.Double.longBitsToDouble(578437695752307201L), this.sdis.readDouble(), 0);
    }

    public void e() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(java.lang.Float.intBitsToFloat(67305985), this.sdis.readFloat(), 0);
    }

    public void f() throws java.io.IOException {
        final byte[] bytesIn = new byte[8];
        this.sdis.readFully(bytesIn);
        for (int i = 0 ; i < 8 ; i++) {
            junit.framework.TestCase.assertEquals(bytes[i], bytesIn[i]);
        }
    }

    public void g() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(67305985, this.sdis.readInt());
    }

    public void h() throws java.io.IOException {
        try {
            this.sdis.readLine();
            junit.framework.TestCase.fail("readLine should be unsupported. ");
        } catch (final java.lang.UnsupportedOperationException uoe) {
        }
    }

    public void i() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(578437695752307201L, this.sdis.readLong());
    }

    public void j() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(((short)(513)), this.sdis.readShort());
    }

    public void l() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(1, this.sdis.readUnsignedByte());
    }

    public void m() throws java.io.IOException {
        junit.framework.TestCase.assertEquals(((short)(513)), this.sdis.readUnsignedShort());
    }

    public void k() throws java.io.IOException {
        try {
            this.sdis.readUTF();
            junit.framework.TestCase.fail("readUTF should be unsupported. ");
        } catch (final java.lang.UnsupportedOperationException uoe) {
        }
    }

    public void n() throws java.io.IOException {
        this.sdis.skipBytes(4);
        junit.framework.TestCase.assertEquals(134678021, this.sdis.readInt());
    }
}


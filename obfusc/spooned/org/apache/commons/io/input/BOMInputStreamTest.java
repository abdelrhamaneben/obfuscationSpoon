package org.apache.commons.io.input;


public class BOMInputStreamTest {
    private static class ExpectCloseInputStream extends java.io.InputStream {
        private boolean _closeCalled;

        public void a() {
            org.junit.Assert.assertTrue(_closeCalled);
        }

        @java.lang.Override
        public void close() throws java.io.IOException {
            _closeCalled = true;
        }

        @java.lang.Override
        public int read() throws java.io.IOException {
            return -1;
        }
    }

    private void a(final byte[] expected, final byte[] actual, final int len) throws java.lang.Exception {
        org.junit.Assert.assertEquals("length", expected.length, len);
        for (int ii = 0 ; ii < (expected.length) ; ii++) {
            org.junit.Assert.assertEquals(("byte " + ii), expected[ii], actual[ii]);
        }
    }

    private java.io.InputStream a(final byte[] baseData, final boolean addBOM) {
        byte[] data = baseData;
        if (addBOM) {
            data = new byte[(baseData.length) + 2];
            data[0] = ((byte)(254));
            data[1] = ((byte)(255));
            java.lang.System.arraycopy(baseData, 0, data, 2, baseData.length);
        } 
        return new java.io.ByteArrayInputStream(data);
    }

    private java.io.InputStream b(final byte[] baseData, final boolean addBOM) {
        byte[] data = baseData;
        if (addBOM) {
            data = new byte[(baseData.length) + 2];
            data[0] = ((byte)(255));
            data[1] = ((byte)(254));
            java.lang.System.arraycopy(baseData, 0, data, 2, baseData.length);
        } 
        return new java.io.ByteArrayInputStream(data);
    }

    private java.io.InputStream c(final byte[] baseData, final boolean addBOM) {
        byte[] data = baseData;
        if (addBOM) {
            data = new byte[(baseData.length) + 4];
            data[0] = 0;
            data[1] = 0;
            data[2] = ((byte)(254));
            data[3] = ((byte)(255));
            java.lang.System.arraycopy(baseData, 0, data, 4, baseData.length);
        } 
        return new java.io.ByteArrayInputStream(data);
    }

    private java.io.InputStream d(final byte[] baseData, final boolean addBOM) {
        byte[] data = baseData;
        if (addBOM) {
            data = new byte[(baseData.length) + 4];
            data[0] = ((byte)(255));
            data[1] = ((byte)(254));
            data[2] = 0;
            data[3] = 0;
            java.lang.System.arraycopy(baseData, 0, data, 4, baseData.length);
        } 
        return new java.io.ByteArrayInputStream(data);
    }

    private java.io.InputStream e(final byte[] baseData, final boolean addBOM) {
        byte[] data = baseData;
        if (addBOM) {
            data = new byte[(baseData.length) + 3];
            data[0] = ((byte)(239));
            data[1] = ((byte)(187));
            data[2] = ((byte)(191));
            java.lang.System.arraycopy(baseData, 0, data, 3, baseData.length);
        } 
        return new java.io.ByteArrayInputStream(data);
    }

    private void a(final java.io.InputStream in) throws java.io.IOException, javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        final org.w3c.dom.Document doc = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new org.xml.sax.InputSource(in));
        org.junit.Assert.assertNotNull(doc);
        org.junit.Assert.assertEquals("X", doc.getFirstChild().getNodeName());
    }

    private void a(final java.io.Reader in) throws java.io.IOException, javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        final org.w3c.dom.Document doc = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new org.xml.sax.InputSource(in));
        org.junit.Assert.assertNotNull(doc);
        org.junit.Assert.assertEquals("X", doc.getFirstChild().getNodeName());
    }

    private void a(final java.lang.String resource) throws java.lang.Exception {
        final java.io.InputStream inputStream = getClass().getResourceAsStream(resource);
        org.junit.Assert.assertNotNull(inputStream);
        final org.apache.commons.io.input.BOMInputStream bomInputStream = new org.apache.commons.io.input.BOMInputStream(inputStream);
        bomInputStream.mark(1000000);
        readFile(bomInputStream);
        bomInputStream.reset();
        readFile(bomInputStream);
        inputStream.close();
        bomInputStream.close();
    }

    private void a(final org.apache.commons.io.input.BOMInputStream bomInputStream) throws java.lang.Exception {
        int bytes = 0;
        final byte[] bytesFromStream = new byte[100];
        do {
            bytes = bomInputStream.read(bytesFromStream);
        } while (bytes > 0 );
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        org.junit.Assert.assertEquals(7, in.available());
        in.close();
    }

    @org.junit.Test
    public void d() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertEquals(4, in.available());
        in.close();
    }

    @org.junit.Test
    public void e() throws java.lang.Exception {
        final org.apache.commons.io.input.BOMInputStreamTest.ExpectCloseInputStream del = new org.apache.commons.io.input.BOMInputStreamTest.ExpectCloseInputStream();
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(del);
        in.close();
        del.assertCloseCalled();
        del.close();
    }

    @org.junit.Test
    public void f() throws java.lang.Exception {
        final byte[] data = new byte[]{  };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        final byte[] buf = new byte[1024];
        org.junit.Assert.assertEquals(-1, in.read(buf));
        in.close();
    }

    @org.junit.Test
    public void g() throws java.lang.Exception {
        final byte[] data = new byte[]{  };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        final byte[] buf = new byte[1024];
        org.junit.Assert.assertEquals(-1, in.read(buf));
        in.close();
    }

    @org.junit.Test
    public void h() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_8, in.getBOM());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        in.close();
    }

    @org.junit.Test
    public void i() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true) , true);
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_8, in.getBOM());
        org.junit.Assert.assertEquals(239, in.read());
        org.junit.Assert.assertEquals(187, in.read());
        org.junit.Assert.assertEquals(191, in.read());
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        in.close();
    }

    @org.junit.Test
    public void j() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        final byte[] buf = new byte[1024];
        assertData(data, buf, in.read(buf));
        in.close();
    }

    @org.junit.Test
    public void k() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        final byte[] buf = new byte[1024];
        assertData(data, buf, in.read(buf));
        in.close();
    }

    @org.junit.Test
    public void l() throws java.lang.Exception {
        final byte[] data = new byte[]{ ((byte)(239)) , ((byte)(171)) , ((byte)(205)) };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        final byte[] buf = new byte[1024];
        assertData(data, buf, in.read(buf));
        in.close();
    }

    @org.junit.Test
    public void m() throws java.lang.Exception {
        final byte[] data = new byte[]{ ((byte)(239)) , ((byte)(171)) , ((byte)(205)) };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertEquals(239, in.read());
        org.junit.Assert.assertEquals(171, in.read());
        org.junit.Assert.assertEquals(205, in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        in.close();
    }

    @org.junit.Test
    public void n() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        org.junit.Assert.assertTrue(in.markSupported());
        in.read();
        in.mark(10);
        in.read();
        in.read();
        in.reset();
        org.junit.Assert.assertEquals('B', in.read());
        in.close();
    }

    @org.junit.Test
    public void o() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertTrue(in.markSupported());
        in.read();
        in.mark(10);
        in.read();
        in.read();
        in.reset();
        org.junit.Assert.assertEquals('B', in.read());
        in.close();
    }

    @org.junit.Test
    public void p() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        org.junit.Assert.assertTrue(in.markSupported());
        in.mark(10);
        in.read();
        in.read();
        in.reset();
        org.junit.Assert.assertEquals('A', in.read());
        in.close();
    }

    @org.junit.Test
    public void q() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertTrue(in.markSupported());
        in.mark(10);
        in.read();
        in.read();
        in.reset();
        org.junit.Assert.assertEquals('A', in.read());
        in.close();
    }

    @org.junit.Test
    public void r() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        try {
            new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true) , false , ((org.apache.commons.io.ByteOrderMark[])(null))).close();
            org.junit.Assert.fail("Null BOMs, expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        try {
            new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true) , false , new org.apache.commons.io.ByteOrderMark[0]).close();
            org.junit.Assert.fail("Null BOMs, expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
    }

    @org.junit.Test
    public void s() throws java.lang.Exception {
        final byte[] data = new byte[]{  };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertFalse("hasBOM()", in.hasBOM());
        org.junit.Assert.assertFalse("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertNull("getBOM", in.getBOM());
        in.close();
    }

    @org.junit.Test
    public void t() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertFalse("hasBOM()", in.hasBOM());
        org.junit.Assert.assertFalse("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertNull("getBOM", in.getBOM());
        in.close();
    }

    @org.junit.Test
    public void u() throws java.lang.Exception {
        readBOMInputStreamTwice("/org/apache/commons/io/testfileBOM.xml");
    }

    @org.junit.Test
    public void v() throws java.lang.Exception {
        readBOMInputStreamTwice("/org/apache/commons/io/testfileNoBOM.xml");
    }

    @org.junit.Test
    public void w() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true) , true);
        org.junit.Assert.assertEquals(239, in.read());
        org.junit.Assert.assertEquals(187, in.read());
        org.junit.Assert.assertEquals(191, in.read());
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_8, in.getBOM());
        in.close();
    }

    @org.junit.Test
    public void x() throws java.lang.Exception {
        @java.lang.SuppressWarnings(value = "deprecation")
        final byte[] data = "ABC".getBytes(org.apache.commons.io.Charsets.UTF_16BE);
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf16BeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_16BE);
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-16BE)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_16BE));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_16BE, in.getBOM());
        try {
            in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_16LE);
            org.junit.Assert.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        in.close();
    }

    @org.junit.Test
    public void y() throws java.lang.Exception {
        @java.lang.SuppressWarnings(value = "deprecation")
        final byte[] data = "ABC".getBytes(org.apache.commons.io.Charsets.UTF_16LE);
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf16LeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_16LE);
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-16LE)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_16LE));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_16LE, in.getBOM());
        try {
            in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_16BE);
            org.junit.Assert.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        in.close();
    }

    @org.junit.Test
    public void z() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("UTF_32BE"));
        final byte[] data = "ABC".getBytes("UTF_32BE");
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf32BeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_32BE);
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-32BE)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_32BE));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_32BE, in.getBOM());
        try {
            in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_32LE);
            org.junit.Assert.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        in.close();
    }

    @org.junit.Test
    public void aa() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("UTF_32LE"));
        final byte[] data = "ABC".getBytes("UTF_32LE");
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf32LeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_32LE);
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(0, in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-32LE)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_32LE));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_32LE, in.getBOM());
        try {
            in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_32BE);
            org.junit.Assert.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        in.close();
    }

    @org.junit.Test
    public void ab() throws java.lang.Exception {
        @java.lang.SuppressWarnings(value = "deprecation")
        final byte[] data = "ABC".getBytes(org.apache.commons.io.Charsets.UTF_8);
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_8);
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_8, in.getBOM());
        try {
            in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_16BE);
            org.junit.Assert.fail("Expected IllegalArgumentException");
        } catch (final java.lang.IllegalArgumentException e) {
        }
        in.close();
    }

    @org.junit.Test
    public void ac() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_16BE , org.apache.commons.io.ByteOrderMark.UTF_8);
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertTrue("hasBOM()", in.hasBOM());
        org.junit.Assert.assertTrue("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertFalse("hasBOM(UTF-16BE)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_16BE));
        org.junit.Assert.assertEquals("getBOM", org.apache.commons.io.ByteOrderMark.UTF_8, in.getBOM());
        in.close();
    }

    @org.junit.Test
    public void ad() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final org.apache.commons.io.input.BOMInputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        org.junit.Assert.assertEquals('A', in.read());
        org.junit.Assert.assertEquals('B', in.read());
        org.junit.Assert.assertEquals('C', in.read());
        org.junit.Assert.assertEquals(-1, in.read());
        org.junit.Assert.assertFalse("hasBOM()", in.hasBOM());
        org.junit.Assert.assertFalse("hasBOM(UTF-8)", in.hasBOM(org.apache.commons.io.ByteOrderMark.UTF_8));
        org.junit.Assert.assertNull("getBOM", in.getBOM());
        in.close();
    }

    @org.junit.Test
    public void ae() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("ISO-10646-UCS-2"));
        final byte[] data = "<?xml version=\"1.0\" encoding=\"ISO-10646-UCS-2\"?><X/>".getBytes("ISO-10646-UCS-2");
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf16BeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_16BE));
        parseXml(createUtf16BeDataStream(data, true));
    }

    @org.junit.Test
    public void af() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("ISO-10646-UCS-4"));
        final byte[] data = "<?xml version=\"1.0\" encoding=\"ISO-10646-UCS-4\"?><X/>".getBytes("ISO-10646-UCS-4");
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf32BeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_32BE));
        parseXml(createUtf32BeDataStream(data, true));
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void ag() throws java.lang.Exception {
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-16BE\"?><X/>".getBytes(org.apache.commons.io.Charsets.UTF_16BE);
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf16BeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_16BE));
        parseXml(createUtf16BeDataStream(data, true));
    }

    @org.junit.Test
    @java.lang.SuppressWarnings(value = "deprecation")
    public void ah() throws java.lang.Exception {
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-16LE\"?><X/>".getBytes(org.apache.commons.io.Charsets.UTF_16LE);
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf16LeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_16LE));
        parseXml(createUtf16LeDataStream(data, true));
    }

    @org.junit.Test
    public void ai() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("UTF_32BE"));
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-32BE\"?><X/>".getBytes("UTF_32BE");
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf32BeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_32BE));
        parseXml(new org.apache.commons.io.input.XmlStreamReader(createUtf32BeDataStream(data, true)));
    }

    @org.junit.Test
    public void aj() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("UTF_32LE"));
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-32LE\"?><X/>".getBytes("UTF_32LE");
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf32LeDataStream(data, true) , org.apache.commons.io.ByteOrderMark.UTF_32LE));
        parseXml(new org.apache.commons.io.input.XmlStreamReader(createUtf32LeDataStream(data, true)));
    }

    @org.junit.Test
    public void ak() throws java.lang.Exception {
        @java.lang.SuppressWarnings(value = "deprecation")
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><X/>".getBytes(org.apache.commons.io.Charsets.UTF_8);
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true)));
        parseXml(createUtf8DataStream(data, true));
    }

    @org.junit.Test
    public void al() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("UTF_32BE"));
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-32BE\"?><X/>".getBytes("UTF_32BE");
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf32BeDataStream(data, false)));
        parseXml(createUtf32BeDataStream(data, false));
    }

    @org.junit.Test
    public void am() throws java.lang.Exception {
        org.junit.Assume.assumeTrue(java.nio.charset.Charset.isSupported("UTF_32LE"));
        final byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-32LE\"?><X/>".getBytes("UTF_32LE");
        parseXml(new org.apache.commons.io.input.BOMInputStream(createUtf32LeDataStream(data, false)));
        parseXml(createUtf32BeDataStream(data, false));
    }

    @org.junit.Test
    public void an() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        in.skip(2L);
        org.junit.Assert.assertEquals('C', in.read());
        in.close();
    }

    @org.junit.Test
    public void ao() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' , 'D' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        in.skip(2L);
        org.junit.Assert.assertEquals('C', in.read());
        in.close();
    }

    @org.junit.Test
    public void a() throws java.io.IOException {
        byte[] baseData = new byte[]{ ((byte)(49)) , ((byte)(50)) , ((byte)(51)) };
        org.apache.commons.io.input.BOMInputStream is1 = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(baseData, true));
        org.junit.Assert.assertEquals(2, is1.skip(2));
        org.junit.Assert.assertEquals(((byte)(51)), is1.read());
        is1.close();
    }

    @org.junit.Test
    public void b() throws java.io.IOException {
        byte[] baseData = new byte[]{ ((byte)(49)) , ((byte)(50)) , ((byte)(51)) };
        org.apache.commons.io.input.BOMInputStream is2 = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(baseData, false));
        org.junit.Assert.assertEquals(2, is2.skip(2));
        org.junit.Assert.assertEquals(((byte)(51)), is2.read());
        is2.close();
    }

    @org.junit.Test
    public void ap() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, true));
        final byte[] buf = new byte[1024];
        assertData(new byte[]{ 'A' , 'B' }, buf, in.read(buf, 0, 2));
        assertData(new byte[]{ 'C' }, buf, in.read(buf, 0, 2));
        in.close();
    }

    @org.junit.Test
    public void aq() throws java.lang.Exception {
        final byte[] data = new byte[]{ 'A' , 'B' , 'C' };
        final java.io.InputStream in = new org.apache.commons.io.input.BOMInputStream(createUtf8DataStream(data, false));
        final byte[] buf = new byte[1024];
        assertData(new byte[]{ 'A' , 'B' }, buf, in.read(buf, 0, 2));
        assertData(new byte[]{ 'C' }, buf, in.read(buf, 0, 2));
        in.close();
    }

    @org.junit.Test
    public void ar() throws java.lang.Exception {
        final java.io.InputStream in = createUtf8DataStream(new byte[]{ 'A' , 'B' }, true);
        final byte[] buf = new byte[1024];
        final int len = in.read(buf);
        org.junit.Assert.assertEquals(5, len);
        org.junit.Assert.assertEquals(239, ((buf[0]) & 255));
        org.junit.Assert.assertEquals(187, ((buf[1]) & 255));
        org.junit.Assert.assertEquals(191, ((buf[2]) & 255));
        org.junit.Assert.assertEquals('A', ((buf[3]) & 255));
        org.junit.Assert.assertEquals('B', ((buf[4]) & 255));
        assertData(new byte[]{ ((byte)(239)) , ((byte)(187)) , ((byte)(191)) , 'A' , 'B' }, buf, len);
    }
}


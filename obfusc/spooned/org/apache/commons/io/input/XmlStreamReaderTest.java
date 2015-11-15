package org.apache.commons.io.input;


public class XmlStreamReaderTest {
    private static final java.lang.String XML5 = "xml-prolog-encoding-spaced-single-quotes";

    private static final java.lang.String XML4 = "xml-prolog-encoding-single-quotes";

    private static final java.lang.String XML3 = "xml-prolog-encoding-double-quotes";

    private static final java.lang.String XML2 = "xml-prolog";

    private static final java.lang.String XML1 = "xml";

    protected void c(final java.lang.String encoding) throws java.lang.Exception {
        java.io.InputStream is = getXmlStream("no-bom", XML1, encoding, encoding);
        org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , false);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), "UTF-8");
        xmlReader.close();
        is = getXmlStream("no-bom", XML2, encoding, encoding);
        xmlReader = new org.apache.commons.io.input.XmlStreamReader(is);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), "UTF-8");
        xmlReader.close();
        is = getXmlStream("no-bom", XML3, encoding, encoding);
        xmlReader = new org.apache.commons.io.input.XmlStreamReader(is);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), encoding);
        xmlReader.close();
        is = getXmlStream("no-bom", XML4, encoding, encoding);
        xmlReader = new org.apache.commons.io.input.XmlStreamReader(is);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), encoding);
        xmlReader.close();
        is = getXmlStream("no-bom", XML5, encoding, encoding);
        xmlReader = new org.apache.commons.io.input.XmlStreamReader(is);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), encoding);
        xmlReader.close();
    }

    protected void b(final java.lang.String encoding) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream("no-bom", XML3, encoding, encoding);
        try {
            new org.apache.commons.io.input.XmlStreamReader(is , false).close();
            org.junit.Assert.fail("It should have failed");
        } catch (final java.io.IOException ex) {
            org.junit.Assert.assertTrue(ex.getMessage().contains("Invalid encoding,"));
        }
    }

    @org.junit.Test
    public void j() throws java.lang.Exception {
        _testRawNoBomValid("US-ASCII");
    }

    @org.junit.Test
    public void o() throws java.lang.Exception {
        _testRawNoBomValid("UTF-8");
    }

    @org.junit.Test
    public void k() throws java.lang.Exception {
        _testRawNoBomValid("UTF-16BE");
    }

    @org.junit.Test
    public void l() throws java.lang.Exception {
        _testRawNoBomValid("UTF-16LE");
    }

    @org.junit.Test
    public void m() throws java.lang.Exception {
        _testRawNoBomValid("UTF-32BE");
    }

    @org.junit.Test
    public void n() throws java.lang.Exception {
        _testRawNoBomValid("UTF-32LE");
    }

    @org.junit.Test
    public void i() throws java.lang.Exception {
        _testRawNoBomValid("ISO-8859-1");
    }

    @org.junit.Test
    public void h() throws java.lang.Exception {
        _testRawNoBomValid("CP1047");
    }

    protected void a(final java.lang.String encoding) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream((encoding + "-bom"), XML3, encoding, encoding);
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , false);
        if ((!(encoding.equals("UTF-16"))) && (!(encoding.equals("UTF-32")))) {
            org.junit.Assert.assertEquals(xmlReader.getEncoding(), encoding);
        } else {
            org.junit.Assert.assertEquals(xmlReader.getEncoding().substring(0, encoding.length()), encoding);
        }
        xmlReader.close();
    }

    protected void a(final java.lang.String bomEnc, final java.lang.String streamEnc, final java.lang.String prologEnc) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream(bomEnc, XML3, streamEnc, prologEnc);
        org.apache.commons.io.input.XmlStreamReader xmlReader = null;
        try {
            xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , false);
            final java.lang.String foundEnc = xmlReader.getEncoding();
            org.junit.Assert.fail(((((((("Expected IOException for BOM " + bomEnc) + ", streamEnc ") + streamEnc) + " and prologEnc ") + prologEnc) + ": found ") + foundEnc));
        } catch (final java.io.IOException ex) {
            org.junit.Assert.assertTrue(ex.getMessage().contains("Invalid encoding,"));
        }
        if (xmlReader != null) {
            xmlReader.close();
        } 
    }

    @org.junit.Test
    public void f() throws java.lang.Exception {
        _testRawBomValid("UTF-8");
        _testRawBomInvalid("UTF-8-bom", "US-ASCII", "US-ASCII");
        _testRawBomInvalid("UTF-8-bom", "ISO-8859-1", "ISO-8859-1");
        _testRawBomInvalid("UTF-8-bom", "UTF-8", "UTF-16");
        _testRawBomInvalid("UTF-8-bom", "UTF-8", "UTF-16BE");
        _testRawBomInvalid("UTF-8-bom", "UTF-8", "UTF-16LE");
        _testRawBomInvalid("UTF-16BE-bom", "UTF-16BE", "UTF-16LE");
        _testRawBomInvalid("UTF-16LE-bom", "UTF-16LE", "UTF-16BE");
        _testRawBomInvalid("UTF-16LE-bom", "UTF-16LE", "UTF-8");
        _testRawBomInvalid("UTF-32BE-bom", "UTF-32BE", "UTF-32LE");
        _testRawBomInvalid("UTF-32LE-bom", "UTF-32LE", "UTF-32BE");
        _testRawBomInvalid("UTF-32LE-bom", "UTF-32LE", "UTF-8");
    }

    @org.junit.Test
    public void d() throws java.lang.Exception {
        _testRawBomValid("UTF-16BE");
        _testRawBomValid("UTF-16LE");
        _testRawBomValid("UTF-16");
        _testRawBomInvalid("UTF-16BE-bom", "UTF-16BE", "UTF-16LE");
        _testRawBomInvalid("UTF-16LE-bom", "UTF-16LE", "UTF-16BE");
        _testRawBomInvalid("UTF-16LE-bom", "UTF-16LE", "UTF-8");
    }

    @org.junit.Test
    public void e() throws java.lang.Exception {
        _testRawBomValid("UTF-32BE");
        _testRawBomValid("UTF-32LE");
        _testRawBomValid("UTF-32");
        _testRawBomInvalid("UTF-32BE-bom", "UTF-32BE", "UTF-32LE");
        _testRawBomInvalid("UTF-32LE-bom", "UTF-32LE", "UTF-32BE");
        _testRawBomInvalid("UTF-32LE-bom", "UTF-32LE", "UTF-8");
    }

    @org.junit.Test
    public void b() throws java.lang.Exception {
        _testHttpValid("application/xml", "UTF-8-bom", "UTF-8", null);
        _testHttpValid("application/xml", "UTF-8-bom", "UTF-8", "UTF-8");
        _testHttpValid("application/xml;charset=UTF-8", "UTF-8-bom", "UTF-8", null);
        _testHttpValid("application/xml;charset=\"UTF-8\"", "UTF-8-bom", "UTF-8", null);
        _testHttpValid("application/xml;charset=\'UTF-8\'", "UTF-8-bom", "UTF-8", null);
        _testHttpValid("application/xml;charset=UTF-8", "UTF-8-bom", "UTF-8", "UTF-8");
        _testHttpValid("application/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", null);
        _testHttpValid("application/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", "UTF-16");
        _testHttpValid("application/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", "UTF-16BE");
        _testHttpInvalid("application/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", null);
        _testHttpInvalid("application/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", "UTF-16");
        _testHttpInvalid("application/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", "UTF-16BE");
        _testHttpInvalid("application/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", null);
        _testHttpInvalid("application/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", "UTF-32");
        _testHttpInvalid("application/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", "UTF-32BE");
        _testHttpInvalid("application/xml", "UTF-8-bom", "US-ASCII", "US-ASCII");
        _testHttpInvalid("application/xml;charset=UTF-16", "UTF-16LE", "UTF-8", "UTF-8");
        _testHttpInvalid("application/xml;charset=UTF-16", "no-bom", "UTF-16BE", "UTF-16BE");
        _testHttpInvalid("application/xml;charset=UTF-32", "UTF-32LE", "UTF-8", "UTF-8");
        _testHttpInvalid("application/xml;charset=UTF-32", "no-bom", "UTF-32BE", "UTF-32BE");
        _testHttpValid("text/xml", "no-bom", "US-ASCII", null);
        _testHttpValid("text/xml;charset=UTF-8", "UTF-8-bom", "UTF-8", "UTF-8");
        _testHttpValid("text/xml;charset=UTF-8", "UTF-8-bom", "UTF-8", null);
        _testHttpValid("text/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", null);
        _testHttpValid("text/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", "UTF-16");
        _testHttpValid("text/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", "UTF-16BE");
        _testHttpValid("text/xml;charset=UTF-32", "UTF-32BE-bom", "UTF-32BE", null);
        _testHttpValid("text/xml;charset=UTF-32", "UTF-32BE-bom", "UTF-32BE", "UTF-32");
        _testHttpValid("text/xml;charset=UTF-32", "UTF-32BE-bom", "UTF-32BE", "UTF-32BE");
        _testHttpValid("text/xml", "UTF-8-bom", "US-ASCII", null);
        _testAlternateDefaultEncoding("application/xml", "UTF-8-bom", "UTF-8", null, null);
        _testAlternateDefaultEncoding("application/xml", "no-bom", "US-ASCII", null, "US-ASCII");
        _testAlternateDefaultEncoding("application/xml", "UTF-8-bom", "UTF-8", null, "UTF-8");
        _testAlternateDefaultEncoding("text/xml", "no-bom", "US-ASCII", null, null);
        _testAlternateDefaultEncoding("text/xml", "no-bom", "US-ASCII", null, "US-ASCII");
        _testAlternateDefaultEncoding("text/xml", "no-bom", "US-ASCII", null, "UTF-8");
        _testHttpInvalid("text/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", null);
        _testHttpInvalid("text/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", "UTF-16");
        _testHttpInvalid("text/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", "UTF-16BE");
        _testHttpInvalid("text/xml;charset=UTF-16", "no-bom", "UTF-16BE", "UTF-16BE");
        _testHttpInvalid("text/xml;charset=UTF-16", "no-bom", "UTF-16BE", null);
        _testHttpInvalid("text/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", null);
        _testHttpInvalid("text/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", "UTF-32");
        _testHttpInvalid("text/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", "UTF-32BE");
        _testHttpInvalid("text/xml;charset=UTF-32", "no-bom", "UTF-32BE", "UTF-32BE");
        _testHttpInvalid("text/xml;charset=UTF-32", "no-bom", "UTF-32BE", null);
        _testHttpLenient("text/xml", "no-bom", "US-ASCII", null, "US-ASCII");
        _testHttpLenient("text/xml;charset=UTF-8", "UTF-8-bom", "UTF-8", "UTF-8", "UTF-8");
        _testHttpLenient("text/xml;charset=UTF-8", "UTF-8-bom", "UTF-8", null, "UTF-8");
        _testHttpLenient("text/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", null, "UTF-16BE");
        _testHttpLenient("text/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", "UTF-16", "UTF-16");
        _testHttpLenient("text/xml;charset=UTF-16", "UTF-16BE-bom", "UTF-16BE", "UTF-16BE", "UTF-16BE");
        _testHttpLenient("text/xml;charset=UTF-32", "UTF-32BE-bom", "UTF-32BE", null, "UTF-32BE");
        _testHttpLenient("text/xml;charset=UTF-32", "UTF-32BE-bom", "UTF-32BE", "UTF-32", "UTF-32");
        _testHttpLenient("text/xml;charset=UTF-32", "UTF-32BE-bom", "UTF-32BE", "UTF-32BE", "UTF-32BE");
        _testHttpLenient("text/xml", "UTF-8-bom", "US-ASCII", null, "US-ASCII");
        _testHttpLenient("text/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", null, "UTF-16BE");
        _testHttpLenient("text/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", "UTF-16", "UTF-16");
        _testHttpLenient("text/xml;charset=UTF-16BE", "UTF-16BE-bom", "UTF-16BE", "UTF-16BE", "UTF-16BE");
        _testHttpLenient("text/xml;charset=UTF-16", "no-bom", "UTF-16BE", "UTF-16BE", "UTF-16BE");
        _testHttpLenient("text/xml;charset=UTF-16", "no-bom", "UTF-16BE", null, "UTF-16");
        _testHttpLenient("text/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", null, "UTF-32BE");
        _testHttpLenient("text/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", "UTF-32", "UTF-32");
        _testHttpLenient("text/xml;charset=UTF-32BE", "UTF-32BE-bom", "UTF-32BE", "UTF-32BE", "UTF-32BE");
        _testHttpLenient("text/xml;charset=UTF-32", "no-bom", "UTF-32BE", "UTF-32BE", "UTF-32BE");
        _testHttpLenient("text/xml;charset=UTF-32", "no-bom", "UTF-32BE", null, "UTF-32");
        _testHttpLenient("text/html", "no-bom", "US-ASCII", "US-ASCII", "US-ASCII");
        _testHttpLenient("text/html", "no-bom", "US-ASCII", null, "US-ASCII");
        _testHttpLenient("text/html;charset=UTF-8", "no-bom", "US-ASCII", "UTF-8", "UTF-8");
        _testHttpLenient("text/html;charset=UTF-16BE", "no-bom", "US-ASCII", "UTF-8", "UTF-8");
        _testHttpLenient("text/html;charset=UTF-32BE", "no-bom", "US-ASCII", "UTF-8", "UTF-8");
    }

    @org.junit.Test
    public void g() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.lang.String xml = getXML("no-bom", XML3, encoding, encoding);
        final java.io.ByteArrayInputStream is = new java.io.ByteArrayInputStream(xml.getBytes(encoding));
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is);
        org.junit.Assert.assertEquals("Check encoding", xmlReader.getEncoding(), encoding);
        org.junit.Assert.assertEquals("Check content", xml, org.apache.commons.io.IOUtils.toString(xmlReader));
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        final java.lang.String encoding = "UTF-8";
        final java.lang.String xml = getXML("no-bom", XML3, encoding, encoding);
        final java.io.ByteArrayInputStream is = new java.io.ByteArrayInputStream(xml.getBytes(encoding));
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , encoding);
        org.junit.Assert.assertEquals("Check encoding", xmlReader.getEncoding(), encoding);
        org.junit.Assert.assertEquals("Check content", xml, org.apache.commons.io.IOUtils.toString(xmlReader));
    }

    public void a(final java.lang.String cT, final java.lang.String bomEnc, final java.lang.String streamEnc, final java.lang.String prologEnc, final java.lang.String alternateEnc) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream(bomEnc, (prologEnc == null ? XML1 : XML3), streamEnc, prologEnc);
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , cT , false , alternateEnc);
        if (!(streamEnc.equals("UTF-16"))) {
            final java.lang.String enc = alternateEnc != null ? alternateEnc : streamEnc;
            org.junit.Assert.assertEquals(xmlReader.getEncoding(), enc);
        } else {
            org.junit.Assert.assertEquals(xmlReader.getEncoding().substring(0, streamEnc.length()), streamEnc);
        }
        xmlReader.close();
    }

    public void d(final java.lang.String cT, final java.lang.String bomEnc, final java.lang.String streamEnc, final java.lang.String prologEnc) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream(bomEnc, (prologEnc == null ? XML1 : XML3), streamEnc, prologEnc);
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , cT , false);
        if (!(streamEnc.equals("UTF-16"))) {
            org.junit.Assert.assertEquals(xmlReader.getEncoding(), streamEnc);
        } else {
            org.junit.Assert.assertEquals(xmlReader.getEncoding().substring(0, streamEnc.length()), streamEnc);
        }
        xmlReader.close();
    }

    protected void c(final java.lang.String cT, final java.lang.String bomEnc, final java.lang.String streamEnc, final java.lang.String prologEnc) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream(bomEnc, (prologEnc == null ? XML2 : XML3), streamEnc, prologEnc);
        try {
            new org.apache.commons.io.input.XmlStreamReader(is , cT , false).close();
            org.junit.Assert.fail(((((((("It should have failed for HTTP Content-type " + cT) + ", BOM ") + bomEnc) + ", streamEnc ") + streamEnc) + " and prologEnc ") + prologEnc));
        } catch (final java.io.IOException ex) {
            org.junit.Assert.assertTrue(ex.getMessage().contains("Invalid encoding,"));
        }
    }

    protected void b(final java.lang.String cT, final java.lang.String bomEnc, final java.lang.String streamEnc, final java.lang.String prologEnc, final java.lang.String shouldbe) throws java.lang.Exception {
        final java.io.InputStream is = getXmlStream(bomEnc, (prologEnc == null ? XML2 : XML3), streamEnc, prologEnc);
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , cT , true);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), shouldbe);
        xmlReader.close();
    }

    private static final java.lang.String ENCODING_ATTRIBUTE_XML = "<?xml version=\"1.0\" ?> \n" + ("<atom:feed xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" + ("\n" + ("  <atom:entry>\n" + ("    <atom:title encoding=\'base64\'><![CDATA\n" + "aW5nTGluZSIgLz4"))));

    @org.junit.Test
    public void a() throws java.lang.Exception {
        final java.io.InputStream is = new java.io.ByteArrayInputStream(ENCODING_ATTRIBUTE_XML.getBytes("UTF-8"));
        final org.apache.commons.io.input.XmlStreamReader xmlReader = new org.apache.commons.io.input.XmlStreamReader(is , "" , true);
        org.junit.Assert.assertEquals(xmlReader.getEncoding(), "UTF-8");
        xmlReader.close();
    }

    private static final int[] NO_BOM_BYTES = new int[]{  };

    private static final int[] UTF_16BE_BOM_BYTES = new int[]{ 254 , 255 };

    private static final int[] UTF_16LE_BOM_BYTES = new int[]{ 255 , 254 };

    private static final int[] UTF_32BE_BOM_BYTES = new int[]{ 0 , 0 , 254 , 255 };

    private static final int[] UTF_32LE_BOM_BYTES = new int[]{ 255 , 254 , 0 , 0 };

    private static final int[] UTF_8_BOM_BYTES = new int[]{ 239 , 187 , 191 };

    private static final java.util.Map<java.lang.String, int[]> BOMs = new java.util.HashMap<java.lang.String, int[]>();

    static {
        BOMs.put("no-bom", NO_BOM_BYTES);
        BOMs.put("UTF-16BE-bom", UTF_16BE_BOM_BYTES);
        BOMs.put("UTF-16LE-bom", UTF_16LE_BOM_BYTES);
        BOMs.put("UTF-32BE-bom", UTF_32BE_BOM_BYTES);
        BOMs.put("UTF-32LE-bom", UTF_32LE_BOM_BYTES);
        BOMs.put("UTF-16-bom", NO_BOM_BYTES);
        BOMs.put("UTF-8-bom", UTF_8_BOM_BYTES);
    }

    private static final java.text.MessageFormat XML = new java.text.MessageFormat("<root>{2}</root>");

    private static final java.text.MessageFormat XML_WITH_PROLOG = new java.text.MessageFormat("<?xml version=\"1.0\"?>\n<root>{2}</root>");

    private static final java.text.MessageFormat XML_WITH_PROLOG_AND_ENCODING_DOUBLE_QUOTES = new java.text.MessageFormat("<?xml version=\"1.0\" encoding=\"{1}\"?>\n<root>{2}</root>");

    private static final java.text.MessageFormat XML_WITH_PROLOG_AND_ENCODING_SINGLE_QUOTES = new java.text.MessageFormat("<?xml version=\"1.0\" encoding=\'\'{1}\'\'?>\n<root>{2}</root>");

    private static final java.text.MessageFormat XML_WITH_PROLOG_AND_ENCODING_SPACED_SINGLE_QUOTES = new java.text.MessageFormat("<?xml version=\"1.0\" encoding =  \t \n \r\'\'{1}\'\'?>\n<root>{2}</root>");

    private static final java.text.MessageFormat INFO = new java.text.MessageFormat("\nBOM : {0}\nDoc : {1}\nStream Enc : {2}\nProlog Enc : {3}\n");

    private static final java.util.Map<java.lang.String, java.text.MessageFormat> XMLs = new java.util.HashMap<java.lang.String, java.text.MessageFormat>();

    static {
        XMLs.put(XML1, XML);
        XMLs.put(XML2, XML_WITH_PROLOG);
        XMLs.put(XML3, XML_WITH_PROLOG_AND_ENCODING_DOUBLE_QUOTES);
        XMLs.put(XML4, XML_WITH_PROLOG_AND_ENCODING_SINGLE_QUOTES);
        XMLs.put(XML5, XML_WITH_PROLOG_AND_ENCODING_SPACED_SINGLE_QUOTES);
    }

    protected java.io.InputStream a(final java.lang.String bomType, final java.lang.String xmlType, final java.lang.String streamEnc, final java.lang.String prologEnc) throws java.io.IOException {
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(1024);
        int[] bom = BOMs.get(bomType);
        if (bom == null) {
            bom = new int[0];
        } 
        for (final int element : bom) {
            baos.write(element);
        }
        final java.io.Writer writer = new java.io.OutputStreamWriter(baos , streamEnc);
        final java.lang.String xmlDoc = getXML(bomType, xmlType, streamEnc, prologEnc);
        writer.write(xmlDoc);
        writer.write("<da>\n");
        for (int i = 0 ; i < 10000 ; i++) {
            writer.write("<do/>\n");
        }
        writer.write("</da>\n");
        writer.close();
        return new java.io.ByteArrayInputStream(baos.toByteArray());
    }

    private java.lang.String b(final java.lang.String bomType, final java.lang.String xmlType, final java.lang.String streamEnc, final java.lang.String prologEnc) {
        final java.text.MessageFormat xml = XMLs.get(xmlType);
        final java.lang.String info = INFO.format(new java.lang.Object[]{ bomType , xmlType , prologEnc });
        final java.lang.String xmlDoc = xml.format(new java.lang.Object[]{ streamEnc , prologEnc , info });
        return xmlDoc;
    }
}


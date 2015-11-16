package org.apache.commons.io.input;


public class XmlStreamReaderUtilitiesTest {
    private static java.lang.String RAWMGS1 = "encoding mismatch";

    private static java.lang.String RAWMGS2 = "unknown BOM";

    private static java.lang.String HTTPMGS1 = "BOM must be NULL";

    private static java.lang.String HTTPMGS2 = "encoding mismatch";

    private static java.lang.String HTTPMGS3 = "Invalid MIME";

    private static java.lang.String APPXML = "application/xml";

    private static java.lang.String APPXML_UTF8 = "application/xml;charset=UTF-8";

    private static java.lang.String APPXML_UTF16 = "application/xml;charset=UTF-16";

    private static java.lang.String APPXML_UTF32 = "application/xml;charset=UTF-32";

    private static java.lang.String APPXML_UTF16BE = "application/xml;charset=UTF-16BE";

    private static java.lang.String APPXML_UTF16LE = "application/xml;charset=UTF-16LE";

    private static java.lang.String APPXML_UTF32BE = "application/xml;charset=UTF-32BE";

    private static java.lang.String APPXML_UTF32LE = "application/xml;charset=UTF-32LE";

    private static java.lang.String TXTXML = "text/xml";

    @org.junit.Test
    public void i() {
        checkContentTypeEncoding(null, null);
        checkContentTypeEncoding(null, "");
        checkContentTypeEncoding(null, "application/xml");
        checkContentTypeEncoding(null, "application/xml;");
        checkContentTypeEncoding(null, "multipart/mixed;boundary=frontier");
        checkContentTypeEncoding(null, "multipart/mixed;boundary=\'frontier\'");
        checkContentTypeEncoding(null, "multipart/mixed;boundary=\"frontier\"");
        checkContentTypeEncoding("UTF-16", "application/xml;charset=utf-16");
        checkContentTypeEncoding("UTF-16", "application/xml;charset=UTF-16");
        checkContentTypeEncoding("UTF-16", "application/xml;charset=\'UTF-16\'");
        checkContentTypeEncoding("UTF-16", "application/xml;charset=\"UTF-16\"");
        checkContentTypeEncoding("UTF-32", "application/xml;charset=utf-32");
        checkContentTypeEncoding("UTF-32", "application/xml;charset=UTF-32");
        checkContentTypeEncoding("UTF-32", "application/xml;charset=\'UTF-32\'");
        checkContentTypeEncoding("UTF-32", "application/xml;charset=\"UTF-32\"");
    }

    private void a(final java.lang.String expected, final java.lang.String httpContentType) {
        org.junit.Assert.assertEquals((("ContentTypeEncoding=[" + httpContentType) + "]"), expected, org.apache.commons.io.input.XmlStreamReader.getContentTypeEncoding(httpContentType));
    }

    @org.junit.Test
    public void j() {
        checkContentTypeMime(null, null);
        checkContentTypeMime("", "");
        checkContentTypeMime("application/xml", "application/xml");
        checkContentTypeMime("application/xml", "application/xml;");
        checkContentTypeMime("application/xml", "application/xml;charset=utf-16");
        checkContentTypeMime("application/xml", "application/xml;charset=utf-32");
    }

    private void b(final java.lang.String expected, final java.lang.String httpContentType) {
        org.junit.Assert.assertEquals((("ContentTypeMime=[" + httpContentType) + "]"), expected, org.apache.commons.io.input.XmlStreamReader.getContentTypeMime(httpContentType));
    }

    @org.junit.Test
    public void a() {
        checkAppXml(false, null);
        checkAppXml(false, "");
        checkAppXml(true, "application/xml");
        checkAppXml(true, "application/xml-dtd");
        checkAppXml(true, "application/xml-external-parsed-entity");
        checkAppXml(true, "application/soap+xml");
        checkAppXml(true, "application/atom+xml");
        checkAppXml(false, "application/atomxml");
        checkAppXml(false, "text/xml");
        checkAppXml(false, "text/atom+xml");
        checkAppXml(true, "application/xml-dtd");
        checkAppXml(true, "application/xml-external-parsed-entity");
    }

    @java.lang.SuppressWarnings(value = "boxing")
    private void a(final boolean expected, final java.lang.String mime) {
        org.junit.Assert.assertEquals((("Mime=[" + mime) + "]"), expected, org.apache.commons.io.input.XmlStreamReader.isAppXml(mime));
    }

    @org.junit.Test
    public void k() {
        checkTextXml(false, null);
        checkTextXml(false, "");
        checkTextXml(true, "text/xml");
        checkTextXml(true, "text/xml-external-parsed-entity");
        checkTextXml(true, "text/soap+xml");
        checkTextXml(true, "text/atom+xml");
        checkTextXml(false, "text/atomxml");
        checkTextXml(false, "application/xml");
        checkTextXml(false, "application/atom+xml");
    }

    @java.lang.SuppressWarnings(value = "boxing")
    private void b(final boolean expected, final java.lang.String mime) {
        org.junit.Assert.assertEquals((("Mime=[" + mime) + "]"), expected, org.apache.commons.io.input.XmlStreamReader.isTextXml(mime));
    }

    @org.junit.Test
    public void f() throws java.io.IOException {
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS2, "UTF-32", null, null, null);
        checkRawEncoding("UTF-8", null, null, null, null);
        checkRawEncoding("UTF-8", null, "UTF-16BE", null, null);
        checkRawEncoding("UTF-8", null, null, "UTF-16BE", null);
        checkRawEncoding("UTF-8", null, "UTF-8", "UTF-8", "UTF-16BE");
        checkRawEncoding("UTF-16BE", null, "UTF-16BE", "UTF-16BE", null);
        checkRawEncoding("UTF-16BE", null, null, null, "UTF-16BE");
        checkRawEncoding("UTF-16BE", null, "UTF-8", null, "UTF-16BE");
        checkRawEncoding("UTF-16BE", null, null, "UTF-8", "UTF-16BE");
        checkRawEncoding("UTF-16BE", null, "UTF-16BE", "UTF-16", null);
        checkRawEncoding("UTF-16LE", null, "UTF-16LE", "UTF-16", null);
    }

    @org.junit.Test
    public void g() throws java.io.IOException {
        testCalculateRawEncodingStandard("UTF-8", "UTF-16BE", "UTF-16LE");
        testCalculateRawEncodingStandard("UTF-16BE", "UTF-8", "UTF-16LE");
        testCalculateRawEncodingStandard("UTF-16LE", "UTF-8", "UTF-16BE");
    }

    @org.junit.Test
    public void h() throws java.io.IOException {
        testCalculateRawEncodingStandard("UTF-8", "UTF-32BE", "UTF-32LE");
        testCalculateRawEncodingStandard("UTF-32BE", "UTF-8", "UTF-32LE");
        testCalculateRawEncodingStandard("UTF-32LE", "UTF-8", "UTF-32BE");
    }

    private void a(final java.lang.String bomEnc, final java.lang.String otherEnc, final java.lang.String defaultEnc) throws java.io.IOException {
        checkRawEncoding(bomEnc, bomEnc, null, null, defaultEnc);
        checkRawEncoding(bomEnc, bomEnc, bomEnc, null, defaultEnc);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, bomEnc, otherEnc, null, defaultEnc);
        checkRawEncoding(bomEnc, bomEnc, null, bomEnc, defaultEnc);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, bomEnc, null, otherEnc, defaultEnc);
        checkRawEncoding(bomEnc, bomEnc, bomEnc, bomEnc, defaultEnc);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, bomEnc, bomEnc, otherEnc, defaultEnc);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, bomEnc, otherEnc, bomEnc, defaultEnc);
    }

    @org.junit.Test
    public void d() throws java.io.IOException {
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-16BE", "UTF-16", null, null);
        checkRawEncoding("UTF-16BE", "UTF-16BE", null, "UTF-16", null);
        checkRawEncoding("UTF-16BE", "UTF-16BE", "UTF-16BE", "UTF-16", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-16BE", null, "UTF-16LE", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-16BE", "UTF-16BE", "UTF-16LE", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-16LE", "UTF-16", null, null);
        checkRawEncoding("UTF-16LE", "UTF-16LE", null, "UTF-16", null);
        checkRawEncoding("UTF-16LE", "UTF-16LE", "UTF-16LE", "UTF-16", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-16LE", null, "UTF-16BE", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-16LE", "UTF-16LE", "UTF-16BE", null);
    }

    @org.junit.Test
    public void e() throws java.io.IOException {
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-32BE", "UTF-32", null, null);
        checkRawEncoding("UTF-32BE", "UTF-32BE", null, "UTF-32", null);
        checkRawEncoding("UTF-32BE", "UTF-32BE", "UTF-32BE", "UTF-32", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-32BE", null, "UTF-32LE", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-32BE", "UTF-32BE", "UTF-32LE", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-32LE", "UTF-32", null, null);
        checkRawEncoding("UTF-32LE", "UTF-32LE", null, "UTF-32", null);
        checkRawEncoding("UTF-32LE", "UTF-32LE", "UTF-32LE", "UTF-32", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-32LE", null, "UTF-32BE", null);
        checkRawError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.RAWMGS1, "UTF-32LE", "UTF-32LE", "UTF-32BE", null);
    }

    private void a(final java.lang.String expected, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.lang.String defaultEncoding) throws java.io.IOException {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        builder.append("RawEncoding: ").append(bomEnc).append("], ");
        builder.append("bomEnc=[").append(bomEnc).append("], ");
        builder.append("xmlGuessEnc=[").append(xmlGuessEnc).append("], ");
        builder.append("xmlEnc=[").append(xmlEnc).append("], ");
        builder.append("defaultEncoding=[").append(defaultEncoding).append("],");
        final java.lang.String encoding = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc, defaultEncoding);
        org.junit.Assert.assertEquals(builder.toString(), expected, encoding);
    }

    protected java.lang.String a(final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.lang.String defaultEncoding) throws java.io.IOException {
        final org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.MockXmlStreamReader mock = new org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.MockXmlStreamReader(defaultEncoding);
        final java.lang.String enc = mock.calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
        mock.close();
        return enc;
    }

    private void b(final java.lang.String msgSuffix, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.lang.String defaultEncoding) {
        try {
            checkRawEncoding("XmlStreamReaderException", bomEnc, xmlGuessEnc, xmlEnc, defaultEncoding);
            org.junit.Assert.fail("Expected XmlStreamReaderException");
        } catch (final org.apache.commons.io.input.XmlStreamReaderException e) {
            org.junit.Assert.assertTrue(("Msg Start: " + (e.getMessage())), e.getMessage().startsWith("Invalid encoding"));
            org.junit.Assert.assertTrue(("Msg End: " + (e.getMessage())), e.getMessage().endsWith(msgSuffix));
            org.junit.Assert.assertEquals("bomEnc", bomEnc, e.getBomEncoding());
            org.junit.Assert.assertEquals("xmlGuessEnc", xmlGuessEnc, e.getXmlGuessEncoding());
            org.junit.Assert.assertEquals("xmlEnc", xmlEnc, e.getXmlEncoding());
            org.junit.Assert.assertNull("ContentTypeEncoding", e.getContentTypeEncoding());
            org.junit.Assert.assertNull("ContentTypeMime", e.getContentTypeMime());
        } catch (final java.lang.Exception e) {
            org.junit.Assert.fail(("Expected XmlStreamReaderException, but threw " + e));
        }
    }

    @org.junit.Test
    public void b() throws java.io.IOException {
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS3, true, null, null, null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS3, false, null, null, null, "UTF-8", null);
        checkHttpEncoding("UTF-8", true, null, null, null, "UTF-8", null);
        checkHttpEncoding("UTF-16LE", true, null, null, null, "UTF-16LE", null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS3, false, "text/css", null, null, null, null);
        checkHttpEncoding("US-ASCII", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.TXTXML, null, null, null, null);
        checkHttpEncoding("UTF-16BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.TXTXML, null, null, null, "UTF-16BE");
        checkHttpEncoding("UTF-8", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML, null, null, null, null);
        checkHttpEncoding("UTF-16BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML, null, null, null, "UTF-16BE");
        checkHttpEncoding("UTF-8", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML, "UTF-8", null, null, "UTF-16BE");
        checkHttpEncoding("UTF-16LE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16LE, null, null, null, null);
        checkHttpEncoding("UTF-16BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16BE, null, null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS1, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16LE, "UTF-16LE", null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS1, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16BE, "UTF-16BE", null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS2, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16, null, null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS2, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16, "UTF-8", null, null, null);
        checkHttpEncoding("UTF-16LE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16, "UTF-16LE", null, null, null);
        checkHttpEncoding("UTF-16BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF16, "UTF-16BE", null, null, null);
        checkHttpEncoding("UTF-8", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF8, null, null, null, null);
        checkHttpEncoding("UTF-8", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF8, "UTF-16BE", "UTF-16BE", "UTF-16BE", "UTF-16BE");
    }

    @org.junit.Test
    public void c() throws java.io.IOException {
        checkHttpEncoding("UTF-32LE", true, null, null, null, "UTF-32LE", null);
        checkHttpEncoding("UTF-32BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.TXTXML, null, null, null, "UTF-32BE");
        checkHttpEncoding("UTF-32BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML, null, null, null, "UTF-32BE");
        checkHttpEncoding("UTF-32LE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32LE, null, null, null, null);
        checkHttpEncoding("UTF-32BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32BE, null, null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS1, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32LE, "UTF-32LE", null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS1, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32BE, "UTF-32BE", null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS2, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32, null, null, null, null);
        checkHttpError(org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.HTTPMGS2, false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32, "UTF-8", null, null, null);
        checkHttpEncoding("UTF-32LE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32, "UTF-32LE", null, null, null);
        checkHttpEncoding("UTF-32BE", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF32, "UTF-32BE", null, null, null);
        checkHttpEncoding("UTF-8", false, org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.APPXML_UTF8, "UTF-32BE", "UTF-32BE", "UTF-32BE", "UTF-32BE");
    }

    private void a(final java.lang.String expected, final boolean lenient, final java.lang.String httpContentType, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.lang.String defaultEncoding) throws java.io.IOException {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        builder.append("HttpEncoding=[").append(bomEnc).append("], ");
        builder.append("lenient=[").append(lenient).append("], ");
        builder.append("httpContentType=[").append(httpContentType).append("], ");
        builder.append("bomEnc=[").append(bomEnc).append("], ");
        builder.append("xmlGuessEnc=[").append(xmlGuessEnc).append("], ");
        builder.append("xmlEnc=[").append(xmlEnc).append("], ");
        builder.append("defaultEncoding=[").append(defaultEncoding).append("],");
        final java.lang.String encoding = calculateHttpEncoding(httpContentType, bomEnc, xmlGuessEnc, xmlEnc, lenient, defaultEncoding);
        org.junit.Assert.assertEquals(builder.toString(), expected, encoding);
    }

    protected java.lang.String a(final java.lang.String httpContentType, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final boolean lenient, final java.lang.String defaultEncoding) throws java.io.IOException {
        final org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.MockXmlStreamReader mock = new org.apache.commons.io.input.XmlStreamReaderUtilitiesTest.MockXmlStreamReader(defaultEncoding);
        final java.lang.String enc = mock.calculateHttpEncoding(httpContentType, bomEnc, xmlGuessEnc, xmlEnc, lenient);
        mock.close();
        return enc;
    }

    private void b(final java.lang.String msgSuffix, final boolean lenient, final java.lang.String httpContentType, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.lang.String defaultEncoding) {
        try {
            checkHttpEncoding("XmlStreamReaderException", lenient, httpContentType, bomEnc, xmlGuessEnc, xmlEnc, defaultEncoding);
            org.junit.Assert.fail("Expected XmlStreamReaderException");
        } catch (final org.apache.commons.io.input.XmlStreamReaderException e) {
            org.junit.Assert.assertTrue(("Msg Start: " + (e.getMessage())), e.getMessage().startsWith("Invalid encoding"));
            org.junit.Assert.assertTrue(("Msg End: " + (e.getMessage())), e.getMessage().endsWith(msgSuffix));
            org.junit.Assert.assertEquals("bomEnc", bomEnc, e.getBomEncoding());
            org.junit.Assert.assertEquals("xmlGuessEnc", xmlGuessEnc, e.getXmlGuessEncoding());
            org.junit.Assert.assertEquals("xmlEnc", xmlEnc, e.getXmlEncoding());
            org.junit.Assert.assertEquals("ContentTypeEncoding", org.apache.commons.io.input.XmlStreamReader.getContentTypeEncoding(httpContentType), e.getContentTypeEncoding());
            org.junit.Assert.assertEquals("ContentTypeMime", org.apache.commons.io.input.XmlStreamReader.getContentTypeMime(httpContentType), e.getContentTypeMime());
        } catch (final java.lang.Exception e) {
            org.junit.Assert.fail(("Expected XmlStreamReaderException, but threw " + e));
        }
    }

    private static class MockXmlStreamReader extends org.apache.commons.io.input.XmlStreamReader {
        MockXmlStreamReader(final java.lang.String defaultEncoding) throws java.io.IOException {
            super(new java.io.ByteArrayInputStream("".getBytes()), null, true, defaultEncoding);
        }
    }
}


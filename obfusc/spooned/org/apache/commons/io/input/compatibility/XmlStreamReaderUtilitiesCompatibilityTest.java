package org.apache.commons.io.input.compatibility;


public class XmlStreamReaderUtilitiesCompatibilityTest extends org.apache.commons.io.input.XmlStreamReaderUtilitiesTest {
    @java.lang.Override
    protected java.lang.String a(final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.lang.String defaultEncoding) throws java.io.IOException {
        final org.apache.commons.io.input.compatibility.XmlStreamReaderUtilitiesCompatibilityTest.MockXmlStreamReader mock = new org.apache.commons.io.input.compatibility.XmlStreamReaderUtilitiesCompatibilityTest.MockXmlStreamReader(defaultEncoding);
        final java.lang.String enc = mock.calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc, null);
        mock.close();
        return enc;
    }

    @java.lang.Override
    protected java.lang.String a(final java.lang.String httpContentType, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final boolean lenient, final java.lang.String defaultEncoding) throws java.io.IOException {
        final org.apache.commons.io.input.compatibility.XmlStreamReaderUtilitiesCompatibilityTest.MockXmlStreamReader mock = new org.apache.commons.io.input.compatibility.XmlStreamReaderUtilitiesCompatibilityTest.MockXmlStreamReader(defaultEncoding);
        java.lang.String enc = mock.calculateHttpEncoding(org.apache.commons.io.input.compatibility.XmlStreamReader.getContentTypeMime(httpContentType), org.apache.commons.io.input.compatibility.XmlStreamReader.getContentTypeEncoding(httpContentType), bomEnc, xmlGuessEnc, xmlEnc, null, lenient);
        mock.close();
        return enc;
    }

    private static class MockXmlStreamReader extends org.apache.commons.io.input.compatibility.XmlStreamReader {
        MockXmlStreamReader(final java.lang.String defaultEncoding) throws java.io.IOException {
            super(new java.io.ByteArrayInputStream("".getBytes()), null, true, defaultEncoding);
        }
    }
}


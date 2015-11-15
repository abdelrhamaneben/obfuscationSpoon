package org.apache.commons.io.input;


public class XmlStreamReaderException extends java.io.IOException {
    private static final long serialVersionUID = 1L;

    private final java.lang.String bomEncoding;

    private final java.lang.String xmlGuessEncoding;

    private final java.lang.String xmlEncoding;

    private final java.lang.String contentTypeMime;

    private final java.lang.String contentTypeEncoding;

    public XmlStreamReaderException(final java.lang.String msg ,final java.lang.String bomEnc ,final java.lang.String xmlGuessEnc ,final java.lang.String xmlEnc) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc);
    }

    public XmlStreamReaderException(final java.lang.String msg ,final java.lang.String ctMime ,final java.lang.String ctEnc ,final java.lang.String bomEnc ,final java.lang.String xmlGuessEnc ,final java.lang.String xmlEnc) {
        super(msg);
        contentTypeMime = ctMime;
        contentTypeEncoding = ctEnc;
        bomEncoding = bomEnc;
        xmlGuessEncoding = xmlGuessEnc;
        xmlEncoding = xmlEnc;
    }

    public java.lang.String a() {
        return bomEncoding;
    }

    public java.lang.String e() {
        return xmlGuessEncoding;
    }

    public java.lang.String d() {
        return xmlEncoding;
    }

    public java.lang.String c() {
        return contentTypeMime;
    }

    public java.lang.String b() {
        return contentTypeEncoding;
    }
}


package org.apache.commons.io.input.compatibility;


public class XmlStreamReaderException extends org.apache.commons.io.input.XmlStreamReaderException {
    private static final long serialVersionUID = 1L;

    private final java.io.InputStream is;

    public XmlStreamReaderException(final java.lang.String msg ,final java.lang.String bomEnc ,final java.lang.String xmlGuessEnc ,final java.lang.String xmlEnc ,final java.io.InputStream is) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc, is);
    }

    public XmlStreamReaderException(final java.lang.String msg ,final java.lang.String ctMime ,final java.lang.String ctEnc ,final java.lang.String bomEnc ,final java.lang.String xmlGuessEnc ,final java.lang.String xmlEnc ,final java.io.InputStream is) {
        super(msg, ctMime, ctEnc, bomEnc, xmlGuessEnc, xmlEnc);
        this.is = is;
    }

    public java.io.InputStream a() {
        return is;
    }
}


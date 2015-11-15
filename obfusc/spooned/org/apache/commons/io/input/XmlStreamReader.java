package org.apache.commons.io.input;


public class XmlStreamReader extends java.io.Reader {
    private static final int BUFFER_SIZE = 4096;

    private static final java.lang.String UTF_8 = "UTF-8";

    private static final java.lang.String US_ASCII = "US-ASCII";

    private static final java.lang.String UTF_16BE = "UTF-16BE";

    private static final java.lang.String UTF_16LE = "UTF-16LE";

    private static final java.lang.String UTF_32BE = "UTF-32BE";

    private static final java.lang.String UTF_32LE = "UTF-32LE";

    private static final java.lang.String UTF_16 = "UTF-16";

    private static final java.lang.String UTF_32 = "UTF-32";

    private static final java.lang.String EBCDIC = "CP1047";

    private static final org.apache.commons.io.ByteOrderMark[] BOMS = new org.apache.commons.io.ByteOrderMark[]{ org.apache.commons.io.ByteOrderMark.UTF_8 , org.apache.commons.io.ByteOrderMark.UTF_16BE , org.apache.commons.io.ByteOrderMark.UTF_16LE , org.apache.commons.io.ByteOrderMark.UTF_32BE , org.apache.commons.io.ByteOrderMark.UTF_32LE };

    private static final org.apache.commons.io.ByteOrderMark[] XML_GUESS_BYTES = new org.apache.commons.io.ByteOrderMark[]{ new org.apache.commons.io.ByteOrderMark(UTF_8 , 60 , 63 , 120 , 109) , new org.apache.commons.io.ByteOrderMark(UTF_16BE , 0 , 60 , 0 , 63) , new org.apache.commons.io.ByteOrderMark(UTF_16LE , 60 , 0 , 63 , 0) , new org.apache.commons.io.ByteOrderMark(UTF_32BE , 0 , 0 , 0 , 60 , 0 , 0 , 0 , 63 , 0 , 0 , 0 , 120 , 0 , 0 , 0 , 109) , new org.apache.commons.io.ByteOrderMark(UTF_32LE , 60 , 0 , 0 , 0 , 63 , 0 , 0 , 0 , 120 , 0 , 0 , 0 , 109 , 0 , 0 , 0) , new org.apache.commons.io.ByteOrderMark(EBCDIC , 76 , 111 , 167 , 148) };

    private final java.io.Reader reader;

    private final java.lang.String encoding;

    private final java.lang.String defaultEncoding;

    public java.lang.String a() {
        return defaultEncoding;
    }

    public XmlStreamReader(final java.io.File file) throws java.io.IOException {
        this(new java.io.FileInputStream(file));
    }

    public XmlStreamReader(final java.io.InputStream is) throws java.io.IOException {
        this(is, true);
    }

    public XmlStreamReader(final java.io.InputStream is ,final boolean lenient) throws java.io.IOException {
        this(is, lenient, null);
    }

    public XmlStreamReader(final java.io.InputStream is ,final boolean lenient ,final java.lang.String defaultEncoding) throws java.io.IOException {
        this.defaultEncoding = defaultEncoding;
        final org.apache.commons.io.input.BOMInputStream bom = new org.apache.commons.io.input.BOMInputStream(new java.io.BufferedInputStream(is , BUFFER_SIZE) , false , BOMS);
        final org.apache.commons.io.input.BOMInputStream pis = new org.apache.commons.io.input.BOMInputStream(bom , true , XML_GUESS_BYTES);
        this.encoding = doRawStream(bom, pis, lenient);
        this.reader = new java.io.InputStreamReader(pis , encoding);
    }

    public XmlStreamReader(final java.net.URL url) throws java.io.IOException {
        this(url.openConnection(), null);
    }

    public XmlStreamReader(final java.net.URLConnection conn ,final java.lang.String defaultEncoding) throws java.io.IOException {
        this.defaultEncoding = defaultEncoding;
        final boolean lenient = true;
        final java.lang.String contentType = conn.getContentType();
        final java.io.InputStream is = conn.getInputStream();
        final org.apache.commons.io.input.BOMInputStream bom = new org.apache.commons.io.input.BOMInputStream(new java.io.BufferedInputStream(is , BUFFER_SIZE) , false , BOMS);
        final org.apache.commons.io.input.BOMInputStream pis = new org.apache.commons.io.input.BOMInputStream(bom , true , XML_GUESS_BYTES);
        if ((conn instanceof java.net.HttpURLConnection) || (contentType != null)) {
            this.encoding = doHttpStream(bom, pis, contentType, lenient);
        } else {
            this.encoding = doRawStream(bom, pis, lenient);
        }
        this.reader = new java.io.InputStreamReader(pis , encoding);
    }

    public XmlStreamReader(final java.io.InputStream is ,final java.lang.String httpContentType) throws java.io.IOException {
        this(is, httpContentType, true);
    }

    public XmlStreamReader(final java.io.InputStream is ,final java.lang.String httpContentType ,final boolean lenient ,final java.lang.String defaultEncoding) throws java.io.IOException {
        this.defaultEncoding = defaultEncoding;
        final org.apache.commons.io.input.BOMInputStream bom = new org.apache.commons.io.input.BOMInputStream(new java.io.BufferedInputStream(is , BUFFER_SIZE) , false , BOMS);
        final org.apache.commons.io.input.BOMInputStream pis = new org.apache.commons.io.input.BOMInputStream(bom , true , XML_GUESS_BYTES);
        this.encoding = doHttpStream(bom, pis, httpContentType, lenient);
        this.reader = new java.io.InputStreamReader(pis , encoding);
    }

    public XmlStreamReader(final java.io.InputStream is ,final java.lang.String httpContentType ,final boolean lenient) throws java.io.IOException {
        this(is, httpContentType, lenient, null);
    }

    public java.lang.String b() {
        return encoding;
    }

    @java.lang.Override
    public int read(final char[] buf, final int offset, final int len) throws java.io.IOException {
        return reader.read(buf, offset, len);
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        reader.close();
    }

    private java.lang.String a(final org.apache.commons.io.input.BOMInputStream bom, final org.apache.commons.io.input.BOMInputStream pis, final boolean lenient) throws java.io.IOException {
        final java.lang.String bomEnc = bom.getBOMCharsetName();
        final java.lang.String xmlGuessEnc = pis.getBOMCharsetName();
        final java.lang.String xmlEnc = org.apache.commons.io.input.XmlStreamReader.getXmlProlog(pis, xmlGuessEnc);
        try {
            return calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
        } catch (final org.apache.commons.io.input.XmlStreamReaderException ex) {
            if (lenient) {
                return doLenientDetection(null, ex);
            } else {
                throw ex;
            }
        }
    }

    private java.lang.String a(final org.apache.commons.io.input.BOMInputStream bom, final org.apache.commons.io.input.BOMInputStream pis, final java.lang.String httpContentType, final boolean lenient) throws java.io.IOException {
        final java.lang.String bomEnc = bom.getBOMCharsetName();
        final java.lang.String xmlGuessEnc = pis.getBOMCharsetName();
        final java.lang.String xmlEnc = org.apache.commons.io.input.XmlStreamReader.getXmlProlog(pis, xmlGuessEnc);
        try {
            return calculateHttpEncoding(httpContentType, bomEnc, xmlGuessEnc, xmlEnc, lenient);
        } catch (final org.apache.commons.io.input.XmlStreamReaderException ex) {
            if (lenient) {
                return doLenientDetection(httpContentType, ex);
            } else {
                throw ex;
            }
        }
    }

    private java.lang.String a(java.lang.String httpContentType, org.apache.commons.io.input.XmlStreamReaderException ex) throws java.io.IOException {
        if ((httpContentType != null) && (httpContentType.startsWith("text/html"))) {
            httpContentType = httpContentType.substring("text/html".length());
            httpContentType = "text/xml" + httpContentType;
            try {
                return calculateHttpEncoding(httpContentType, ex.getBomEncoding(), ex.getXmlGuessEncoding(), ex.getXmlEncoding(), true);
            } catch (final org.apache.commons.io.input.XmlStreamReaderException ex2) {
                ex = ex2;
            }
        } 
        java.lang.String encoding = ex.getXmlEncoding();
        if (encoding == null) {
            encoding = ex.getContentTypeEncoding();
        } 
        if (encoding == null) {
            encoding = (defaultEncoding) == null ? UTF_8 : defaultEncoding;
        } 
        return encoding;
    }

    java.lang.String a(final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc) throws java.io.IOException {
        if (bomEnc == null) {
            if ((xmlGuessEnc == null) || (xmlEnc == null)) {
                return (defaultEncoding) == null ? UTF_8 : defaultEncoding;
            } 
            if ((xmlEnc.equals(UTF_16)) && ((xmlGuessEnc.equals(UTF_16BE)) || (xmlGuessEnc.equals(UTF_16LE)))) {
                return xmlGuessEnc;
            } 
            return xmlEnc;
        } 
        if (bomEnc.equals(UTF_8)) {
            if ((xmlGuessEnc != null) && (!(xmlGuessEnc.equals(UTF_8)))) {
                final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_1, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            if ((xmlEnc != null) && (!(xmlEnc.equals(UTF_8)))) {
                final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_1, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            return bomEnc;
        } 
        if ((bomEnc.equals(UTF_16BE)) || (bomEnc.equals(UTF_16LE))) {
            if ((xmlGuessEnc != null) && (!(xmlGuessEnc.equals(bomEnc)))) {
                final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_1, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            if (((xmlEnc != null) && (!(xmlEnc.equals(UTF_16)))) && (!(xmlEnc.equals(bomEnc)))) {
                final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_1, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            return bomEnc;
        } 
        if ((bomEnc.equals(UTF_32BE)) || (bomEnc.equals(UTF_32LE))) {
            if ((xmlGuessEnc != null) && (!(xmlGuessEnc.equals(bomEnc)))) {
                final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_1, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            if (((xmlEnc != null) && (!(xmlEnc.equals(UTF_32)))) && (!(xmlEnc.equals(bomEnc)))) {
                final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_1, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            return bomEnc;
        } 
        final java.lang.String msg = java.text.MessageFormat.format(RAW_EX_2, bomEnc, xmlGuessEnc, xmlEnc);
        throw new org.apache.commons.io.input.XmlStreamReaderException(msg , bomEnc , xmlGuessEnc , xmlEnc);
    }

    java.lang.String a(final java.lang.String httpContentType, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final boolean lenient) throws java.io.IOException {
        if (lenient && (xmlEnc != null)) {
            return xmlEnc;
        } 
        final java.lang.String cTMime = org.apache.commons.io.input.XmlStreamReader.getContentTypeMime(httpContentType);
        final java.lang.String cTEnc = org.apache.commons.io.input.XmlStreamReader.getContentTypeEncoding(httpContentType);
        final boolean appXml = org.apache.commons.io.input.XmlStreamReader.isAppXml(cTMime);
        final boolean textXml = org.apache.commons.io.input.XmlStreamReader.isTextXml(cTMime);
        if ((!appXml) && (!textXml)) {
            final java.lang.String msg = java.text.MessageFormat.format(HTTP_EX_3, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            throw new org.apache.commons.io.input.XmlStreamReaderException(msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc);
        } 
        if (cTEnc == null) {
            if (appXml) {
                return calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
            } else {
                return (defaultEncoding) == null ? US_ASCII : defaultEncoding;
            }
        } 
        if ((cTEnc.equals(UTF_16BE)) || (cTEnc.equals(UTF_16LE))) {
            if (bomEnc != null) {
                final java.lang.String msg = java.text.MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            return cTEnc;
        } 
        if (cTEnc.equals(UTF_16)) {
            if ((bomEnc != null) && (bomEnc.startsWith(UTF_16))) {
                return bomEnc;
            } 
            final java.lang.String msg = java.text.MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            throw new org.apache.commons.io.input.XmlStreamReaderException(msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc);
        } 
        if ((cTEnc.equals(UTF_32BE)) || (cTEnc.equals(UTF_32LE))) {
            if (bomEnc != null) {
                final java.lang.String msg = java.text.MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                throw new org.apache.commons.io.input.XmlStreamReaderException(msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc);
            } 
            return cTEnc;
        } 
        if (cTEnc.equals(UTF_32)) {
            if ((bomEnc != null) && (bomEnc.startsWith(UTF_32))) {
                return bomEnc;
            } 
            final java.lang.String msg = java.text.MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            throw new org.apache.commons.io.input.XmlStreamReaderException(msg , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc);
        } 
        return cTEnc;
    }

    static java.lang.String d(final java.lang.String httpContentType) {
        java.lang.String mime = null;
        if (httpContentType != null) {
            final int i = httpContentType.indexOf(";");
            if (i >= 0) {
                mime = httpContentType.substring(0, i);
            } else {
                mime = httpContentType;
            }
            mime = mime.trim();
        } 
        return mime;
    }

    private static final java.util.regex.Pattern CHARSET_PATTERN = java.util.regex.Pattern.compile("charset=[\"\']?([.[^; \"\']]*)[\"\']?");

    static java.lang.String c(final java.lang.String httpContentType) {
        java.lang.String encoding = null;
        if (httpContentType != null) {
            final int i = httpContentType.indexOf(";");
            if (i > (-1)) {
                final java.lang.String postMime = httpContentType.substring((i + 1));
                final java.util.regex.Matcher m = CHARSET_PATTERN.matcher(postMime);
                encoding = m.find() ? m.group(1) : null;
                encoding = encoding != null ? encoding.toUpperCase(java.util.Locale.US) : null;
            } 
        } 
        return encoding;
    }

    public static final java.util.regex.Pattern ENCODING_PATTERN = java.util.regex.Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:\'.[^\']*\'))", java.util.regex.Pattern.MULTILINE);

    private static java.lang.String a(final java.io.InputStream is, final java.lang.String guessedEnc) throws java.io.IOException {
        java.lang.String encoding = null;
        if (guessedEnc != null) {
            final byte[] bytes = new byte[BUFFER_SIZE];
            is.mark(BUFFER_SIZE);
            int offset = 0;
            int max = BUFFER_SIZE;
            int c = is.read(bytes, offset, max);
            int firstGT = -1;
            java.lang.String xmlProlog = "";
            while (((c != (-1)) && (firstGT == (-1))) && (offset < (BUFFER_SIZE))) {
                offset += c;
                max -= c;
                c = is.read(bytes, offset, max);
                xmlProlog = new java.lang.String(bytes , 0 , offset , guessedEnc);
                firstGT = xmlProlog.indexOf('>');
            }
            if (firstGT == (-1)) {
                if (c == (-1)) {
                    throw new java.io.IOException("Unexpected end of XML stream");
                } else {
                    throw new java.io.IOException((("XML prolog or ROOT element not found on first " + offset) + " bytes"));
                }
            } 
            final int bytesRead = offset;
            if (bytesRead > 0) {
                is.reset();
                final java.io.BufferedReader bReader = new java.io.BufferedReader(new java.io.StringReader(xmlProlog.substring(0, (firstGT + 1))));
                final java.lang.StringBuffer prolog = new java.lang.StringBuffer();
                java.lang.String line = bReader.readLine();
                while (line != null) {
                    prolog.append(line);
                    line = bReader.readLine();
                }
                final java.util.regex.Matcher m = ENCODING_PATTERN.matcher(prolog);
                if (m.find()) {
                    encoding = m.group(1).toUpperCase();
                    encoding = encoding.substring(1, ((encoding.length()) - 1));
                } 
            } 
        } 
        return encoding;
    }

    static boolean a(final java.lang.String mime) {
        return (mime != null) && ((((mime.equals("application/xml")) || (mime.equals("application/xml-dtd"))) || (mime.equals("application/xml-external-parsed-entity"))) || ((mime.startsWith("application/")) && (mime.endsWith("+xml"))));
    }

    static boolean b(final java.lang.String mime) {
        return (mime != null) && (((mime.equals("text/xml")) || (mime.equals("text/xml-external-parsed-entity"))) || ((mime.startsWith("text/")) && (mime.endsWith("+xml"))));
    }

    private static final java.lang.String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";

    private static final java.lang.String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";

    private static final java.lang.String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";

    private static final java.lang.String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";

    private static final java.lang.String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
}


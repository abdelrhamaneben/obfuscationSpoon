package org.apache.commons.io.input.compatibility;


public class XmlStreamReader extends java.io.Reader {
    private static final int BUFFER_SIZE = 4096;

    private static final java.lang.String UTF_8 = "UTF-8";

    private static final java.lang.String US_ASCII = "US-ASCII";

    private static final java.lang.String UTF_16BE = "UTF-16BE";

    private static final java.lang.String UTF_16LE = "UTF-16LE";

    private static final java.lang.String UTF_16 = "UTF-16";

    private static final java.lang.String UTF_32BE = "UTF-32BE";

    private static final java.lang.String UTF_32LE = "UTF-32LE";

    private static final java.lang.String UTF_32 = "UTF-32";

    private static final java.lang.String EBCDIC = "CP1047";

    private static java.lang.String staticDefaultEncoding = null;

    private java.io.Reader reader;

    private java.lang.String encoding;

    private final java.lang.String defaultEncoding;

    public static void e(final java.lang.String encoding) {
        org.apache.commons.io.input.compatibility.XmlStreamReader.staticDefaultEncoding = encoding;
    }

    public static java.lang.String a() {
        return org.apache.commons.io.input.compatibility.XmlStreamReader.staticDefaultEncoding;
    }

    public XmlStreamReader(final java.io.File file) throws java.io.IOException {
        this(new java.io.FileInputStream(file));
    }

    public XmlStreamReader(final java.io.InputStream is) throws java.io.IOException {
        this(is, true);
    }

    public XmlStreamReader(final java.io.InputStream is ,final boolean lenient) throws java.io.IOException , org.apache.commons.io.input.compatibility.XmlStreamReaderException {
        defaultEncoding = org.apache.commons.io.input.compatibility.XmlStreamReader.staticDefaultEncoding;
        try {
            doRawStream(is);
        } catch (final org.apache.commons.io.input.compatibility.XmlStreamReaderException ex) {
            if (!lenient) {
                throw ex;
            } else {
                doLenientDetection(null, ex);
            }
        }
    }

    public XmlStreamReader(final java.net.URL url) throws java.io.IOException {
        this(url.openConnection());
    }

    public XmlStreamReader(final java.net.URLConnection conn) throws java.io.IOException {
        defaultEncoding = org.apache.commons.io.input.compatibility.XmlStreamReader.staticDefaultEncoding;
        final boolean lenient = true;
        if (conn instanceof java.net.HttpURLConnection) {
            try {
                doHttpStream(conn.getInputStream(), conn.getContentType(), lenient);
            } catch (final org.apache.commons.io.input.compatibility.XmlStreamReaderException ex) {
                doLenientDetection(conn.getContentType(), ex);
            }
        } else if ((conn.getContentType()) != null) {
            try {
                doHttpStream(conn.getInputStream(), conn.getContentType(), lenient);
            } catch (final org.apache.commons.io.input.compatibility.XmlStreamReaderException ex) {
                doLenientDetection(conn.getContentType(), ex);
            }
        } else {
            try {
                doRawStream(conn.getInputStream());
            } catch (final org.apache.commons.io.input.compatibility.XmlStreamReaderException ex) {
                doLenientDetection(null, ex);
            }
        }
    }

    public XmlStreamReader(final java.io.InputStream is ,final java.lang.String httpContentType) throws java.io.IOException {
        this(is, httpContentType, true);
    }

    public XmlStreamReader(final java.io.InputStream is ,final java.lang.String httpContentType ,final boolean lenient ,final java.lang.String defaultEncoding) throws java.io.IOException , org.apache.commons.io.input.compatibility.XmlStreamReaderException {
        this.defaultEncoding = defaultEncoding == null ? org.apache.commons.io.input.compatibility.XmlStreamReader.staticDefaultEncoding : defaultEncoding;
        try {
            doHttpStream(is, httpContentType, lenient);
        } catch (final org.apache.commons.io.input.compatibility.XmlStreamReaderException ex) {
            if (!lenient) {
                throw ex;
            } else {
                doLenientDetection(httpContentType, ex);
            }
        }
    }

    public XmlStreamReader(final java.io.InputStream is ,final java.lang.String httpContentType ,final boolean lenient) throws java.io.IOException , org.apache.commons.io.input.compatibility.XmlStreamReaderException {
        this(is, httpContentType, lenient, null);
    }

    private void a(java.lang.String httpContentType, org.apache.commons.io.input.compatibility.XmlStreamReaderException ex) throws java.io.IOException {
        if (httpContentType != null) {
            if (httpContentType.startsWith("text/html")) {
                httpContentType = httpContentType.substring("text/html".length());
                httpContentType = "text/xml" + httpContentType;
                try {
                    doHttpStream(ex.getInputStream(), httpContentType, true);
                    ex = null;
                } catch (final org.apache.commons.io.input.compatibility.XmlStreamReaderException ex2) {
                    ex = ex2;
                }
            } 
        } 
        if (ex != null) {
            java.lang.String encoding = ex.getXmlEncoding();
            if (encoding == null) {
                encoding = ex.getContentTypeEncoding();
            } 
            if (encoding == null) {
                encoding = (defaultEncoding) == null ? UTF_8 : defaultEncoding;
            } 
            prepareReader(ex.getInputStream(), encoding);
        } 
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

    private void a(final java.io.InputStream is) throws java.io.IOException {
        final java.io.BufferedInputStream pis = new java.io.BufferedInputStream(is , BUFFER_SIZE);
        final java.lang.String bomEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getBOMEncoding(pis);
        final java.lang.String xmlGuessEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getXMLGuessEncoding(pis);
        final java.lang.String xmlEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getXmlProlog(pis, xmlGuessEnc);
        final java.lang.String encoding = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc, pis);
        prepareReader(pis, encoding);
    }

    private void a(final java.io.InputStream is, final java.lang.String httpContentType, final boolean lenient) throws java.io.IOException {
        final java.io.BufferedInputStream pis = new java.io.BufferedInputStream(is , BUFFER_SIZE);
        final java.lang.String cTMime = org.apache.commons.io.input.compatibility.XmlStreamReader.getContentTypeMime(httpContentType);
        final java.lang.String cTEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getContentTypeEncoding(httpContentType);
        final java.lang.String bomEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getBOMEncoding(pis);
        final java.lang.String xmlGuessEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getXMLGuessEncoding(pis);
        final java.lang.String xmlEnc = org.apache.commons.io.input.compatibility.XmlStreamReader.getXmlProlog(pis, xmlGuessEnc);
        final java.lang.String encoding = calculateHttpEncoding(cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc, pis, lenient);
        prepareReader(pis, encoding);
    }

    private void a(final java.io.InputStream is, final java.lang.String encoding) throws java.io.IOException {
        reader = new java.io.InputStreamReader(is , encoding);
        this.encoding = encoding;
    }

    java.lang.String a(final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.io.InputStream is) throws java.io.IOException {
        java.lang.String encoding;
        if (bomEnc == null) {
            if ((xmlGuessEnc == null) || (xmlEnc == null)) {
                encoding = (defaultEncoding) == null ? UTF_8 : defaultEncoding;
            } else if ((xmlEnc.equals(UTF_16)) && ((xmlGuessEnc.equals(UTF_16BE)) || (xmlGuessEnc.equals(UTF_16LE)))) {
                encoding = xmlGuessEnc;
            } else if ((xmlEnc.equals(UTF_32)) && ((xmlGuessEnc.equals(UTF_32BE)) || (xmlGuessEnc.equals(UTF_32LE)))) {
                encoding = xmlGuessEnc;
            } else {
                encoding = xmlEnc;
            }
        } else if (bomEnc.equals(UTF_8)) {
            if ((xmlGuessEnc != null) && (!(xmlGuessEnc.equals(UTF_8)))) {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_1.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
            } 
            if ((xmlEnc != null) && (!(xmlEnc.equals(UTF_8)))) {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_1.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
            } 
            encoding = UTF_8;
        } else if ((bomEnc.equals(UTF_16BE)) || (bomEnc.equals(UTF_16LE))) {
            if ((xmlGuessEnc != null) && (!(xmlGuessEnc.equals(bomEnc)))) {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_1.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
            } 
            if (((xmlEnc != null) && (!(xmlEnc.equals(UTF_16)))) && (!(xmlEnc.equals(bomEnc)))) {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_1.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
            } 
            encoding = bomEnc;
        } else if ((bomEnc.equals(UTF_32BE)) || (bomEnc.equals(UTF_32LE))) {
            if ((xmlGuessEnc != null) && (!(xmlGuessEnc.equals(bomEnc)))) {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_1.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
            } 
            if (((xmlEnc != null) && (!(xmlEnc.equals(UTF_32)))) && (!(xmlEnc.equals(bomEnc)))) {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_1.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
            } 
            encoding = bomEnc;
        } else {
            throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(RAW_EX_2.format(new java.lang.Object[]{ bomEnc , xmlGuessEnc , xmlEnc }) , bomEnc , xmlGuessEnc , xmlEnc , is);
        }
        return encoding;
    }

    java.lang.String a(final java.lang.String cTMime, final java.lang.String cTEnc, final java.lang.String bomEnc, final java.lang.String xmlGuessEnc, final java.lang.String xmlEnc, final java.io.InputStream is, final boolean lenient) throws java.io.IOException {
        java.lang.String encoding;
        if (lenient & (xmlEnc != null)) {
            encoding = xmlEnc;
        } else {
            final boolean appXml = org.apache.commons.io.input.compatibility.XmlStreamReader.isAppXml(cTMime);
            final boolean textXml = org.apache.commons.io.input.compatibility.XmlStreamReader.isTextXml(cTMime);
            if (appXml || textXml) {
                if (cTEnc == null) {
                    if (appXml) {
                        encoding = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc, is);
                    } else {
                        encoding = (defaultEncoding) == null ? US_ASCII : defaultEncoding;
                    }
                } else if ((bomEnc != null) && ((cTEnc.equals(UTF_16BE)) || (cTEnc.equals(UTF_16LE)))) {
                    throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(HTTP_EX_1.format(new java.lang.Object[]{ cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc }) , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc , is);
                } else if (cTEnc.equals(UTF_16)) {
                    if ((bomEnc != null) && (bomEnc.startsWith(UTF_16))) {
                        encoding = bomEnc;
                    } else {
                        throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(HTTP_EX_2.format(new java.lang.Object[]{ cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc }) , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc , is);
                    }
                } else if ((bomEnc != null) && ((cTEnc.equals(UTF_32BE)) || (cTEnc.equals(UTF_32LE)))) {
                    throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(HTTP_EX_1.format(new java.lang.Object[]{ cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc }) , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc , is);
                } else if (cTEnc.equals(UTF_32)) {
                    if ((bomEnc != null) && (bomEnc.startsWith(UTF_32))) {
                        encoding = bomEnc;
                    } else {
                        throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(HTTP_EX_2.format(new java.lang.Object[]{ cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc }) , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc , is);
                    }
                } else {
                    encoding = cTEnc;
                }
            } else {
                throw new org.apache.commons.io.input.compatibility.XmlStreamReaderException(HTTP_EX_3.format(new java.lang.Object[]{ cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc }) , cTMime , cTEnc , bomEnc , xmlGuessEnc , xmlEnc , is);
            }
        }
        return encoding;
    }

    static java.lang.String d(final java.lang.String httpContentType) {
        java.lang.String mime = null;
        if (httpContentType != null) {
            final int i = httpContentType.indexOf(";");
            mime = (i == (-1) ? httpContentType : httpContentType.substring(0, i)).trim();
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
                encoding = encoding != null ? encoding.toUpperCase() : null;
            } 
        } 
        return encoding;
    }

    static java.lang.String a(final java.io.BufferedInputStream is) throws java.io.IOException {
        java.lang.String encoding = null;
        final int[] bytes = new int[3];
        is.mark(3);
        bytes[0] = is.read();
        bytes[1] = is.read();
        bytes[2] = is.read();
        if (((bytes[0]) == 254) && ((bytes[1]) == 255)) {
            encoding = UTF_16BE;
            is.reset();
            is.read();
            is.read();
        } else if (((bytes[0]) == 255) && ((bytes[1]) == 254)) {
            encoding = UTF_16LE;
            is.reset();
            is.read();
            is.read();
        } else if ((((bytes[0]) == 239) && ((bytes[1]) == 187)) && ((bytes[2]) == 191)) {
            encoding = UTF_8;
        } else {
            is.reset();
        }
        return encoding;
    }

    private static java.lang.String b(final java.io.BufferedInputStream is) throws java.io.IOException {
        java.lang.String encoding = null;
        final int[] bytes = new int[4];
        is.mark(4);
        bytes[0] = is.read();
        bytes[1] = is.read();
        bytes[2] = is.read();
        bytes[3] = is.read();
        is.reset();
        if (((((bytes[0]) == 0) && ((bytes[1]) == 60)) && ((bytes[2]) == 0)) && ((bytes[3]) == 63)) {
            encoding = UTF_16BE;
        } else if (((((bytes[0]) == 60) && ((bytes[1]) == 0)) && ((bytes[2]) == 63)) && ((bytes[3]) == 0)) {
            encoding = UTF_16LE;
        } else if (((((bytes[0]) == 60) && ((bytes[1]) == 63)) && ((bytes[2]) == 120)) && ((bytes[3]) == 109)) {
            encoding = UTF_8;
        } else if (((((bytes[0]) == 76) && ((bytes[1]) == 111)) && ((bytes[2]) == 167)) && ((bytes[3]) == 148)) {
            encoding = EBCDIC;
        } 
        return encoding;
    }

    public static final java.util.regex.Pattern ENCODING_PATTERN = java.util.regex.Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:\'.[^\']*\'))", java.util.regex.Pattern.MULTILINE);

    private static java.lang.String a(final java.io.BufferedInputStream is, final java.lang.String guessedEnc) throws java.io.IOException {
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

    private static final java.text.MessageFormat RAW_EX_1 = new java.text.MessageFormat("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch");

    private static final java.text.MessageFormat RAW_EX_2 = new java.text.MessageFormat("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM");

    private static final java.text.MessageFormat HTTP_EX_1 = new java.text.MessageFormat("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL");

    private static final java.text.MessageFormat HTTP_EX_2 = new java.text.MessageFormat("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch");

    private static final java.text.MessageFormat HTTP_EX_3 = new java.text.MessageFormat("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME");
}


package org.apache.commons.csv;


public final class CSVParser implements java.io.Closeable , java.lang.Iterable<org.apache.commons.csv.CSVRecord> {
    public static org.apache.commons.csv.CSVParser parse(final java.io.File file, final java.nio.charset.Charset charset, final org.apache.commons.csv.CSVFormat format) throws java.io.IOException {
        org.apache.commons.csv.Assertions.notNull(file, "file");
        org.apache.commons.csv.Assertions.notNull(format, "format");
        return new org.apache.commons.csv.CSVParser(new java.io.InputStreamReader(new java.io.FileInputStream(file) , charset) , format);
    }

    public static org.apache.commons.csv.CSVParser parse(final java.lang.String string, final org.apache.commons.csv.CSVFormat format) throws java.io.IOException {
        org.apache.commons.csv.Assertions.notNull(string, "string");
        org.apache.commons.csv.Assertions.notNull(format, "format");
        return new org.apache.commons.csv.CSVParser(new java.io.StringReader(string) , format);
    }

    public static org.apache.commons.csv.CSVParser parse(final java.net.URL url, final java.nio.charset.Charset charset, final org.apache.commons.csv.CSVFormat format) throws java.io.IOException {
        org.apache.commons.csv.Assertions.notNull(url, "url");
        org.apache.commons.csv.Assertions.notNull(charset, "charset");
        org.apache.commons.csv.Assertions.notNull(format, "format");
        return new org.apache.commons.csv.CSVParser(new java.io.InputStreamReader(url.openStream() , charset) , format);
    }

    private final org.apache.commons.csv.CSVFormat format;

    private final java.util.Map<java.lang.String, java.lang.Integer> headerMap;

    private final org.apache.commons.csv.Lexer lexer;

    private final java.util.List<java.lang.String> record = new java.util.ArrayList<java.lang.String>();

    private long recordNumber;

    private final long characterOffset;

    private final org.apache.commons.csv.Token reusableToken = new org.apache.commons.csv.Token();

    public CSVParser(final java.io.Reader reader ,final org.apache.commons.csv.CSVFormat format) throws java.io.IOException {
        this(reader, format, 0, 1);
    }

    public CSVParser(final java.io.Reader reader ,final org.apache.commons.csv.CSVFormat format ,final long characterOffset ,final long recordNumber) throws java.io.IOException {
        org.apache.commons.csv.Assertions.notNull(reader, "reader");
        org.apache.commons.csv.Assertions.notNull(format, "format");
        this.format = format;
        this.lexer = new org.apache.commons.csv.Lexer(format , new org.apache.commons.csv.ExtendedBufferedReader(reader));
        this.headerMap = d();
        this.characterOffset = characterOffset;
        this.recordNumber = recordNumber - 1;
    }

    private void h() {
        final java.lang.String input = this.reusableToken.content.toString();
        final java.lang.String nullString = this.format.n();
        if (nullString == null) {
            this.record.add(input);
        } else {
            this.record.add((input.equalsIgnoreCase(nullString) ? null : input));
        }
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        if ((this.lexer) != null) {
            this.lexer.close();
        } 
    }

    public long e() {
        return this.lexer.d();
    }

    public java.util.Map<java.lang.String, java.lang.Integer> c() {
        return (this.headerMap) == null ? null : new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(this.headerMap);
    }

    public long f() {
        return this.recordNumber;
    }

    public java.util.List<org.apache.commons.csv.CSVRecord> b() throws java.io.IOException {
        org.apache.commons.csv.CSVRecord rec;
        final java.util.List<org.apache.commons.csv.CSVRecord> records = new java.util.ArrayList<org.apache.commons.csv.CSVRecord>();
        while ((rec = g()) != null) {
            records.add(rec);
        }
        return records;
    }

    private java.util.Map<java.lang.String, java.lang.Integer> d() throws java.io.IOException {
        java.util.Map<java.lang.String, java.lang.Integer> hdrMap = null;
        final java.lang.String[] formatHeader = this.format.p();
        if (formatHeader != null) {
            hdrMap = this.format.c() ? new java.util.TreeMap<java.lang.String, java.lang.Integer>(java.lang.String.CASE_INSENSITIVE_ORDER) : new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>();
            java.lang.String[] headerRecord = null;
            if ((formatHeader.length) == 0) {
                final org.apache.commons.csv.CSVRecord nextRecord = g();
                if (nextRecord != null) {
                    headerRecord = nextRecord.d();
                } 
            } else {
                if (this.format.e()) {
                    g();
                } 
                headerRecord = formatHeader;
            }
            if (headerRecord != null) {
                for (int i = 0 ; i < (headerRecord.length) ; i++) {
                    final java.lang.String header = headerRecord[i];
                    final boolean containsHeader = hdrMap.containsKey(header);
                    final boolean emptyHeader = (header == null) || (header.trim().isEmpty());
                    if (containsHeader && ((!emptyHeader) || (emptyHeader && (!(this.format.a()))))) {
                        throw new java.lang.IllegalArgumentException(((("The header contains a duplicate name: \"" + header) + "\" in ") + (java.util.Arrays.toString(headerRecord))));
                    } 
                    hdrMap.put(header, java.lang.Integer.valueOf(i));
                }
            } 
        } 
        return hdrMap;
    }

    public boolean a() {
        return this.lexer.a();
    }

    @java.lang.Override
    public java.util.Iterator<org.apache.commons.csv.CSVRecord> iterator() {
        return new java.util.Iterator<org.apache.commons.csv.CSVRecord>() {
            private org.apache.commons.csv.CSVRecord current;

            private org.apache.commons.csv.CSVRecord a() {
                try {
                    return org.apache.commons.csv.CSVParser.this.g();
                } catch (final java.io.IOException e) {
                    throw new java.lang.RuntimeException(e);
                }
            }

            @java.lang.Override
            public boolean hasNext() {
                if (org.apache.commons.csv.CSVParser.this.a()) {
                    return false;
                } 
                if ((this.current) == null) {
                    this.current = a();
                } 
                return (this.current) != null;
            }

            @java.lang.Override
            public org.apache.commons.csv.CSVRecord next() {
                if (org.apache.commons.csv.CSVParser.this.a()) {
                    throw new java.util.NoSuchElementException("CSVParser has been closed");
                } 
                org.apache.commons.csv.CSVRecord next = this.current;
                this.current = null;
                if (next == null) {
                    next = a();
                    if (next == null) {
                        throw new java.util.NoSuchElementException("No more CSV records available");
                    } 
                } 
                return next;
            }

            @java.lang.Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }

    org.apache.commons.csv.CSVRecord g() throws java.io.IOException {
        org.apache.commons.csv.CSVRecord result = null;
        this.record.clear();
        java.lang.StringBuilder sb = null;
        final long startCharPosition = (lexer.c()) + (this.characterOffset);
        do {
            this.reusableToken.a();
            this.lexer.a(this.reusableToken);
            switch (this.reusableToken.type) {
                case TOKEN :
                    h();
                    break;
                case EORECORD :
                    h();
                    break;
                case EOF :
                    if (this.reusableToken.isReady) {
                        h();
                    } 
                    break;
                case INVALID :
                    throw new java.io.IOException((("(line " + (e())) + ") invalid parse sequence"));
                case COMMENT :
                    if (sb == null) {
                        sb = new java.lang.StringBuilder();
                    } else {
                        sb.append(org.apache.commons.csv.Constants.LF);
                    }
                    sb.append(this.reusableToken.content);
                    this.reusableToken.type = org.apache.commons.csv.Token.Type.TOKEN;
                    break;
                default :
                    throw new java.lang.IllegalStateException(("Unexpected Token type: " + (this.reusableToken.type)));
            }
        } while ((this.reusableToken.type) == (org.apache.commons.csv.Token.Type.TOKEN) );
        if (!(this.record.isEmpty())) {
            (this.recordNumber)++;
            final java.lang.String comment = sb == null ? null : sb.toString();
            result = new org.apache.commons.csv.CSVRecord(this.record.toArray(new java.lang.String[this.record.size()]) , this.headerMap , comment , this.recordNumber , startCharPosition);
        } 
        return result;
    }
}


package org.apache.commons.csv;


public final class CSVFormat implements java.io.Serializable {
    public static enum Predefined {
Default(org.apache.commons.csv.CSVFormat.DEFAULT), Excel(org.apache.commons.csv.CSVFormat.EXCEL), MySQL(org.apache.commons.csv.CSVFormat.MYSQL), RFC4180(org.apache.commons.csv.CSVFormat.RFC4180), TDF(org.apache.commons.csv.CSVFormat.TDF);
        private final org.apache.commons.csv.CSVFormat format;
        private Predefined(org.apache.commons.csv.CSVFormat format) {
            this.format = format;
        }
        public org.apache.commons.csv.CSVFormat a() {
            return format;
        }
    }

    private static final long serialVersionUID = 1L;

    private final char delimiter;

    private final java.lang.Character quoteCharacter;

    private final org.apache.commons.csv.QuoteMode quoteMode;

    private final java.lang.Character commentMarker;

    private final java.lang.Character escapeCharacter;

    private final boolean ignoreSurroundingSpaces;

    private final boolean allowMissingColumnNames;

    private final boolean ignoreEmptyLines;

    private final java.lang.String recordSeparator;

    private final java.lang.String nullString;

    private final java.lang.String[] header;

    private final java.lang.String[] headerComments;

    private final boolean skipHeaderRecord;

    private final boolean ignoreHeaderCase;

    public static final org.apache.commons.csv.CSVFormat DEFAULT = new org.apache.commons.csv.CSVFormat(org.apache.commons.csv.Constants.COMMA , org.apache.commons.csv.Constants.DOUBLE_QUOTE_CHAR , null , null , null , false , true , org.apache.commons.csv.Constants.CRLF , null , null , null , false , false , false);

    public static final org.apache.commons.csv.CSVFormat RFC4180 = DEFAULT.b(false);

    public static final org.apache.commons.csv.CSVFormat EXCEL = DEFAULT.b(false).r();

    public static final org.apache.commons.csv.CSVFormat TDF = DEFAULT.b(org.apache.commons.csv.Constants.TAB).u();

    public static final org.apache.commons.csv.CSVFormat MYSQL = DEFAULT.b(org.apache.commons.csv.Constants.TAB).c(org.apache.commons.csv.Constants.BACKSLASH).b(false).c(null).e(org.apache.commons.csv.Constants.LF);

    private static boolean isLineBreak(final char c) {
        return (c == (org.apache.commons.csv.Constants.LF)) || (c == (org.apache.commons.csv.Constants.CR));
    }

    private static boolean isLineBreak(final java.lang.Character c) {
        return (c != null) && (org.apache.commons.csv.CSVFormat.isLineBreak(c.charValue()));
    }

    public static org.apache.commons.csv.CSVFormat newFormat(final char delimiter) {
        return new org.apache.commons.csv.CSVFormat(delimiter , null , null , null , null , false , false , null , null , null , null , false , false , false);
    }

    public static org.apache.commons.csv.CSVFormat valueOf(final java.lang.String format) {
        return org.apache.commons.csv.CSVFormat.Predefined.valueOf(format).a();
    }

    private CSVFormat(final char delimiter ,final java.lang.Character quoteChar ,final org.apache.commons.csv.QuoteMode quoteMode ,final java.lang.Character commentStart ,final java.lang.Character escape ,final boolean ignoreSurroundingSpaces ,final boolean ignoreEmptyLines ,final java.lang.String recordSeparator ,final java.lang.String nullString ,final java.lang.Object[] headerComments ,final java.lang.String[] header ,final boolean skipHeaderRecord ,final boolean allowMissingColumnNames ,final boolean ignoreHeaderCase) {
        this.delimiter = delimiter;
        this.quoteCharacter = quoteChar;
        this.quoteMode = quoteMode;
        this.commentMarker = commentStart;
        this.escapeCharacter = escape;
        this.ignoreSurroundingSpaces = ignoreSurroundingSpaces;
        this.allowMissingColumnNames = allowMissingColumnNames;
        this.ignoreEmptyLines = ignoreEmptyLines;
        this.recordSeparator = recordSeparator;
        this.nullString = nullString;
        this.headerComments = b(headerComments);
        this.header = header == null ? null : header.clone();
        this.skipHeaderRecord = skipHeaderRecord;
        this.ignoreHeaderCase = ignoreHeaderCase;
        x();
    }

    private java.lang.String[] b(final java.lang.Object[] values) {
        if (values == null) {
            return null;
        } 
        final java.lang.String[] strings = new java.lang.String[values.length];
        for (int i = 0 ; i < (values.length) ; i++) {
            final java.lang.Object value = values[i];
            strings[i] = value == null ? null : value.toString();
        }
        return strings;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if ((this) == obj) {
            return true;
        } 
        if (obj == null) {
            return false;
        } 
        if ((getClass()) != (obj.getClass())) {
            return false;
        } 
        final org.apache.commons.csv.CSVFormat other = ((org.apache.commons.csv.CSVFormat)(obj));
        if ((delimiter) != (other.delimiter)) {
            return false;
        } 
        if ((quoteMode) != (other.quoteMode)) {
            return false;
        } 
        if ((quoteCharacter) == null) {
            if ((other.quoteCharacter) != null) {
                return false;
            } 
        } else if (!(quoteCharacter.equals(other.quoteCharacter))) {
            return false;
        } 
        if ((commentMarker) == null) {
            if ((other.commentMarker) != null) {
                return false;
            } 
        } else if (!(commentMarker.equals(other.commentMarker))) {
            return false;
        } 
        if ((escapeCharacter) == null) {
            if ((other.escapeCharacter) != null) {
                return false;
            } 
        } else if (!(escapeCharacter.equals(other.escapeCharacter))) {
            return false;
        } 
        if ((nullString) == null) {
            if ((other.nullString) != null) {
                return false;
            } 
        } else if (!(nullString.equals(other.nullString))) {
            return false;
        } 
        if (!(java.util.Arrays.equals(header, other.header))) {
            return false;
        } 
        if ((ignoreSurroundingSpaces) != (other.ignoreSurroundingSpaces)) {
            return false;
        } 
        if ((ignoreEmptyLines) != (other.ignoreEmptyLines)) {
            return false;
        } 
        if ((skipHeaderRecord) != (other.skipHeaderRecord)) {
            return false;
        } 
        if ((recordSeparator) == null) {
            if ((other.recordSeparator) != null) {
                return false;
            } 
        } else if (!(recordSeparator.equals(other.recordSeparator))) {
            return false;
        } 
        return true;
    }

    public java.lang.String a(final java.lang.Object... values) {
        final java.io.StringWriter out = new java.io.StringWriter();
        try {
            new org.apache.commons.csv.CSVPrinter(out , this).b(values);
            return out.toString().trim();
        } catch (final java.io.IOException e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    public java.lang.Character k() {
        return commentMarker;
    }

    public char j() {
        return delimiter;
    }

    public java.lang.Character l() {
        return escapeCharacter;
    }

    public java.lang.String[] p() {
        return (header) != null ? header.clone() : null;
    }

    public java.lang.String[] q() {
        return (headerComments) != null ? headerComments.clone() : null;
    }

    public boolean a() {
        return allowMissingColumnNames;
    }

    public boolean b() {
        return ignoreEmptyLines;
    }

    public boolean d() {
        return ignoreSurroundingSpaces;
    }

    public boolean c() {
        return ignoreHeaderCase;
    }

    public java.lang.String n() {
        return nullString;
    }

    public java.lang.Character m() {
        return quoteCharacter;
    }

    public org.apache.commons.csv.QuoteMode w() {
        return quoteMode;
    }

    public java.lang.String o() {
        return recordSeparator;
    }

    public boolean e() {
        return skipHeaderRecord;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (delimiter);
        result = (prime * result) + ((quoteMode) == null ? 0 : quoteMode.hashCode());
        result = (prime * result) + ((quoteCharacter) == null ? 0 : quoteCharacter.hashCode());
        result = (prime * result) + ((commentMarker) == null ? 0 : commentMarker.hashCode());
        result = (prime * result) + ((escapeCharacter) == null ? 0 : escapeCharacter.hashCode());
        result = (prime * result) + ((nullString) == null ? 0 : nullString.hashCode());
        result = (prime * result) + (ignoreSurroundingSpaces ? 1231 : 1237);
        result = (prime * result) + (ignoreHeaderCase ? 1231 : 1237);
        result = (prime * result) + (ignoreEmptyLines ? 1231 : 1237);
        result = (prime * result) + (skipHeaderRecord ? 1231 : 1237);
        result = (prime * result) + ((recordSeparator) == null ? 0 : recordSeparator.hashCode());
        result = (prime * result) + (java.util.Arrays.hashCode(header));
        return result;
    }

    public boolean f() {
        return (commentMarker) != null;
    }

    public boolean g() {
        return (escapeCharacter) != null;
    }

    public boolean h() {
        return (nullString) != null;
    }

    public boolean i() {
        return (quoteCharacter) != null;
    }

    public org.apache.commons.csv.CSVParser a(final java.io.Reader in) throws java.io.IOException {
        return new org.apache.commons.csv.CSVParser(in , this);
    }

    public org.apache.commons.csv.CSVPrinter a(final java.lang.Appendable out) throws java.io.IOException {
        return new org.apache.commons.csv.CSVPrinter(out , this);
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Delimiter=<").append(delimiter).append('>');
        if (g()) {
            sb.append(' ');
            sb.append("Escape=<").append(escapeCharacter).append('>');
        } 
        if (i()) {
            sb.append(' ');
            sb.append("QuoteChar=<").append(quoteCharacter).append('>');
        } 
        if (f()) {
            sb.append(' ');
            sb.append("CommentStart=<").append(commentMarker).append('>');
        } 
        if (h()) {
            sb.append(' ');
            sb.append("NullString=<").append(nullString).append('>');
        } 
        if ((recordSeparator) != null) {
            sb.append(' ');
            sb.append("RecordSeparator=<").append(recordSeparator).append('>');
        } 
        if (b()) {
            sb.append(" EmptyLines:ignored");
        } 
        if (d()) {
            sb.append(" SurroundingSpaces:ignored");
        } 
        if (c()) {
            sb.append(" IgnoreHeaderCase:ignored");
        } 
        sb.append(" SkipHeaderRecord:").append(skipHeaderRecord);
        if ((headerComments) != null) {
            sb.append(' ');
            sb.append("HeaderComments:").append(java.util.Arrays.toString(headerComments));
        } 
        if ((header) != null) {
            sb.append(' ');
            sb.append("Header:").append(java.util.Arrays.toString(header));
        } 
        return sb.toString();
    }

    private void x() throws java.lang.IllegalArgumentException {
        if (org.apache.commons.csv.CSVFormat.isLineBreak(delimiter)) {
            throw new java.lang.IllegalArgumentException("The delimiter cannot be a line break");
        } 
        if (((quoteCharacter) != null) && ((delimiter) == (quoteCharacter.charValue()))) {
            throw new java.lang.IllegalArgumentException((("The quoteChar character and the delimiter cannot be the same (\'" + (quoteCharacter)) + "\')"));
        } 
        if (((escapeCharacter) != null) && ((delimiter) == (escapeCharacter.charValue()))) {
            throw new java.lang.IllegalArgumentException((("The escape character and the delimiter cannot be the same (\'" + (escapeCharacter)) + "\')"));
        } 
        if (((commentMarker) != null) && ((delimiter) == (commentMarker.charValue()))) {
            throw new java.lang.IllegalArgumentException((("The comment start character and the delimiter cannot be the same (\'" + (commentMarker)) + "\')"));
        } 
        if (((quoteCharacter) != null) && (quoteCharacter.equals(commentMarker))) {
            throw new java.lang.IllegalArgumentException((("The comment start character and the quoteChar cannot be the same (\'" + (commentMarker)) + "\')"));
        } 
        if (((escapeCharacter) != null) && (escapeCharacter.equals(commentMarker))) {
            throw new java.lang.IllegalArgumentException((("The comment start and the escape character cannot be the same (\'" + (commentMarker)) + "\')"));
        } 
        if (((escapeCharacter) == null) && ((quoteMode) == (org.apache.commons.csv.QuoteMode.NONE))) {
            throw new java.lang.IllegalArgumentException("No quotes mode set but no escape character is set");
        } 
        if ((header) != null) {
            final java.util.Set<java.lang.String> dupCheck = new java.util.HashSet<java.lang.String>();
            for (final java.lang.String hdr : header) {
                if (!(dupCheck.add(hdr))) {
                    throw new java.lang.IllegalArgumentException(((("The header contains a duplicate entry: \'" + hdr) + "\' in ") + (java.util.Arrays.toString(header))));
                } 
            }
        } 
    }

    public org.apache.commons.csv.CSVFormat a(final char commentMarker) {
        return a(java.lang.Character.valueOf(commentMarker));
    }

    public org.apache.commons.csv.CSVFormat a(final java.lang.Character commentMarker) {
        if (org.apache.commons.csv.CSVFormat.isLineBreak(commentMarker)) {
            throw new java.lang.IllegalArgumentException("The comment start marker character cannot be a line break");
        } 
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat b(final char delimiter) {
        if (org.apache.commons.csv.CSVFormat.isLineBreak(delimiter)) {
            throw new java.lang.IllegalArgumentException("The delimiter cannot be a line break");
        } 
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat c(final char escape) {
        return b(java.lang.Character.valueOf(escape));
    }

    public org.apache.commons.csv.CSVFormat b(final java.lang.Character escape) {
        if (org.apache.commons.csv.CSVFormat.isLineBreak(escape)) {
            throw new java.lang.IllegalArgumentException("The escape character cannot be a line break");
        } 
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escape , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat c(final java.lang.String... header) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat a(final java.sql.ResultSet resultSet) throws java.sql.SQLException {
        return a((resultSet != null ? resultSet.getMetaData() : null));
    }

    public org.apache.commons.csv.CSVFormat a(final java.sql.ResultSetMetaData metaData) throws java.sql.SQLException {
        java.lang.String[] labels = null;
        if (metaData != null) {
            final int columnCount = metaData.getColumnCount();
            labels = new java.lang.String[columnCount];
            for (int i = 0 ; i < columnCount ; i++) {
                labels[i] = metaData.getColumnLabel((i + 1));
            }
        } 
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , labels , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat d(final java.lang.Object... headerComments) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat r() {
        return a(true);
    }

    public org.apache.commons.csv.CSVFormat a(final boolean allowMissingColumnNames) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat s() {
        return b(true);
    }

    public org.apache.commons.csv.CSVFormat b(final boolean ignoreEmptyLines) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat u() {
        return d(true);
    }

    public org.apache.commons.csv.CSVFormat d(final boolean ignoreSurroundingSpaces) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat t() {
        return c(true);
    }

    public org.apache.commons.csv.CSVFormat c(final boolean ignoreHeaderCase) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat a(final java.lang.String nullString) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat d(final char quoteChar) {
        return c(java.lang.Character.valueOf(quoteChar));
    }

    public org.apache.commons.csv.CSVFormat c(final java.lang.Character quoteChar) {
        if (org.apache.commons.csv.CSVFormat.isLineBreak(quoteChar)) {
            throw new java.lang.IllegalArgumentException("The quoteChar cannot be a line break");
        } 
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteChar , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat a(final org.apache.commons.csv.QuoteMode quoteModePolicy) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteModePolicy , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat e(final char recordSeparator) {
        return b(java.lang.String.valueOf(recordSeparator));
    }

    public org.apache.commons.csv.CSVFormat b(final java.lang.String recordSeparator) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }

    public org.apache.commons.csv.CSVFormat v() {
        return e(true);
    }

    public org.apache.commons.csv.CSVFormat e(final boolean skipHeaderRecord) {
        return new org.apache.commons.csv.CSVFormat(delimiter , quoteCharacter , quoteMode , commentMarker , escapeCharacter , ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , headerComments , header , skipHeaderRecord , allowMissingColumnNames , ignoreHeaderCase);
    }
}


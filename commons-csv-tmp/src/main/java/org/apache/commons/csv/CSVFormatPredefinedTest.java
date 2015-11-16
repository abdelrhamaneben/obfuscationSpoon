package org.apache.commons.csv;


public class CSVFormatPredefinedTest {
    private void a(final org.apache.commons.csv.CSVFormat format, final java.lang.String enumName) {
        org.junit.Assert.assertEquals(format, org.apache.commons.csv.CSVFormat.Predefined.valueOf(enumName).a());
        org.junit.Assert.assertEquals(format, org.apache.commons.csv.CSVFormat.valueOf(enumName));
    }

    @org.junit.Test
    public void testDefault() {
        a(org.apache.commons.csv.CSVFormat.DEFAULT, "Default");
    }

    @org.junit.Test
    public void testExcel() {
        a(org.apache.commons.csv.CSVFormat.EXCEL, "Excel");
    }

    @org.junit.Test
    public void testMySQL() {
        a(org.apache.commons.csv.CSVFormat.MYSQL, "MySQL");
    }

    @org.junit.Test
    public void testRFC4180() {
        a(org.apache.commons.csv.CSVFormat.RFC4180, "RFC4180");
    }

    @org.junit.Test
    public void testTDF() {
        a(org.apache.commons.csv.CSVFormat.TDF, "TDF");
    }
}


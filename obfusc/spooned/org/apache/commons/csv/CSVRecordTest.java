package org.apache.commons.csv;


public class CSVRecordTest {
    private enum EnumFixture {
UNKNOWN_COLUMN;    }

    private java.lang.String[] values;

    private org.apache.commons.csv.CSVRecord record;

    private org.apache.commons.csv.CSVRecord recordWithHeader;

    private java.util.Map<java.lang.String, java.lang.Integer> header;

    @org.junit.Before
    public void a() throws java.lang.Exception {
        values = new java.lang.String[]{ "A" , "B" , "C" };
        record = new org.apache.commons.csv.CSVRecord(values , null , null , 0 , -1);
        header = new java.util.HashMap<java.lang.String, java.lang.Integer>();
        header.put("first", java.lang.Integer.valueOf(0));
        header.put("second", java.lang.Integer.valueOf(1));
        header.put("third", java.lang.Integer.valueOf(2));
        recordWithHeader = new org.apache.commons.csv.CSVRecord(values , header , null , 0 , -1);
    }

    @org.junit.Test
    public void testGetInt() {
        org.junit.Assert.assertEquals(values[0], record.a(0));
        org.junit.Assert.assertEquals(values[1], record.a(1));
        org.junit.Assert.assertEquals(values[2], record.a(2));
    }

    @org.junit.Test
    public void testGetString() {
        org.junit.Assert.assertEquals(values[0], recordWithHeader.c("first"));
        org.junit.Assert.assertEquals(values[1], recordWithHeader.c("second"));
        org.junit.Assert.assertEquals(values[2], recordWithHeader.c("third"));
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testGetStringInconsistentRecord() {
        header.put("fourth", java.lang.Integer.valueOf(4));
        recordWithHeader.c("fourth");
    }

    @org.junit.Test(expected = java.lang.IllegalStateException.class)
    public void testGetStringNoHeader() {
        record.c("first");
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testGetUnmappedEnum() {
        org.junit.Assert.assertNull(recordWithHeader.a(EnumFixture.UNKNOWN_COLUMN));
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testGetUnmappedName() {
        org.junit.Assert.assertNull(recordWithHeader.c("fourth"));
    }

    @org.junit.Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetUnmappedNegativeInt() {
        org.junit.Assert.assertNull(recordWithHeader.a(java.lang.Integer.MIN_VALUE));
    }

    @org.junit.Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetUnmappedPositiveInt() {
        org.junit.Assert.assertNull(recordWithHeader.a(java.lang.Integer.MAX_VALUE));
    }

    @org.junit.Test
    public void testIsConsistent() {
        org.junit.Assert.assertTrue(record.a());
        org.junit.Assert.assertTrue(recordWithHeader.a());
        header.put("fourth", java.lang.Integer.valueOf(4));
        org.junit.Assert.assertFalse(recordWithHeader.a());
    }

    @org.junit.Test
    public void testIsMapped() {
        org.junit.Assert.assertFalse(record.a("first"));
        org.junit.Assert.assertTrue(recordWithHeader.a("first"));
        org.junit.Assert.assertFalse(recordWithHeader.a("fourth"));
    }

    @org.junit.Test
    public void testIsSet() {
        org.junit.Assert.assertFalse(record.b("first"));
        org.junit.Assert.assertTrue(recordWithHeader.b("first"));
        org.junit.Assert.assertFalse(recordWithHeader.b("fourth"));
    }

    @org.junit.Test
    public void testIterator() {
        int i = 0;
        for (final java.lang.String value : record) {
            org.junit.Assert.assertEquals(values[i], value);
            i++;
        }
    }

    @org.junit.Test
    public void testPutInMap() {
        final java.util.Map<java.lang.String, java.lang.String> map = new java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>();
        this.recordWithHeader.a(map);
        a(map, false);
        final java.util.TreeMap<java.lang.String, java.lang.String> map2 = recordWithHeader.a(new java.util.TreeMap<java.lang.String, java.lang.String>());
        a(map2, false);
    }

    @org.junit.Test
    public void testRemoveAndAddColumns() throws java.io.IOException {
        final org.apache.commons.csv.CSVPrinter printer = new org.apache.commons.csv.CSVPrinter(new java.lang.StringBuilder() , org.apache.commons.csv.CSVFormat.DEFAULT);
        final java.util.Map<java.lang.String, java.lang.String> map = recordWithHeader.f();
        map.remove("OldColumn");
        map.put("ZColumn", "NewValue");
        final java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<java.lang.String>(map.values());
        java.util.Collections.sort(list);
        printer.b(list);
        org.junit.Assert.assertEquals(("A,B,C,NewValue" + (org.apache.commons.csv.CSVFormat.DEFAULT.o())), printer.a().toString());
        printer.close();
    }

    @org.junit.Test
    public void testToMap() {
        final java.util.Map<java.lang.String, java.lang.String> map = this.recordWithHeader.f();
        a(map, true);
    }

    @org.junit.Test
    public void testToMapWithShortRecord() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse("a,b", org.apache.commons.csv.CSVFormat.DEFAULT.c("A", "B", "C"));
        final org.apache.commons.csv.CSVRecord shortRec = parser.iterator().next();
        shortRec.f();
    }

    @org.junit.Test
    public void testToMapWithNoHeader() throws java.lang.Exception {
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse("a,b", org.apache.commons.csv.CSVFormat.newFormat(','));
        final org.apache.commons.csv.CSVRecord shortRec = parser.iterator().next();
        final java.util.Map<java.lang.String, java.lang.String> map = shortRec.f();
        org.junit.Assert.assertNotNull("Map is not null.", map);
        org.junit.Assert.assertTrue("Map is empty.", map.isEmpty());
    }

    private void a(final java.util.Map<java.lang.String, java.lang.String> map, final boolean allowsNulls) {
        org.junit.Assert.assertTrue(map.containsKey("first"));
        org.junit.Assert.assertTrue(map.containsKey("second"));
        org.junit.Assert.assertTrue(map.containsKey("third"));
        org.junit.Assert.assertFalse(map.containsKey("fourth"));
        if (allowsNulls) {
            org.junit.Assert.assertFalse(map.containsKey(null));
        } 
        org.junit.Assert.assertEquals("A", map.get("first"));
        org.junit.Assert.assertEquals("B", map.get("second"));
        org.junit.Assert.assertEquals("C", map.get("third"));
        org.junit.Assert.assertEquals(null, map.get("fourth"));
    }
}


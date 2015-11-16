package org.apache.commons.csv;


public class AssertionsTest {
    @org.junit.Test
    public void testNotNull() throws java.lang.Exception {
        org.apache.commons.csv.Assertions.notNull(new java.lang.Object(), "object");
    }

    @org.junit.Test(expected = java.lang.IllegalArgumentException.class)
    public void testNotNullNull() throws java.lang.Exception {
        org.apache.commons.csv.Assertions.notNull(null, "object");
    }
}


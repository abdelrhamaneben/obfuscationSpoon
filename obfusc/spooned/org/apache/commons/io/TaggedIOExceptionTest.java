package org.apache.commons.io;


public class TaggedIOExceptionTest extends junit.framework.TestCase {
    public void a() {
        final java.io.Serializable tag = java.util.UUID.randomUUID();
        final java.io.IOException exception = new java.io.IOException("Test exception");
        final org.apache.commons.io.TaggedIOException tagged = new org.apache.commons.io.TaggedIOException(exception , tag);
        junit.framework.TestCase.assertTrue(org.apache.commons.io.TaggedIOException.isTaggedWith(tagged, tag));
        junit.framework.TestCase.assertFalse(org.apache.commons.io.TaggedIOException.isTaggedWith(tagged, java.util.UUID.randomUUID()));
        junit.framework.TestCase.assertEquals(exception, tagged.getCause());
        junit.framework.TestCase.assertEquals(exception.getMessage(), tagged.getMessage());
    }
}


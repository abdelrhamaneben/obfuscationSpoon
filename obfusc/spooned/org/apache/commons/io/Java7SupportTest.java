package org.apache.commons.io;


public class Java7SupportTest {
    @org.junit.Test
    public void b() throws java.lang.Exception {
        java.io.File file = new java.io.File(".");
        if (org.apache.commons.io.Java7Support.isAtLeastJava7()) {
            org.junit.Assert.assertFalse(org.apache.commons.io.Java7Support.isSymLink(file));
        } 
    }

    @org.junit.Test
    public void a() throws java.lang.Exception {
        java.io.File file = new java.io.File("target/fzz");
        if (org.apache.commons.io.Java7Support.isAtLeastJava7()) {
            org.apache.commons.io.Java7Support.createSymbolicLink(file, new java.io.File("../target"));
            final java.io.File file1 = org.apache.commons.io.Java7Support.readSymbolicLink(file);
            org.junit.Assert.assertEquals("target", file1.getName());
            org.apache.commons.io.Java7Support.delete(file);
        } 
    }
}


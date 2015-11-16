package org.apache.commons.csv;


public class TokenMatchersTest {
    private org.apache.commons.csv.Token token;

    @org.junit.Before
    public void a() {
        token = new org.apache.commons.csv.Token();
        token.type = org.apache.commons.csv.Token.Type.TOKEN;
        token.isReady = true;
        token.content.append("content");
    }

    @org.junit.Test
    public void testHasType() {
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.hasType(org.apache.commons.csv.Token.Type.COMMENT).matches(token));
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.hasType(org.apache.commons.csv.Token.Type.EOF).matches(token));
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.hasType(org.apache.commons.csv.Token.Type.EORECORD).matches(token));
        org.junit.Assert.assertTrue(org.apache.commons.csv.TokenMatchers.hasType(org.apache.commons.csv.Token.Type.TOKEN).matches(token));
    }

    @org.junit.Test
    public void testHasContent() {
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.hasContent("This is not the token\'s content").matches(token));
        org.junit.Assert.assertTrue(org.apache.commons.csv.TokenMatchers.hasContent("content").matches(token));
    }

    @org.junit.Test
    public void testIsReady() {
        org.junit.Assert.assertTrue(org.apache.commons.csv.TokenMatchers.isReady().matches(token));
        token.isReady = false;
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.isReady().matches(token));
    }

    @org.junit.Test
    public void testMatches() {
        org.junit.Assert.assertTrue(org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "content").matches(token));
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EOF, "content").matches(token));
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.TOKEN, "not the content").matches(token));
        org.junit.Assert.assertFalse(org.apache.commons.csv.TokenMatchers.matches(org.apache.commons.csv.Token.Type.EORECORD, "not the content").matches(token));
    }
}


package org.apache.commons.csv;


final class TokenMatchers {
    public static org.hamcrest.Matcher<org.apache.commons.csv.Token> hasType(final org.apache.commons.csv.Token.Type expectedType) {
        return new org.hamcrest.TypeSafeDiagnosingMatcher<org.apache.commons.csv.Token>() {
            @java.lang.Override
            public void describeTo(final org.hamcrest.Description description) {
                description.appendText("token has type ");
                description.appendValue(expectedType);
            }

            @java.lang.Override
            protected boolean matchesSafely(final org.apache.commons.csv.Token item, final org.hamcrest.Description mismatchDescription) {
                mismatchDescription.appendText("token type is ");
                mismatchDescription.appendValue(item.type);
                return (item.type) == expectedType;
            }
        };
    }

    public static org.hamcrest.Matcher<org.apache.commons.csv.Token> hasContent(final java.lang.String expectedContent) {
        return new org.hamcrest.TypeSafeDiagnosingMatcher<org.apache.commons.csv.Token>() {
            @java.lang.Override
            public void describeTo(final org.hamcrest.Description description) {
                description.appendText("token has content ");
                description.appendValue(expectedContent);
            }

            @java.lang.Override
            protected boolean matchesSafely(final org.apache.commons.csv.Token item, final org.hamcrest.Description mismatchDescription) {
                mismatchDescription.appendText("token content is ");
                mismatchDescription.appendValue(item.content.toString());
                return expectedContent.equals(item.content.toString());
            }
        };
    }

    public static org.hamcrest.Matcher<org.apache.commons.csv.Token> isReady() {
        return new org.hamcrest.TypeSafeDiagnosingMatcher<org.apache.commons.csv.Token>() {
            @java.lang.Override
            public void describeTo(final org.hamcrest.Description description) {
                description.appendText("token is ready ");
            }

            @java.lang.Override
            protected boolean matchesSafely(final org.apache.commons.csv.Token item, final org.hamcrest.Description mismatchDescription) {
                mismatchDescription.appendText("token is not ready ");
                return item.isReady;
            }
        };
    }

    public static org.hamcrest.Matcher<org.apache.commons.csv.Token> matches(final org.apache.commons.csv.Token.Type expectedType, final java.lang.String expectedContent) {
        return org.hamcrest.core.AllOf.allOf(org.apache.commons.csv.TokenMatchers.hasType(expectedType), org.apache.commons.csv.TokenMatchers.hasContent(expectedContent));
    }
}


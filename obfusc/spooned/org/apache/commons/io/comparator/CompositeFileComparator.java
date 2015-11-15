package org.apache.commons.io.comparator;


public class CompositeFileComparator extends org.apache.commons.io.comparator.AbstractFileComparator implements java.io.Serializable {
    private static final long serialVersionUID = -2224170307287243428L;

    private static final java.util.Comparator<?>[] NO_COMPARATORS = new java.util.Comparator<?>[]{  };

    private final java.util.Comparator<java.io.File>[] delegates;

    @java.lang.SuppressWarnings(value = "unchecked")
    public CompositeFileComparator(final java.util.Comparator<java.io.File>... delegates) {
        if (delegates == null) {
            this.delegates = ((java.util.Comparator<java.io.File>[])(NO_COMPARATORS));
        } else {
            this.delegates = ((java.util.Comparator<java.io.File>[])(new java.util.Comparator<?>[delegates.length]));
            java.lang.System.arraycopy(delegates, 0, this.delegates, 0, delegates.length);
        }
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    public CompositeFileComparator(final java.lang.Iterable<java.util.Comparator<java.io.File>> delegates) {
        if (delegates == null) {
            this.delegates = ((java.util.Comparator<java.io.File>[])(NO_COMPARATORS));
        } else {
            final java.util.List<java.util.Comparator<java.io.File>> list = new java.util.ArrayList<java.util.Comparator<java.io.File>>();
            for (final java.util.Comparator<java.io.File> comparator : delegates) {
                list.add(comparator);
            }
            this.delegates = ((java.util.Comparator<java.io.File>[])(list.toArray(new java.util.Comparator<?>[list.size()])));
        }
    }

    public int a(final java.io.File file1, final java.io.File file2) {
        int result = 0;
        for (final java.util.Comparator<java.io.File> delegate : delegates) {
            result = delegate.compare(file1, file2);
            if (result != 0) {
                break;
            } 
        }
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder();
        builder.append(super.toString());
        builder.append('{');
        for (int i = 0 ; i < (delegates.length) ; i++) {
            if (i > 0) {
                builder.append(',');
            } 
            builder.append(delegates[i]);
        }
        builder.append('}');
        return builder.toString();
    }
}


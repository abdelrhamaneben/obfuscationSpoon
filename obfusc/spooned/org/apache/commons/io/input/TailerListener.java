package org.apache.commons.io.input;


public interface TailerListener {
    void a(org.apache.commons.io.input.Tailer tailer);

    void fileRotated();

    void a();

    void a(java.lang.String line);

    void a(java.lang.Exception ex);
}


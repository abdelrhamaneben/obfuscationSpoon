package org.apache.commons.io;


public class DemuxTestCase {
    private static final java.lang.String T1 = "Thread1";

    private static final java.lang.String T2 = "Thread2";

    private static final java.lang.String T3 = "Thread3";

    private static final java.lang.String T4 = "Thread4";

    private static final java.lang.String DATA1 = "Data for thread1";

    private static final java.lang.String DATA2 = "Data for thread2";

    private static final java.lang.String DATA3 = "Data for thread3";

    private static final java.lang.String DATA4 = "Data for thread4";

    private static final java.util.Random c_random = new java.util.Random();

    private final java.util.HashMap<java.lang.String, org.apache.commons.io.output.ByteArrayOutputStream> m_outputMap = new java.util.HashMap<java.lang.String, org.apache.commons.io.output.ByteArrayOutputStream>();

    private final java.util.HashMap<java.lang.String, java.lang.Thread> m_threadMap = new java.util.HashMap<java.lang.String, java.lang.Thread>();

    @java.lang.SuppressWarnings(value = "deprecation")
    private java.lang.String b(final java.lang.String threadName) {
        final org.apache.commons.io.output.ByteArrayOutputStream output = m_outputMap.get(threadName);
        org.junit.Assert.assertNotNull("getOutput()", output);
        return output.toString(org.apache.commons.io.Charsets.UTF_8);
    }

    private java.lang.String a(final java.lang.String threadName) {
        final org.apache.commons.io.DemuxTestCase.ReaderThread thread = ((org.apache.commons.io.DemuxTestCase.ReaderThread)(m_threadMap.get(threadName)));
        org.junit.Assert.assertNotNull("getInput()", thread);
        return thread.getData();
    }

    private void b() throws java.lang.Exception {
        for (java.lang.String name : m_threadMap.keySet()) {
            final java.lang.Thread thread = m_threadMap.get(name);
            thread.start();
        }
    }

    private void a() throws java.lang.Exception {
        for (java.lang.String name : m_threadMap.keySet()) {
            final java.lang.Thread thread = m_threadMap.get(name);
            thread.join();
        }
    }

    private void a(final java.lang.String name, final java.lang.String data, final org.apache.commons.io.output.DemuxOutputStream demux) throws java.lang.Exception {
        final org.apache.commons.io.output.ByteArrayOutputStream output = new org.apache.commons.io.output.ByteArrayOutputStream();
        m_outputMap.put(name, output);
        final org.apache.commons.io.DemuxTestCase.WriterThread thread = new org.apache.commons.io.DemuxTestCase.WriterThread(name , data , output , demux);
        m_threadMap.put(name, thread);
    }

    private void a(final java.lang.String name, final java.lang.String data, final org.apache.commons.io.input.DemuxInputStream demux) throws java.lang.Exception {
        final java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(data.getBytes());
        final org.apache.commons.io.DemuxTestCase.ReaderThread thread = new org.apache.commons.io.DemuxTestCase.ReaderThread(name , input , demux);
        m_threadMap.put(name, thread);
    }

    @org.junit.Test
    public void d() throws java.lang.Exception {
        final org.apache.commons.io.output.DemuxOutputStream output = new org.apache.commons.io.output.DemuxOutputStream();
        startWriter(T1, DATA1, output);
        startWriter(T2, DATA2, output);
        startWriter(T3, DATA3, output);
        startWriter(T4, DATA4, output);
        doStart();
        doJoin();
        org.junit.Assert.assertEquals("Data1", DATA1, getOutput(T1));
        org.junit.Assert.assertEquals("Data2", DATA2, getOutput(T2));
        org.junit.Assert.assertEquals("Data3", DATA3, getOutput(T3));
        org.junit.Assert.assertEquals("Data4", DATA4, getOutput(T4));
    }

    @org.junit.Test
    public void c() throws java.lang.Exception {
        final org.apache.commons.io.input.DemuxInputStream input = new org.apache.commons.io.input.DemuxInputStream();
        startReader(T1, DATA1, input);
        startReader(T2, DATA2, input);
        startReader(T3, DATA3, input);
        startReader(T4, DATA4, input);
        doStart();
        doJoin();
        org.junit.Assert.assertEquals("Data1", DATA1, getInput(T1));
        org.junit.Assert.assertEquals("Data2", DATA2, getInput(T2));
        org.junit.Assert.assertEquals("Data3", DATA3, getInput(T3));
        org.junit.Assert.assertEquals("Data4", DATA4, getInput(T4));
    }

    private static class ReaderThread extends java.lang.Thread {
        private final java.lang.StringBuffer m_buffer = new java.lang.StringBuffer();

        private final java.io.InputStream m_input;

        private final org.apache.commons.io.input.DemuxInputStream m_demux;

        ReaderThread(final java.lang.String name ,final java.io.InputStream input ,final org.apache.commons.io.input.DemuxInputStream demux) {
            super(name);
            m_input = input;
            m_demux = demux;
        }

        public java.lang.String a() {
            return m_buffer.toString();
        }

        @java.lang.Override
        public void run() {
            m_demux.bindStream(m_input);
            try {
                int ch = m_demux.read();
                while ((-1) != ch) {
                    m_buffer.append(((char)(ch)));
                    final int sleepTime = java.lang.Math.abs(((org.apache.commons.io.DemuxTestCase.c_random.nextInt()) % 10));
                    java.lang.Thread.sleep(sleepTime);
                    ch = m_demux.read();
                }
            } catch (final java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class WriterThread extends java.lang.Thread {
        private final byte[] m_data;

        private final java.io.OutputStream m_output;

        private final org.apache.commons.io.output.DemuxOutputStream m_demux;

        WriterThread(final java.lang.String name ,final java.lang.String data ,final java.io.OutputStream output ,final org.apache.commons.io.output.DemuxOutputStream demux) {
            super(name);
            m_output = output;
            m_demux = demux;
            m_data = data.getBytes();
        }

        @java.lang.Override
        public void run() {
            m_demux.bindStream(m_output);
            for (final byte element : m_data) {
                try {
                    m_demux.write(element);
                    final int sleepTime = java.lang.Math.abs(((org.apache.commons.io.DemuxTestCase.c_random.nextInt()) % 10));
                    java.lang.Thread.sleep(sleepTime);
                } catch (final java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


package dssb.callerid.impl;

import org.junit.Test;

import dssb.callerid.ITraceCallerSpec;

@SuppressWarnings("javadoc")
public class CallerIdTest {
    
    private ITraceCallerSpec spec   = new ITraceCallerSpec();
    private CallerId         tracer = new CallerId();
    
    @Test
    public void testBasicCaller() {
        spec.testBasicCaller(tracer);
    }
    
    @Test
    public void testBasicCallerWithOffset() {
        spec.testBasicCallerWithOffset(tracer);
    }
    
}

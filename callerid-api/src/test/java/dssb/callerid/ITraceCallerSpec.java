package dssb.callerid;

import static org.junit.Assert.assertEquals;

import lombok.val;

/**
 * Specification for any ITraceCaller
 * 
 * @author manusitn
 */
public class ITraceCallerSpec {
    
    /**
     * Check the basic caller check.
     * 
     * @param tracer  the tracer to use.
     */
    public void testBasicCaller(ITraceCaller tracer) {
        val stackTrace = new Calling1(tracer).caller();
        assertEquals(Calling1.class.getCanonicalName(), stackTrace.getClassName());
        assertEquals("caller",                          stackTrace.getMethodName());
        assertEquals("Calling1.java",                   stackTrace.getFileName());
        assertEquals(13,                                stackTrace.getLineNumber());
    }
    
    /**
     * Check the basic caller check with offset.
     * 
     * @param tracer  the tracer to use.
     */
    public void testBasicCallerWithOffset(ITraceCaller tracer) {
        val stackTrace = new Calling2(tracer).caller();
        assertEquals(Calling2.class.getCanonicalName(), stackTrace.getClassName());
        assertEquals("caller",                          stackTrace.getMethodName());
        assertEquals("Calling2.java",                   stackTrace.getFileName());
        assertEquals(13,                                stackTrace.getLineNumber());
    }
    
    
}

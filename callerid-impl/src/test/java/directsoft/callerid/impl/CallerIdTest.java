package directsoft.callerid.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.val;

@SuppressWarnings("javadoc")
public class CallerIdTest {
    
    @Test
    public void testBasicCaller() {
        val stackTrace = new Calling1().first();
        assertEquals(Calling1.class.getCanonicalName(), stackTrace.getClassName());
        assertEquals("first",                           stackTrace.getMethodName());
        assertEquals("Calling1.java",                   stackTrace.getFileName());
        assertEquals(7,                                 stackTrace.getLineNumber());
    }
    
    @Test
    public void testBasicCallerWithOffset() {
        val stackTrace = new Calling2().zero();
        assertEquals(Calling2.class.getCanonicalName(), stackTrace.getClassName());
        assertEquals("zero",                            stackTrace.getMethodName());
        assertEquals("Calling2.java",                   stackTrace.getFileName());
        assertEquals(7,                                 stackTrace.getLineNumber());
    }
    
}

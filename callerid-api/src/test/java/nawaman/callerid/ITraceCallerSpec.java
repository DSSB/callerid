//  ========================================================================
//  Copyright (c) 2017 Nawapunth Manusitthipol.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
package nawaman.callerid;

import static org.junit.Assert.assertEquals;

import lombok.val;
import nawaman.callerid.ITraceCaller;

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
        assertEquals(30,                                stackTrace.getLineNumber());
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
        assertEquals(30,                                stackTrace.getLineNumber());
    }
    
    
}

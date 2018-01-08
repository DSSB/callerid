//  ========================================================================
//  Copyright (c) 2017 Direct Solution Software Builders (DSSB).
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
package dssb.callerid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import dssb.callerid.IGetCaller;
import dssb.callerid.remote.RemoteCaller;
import lombok.val;

/**
 * Specification for any IGetCaller implementations.
 * 
 * @author NawaMan -- nawaman@dssb.io
 */
public class IGetCallerSpec {
    
    /**
     * Check the basic caller check.
     * 
     * @param tracer  the tracer to use.
     */
    public void testBasicCaller(IGetCaller tracer) {
        val stackTrace = new GetCalling1(tracer).caller();
        assertEquals(GetCalling1.class.getCanonicalName(), stackTrace.getClassName());
        assertEquals("caller",                          stackTrace.getMethodName());
        assertEquals("GetCalling1.java",                stackTrace.getFileName());
        assertEquals(30,                                stackTrace.getLineNumber());
    }
    
    /**
     * Check the basic caller check with offset.
     * 
     * @param tracer  the tracer to use.
     */
    public void testBasicCallerWithOffset(IGetCaller tracer) {
        val stackTrace = new GetCalling2(tracer).caller();
        assertEquals(GetCalling2.class.getCanonicalName(), stackTrace.getClassName());
        assertEquals("caller",                          stackTrace.getMethodName());
        assertEquals("GetCalling2.java",                stackTrace.getFileName());
        assertEquals(30,                                stackTrace.getLineNumber());
    }
    
    /**
     * Test if the given tracer can check if the call is local.
     * 
     * @param tracer  the tracer to use.
     */
    public void testLocalCallCheck(IGetCaller tracer) {
        assertTrue(new LocalCaller().callThenCheckIfLocal(tracer));
        assertFalse(new RemoteCaller().callThenCheckIfLocal(tracer));
    }
    
}

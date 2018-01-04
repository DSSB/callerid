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

import lombok.val;

/**
 * Specification for any ITraceCaller implementations.
 * 
 * @author NawaMan -- nawaman@dssb.io
 */
public class ITraceCallerSpec {
    
    /**
     * The caller of the first method that trace is the call of any method-call nested except when trace was pause.
     * 
     * @param tracer  the tracer to use.
     */
    public void test(ITraceCaller tracer) {
        val stackTraces = TraceCalling1.outerCaller(tracer).split("\\r?\\n");
        assertEquals("startTrace   : dssb.callerid.TraceCalling1.outerCaller(TraceCalling1.java:22)", stackTraces[0]);
        assertEquals("continueTrace: dssb.callerid.TraceCalling1.outerCaller(TraceCalling1.java:22)", stackTraces[1]);
        assertEquals("pauseTrace   : dssb.callerid.TraceCalling1.outerCaller(TraceCalling1.java:22)", stackTraces[2]);
        assertEquals("theMethod    : dssb.callerid.TraceCalling1.innerCaller(TraceCalling1.java:44)", stackTraces[3]);
    }
    
}

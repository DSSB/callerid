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

import org.junit.Test;

/**
 * These tests ensure the default implementation of the ITraceCaller behave as expected.
 * 
 * @author NawaMan<nawaman@dssb.io>
 */
@SuppressWarnings("javadoc")
public class ITraceCallerTest {
    
    private IGetCallerSpec spec   = new IGetCallerSpec();
    private IGetCaller     tracer = new IGetCaller() {};
    
    @Test
    public void testBasicCaller() {
        spec.testBasicCaller(tracer);
    }
    
    @Test
    public void testBasicCallerWithOffset() {
        spec.testBasicCallerWithOffset(tracer);
    }
}

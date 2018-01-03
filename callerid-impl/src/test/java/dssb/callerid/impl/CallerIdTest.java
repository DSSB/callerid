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
package dssb.callerid.impl;

import org.junit.Test;

import dssb.callerid.IGetCallerSpec;
import dssb.callerid.ITraceCallerSpec;

/**
 * These tests ensures the implementation of CallerId behave.
 * 
 * @author NawaMan -- nawaman@dssb.io
 */
@SuppressWarnings("javadoc")
public class CallerIdTest {
    
    private IGetCallerSpec   getCallerSpec   = new IGetCallerSpec();
    private ITraceCallerSpec traceCallerSpec = new ITraceCallerSpec();
    private CallerId         callerId        = new CallerId();
    
    @Test
    public void testGetCaller() {
        getCallerSpec.testBasicCaller(callerId);
    }
    
    @Test
    public void testGetCallerWithOffset() {
        getCallerSpec.testBasicCallerWithOffset(callerId);
    }
    
    @Test
    public void testTraceCaller() {
        traceCallerSpec.test(callerId);
    }
    
}

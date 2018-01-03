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

@SuppressWarnings("javadoc")
public class TraceCalling1 {
    
    public static String outerCaller(ITraceCaller tracer) {
        return startTrace(tracer);
    }
    
    public static String startTrace(ITraceCaller tracer) {
        return tracer.trace(trace->{
            return "startTrace   : " + trace + "\n" + continueTrace(tracer);
        });
    }
    
    public static String continueTrace(ITraceCaller tracer) {
        return tracer.trace(trace->{
            return "continueTrace: " + trace + "\n" + pauseTrace(tracer);
        });
    }
    
    public static String pauseTrace(ITraceCaller tracer) {
        return tracer.tracePause(trace->{
            return "pauseTrace   : " + trace + "\n" + innerCaller(tracer);
        });
    }
    
    public static String innerCaller(ITraceCaller tracer) {
        return theMethod(tracer);
    }
    
    public static String theMethod(ITraceCaller tracer) {
        return tracer.trace(trace->{
            return "theMethod    : " + trace + "";
        });
    }
    
}

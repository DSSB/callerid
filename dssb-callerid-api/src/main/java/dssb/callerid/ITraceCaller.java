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

import dssb.failable.Failable;

/**
 * Classes implementing this interface can trace the caller of a method.
 * 
 * @author NawaMan -- nawaman@dssb.io
 */
public interface ITraceCaller {
    
    /**
     * Run the body and continue (or start) the tracing.
     * 
     * @param   body  the code to run -- the traced element will be passed on as the body parameter.
     * @return  the value returned by the body.
     * @throws T  the exception thrown by the value.
     * @param <V> the return value that the body will produce.
     * @param <T> the exception that the body might throw.
     */
    public <V, T extends Throwable> V trace(Failable.Function<StackTraceElement, V, T> body) throws T;
    
    /**
     * Run the body but pause the tracing.
     * 
     * @param   body  the code to run -- the traced element will be passed on as the body parameter.
     * @return  the value returned by the body.
     * @throws T  the exception thrown by the value.
     * @param <V> the return value that the body will produce.
     * @param <T> the exception that the body might throw.
     */
    public <V, T extends Throwable> V tracePause(Failable.Function<StackTraceElement, V, T> body) throws T;
    
}

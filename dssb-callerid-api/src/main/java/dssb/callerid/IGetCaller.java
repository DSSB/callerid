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

import java.util.Arrays;

import lombok.val;

/**
 * Classes implementing this interface can get the caller of a method.
 * 
 * @author NawaMan -- nawaman@dssb.io
 */
public interface IGetCaller {
    
    /**
     * Returns the caller of the method that call this method.
     * 
     * @return the caller.
     */
    public default StackTraceElement caller() {
        return caller(1);   // +1 as it include this one.
    }
    
    /**
     * Returns the caller of the method that call this method with the offset.
     * 
     * @param offset
     *          the offset of the caller. 0 is no offset, +n is the nth caller before it.
     *          negative number will be seen as 0.
     * @return the caller.
     */
    public default StackTraceElement caller(int offset) {
        offset = Math.max(0, offset);
        
        val stackTrace = Thread.currentThread().getStackTrace();
        val length     = stackTrace.length;
        val index      = Math.min(length - 1, 3) + offset;
        return stackTrace[index];
    }
    
    /**
     * Check if the call is made from within the same package.
     * 
     * @return {@code true} if the call is local.
     **/
    public default boolean isLocalCall() {
        try {
            val stackTrace  = Thread.currentThread().getStackTrace();
            val clientName  = stackTrace[2].getClassName();
            val clientClass = Class.forName(clientName);
            val packageName = clientClass.getPackage().getName();
            val callerName  = stackTrace[3].getClassName();
            val isLocalCall = callerName.startsWith(packageName + ".")
                           && (callerName.indexOf('.', packageName.length() + 1) == -1);
            return isLocalCall;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    
    /**
     * Checks if the current stack is run under a JUnit (JUnit 4 for now).
     * 
     * @return {@code true} if this execution is under a JUnit 4 execution.
     */
    public default boolean isUnderJUnit() {
        val stackTraces = Thread.currentThread().getStackTrace();
        val isInJUnit = Arrays.stream(stackTraces)
            .map(Object::toString)
            .map(String::trim)
            .anyMatch(each->each.startsWith("org.junit.runners.ParentRunner.run(ParentRunner.java:"));
        return isInJUnit;
    }
    
}

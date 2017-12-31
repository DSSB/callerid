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

import lombok.val;

/**
 * Classes implementing this interface can trace a caller.
 * 
 * @author NawaMan
 */
public interface ITraceCaller {
    
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
    
}

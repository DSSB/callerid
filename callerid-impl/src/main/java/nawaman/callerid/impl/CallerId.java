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
package nawaman.callerid.impl;

import lombok.val;
import nawaman.callerid.ITraceCaller;

/**
 * Implementation to get the caller.
 * 
 * @author NawaMan
 */
public class CallerId implements ITraceCaller {
    
    /** The default instance of the caller id. */
    public static final CallerId instance = new CallerId();
    
    /** {@inheritDoc} */ @Override
    public StackTraceElement caller(int _offset) {
        val offset     = Math.max(0, _offset);
        val stackTrace = Thread.currentThread().getStackTrace();
        val length     = stackTrace.length;
        val index      = Math.min(length - 1, 3) + offset;
        return stackTrace[index];
    }
    
}

package dssb.callerid.impl;

import dssb.callerid.ITraceCaller;
import lombok.val;

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

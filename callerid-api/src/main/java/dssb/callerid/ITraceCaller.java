package dssb.callerid;

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
    public StackTraceElement caller(int offset);
    
}

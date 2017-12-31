package dssb.callerid.impl;

import dssb.callerid.impl.CallerId;

@SuppressWarnings("javadoc")
public class Calling2 {
    
    public StackTraceElement zero() {
        return first();
    }
    
    public StackTraceElement first() {
        return second();
    }
    
    public StackTraceElement second() {
        return CallerId.instance.caller(1);
    }
    
}

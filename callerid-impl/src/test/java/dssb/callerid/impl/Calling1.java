package dssb.callerid.impl;

import dssb.callerid.impl.CallerId;

@SuppressWarnings("javadoc")
public class Calling1 {
    
    public StackTraceElement first() {
        return second();
    }
    
    public StackTraceElement second() {
        return CallerId.instance.caller();
    }
    
}
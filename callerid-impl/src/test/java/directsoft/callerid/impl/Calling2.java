package directsoft.callerid.impl;

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

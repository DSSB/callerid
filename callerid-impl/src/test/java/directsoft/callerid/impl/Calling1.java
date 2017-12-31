package directsoft.callerid.impl;

@SuppressWarnings("javadoc")
public class Calling1 {
    
    public StackTraceElement first() {
        return second();
    }
    
    public StackTraceElement second() {
        return CallerId.instance.caller();
    }
    
}
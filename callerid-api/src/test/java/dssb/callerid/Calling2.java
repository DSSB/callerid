package dssb.callerid;

@SuppressWarnings("javadoc")
public class Calling2 {
    
    private final ITraceCaller tracer;
    
    public Calling2(ITraceCaller tracer) {
        this.tracer = tracer;
    }
    
    public StackTraceElement caller() {
        return first();
    }
    
    public StackTraceElement first() {
        return checker();
    }
    
    public StackTraceElement checker() {
        return tracer.caller(1);
    }
    
}

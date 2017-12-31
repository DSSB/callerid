package dssb.callerid;

@SuppressWarnings("javadoc")
public class Calling1 {
    
    private final ITraceCaller tracer;
    
    public Calling1(ITraceCaller tracer) {
        this.tracer = tracer;
    }
    
    public StackTraceElement caller() {
        return checker();
    }
    
    public StackTraceElement checker() {
        return tracer.caller();
    }
    
}
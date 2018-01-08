package dssb.callerid;

@SuppressWarnings("javadoc")
public class Callee {
    
    public boolean isCallLocal(IGetCaller iGetCaller) {
        return iGetCaller.isLocalCall();
    }
    
}

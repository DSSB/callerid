package dssb.callerid;

@SuppressWarnings("javadoc")
public class LocalCaller {
    
    public boolean callThenCheckIfLocal(IGetCaller iGetCaller) {
        return new Callee().isCallLocal(iGetCaller);
    }
    
}

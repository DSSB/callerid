package dssb.callerid.remote;

import dssb.callerid.Callee;
import dssb.callerid.IGetCaller;

@SuppressWarnings("javadoc")
public class RemoteCaller {
    
    public boolean callThenCheckIfLocal(IGetCaller iGetCaller) {
        return new Callee().isCallLocal(iGetCaller);
    }
    
}

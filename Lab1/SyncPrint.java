public class SyncPrint implements Runnable {
    private final char symbol;
    private final Sync sync;
    private final boolean controlValue;

    public SyncPrint(char symbol,Sync sync, boolean control)
    {
        this.symbol = symbol;
        this.sync = sync;
        controlValue = control;
    }
    @Override
    public void run(){
        while(!sync.getStop()){
            sync.waitLogic(controlValue,symbol);
        }
    }
}

public class Task5 {
    public static void main(String[] args){
        Sync permission = new Sync(100);
        Thread th1 =  new Thread(new SyncPrint('-',permission,true));
        Thread th2 =  new Thread(new SyncPrint('|',permission,false));
        th1.start();
        th2.start();
    }
}

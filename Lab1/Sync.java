public class Sync {
    private boolean stop = false;
    private boolean permission = true;
    private int num = 0;
    int numOfSymbols;

    public Sync(int numOfSymbols){
        stop = false;
        num = 0;
        permission = true;
        this.numOfSymbols = numOfSymbols;
    }

    public synchronized boolean getStop(){
        return  stop;
    }

    public synchronized boolean getPermission(){
        return permission;
    }

    public synchronized void waitLogic(boolean control,char s){
        while(getPermission() != control){
            try{
                wait();
            } catch (InterruptedException ex){
            }
        }

        permission = !permission;

       if(num < numOfSymbols)
       {
           System.out.print(s);
           ++num;

       }
       else {
           stop=true;
       }
       notifyAll();
    }
}

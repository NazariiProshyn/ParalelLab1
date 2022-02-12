public class BallThread extends Thread{
    private Ball b;
    public static int threadCount = 0;
    private Thread joinedThread;

    public BallThread(Ball ball)
    {
        b = ball;
    }

    public void setJoinedThread(Thread thread) {
        joinedThread = thread;
    }

    @Override
    public void run() {
        System.out.println("Started Thread name : " + Thread.currentThread().getName());
        try {

            for(int i=1; i<1000; i++){
                if (b.checkJoined()) {
                    joinedThread.join();
                }
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);

            }
        }
        catch (InterruptedException ex) {}
        System.out.println("Finished Thread name : " + Thread.currentThread().getName());
        ++threadCount;
    }
}

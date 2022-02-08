import java.awt.*;

public class NewThreads extends Thread{
    private int ballsCount;
    private BallCanvas canvas;
    Color[] colorsArr = {Color.red,Color.blue,Color.yellow};

    public NewThreads(int ballsNumber, BallCanvas can) {
        ballsCount = ballsNumber;
        canvas = can;
    }

    public void run() {

        for(int i = 0 ; i < colorsArr.length; ++i )
        {

            Ball b = new Ball(canvas,colorsArr[i]);
            canvas.add(b);
            BallThread thread = new BallThread(b);
            thread.start();

            System.out.println("Thread name = " + thread.getName());
            try {
                thread.join();
            }
            catch (InterruptedException ex) {
                System.out.println("Interrupted : Thread name = " + thread.getName());
            }
            System.out.println("Joined: " + thread.getName());
        }

    }
}
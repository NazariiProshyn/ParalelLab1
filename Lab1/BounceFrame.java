import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BounceFrame extends JFrame{
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread Name = " + Thread.currentThread().getName());
        Container content = getContentPane();
        content.add(canvas, BorderLayout.CENTER);
        JPanel buttonPatel = new JPanel();
        buttonPatel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonJoin = new JButton("Join");
        JButton buttonStop = new JButton("Stop");

        Color[] ballsColors = {Color.red,Color.blue,Color.green};


        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b1 = new Ball(canvas, Color.red);
                canvas.add(b1);
                BallThread thread1 = new BallThread(b1);
                thread1.start();

                Ball b2 = new Ball(canvas, Color.blue);
                canvas.add(b2);
                BallThread thread2 = new BallThread(b2);
                thread2.start();

                Ball b3 = new Ball(canvas, Color.green);
                canvas.add(b3);
                BallThread thread3 = new BallThread(b3);
                thread3.setThreadToJoin(thread1);
                thread3.start();
            }
        });

        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.joinBalls();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPatel.add(buttonStart);
        buttonPatel.add(buttonJoin);
        buttonPatel.add(buttonStop);

        content.add(buttonPatel, BorderLayout.SOUTH);
    }
}

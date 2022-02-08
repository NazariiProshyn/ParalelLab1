import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm Task 1");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        buttonStart.addActionListener(new ActionListener() {

            boolean redColor   = true;
            boolean blueColor  = false;
            int numOfRedBalls  = 1;
            int numOfBlueBalls = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < numOfRedBalls; ++i)
                {
                    Ball b = new Ball(canvas,redColor);
                    canvas.add(b);

                    BallThread thread = new BallThread(b);
                    thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
                }

                for(int i = 0; i < numOfBlueBalls; ++i)
                {
                    Ball b = new Ball(canvas,blueColor);
                    canvas.add(b);

                    BallThread thread = new BallThread(b);
                    thread.start();
                    System.out.println("Thread name = " +
                            thread.getName());
                }
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        }); buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
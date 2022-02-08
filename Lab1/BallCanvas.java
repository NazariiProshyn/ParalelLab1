import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallCanvas extends JPanel{
    private int numOfBallsInHole = 0;
    private int radiusOfHole = 100;
    private int coordinateHole = 275;

    private ArrayList<Ball> balls = new ArrayList<>();
    private JLabel ballsInHoul = new JLabel("Balls in hole: 0");
    public void add(Ball b){
        this.balls.add(b);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<balls.size();i++){
            Ball b = balls.get(i);
            if(b.checkBallInHall(coordinateHole + radiusOfHole,radiusOfHole))
            {
                balls.remove(i);
                ++numOfBallsInHole;
            }
            else
            {
                b.draw(g2);
            }
        }
        ballsInHoul.setText("Balls in hole: " + String.valueOf(numOfBallsInHole));
        add(ballsInHoul);
        g2.setColor(Color.BLACK);
        g2.fillOval(coordinateHole,coordinateHole,radiusOfHole * 2,radiusOfHole * 2);
    }
}
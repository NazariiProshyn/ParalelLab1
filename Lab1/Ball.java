import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball {
    private Component canvas;
    private static final int RXSIZE = 20;
    private static final int RYSIZE = 20;
    private static final int BXSIZE = 20;
    private static final int BYSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private boolean colorOfBall = false;

    public Ball(Component c,Boolean color){
        this.canvas = c;
        colorOfBall = color;
    }

    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){
        if(colorOfBall)
        {
            g2.setColor(Color.RED);
            g2.fill(new Ellipse2D.Double(x,y,RXSIZE,RXSIZE));
        }
        else
        {
            g2.setColor(Color.BLUE);
            g2.fill(new Ellipse2D.Double(x,y,BXSIZE,BXSIZE));
        }


    }

    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x = 0;
            dx = -dx;
        }
        if(x+RXSIZE>=this.canvas.getWidth()){
            x = this.canvas.getWidth()-RXSIZE;dx = -dx;
        }
        if(y<0){
            y=0;
            dy = -dy;
        }
        if(y+RYSIZE>=this.canvas.getHeight()){
            y = this.canvas.getHeight()-RYSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class second extends JPanel implements ActionListener , KeyListener {
    Timer t = new Timer(5,this);
    double x=0;
    double y=0;
    double velX=0;
    double velY=0;
    double r=4;
    double s=3;

    public second(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x,y,40,40);
        Ellipse2D hero = new Hero.Double(x,y,40,40);
        Ellipse2D hero2 = new Hero.Double(40,40,40,40);
        g2.fill(hero);
       // g2.fill(hero2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        /*if(x < 0 || x > 910){
            velX = -velX;
        }
        if(y < 0 || y > 850){
            velY = -velY;
        }*/
        x += velX;
        y += velY;

    }
    public void up(){
        velY= -1.5;
        velX = 0;
    }
    public void down(){
        velY = 1.5;
        velX = 0;
    }

    public void left(){
        velX = -1.5;
        velY = 0;
    }

    public void right(){
        velX = 1.5;
        velY= 0;
    }

    public void upStop(){
        velY = 0;
        velX = 0;
    }

    public void downStop(){
        velY = 0;
        velX = 0;
    }

    public void leftStop(){
        velX = 0;
        velY = 0;
    }

    public void rightStop(){
        velX = 0;
        velX = 0;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if( code == KeyEvent.VK_UP){
            up();
        }
        if(code == KeyEvent.VK_DOWN){
            down();
        }
        if (code == KeyEvent.VK_LEFT){
            left();
        }
        if (code == KeyEvent.VK_RIGHT){
            right();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            upStop();
        }
        if (code == KeyEvent.VK_DOWN){
            downStop();
        }
        if(code == KeyEvent.VK_LEFT){
            leftStop();
        }

        if(code == KeyEvent.VK_RIGHT){
            rightStop();
        }


    }
}

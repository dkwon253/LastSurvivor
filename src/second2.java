import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class second2 extends JPanel implements ActionListener  {
    Timer t = new Timer(5, this);
    double x = 0;
    double y = 0;
    double velX = 2;
    double velY = 2;
    double r = 4;
    double s = 3;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
        Ellipse2D hero = new Hero.Double(x, y, 40, 40);
        Ellipse2D hero2 = new Hero.Double(40, 40, 40, 40);
        g2.fill(circle);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (x < 0 || x > 910) {
            velX = -velX;
        }
        if (y < 0 || y > 850) {
            velY = -velY;
        }
        x += velX;
        y += velY;
        repaint();
    }

    public void up() {
        velY += -1.5;
        velX = 0;
    }

    public void down() {
        velY += 1.5;
        velX = 0;
    }

    public void left() {
        velX += -1.5;
        velY = 0;
    }

    public void right() {
        velX += 1.5;
        velY = 0;
    }

}

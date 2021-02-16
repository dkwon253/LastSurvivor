import javax.swing.*;

public class mover {


    public static void main(String args[]) {
        second s = new second();
        //second2 s2 = new second2();
        JFrame f = new JFrame();
        f.add(s);
        //f.add(s2);
        f.setVisible(true);
        f.setSize(1000,900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Moving ball");

    }

}

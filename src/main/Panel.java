package main;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {
    // constructor method
    public Panel() {

    }

    // necessary to be able to draw
    public void paintComponent(Graphics g) {
        // call super class (parent class?), i.e. Jpanel in this case, then it te idk 
        super.paintComponent(g);

        // draws rectangles: args are (x, y, width, height)
        g.drawRect(50, 50, 25, 100);
        
        g.drawRect(200, 50, 25, 100);
        g.drawRect(250, 60, 25, 90);

        g.drawRect(50, 200, 25, 100);
        g.drawRect(100, 200, 25, 100);

        g.drawRect(200, 200, 25, 100);
        g.drawRect(250, 275, 80, 25);
    }
}

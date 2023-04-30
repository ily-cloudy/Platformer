package main;

import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.Keyboard;
import inputs.Mouse;

public class Panel extends JPanel {
    // creates object for mouse inputs, as it will be used twice
    private Mouse mouse_inputs;

    // position variables
    private int x = 0;
    private int y = 0;

    // constructor method
    public Panel() {
        //initializing mouse_inputs object
        mouse_inputs = new Mouse();
        // keyboard and mouse listeners
        addKeyListener(new Keyboard(this));
        addMouseListener(mouse_inputs);
        addMouseMotionListener(mouse_inputs);
    }

    // methods for change in position
    public void deltaX(int val) {
        this.x += val;
        // repaints the panel (otherwise nothing will happen)
        repaint();
    }
    public void deltaY(int val) {
        this.y += val;
        repaint();
    }

    // necessary to be able to draw
    public void paintComponent(Graphics g) {
        // call super class (parent class?), i.e. Jpanel in this case, then it te idk 
        super.paintComponent(g);

        // draws full rectangle: args are (x, y, width, height)
        g.fillRect(x, y, 25, 25);
    }
}

package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import inputs.Keyboard;
import inputs.Mouse;


public class Panel extends JPanel {
    // creates object for mouse inputs, as it will be used twice
    private Mouse mouse_inputs;

    // position variables and framerate
    private float x = 100;
    private float y = 200;
    private float xdir = 1.0f;
    private float ydir = 1.0f;
    private Random random;

    // rgb value parameters 
    private Color color = new Color(255,0,255);

    // constructor method
    public Panel() {
        // initializing random object 
        random = new Random();

        // initializing mouse_inputs object
        mouse_inputs = new Mouse();

        // keyboard and mouse listeners
        addKeyListener(new Keyboard(this));
        addMouseListener(mouse_inputs);
        addMouseMotionListener(mouse_inputs);
    }

    // methods for change in position
    public void deltaX(int val) {
        this.x += val;
    }
    public void deltaY(int val) {
        this.y += val;
    }

    // necessary to be able to draw
    public void paintComponent(Graphics g) {
        // call super class (parent class?), i.e. Jpanel in this case
        super.paintComponent(g);

        // silly method for moving rectangles and changing their color
        updateRectangles();

        // draw the thingys
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setColor(color);
        g.drawRect((int) x, (int) y, 65, 30);
        g.drawString("DVD",(int) x + 20, (int) y + 20);
        
    }

    // changes position parameters (x,y)
    // ensures that the drawing remains in frame
    // changes color every time direction is changed
    private void updateRectangles() {
        x += xdir;
        if(x > 420) {xdir *= -1; x = 420;color = randomColor();}
        if(x < 0) {xdir *= -1; x = 0;color = randomColor();}

        y += ydir;
        if(y > 430) {ydir *= -1; y = 430; color = randomColor();}
        if(y < 0) {ydir *= -1; y = 0;color = randomColor();}
    }

    // yep 
    private Color randomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }
}  

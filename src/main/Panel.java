package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.Keyboard;
import inputs.Mouse; 

public class Panel extends JPanel {

    private Game game;

    

    // creates object for mouse inputs, as it will be used twice
    private Mouse mouse_inputs;

    // constructor method
    public Panel(Game game) { 
        // initializing mouse_inputs object
        mouse_inputs = new Mouse();

        this.game = game;
        setPanelSize();

        // keyboard and mouse listeners
        addKeyListener(new Keyboard(this));
        addMouseListener(mouse_inputs);
        addMouseMotionListener(mouse_inputs); 
    }

    private void setPanelSize() {
        Dimension size = new Dimension(game.GAME_WIDTH, game.GAME_HEIGHT);  
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        System.out.println("dimensions: " + game.GAME_WIDTH + " : " + game.GAME_HEIGHT);
    }

    public void updateGame() {
    }

    // necessary to be able to draw
    public void paintComponent(Graphics g) {
        // call super class (parent class?), i.e. Jpanel in this case
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame() {
        return game;
    }
}  
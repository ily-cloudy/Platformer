package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.Keyboard;
import inputs.Mouse;

import static utility.Parameters.Directions.*;


public class Panel extends JPanel {
    // TO-DO: MOVE TO PLAYER CLASS
    private String player_action = "run";
    private int player_dircection = -1;
    private boolean moving = false;
    
    // creates object for mouse inputs, as it will be used twice
    private Mouse mouse_inputs;

    // position variables and framerate
    private float x = 100;
    private float y = 200;

    // images and animations
    private BufferedImage img;
//    private BufferedImage[][] animations;
    HashMap<String, BufferedImage[]> ani_map = new HashMap<>(); 
    private int ani_tick, ani_index, ani_speed = 7;

    // constructor method
    public Panel() {
        // initializing mouse_inputs object
        mouse_inputs = new Mouse();

        importImage();

        loadAnimations();

        setPanelSize();

        // keyboard and mouse listeners
        addKeyListener(new Keyboard(this));
        addMouseListener(mouse_inputs);
        addMouseMotionListener(mouse_inputs); 
    }

    public void setDirection(int direction) {
        this.player_dircection = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void loadAnimations() {
        
        // idle animation: 6 frames
        BufferedImage[] ani_idle = new BufferedImage[6];

        for (int i = 0; i < ani_idle.length; i++) {
            ani_idle[i] = img.getSubimage(i*32, 0, 32, 32);
        }
        
        ani_map.put("idle", ani_idle);
        
        // running animation; 7 frames
        BufferedImage[] ani_run = new BufferedImage[7];

        for (int i = 0; i < ani_run.length; i++) {
            ani_run[i] = img.getSubimage(i*32, 32, 32, 32);
        }
        
        ani_map.put("run", ani_run);


//        --ALTERNATIVE--

//        animations = new BufferedImage[5][9];
//
//        for (int j = 0; j < animations.length; j++) {
//            for(int i = 0; i < animations[j].length; i++) {
//                animations[j][i] = img.getSubimage(i*32, j*32, 32, 32);  
//            }
//        }
    }

    private void importImage() {

        try {
            img = ImageIO.read(new File("res/satyr-Sheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);  
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    // continously iterates through animation arrays at a fixed speed
    private void updateAnimationTick() {

        ani_tick ++;
        if (ani_tick >= ani_speed) {
            ani_tick = 0;
            ani_index ++;
            // note the rows of the array are still picked manually; therefore, its length is too.
            if (ani_index >= ani_map.get(player_action).length) {
                ani_index = 0;
            }
        }
    } 

    private void setAnimation() {

        if(moving) {
            player_action = "run";
        }
        else {
            player_action = "idle";
        }
    }

    private void changePosition() {
        if (moving) {
            switch(player_dircection) {
                case left:
                    x -= 4;
                    break;
                case up:
                    y -= 4;
                    break;
                case right:
                    x += 4;
                    break;
                case down:
                    y += 4;
                    break;
            }
        }
    }

    // necessary to be able to draw
    public void paintComponent(Graphics g) {
        // call super class (parent class?), i.e. Jpanel in this case
        super.paintComponent(g);

        updateAnimationTick();

        setAnimation();

        changePosition();

        // checking that animation index is in range again (this avoids exceptions)
        if (ani_index >= ani_map.get(player_action).length) {
            ani_index = 0;
        }

        g.drawImage(ani_map.get(player_action)[ani_index], (int) x, (int) y, 128, 128, null);
        
    }
}  
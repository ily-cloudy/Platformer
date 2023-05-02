package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

import utility.LoadSave;

import java.util.HashMap;

import static utility.Parameters.Directions.*;

public class Player extends Entity{

    private int ani_tick, ani_index, ani_speed = 12;
    private BufferedImage img;
    HashMap<String, BufferedImage[]> ani_map = new HashMap<>();

    private String player_action = "run";
    private boolean moving = false;
    private boolean left, up, right, down;
    private float player_speed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {

        changePosition();
        updateAnimationTick();
        setAnimation();
        

    }

    public void render(Graphics g) {

        if (ani_index >= ani_map.get(player_action).length) {
            ani_index = 0;
        }

        g.drawImage(ani_map.get(player_action)[ani_index], (int) x, (int) y, 128, 128, null);

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
       
        moving = false;

        if (left && !right) {
            x -= player_speed;
            moving = true;
        } 
        else if (right && !left) {
            x += player_speed;
            moving = true;
        }

        if (up && !down) {
            y -= player_speed;
            moving = true;
        }
        else if (down && !up) {
            y += player_speed;
            moving = true; 
        }
    }

    private void loadAnimations() {

        // loads player sprites
        img = LoadSave.GetSpriteSheet(LoadSave.SPRITES_PLAYER);

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
    }

    // is called when widow focus is lost; stops player from continuing to move
    public void resetBooleans() {
        left = false;
        right = false;
        down = false;
        up = false;

    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

}
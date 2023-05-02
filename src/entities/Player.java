package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import java.util.HashMap;

import static utility.Parameters.Directions.*;

public class Player extends Entity{

    private int ani_tick, ani_index, ani_speed = 12;
    private BufferedImage img;
    HashMap<String, BufferedImage[]> ani_map = new HashMap<>();

    private String player_action = "run";
    private int player_dircection = -1;
    private boolean moving = false;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {

        updateAnimationTick();
        setAnimation();
        changePosition();

    }

    public void render(Graphics g) {

        if (ani_index >= ani_map.get(player_action).length) {
            ani_index = 0;
        }

        g.drawImage(ani_map.get(player_action)[ani_index], (int) x, (int) y, 128, 128, null);

    }

    public void setDirection(int direction) {
        this.player_dircection = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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
                    x -= 3;
                    break;
                case up:
                    y -= 3;
                    break;
                case right:
                    x += 3;
                    break;
                case down:
                    y += 3;
                    break;
            }
        }
    }

    private void loadAnimations() {
        // reads image sprite
        try {
            img = ImageIO.read(new File("res/satyr-Sheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
}
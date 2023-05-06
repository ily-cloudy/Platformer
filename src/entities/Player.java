package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;


import main.Game;

import static utility.UtilMethods.*;

import utility.LoadSave;

import java.util.HashMap;

import static utility.Parameters.Directions.*;

public class Player extends Entity{

    private int ani_tick, ani_index, ani_speed = 12;
    private BufferedImage img;
    HashMap<String, BufferedImage[]> ani_map = new HashMap<>();

    private String player_action = "idle";
    private boolean moving = false;
    private boolean left, up, right, down, jump;
    private float player_speed = 2.0f;
    private int[][] collision_data;
    private float x_draw_offset = -11 * Game.SCALE;
	private float y_draw_offset = -11 * Game.SCALE;
    
    private float air_speed = 0f;
    private float gravity = 0.04f * Game.SCALE; // =.04 -> vel_max = 2.0 ,, it's weird i dont know whats wrong
    private float jump_vel = -2.00f * Game.SCALE;
    private float fall_vel_post_col= 0.5f;
    private boolean airborne = false;


    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x, y, 12*Game.SCALE,16*Game.SCALE);
    }

    public void update() {

        changePosition();
//        updateHitbox();
        updateAnimationTick();
        setAnimation();

    }

    public void render(Graphics g) {

        if (ani_index >= ani_map.get(player_action).length) {
            resetAniTick();
        }

        g.drawImage(ani_map.get(player_action)[ani_index], (int) (hitbox.x + x_draw_offset), (int) (hitbox.y + y_draw_offset), (int)(width), (int) (height), null);
//        drawHitbox(g);

    }


    // continously iterates through animation arrays at a fixed speed
    private void updateAnimationTick() {


        String current_ani = player_action;
        ani_tick ++;
        if (ani_tick >= ani_speed) {
            ani_tick = 0;
            ani_index ++;
            // note the rows of the array are still picked manually; therefore, its length is too.
            if (ani_index >= ani_map.get(player_action).length) {
                ani_index = 0;
            }
        }
        if (current_ani != player_action) {ani_index = 0; ani_tick = 0;}
    }
    
    private void setAnimation() {

//        String start_ani = player_action;

        if(moving) {
            player_action = "run";
        }
        else {
            player_action = "idle";
        }

		if (airborne) {
			if (air_speed < 0)
				player_action = "jump";
			else
				player_action = "fall";
		}

//        if (start_ani != player_action) {resetAniTick();}

    } 

    private void changePosition() {
        moving = false;

        if (jump) {
            jump();
        }

        if (!left && !right && !airborne) {return;}
        
        float x_speed = 0; 

        if (left) {
            x_speed -= player_speed;} 
        if (right) {
            x_speed += player_speed;}

        if (! airborne) {
            if (!IsEntityOnFloor(hitbox, collision_data)) {
                airborne = true;
            }
        }

        if (airborne) {
            if (CanMoveHere(hitbox.x, hitbox.y + air_speed, hitbox.width, hitbox.height, collision_data)) {
                hitbox.y += (float) air_speed;
                air_speed += (float) gravity;
                changeXPosition(x_speed);
            }
            else {
                hitbox.y = GetEntityYPositionBySolid(hitbox, air_speed);
                if (air_speed > 0) {
                    resetAirborne();
                }
                else {
                    air_speed = fall_vel_post_col;
                    x_speed += fall_vel_post_col;
                }
                changeXPosition(x_speed);
            }
        }
        else {
            changeXPosition(x_speed);
        }
        moving = true;
    }

    private void jump() {
        if (airborne) {return;}
        airborne = true;
        air_speed = jump_vel;

    }

    private void resetAirborne() {
        airborne = false;
        air_speed = 0;
    }

    private void changeXPosition(float x_speed) {
        if (CanMoveHere(hitbox.x + x_speed, hitbox.y, hitbox.width, hitbox.height, collision_data)) {
            hitbox.x += x_speed;
        }
        else {
            hitbox.x = GetEntityXPositionBySolid(hitbox, x_speed);
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

        // jumping animation; 3 frames
        BufferedImage[] ani_jump = new BufferedImage[3]; 

        for (int i = 0; i < ani_jump.length; i++) {
            ani_jump[i] = img.getSubimage(i*32, 64, 32, 32);
        }

        ani_map.put("jump", ani_jump);

        // jumping animation; 3 frames
        BufferedImage[] ani_jump2 = new BufferedImage[3]; 

        for (int i = 0; i < ani_jump2.length; i++) {
            ani_jump2[i] = img.getSubimage(i*32, 64, 32, 32);
        }

        ani_map.put("jump2", ani_jump2);

        // falling animation; 3 frames
        BufferedImage[] ani_fall = new BufferedImage[3]; 

        for (int i = 0; i < ani_fall.length; i++) {
            ani_fall[i] = img.getSubimage(i*32 + 4*32, 64, 32, 32);
        }

        ani_map.put("fall", ani_fall);

    }

    private void resetAniTick() {
		ani_tick = 0;
		ani_index = 0;
	}

    public void loadCollisionData (int[][] collision_data) {
        this.collision_data = collision_data;
        if (! IsEntityOnFloor(hitbox, collision_data)) {
            airborne = true;
        }
    }


    // is called when widow focus is lost; stops player from continuing to move
//    public void resetBooleans() {
//        left = false;
//        right = false;
//        down = false;
//        up = false;
//
//    }

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

    public void setJump (boolean jump) {
        this.jump = jump;
    }

}
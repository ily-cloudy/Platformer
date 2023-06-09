package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;


import main.Game;
import static utility.UtilMethods.*;
import utility.LoadSave;
import java.util.HashMap;
import static utility.Parameters.*;

public class Player extends Entity{

    // player specific animation parameters
    private BufferedImage img;
    HashMap<String, BufferedImage[]> ani_map = new HashMap<>();
    private String player_action = "idle";
    private boolean moving = false;
    private boolean left, right, jump, dash;
    private int[][] collision_data;
    private float x_draw_offset = -11 * Game.SCALE;
	private float y_draw_offset = -11 * Game.SCALE;
    
    // player specific movement parameters
    private float jump_vel = -2.00f * Game.SCALE;
    private float fall_vel_post_col= 0.5f;
    private boolean dash_used = false;

    // for flipping player character into the direction of travel
    private int flip_x = 0;
    private int flip_w = 1;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(12*Game.SCALE,16*Game.SCALE);
    }

    public void update() {
        changePosition();
        updateAnimationTick();
        setAnimation();
        checkDashReset();
    }

    public void render(Graphics g, int env_offset) {

        if (ani_index >= ani_map.get(player_action).length) { resetAniTick(); }

        g.drawImage(ani_map.get(player_action)[ani_index],
            (int) (hitbox.x + x_draw_offset) - env_offset + flip_x,
            (int) (hitbox.y + y_draw_offset), 
            (int) (width * flip_w), 
            (int) (height), null);
    }


    // Continously iterates through animation arrays at a fixed speed
    private void updateAnimationTick() {

        String current_ani = player_action;
        ani_tick ++;
        if (ani_tick >= ANI_SPEED) {
            ani_tick = 0;
            ani_index ++;
            // note the rows of the array are still picked manually; therefore, its length is too.
            if (ani_index >= ani_map.get(player_action).length) { 
                ani_index = 0; 
            }
        }

        if (current_ani != player_action) { 
            ani_index = 0; 
            ani_tick = 0; 
        }
    }
    
    private void setAnimation() {
        if (moving) {
            player_action = "run";
        }
        else {
            player_action = "idle";
        }

        if (dash) {
            player_action = "ghost";
        }

		if (airborne) {
			if (air_speed < 0)
				player_action = "jump";
			else
				player_action = "fall";
		}

    } 

    private void changePosition() {
        moving = false;

        if (jump) { jump(); }

        if (dash) { dash(); }

        if (!left && !right && !airborne) { 
            return; 
        }
        
        float x_speed = 0; 

        if (left) {
            x_speed -= RUNNING_SPEED;
            // flips animation to the left
            flip_x = width;
            flip_w = -1;
        } 
        if (right) {
            x_speed += RUNNING_SPEED;
            // flips animation to the right
            flip_x = 0;
            flip_w = 1;
        }

        if (!airborne) {
            if (!IsEntityOnFloor(hitbox, collision_data)) { 
                airborne = true; 
            }
        }

        if (airborne) {
            if (CanMoveHere(hitbox.x, hitbox.y + air_speed, hitbox.width, hitbox.height, collision_data)) {
                hitbox.y += (float) air_speed;
                air_speed += (float) GRAVITY;
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
        if (airborne) {
            return;
        }
        airborne = true;
        air_speed = jump_vel;
    }


    // FIX THIS PLS
    private void dash() {
        float speed;
        checkDashReset();
        if (this.dash_used) {return;}
        // checks travel direction and assigns the corresponding speed
        if (flip_w == 1) {speed = 1;}
        else {speed = -1;}
        
        for (int i = 0; i < 100; i++) {
            changeXPosition(speed);
        }
        this.dash_used = true;
        return;
    }
    // TO-DO: find suitable method to chack if !airborne for at least .2 seconds
    private void checkDashReset() {
        if (!airborne) {
            // wait 0.2 seconds 
            if (!airborne) {
                this.dash_used = false;
            }
        }
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
        img = LoadSave.GetSpriteSheet(LoadSave.SPRITES_PLAYER);

        // idle animation: 6 frames
        BufferedImage[] ani_idle = new BufferedImage[6];

        for (int i = 0; i < ani_idle.length; i++) {
            ani_idle[i] = img.getSubimage(i*32, 0, 32, 32);
        }
        
        ani_map.put("idle", ani_idle);
        
        // running animation; 8 frames
        BufferedImage[] ani_run = new BufferedImage[8];

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

        // falling animation; 3 frames
        BufferedImage[] ani_fall = new BufferedImage[3]; 

        for (int i = 0; i < ani_fall.length; i++) {
            ani_fall[i] = img.getSubimage(i*32 + 4*32, 64, 32, 32);
        }

        ani_map.put("fall", ani_fall);


        // death animation; 9 frames 
        BufferedImage[] ani_death = new BufferedImage[9];

        for (int i = 0; i < ani_death.length; i++) {
            ani_death[i] = img.getSubimage(i*32, 3*32, 32, 32);
        }
        
        ani_map.put("death", ani_death);

        // ghost animation (use for dash??); 4 frames
        BufferedImage[] ani_ghost = new BufferedImage[4];

        for (int i = 0; i < ani_ghost.length; i++) {
            ani_ghost[i] = img.getSubimage(i*32, 4*32, 32, 32);
        }
        
        ani_map.put("ghost", ani_ghost);
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

    // annoying methods; ignore  
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setJump (boolean jump) {
        this.jump = jump;
    }

    public void setDash (boolean dash) {
        this.dash = dash;
    }
}
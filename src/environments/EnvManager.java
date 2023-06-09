package environments;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import main.Game;
import utility.LoadSave;
import environments.*;
import gamestates.Gamestate;

public class EnvManager {

    private int dim_x, dim_y;
    private String sprite = "spikes up2 1x1";

    private Env1Data envdata;
    private Game game;
    HashMap<String, BufferedImage> env_sprite_map = new HashMap<>();


    public EnvManager(Game game) {
        this.game = game;
        importSprites();
        switch (Environment.env) {
            case ENV1:
                Env1Data.loadEnv();
                break;
            case ENV2:
                Env2Data.loadEnv();
                break;
            default:
                break;
        }
    }

    private void importSprites() {
        
        // look i know this is a massive bodge but i was tired and it works

        BufferedImage img = LoadSave.GetSpriteSheet(LoadSave.SPRITES_ENVIRONMENT);

        // blocks
        env_sprite_map.put("dark 1x1", img.getSubimage(0, 9*16, 1*16, 1*16));
        env_sprite_map.put("dark+vine 1x1", img.getSubimage(17*16, 9*16, 1*16, 1*16));
        env_sprite_map.put("rect 3x1", img.getSubimage(1*16, 9*16, 3*16, 1*16));
        env_sprite_map.put("grass1 1x1", img.getSubimage(4*16, 9*16, 1*16, 1*16));
        env_sprite_map.put("grass2 1x1", img.getSubimage(5*16, 9*16, 1*16, 1*16));
        env_sprite_map.put("pond 6x1", img.getSubimage(6*16, 9*16, 6*16, 1*16));
        env_sprite_map.put("grass 2x1", img.getSubimage(12*16, 9*16, 2*16, 1*16));
        env_sprite_map.put("orange grass 3x1", img.getSubimage(14*16, 9*16, 3*16, 1*16));
        env_sprite_map.put("rect1 2x1", img.getSubimage(2*16, 10*16, 2*16, 1*16));
        env_sprite_map.put("orange rect 2x1", img.getSubimage(4*16, 10*16, 2*16, 1*16));
        env_sprite_map.put("rect2 2x1", img.getSubimage(6*16, 10*16, 2*16, 1*16));
        env_sprite_map.put("rect3 2x1", img.getSubimage(8*16, 10*16, 2*16, 1*16));
        // corner blocks
        env_sprite_map.put("c1 top left 1x1", img.getSubimage(5*16, 1*16, 1*16, 1*16));
        env_sprite_map.put("c1 top right 1x1", img.getSubimage(6*16, 1*16, 1*16, 1*16));
        env_sprite_map.put("c1 bot left 1x1", img.getSubimage(5*16, 2*16, 1*16, 1*16));
        env_sprite_map.put("c1 bot right 1x1", img.getSubimage(6*16, 2*16, 1*16, 1*16));
        env_sprite_map.put("c2 top left 1x1", img.getSubimage(8*16, 1*16, 1*16, 1*16));
        env_sprite_map.put("c2 top right 1x1", img.getSubimage(9*16, 1*16, 1*16, 1*16));
        env_sprite_map.put("c2 bot left 1x1", img.getSubimage(8*16, 2*16, 1*16, 1*16));
        env_sprite_map.put("c2 bot right 1x1", img.getSubimage(9*16, 2*16, 1*16, 1*16));
        // one-way platforms
        env_sprite_map.put("oneway left 2x1", img.getSubimage(5*16, 4*16, 2*16, 1*16));
        env_sprite_map.put("oneway right 2x1", img.getSubimage(8*16, 4*16, 2*16, 1*16));
        env_sprite_map.put("oneway 1x1", img.getSubimage(7*16, 4*16, 1*16, 1*16));
        // traps
        env_sprite_map.put("spikes up1 1x1", img.getSubimage(10*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes up2 1x1", img.getSubimage(11*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes right1 1x1", img.getSubimage(12*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes right2 1x1", img.getSubimage(13*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes down1 1x1", img.getSubimage(14*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes down2 1x1", img.getSubimage(15*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes left1 1x1", img.getSubimage(16*16, 10*16, 1*16, 1*16));
        env_sprite_map.put("spikes left2 1x1", img.getSubimage(16*16, 10*16, 1*16, 1*16));
        // trees
        env_sprite_map.put("tree 7x9", img.getSubimage(176, 0, 112, 144));
        env_sprite_map.put("tree 4x4", img.getSubimage(0, 5*16, 4*16, 4*16));
        // no collision decorations
        env_sprite_map.put("lights 1x2", img.getSubimage(0, 2*16, 1*16, 2*16));
        env_sprite_map.put("lights 1x1", img.getSubimage(1*16, 2*16, 1*16, 1*16));
        env_sprite_map.put("lights 1x3", img.getSubimage(2*16, 2*16, 1*16, 3*16));
        env_sprite_map.put("hang grass 1x1", img.getSubimage(1*16, 3*16, 1*16, 1*16));
        env_sprite_map.put("tiny bush 1x1", img.getSubimage(0*16, 4*16, 1*16, 1*16));
        env_sprite_map.put("bush1 1x1", img.getSubimage(1*16, 4*16, 1*16, 1*16));
        env_sprite_map.put("bush2 1x1", img.getSubimage(9*16, 7*16, 1*16, 1*16));
        env_sprite_map.put("bush3 1x1", img.getSubimage(9*16, 8*16, 1*16, 1*16));
        env_sprite_map.put("bush 3x2", img.getSubimage(7*16, 5*16, 3*16, 2*16));
        env_sprite_map.put("bush on rock 5x2", img.getSubimage(4*16, 7*16, 5*16, 2*16));
        env_sprite_map.put("rock 2x2", img.getSubimage(3*16, 3*16, 2*16, 2*16));
        env_sprite_map.put("stub 1x1", img.getSubimage(4*16, 5*16, 1*16, 1*16));
        env_sprite_map.put("topgrass1 1x1", img.getSubimage(4*16, 6*16, 1*16, 1*16));
        env_sprite_map.put("topgrass2 1x1", img.getSubimage(5*16, 6*16, 1*16, 1*16));
        env_sprite_map.put("topgrass3 1x1", img.getSubimage(6*16, 6*16, 1*16, 1*16));
        env_sprite_map.put("cornervine1 1x1", img.getSubimage(5*16, 5*16, 1*16, 1*16));
        env_sprite_map.put("cornervine2 1x1", img.getSubimage(6*16, 5*16, 1*16, 1*16));
        env_sprite_map.put("leftvine1 1x1", img.getSubimage(7*16, 1*16, 1*16, 1*16));
        env_sprite_map.put("leftvine2 1x1", img.getSubimage(7*16, 2*16, 1*16, 1*16));
        env_sprite_map.put("leftvine3 1x1", img.getSubimage(7*16, 3*16, 1*16, 1*16));
        env_sprite_map.put("rightvine1 1x1", img.getSubimage(10*16, 1*16, 1*16, 1*16));
        env_sprite_map.put("rightvine2 1x1", img.getSubimage(10*16, 2*16, 1*16, 1*16));
        env_sprite_map.put("rightvine3 1x1", img.getSubimage(10*16, 3*16, 1*16, 1*16)); 
    }

    // Renders the environment hashmap
    // yes, it is unreadable; that is the point. only i may know the secrets! >:3
    // TO-DO: Make this readable again.
    public void draw(Graphics g, int lvl_offset) {
        switch (Environment.env) {
            case ENV1:
                Env1Data.layout.forEach((k,v) -> {
                    // calls render method
                    g.drawImage(
                        // retrieves sprite based on string input v
                        env_sprite_map.get(v),
                        // determines x position based on the x component of the provided coordinate 
                        k[0]*Game.TILES_SIZE - lvl_offset,
                        // determines y position based on the y component of the provided coordinate
                        k[1]*Game.TILES_SIZE,
                        // determines width
                        (int)(Integer.parseInt(String.valueOf(v.charAt(v.length()-3)))*Game.SCALE*16),
                        // determines height
                        (int)(Integer.parseInt(String.valueOf(v.charAt(v.length()-1)))*Game.SCALE*16),
                        null);});
                break;
            case ENV2:
                Env2Data.layout.forEach((k,v) -> {
                    g.drawImage(env_sprite_map.get(v),
                    k[0]*Game.TILES_SIZE - lvl_offset,
                    k[1]*Game.TILES_SIZE,
                    (int)(Integer.parseInt(String.valueOf(v.charAt(v.length()-3)))*Game.SCALE*16),
                    (int)(Integer.parseInt(String.valueOf(v.charAt(v.length()-1)))*Game.SCALE*16),
                    null);}); 
                break;
            default:
                break;
        }
    }
    // TO-DO: make this pls. Update: what and why is this?
    public void update() {
    }
}

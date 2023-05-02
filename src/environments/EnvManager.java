package environments;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import main.Game;
import utility.LoadSave;

public class EnvManager {
    
    private Game game;
//  private BufferedImage env_sprite;
    HashMap<String, BufferedImage> env_sprite_map = new HashMap<>();


    public EnvManager(Game game) {
        this.game = game;
//      env_sprite = LoadSave.GetSpriteSheet(LoadSave.SPRITES_ENVIRONMENT);
        importSprites();
    }

    private void importSprites() {
        
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
        // one-way platforms
        
        // traps

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
        env_sprite_map.put("rock 2x2", img.getSubimage(3*16, 3*16, 2*16, 2*16));
    }

    public void draw(Graphics g) {
        g.drawImage(env_sprite_map.get("bush1 1x1"), 100, 100, 1*4*16, 1*4*16, null);
    }

    public void update() {
    }
}

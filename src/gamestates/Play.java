package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import entities.Player;
import environments.Env1Data;
import environments.Env2Data;
import environments.EnvManager;
import environments.Environment;
import main.Game;
import utility.LoadSave;

public class Play extends State implements StateMethods{
    private Player player;
    private EnvManager env_manager;

    private int x_env_offset = 0;
    private int left_border = (int) (0.3 * Game.GAME_WIDTH);
    private int right_border = (int) (0.7 * Game.GAME_WIDTH);
    
    private int env_tiles_width;
    
    private int max_tile_offset;
    private int max_env_offset;

    private BufferedImage background0;
    private BufferedImage background1;
    private BufferedImage background2;
    
    public Play(Game game) {
        super(game);
        initEntities();
        Env1Data.loadEnv();
        this.env_tiles_width = Env1Data.collision_matrix[0].length;
        this.max_tile_offset = env_tiles_width - Game.TILES_WIDTH;
        this.max_env_offset = max_tile_offset * Game.TILES_SIZE;

        // static bg
        background0 = LoadSave.GetSpriteSheet(LoadSave.BACKGROUND_0);
        // should move
        background1 = LoadSave.GetSpriteSheet(LoadSave.BACKGROUND_1);
        // mby move idk does that look good?
        background2 = LoadSave.GetSpriteSheet(LoadSave.BACKGROUND_2); 
    }

    private void initEntities() {
        env_manager = new EnvManager(game);
        player = new Player(50, 200, (int) (32*Game.SCALE), (int) (32*Game.SCALE));
        switch (Environment.env) {
            case ENV1:
                player.loadCollisionData(Env1Data.collision_matrix);
                break;
            case ENV2:
                player.loadCollisionData(Env2Data.collision_matrix);
                break;
            default:
                break;
        }
    }

    @Override
    public void update() {
        env_manager.update();
        player.update();
        checkCloseToBorder();
    }

    @Override
    public void draw(Graphics g) {

        // yep im lazy like that
        g.drawImage(background0, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        drawMovingBackground(g);
        env_manager.draw(g, x_env_offset);
        player.render(g, x_env_offset);
    }

    private void drawMovingBackground(Graphics g) {
        // mod: 'if picture does not fit perfectly inside the panel: draw a new one with x = x_0 + panel width
        // x positon: -1 at end prevents gap between seperate cloud pictures  
        g.drawImage(background1, 0 - (int) (x_env_offset * 0.3), 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        if ((x_env_offset * 0.3) % Game.GAME_WIDTH != 0) {
            g.drawImage(background1, 0 - (int) (x_env_offset * 0.3) + Game.GAME_WIDTH - 1, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        } 

        g.drawImage(background2, 0 - (int) (x_env_offset * 0.7), 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        if ((x_env_offset * 0.7) % Game.GAME_WIDTH != 0) {
            g.drawImage(background2, 0 - (int) (x_env_offset * 0.7) + Game.GAME_WIDTH * 1 - 1, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
            // second cloud image; more can be added this way. this should be formalized later.
            g.drawImage(background2, 0 - (int) (x_env_offset * 0.7) + Game.GAME_WIDTH * 2 - 1, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        }   
    }

    private void checkCloseToBorder() {
        int player_x = (int) player.getHitbox().x;
        int delta = player_x - x_env_offset;

        if (delta > right_border) {
            x_env_offset += delta - right_border;
        }
        else if (delta < left_border) {
            x_env_offset += delta - left_border;
        }
        // ENFORCES PROPER MAX AND MIN OFFSET
        if (x_env_offset > max_env_offset) {
            x_env_offset = max_env_offset;
        }
        else if (x_env_offset < 0) {
            x_env_offset = 0;
        }
    }

    @Override 
    public void mouseClicked(MouseEvent e) {
          // not used in current gamestate
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // not used in current gamestate
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // not used in current gamestate
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // not used in current gamestate
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_D:
                player.setRight(true);
                break;
            case KeyEvent.VK_A:
                player.setLeft(true);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(true);
                break;
                
            case KeyEvent.VK_SHIFT:
                player.setDash(true);
                break;

            case KeyEvent.VK_ESCAPE:
                Gamestate.state = Gamestate.MENU;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_D:
                player.setRight(false);
                break;
            case KeyEvent.VK_A:
                player.setLeft(false);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(false);
                break;
            case KeyEvent.VK_SHIFT:
                player.setDash(false);
                break;
        }
    }

    

    public Player getPlayer() {
        return player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}
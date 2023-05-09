package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import environments.EnvData;
import environments.EnvManager;
import main.Game;

public class Play extends State implements StateMethods{
    private Player player;
    private EnvManager env_manager;

    private int x_env_offset;
    private int left_border = (int) (0.3 * Game.GAME_WIDTH);
    private int right_border = (int) (0.7 * Game.GAME_WIDTH);
    
    private int env_tiles_width;
    
    private int max_tile_offset;
    private int max_env_offset;
    
    public Play(Game game) {
        super(game);
        initEntities();
        EnvData.env1();
        this.env_tiles_width = EnvData.collision_matrix[0].length;
        this.max_tile_offset = env_tiles_width - Game.TILES_WIDTH;
        this.max_env_offset = max_tile_offset * Game.TILES_SIZE;
         
    }

    private void initEntities() {
        env_manager = new EnvManager(game);
        player = new Player(50, 200, (int) (32*Game.SCALE), (int) (32*Game.SCALE));
        player.loadCollisionData(EnvData.collision_matrix);
    }

    @Override
    public void update() {
        env_manager.update();
        player.update();
        checkCloseToBorder();
    }

    @Override
    public void draw(Graphics g) {
        env_manager.draw(g, x_env_offset);
        player.render(g, x_env_offset);
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
            case KeyEvent.VK_RIGHT:
                player.setRight(true);
                break;
            case KeyEvent.VK_LEFT:
                player.setLeft(true);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(true);
                break;
            case KeyEvent.VK_ESCAPE:
                Gamestate.state = Gamestate.MENU;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                player.setRight(false);
                break;
            case KeyEvent.VK_LEFT:
                player.setLeft(false);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(false);
                break;
        }
    }

    public Player getPlayer() {
        return player;
    }

}
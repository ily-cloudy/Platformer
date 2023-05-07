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
    
    public Play(Game game) {
        super(game);
        initEntities();
         
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
    }

    @Override
    public void draw(Graphics g) {
        env_manager.draw(g);
        player.render(g);
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
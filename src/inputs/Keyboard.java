package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestates.Gamestate;
import main.Panel;

public class Keyboard implements KeyListener{

    private Panel game_panel;

    public Keyboard(Panel game_panel) {
        this.game_panel = game_panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (Gamestate.state) {
            case PLAY:
                game_panel.getGame().getPlay().keyPressed(e);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                game_panel.getGame().getMenu().keyPressed(e);
                break;
            case PLAY:
                game_panel.getGame().getPlay().keyPressed(e);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                game_panel.getGame().getMenu().keyReleased(e);
                break;
            case PLAY:
                game_panel.getGame().getPlay().keyReleased(e);
                break;
            default:
                break; 
        }
    }
}

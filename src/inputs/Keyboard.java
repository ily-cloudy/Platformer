package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Panel;

import static utility.Parameters.Directions.*;

// implements is like inheritance for methods? :/ it work
public class Keyboard implements KeyListener{

    private Panel game_panel;

    //constructor
    public Keyboard(Panel game_panel) {
        // 'this.' refers to the current object/instance, kind of like self. in py
        this.game_panel = game_panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // checks if relevant key is pressed, then changes the position in the corresponding direction
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                game_panel.setDirection(up);
                break;
            case KeyEvent.VK_RIGHT:
                game_panel.setDirection(right);
                break;
            case KeyEvent.VK_DOWN:
                game_panel.setDirection(down);
                break;
            case KeyEvent.VK_LEFT:
                game_panel.setDirection(left);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                game_panel.setMoving(false);
                break;
            case KeyEvent.VK_RIGHT:
                game_panel.setMoving(false);
                break;
            case KeyEvent.VK_DOWN:
                game_panel.setMoving(false);
                break;
            case KeyEvent.VK_LEFT:
                game_panel.setMoving(false);
                break;
        }
    }
    
}

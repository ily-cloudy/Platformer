package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Panel;

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
                game_panel.deltaY(-5);
                break;
            case KeyEvent.VK_RIGHT:
                game_panel.deltaX(5);
                break;
            case KeyEvent.VK_DOWN:
                game_panel.deltaY(5);
                break;
            case KeyEvent.VK_LEFT:
                game_panel.deltaX(-5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}

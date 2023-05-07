package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import utility.LoadSave;

public class Menu extends State implements StateMethods{
    private BufferedImage[] imgs;


    public Menu(Game game) {
        super(game);
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

    @Override
    public void draw(Graphics g) {
        imgs = new BufferedImage[3];
        imgs[0] = LoadSave.GetSpriteSheet(LoadSave.BACKGROUND_0);
        imgs[1] = LoadSave.GetSpriteSheet(LoadSave.BACKGROUND_1);
        imgs[2] = LoadSave.GetSpriteSheet(LoadSave.BACKGROUND_2);
        
        for (int i = 0; i < imgs.length; i++) {
            g.drawImage(imgs[i], 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Dialog", Font.PLAIN, 25)); 
        g.drawString("menu <3", Game.GAME_WIDTH / 8, (int) (50 * Game.SCALE));
        g.drawString("-", Game.GAME_WIDTH / 8, (int) (60 * Game.SCALE));
        g.drawString("press enter to start!", Game.GAME_WIDTH / 8, (int) (70 * Game.SCALE));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Gamestate.state = Gamestate.PLAY;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
     
}

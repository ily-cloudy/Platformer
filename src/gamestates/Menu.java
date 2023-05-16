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
    private BufferedImage img;

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
        
        img = LoadSave.GetSpriteSheet(LoadSave.MENU);

        for (int i = 0; i < imgs.length; i++) {
            g.drawImage(imgs[i], 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        }
        
        g.drawImage(img, (int) (15*16*Game.SCALE), (int) (2*16*Game.SCALE), (int) (112 * Game.SCALE), (int) (176 * Game.SCALE), null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, (int) (8 * Game.SCALE))); 
        g.drawString("1|  public void PlaceHolder() {", Game.GAME_WIDTH / 6, (int) (67 * Game.SCALE));
        
        g.setFont(new Font("Monospaced", Font.PLAIN, (int) (8 * Game.SCALE))); 
        g.drawString("2|      press ENTER to start;", Game.GAME_WIDTH / 6, (int) (103 * Game.SCALE));
        g.drawString("3|      art by LuckyLoops and Trixie;", Game.GAME_WIDTH / 6, (int) (119 * Game.SCALE));
        g.drawString("4|      music by Lou;", Game.GAME_WIDTH / 6, (int) (135 * Game.SCALE));
        g.drawString("5|      programmed by Lou;", Game.GAME_WIDTH / 6, (int) (151 * Game.SCALE));
        g.drawString("6|      }", Game.GAME_WIDTH / 6, (int) (167 * Game.SCALE));
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

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
     
}

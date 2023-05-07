package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadSave {
    
    public static final String SPRITES_PLAYER = "satyr-Sheet.png";
    public static final String SPRITES_ENVIRONMENT = "tileset.png";
    public static final String BACKGROUND_0 = "background_0.png";
    public static final String BACKGROUND_1 = "background_1.png";
    public static final String BACKGROUND_2 = "background_2.png";

    public static BufferedImage GetSpriteSheet(String file_name) {
        
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("res/"+file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return img;   
    } 

}

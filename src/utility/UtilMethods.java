package utility;

import main.Game;

public class UtilMethods {
    
    public static boolean CanMoveHere(float x, float y, int width, int height, int[][] collision_data) {

        // forgive me for my sins
        if (! IsSolid(x, y, collision_data)) {
            if (! IsSolid(x + width, y + height, collision_data)) {
                if (! IsSolid(x + width, y, collision_data)) {
                    if (! IsSolid(x, y + height, collision_data)) {
                        return true;
                    }
                }
            }  
        }
        return false;
    }

    private static boolean IsSolid(float x, float y, int[][] collision_data) {
        if (x < 0 || x >= Game.GAME_WIDTH) {
            return true;
        }
        if (y < 0 || y >= Game.GAME_HEIGHT) {
            return false;
        }

        float x_index = x / Game.TILES_SIZE;
        float y_index = y / Game.TILES_SIZE;

        int value = collision_data[((int) y_index)][(int) x_index];

        if (value == 1) {return true;}
        else {return false;} 
/* TO-DO: MAKE CHANGES:  0 = empty, 1 = solid, 2 = semi-solid, 3 = trap tile.  */

    }


}

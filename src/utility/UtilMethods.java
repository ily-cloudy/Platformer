package utility;

import java.awt.geom.Rectangle2D;

import main.Game;

public class UtilMethods {
    
    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] collision_data) {

        if (IsSolid(x, y, collision_data)) {return false;}
        if (IsSolid(x + width, y+ height, collision_data)) {return false;}
        if (IsSolid(x + width, y, collision_data)) {return false;}
        if (IsSolid(x, y + height, collision_data)) {return false;}
        
        return true;
        
    }

    private static boolean IsSolid(float x, float y, int[][] collision_data) {
        int max_width = collision_data[0].length * Game.TILES_SIZE;
        if (x < 0 || x >= max_width) {
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
 
    public static float GetEntityXPositionBySolid(Rectangle2D.Float hitbox, float x_speed) {

        int current_tile = (int)(hitbox.x / Game.TILES_SIZE);

        if (x_speed > 0) {
        // right
            int tile_x_pos = current_tile * Game.TILES_SIZE;
            int offset_x = (int)(Game.TILES_SIZE - hitbox.width);
            return tile_x_pos + offset_x - 1;
        }
        else {
        // left 
            return current_tile * Game.TILES_SIZE;
        }
    }

    public static float GetEntityYPositionBySolid(Rectangle2D.Float hitbox, float air_speed) {

        int current_tile = (int)(hitbox.y / Game.TILES_SIZE);

        if (air_speed > 0) {
            // falling to floor
            int tile_y_pos = current_tile * Game.TILES_SIZE;
            int offset_y = (int)(Game.TILES_SIZE - hitbox.height);
            return tile_y_pos + offset_y+16*Game.SCALE - 1;
        }
        else {
            // rising
            return current_tile * Game.TILES_SIZE;
        }
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] collision_data) {
		// Check the pixel below bottom left and bottom right
		if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, collision_data))
			if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, collision_data))
				return false;

		return true;

	}

}

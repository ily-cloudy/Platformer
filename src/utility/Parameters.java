package utility;

import main.Game;

// collection of parameters that can be modified to change the feel of the game

public class Parameters {

    // changes window size and game scale
    public static final float TILE_SIZE_MULTIPLIER = 3.0f; 

    public static final float GRAVITY = 0.04f * Game.SCALE;

    public static final float RUNNING_SPEED = 0.70f * Game.SCALE;
    
    public static final int ANI_SPEED = 12;

}

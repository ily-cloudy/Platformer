package main;

import java.awt.Graphics;

import environments.EnvData;

import gamestates.Gamestate;
import gamestates.*;

public class Game implements Runnable {

    private Window game_window;
    private Panel game_panel;
    private Thread game_thread;
    private final int FPS_SET = 60;
    private final int UPS_SET = 120;

    private Play play;
    private Menu menu;

    public final static int TILES_DEFAULT_SIZE = 16;
    public final static float SCALE = 3.0f;
    public final static int TILES_WIDTH = 26;
    public final static int TILES_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);

    public final static int GAME_WIDTH = TILES_SIZE * TILES_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_HEIGHT;

    // constuctor method; basically __init__() in py
    public Game() {
        initEntities();
        
        // making a bunch of objects. panel goes into window - thus panel is initialized first.
        game_panel = new Panel(this); 
        game_window = new Window(game_panel);
        // panel is needy and requires attention (this object gets input focus; necessary for inputs to function)
        game_panel.setFocusable(true);
        game_panel.requestFocus();
        // :pray:
        startGameLoop();
    }


    // TO-DO: rename to: initialize classes
    private void initEntities() {

        menu = new Menu(this);
        play = new Play(this);

    }

    // thread method oh no
    private void startGameLoop() {
        game_thread = new Thread(this);
        game_thread.start();
    }

    public void update() {
        switch (Gamestate.state) {
            case MENU:
                menu.update();
                break;
            case PLAY:
                play.update();
                break;
            default:
                break;
        }
    }

    public void render(Graphics g) {
        switch (Gamestate.state) {
            case MENU:
                menu.draw(g);
                break;
            case PLAY:
                play.draw(g);
                break;
            default:
                break;
        }

    }

    // game loop using runnable, i.e. setting a fixed fps. 
	@Override
	public void run() {

        // the duration of a frame is the inverse of fps, i.e., 1/fps.
        // additionally we multiply by 10 ** 9 to convert to ns
        // same for ups
		double frame_duration = 1000000000.0 / FPS_SET;
        double update_duration = 1000000000.0 / UPS_SET;

        long previous_time = System.nanoTime();

        // more params
		int frames = 0;
        int updates = 0; 
		long last_check = System.currentTimeMillis();

        double d_updates = 0;
        double d_frames = 0;

        // continously checks if the fixed frame duration has passed.
		while (true) {
            long current_time = System.nanoTime();

            // d_updates will be >= 1, when the duration since last update is over the 'fixed' update duration
            d_updates += (current_time - previous_time) / update_duration;
            d_frames += (current_time - previous_time) / frame_duration;
            previous_time = current_time;
        

            if (d_updates >= 1) {
                update();
                updates ++;
                d_updates --;
            }

            if (d_frames >= 1) {
                game_panel.repaint();
				d_frames --;
				frames ++;
            }

            // framerate counter
			if (System.currentTimeMillis() - last_check >= 1000) {
				last_check = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
                updates = 0;
			}
		}
	}

    public Menu getMenu() {
        return menu;
    }

    public Play getPlay() {
        return play;
    }


}
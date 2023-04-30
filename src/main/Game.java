package main;

public class Game implements Runnable {

    private Window game_window;
    private Panel game_panel;
    private Thread game_thread;
    private final int FPS_SET = 60;

    // constuctor method; basically __init__() in py
    public Game() {

        // making a bunch of objects. panel goes into window - thus panel is initialized first.
        game_panel = new Panel(); 
        game_window = new Window(game_panel);
        // panel is needy and requires attention (this object gets input focus; necessary for inputs to function)
        game_panel.requestFocus();
        // :pray:
        startGameLoop();

    }

    // thread method oh no
    private void startGameLoop() {
        game_thread = new Thread(this);
        game_thread.start();
    }

    // game loop using runnable, i.e. setting a fixed fps. 
	@Override
	public void run() {

        // the duration of a frame is the inverse of fps, i.e., 1/fps.
        // additionally we multiply by 10 ** 9 to convert to ns
		double frame_duration = 1000000000.0 / FPS_SET;
		long last_frame = System.nanoTime();
		long now = System.nanoTime();

        // more params
		int frames = 0;
		long last_check = System.currentTimeMillis();

        // continously checks if the fixed frame duration has passed.
		while (true) {
			now = System.nanoTime();
			if (now - last_frame >= frame_duration) {
				game_panel.repaint();
				last_frame = now;
				frames++;
			}

            // framerate counter
			if (System.currentTimeMillis() - last_check >= 1000) {
				last_check = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}

	}

}
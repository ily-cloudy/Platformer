package main;
public class Game {
    private Window game_window;
    private Panel game_panel;

    // constuctor method; basically __init__()
    public Game() {
        // making a bunch of objects yep. 'panel goes into window'; thus panel is initialized first.
        game_panel = new Panel(); 
        game_window = new Window(game_panel);
        
    }
}

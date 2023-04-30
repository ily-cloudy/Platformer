package main;

public class Game {
    private Window game_window;
    private Panel game_panel;

    // constuctor method; basically __init__() in py
    public Game() {
        // making a bunch of objects. panel goes into window - thus panel is initialized first.
        game_panel = new Panel(); 
        game_window = new Window(game_panel);
        // panel is needy and requires attention (this object gets input focus; necessary for inputs to function)
        game_panel.requestFocus();
        
    }
}

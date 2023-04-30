package main;

import javax.swing.JFrame;

public class Window {
    // creates frame using Jframe
    private JFrame frame; 

    // constructor method
    public Window(Panel game_panel) {
        // frame set-up
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // adds panel into window object 
        frame.add(game_panel);
        frame.setLocationRelativeTo(null);
        // WHY IS THIS SET TO FALSE BY DEFAULT??? T^T
        frame.setVisible(true);
    }
}

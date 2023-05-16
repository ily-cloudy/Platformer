package main;

import javax.swing.JFrame;

public class Window {
    private JFrame frame; 

    public Window(Panel game_panel) {
        // frame and window  set-up
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game_panel);
        // picks window dimensions that fit outside of the specified panel dimension
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        // WHY IS THIS SET TO FALSE BY DEFAULT??? T^T i am going insane
        frame.setVisible(true);
    }
}

import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        // GAME WINDOW
        //dimensions of window in pixel
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        //frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        //this setLocation will locate window in the center of the window
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //when user clicks on expnadof window, this setDefaultCloseOperation will terminate the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Instance of FlappyBird
        FlappyBird  flappyBird = new FlappyBird();
        frame.add(flappyBird);
        //this pack makes app's dimension as mentioned without including title bar
        frame.pack();
        flappyBird.requestFocus();
        frame.setVisible(true);

    }
}

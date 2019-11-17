package brickbreaker;

// Jay Bhagat
// August 10, 2018

// Importing the libraries needed
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        // Sets up the frame and allows it to open BrickBreaker.java
        JFrame frame = new JFrame("Brick Breaker");
        Container container = frame.getContentPane();
        BrickBreaker brickBreaker = new BrickBreaker();
        container.add(brickBreaker);
        brickBreaker.setVisible(true);
        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creates the game loop
        while (true) {
            // Calls the move method from the BrickBreaker class
            brickBreaker.move();
            // Erases the psat paint method and recalls it in the BrickBreaker class
            brickBreaker.repaint();
            // Adds a delay to see movement
            Thread.sleep(5);
            // Ends the program if the lives are less than 0
            if (brickBreaker.lives < 0) {
                brickBreaker.gameover = new JLabel("GAME OVER :(");
                brickBreaker.gameover.setForeground(Color.RED);
            }
        }
    }
}

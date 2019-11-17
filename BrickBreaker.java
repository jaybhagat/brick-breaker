package brickbreaker;

// Jay Bhagat
// August 12, 2018
// Brick Breaker - ______
// Importing the Libraries needed for the code
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrickBreaker extends JPanel implements MouseListener, MouseMotionListener {

private int ballX = 0;
private int ballY = 0;
private int increaseXBall = 2;
private int increaseYBall = 1;
private int rectXcoord = 50;
private int rectYcoord = 50;
private int mouseLocX = 0;
private int mouseLocY = 0;
final static int paddleHei = 10;
final static int paddleWid = 50;
private double interH = 0;
private double interW = 0;
public int lives = 2;
private int points = 0;
final static int brickHeight = 30;
final static int brickWidth = 100;
public JLabel gameover;

    // Sets the background colour and adds MouseMotionListener on whole screen
    public BrickBreaker() {
        setBackground(Color.BLACK);
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        // To override the paint method
        super.paint(g);
        // Ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 10, 10);
        Rectangle ballRect = new Rectangle(ballX, ballY, 10, 10);
        
        // Paddle
        g.setColor(new Color(211,211,211));
        Rectangle padRect = new Rectangle(mouseLocX - 25, 655, paddleWid, paddleHei);
        g.fillRect(mouseLocX - 25, 655, paddleWid, paddleHei);
        
        // Intersection between the ball and paddle
        Rectangle paddleInter = padRect.intersection(ballRect);
        
        // Getting dimensions of intersected rectangle
        interH = paddleInter.getHeight();
        interW = paddleInter.getWidth();
        
        Rectangle[][] brickDraw = new Rectangle[4][5];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                brickDraw[i][j] = new Rectangle(20 + 140*j,20 + 50*i, brickWidth, brickHeight);
            }
        }
        
        // Drawing of the bricks
        int[][] brX = new int[4][5];
        int[][] brY = new int[4][5];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                brX[i][j] = 20 + 140*j;
                brY[i][j] = 20 + 50*i;
            }
        }
        
        boolean[][] isHit = new boolean[4][5];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                isHit[i][j] = false;
            }
        }
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                    g.setColor(Color.RED);
                    g.fillRect(brX[i][j],brY[i][j],brickWidth,brickHeight);
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 5; j++) {
                Rectangle brickInter = brickDraw[i][j].intersection(ballRect);
                double brickInterY = brickInter.getHeight();
                double brickInterX = brickInter.getWidth();
                
                if(brickInterX > 1 && brickInterY == 1) {
                    isHit[i][j] = true;
                }
            }
        }
        
        for(int i = 0; i < 4; i++) {
            for(int j= 0; j < 5; j++) {
                if(isHit[i][j] == true) {
                    g.setColor(Color.BLACK);
                    g.fillRect(brX[i][j],brY[i][j],brickWidth,brickHeight);
                }
            }
        }
        
    }
    
    // The movementof the ball
    public void move() {
        ballX = ballX + increaseXBall;
        ballY = ballY + increaseYBall;
        if (ballX == 670 || ballX == 0) {
            changeXDirection();
        }
        
        if (interW > 1 && interH == 1 || ballY == 0) {
            changeYDirection();
        }
        
        if (ballY == 700) {
            ballY = 0;
            lives--;
        }
    }
    
    // Makes the addition to x-coordinate negative
    public void changeXDirection() {
        increaseXBall = -increaseXBall;
    }
    
    // Makes the addition to y-coordinate negative
    public void changeYDirection() {
        increaseYBall = -increaseYBall;
    }
    
    public void brickIntersection() {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseLocX = e.getX();
        mouseLocY = e.getY();
    }
    
}

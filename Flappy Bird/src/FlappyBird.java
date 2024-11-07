import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


//Designing Game's window
//these ActionListener,KeyListener are interfaces
public class FlappyBird extends JPanel implements ActionListener, KeyListener{
    int boardWidth = 360;
    int boardHeight = 640;

    
    //Bird
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;
    
    class Bird{
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;
        
        //Biird Constructor
        Bird(Image img){
            this.img = img;
        }
    }

    //Pipes
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe{
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        //this will check if our bird has passed the pipe or not
        boolean passes = false;

        //Pipe Constructor
        Pipe(Image img){
            this.img = img;
        }
    }

    //game logic
    //here we created a field Bird which we named as bird 
    Bird bird;
    int velocityX = -4;
    //velocityY is for bird as bird moves up and down 
    int velocityY = 0;
    int gravity = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    //game loop
    Timer gameLoop;
    Timer placePipesTimer;
    boolean gameOver = false;
    double score = 0;


    //Images
    Image backgrImage;
    Image birdImage;
    Image topPipeImg;
    Image bottomPipeImg;

    //Constructor
    FlappyBird(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        //setBackground(Color.blue);
        //setFocusable takes out key input
        setFocusable(true);
        addKeyListener(this);

        //load images
        backgrImage = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //Bird object
        bird = new Bird(birdImage);
        pipes = new ArrayList<Pipe>();

        //place pipe timer
        placePipesTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                placepipes();
            }
        });
        placePipesTimer.start();

        //game timer
        //here 1000/60 measn 60 frames per second and "this" means this flappy bird class
        gameLoop = new Timer(1900/60, this);
        gameLoop.start();
    }

    public void placepipes(){
        //every pipe is shifted 1/4 times upward from its original height
        //(0-1) * pipeHeight/2 => (0-1) * 512 => (0 -> 256)
        //pipeHeight?4 = 128, pipeY = 0
        //0-128 - (0 -> 256)
        //means range of top pipe wil be between pipeHeight/2 to 3/4 of toppipe
        int randomPipeY = (int)(pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        
        int openingSpace = boardHeight/4;

        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }
    public void paintComponent(Graphics g){
        //super refers to main class which is JPanel
        super.paintComponent(g);
        draw(g);

    }
    public void draw(Graphics g){
        // background
        //in this drawImage, this 0,0 is starting position and boardWidth,boardHeight is ending position of backgroung image
        g.drawImage(backgrImage, 0, 0, boardWidth, boardHeight,null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        //pipes
        for(int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        //score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if(gameOver){
            g.drawString("Game Over: " + String.valueOf((int) score), 10,35);
        } else{
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    //In this function we are updating x and y position of all our objects
    public void move(){
        //bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);

        //pipes
        for(int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;

            if(!pipe.passes && bird.x > pipe.x + pipe.width){
                pipe.passes = true;
                //becasue thee are 2 pipes in a set and when 1 set is passed then score is counted as 1
                score += 0.5;
                 
            }
            if(collision(bird, pipe)){
                gameOver = true;
            }
        }

        if(bird.y > boardHeight){
            gameOver = true;
        }

    }
    public boolean collision(Bird a, Pipe b){
        return a.x < b.x + b.width &&
               a.x + a.width > b.x &&
               a.y < b.y + b.height &&
               a.y + a.height > b.y;
    }
    

    //this is the action that will be performed every 60times a second
    @Override
    public void actionPerformed(ActionEvent e) {
        //move function will update position of bird
        move();
        //this will perform paintComponent function
        repaint();
        if(gameOver){
            placePipesTimer.stop();
            gameLoop.stop();
        }
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            velocityY = -10;
            if(gameOver){
                //restart game by reseting conditions
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipesTimer.start();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

//Ömer Faruk Çelik-2021400084-16.04.23-This code implements a bubble trouble game
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * the environment includes playing game and game constants
 * all classes are blended and combined here
 * it also calculates time difference using almost all classes and enables the object to move
 */
public class Environment {

    // Canvas constant
    // width of canvas
    public static final int CANVAS_WIDTH = 800;
    // height of canvas
    public static final int CANVAS_HEIGHT =500;
    //I use 1600 instead of 16 to make calculation easy
    //x_scale on the canvas
    public static final int X_SCALE = 1600;
    //I use -100 instead of -1 to make calculation easy
    //y_scale bar on the canvas
    public static final int Y_SCALE_BAR = -100;
    //I use 900 instead of 9 to make calculation easy
    //y_scale background on the canvas
    public static final int Y_SCALE_BACKGROUND = 900;

    //Environment constant
    // total game duration in millisecond
    public static final int TOTAL_GAME_DURATION = 40000;
    // pause duration
    public static final int PAUSE_DURATION= 1;

    //Player constant
    // height of the player
    public static final double HEIGHT_PLAYER = (Y_SCALE_BACKGROUND)/8.0;
    // width of the player
    public static final double WIDTH_PLAYER = HEIGHT_PLAYER*27.0/37.0;
    // period of the player in millisecond
    public static final int PERIOD_OF_PLAYER = 6000;

    //Arrow constant

    // period of the arrow in millisecond
    public static final int PERIOD_OF_ARROW = 1500;

    //Ball
    // period of the ball in millisecond
    public static final int PERIOD_OF_BALL = 15000;
    // the height multiplier with regard to different level ball
    public static final double HEIGHT_MULTIPLIER = 1.75;
    // the radius multiplier with regard to different level ball
    public static final double RADIUS_MULTIPLIER = 2;
    // 0 level ball's max height it can reach
    public static final double MIN_POSSIBLE_HEIGHT = HEIGHT_PLAYER*1.4;
    // 0 level ball's radius
    public static final double MIN_POSSIBLE_RADIUS = (Y_SCALE_BACKGROUND)*0.0175;
    // gravity
    public static final double GRAVITY = 0.0000003* (Y_SCALE_BACKGROUND);

    //Bar
    // I use -100 instead of -1 to make calculation easy
    // height of the bar
    public static final double HEIGHT_SCALE_TO_BAR = -100;
    // I use 50 instead of 0.5 to make calculation easy
    // height of time-bar
    public static final double TIME_SCALE_BAR = 50;

    // Game over
    public static boolean endGame = true;
    public static boolean againGame = true;
    public static boolean lastLoop = false;

    /**
     * no-arg constructor
     */
    Environment(){};

    /**
     * Sets canvas values and creates canvas
     */
    public void settingCanvas(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(Environment.CANVAS_WIDTH,Environment.CANVAS_HEIGHT);
        StdDraw.setXscale(0, Environment.X_SCALE);
        StdDraw.setYscale(Environment.Y_SCALE_BAR,Environment.Y_SCALE_BACKGROUND);
    }

    /**
     * Draws background
     */
    public void drawBackground(){
        StdDraw.picture(Environment.X_SCALE / 2.0, Environment.Y_SCALE_BACKGROUND / 2.0, "background.png", Environment.X_SCALE, Environment.Y_SCALE_BACKGROUND);
    }

    /**
     * draws endScreen when the game over
     * @param won won determines whether the player win the game
     */
    public void drawEndScreen(boolean won){
        // setting pen color black to change text's color
        StdDraw.setPenColor(StdDraw.BLACK);
        // draws game screen
        StdDraw.picture( Environment.X_SCALE/2.0,Environment.Y_SCALE_BACKGROUND/2.18,"game_screen.png",Environment.X_SCALE/3.8,Environment.Y_SCALE_BACKGROUND/4.0);
        // setting font for you won and game over text
        StdDraw.setFont(new Font("Helvetica",Font.BOLD,30));
        // if the player wins the game,it will display "YOU WON"
        if (won){
            StdDraw.text(Environment.X_SCALE/2.0,Environment.Y_SCALE_BACKGROUND/2.0,"YOU WON!");
        }
        // if the player don't win the game,it will display "GAME OVER"
        else{
            StdDraw.text(Environment.X_SCALE/2.0,Environment.Y_SCALE_BACKGROUND/2.0,"GAME OVER!");
        }
        // setting font for replay and quit text
        StdDraw.setFont(new Font("Helvetica",Font.ITALIC,15));
        // displaying after game overs, To Replay Click "Y"
        StdDraw.text(Environment.X_SCALE/2.0,Environment.Y_SCALE_BACKGROUND/2.3,"To Replay Click “Y”");
        // displaying after game overs, To Quit Click "N"
        StdDraw.text(Environment.X_SCALE/2.0,Environment.Y_SCALE_BACKGROUND/2.6,"To Quit Click “N”");
    }

    /**
     * it determines whether N key is pressed to replay game
     * @return true if N key is pressed
     */
    public boolean quitGame(){
        return StdDraw.isKeyPressed(KeyEvent.VK_N);
    }

    /**
     * it determines whether Y key is pressed to replay game
     * @return true if Y key is pressed
     */
    public boolean replayGame(){
        return StdDraw.isKeyPressed(KeyEvent.VK_Y);
    }

    /**
     * plays game
     * creates all objects
     * it uses methods written in other classes like drawing or moving to move and draw objects
     * it also determines after the game over,asks user to replay the game or quit the game
     */
    public void playGame(){
        //this while loop includes all game
        // because they are in the loop, to replay the game
        while (Environment.endGame) {
            // creates player object
            Player player = new Player(Environment.X_SCALE / 2.0);
            // creates bar object
            Bar bar = new Bar();
            // creates ball object arraylist
            ArrayList<Ball> balls = new ArrayList<Ball>();
            // creates initial balls
            Ball ball0 = new Ball(2, true, Environment.X_SCALE / 4.0, 50);
            Ball ball1 = new Ball(1, false, Environment.X_SCALE / 3.0, 50);
            Ball ball2 = new Ball(0, true, Environment.X_SCALE / 4.0, 50);
            // adding balls to arraylist
            balls.add(ball0);
            balls.add(ball1);
            balls.add(ball2);
            // creates arrow object
            Arrow arrow = new Arrow();
            // creates environment object
            Environment environment = new Environment();
            // creating and setting canvas method
            environment.settingCanvas();
            // drawing background method
            environment.drawBackground();
            // it determines start time before game starts
            double startTime = System.currentTimeMillis();
            // it will determine time difference each loop and will be used for the object to moves constantly
            double unitTime = System.currentTimeMillis();
            // it is about the replay game
            Environment.againGame = true;
            while (Environment.againGame) {
                // calculates the time for the time bar
                double timeBar = System.currentTimeMillis() - startTime;
                // clear the canvas for the motion
                StdDraw.clear();
                // draws background
                environment.drawBackground();
                // draws the bottom bar background
                bar.draw();
                // draws the time Bar
                bar.draw2(timeBar);
                // it calculates current time
                double inTime = System.currentTimeMillis();
                // it determines time difference
                double allTime = inTime - unitTime;
                // setting time current time
                unitTime = inTime;
                // draws the player
                player.draw();
                // moves the player
                player.move(allTime);
                // it iterates for the every balls
                for (int i = 0; i < balls.size(); i++) {
                    // if ball touches the player
                    if(balls.get(i).isTouchedPlayer(player.getX())){
                        // player's touched sets true
                        player.setTouched(true);
                        // it activates lastLoop which created for the End Game Screen
                        Environment.lastLoop = true;
                    }
                    // draws balls
                    balls.get(i).draw();
                    // moves balls
                    balls.get(i).move(allTime);
                    // if ball touches the arrow
                    if (arrow.isExist() &&balls.get(i).isTouchedArrow(arrow.getX0(),arrow.getArrowScale())) {
                        // sets arrow existing false to disappear arrow
                        arrow.setExist(false);
                        // sets arrow scale 0 to start new arrow 0 in y-scale
                        arrow.setArrowScale(0);
                        // it adds new balls to ball arraylists
                        for (int j = 0; j < balls.get(i).createNewBalls().size(); j++) {
                            balls.add(balls.get(i).createNewBalls().get(j));
                        }
                        // it deletes the ball hits the arrow
                        balls.remove(balls.get(i));
                        break;
                    }
                }
                // draws the arrow
                arrow.drawFrame(player.getX(), allTime);
                // show the canvas for the motion
                StdDraw.show();
                // if there is no ball it activates lastLoop which created for the End Game Screen
                if (balls.size() == 0){Environment.lastLoop = true;}
                // if time is over it activates lastLoop which created for the End Game Screen
                if (timeBar > 40000){Environment.lastLoop = true;}
                // loop for the end game screen
                while (Environment.lastLoop){
                    // for the losing draws end game screen
                    if (timeBar > 40000 || player.isTouched()) {
                        environment.drawBackground();
                        player.draw();
                        bar.draw2(timeBar);
                        environment.drawEndScreen(false);
                    }
                    // for the winning draws end game screen
                    else{
                        environment.drawBackground();
                        player.draw();
                        environment.drawEndScreen(true);
                    }
                    // if N is pressed close the canvas and quit the game
                    if (environment.quitGame()){
                        System.exit(0);
                    }
                    // if y is pressed replay the game
                    if (environment.replayGame()){
                        Environment.againGame = false;
                        Environment.lastLoop = false;
                        break;
                    }
                    StdDraw.show();
                }

            }
            // it sets pause duration in each loop
            StdDraw.pause(Environment.PAUSE_DURATION);
        }
    }






















}

//Ömer Faruk Çelik-2021400084-16.04.23-This code implements a bubble trouble game

import java.awt.event.KeyEvent;

/**
 * Player represents a player object in the game
 * Player can move right and left with constant speed until border of the game but cannot move upward or downward.
 * Player can shoot an arrow and if ball touches the player the game over
 *
 */
public class Player {
    // x coordinate of the player
    private double x;
    // x-axis speed of the player
    private double Vx;
    // it checks player is touched with the balls
    private boolean touched = false;

    /**
     * Constructors and initializes a Player object on the game
     * @param x x coordinate
     */
    public Player(double x) {
        this.x = x;
        this.Vx =(double)Environment.X_SCALE/Environment.PERIOD_OF_PLAYER;
    }

    /**
     * Draws the player on the canvas
     */
    public void draw(){

        StdDraw.picture(x,0+Environment.HEIGHT_PLAYER/2,"player_back.png",Environment.WIDTH_PLAYER,Environment.HEIGHT_PLAYER);
    }

    /**
     * changes the player coordinate on x-axis and moves the player with regard to pressed keys
     * if right key is pressed, the player moves the right
     * if left key is pressed, the player moves the left
     * @param time time is time difference each loop, so it can move with regard to time
     */
    public void move(double time){
        // if right key is pressed, the player moves the right with regard to x-axis speed and time
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) &&(x < Environment.X_SCALE-Environment.WIDTH_PLAYER/2)){
            x += Vx*time;
        }
        // if left key is pressed, the player moves the left with regard to x-axis speed and time
        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && (x > Environment.WIDTH_PLAYER/2)){
            x -= Vx*time;
        }

    }

    // Getter and Setter Methods

    public double getVx() {
        return Vx;
    }

    public void setVx(double vx) {
        Vx = vx;
    }

    public boolean isTouched() {
        return touched;
    }


    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}

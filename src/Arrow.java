//Ömer Faruk Çelik-2021400084-16.04.23-This code implements a bubble trouble game
import java.awt.event.KeyEvent;

/**
 * it creates an arrow object on the game
 * the player throw an arrow to pop balls
 * if the arrow hit the ball, it disappears, and the ball pops and creates two new ball whose level larger than 0
 * at the same time, just one arrow can be thrown
 * it goes upward on the player x-axis coordinate, but doesnot change its x-axis coordinate after that
 * it means, its x-axis coordinate depends on player coordinate, but when it is thrown, it doesn't depend on after that
 * the x-coordinate from which it was thrown remains constant
 */
public class Arrow {
    //its existing
    private boolean exist = false;
    //top of the arrow's y-axis coordinate
    private double arrowScale = 0;
    // it's x-axis coordinate
    private double x0;

    /**
     * no-arg constructor
     */
    Arrow() {
    }

    /**
     *
     * @param x x coordinate of the player, when space key is pressed
     * @param time time is time difference each loop, so it can move with regard to time
     */
    public void drawFrame(double x, double time) {
        // if there is no arrow in the game, when space key is pressed, an arrow occurs
        if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && arrowScale == 0){
            // it sets x coordinate of the arrow
            x0 = x;
            // it sets existing boolean true
            exist= true;
        }
        // if an arrow exist
        if (exist) {
            // the arrow is drawn in the screen, and moves until top of the screen
            if (arrowScale < Environment.Y_SCALE_BACKGROUND) {
                StdDraw.picture(x0, arrowScale / 2, "arrow.png",7.0/37*Environment.WIDTH_PLAYER ,arrowScale);
                arrowScale = arrowScale + (double) Environment.Y_SCALE_BACKGROUND / Environment.PERIOD_OF_ARROW * time;
                // if the arrow arrive top of the screen, it sets y-coordinate 0 and exist false
            } else {
                arrowScale = 0;
                exist = false;
            }
        }
    }
    // Getter and Setter method
    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public double getArrowScale() {
        return arrowScale;
    }

    public void setArrowScale(double arrowScale) {
        this.arrowScale = arrowScale;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }
}







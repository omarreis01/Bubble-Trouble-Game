//Ömer Faruk Çelik-2021400084-16.04.23-This code implements a bubble trouble game
/**
 * Bar represents a bar object in game at the bottom
 * it contains bar background and also time bar which gets shorter over time
 * it provides information how much time is left
 */
public class Bar {
    /**
     * Constructors and creates a Bar on the screen
     */
    Bar(){}

    /**
     * Draws the bar background the on the screen
     */
    public void draw(){
        StdDraw.picture(Environment.X_SCALE/2.0,Environment.HEIGHT_SCALE_TO_BAR/2.0,"bar.png",Environment.X_SCALE,-Environment.HEIGHT_SCALE_TO_BAR);
    }

    /**
     * Draws also a time bar
     * it gets short over time, which shows how much time is left on the game
     * it's color transforms from yellow to red with a constant speed
     * @param time time is time difference each loop, so it can move with regard to time
     */

    public void draw2(double time){
        if (time < 40000) {
            //while time is smaller than 40000, the bar's color transforms from yellow to red with a constant speed
            StdDraw.setPenColor(255, 255 - (int) ((time / (Environment.TOTAL_GAME_DURATION) * 255)), 0);
            // it's height gets smaller over time
            StdDraw.filledRectangle(Environment.X_SCALE / 2.0 - ((time / (Environment.TOTAL_GAME_DURATION) * Environment.X_SCALE / 2.0)), Environment.HEIGHT_SCALE_TO_BAR / 2.0, (Environment.X_SCALE / 2.0) - (time / (Environment.TOTAL_GAME_DURATION) * Environment.X_SCALE / 2.0), Environment.TIME_SCALE_BAR / 2.0);
        }
    }

}

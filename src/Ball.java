//Ömer Faruk Çelik-2021400084-16.04.23-This code implements a bubble trouble game
import java.util.ArrayList;

/**
 * Ball represents a ball object on the game
 * a ball makes projectile motion and when it comes to the borders it bounces
 * they have special speed on Y-scale with regard to its level
 * if there is no left ball, the user wins the game
 * if a ball touches the player object, the user loses the game
 * if it collides with arrow, the ball deletes, and it creates two new smaller ball with regard to its level
 */
public class Ball{
    // its level
    private int level;
    //its x-axis speed in 1 millisecond
    private double Vx;
    //its y-axis speed in 1 millisecond
    private double Vy;
    // its initial y-axis speed in 1 millisecond
    private double V0;
    // it determines which direction ball goes
    private boolean right;
    //its x-axis coordinate
    private double x;
    //center of ball's  y-axis coordinate
    private double y;
    //center of ball's  radius
    private double radius;

    /**
     * Constructors and intializes ball speed, radius, coordinates, level, and direction
     * Every level ball has different features
     * @param level
     * @param right
     * @param x
     * @param y
     */
    public Ball(int level,boolean right,double x,double y){
        // initializing its direction, level, x and y coordinates
        this.right = right;
        this.level = level;
        this.x = x;
        this.y = y;
        if (level == 2){
            // if its level 2 and moves to the right
            if (right) {
                // Vx is its x-axis speed, calculated with its period of ball it gives us to the speed in 1 millisecond on the x-axis
                this.Vx = ((double)Environment.X_SCALE / Environment.PERIOD_OF_BALL);
                // it initializes radius of the ball
                this.radius = Environment.MIN_POSSIBLE_RADIUS* Environment.RADIUS_MULTIPLIER*Environment.RADIUS_MULTIPLIER;
                // Vy is its y-axis speed, calculated with sqrt 2*g*h formula,knowing a ball's maximum height it can reach, the formula calculates its speed in 1 millisecond on the y-axis
                this.Vy = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER*Environment.HEIGHT_MULTIPLIER);
                // it equals Vy speed, but while Vy changes constantly, V0 doesn't change, it stores when the ball hits to the ground, its bounce speed
                this.V0 = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER*Environment.HEIGHT_MULTIPLIER);

            }
            // if its level 2 and moves to the left
            else{
                // Vx is its x-axis speed, calculated with its period of ball it gives us to the speed in 1 millisecond on the x-axis
                this.Vx = -((double)Environment.X_SCALE / Environment.PERIOD_OF_BALL);
                // it initializes radius of the ball
                this.radius = Environment.MIN_POSSIBLE_RADIUS* Environment.RADIUS_MULTIPLIER*Environment.RADIUS_MULTIPLIER;
                // Vy is its y-axis speed, calculated with sqrt 2*g*h formula,knowing a ball's maximum height it can reach, the formula calculates its speed in 1 millisecond on the y-axis
                this.Vy = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER*Environment.HEIGHT_MULTIPLIER);
                // it equals Vy speed, but while Vy changes constantly, V0 doesn't change, it stores when the ball hits to the ground, its bounce speed
                this.V0 = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER*Environment.HEIGHT_MULTIPLIER);

            }
        }
        if (level ==1){
            // if its level 1 and moves to the right
            if (right){
                // Vx is its x-axis speed, calculated with its period of ball it gives us to the speed in 1 millisecond on the x-axis
                this.Vx = ((double)Environment.X_SCALE / Environment.PERIOD_OF_BALL);
                // it initializes radius of the ball
                this.radius = Environment.MIN_POSSIBLE_RADIUS* Environment.RADIUS_MULTIPLIER;
                // Vy is its y-axis speed, calculated with sqrt 2*g*h formula,knowing a ball's maximum height it can reach, the formula calculates its speed in 1 millisecond on the y-axis
                this.Vy = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER);
                // it equals Vy speed, but while Vy changes constantly, V0 doesn't change, it stores when the ball hits to the ground, its bounce speed
                this.V0 =Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER);

            }
            // if its level 1 and moves to the left
            else{
                // Vx is its x-axis speed, calculated with its period of ball it gives us to the speed in 1 millisecond on the x-axis
                this.Vx =-((double)Environment.X_SCALE / Environment.PERIOD_OF_BALL);
                // it initializes radius of the ball
                this.radius = Environment.MIN_POSSIBLE_RADIUS* Environment.RADIUS_MULTIPLIER;
                // Vy is its y-axis speed, calculated with sqrt 2*g*h formula,knowing a ball's maximum height it can reach, the formula calculates its speed in 1 millisecond on the y-axis
                this.Vy = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER);
                // it equals Vy speed, but while Vy changes constantly, V0 doesn't change, it stores when the ball hits to the ground, its bounce speed
                this.V0 =Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT*Environment.HEIGHT_MULTIPLIER);

            }
        }
        if (level == 0){
            // if its level 0 and moves to the right
            if (right){
                // Vx is its x-axis speed, calculated with its period of ball it gives us to the speed in 1 millisecond on the x-axis
                this.Vx = ((double)Environment.X_SCALE / Environment.PERIOD_OF_BALL);
                // it initializes radius of the ball
                this.radius = Environment.MIN_POSSIBLE_RADIUS;
                // Vy is its y-axis speed, calculated with sqrt 2*g*h formula,knowing a ball's maximum height it can reach, the formula calculates its speed in 1 millisecond on the y-axis
                this.Vy = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT);
                // it equals Vy speed, but while Vy changes constantly, V0 doesn't change, it stores when the ball hits to the ground, its bounce speed
                this.V0 =Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT);
            }
            // if its level 0 and moves to the left
            else {
                // Vx is its x-axis speed, calculated with its period of ball it gives us to the speed in 1 millisecond on the x-axis
                this.Vx = -((double)Environment.X_SCALE / Environment.PERIOD_OF_BALL);
                // it initializes radius of the ball
                this.radius = Environment.MIN_POSSIBLE_RADIUS;
                // Vy is its y-axis speed, calculated with sqrt 2*g*h formula,knowing a ball's maximum height it can reach, the formula calculates its speed in 1 millisecond on the y-axis
                this.Vy = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT);
                // it equals Vy speed, but while Vy changes constantly, V0 doesn't change, it stores when the ball hits to the ground, its bounce speed
                this.V0 = Math.sqrt(2*Environment.GRAVITY*Environment.MIN_POSSIBLE_HEIGHT);
            }

        }
    }

    /**
     * draws the ball on the screen
     */
    public void draw(){
        StdDraw.picture(x,y,"ball.png",radius*2,radius*2);
    }

    /**
     * it changes X coordinate with regard to Vx speed and time
     * it changes Y coordinate with regard to Vy speed and time
     * it changes Vy speed with regard to Gravity and time
     * if it comes to the borders it bounces in the opposite direction,and replaces the speed with the opposite sign
     * @param time time is time difference each loop, so it can move with regard to time
     */
    public void move(double time){
        // if ball touches the ground it sets the y-axis speed to beginning speed, so it bounces
        if (y < radius){
            Vy = V0;
        }
        // if ball touches the right-side, it changes the x-axis speed on the opposite sign, which means it starts going to opposite direction, so it bounces
        if (x < radius && !right){
            Vx = -Vx;
            right = true;
        }
        // if ball touches the left-side, it changes the x-axis speed on the opposite sign, which means it starts going to opposite direction, so it bounces
        if ( x > Environment.X_SCALE-radius && right){
            Vx = -Vx;
            right = false;
        }
        // each time its y-axis speed decreases with regard to gravity
        Vy -= Environment.GRAVITY*time;
        // it changes the x-axis coordinates with regard to x-axis speed
        x+= Vx*time;
        // it changes the y-axis coordinates with regard to x-axis speed
        y += Vy*time;
    }

    /**
     * it checks whether the ball touches the arrow
     * it checks whether the ball coordinates which includes the all coordinates on the screen not just center overlap the arrow coordinates which includes the all coordinates on the screen not just center
     * @param arrowX arrowX is X coordinates of arrow
     * @param arrowY arrowY is Y coordinates of arrow
     * @return true if collide occurs
     */
    public boolean isTouchedArrow(double arrowX, double arrowY){
        // if arrow collides with ball on the bottom of the ball it checks their coordinates overlap
        if (y-arrowY>0&& y-arrowY<radius && Math.abs(x-arrowX) <= radius ){
            double tempY = Math.sqrt((radius*radius)-(Math.pow(x-arrowX,2)));
            if (Math.abs(y-arrowY) <= tempY){
                return true;
            }
        }
        // if arrow's height is larger than ball y-axis coordinate it checks their coordinates overlap
        if (arrowY > y && Math.abs(x-arrowX) <= radius) {
            if ((Vx > 0 && x+radius > arrowX) || (Vx <0 && x-radius < arrowX)){
                return true;
            }
        }
        return false;
    }

    /**
     * it checks whether the ball touches the player
     * it checks whether the ball coordinates which includes the all coordinates on the screen not just center overlap the player coordinates which includes the all coordinates on the screen not just center
     * @param playerX playerX is X coordinates of the player
     * @return true if collide occurs
     */
    public boolean isTouchedPlayer(double playerX){
        // it checks whether the ball collides with the player on the top side
        if (x > playerX-Environment.WIDTH_PLAYER/2.0 && x < playerX+Environment.WIDTH_PLAYER/2.0&& y-radius <Environment.HEIGHT_PLAYER){
            return true;
            // it checks whether the ball collides with the player on the right side
        }
        if(Vx> 0&& x + radius >playerX-Environment.WIDTH_PLAYER/2.0 && x-radius <playerX+Environment.WIDTH_PLAYER/2.0&& y <Environment.HEIGHT_PLAYER){
            return true;
            // it checks whether the ball collides with the player on the left side
        }
        if (Vx < 0 && x-radius <playerX+Environment.WIDTH_PLAYER/2.0 && x + radius >playerX-Environment.WIDTH_PLAYER/2.0&& y <Environment.HEIGHT_PLAYER){
            return true;
            // it checks whether the ball collides with the player on the corner sides
        }
        if (Math.sqrt(Math.pow(x-playerX,2))+Math.pow(y-Environment.WIDTH_PLAYER,2) < radius){
            return true;
        }
        // if all of them above don't occur it returns false
        return false;
    }

    /**
     * it creates arraylist including two balls
     * the balls created with same current level with the current ball
     * the balls created with a level that one less than the current ball
     * one of them moves to the right, one of them moves to the left with specialize with true and false
     * @return balls is arraylist of ball including two balls
     */
    public ArrayList<Ball> createNewBalls(){
        // creating an empty list taking balls object, which will store the balls
        ArrayList<Ball> balls = new ArrayList<>();
        // if balls' level is higher than 0, it creates new two balls and add them arraylist created before
        if (level > 0) {
            // it creates new two ball one less level than current ball, and one of them goes to right, the other goes to left
            Ball ball3 = new Ball(level - 1, true, x, y);
            Ball ball4 = new Ball(level - 1, false, x, y);
            // adding new balls to balls arraylist
            balls.add(ball3);
            balls.add(ball4);
            // returning arraylist
            return balls;
        }
        return balls;
    }

    //Getter and Setter methods

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getVx() {
        return Vx;
    }

    public void setVx(double vx) {
        Vx = vx;
    }

    public double getVy() {
        return Vy;
    }

    public void setVy(double vy) {
        Vy = vy;
    }

    public double getV0() {
        return V0;
    }

    public void setV0(double v0) {
        V0 = v0;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
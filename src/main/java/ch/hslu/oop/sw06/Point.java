
/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date) asdfasfd
 */
public class Point
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Point
     * @param x the x value
     * @param y the y value
     */
    public Point(final int x, final int y)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructor for objects of class Point using an existing point
     * @param point An existing point
     */
    public Point(Point point){
        this(point.getX(), point.getY());
    }
    
    public int getQuadrant()
    {
        if(this.getX() == 0 || this.getY() == 0){
            return 0;
        }
        if(this.getX() < 0){
            if(this.getY() < 0){
                return 3;
            }
            
            return 2;
        }
        else{
            if (this.getY() > 0){
                return 1;
            }
            
            return 4;
        }
    } 
    
    /*
    * Moves the point relative to the current point using absolute coordinates.
    */
    public void moveRelative(final int x, final int y){
        this.x = this.getX() + x;
        this.y = this.getY() + y;
    }
    
    /*
    * Moves the point relative to the current point using another point.
    */
    public void moveRelative(final Point point){
        this.moveRelative(point.getX(), point.getY());
    }
    
    public void moveWithPolarCoordinates(final int value, final double angle){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
    * @return the x
    */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    /*
    * Sets the new x vector on this point
    */
    public void setX(final int x){
        this.x = x;
    }
    
    /*
    * Sets the new y vector on this point
    */
    public void setY(final int y){
        this.y = y;
    }
}

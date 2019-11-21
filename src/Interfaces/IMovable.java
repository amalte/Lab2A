package Interfaces;

public interface IMovable {
    /**
     * Possible directions for object
     */
    enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    /**
     * Makes object move in current direction
     */
    void move();

    /**
     * Makes object turn left depending on current direction
     */
    void turnLeft();

    /**
     * Makes object turn right depending on current direction
     */
    void turnRight();

    double getX();
    void setX(double x);
    double getY();
    void setY(double y);
}